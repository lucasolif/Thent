
package dao;

import ferramentas.Utilitarios;
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
    
    private final Utilitarios converteData = new Utilitarios();
    private Connection conexao = null;
    private PreparedStatement selectStmt = null;
    private PreparedStatement insertStmt = null;
    private PreparedStatement updateStmt = null;
    private ResultSet rs = null;
    
    public void emprestarLivros(EmprestimoLivro livrosEmprestados){
 
        String inserDadosEmprestimo = "INSERT INTO Emprestimo(Pessoa,Biblioteca,Data) VALUES(?,?,GETDATE())";
        List<Livro> livrosDisponiveis = livrosDisponiveisParaEmprestimo(livrosEmprestados);
 
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            //verfica se a lista de livros disponiveis não é vazia
            if(!livrosDisponiveis.isEmpty()){                          
                //Pega os dados da Pessoa e da Biblioteca, e insere na tabela EmprestimoLivros
                insertStmt = this.conexao.prepareStatement(inserDadosEmprestimo, PreparedStatement.RETURN_GENERATED_KEYS); 
                insertStmt.setInt(1, livrosEmprestados.getPessoa().getCodigo());
                insertStmt.setInt(2, livrosEmprestados.getBiblioteca().getCodigo());
                insertStmt.executeUpdate();                              
                ResultSet generatedKeysEmp = insertStmt.getGeneratedKeys();
                
                if(generatedKeysEmp.next()){          
                    //Adiciona o livro para emprestimo
                    adicionarLivroEmprestado(livrosDisponiveis,generatedKeysEmp,livrosEmprestados);     
                    JOptionPane.showMessageDialog(null, "Empréstimo do livro efetuado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Chave do empréstimo não foi gerada", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }
                this.conexao.commit(); 
            }
        }catch(SQLException ex){
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
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
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }  
        
    private void adicionarLivroEmprestado(List<Livro> livros, ResultSet generatedKeysEmp, EmprestimoLivro livrosEmprestados){     
        
        String insertLivrosEmprestados = "INSERT INTO LivrosEmprestados (Livro,CodEmprestimo,StatusEmprestimo,DataEmprestimo)VALUES (?,?,?,?)";
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
                insertStmt.setInt(3, livrosEmprestados.getStatusEmprestimo());
                insertStmt.setDate(4, (Date) livrosEmprestados.getDataEmprestimo());
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
                        JOptionPane.showMessageDialog(null, "Não foi gerada a chave para o livro com o código " + empLivro.getCodInterno(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }                           
                }else{
                    JOptionPane.showMessageDialog(null, "Não foi gerada a chave para o empréstimo.", "Erro", JOptionPane.ERROR_MESSAGE);                                 
                }          
            }         
        }catch(SQLException ex){
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
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o empréstimo", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void registrarEntradaSaidaLivro(String script, int idEmprestimo, int idLivroEmprestado){ 
        try{ 
            this.insertStmt = this.conexao.prepareStatement(script);
            this.insertStmt.setInt(1, idEmprestimo);
            this.insertStmt.setInt(2, idLivroEmprestado);
            this.insertStmt.execute(); 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o empréstimo", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public List<EmprestimoLivro> consultarEmprestimosLivro(EmprestimoLivro filtroEmpLivro, java.util.Date dataEmprestimoInicial, java.util.Date dataEmprestimoFinal, java.util.Date dataDevolucaoInicial, java.util.Date dataDevolucaoFinal){
        
        List<EmprestimoLivro> listaEmpLivro = new ArrayList<>();
        
        // Montando a query SQL com placeholders
        String sql = "SELECT EMP.Codigo AS CodigoEmprestimo, B.Codigo AS CodBiblioteca, B.NomeBiblioteca AS NomeBiblioteca, P.Codigo AS CodPessoa, P.Nome AS NomePessoa, " +
            "LV.Codigo AS CodInternoLivro, LV.CodLivro AS CodLivro, LV.Nome AS NomeLivro, LV.Volume AS VolumeLivro, " +
            "LE.StatusEmprestimo AS StatusEmprestimo, LE.DataEmprestimo AS DataEmprestimo, LE.DataDevolucao AS DataDevolucao " +
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
            if (!filtroEmpLivro.getLivro().isEmpty()) {
                this.selectStmt.setInt(7, filtroEmpLivro.getLivro().get(0).getCodInterno());
                this.selectStmt.setInt(8, filtroEmpLivro.getLivro().get(0).getCodInterno());
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
                this.selectStmt.setInt(11, filtroEmpLivro.getStatusEmprestimo());
                this.selectStmt.setInt(12, filtroEmpLivro.getStatusEmprestimo());
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
                empLivro.setCodigo(rs.getInt("CodigoEmprestimo"));
                empLivro.setStatusEmprestimo(rs.getInt("StatusEmprestimo"));
                empLivro.setDataEmprestimo(rs.getDate("DataEmprestimo"));
                empLivro.setDataDevolucao(rs.getDate("DataDevolucao"));
                biblioteca.setCodigo(rs.getInt("CodBiblioteca"));
                biblioteca.setNomeBiblioteca(rs.getString("NomeBiblioteca"));
                empLivro.setBiblioteca(biblioteca);
                empLivro.setPessoa(pessoa);
                empLivro.setLivro(listaLivro);

                listaEmpLivro.add(empLivro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os empréstimos dos livros", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fechando recursos
            try {
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
        return listaEmpLivro;
    }

    public void devolverLivro(List<EmprestimoLivro> livrosDevolvido){
        
        String sqlInsert = "INSERT INTO RegistroSaidaEntradaLivro (CodEmprestimo,CodLivroEmprestados,TipoMovimentacao,DataMovimentacao)VALUES (?,?,'ENTRADA - DEVOLUÇÃO',GETDATE())";
        String sqlUpdate = "UPDATE LE SET LE.StatusEmprestimo=?, LE.DataDevolucao=? "
            + "OUTPUT inserted.Codigo, inserted.CodEmprestimo "
            + "FROM LivrosEmprestados AS LE "
            + "INNER JOIN Emprestimo AS EMP ON EMP.Codigo = LE.CodEmprestimo " 
            + "WHERE LE.CodEmprestimo=? AND LE.Livro=? AND LE.StatusEmprestimo=1 AND LE.DataDevolucao IS NULL AND EMP.Pessoa=? AND EMP.Biblioteca=?";
        String sqlUpdate2 = "UPDATE RegistroBiblioteca SET Quantidade = Quantidade + 1 WHERE Livro = ?";

        try{
            this.conexao = Conexao.getDataSource().getConnection();
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso
       
            for(EmprestimoLivro devLivro : livrosDevolvido){ 
                
                this.updateStmt = conexao.prepareStatement(sqlUpdate, PreparedStatement.RETURN_GENERATED_KEYS); 
                this.updateStmt.setInt(1, devLivro.getStatusEmprestimo());
                this.updateStmt.setDate(2, (Date) devLivro.getDataDevolucao());
                this.updateStmt.setInt(3, devLivro.getCodigo());
                this.updateStmt.setInt(4, devLivro.getLivro().get(0).getCodLivro());
                this.updateStmt.setInt(5, devLivro.getPessoa().getCodigo());
                this.updateStmt.setInt(6, devLivro.getBiblioteca().getCodigo());                         
                this.rs = this.updateStmt.executeQuery(); 
                
                if (this.rs.next()) {                           
                    // Atualizar a quantidade de livros da biblioteca                  
                    atualizarSaldoLivro(sqlUpdate2,devLivro.getLivro().get(0),devLivro.getBiblioteca());
                    registrarEntradaSaidaLivro(sqlInsert,this.rs.getInt("CodEmprestimo"), this.rs.getInt("Codigo"));              
                }
            }
            //Confimar a transação, ou seja, a inserção dos dados
            this.conexao.commit();
            JOptionPane.showMessageDialog(null, "Devolução efetuada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Se ocorrer um erro, fazer rollback da transação
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar a devolução", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(this.rs != null) this.rs.close();
                if(this.updateStmt != null) this.updateStmt.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    private List<Livro> livrosDisponiveisParaEmprestimo(EmprestimoLivro livrosEmprestados){
        String sqlSelect = "SELECT * FROM RegistroBiblioteca WHERE Biblioteca=? AND Livro=? AND Quantidade > 0";   
        List<Livro> livrosDisponiveis = new ArrayList<>();
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            for(Livro lvEmp : livrosEmprestados.getLivro()){                  
                //Consulta para saber se o livro existe na biblioteca informada
                this.selectStmt = this.conexao.prepareStatement(sqlSelect); 
                this.selectStmt.setInt(1, livrosEmprestados.getBiblioteca().getCodigo());
                this.selectStmt.setInt(2, lvEmp.getCodInterno());
                this.rs = this.selectStmt.executeQuery();
                
                if(this.rs.next()){                  
                    livrosDisponiveis.add(lvEmp);  
                }else{
                    JOptionPane.showMessageDialog(null, "Livro "+lvEmp.getNomeLivro().toUpperCase()+" não encontrado na biblioteca "+livrosEmprestados.getBiblioteca().getNomeBiblioteca().toUpperCase(), "Concluído", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os livros disponíveis", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(this.selectStmt != null) this.selectStmt.close();
                //if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }    
        return livrosDisponiveis;
    }   
    
    //Consulta que aparece todos os livros emprestados, quando abrir a tela;
    public List<EmprestimoLivro> consultarEmprestimosStatusEmprestado(){
        
        List<EmprestimoLivro> listaEmpLivro = new ArrayList<>();
        
        // Montando a query SQL com placeholders
        String sqlSelect = "SELECT EMP.Codigo AS CodigoEmprestimo, B.Codigo AS CodBiblioteca, B.NomeBiblioteca AS NomeBiblioteca, P.Codigo AS CodPessoa, P.Nome AS NomePessoa, " +
            "LV.Codigo AS CodInternoLivro, LV.CodLivro AS CodLivro, LV.Nome AS NomeLivro, LV.Volume AS VolumeLivro, " +
            "LE.StatusEmprestimo AS StatusEmprestimo, LE.DataEmprestimo AS DataEmprestimo, LE.DataDevolucao AS DataDevolucao " +
            "FROM Emprestimo AS EMP " +
            "INNER JOIN LivrosEmprestados LE ON EMP.Codigo = LE.CodEmprestimo " +
            "INNER JOIN Pessoas P ON EMP.Pessoa = P.Codigo " +
            "INNER JOIN Livros LV ON LE.Livro = LV.Codigo " +
            "INNER JOIN Bibliotecas AS B ON B.Codigo = EMP.Biblioteca " +
            "WHERE LE.StatusEmprestimo = 1 AND LE.DataDevolucao IS NULL";

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
                
                pessoa.setCodigo(rs.getInt("CodPessoa"));
                pessoa.setNome(rs.getString("NomePessoa"));
                livro.setCodInterno(rs.getInt("CodInternoLivro"));
                livro.setCodLivro(rs.getInt("CodLivro"));
                livro.setNomeLivro(rs.getString("NomeLivro"));
                livro.setVolume(rs.getInt("VolumeLivro"));
                empLivro.setCodigo(rs.getInt("CodigoEmprestimo"));
                empLivro.setStatusEmprestimo(rs.getInt("StatusEmprestimo"));
                empLivro.setDataEmprestimo(rs.getDate("DataEmprestimo"));
                empLivro.setDataDevolucao(rs.getDate("DataDevolucao"));
                biblioteca.setCodigo(rs.getInt("CodBiblioteca"));
                biblioteca.setNomeBiblioteca(rs.getString("NomeBiblioteca"));
                listaLivro.add(livro);
                empLivro.setBiblioteca(biblioteca);
                empLivro.setPessoa(pessoa);
                empLivro.setLivro(listaLivro);

                listaEmpLivro.add(empLivro);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar todos os livros emprestados", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fechando recursos
            try {
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
        return listaEmpLivro;
    }
}
