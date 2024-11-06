
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
import model.EmprestimoLivro;
import model.Livro;
import model.Pessoa;

public class EmprestimoLivroDao {
    
    private final Conversores converteData = new Conversores();
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void emprestarLivros(List<EmprestimoLivro> livrosEmprestados){

        PreparedStatement psEmprestimo = null;
        PreparedStatement psAtuBblioteca = null;
        ResultSet generatedKeys = null;
        
        String sqlInsert2 = "INSERT INTO EmprestimoLivros(Pessoa,Livro,StatusEmprestimo,DataEmprestimo,Igreja,Eventos) VALUES(?,?,?,?,?,'<' + CONVERT(VARCHAR, GETDATE(), 103)+'> EMPRÉSTIMO')";
        String sqlUpdate = "UPDATE Biblioteca SET Quantidade = Quantidade - 1 WHERE Livro = ?";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            for(EmprestimoLivro emp : livrosEmprestados){   
                    
                psEmprestimo = this.conexao.prepareStatement(sqlInsert2, PreparedStatement.RETURN_GENERATED_KEYS); 
                psEmprestimo.setInt(1, emp.getPessoa().getCodigo());
                psEmprestimo.setInt(2, emp.getLivro().getCodInterno());
                psEmprestimo.setInt(3, emp.getStatus());
                psEmprestimo.setDate(4, (Date) emp.getDataEmprestimo());
                psEmprestimo.setInt(5, emp.getIgreja().getCodigo());
                psEmprestimo.executeUpdate();

                // Recuperar a chave primaria do emprestimo
                generatedKeys = psEmprestimo.getGeneratedKeys();
                
                if (generatedKeys.next()) {
                    //Atualizando a quantidade de livros da biblioteca, após o empréstimo
                    psAtuBblioteca = this.conexao.prepareStatement(sqlUpdate);
                    psAtuBblioteca.setInt(1, emp.getLivro().getCodInterno());                  
                    psAtuBblioteca.executeUpdate();                                    
                }
            }
            //Confimar a transação, ou seja, a inserção dos dados
            this.conexao.commit();
            JOptionPane.showMessageDialog(null, "Empréstimo efetuado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o empréstimo", "Erro 007", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro de SQL: " + ex.getMessage()); 
        }finally{
            //Fechar os recursos abertos
            try{
                if(generatedKeys != null) generatedKeys.close();
                if(psEmprestimo != null) psEmprestimo.close();
                if(psAtuBblioteca != null) psAtuBblioteca.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }  
    
    public List<EmprestimoLivro> consultarEmprestimosLivro(EmprestimoLivro filtroEmpLivro, java.util.Date dataEmprestimoInicial, java.util.Date dataEmprestimoFinal, java.util.Date dataDevolucaoInicial, java.util.Date dataDevolucaoFinal){
        
        List<EmprestimoLivro> listaEmpLivro = new ArrayList<>();
        
        // Montando a query SQL com placeholders
        String sql = "SELECT EMP.CodInterno AS CodIternoEmprestimo, EMP.Pessoa AS CodPessoa, P.Nome AS NomePessoa, " +
            "EMP.Livro AS CodInternoLivro, LV.CodLivro AS CodLivro, LV.Nome AS NomeLivro, LV.Volume AS VolumeLivro, " +
            "EMP.StatusEmprestimo AS StatusEmprestimo, EMP.DataEmprestimo AS DataEmprestimo, EMP.DataDevolucao AS DataDevolucao " +
            "FROM EmprestimoLivros AS EMP " +
            "INNER JOIN Pessoas P ON EMP.Pessoa = P.Codigo " +
            "INNER JOIN Livros LV ON EMP.Livro = LV.Codigo " +
            "WHERE (? IS NULL OR EMP.DataEmprestimo BETWEEN ? AND ?) " +
            "AND (? IS NULL OR EMP.DataDevolucao BETWEEN ? AND ?) " +
            "AND (? IS NULL OR EMP.Livro = ?) " +
            "AND (? IS NULL OR EMP.Pessoa = ?) " +
            "AND (? IS NULL OR EMP.StatusEmprestimo = ?) " +
            "AND (? IS NULL OR EMP.Igreja = ?)";

        try {
            conexao = Conexao.getDataSource().getConnection();         
            ps = conexao.prepareStatement(sql);  
            
            // Datas Emprestimo
            if (dataEmprestimoInicial != null && dataEmprestimoFinal != null) {
                ps.setDate(1, new java.sql.Date(dataEmprestimoInicial.getTime()));
                ps.setDate(2, new java.sql.Date(dataEmprestimoInicial.getTime()));
                ps.setDate(3, new java.sql.Date(dataEmprestimoFinal.getTime()));
            } else {
                ps.setNull(1, java.sql.Types.DATE);
                ps.setNull(2, java.sql.Types.DATE);
                ps.setNull(3, java.sql.Types.DATE);
            }
            
            //Datas Devolução
            if (dataDevolucaoInicial != null && dataDevolucaoFinal != null) {
                ps.setDate(4, new java.sql.Date(dataDevolucaoInicial.getTime()));
                ps.setDate(5, new java.sql.Date(dataDevolucaoInicial.getTime()));
                ps.setDate(6, new java.sql.Date(dataDevolucaoFinal.getTime()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
                ps.setNull(5, java.sql.Types.DATE);
                ps.setNull(6, java.sql.Types.DATE);
            }
                       
            // Parâmetro para livro
            if (filtroEmpLivro.getLivro() != null) {
                ps.setInt(7, filtroEmpLivro.getLivro().getCodInterno());
                ps.setInt(8, filtroEmpLivro.getLivro().getCodInterno());
            } else {
                ps.setNull(7, java.sql.Types.INTEGER);
                ps.setNull(8, java.sql.Types.INTEGER);
            }

            // Parâmetro para pessoa
            if (filtroEmpLivro.getPessoa().getCodigo() != null) {
                ps.setInt(9, filtroEmpLivro.getPessoa().getCodigo());
                ps.setInt(10, filtroEmpLivro.getPessoa().getCodigo());
            } else {
                ps.setNull(9, java.sql.Types.INTEGER);
                ps.setNull(10, java.sql.Types.INTEGER);
            }

            // Parâmetro para status
            if (filtroEmpLivro.getStatus() != null) {
                ps.setInt(11, filtroEmpLivro.getStatus());
                ps.setInt(12, filtroEmpLivro.getStatus());
            } else {
                ps.setNull(11, java.sql.Types.INTEGER);
                ps.setNull(12, java.sql.Types.INTEGER);
            }
            
            // Parâmetro para igreja
            if (filtroEmpLivro.getIgreja() != null) {
                ps.setInt(13, filtroEmpLivro.getIgreja().getCodigo());
                ps.setInt(14, filtroEmpLivro.getIgreja().getCodigo());
            } else {
                ps.setNull(13, java.sql.Types.INTEGER);
                ps.setNull(14, java.sql.Types.INTEGER);
            }
            
            // Executando a consulta
            rs = ps.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                EmprestimoLivro empLivro = new EmprestimoLivro();
                Livro livro = new Livro();
                pessoa.setCodigo(rs.getInt("CodPessoa"));
                pessoa.setNome(rs.getString("NomePessoa"));
                livro.setCodInterno(rs.getInt("CodInternoLivro"));
                livro.setCodLivro(rs.getInt("CodLivro"));
                livro.setNomeLivro(rs.getString("NomeLivro"));
                livro.setVolume(rs.getInt("volumeLivro"));
                empLivro.setCodInterno(rs.getInt("CodIternoEmprestimo"));
                empLivro.setStatus(rs.getInt("StatusEmprestimo"));
                empLivro.setDataEmprestimo(rs.getDate("DataEmprestimo"));
                empLivro.setDataDevolucao(rs.getDate("DataDevolucao"));
                empLivro.setPessoa(pessoa);
                empLivro.setLivro(livro);

                listaEmpLivro.add(empLivro);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os empréstimos dos livros", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fechando recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
        return listaEmpLivro;
    }

    public void devolverLivro(List<EmprestimoLivro> livrosDevolvido){
        
        PreparedStatement psRegistro = null;
        PreparedStatement psMovimento = null;
        ResultSet generatedKeys = null;

        try{
            conexao = Conexao.getDataSource().getConnection();
       
            for(EmprestimoLivro devLivro : livrosDevolvido){ 
                
                String sqlUpdate1 = "UPDATE EmprestimoLivros SET StatusEmprestimo=?, DataDevolucao=?, Eventos = Eventos + '<'+CONVERT(VARCHAR, GETDATE(), 103)+'> DEVOLUÇÃO' WHERE CodInterno=? AND Livro=? AND StatusEmprestimo=1 AND DataDevolucao IS NULL";
                psRegistro = conexao.prepareStatement(sqlUpdate1, PreparedStatement.RETURN_GENERATED_KEYS); 
                psRegistro.setInt(1, devLivro.getStatus());
                psRegistro.setDate(2, (Date) devLivro.getDataDevolucao());
                psRegistro.setInt(3, devLivro.getCodInterno());
                psRegistro.setInt(4, devLivro.getLivro().getCodInterno());
                psRegistro.execute();

                // Recuperar a chave primária gerada
                generatedKeys = psRegistro.getGeneratedKeys();
                
                if (generatedKeys.next()) { //Verifica se tem a chave primária
                    // Atualizar a quantidade de livros da biblioteca
                    String sqlUpdate2 = "UPDATE Biblioteca SET Quantidade = Quantidade + 1 WHERE Livro = ?";
                    psMovimento = conexao.prepareStatement(sqlUpdate2);                  
                    psMovimento.setInt(1, devLivro.getLivro().getCodInterno());                  
                    psMovimento.executeUpdate();
                }
            }
            //Confimar a transação, ou seja, a inserção dos dados
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Devolução efetuada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Se ocorrer um erro, fazer rollback da transação
            if(conexao != null){
                try{
                    conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar a devolução", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(rs != null) rs.close();
                if(psRegistro != null) psRegistro.close();
                if(psMovimento != null) psMovimento.close();
                if(conexao != null) conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    //Consulta que aparece todos os livros emprestados, quando abrir a tela;
    public List<EmprestimoLivro> consultarTodosEmprestimos(){
        
        List<EmprestimoLivro> listaEmpLivro = new ArrayList<>();
        
        // Montando a query SQL com placeholders
        String sql = "SELECT EMP.CodInterno AS CodIternoEmprestimo, EMP.EmprestimoDevolucao AS EmprestimoDevolucao, EMP.Pessoa AS CodPessoa, P.Nome AS NomePessoa, " +
            "EMP.Livro AS CodInternoLivro, LV.CodLivro AS CodLivro, LV.Nome AS NomeLivro, LV.Volume AS VolumeLivro, " +
            "EMP.StatusEmprestimo AS StatusEmprestimo, EMP.DataEmprestimo AS DataEmprestimo, EMP.DataDevolucao AS DataDevolucao " +
            "FROM EmprestimoLivros AS EMP " +
            "INNER JOIN Pessoas P ON EMP.Pessoa = P.Codigo " +
            "INNER JOIN Livros LV ON EMP.Livro = LV.Codigo " +
            "WHERE StatusEmprestimo = 1 AND DataDevolucao IS NULL";

        try {
            conexao = Conexao.getDataSource().getConnection();         
            ps = conexao.prepareStatement(sql);  
            rs = ps.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                EmprestimoLivro empLivro = new EmprestimoLivro();
                Livro livro = new Livro();
                pessoa.setCodigo(rs.getInt("CodPessoa"));
                pessoa.setNome(rs.getString("NomePessoa"));
                livro.setCodInterno(rs.getInt("CodInternoLivro"));
                livro.setCodLivro(rs.getInt("CodLivro"));
                livro.setNomeLivro(rs.getString("NomeLivro"));
                livro.setVolume(rs.getInt("volumeLivro"));
                empLivro.setCodInterno(rs.getInt("CodIternoEmprestimo"));
                empLivro.setStatus(rs.getInt("StatusEmprestimo"));
                empLivro.setDataEmprestimo(rs.getDate("DataEmprestimo"));
                empLivro.setDataDevolucao(rs.getDate("DataDevolucao"));
                empLivro.setPessoa(pessoa);
                empLivro.setLivro(livro);

                listaEmpLivro.add(empLivro);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar todos os livros emprestados", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fechando recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
        return listaEmpLivro;
    }
}
