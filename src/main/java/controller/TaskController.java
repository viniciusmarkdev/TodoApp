    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author Luis
 */
public class TaskController {
    
    public void save(Task task){
        
        
        String sql = "INSERT INTO tb_tarefas(tb_projetos_id, nome,  descricao , status,notas ,  prazo,dataCriacao ,dataAtualizacao "
                + ")"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
     
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,task.getTb_projetos_id());
            statement.setString(2, task.getNome());
            statement.setString(3,task.getDescricao());
            statement.setBoolean(4, task.isStatus());
            statement.setString(5, task.getNotas());
            statement.setDate(6,new Date(task.getPrazo().getTime()));
            statement.setDate(7,new Date(task.getDataCriacao().getTime()));
            statement.setDate(8,new Date(task.getDataAtualizacao().getTime()));
            statement.execute();
       
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa "+ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection(connection);
        }
    }
    
    public void update(Task task){
        
       
         String sql = "UPDATE tb_tarefas SET tb_projetos_id=?,nome=?,descricao=?,notas=?,"
                 + "status=?,prazo=?,DataCriacao=?,DataAtualizacao=?WHERE id=?";
                 
                
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
          
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getTb_projetos_id());
            statement.setString(2, task.getNome());
            statement.setString(3, task.getDescricao());
            statement.setString(4, task.getNotas());
            statement.setBoolean(5, task.isStatus());
            statement.setDate(6, new Date(task.getPrazo().getTime()));
            statement.setDate(7, new Date(task.getDataCriacao().getTime() ));
            statement.setDate(8, new Date(task.getDataAtualizacao().getTime() ));
            statement.setInt(9, task.getId());
            //Executando a query
            statement.execute();
             } catch (Exception ex) {
                 
                     throw new RuntimeException("Erro ao atualizar a tarefa " +ex.getMessage(),ex);
        }
        
        
        
        
        
    }
    public void removeById(int id){
        
        String sql = "DELETE FROM tb_tarefas WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
      
        try {
            
             //Criando conexão com banco de dados
            connection  =ConnectionFactory.getConnection();
            //preparando query
            statement = connection .prepareStatement(sql);
            
            //Setando valores
            statement.setInt(1, id);
           
            //executando a query
            statement.execute();
            
        } catch (Exception ex) {
            
            throw new RuntimeException("Erro ao deletar a tarefa" +ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection( connection , statement);
        }
        
    }
   
    public List<Task>getAll(int tb_projetos_id){
        
        
        String sql = "SELECT * FROM tb_tarefas where tb_projetos_id=?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
       
        //Lista de tarefas que será devolvida quando a chamada do método acontecer     
        List<Task> tasks = new ArrayList<Task>();
        
        
        try {
            
            //Criação da conexão
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            //Setando o valor que corresponde ao filtro de busca
            statement.setInt(1,tb_projetos_id);
            
            //Valor retornado com o valor da query
            resultSet = statement.executeQuery();
            
            //Enquanto houverem  valores a serem percorridos no meu resultSet
            while(resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setTb_projetos_id(resultSet.getInt("tb_projetos_id"));
                task.setNome(resultSet.getString("nome"));
                task.setDescricao(resultSet.getString("descricao"));
                task.setNotas(resultSet.getString("notas"));
                task.setStatus(resultSet.getBoolean("status"));
                task.setPrazo(resultSet.getDate("prazo"));
                task.setDataCriacao(resultSet.getDate("dataCriacao"));
                task.setDataAtualizacao(resultSet.getDate("dataAtualizacao"));
                        
                tasks.add(task);
                
            }
        } catch (Exception ex) {
            
             throw new RuntimeException("Erro ao inserir a tarefa" +ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection( connection , statement , resultSet);
        }
        
        
        
        //lista de tarefas que foi criada e carregada no banco de dados
        return tasks;
   
    }

   
    
}
