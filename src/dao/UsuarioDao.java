
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.AcessosIgreja;
import model.AcessosTela;
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

    public int adicionarUsuario(Usuario usuario){
        
        String sql= "INSERT INTO Usuarios (Nome,Email,Celular,Usuario,Igreja,DataCadastro,Ativo,HashSenha,SaltSenha,Funcao,TodasIgrejas)VALUES (?,?,?,?,?,GETDATE(),1,?,?,?,?)";
        int idUsuario = 0;
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            conexao.setAutoCommit(false); //Setando o autocomit como falso
                     
            ps = conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1,usuario.getNome());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getCelular());
            ps.setString(4,usuario.getLogin());
            ps.setInt(5,usuario.getIgreja().getCodigo());   
            ps.setString(6,usuario.getHashSenha());
            ps.setString(7,usuario.getSaltSenha());
            ps.setInt(8,usuario.getFuncaoCargo().getCodigo());
            ps.setInt(9,usuario.getTodasIgrejas());
            ps.executeUpdate();
            
            // Recuperar a chave primária gerada
            ResultSet generatedKeys = ps.getGeneratedKeys();         
            if (generatedKeys.next()) {                
                idUsuario = generatedKeys.getInt(1);
            }
            
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            if (ex.getErrorCode() == 2627) { // Código de erro para violação de UNIQUE
                JOptionPane.showMessageDialog(null, "Já existe um usuário com esse Login", "Erro 001", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
            }
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return idUsuario;

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
            
            JOptionPane.showMessageDialog(null, "Usuário "+usuario.getLogin()+" alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o usuário "+usuario.getLogin(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
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
            
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a senha "+usuario.getLogin(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
    }
    
    public List<Usuario> consultarUsuario(String usuario){
        List<Usuario> listaUsuarios = new ArrayList<>();
         //Estanciando o objeto para consultarIgreja a igreja do usuário

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
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaUsuarios;
    }
    
    public void salvarAcessosPersonalizados(List<AcessosTela> listaAcessos){
        String sql= "Insert Into PermissaoPersonalizadaUsuario (Usuario, MenuID, PodeAcessar, Editar, Excluir, Cadastrar) VALUES (?,?,?,?,?,?)";
             
        try{
            conexao = Conexao.getDataSource().getConnection();
                     
            for(AcessosTela aces : listaAcessos){
                stmtInsert = conexao.prepareStatement(sql);
                
                stmtInsert.setInt(1,aces.getUsuario().getCodigo());
                stmtInsert.setInt(2,aces.getMenuId());
                stmtInsert.setInt(3,aces.getPodeAcesasr());
                stmtInsert.setInt(4,aces.getEditar());
                stmtInsert.setInt(5,aces.getExcluir());   
                stmtInsert.setInt(6,aces.getCadastrar());
                stmtInsert.execute();
            }

            JOptionPane.showMessageDialog(null, "Acessos cadastrados com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);       
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void alterarAcessosPersonalizados(List<AcessosTela> listaAcessos){
        String sql= "Update PermissaoPersonalizadaUsuario Set PodeAcessar = ?, Editar = ?, Excluir = ?, Cadastrar = ? "
            +"Where Usuario = ? AND MenuID = ?";
        
             
        try{
            conexao = Conexao.getDataSource().getConnection();
                     
           for(AcessosTela aces : listaAcessos){
                stmtSelect = conexao.prepareStatement(sql);
                
                stmtSelect.setInt(1,aces.getPodeAcesasr());
                stmtSelect.setInt(2,aces.getEditar());
                stmtSelect.setInt(3,aces.getExcluir());   
                stmtSelect.setInt(4,aces.getCadastrar());
                stmtSelect.setInt(5,aces.getUsuario().getCodigo());
                stmtSelect.setInt(6,aces.getMenuId());
                stmtSelect.execute();
           }

            JOptionPane.showMessageDialog(null, "Acessos cadastrados com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);       
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
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
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os acessos do usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return funcao;
    }
    
    public List<AcessosTela> consultarAcessosPadrao(Usuario usuario){
        List<AcessosTela> listaAcessos = new ArrayList<>();
         //Estanciando o objeto para consultarIgreja a igreja do usuário

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
                AcessosTela acessos = new AcessosTela();

                acessos.setCodFuncao(rs.getInt("FuncaoID"));
                acessos.setMenuId(rs.getInt("MenuID"));
                acessos.setPodeAcesasr(rs.getInt("PodeAcessar"));
                acessos.setEditar(rs.getInt("Editar"));
                acessos.setExcluir(rs.getInt("Excluir"));
                acessos.setCadastrar(rs.getInt("Cadastrar"));

                listaAcessos.add(acessos);
            }          
        }catch(SQLException ex){
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os acessos do usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaAcessos;
    }
    
    public List<AcessosTela> consultarAcessosPersonalizados(Usuario usuario){
        
        List<AcessosTela> listaAcessos = new ArrayList<>();
         //Estanciando o objeto para consultarIgreja a igreja do usuário

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
                AcessosTela acessos = new AcessosTela();
                
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
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os acessos do usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);   
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaAcessos;
    }
    
    public void adicionarAcessoIgreja(List<AcessosIgreja> listaAcessosNovos){
                     
        String sql= "INSERT INTO UsuariosAcessoIgreja (Usuario,Igreja,Data)VALUES (?,?,GETDATE())";
             
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            for(AcessosIgreja ai : listaAcessosNovos){
                ps.setInt(1,ai.getUsuario().getCodigo());
                ps.setInt(2,ai.getIgreja().getCodigo());

                ps.execute();
            }           
        }catch(SQLException ex){
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar/alterar acessos", "Erro 001", JOptionPane.ERROR_MESSAGE);      
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    public void excluirAcessoIgreja(List<AcessosIgreja> listaAcessosAtual){
        String sql= "DELETE FROM UsuariosAcessoIgreja WHERE Codigo = ?";
             
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            for(AcessosIgreja ai : listaAcessosAtual){
                ps.setInt(1,ai.getCodigo());
                ps.execute();
            }           
        }catch(SQLException ex){
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir acessos igreja", "Erro 001", JOptionPane.ERROR_MESSAGE);      
        }finally{
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    public List<AcessosIgreja> consultarAcessoIgreja(Usuario user){
        
        String sql= "SELECT UAI.* , (SELECT NomeIgreja FROM Igrejas I WHERE I.Codigo = UAI.Igreja) As NomeIgreja FROM UsuariosAcessoIgreja UAI WHERE UAI.Usuario = ?";
        List<AcessosIgreja> listaAcessos = new ArrayList<>();
             
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            ps.setInt(1,  user.getCodigo());
            rs = ps.executeQuery();

            while(rs.next()){
                Igreja igreja = new Igreja();
                AcessosIgreja acessoIgreja = new AcessosIgreja();             
                acessoIgreja.setCodigo(rs.getInt("Codigo"));
                igreja.setCodigo(rs.getInt("Igreja"));
                igreja.setNome(rs.getString("NomeIgreja"));
                acessoIgreja.setIgreja(igreja);
                
                listaAcessos.add(acessoIgreja);
            }          
        }catch(SQLException ex){
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os acessos igreja do usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return listaAcessos;
    }
    
    public String gerarFiltroIgreja(Usuario usuario){
        
        List<AcessosIgreja> listaAcessoIgreja = consultarAcessoIgreja(usuario);
        String filtroIgreja = "";
        int cont = 0;
        int tamanhoLista = listaAcessoIgreja.size();
        int ultimo = tamanhoLista - 1;
        
        for(AcessosIgreja ai : listaAcessoIgreja){
            
            String codIgreja = String.valueOf(ai.getIgreja().getCodigo());
            
            if(tamanhoLista == 1){
                filtroIgreja = codIgreja;
            }else{
                if(tamanhoLista > 1 && cont == ultimo){
                   filtroIgreja += codIgreja;
                }else{
                   filtroIgreja += codIgreja+","; 
                }
            }
            cont ++;
        }
        
        return filtroIgreja;
    }
    
    public Integer validarUsuarioRecuperacaoSenha(String login, String email){
        
        Integer codUsuario = null; 
        
        String sql = "SELECT Codigo FROM Usuarios Where Usuario = ? And Email = ? And Ativo = 1";
    
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            ps.setString(1,  login);
            ps.setString(2,  email);
            rs = ps.executeQuery();

            while(rs.next()){
                codUsuario = rs.getInt("Codigo");
            }          
        }catch(SQLException ex){
            logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentarvalidar usuário", "Erro", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("UsuarioDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return codUsuario;   
    }
  
  
}
