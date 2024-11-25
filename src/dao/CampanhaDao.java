
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
import model.Campanha;
import model.ContasReceberCampanha;
import model.Igreja;
import model.Pessoa;


public class CampanhaDao {
    
    private final Utilitarios converteData = new Utilitarios();
    private Connection conexao = null;
    private PreparedStatement insertStmt = null;
    private PreparedStatement updateStmt = null;
    private PreparedStatement selectStmt = null;
    private PreparedStatement deleteStmt = null;
    private ResultSet rs = null;
    
    public void cadastrarCampanha(Campanha campanha, boolean geraContaReceber){

        String sqlInsert = "INSERT INTO Campanhas (DescricaoCampanha, Igreja, DuracaoCampanha, DataInicioCampanha, DataFinalCampanha, Observacao, ValorTotalCampanha, StatusCampanha, DescricaoStatus, DiaPagamento, DataCadastro) VALUES (?,?,?,?,?,?,?,?,'Ativa',?,GETDATE())";

        try{
            this.conexao = Conexao.getDataSource().getConnection();
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso   
            
            this.insertStmt = this.conexao.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS); 
            this.insertStmt.setString(1, campanha.getDescricaoCampanha());
            this.insertStmt.setInt(2, campanha.getIgreja().getCodigo());
            this.insertStmt.setInt(3, campanha.getDuracaoMeses());
            this.insertStmt.setDate(4, (Date) campanha.getDataInicial());
            this.insertStmt.setDate(5, (Date) campanha.getDataFinal());
            this.insertStmt.setString(6, campanha.getObservacao());
            this.insertStmt.setDouble(7, campanha.getValorTotalCampanha());
            this.insertStmt.setInt(8, campanha.getStatusCampanha());
            this.insertStmt.setInt(9, campanha.getDiaPagamento());
            this.insertStmt.executeUpdate();
            
            ResultSet generatedKeys = this.insertStmt.getGeneratedKeys();
            if(generatedKeys.next()){
                int codCampanha = generatedKeys.getInt(1);
                
                //M�todo para adicionar participante na tabela de participante. Vincula com a campanha por meio do c�digo da campanha
                if(!campanha.getParticipante().isEmpty()){         
                    adicionarParticipantes(campanha.getParticipante(), codCampanha);   
                    
                    //Se for escolhido para gerar contas a receber no form, o m�todo chama a fun��o para gerar a contas a receber
                    if(geraContaReceber){
                        gerarContasReceberCampanha(campanha.getListaCrCampanha(), codCampanha);
                    } 

                }
                JOptionPane.showMessageDialog(null, "Campanha cadastrada com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);             
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar a chave da campanha", "Erro 007", JOptionPane.ERROR_MESSAGE);
            }
            this.conexao.commit();
        }catch(SQLException ex){
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a campanha", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(this.rs != null) this.rs.close();
                if(this.insertStmt != null) this.insertStmt.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }   
    
    public void adicionarParticipantes(List<Pessoa> participantes, int codCampanha){
        
        String sqlInsert = "INSERT INTO ParticipantesCampanha (CodPessoa, NomePessoa, Campanha, Status, DataCadastro) VALUES (?,?,?,?,GETDATE())";

        try{                
            for(Pessoa part : participantes){
                this.insertStmt = this.conexao.prepareStatement(sqlInsert);
                this.insertStmt.setInt(1, part.getCodigo());
                this.insertStmt.setString(2, part.getNome());
                this.insertStmt.setInt(3, codCampanha);
                this.insertStmt.setInt(4, 1);
                this.insertStmt.execute();
            }         
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar os participantes", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if(this.insertStmt != null) this.insertStmt.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void gerarContasReceberCampanha(List<ContasReceberCampanha> listaCrCamp, int codCampanha){
        
        String sqlInsert = "INSERT INTO ContasReceberCampanhas (CodPessoa,NomePessoa,Parcela,ValorParcela,ValorPendente,DataVencimento,StatusPagamento,DescricaoStatus,Campanha,ContaResultado,Igreja,DataCadastro) Values(?,?,?,?,?,?,?,?,?,?,?,GETDATE())";

        try{                 
            this.conexao = Conexao.getDataSource().getConnection();
            this.insertStmt = this.conexao.prepareStatement(sqlInsert); 
            
            for(ContasReceberCampanha crCamp : listaCrCamp){             
                this.insertStmt.setInt(1, crCamp.getParticipante().getCodigo());
                this.insertStmt.setString(2, crCamp.getParticipante().getNome());
                this.insertStmt.setInt(3, crCamp.getParcela());
                this.insertStmt.setDouble(4, crCamp.getValorParcela());
                this.insertStmt.setDouble(5, crCamp.getValorPendente());
                this.insertStmt.setDate(6, (Date) crCamp.getDataVencimento());
                this.insertStmt.setInt(7, crCamp.getStatusPagamento());
                this.insertStmt.setString(8, crCamp.getDescricaoStatus());
                this.insertStmt.setInt(9, codCampanha);
                this.insertStmt.setInt(10, crCamp.getContaResultado().getCodigo());
                this.insertStmt.setInt(11, crCamp.getIgreja().getCodigo());
                this.insertStmt.execute();
            }
            JOptionPane.showMessageDialog(null, "Contas a receber gerada com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao gerar as contas a receber", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if(this.insertStmt != null) this.insertStmt.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public List<Campanha> consultarCampanhasAtiva(String busca){
        String sql = "SELECT * FROM Campanhas WHERE ((? IS NULL OR Codigo LIKE ?) OR (? IS NULL OR DescricaoCampanha LIKE ?)) "
        + "AND StatusCampanha = 1 AND DescricaoStatus LIKE '%Ativa%' ORDER BY Descricao";  
        List<Campanha> listaCampanhas = new ArrayList<>();
 
        try{
            this.conexao = Conexao.getDataSource().getConnection();        
            this.selectStmt = this.conexao.prepareStatement(sql);
                 
            if (busca != null) {
                this.selectStmt.setString(1,  "%" + busca + "%");
                this.selectStmt.setString(2,  "%" + busca + "%");
                this.selectStmt.setString(3,  "%" + busca + "%");
                this.selectStmt.setString(4,  "%" + busca + "%");
            } else {
                this.selectStmt.setNull(1, java.sql.Types.INTEGER);
                this.selectStmt.setNull(2, java.sql.Types.INTEGER);
                this.selectStmt.setNull(3, java.sql.Types.INTEGER);
                this.selectStmt.setNull(4, java.sql.Types.INTEGER);
            }
            this.rs = this.selectStmt.executeQuery();

            while(this.rs.next()){
                Campanha campanha = new Campanha();
                campanha.setCodigo(this.rs.getInt("Codigo"));
                campanha.setDescricaoCampanha(this.rs.getString("DescricaoCampanha"));
                campanha.setDuracaoMeses(this.rs.getInt("DuracaoCampanha"));
                campanha.setDataInicial(this.rs.getDate("DataInicioCampanha"));
                campanha.setDataFinal(this.rs.getDate("DataFinalCampanha"));
                campanha.setDiaPagamento(this.rs.getInt("DiaPagamento"));
                campanha.setObservacao(this.rs.getString("Observacao"));
                campanha.setValorTotalCampanha(this.rs.getDouble("ValoTotalCampanha"));
                campanha.setStatusCampanha(this.rs.getInt("StatusCampanha"));
                campanha.setDescricaoStatus(this.rs.getString("DescricaoStatus"));
                campanha.setDataCadastro(this.rs.getDate("DataCadastro"));

                listaCampanhas.add(campanha);
            }
            this.selectStmt.execute();
          
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as Contas Caixa", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaCampanhas;
    }
    
    public List<Campanha> consultarCampanhasAtiva(){
    
        String sql = "SELECT * FROM Campanhas WHERE StatusCampanha = 1 ORDER BY DescricaoCampanha ";  
        List<Campanha> listaCampanhas = new ArrayList<>();
 
        try{
            this.conexao = Conexao.getDataSource().getConnection();         
            this.selectStmt = this.conexao.prepareStatement(sql);
            this.rs = this.selectStmt.executeQuery();

            while(rs.next()){
                Campanha campanha = new Campanha();
                Igreja igreja = new Igreja();
                campanha.setCodigo(rs.getInt("Codigo"));
                campanha.setDescricaoCampanha(rs.getString("DescricaoCampanha"));
                igreja.setCodigo(rs.getInt("Igreja"));
                campanha.setDuracaoMeses(rs.getInt("DuracaoCampanha"));
                campanha.setDataInicial(rs.getDate("DataInicioCampanha"));
                campanha.setDataFinal(rs.getDate("DataFinalCampanha"));
                campanha.setDiaPagamento(rs.getInt("DiaPagamento"));               
                campanha.setObservacao(rs.getString("Observacao"));
                campanha.setValorTotalCampanha(rs.getDouble("ValorTotalCampanha"));
                campanha.setStatusCampanha(rs.getInt("StatusCampanha"));
                campanha.setDescricaoStatus(rs.getString("DescricaoStatus"));
                campanha.setDataCadastro(rs.getDate("DataCadastro"));
                campanha.setIgreja(igreja);

                listaCampanhas.add(campanha);
            }
          
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as campanhas ativas", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaCampanhas;
        
    }
    
    public boolean verificarParticipanteCampanha(Campanha campanha, Pessoa participante){
        
        String sql = "SELECT * FROM Campanhas AS C INNER JOIN ParticipantesCampanha AS PC ON PC.Campanha = C.Codigo WHERE C.StatusCampanha = 1 AND PC.Campanha = ? AND PC.CodPessoa = ? AND PC.Status = 1";  
        boolean controle = false;
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            
            this.selectStmt = this.conexao.prepareStatement(sql);
            this.selectStmt.setInt(1, campanha.getCodigo());
            this.selectStmt.setInt(2, participante.getCodigo());
            this.rs = this.selectStmt.executeQuery();

            if(this.rs.next()){
                controle = true;
            }   
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar verficar a existencia do participante na campanha", "Erro 001", JOptionPane.ERROR_MESSAGE);
            System.out.println("erro: "+ex.getMessage());
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return controle;
    } 
    
    public void inativarParticipante(Campanha campanha, Pessoa participante){
                  
        String sql = "UPDATE ParticipantesCampanha SET Status=0 OUTPUT inserted.Codigo WHERE CodPessoa=? AND Campanha=?";  
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();   
            
            this.updateStmt = this.conexao.prepareStatement(sql);
            this.updateStmt.setInt(1, participante.getCodigo());
            this.updateStmt.setInt(2, campanha.getCodigo());
            this.rs = this.updateStmt.executeQuery();

            if(this.rs.next()){
                excluirContasReceberCampanha(campanha, participante);
                JOptionPane.showMessageDialog(null, "Participante inativado com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "N�o foi encontrado o participante na campanha selecionada", "Erro", JOptionPane.ERROR_MESSAGE);
            }   
        }catch(SQLException ex){
            if(this.conexao != null){
                try{
                    if(!this.conexao.isClosed()){
                        this.conexao.rollback();
                    }              
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar inativar o participante", "Erro", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.rs != null) this.rs.close();
                if (this.updateStmt != null) this.updateStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }      
    }
    
    public void excluirContasReceberCampanha(Campanha campanha, Pessoa participante){
        String sql = "DELETE FROM ContasReceberCampanhas WHERE CodPessoa=? AND Campanha=? AND StatusPagamento=0 AND ValorPago IS NULL";  
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();      
            
            this.deleteStmt = this.conexao.prepareStatement(sql);
            this.deleteStmt.setInt(1, participante.getCodigo());
            this.deleteStmt.setInt(2, campanha.getCodigo());         
            this.deleteStmt.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir as contas a pagar em aberto", "Erro 001", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro: "+ex.getMessage());
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.deleteStmt != null) this.deleteStmt.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
