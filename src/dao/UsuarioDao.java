
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Acessos;
import model.FuncoesUsuario;
import model.Igreja;
import model.Usuario;



public class UsuarioDao {
    
    private final LogsDao logsDao = new LogsDao();
    Connection conexao = null;
    PreparedStatement stmtSelect = null;
    PreparedStatement stmtInsert = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void adicionarUsuario(Usuario usuario){
        
        String sql= "INSERT INTO Usuarios (Nome,Email,Celular,Usuario,Igreja,DataCadastro,Ativo,HashSenha,SaltSenha,Funcao,TodasIgrejas)VALUES (?,?,?,?,?,GETDATE(),1,?,?,?,?)";
             
        try{
            conexao = Conexao.getDataSource().getConnection();
                     
            ps = conexao.prepareStatement(sql);
            ps.setString(1,usuario.getNome());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getCelular());
            ps.setString(4,usuario.getLogin());
            ps.setInt(5,usuario.getIgreja().getCodigo());   
            ps.setString(6,usuario.getHashSenha());
            ps.setString(7,usuario.getSaltSenha());
            ps.setInt(8,usuario.getFuncaoCargo().getCodigo());
            ps.setInt(9,usuario.getTodasIgrejas());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Usu�rio cadastrado com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            if (ex.getErrorCode() == 2627) { // C�digo de erro para viola��o de UNIQUE
                JOptionPane.showMessageDialog(null, "J� existe um usu�rio com esse Login", "Erro 001", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o usu�rio", "Erro 001", JOptionPane.ERROR_MESSAGE);
            }
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    
    public void alterarUsuario(Usuario usuario){
             
        try{            
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE Usuarios SET Email=?,Celular=?,Igreja=?,Ativo=?,Funcao=?,TodasIgrejas=?" + " WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1,usuario.getEmail());
            ps.setString(2,usuario.getCelular());
            ps.setInt(3,usuario.getIgreja().getCodigo());
            ps.setInt(4,usuario.getAtivo());
            ps.setInt(5,usuario.getFuncaoCargo().getCodigo());
            ps.setInt(6,usuario.getTodasIgrejas());
            ps.setInt(7,usuario.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usu�rio "+usuario.getLogin()+" alterada com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o usu�rio "+usuario.getLogin(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
    } 
    
    public void alterarSenha(Usuario usuario){
             
        try{            
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE Usuarios SET HashSenha = ?, SaltSenha = ?" + " WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1,usuario.getHashSenha());
            ps.setString(2,usuario.getSaltSenha());
            ps.setInt(3,usuario.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a senha "+usuario.getLogin(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
    }
    
    public List<Usuario> consultarUsuario(String usuario){
        List<Usuario> listaUsuarios = new ArrayList<>();
         //Estanciando o objeto para consultarIgreja a igreja do usu�rio

        String sql = "SELECT I.Codigo AS CodIgreja, I.NomeIgreja AS NomeIgreja, (Select Nome From Funcoes As F Where F.Codigo = U.Funcao) As NomeFuncao, * "
        + "FROM Usuarios AS U "
        + "INNER JOIN Igrejas AS I ON I.Codigo = U.Igreja "       
        + "WHERE ((? IS NULL OR U.Codigo LIKE ?) OR (? IS NULL OR U.Nome LIKE ?) OR (? IS NULL OR U.Usuario LIKE ?))"
        + "AND Ativo = 1";
    
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            if (usuario != null) {
                ps.setString(1,  "%" + usuario + "%");
                ps.setString(2,  "%" + usuario + "%");
                ps.setString(3,  "%" + usuario + "%");
                ps.setString(4,  "%" + usuario + "%");    
                ps.setString(5,  "%" + usuario + "%");
                ps.setString(6,  "%" + usuario + "%"); 
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
                ps.setNull(5, java.sql.Types.INTEGER);
                ps.setNull(6, java.sql.Types.INTEGER);                    
            }
            
            rs = ps.executeQuery();

            while(rs.next()){
                Usuario user = new Usuario();
                FuncoesUsuario funcao = new FuncoesUsuario();
                Igreja igreja = new Igreja();
                funcao.setCodigo(rs.getInt("Funcao"));
                funcao.setNome(rs.getString("NomeFuncao"));
                igreja.setCodigo(rs.getInt("CodIgreja"));
                igreja.setNome(rs.getString("NomeIgreja"));
                user.setCodigo(rs.getInt("Codigo"));
                user.setNome(rs.getString("Nome"));
                user.setEmail(rs.getString("Email"));
                user.setCelular(rs.getString("Celular"));
                user.setLogin(rs.getString("Usuario"));                
                user.setAtivo(rs.getInt("Ativo"));
                user.setIgreja(igreja);
                user.setHashSenha(rs.getString("HashSenha"));
                user.setSaltSenha(rs.getString("SaltSenha"));
                user.setFuncaoCargo(funcao);
                user.setTodasIgrejas(rs.getInt("TodasIgrejas"));

                listaUsuarios.add(user);
            }          
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o usu�rio", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaUsuarios;
    }
    
    public void removerUsuario(int usuario){
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "DELETE FROM Usuarios WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, usuario);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usu�rio exclu�da com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o usu�rio", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void salvarAcessosPersonalizados(List<Acessos> listaAcessos){
        String sql= "Insert Into PermissaoPersonalizadaUsuario (Usuario, MenuID, PodeAcessar, Editar, Excluir, Cadastrar) VALUES (?,?,?,?,?,?)";
             
        try{
            conexao = Conexao.getDataSource().getConnection();
                     
            for(Acessos aces : listaAcessos){
                stmtInsert = conexao.prepareStatement(sql);
                
                stmtInsert.setInt(1,aces.getUsuario().getCodigo());
                stmtInsert.setInt(2,aces.getMenuId());
                stmtInsert.setInt(3,aces.getPodeAcesasr());
                stmtInsert.setInt(4,aces.getEditar());
                stmtInsert.setInt(5,aces.getExcluir());   
                stmtInsert.setInt(6,aces.getCadastrar());
                stmtInsert.execute();
            }

            JOptionPane.showMessageDialog(null, "Acessos cadastrados com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o usu�rio", "Erro 001", JOptionPane.ERROR_MESSAGE);       
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void alterarAcessosPersonalizados(List<Acessos> listaAcessos){
        String sql= "Update PermissaoPersonalizadaUsuario Set PodeAcessar = ?, Editar = ?, Excluir = ?, Cadastrar = ? "
            +"Where Usuario = ? AND MenuID = ?";
        
             
        try{
            conexao = Conexao.getDataSource().getConnection();
                     
           for(Acessos aces : listaAcessos){
                stmtSelect = conexao.prepareStatement(sql);
                
                stmtSelect.setInt(1,aces.getPodeAcesasr());
                stmtSelect.setInt(2,aces.getEditar());
                stmtSelect.setInt(3,aces.getExcluir());   
                stmtSelect.setInt(4,aces.getCadastrar());
                stmtSelect.setInt(5,aces.getUsuario().getCodigo());
                stmtSelect.setInt(6,aces.getMenuId());
                stmtSelect.execute();
           }

            JOptionPane.showMessageDialog(null, "Acessos cadastrados com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o usu�rio", "Erro 001", JOptionPane.ERROR_MESSAGE);       
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public FuncoesUsuario consultarFuncaoUsuario(Usuario usuario){
        FuncoesUsuario funcao = new FuncoesUsuario();  

        String sql = "Select Funcao From Usuarios Where Codigo = ?";
    
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            ps.setInt(1,  usuario.getCodigo());
            rs = ps.executeQuery();

            while(rs.next()){
                funcao.setCodigo(rs.getInt("Funcao"));
            }          
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os acessos do usu�rio", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return funcao;
    }
    
    public List<Acessos> consultarAcessosPadrao(Usuario usuario){
        List<Acessos> listaAcessos = new ArrayList<>();
         //Estanciando o objeto para consultarIgreja a igreja do usu�rio

        String sql = "Select * " +
        "From " +
        "PermissoesMenus As PM " +
        "Where " +
        "PM.FuncaoID = (Select Funcao From Usuarios As U Where U.Codigo = ?)";
    
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            ps.setInt(1,  usuario.getCodigo());
  
            rs = ps.executeQuery();

            while(rs.next()){
                Acessos acessos = new Acessos();

                acessos.setCodFuncao(rs.getInt("FuncaoID"));
                acessos.setMenuId(rs.getInt("MenuID"));
                acessos.setPodeAcesasr(rs.getInt("PodeAcessar"));
                acessos.setEditar(rs.getInt("Editar"));
                acessos.setExcluir(rs.getInt("Excluir"));
                acessos.setCadastrar(rs.getInt("Cadastrar"));

                listaAcessos.add(acessos);
            }          
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os acessos do usu�rio", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaAcessos;
    }
    
    public List<Acessos> consultarAcessosPersonalizados(Usuario usuario){
        
        List<Acessos> listaAcessos = new ArrayList<>();
         //Estanciando o objeto para consultarIgreja a igreja do usu�rio

        String sql = "Select * " +
        "From " +
        "PermissaoPersonalizadaUsuario " +
        "Where Usuario = ?";
    
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            ps.setInt(1,  usuario.getCodigo());
  
            rs = ps.executeQuery();

            while(rs.next()){
                Usuario user = new Usuario();
                Acessos acessos = new Acessos();
                
                user.setCodigo(rs.getInt("Usuario"));
                acessos.setMenuId(rs.getInt("MenuID"));
                acessos.setPodeAcesasr(rs.getInt("PodeAcessar"));
                acessos.setEditar(rs.getInt("Editar"));
                acessos.setExcluir(rs.getInt("Excluir"));
                acessos.setCadastrar(rs.getInt("Cadastrar"));
                acessos.setUsuario(user);

                listaAcessos.add(acessos);
            }          
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os acessos do usu�rio", "Erro 001", JOptionPane.ERROR_MESSAGE);   
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaAcessos;
    }
    
  
}
