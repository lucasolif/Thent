
package dao;

import Services.Utilitarios;
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
import model.ParticipanteCampanha;
import model.Pessoa;


public class CampanhaDao {
    
    private final LogsDao logsDao = new LogsDao();
    private final Utilitarios converteData = new Utilitarios();
    private Connection conexao = null;
    private PreparedStatement insertStmt = null;
    private PreparedStatement updateStmt = null;
    private PreparedStatement selectStmt = null;
    private PreparedStatement deleteStmt = null;
    private ResultSet rs = null;
    
    public void cadastrarCampanha(Campanha campanha, boolean geraContaReceber){

        String sqlInsert = "INSERT INTO Campanhas (DescricaoCampanha, Igreja, DuracaoCampanha, DataInicioCampanha, DataFinalCampanha, Observacao, ValorTotalCampanha, StatusCampanha, DescricaoStatus, DiaPagamento, DataCadastro) VALUES (?,?,?,?,?,?,?,?,'Andamento',?,GETDATE())";

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
            this.insertStmt.setString(8, campanha.getStatusCampanha());
            this.insertStmt.setInt(9, campanha.getDiaPagamento());
            this.insertStmt.executeUpdate();
            
            ResultSet generatedKeys = this.insertStmt.getGeneratedKeys();
            if(generatedKeys.next()){
                int codCampanha = generatedKeys.getInt(1);
                
                //Método para adicionar participante na tabela de participante. Vincula com a campanha por meio do código da campanha
                if(!campanha.getParticipante().isEmpty()){         
                    adicionarParticipantes(campanha.getParticipante(), codCampanha);   
                    
                    //Se for escolhido para gerar contas a receber no form, o método chama a função para gerar a contas a receber
                    if(geraContaReceber){
                        gerarContasReceberCampanha(campanha.getParticipante() , codCampanha);
                    } 

                }
                JOptionPane.showMessageDialog(null, "Campanha cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);             
            }else{        
                JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar a chave da campanha", "Erro 007", JOptionPane.ERROR_MESSAGE);
            }
            this.conexao.commit();
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    logsDao.gravaLogsErro(e.getSQLState()+" - "+e.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a campanha", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if(this.rs != null) this.rs.close();
                if(this.insertStmt != null) this.insertStmt.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }   
    
    public void adicionarParticipantes(List<ParticipanteCampanha> participantes, int codCampanha){
        
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
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar os participantes", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if(this.insertStmt != null) this.insertStmt.close();
            }catch(SQLException ex){
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void adicionarParticipantesAvulso(ParticipanteCampanha participantes, int codCampanha, boolean geraContaReceber){
        
        String sqlInsert = "INSERT INTO ParticipantesCampanha (CodPessoa, NomePessoa, Campanha, Status, DataCadastro) VALUES (?,?,?,?,GETDATE())";

        try{                
            this.conexao = Conexao.getDataSource().getConnection();
            this.insertStmt = this.conexao.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
            
            this.insertStmt.setInt(1, participantes.getCodigo());
            this.insertStmt.setString(2, participantes.getNome());
            this.insertStmt.setInt(3, codCampanha);
            this.insertStmt.setInt(4, 1);
            this.insertStmt.executeUpdate();
            
            ResultSet generatedKeys = this.insertStmt.getGeneratedKeys();                      
            if(generatedKeys.next() && geraContaReceber){
                gerarContasReceberAvulsaCampanha(participantes, codCampanha);
            }
        }catch(SQLException ex){
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar os participantes", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if(this.insertStmt != null) this.insertStmt.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void gerarContasReceberCampanha(List<ParticipanteCampanha> listaParticipantes, int codCampanha){
        
        String sqlInsert = "INSERT INTO ContasReceberCampanhas (CodPessoa,NomePessoa,Parcela,ValorParcela,ValorPendente,DataVencimento,StatusPagamento,DescricaoStatus,Campanha,ContaResultado,Igreja,DataCadastro) Values(?,?,?,?,?,?,?,?,?,?,?,GETDATE())";

        try{                 
            this.insertStmt = this.conexao.prepareStatement(sqlInsert); 
            for(ParticipanteCampanha part : listaParticipantes){
                for(ContasReceberCampanha crCamp : part.getListaCrCampanha()){             
                    this.insertStmt.setInt(1, part.getCodigo());
                    this.insertStmt.setString(2, part.getNome());
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
            }
            JOptionPane.showMessageDialog(null, "Contas a receber gerada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao gerar as contas a receber", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if(this.insertStmt != null) this.insertStmt.close();
            }catch(SQLException ex){
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void gerarContasReceberAvulsaCampanha(ParticipanteCampanha participante, int codCampanha){
        
        String sqlInsert = "INSERT INTO ContasReceberCampanhas (CodPessoa,NomePessoa,Parcela,ValorParcela,ValorPendente,DataVencimento,StatusPagamento,DescricaoStatus,Campanha,ContaResultado,Igreja,DataCadastro) Values(?,?,?,?,?,?,?,?,?,?,?,GETDATE())";

        try{           
            this.conexao = Conexao.getDataSource().getConnection();
            this.insertStmt = this.conexao.prepareStatement(sqlInsert); 
            
            for(ContasReceberCampanha crCamp : participante.getListaCrCampanha()){             
                this.insertStmt.setInt(1, participante.getCodigo());
                this.insertStmt.setString(2, participante.getNome());
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
            
            JOptionPane.showMessageDialog(null, "Contas a receber gerada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());            
            JOptionPane.showMessageDialog(null, "Erro ao gerar as contas a receber", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if(this.insertStmt != null) this.insertStmt.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean verificarParticipanteCampanha(Campanha campanha, ParticipanteCampanha participante){
        
        String sql = "SELECT * FROM Campanhas AS C INNER JOIN ParticipantesCampanha AS PC ON PC.Campanha = C.Codigo WHERE C.StatusCampanha = 'A' AND PC.Campanha = ? AND PC.CodPessoa = ? AND PC.Status = 1";  
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
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
        }finally{
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }       
        return controle;
    } 
    
    public void inativarParticipante(Campanha campanha, ParticipanteCampanha participante){
                  
        String sql = "UPDATE ParticipantesCampanha SET Status=0 OUTPUT inserted.Codigo WHERE CodPessoa=? AND Campanha=?";  
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();   
            
            this.updateStmt = this.conexao.prepareStatement(sql);
            this.updateStmt.setInt(1, participante.getCodigo());
            this.updateStmt.setInt(2, campanha.getCodigo());
            this.rs = this.updateStmt.executeQuery();

            if(this.rs.next()){
                excluirContasReceberCampanha(campanha, participante);
                JOptionPane.showMessageDialog(null, "Participante inativado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Não foi encontrado o participante na campanha selecionada", "Erro", JOptionPane.ERROR_MESSAGE);
            }   
        }catch(SQLException ex){
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
            if(this.conexao != null){
                try{
                    if(!this.conexao.isClosed()){
                        this.conexao.rollback();
                    }              
                }catch(SQLException e){
                    //Grava o log de erro na tabela de LogsErro
                    logsDao.gravaLogsErro(e.getSQLState()+" - "+e.getMessage());  
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
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }      
    }
    
    public void excluirContasReceberCampanha(Campanha campanha, ParticipanteCampanha participante){
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
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public List<ContasReceberCampanha> consultarContasReceberCampanha(ContasReceberCampanha crCampanha, String statusCampanha, java.util.Date dataVencInicial, java.util.Date dataVencFinal, java.util.Date dataPagtoInicial, java.util.Date dataPagtoFinal){
        
        List<ContasReceberCampanha> listaCrCampanha = new ArrayList<>();

        // Montando a query SQL com placeholders
        String sql = "SELECT C.DescricaoCampanha AS DescricaoCampanha, CR.* " +
        "FROM ContasReceberCampanhas AS CR " +
        "INNER JOIN Campanhas AS C ON C.Codigo = CR.Campanha " +
        "WHERE (? IS NULL OR CR.DataPagamento BETWEEN ? AND ?) " +
        "AND (? IS NULL OR CR.DataVencimento BETWEEN ? AND ?) " +
        "AND (? IS NULL OR CR.CodPessoa = ?) " +
        "AND (? IS NULL OR CR.StatusPagamento = ?) " +
        "AND (? IS NULL OR CR.FormaPagto = ?) " +
        "AND (? IS NULL OR CR.Igreja = ?) " +
        "AND (? IS NULL OR CR.Campanha = ?) " +
        "AND (? IS NULL OR C.StatusCampanha = ?)";

        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.selectStmt = this.conexao.prepareStatement(sql);  
            
            // Datas Pagamento
            if (dataPagtoInicial != null && dataPagtoFinal != null) {
                this.selectStmt .setDate(1, new java.sql.Date(dataPagtoInicial.getTime()));
                this.selectStmt .setDate(2, new java.sql.Date(dataPagtoInicial.getTime()));
                this.selectStmt .setDate(3, new java.sql.Date(dataPagtoFinal.getTime()));
            } else {
                this.selectStmt .setNull(1, java.sql.Types.DATE);
                this.selectStmt .setNull(2, java.sql.Types.DATE);
                this.selectStmt .setNull(3, java.sql.Types.DATE);
            }
            
            //Datas Vencimento
            if (dataVencInicial != null && dataVencFinal != null) {
                this.selectStmt .setDate(4, new java.sql.Date(dataVencInicial.getTime()));
                this.selectStmt .setDate(5, new java.sql.Date(dataVencInicial.getTime()));
                this.selectStmt .setDate(6, new java.sql.Date(dataVencFinal.getTime()));
            } else {
                this.selectStmt .setNull(4, java.sql.Types.DATE);
                this.selectStmt .setNull(5, java.sql.Types.DATE);
                this.selectStmt .setNull(6, java.sql.Types.DATE);
            }     

            // Parâmetro para participante
            if (crCampanha.getParticipante() != null) {
                this.selectStmt .setInt(7, crCampanha.getParticipante().getCodigo());
                this.selectStmt .setInt(8, crCampanha.getParticipante().getCodigo());
            } else {
                this.selectStmt .setNull(7, java.sql.Types.INTEGER);
                this.selectStmt .setNull(8, java.sql.Types.INTEGER);
            }

            // Parâmetro para Status de pagamento
            if (crCampanha.getStatusPagamento() != null) {
                this.selectStmt .setInt(9, crCampanha.getStatusPagamento());
                this.selectStmt .setInt(10, crCampanha.getStatusPagamento());
            } else {
                this.selectStmt .setNull(9, java.sql.Types.INTEGER);
                this.selectStmt .setNull(10, java.sql.Types.INTEGER);
            }

            // Parâmetro para forma de pagamento
            if (crCampanha.getFormaPagto() != null) {
                this.selectStmt .setInt(11, crCampanha.getFormaPagto().getCodigo());
                this.selectStmt .setInt(12, crCampanha.getFormaPagto().getCodigo());
            } else {
                this.selectStmt .setNull(11, java.sql.Types.INTEGER);
                this.selectStmt .setNull(12, java.sql.Types.INTEGER);
            }
            
            // Parâmetro para forma igreja
            if (crCampanha.getIgreja() != null) {
                this.selectStmt .setInt(13, crCampanha.getIgreja().getCodigo());
                this.selectStmt .setInt(14, crCampanha.getIgreja().getCodigo());
            } else {
                this.selectStmt .setNull(13, java.sql.Types.INTEGER);
                this.selectStmt .setNull(14, java.sql.Types.INTEGER);
            }
            
            // Parâmetro para campanha
            if (crCampanha.getCampanha() != null) {
                this.selectStmt .setInt(15, crCampanha.getCampanha().getCodigo());
                this.selectStmt .setInt(16, crCampanha.getCampanha().getCodigo());
            } else {
                this.selectStmt .setNull(15, java.sql.Types.INTEGER);
                this.selectStmt .setNull(16, java.sql.Types.INTEGER);
            }
            
            // Parâmetro para satus da campanha
            if (statusCampanha != null) {
                this.selectStmt .setString(17, statusCampanha);
                this.selectStmt .setString(18, statusCampanha);
            } else {
                this.selectStmt .setNull(17, java.sql.Types.INTEGER);
                this.selectStmt .setNull(18, java.sql.Types.INTEGER);
            }
            
            // Executando a consulta
            this.rs = this.selectStmt .executeQuery();

            // Iterando sobre os resultados
            while (this.rs.next()) {
                //Convertendo as datas do tipo Date para String
                Campanha campanha = new Campanha();
                Igreja igreja = new Igreja();
                ParticipanteCampanha participante = new ParticipanteCampanha();
                ContasReceberCampanha contaReceber = new ContasReceberCampanha();
                igreja.setCodigo(this.rs.getInt("Igreja"));
                campanha.setCodigo(this.rs.getInt("Campanha"));
                campanha.setDescricaoCampanha(this.rs.getString("DescricaoCampanha"));
                participante.setCodigo(this.rs.getInt("CodPessoa"));
                participante.setNome(this.rs.getString("NomePessoa"));
                contaReceber.setCodigo(this.rs.getInt("NumParcela"));
                contaReceber.setNumParcela(this.rs.getInt("NumParcela"));
                contaReceber.setParcela(this.rs.getInt("Parcela"));
                contaReceber.setValorParcela(this.rs.getDouble("ValorParcela"));
                contaReceber.setValorPago(this.rs.getDouble("ValorPago"));
                contaReceber.setDescricaoStatus(this.rs.getString("DescricaoStatus"));
                contaReceber.setDataVencimento(this.rs.getDate("DataVencimento"));
                contaReceber.setDataPagamento(this.rs.getDate("DataPagamento"));
                contaReceber.setIgreja(igreja);
                contaReceber.setCampanha(campanha);
                contaReceber.setParticipante(participante);

                listaCrCampanha.add(contaReceber);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as contas a receber da campanha", "Erro 001", JOptionPane.ERROR_MESSAGE);
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.selectStmt  != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaCrCampanha;       
    }
    
    public List<ContasReceberCampanha> consultarContasReceberCampanhaMesAtual(Date dataAtual){
        
        List<ContasReceberCampanha> listaCrCampanha = new ArrayList<>();

        String sql = "SELECT (SELECT DescricaoCampanha FROM Campanhas As C WHERE CRC.Campanha = C.Codigo) As DescricaoCampanha,CRC.* FROM ContasReceberCampanhas As CRC "
        + "WHERE CRC.ValorPendente > 0 AND (CRC.DescricaoStatus = 'Aberto' OR CRC.DescricaoStatus = 'Pendente') AND MONTH(CRC.DataVencimento) = MONTH(?)";

        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.selectStmt = this.conexao.prepareStatement(sql);  
            
            this.selectStmt.setDate(1, dataAtual);
            this.rs = this.selectStmt .executeQuery();

            while (this.rs.next()) {
                Campanha campanha = new Campanha();
                Igreja igreja = new Igreja();
                ParticipanteCampanha participante = new ParticipanteCampanha();
                ContasReceberCampanha contaReceber = new ContasReceberCampanha();
                igreja.setCodigo(this.rs.getInt("Igreja"));
                campanha.setCodigo(this.rs.getInt("Campanha"));
                campanha.setDescricaoCampanha(this.rs.getString("DescricaoCampanha"));
                participante.setCodigo(this.rs.getInt("CodPessoa"));
                participante.setNome(this.rs.getString("NomePessoa"));
                contaReceber.setCodigo(this.rs.getInt("NumParcela"));
                contaReceber.setNumParcela(this.rs.getInt("NumParcela"));
                contaReceber.setParcela(this.rs.getInt("Parcela"));
                contaReceber.setValorParcela(this.rs.getDouble("ValorParcela"));
                contaReceber.setValorPago(this.rs.getDouble("ValorPago"));
                contaReceber.setDescricaoStatus(this.rs.getString("DescricaoStatus"));
                contaReceber.setDataVencimento(this.rs.getDate("DataVencimento"));
                contaReceber.setDataPagamento(this.rs.getDate("DataPagamento"));
                contaReceber.setIgreja(igreja);
                contaReceber.setCampanha(campanha);
                contaReceber.setParticipante(participante);

                listaCrCampanha.add(contaReceber);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as contas a receber da campanha", "Erro 001", JOptionPane.ERROR_MESSAGE);
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.selectStmt  != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaCrCampanha;      
    }
    
    public List<ParticipanteCampanha> consultarParticipantesValores(Campanha campanha){
        
        List<ParticipanteCampanha> listaParticipanteCampanha = new ArrayList<>();
        
        String sql = "SELECT " +
        "PC.CodPessoa AS CodPessoa, " +
        "PC.NomePessoa AS NomePessoa, " +
        "PC.Status As Status, " +
        "CASE PC.Status " +
        "    WHEN 1 THEN 'Ativo' " +
        "    ELSE 'Inativo' " +
        "END AS StatusPessoa, " +
        "(SELECT COUNT(Parcela) FROM ContasReceberCampanhas WHERE ValorPago Is Not Null) AS TotalParcelasPagas, " +
        "SUM(ISNULL(CRC.ValorPago, 0)) AS TotalValorPago, " +
        "SUM(ISNULL(CRC.ValorPendente, 0)) AS TotalPendente " +
        "FROM ParticipantesCampanha AS PC " +
        "LEFT JOIN ContasReceberCampanhas AS CRC ON CRC.CodPessoa = PC.CodPessoa AND CRC.Campanha = PC.Campanha " +
        "WHERE PC.Campanha = ? " +  // Substituído por parâmetro
        "GROUP BY " +
        "PC.CodPessoa, " +
        "PC.NomePessoa, " +
        "PC.Campanha, " +
        "PC.Status";

        try{
            this.conexao = Conexao.getDataSource().getConnection();          
            this.selectStmt = this.conexao.prepareStatement(sql);
            this.selectStmt.setInt(1, campanha.getCodigo());
            
            this.rs = this.selectStmt.executeQuery();

            while(this.rs.next()){
                ParticipanteCampanha participante = new ParticipanteCampanha();
                participante.setCodigo(this.rs.getInt("CodPessoa"));
                participante.setNome(this.rs.getString("NomePessoa"));
                participante.setStatus(this.rs.getInt("Status"));
                participante.setDescricaoStatus(this.rs.getString("StatusPessoa"));
                participante.setQtdParcelasPagas(this.rs.getInt("TotalParcelasPagas"));
                participante.setValorTotalPago(this.rs.getDouble("TotalValorPago"));
                participante.setValorTotalPendente(this.rs.getDouble("TotalPendente")); 
                
                listaParticipanteCampanha.add(participante);
            }         
        }catch(SQLException ex){
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os participantes e os valores", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return listaParticipanteCampanha;
    }
    
    public void atualizarContaReceberCampanha(ContasReceberCampanha crCampanha){
        
        String sql = "UPDATE ContasReceberCampanhas "
        + "SET ValorPago=?, ValorPendente=?, DataPagamento=?, StatusPagamento=?, DescricaoStatus=?, FormaPagto=?, ObservacaoPagamento=?"
        + "WHERE NumParcela=?";
        
        double valorPendente = Math.round((crCampanha.getValorParcela() - crCampanha.getValorPago()) * 100.0) / 100.0;
        int statusPagto = 0;
        String descStatus = "Aberto";
        
        if(valorPendente == 0){
            statusPagto = 1;
            descStatus = "Pago";
        }else if(valorPendente > 0 || valorPendente != crCampanha.getValorParcela()){
            statusPagto = 0;
            descStatus = "Pendente";
        }
        
        try{        
            this.conexao = Conexao.getDataSource().getConnection();   
            this.updateStmt = this.conexao.prepareStatement(sql);
            
            this.updateStmt.setDouble(1, crCampanha.getValorPago());
            this.updateStmt.setDouble(2, valorPendente);
            this.updateStmt.setDate(3, (Date) crCampanha.getDataPagamento());
            this.updateStmt.setInt(4, statusPagto);
            this.updateStmt.setString(5, descStatus);
            this.updateStmt.setInt(6, crCampanha.getFormaPagto().getCodigo());
            this.updateStmt.setString(7, crCampanha.getObservacaoPagamento());
            this.updateStmt.setInt(8, crCampanha.getCodigo());           
            this.updateStmt.executeUpdate();  
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o contas a receber", "Erro 001", JOptionPane.ERROR_MESSAGE);
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
        }finally{
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public List<Double> consultarValores(Integer codCampanha){
        
        List<Double> listaValores = new ArrayList<>();

        String sql = "SELECT " +
        "SUM(ISNULL(ValorPago, 0)) AS ValorPago, " +
        "SUM(ValorPendente) AS ValorPendente, " +
        "(SELECT COUNT(Parcela) FROM ContasReceberCampanhas WHERE ValorPago IS NOT NULL) AS ParcelaPaga " +
        "FROM ContasReceberCampanhas " +
        "WHERE Campanha = ?";

        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.selectStmt = this.conexao.prepareStatement(sql);
            
            this.selectStmt.setInt(1, codCampanha);  
            this.rs = this.selectStmt.executeQuery();

            while(this.rs.next()){
                double valorPagor = this.rs.getInt("ValorPago");
                double valorPendente = this.rs.getInt("ValorPendente");
                double qtdParcelasPaga = this.rs.getDouble("ParcelaPaga");

                listaValores.add(valorPagor);
                listaValores.add(valorPendente);
                listaValores.add(qtdParcelasPaga);  
            }         
        }catch(SQLException ex){
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar valores totais da campanha", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaValores;
    }
    
    public List<Campanha> consultarCampanhas(String busca){
        
        List<Campanha> listaCampanhas = new ArrayList<>();

        String sql = "SELECT " +
        "I.Codigo AS CodIgreja, " +
        "I.NomeIgreja AS NomeIgreja, " +
        "C.* " +
        "FROM Campanhas AS C " +
        "LEFT JOIN Igrejas AS I ON I.Codigo = C.Igreja " +
        "WHERE (? IS NULL OR C.Codigo LIKE ?) OR (? IS NULL OR C.DescricaoCampanha LIKE ?)";

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
                Igreja igreja = new Igreja();
                igreja.setCodigo(this.rs.getInt("CodIgreja"));
                igreja.setNome(this.rs.getString("NomeIgreja"));
                campanha.setCodigo(this.rs.getInt("Codigo"));
                campanha.setDescricaoCampanha(this.rs.getString("DescricaoCampanha"));
                campanha.setDuracaoMeses(this.rs.getInt("DuracaoCampanha"));
                campanha.setDataInicial(this.rs.getDate("DataInicioCampanha"));
                campanha.setDataFinal(this.rs.getDate("DataFinalCampanha"));
                campanha.setDiaPagamento(this.rs.getInt("DiaPagamento"));
                campanha.setObservacao(this.rs.getString("Observacao"));
                campanha.setValorTotalCampanha(this.rs.getDouble("ValorTotalCampanha"));
                campanha.setStatusCampanha(this.rs.getString("StatusCampanha"));
                campanha.setDescricaoStatus(this.rs.getString("DescricaoStatus"));
                campanha.setDataCadastro(this.rs.getDate("DataCadastro"));
                campanha.setIgreja(igreja);

                listaCampanhas.add(campanha);
            }         
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar campanha", "Erro 001", JOptionPane.ERROR_MESSAGE);
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaCampanhas;
    }
    
    public List<Campanha> consultarTodasCampanhas(){
    
        String sql = "SELECT * FROM Campanhas ORDER BY DescricaoCampanha ";  
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
                campanha.setStatusCampanha(rs.getString("StatusCampanha"));
                campanha.setDescricaoStatus(rs.getString("DescricaoStatus"));
                campanha.setDataCadastro(rs.getDate("DataCadastro"));
                campanha.setIgreja(igreja);

                listaCampanhas.add(campanha);
            }
          
        }catch(SQLException ex){
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as campanhas", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaCampanhas;    
    }
    
    public List<Campanha> consultarCampanhasAtiva(String busca){
        String sql = "SELECT I.Codigo As CodIgreja, I.NomeIgreja As NomeIgreja, C.* FROM Campanhas As C "
        + "INNER JOIN Igrejas As I ON I.Codigo = C.Igreja "
        + "WHERE ((? IS NULL OR C.Codigo LIKE ?) OR (? IS NULL OR C.DescricaoCampanha LIKE ?)) "
        + "AND C.StatusCampanha = 'A' AND C.DescricaoStatus = 'Andamento' ORDER BY C.DescricaoCampanha";  
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
                Igreja igreja = new Igreja();
                igreja.setCodigo(this.rs.getInt("CodIgreja"));
                igreja.setNome(this.rs.getString("NomeIgreja"));
                campanha.setCodigo(this.rs.getInt("Codigo"));
                campanha.setDescricaoCampanha(this.rs.getString("DescricaoCampanha"));
                campanha.setDuracaoMeses(this.rs.getInt("DuracaoCampanha"));
                campanha.setDataInicial(this.rs.getDate("DataInicioCampanha"));
                campanha.setDataFinal(this.rs.getDate("DataFinalCampanha"));
                campanha.setDiaPagamento(this.rs.getInt("DiaPagamento"));
                campanha.setObservacao(this.rs.getString("Observacao"));
                campanha.setValorTotalCampanha(this.rs.getDouble("ValorTotalCampanha"));
                campanha.setStatusCampanha(this.rs.getString("StatusCampanha"));
                campanha.setDescricaoStatus(this.rs.getString("DescricaoStatus"));
                campanha.setDataCadastro(this.rs.getDate("DataCadastro"));
                campanha.setIgreja(igreja);

                listaCampanhas.add(campanha);
            }
            this.selectStmt.execute();
          
        }catch(SQLException ex){
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
            JOptionPane.showMessageDialog(null, "Erro consultar Campanha", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaCampanhas;
    } 
  
    public List<Campanha> consultarTodasCampanhasAtiva(){
    
        String sql = "SELECT * FROM Campanhas WHERE StatusCampanha = 'A' ORDER BY DescricaoCampanha ";  
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
                campanha.setStatusCampanha(rs.getString("StatusCampanha"));
                campanha.setDescricaoStatus(rs.getString("DescricaoStatus"));
                campanha.setDataCadastro(rs.getDate("DataCadastro"));
                campanha.setIgreja(igreja);

                listaCampanhas.add(campanha);
            }
          
        }catch(SQLException ex){
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as campanhas ativas", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaCampanhas;
        
    }
  
}
