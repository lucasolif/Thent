
package dao;

import ferramentas.Conversores;
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
import model.RegistroBiblioteca;

public class EmprestimoLivroDao {
    
    private final Conversores converteData = new Conversores();
    private Connection conexao = null;
    private PreparedStatement selectStmt = null;
    private PreparedStatement insertStmt = null;
    private PreparedStatement updateStmt = null;
    private ResultSet rs = null;
    
    public void emprestarLivros(List<EmprestimoLivro> livrosEmprestados){

        String sqlInsert2 = "INSERT INTO RegistroSaidaEntradaLivro (TipoMovimentacao,DataMovimentacao)VALUES ('SA�DA - EMPR�STIMO',GETDATE())";
        String sqlSelect = "SELECT * FROM RegistroBiblioteca WHERE Biblioteca=? AND Livro=?";
        String sqlInsert1 = "INSERT INTO EmprestimoLivros(Pessoa,Livro,Biblioteca,StatusEmprestimo,DataEmprestimo) VALUES(?,?,?,?,?)";
        String sqlUpdate = "UPDATE RegistroBiblioteca SET Quantidade = Quantidade - 1 WHERE Livro=? AND Biblioteca=?";
        
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            for(EmprestimoLivro emp : livrosEmprestados){   
                
                //Consulta para saber se o livro existe na biblioteca informada
                this.selectStmt = this.conexao.prepareStatement(sqlSelect, PreparedStatement.RETURN_GENERATED_KEYS); 
                this.selectStmt.setInt(1, emp.getBiblioteca().getCodigo());
                this.selectStmt.setInt(2, emp.getLivro().getCodInterno());
                this.rs = this.selectStmt.executeQuery();
                
                if(this.rs.next()){
                    //Inserindo os dados na tabela de empr�stimos    
                    this.insertStmt = this.conexao.prepareStatement(sqlInsert1, PreparedStatement.RETURN_GENERATED_KEYS); 
                    this.insertStmt.setInt(1, emp.getPessoa().getCodigo());
                    this.insertStmt.setInt(2, emp.getLivro().getCodInterno());
                    this.insertStmt.setInt(3, emp.getBiblioteca().getCodigo());
                    this.insertStmt.setInt(4, emp.getStatusEmprestimo());
                    this.insertStmt.setDate(5, (Date) emp.getDataEmprestimo());
                    this.insertStmt.executeUpdate();

                    // Recuperar a chave primaria do emprestimo adicionado
                    ResultSet generatedKeys = this.insertStmt.getGeneratedKeys();

                    if (generatedKeys.next()) {
                        //Atualizando o saldo do livro
                        this.updateStmt = this.conexao.prepareStatement(sqlUpdate); 
                        this.updateStmt.setInt(1, emp.getLivro().getCodInterno());
                        this.updateStmt.setInt(2, emp.getBiblioteca().getCodigo());
                        this.updateStmt.executeUpdate();    
                        
                        //Insere na tabela a movimenta��o do tipo entrada
                        this.insertStmt = this.conexao.prepareStatement(sqlInsert2);    
                        this.insertStmt.execute();    
                    }
                    JOptionPane.showMessageDialog(null, "Empr�stimo do livro "+emp.getLivro().getNomeLivro().toUpperCase()+" efetuado com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Livro "+emp.getLivro().getNomeLivro().toUpperCase()+" n�o encontrado na biblioteca "+emp.getBiblioteca().getNomeBiblioteca().toUpperCase(), "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            //Confimar a transa��o, ou seja, a inser��o dos dados
            this.conexao.commit();
        }catch(SQLException ex){
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o empr�stimo", "Erro 007", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro de SQL: " + ex.getMessage()); 
        }finally{
            //Fechar os recursos abertos
            try{
                if(this.updateStmt != null) this.updateStmt.close();
                if(this.updateStmt != null) this.updateStmt.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }  
    
    public List<EmprestimoLivro> consultarEmprestimosLivro(EmprestimoLivro filtroEmpLivro, java.util.Date dataEmprestimoInicial, java.util.Date dataEmprestimoFinal, java.util.Date dataDevolucaoInicial, java.util.Date dataDevolucaoFinal){
        
        List<EmprestimoLivro> listaEmpLivro = new ArrayList<>();
        
        // Montando a query SQL com placeholders
        String sql = "SELECT EMP.Codigo AS CodigoEmprestimo, B.Codigo AS CodBiblioteca, B.NomeBiblioteca AS NomeBiblioteca, BP.Codigo AS CodPessoa, P.Nome AS NomePessoa, " +
            "LV.Codigo AS CodInternoLivro, LV.CodLivro AS CodLivro, LV.Nome AS NomeLivro, LV.Volume AS VolumeLivro, " +
            "EMP.StatusEmprestimo AS StatusEmprestimo, EMP.DataEmprestimo AS DataEmprestimo, EMP.DataDevolucao AS DataDevolucao " +
            "FROM EmprestimoLivros AS EMP " +
            "INNER JOIN Pessoas P ON EMP.Pessoa = P.Codigo " +
            "INNER JOIN Livros LV ON EMP.Livro = LV.Codigo " +
            "INNER JOIN Bibliotecas AS B ON B.Codigo = EMP.Biblioteca " +
            "WHERE (? IS NULL OR EMP.DataEmprestimo BETWEEN ? AND ?) " +
            "AND (? IS NULL OR EMP.DataDevolucao BETWEEN ? AND ?) " +
            "AND (? IS NULL OR EMP.Livro = ?) " +
            "AND (? IS NULL OR EMP.Pessoa = ?) " +
            "AND (? IS NULL OR EMP.StatusEmprestimo = ?) " +
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
            
            //Datas Devolu��o
            if (dataDevolucaoInicial != null && dataDevolucaoFinal != null) {
                this.selectStmt.setDate(4, new java.sql.Date(dataDevolucaoInicial.getTime()));
                this.selectStmt.setDate(5, new java.sql.Date(dataDevolucaoInicial.getTime()));
                this.selectStmt.setDate(6, new java.sql.Date(dataDevolucaoFinal.getTime()));
            } else {
                this.selectStmt.setNull(4, java.sql.Types.DATE);
                this.selectStmt.setNull(5, java.sql.Types.DATE);
                this.selectStmt.setNull(6, java.sql.Types.DATE);
            }
                       
            // Par�metro para livro
            if (filtroEmpLivro.getLivro() != null) {
                this.selectStmt.setInt(7, filtroEmpLivro.getLivro().getCodInterno());
                this.selectStmt.setInt(8, filtroEmpLivro.getLivro().getCodInterno());
            } else {
                this.selectStmt.setNull(7, java.sql.Types.INTEGER);
                this.selectStmt.setNull(8, java.sql.Types.INTEGER);
            }

            // Par�metro para pessoa
            if (filtroEmpLivro.getPessoa().getCodigo() != null) {
                this.selectStmt.setInt(9, filtroEmpLivro.getPessoa().getCodigo());
                this.selectStmt.setInt(10, filtroEmpLivro.getPessoa().getCodigo());
            } else {
                this.selectStmt.setNull(9, java.sql.Types.INTEGER);
                this.selectStmt.setNull(10, java.sql.Types.INTEGER);
            }

            // Par�metro para status
            if (filtroEmpLivro.getStatusEmprestimo()!= null) {
                this.selectStmt.setInt(11, filtroEmpLivro.getStatusEmprestimo());
                this.selectStmt.setInt(12, filtroEmpLivro.getStatusEmprestimo());
            } else {
                this.selectStmt.setNull(11, java.sql.Types.INTEGER);
                this.selectStmt.setNull(12, java.sql.Types.INTEGER);
            }
            
            // Par�metro para igreja
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
                empLivro.setBiblioteca(biblioteca);
                empLivro.setPessoa(pessoa);
                empLivro.setLivro(livro);

                listaEmpLivro.add(empLivro);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os empr�stimos dos livros", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fechando recursos
            try {
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
        return listaEmpLivro;
    }

    public void devolverLivro(List<EmprestimoLivro> livrosDevolvido){
        
        String sqlInsert = "INSERT INTO RegistroSaidaEntradaLivro (TipoMovimentacao,DataMovimentacao)VALUES ('ENTRADA - DEVOLU��O',GETDATE())";
        String sqlUpdate = "UPDATE EmprestimoLivros SET StatusEmprestimo=?, DataDevolucao=? WHERE Codigo=? AND Livro=? AND StatusEmprestimo=1 AND DataDevolucao IS NULL AND Pessoa=? AND Biblioteca=?";
        String sqlUpdate2 = "UPDATE RegistroBiblioteca SET Quantidade = Quantidade + 1 WHERE Livro = ?";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
       
            for(EmprestimoLivro devLivro : livrosDevolvido){ 
                               
                this.updateStmt = conexao.prepareStatement(sqlUpdate, PreparedStatement.RETURN_GENERATED_KEYS); 
                this.updateStmt.setInt(1, devLivro.getStatusEmprestimo());
                this.updateStmt.setDate(2, (Date) devLivro.getDataDevolucao());
                this.updateStmt.setInt(3, devLivro.getCodigo());
                this.updateStmt.setInt(4, devLivro.getLivro().getCodInterno());
                this.updateStmt.setInt(5, devLivro.getPessoa().getCodigo());
                this.updateStmt.setInt(6, devLivro.getBiblioteca().getCodigo());
                this.updateStmt.executeUpdate();

                // Recuperar a chave prim�ria gerada
                ResultSet generatedKeys = this.updateStmt.getGeneratedKeys();
                
                if (generatedKeys.next()) {                     
                    // Atualizar a quantidade de livros da biblioteca                  
                    this.updateStmt = this.conexao.prepareStatement(sqlUpdate2);                  
                    this.updateStmt.setInt(1, devLivro.getLivro().getCodInterno());                  
                    this.updateStmt.executeUpdate();
                    
                    //Insere na tabela a movimenta��o do tipo entrada
                    this.insertStmt = this.conexao.prepareStatement(sqlInsert);    
                    this.insertStmt.execute();    
                }
            }
            //Confimar a transa��o, ou seja, a inser��o dos dados
            this.conexao.commit();
            JOptionPane.showMessageDialog(null, "Devolu��o efetuada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Se ocorrer um erro, fazer rollback da transa��o
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar a devolu��o", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(this.rs != null) this.rs.close();
                if(this.updateStmt != null) this.updateStmt.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    //Consulta que aparece todos os livros emprestados, quando abrir a tela;
    public List<EmprestimoLivro> consultarEmprestimosStatusEmprestado(){
        
        List<EmprestimoLivro> listaEmpLivro = new ArrayList<>();
        
        // Montando a query SQL com placeholders
        String sqlSelect = "SELECT EMP.Codigo AS CodigoEmprestimo, B.Codigo AS CodBiblioteca, B.NomeBiblioteca AS NomeBiblioteca, BP.Codigo AS CodPessoa, P.Nome AS NomePessoa, " +
            "LV.Codigo AS CodInternoLivro, LV.CodLivro AS CodLivro, LV.Nome AS NomeLivro, LV.Volume AS VolumeLivro, " +
            "EMP.StatusEmprestimo AS StatusEmprestimo, EMP.DataEmprestimo AS DataEmprestimo, EMP.DataDevolucao AS DataDevolucao " +
            "FROM EmprestimoLivros AS EMP " +
            "INNER JOIN Pessoas P ON EMP.Pessoa = P.Codigo " +
            "INNER JOIN Livros LV ON EMP.Livro = LV.Codigo " +
            "INNER JOIN Bibliotecas AS B ON B.Codigo = EMP.Biblioteca " +
            "WHERE StatusEmprestimo = 1 AND DataDevolucao IS NULL";

        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.selectStmt = this.conexao.prepareStatement(sqlSelect);  
            this.rs = this.selectStmt.executeQuery();

            // Iterando sobre os resultados
            while (this.rs.next()) {
                Pessoa pessoa = new Pessoa();
                EmprestimoLivro empLivro = new EmprestimoLivro();
                Livro livro = new Livro();
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
                empLivro.setBiblioteca(biblioteca);
                empLivro.setPessoa(pessoa);
                empLivro.setLivro(livro);

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
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
        return listaEmpLivro;
    }
    
    public void saidaAvulsaLivro(RegistroBiblioteca rgMovimentacao){
        
        String sqlInsert = "INSERT INTO RegistroSaidaEntradaLivro(TipoMovimentacao,DataMovimentacao) VALUES(?,GETDATE())";
        String sqlUpdate = "UPDATE RegistroBiblioteca SET Quantidade = Quantidade - 1 OUTPUT inserted.Codigo WHERE Livro=? AND Biblioteca=?";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();

            //Atualizando o saldo do livro
            this.updateStmt = this.conexao.prepareStatement(sqlUpdate); 
            this.updateStmt.setInt(1, rgMovimentacao.getLivro().getCodInterno());
            this.updateStmt.setInt(2, rgMovimentacao.getBiblioteca().getCodigo());
            this.rs = this.updateStmt.executeQuery();   
            
            if (this.rs.next()) {           
                //Inserindo os dados na tabela de empr�stimos    
                this.insertStmt = this.conexao.prepareStatement(sqlInsert); 
                this.insertStmt.setString(1, "SA�DA AVULSA - LIVRO: "+rgMovimentacao.getLivro().getCodLivro()+" - "+rgMovimentacao.getLivro().getNomeLivro());
                this.insertStmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Sa�da avulsa do livro "+rgMovimentacao.getLivro().getNomeLivro()+" efetuada com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar a sa�da avulsa", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(this.updateStmt != null) this.updateStmt.close();
                if(this.updateStmt != null) this.updateStmt.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
}
