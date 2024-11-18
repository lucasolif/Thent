
package dao;

import ferramentas.Utilitarios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Campanha;
import model.ContasReceberCampanha;
import model.Pessoa;


public class CampanhaDao {
    
    private final Utilitarios converteData = new Utilitarios();
    private Connection conexao = null;
    private PreparedStatement psParticipante = null;
    private PreparedStatement psCampanha = null;
    private PreparedStatement psCrCampanha = null;
    private ResultSet rs = null;
    
    public void cadastrarCampanha(Campanha campanha, boolean geraContaReceber){

        String sqlInsert = "INSERT INTO Campanha (TipoCampanha, DescricaoCampanha, Igreja, DuracaoCampanha, DataInicioCampanha, DataFinalCampanha, Observacao, ValorTotalCampanha, StatusCampanha, DiaPagamento, DataCadastro) VALUES (?,?,?,?,?,?,?,?,?,?,GETDATE())";

        try{
            this.conexao = Conexao.getDataSource().getConnection();
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso   
            
            this.psCampanha = this.conexao.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS); 
            this.psCampanha.setInt(1, campanha.getTipoCampanha().getCodigo());
            this.psCampanha.setString(2, campanha.getDescricaoCampanha());
            this.psCampanha.setInt(3, campanha.getIgreja().getCodigo());
            this.psCampanha.setInt(4, campanha.getDuracaoMeses());
            this.psCampanha.setDate(5, (Date) campanha.getDataInicial());
            this.psCampanha.setDate(6, (Date) campanha.getDataFinal());
            this.psCampanha.setString(7, campanha.getObservacao());
            this.psCampanha.setDouble(8, campanha.getValorTotalCampanha());
            this.psCampanha.setInt(9, campanha.getStatusCampanha());
            this.psCampanha.setInt(10, campanha.getDiaPagamento());
            this.psCampanha.executeUpdate();

            // Recuperar a chave primária gerada
            ResultSet generatedKeys = this.psCampanha.getGeneratedKeys();
            int codCampanha = generatedKeys.getInt(1);
            
            //Método para adicionar participante na tabela de participante. Vincula com a campanha por meio do código da campanha
            if(!campanha.getParticipante().isEmpty() && generatedKeys.next()){
                adicionarParticipantes(campanha.getParticipante(), codCampanha);
                this.conexao.commit();
            }
            
            //Se for escolhido para gerar contas a receber no form, o método chama a função para gerar a contas a receber
            if(geraContaReceber){
                gerarContasReceberCampanha(campanha.getListaCrCampanha());
            } 

            JOptionPane.showMessageDialog(null, "Campanha cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
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
                if(this.psCampanha != null) this.psCampanha.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }   
    
    private void adicionarParticipantes(List<Pessoa> participantes, int codCampanha){
        
        String sqlInsert = "INSERT INTO ParticipantesCampanha (CodPessoa, NomePessoa, Campanha, Status, DataCadastro) VALUES (?,?,?,?,GETDATE())";

        try{    
            this.conexao = Conexao.getDataSource().getConnection();
            this.psParticipante = this.conexao.prepareStatement(sqlInsert);
            
            for(Pessoa part : participantes){
                this.psParticipante.setInt(1, part.getCodigo());
                this.psParticipante.setString(2, part.getNome());
                this.psParticipante.setInt(3, codCampanha);
                this.psParticipante.setInt(4, 1);
                this.psParticipante.execute();
            }         
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar os participantes", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if(conexao != null) conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void gerarContasReceberCampanha(List<ContasReceberCampanha> listaCrCamp){
        
        String sqlInsert = "INSERT INTO ContasReceberCampanhas (CodPessoa,NomePessoa,Parcela,ValorParcela,ValorPendente,DataVencimento,StatusPagamento,DescricaoStatus,Campanha,ContaResultado,Igreja,DataCadastro) Values(?,?,?,?,?,?,?,?,?,?,?,GETDATE())";

        try{
            this.conexao = Conexao.getDataSource().getConnection();          
            this.psCrCampanha = this.conexao.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS); 
            
            for(ContasReceberCampanha crCamp : listaCrCamp){
                this.psCrCampanha.setInt(1, crCamp.getParticipante().getCodigo());
                this.psCrCampanha.setString(2, crCamp.getParticipante().getNome());
                this.psCrCampanha.setInt(3, crCamp.getParcela());
                this.psCrCampanha.setDouble(4, crCamp.getValorParcela());
                this.psCrCampanha.setDouble(5, crCamp.getValorPendente());
                this.psCrCampanha.setDate(6, (Date) crCamp.getDataVencimento());
                this.psCrCampanha.setInt(7, crCamp.getStatusPagamento());
                this.psCrCampanha.setString(8, crCamp.getDescricaoStatus());
                this.psCrCampanha.setInt(9, crCamp.getCampanha().getCodigo());
                this.psCrCampanha.setInt(10, crCamp.getContaResultado().getCodigo());
                this.psCrCampanha.setInt(11, crCamp.getIgreja().getCodigo());
                this.psCrCampanha.execute();
            }
            JOptionPane.showMessageDialog(null, "Contas a receber gerada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao gerar as contas a receber", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(this.psCrCampanha != null) this.psCrCampanha.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
