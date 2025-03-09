
package dao;

import services.Utilitarios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Biblioteca;
import model.EmprestimoLivro;
import model.Livro;
import model.Pessoa;

public class EmprestimoLivroDao {
    
    private final LogsDao logsDao = new LogsDao();
    private final Utilitarios converteData = new Utilitarios();
    private Connection conexao = null;
    private PreparedStatement selectStmt = null;
    private PreparedStatement insertStmt = null;
    private PreparedStatement updateStmt = null;
    private ResultSet rs = null;
    
    public void emprestarLivros(EmprestimoLivro livrosEmprestados){
 
        String inserDadosEmprestimo = "INSERT INTO Emprestimo(Pessoa,Biblioteca,Data) VALUES(?,?,GETDATE())";
 
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso
                                 
            //Pega os dados da Pessoa e da Biblioteca, e insere na tabela EmprestimoLivros
            insertStmt = this.conexao.prepareStatement(inserDadosEmprestimo, PreparedStatement.RETURN_GENERATED_KEYS); 
            insertStmt.setInt(1, livrosEmprestados.getPessoa().getCodigo());
            insertStmt.setInt(2, livrosEmprestados.getBiblioteca().getCodigo());
            insertStmt.executeUpdate();                              
            ResultSet generatedKeysEmp = insertStmt.getGeneratedKeys();

            if(generatedKeysEmp.next()){          
                //Adiciona o livro para emprestimo
                adicionarLivroEmprestado(livrosEmprestados.getListaLivro(),generatedKeysEmp,livrosEmprestados);     
                JOptionPane.showMessageDialog(null, "Empréstimo do livro efetuado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Chave do empréstimo não foi gerada", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
            this.conexao.commit(); 
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    logsDao.gravaLogsErro("EmprestimoLivroDao - "+e.getSQLState()+" - "+e.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o empréstimo", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(this.updateStmt != null) this.updateStmt.close();
                if(this.insertStmt != null) this.insertStmt.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }  
        
    private void adicionarLivroEmprestado(List<Livro> livros, ResultSet generatedKeysEmp, EmprestimoLivro livrosEmprestados){     
        
        String insertLivrosEmprestados = "INSERT INTO LivrosEmprestados (Livro,CodEmprestimo,StatusEmprestimo,DescricaoStatus,DataEmprestimo)VALUES (?,?,?,?,?)";
        String insertRegistroSaida = "INSERT INTO RegistroSaidaEntradaLivro (CodEmprestimo,CodLivroEmprestados,TipoMovimentacao,DataMovimentacao)VALUES (?,?,'SAÍDA - EMPRÉSTIMO',GETDATE())";
        String sqlUpdate = "UPDATE RegistroBiblioteca SET Quantidade = Quantidade - 1 WHERE Livro=? AND Biblioteca=?";
                   
        try{
            //int idRegistroEmprestimo = ;         
            int codEmprestimo = generatedKeysEmp.getInt(1);
                    
            for(Livro empLivro : livros){                  
                //Salvando os livros que foram emprestado    
                insertStmt = this.conexao.prepareStatement(insertLivrosEmprestados, PreparedStatement.RETURN_GENERATED_KEYS); 
                insertStmt.setInt(1, empLivro.getCodInterno());
                insertStmt.setInt(2, codEmprestimo);
                insertStmt.setString(3, livrosEmprestados.getStatusEmprestimo());
                insertStmt.setString(4, livrosEmprestados.getDescricaoStatus());
                insertStmt.setDate(5, (Date) livrosEmprestados.getDataEmprestimo());
                insertStmt.executeUpdate();   
                ResultSet generatedKeysLiv = insertStmt.getGeneratedKeys();
                
                if(generatedKeysLiv.next()){ 
                    int keyLivroEmp = generatedKeysLiv.getInt(1); 
                    //Atualiza o saldo do livro na biblioteca
                    atualizarSaldoLivro(sqlUpdate, empLivro, livrosEmprestados.getBiblioteca());

                    if(keyLivroEmp > 0){                  
                        //Registra a movimentação do livro
                        registrarEntradaSaidaLivro(insertRegistroSaida, codEmprestimo, keyLivroEmp);
                    }else{
                        JOptionPane.showMessageDialog(null, "Não foi gerada a chave para o livro" + empLivro.getCodInterno(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }                           
                }else{
                    JOptionPane.showMessageDialog(null, "Não foi gerada a chave para o empréstimo.", "Erro", JOptionPane.ERROR_MESSAGE);                                 
                }          
            }         
        }catch(SQLException ex){
            logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar registrar o empréstimo do livro", "Erro 007", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    private void atualizarSaldoLivro(String script, Livro livros, Biblioteca bibliteca){
        try{           
            //Atualizando o saldo do livro que foi emprestado
            this.updateStmt = this.conexao.prepareStatement(script); 
            this.updateStmt.setInt(1, livros.getCodInterno());
            this.updateStmt.setInt(2, bibliteca.getCodigo());
            this.updateStmt.executeUpdate();            
        }catch(SQLException ex){
            logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o saldo do livro", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void registrarEntradaSaidaLivro(String script, int idEmprestimo, int idLivroEmprestado){ 
        try{ 
            this.insertStmt = this.conexao.prepareStatement(script);
            this.insertStmt.setInt(1, idEmprestimo);
            this.insertStmt.setInt(2, idLivroEmprestado);
            this.insertStmt.execute(); 
        }catch(SQLException ex){
            logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o empréstimo", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void devolverLivroEmprestado(List<EmprestimoLivro> livrosDevolvido){
        
        String sqlInsert = "INSERT INTO RegistroSaidaEntradaLivro (CodEmprestimo,CodLivroEmprestados,TipoMovimentacao,DataMovimentacao)VALUES (?,?,'ENTRADA - DEVOLUÇÃO',GETDATE())";      
        String sqlUpdate = "UPDATE LivrosEmprestados SET StatusEmprestimo = 'D', DescricaoStatus = 'Devolvido', DataDevolucao = ? OUTPUT INSERTED.Codigo, INSERTED.CodEmprestimo WHERE CodEmprestimo = ? AND Livro = ? AND Codigo = ?";
        String sqlUpdate2 = "UPDATE RegistroBiblioteca SET Quantidade = Quantidade + 1 WHERE Livro = ? AND Biblioteca = ?";

        try{
            this.conexao = Conexao.getDataSource().getConnection();
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso
       
            for(EmprestimoLivro devLivro : livrosDevolvido){               
                this.updateStmt = conexao.prepareStatement(sqlUpdate); 
    
                this.updateStmt.setDate(1, (Date) devLivro.getDataDevolucao());
                this.updateStmt.setInt(2, devLivro.getCodigoEmprestimo());
                this.updateStmt.setInt(3, devLivro.getListaLivro().get(0).getCodInterno());
                this.updateStmt.setInt(4, devLivro.getCodigoInternoEmprestimo());
                this.rs = this.updateStmt.executeQuery(); 
                
                if (this.rs.next()) {
                    int codigo = this.rs.getInt("Codigo");
                    int codEmprestimo = this.rs.getInt("CodEmprestimo");

                    // Atualizar a quantidade de livros da biblioteca
                    atualizarSaldoLivro(sqlUpdate2, devLivro.getListaLivro().get(0), devLivro.getBiblioteca());
                    registrarEntradaSaidaLivro(sqlInsert, codEmprestimo, codigo);
                    
                    JOptionPane.showMessageDialog(null, "Devolução efetuada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar a devolução", "Erro", JOptionPane.ERROR_MESSAGE); 
                }
            }
            this.conexao.commit();        
        }catch(SQLException ex){
            logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar a devolução", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if(this.rs != null) this.rs.close();
                if(this.updateStmt != null) this.updateStmt.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    public List<EmprestimoLivro> consultarEmprestimosLivro(EmprestimoLivro filtroEmpLivro, java.util.Date dataEmprestimoInicial, java.util.Date dataEmprestimoFinal, java.util.Date dataDevolucaoInicial, java.util.Date dataDevolucaoFinal){
        
        List<EmprestimoLivro> listaEmpLivro = new ArrayList<>();
        
        String sql = "SELECT EMP.Codigo AS CodigoEmprestimo, B.Codigo AS CodBiblioteca, B.NomeBiblioteca AS NomeBiblioteca, P.Codigo AS CodPessoa, P.Nome AS NomePessoa, " +
            "LV.Codigo AS CodInternoLivro, LV.CodLivro AS CodLivro, LV.Nome AS NomeLivro, LV.Volume AS VolumeLivro, " +
            "LE.Codigo As CodInternoLivroEmprestado, LE.StatusEmprestimo AS StatusEmprestimo, LE.DescricaoStatus AS DescricaoStatus, LE.DataEmprestimo AS DataEmprestimo, LE.DataDevolucao AS DataDevolucao " +
            "FROM Emprestimo AS EMP " +
            "INNER JOIN LivrosEmprestados LE ON LE.CodEmprestimo = EMP.Codigo " +
            "INNER JOIN Pessoas P ON EMP.Pessoa = P.Codigo " +
            "INNER JOIN Livros LV ON LE.Livro = LV.Codigo " +
            "INNER JOIN Bibliotecas AS B ON B.Codigo = EMP.Biblioteca " +
            "WHERE (? IS NULL OR LE.DataEmprestimo BETWEEN ? AND ?) " +
            "AND (? IS NULL OR LE.DataDevolucao BETWEEN ? AND ?) " +
            "AND (? IS NULL OR LE.Livro = ?) " +
            "AND (? IS NULL OR EMP.Pessoa = ?) " +
            "AND (? IS NULL OR LE.StatusEmprestimo = ?) " +
            "AND (? IS NULL OR EMP.Biblioteca = ?)";

        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.selectStmt = this.conexao.prepareStatement(sql);  
            
            // Datas Emprestimo
            if (dataEmprestimoInicial != null && dataEmprestimoFinal != null) {
                this.selectStmt.setDate(1, new java.sql.Date(dataEmprestimoInicial.getTime()));
                this.selectStmt.setDate(2, new java.sql.Date(dataEmprestimoInicial.getTime()));
                this.selectStmt.setDate(3, new java.sql.Date(dataEmprestimoFinal.getTime()));
            } else {
                this.selectStmt.setNull(1, java.sql.Types.DATE);
                this.selectStmt.setNull(2, java.sql.Types.DATE);
                this.selectStmt.setNull(3, java.sql.Types.DATE);
            }
            
            //Datas Devolução
            if (dataDevolucaoInicial != null && dataDevolucaoFinal != null) {
                this.selectStmt.setDate(4, new java.sql.Date(dataDevolucaoInicial.getTime()));
                this.selectStmt.setDate(5, new java.sql.Date(dataDevolucaoInicial.getTime()));
                this.selectStmt.setDate(6, new java.sql.Date(dataDevolucaoFinal.getTime()));
            } else {
                this.selectStmt.setNull(4, java.sql.Types.DATE);
                this.selectStmt.setNull(5, java.sql.Types.DATE);
                this.selectStmt.setNull(6, java.sql.Types.DATE);
            }
                       
            // Parâmetro para livro
            if (filtroEmpLivro.getLivro() != null) {
                this.selectStmt.setInt(7, filtroEmpLivro.getLivro().getCodInterno());
                this.selectStmt.setInt(8, filtroEmpLivro.getLivro().getCodInterno());
            } else {
                this.selectStmt.setNull(7, java.sql.Types.INTEGER);
                this.selectStmt.setNull(8, java.sql.Types.INTEGER);
            }

            // Parâmetro para pessoa
            if (filtroEmpLivro.getPessoa().getCodigo() != null) {
                this.selectStmt.setInt(9, filtroEmpLivro.getPessoa().getCodigo());
                this.selectStmt.setInt(10, filtroEmpLivro.getPessoa().getCodigo());
            } else {
                this.selectStmt.setNull(9, java.sql.Types.INTEGER);
                this.selectStmt.setNull(10, java.sql.Types.INTEGER);
            }

            // Parâmetro para status
            if (filtroEmpLivro.getStatusEmprestimo()!= null) {
                this.selectStmt.setString(11, filtroEmpLivro.getStatusEmprestimo());
                this.selectStmt.setString(12, filtroEmpLivro.getStatusEmprestimo());
            } else {
                this.selectStmt.setNull(11, java.sql.Types.INTEGER);
                this.selectStmt.setNull(12, java.sql.Types.INTEGER);
            }
            
            // Parâmetro para igreja
            if (filtroEmpLivro.getBiblioteca() != null) {
                this.selectStmt.setInt(13, filtroEmpLivro.getBiblioteca().getCodigo());
                this.selectStmt.setInt(14, filtroEmpLivro.getBiblioteca().getCodigo());
            } else {
                this.selectStmt.setNull(13, java.sql.Types.INTEGER);
                this.selectStmt.setNull(14, java.sql.Types.INTEGER);
            }
            
            // Executando a consulta
            this.rs = this.selectStmt.executeQuery();

            // Iterando sobre os resultados
            while (this.rs.next()) {
                Pessoa pessoa = new Pessoa();
                EmprestimoLivro empLivro = new EmprestimoLivro();
                Livro livro = new Livro();
                List<Livro> listaLivro = new ArrayList();
                Biblioteca biblioteca = new Biblioteca();                
                pessoa.setCodigo(rs.getInt("CodPessoa"));
                pessoa.setNome(rs.getString("NomePessoa"));
                livro.setCodInterno(rs.getInt("CodInternoLivro"));
                livro.setCodLivro(rs.getInt("CodLivro"));
                livro.setNomeLivro(rs.getString("NomeLivro"));
                livro.setVolume(rs.getInt("VolumeLivro"));
                listaLivro.add(livro);
                empLivro.setCodigoInternoEmprestimo(rs.getInt("CodInternoLivroEmprestado"));
                empLivro.setCodigoEmprestimo(rs.getInt("CodigoEmprestimo"));
                empLivro.setStatusEmprestimo(rs.getString("StatusEmprestimo"));
                empLivro.setDescricaoStatus(rs.getString("DescricaoStatus"));
                empLivro.setDataEmprestimo(rs.getDate("DataEmprestimo"));
                empLivro.setDataDevolucao(rs.getDate("DataDevolucao"));
                biblioteca.setCodigo(rs.getInt("CodBiblioteca"));
                biblioteca.setNomeBiblioteca(rs.getString("NomeBiblioteca"));
                empLivro.setBiblioteca(biblioteca);
                empLivro.setPessoa(pessoa);
                empLivro.setListaLivro(listaLivro);

                listaEmpLivro.add(empLivro);
            }
        } catch (SQLException ex) {
            logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os empréstimos dos livros", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fechando recursos
            try {
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
        return listaEmpLivro;
    }
    
    //Consulta que aparece todos os livros emprestados, quando abrir a tela;
    public List<EmprestimoLivro> consultarEmprestimosStatusEmprestado(){
        
        List<EmprestimoLivro> listaEmpLivro = new ArrayList<>();
        
        // Montando a query SQL com placeholders
        String sqlSelect = "SELECT EMP.Codigo AS CodigoEmprestimo, B.Codigo AS CodBiblioteca, B.NomeBiblioteca AS NomeBiblioteca, P.Codigo AS CodPessoa, P.Nome AS NomePessoa, " +
            "LV.Codigo AS CodInternoLivro, LV.CodLivro AS CodLivro, LV.Nome AS NomeLivro, LV.Volume AS VolumeLivro, " +
            "LE.Codigo As CodInternoLivroEmprestado, LE.StatusEmprestimo AS StatusEmprestimo, LE.DescricaoStatus AS DescricaoStatus, LE.DataEmprestimo AS DataEmprestimo, LE.DataDevolucao AS DataDevolucao " +
            "FROM Emprestimo AS EMP " +
            "INNER JOIN LivrosEmprestados LE ON EMP.Codigo = LE.CodEmprestimo " +
            "INNER JOIN Pessoas P ON EMP.Pessoa = P.Codigo " +
            "INNER JOIN Livros LV ON LE.Livro = LV.Codigo " +
            "INNER JOIN Bibliotecas AS B ON B.Codigo = EMP.Biblioteca " +
            "WHERE LE.StatusEmprestimo = 'E' AND LE.DataDevolucao IS NULL";

        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.selectStmt = this.conexao.prepareStatement(sqlSelect);  
            this.rs = this.selectStmt.executeQuery();

            // Iterando sobre os resultados
            while (this.rs.next()) {
                Pessoa pessoa = new Pessoa();
                EmprestimoLivro empLivro = new EmprestimoLivro();
                Livro livro = new Livro();
                List<Livro> listaLivro = new ArrayList<>();
                Biblioteca biblioteca = new Biblioteca();
                
                pessoa.setCodigo(this.rs.getInt("CodPessoa"));
                pessoa.setNome(this.rs.getString("NomePessoa"));
                livro.setCodInterno(this.rs.getInt("CodInternoLivro"));
                livro.setCodLivro(this.rs.getInt("CodLivro"));
                livro.setNomeLivro(this.rs.getString("NomeLivro"));
                livro.setVolume(this.rs.getInt("VolumeLivro"));
                empLivro.setCodigoInternoEmprestimo(this.rs.getInt("CodInternoLivroEmprestado"));
                empLivro.setCodigoEmprestimo(this.rs.getInt("CodigoEmprestimo"));
                empLivro.setStatusEmprestimo(this.rs.getString("StatusEmprestimo"));
                empLivro.setDescricaoStatus(this.rs.getString("DescricaoStatus"));
                empLivro.setDataEmprestimo(this.rs.getDate("DataEmprestimo"));
                empLivro.setDataDevolucao(this.rs.getDate("DataDevolucao"));
                biblioteca.setCodigo(this.rs.getInt("CodBiblioteca"));
                biblioteca.setNomeBiblioteca(this.rs.getString("NomeBiblioteca"));
                listaLivro.add(livro);
                empLivro.setBiblioteca(biblioteca);
                empLivro.setPessoa(pessoa);
                empLivro.setListaLivro(listaLivro);

                listaEmpLivro.add(empLivro);
            }

        } catch (SQLException ex) {
            logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar todos os livros emprestados", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fechando recursos
            try {
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
        return listaEmpLivro;
    }
    
    public boolean validarEmprestimoPessoa(Livro livro, Integer codPessoa){
        boolean livroEncontrado = false;
        // Montando a query SQL com placeholders
        String sql = "SELECT * " +
            "FROM Emprestimo AS EMP " +
            "INNER JOIN LivrosEmprestados AS LE ON LE.CodEmprestimo = EMP.Codigo " +
            "WHERE EMP.Pessoa = ? AND LE.Livro = ? AND LE.StatusEmprestimo = 1 AND DataDevolucao IS NULL";

        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.selectStmt = this.conexao.prepareStatement(sql);  
            
            this.selectStmt.setInt(1, codPessoa);
            this.selectStmt.setInt(2, livro.getCodInterno());        
            this.rs = this.selectStmt.executeQuery();

            if(this.rs.next()) {
                livroEncontrado = true;
            }
        } catch (SQLException ex) {
            logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o empréstimo do livro", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fechando recursos
            try {
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("EmprestimoLivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
     return livroEncontrado;
    }
    
}
