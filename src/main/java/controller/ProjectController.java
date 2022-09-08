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
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author Luis
 */
public class ProjectController {
    
    public void save(Project project){
        
      String sql = "INSERT INTO tb_projetos(nome, descricao, DataCriacao,DataAtualizacao ) VALUES (?, ?, ?, ?)";
       
       Connection connection = null;
       PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getNome());
            statement.setString(2,project.getDescricao());
            statement.setDate(3,new Date(project.getDataCriacao().getTime()));
            statement.setDate(4,new Date(project.getDataAtualizacao().getTime()));
            statement.execute();
       
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o projeto "+ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection(connection , statement);
        }
    }
    
    
    public void update( Project project){
      
        String sql = "UPDATE tb_projetos SET nome = ?, descricao= ?,DataCriacao  = ?, DataAtualizacao = ? WHERE id = ?";

        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
          
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getNome());
            statement.setString(2, project.getDescricao());
            statement.setDate(3, new Date(project.getDataCriacao().getTime() ));
            statement.setDate(4, new Date(project.getDataAtualizacao().getTime() ));
            statement.setInt(5, project.getId());
            //Executando a query
            statement.execute();
             } catch (Exception ex) {
                 
                     throw new RuntimeException("Erro ao atualizar o projeto" +ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection(connection , statement);
        }
        
        
        
        
        
    }
    public void removeById(int id) throws SQLException{
        
        String sql = "DELETE FROM tb_projetos WHERE id = ?";
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
   
    public List<Project>getAll(){
        
        
        String sql = "SELECT * FROM tb_projetos ";
      
       
        //Lista de tarefas que será devolvida quando a chamada do método acontecer     
        List<Project> projects = new ArrayList<>();
        
          
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        
        try {
            
            //Criação da conexão
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            //Setando o valor que corresponde ao filtro de busca
        
            
            //Valor retornado com o valor da query
            resultSet = statement.executeQuery();
            
            //Enquanto houverem  valores a serem percorridos no meu resultSet
            while(resultSet.next()){
                Project project= new Project();
                project.setId(resultSet.getInt("id"));
                project.setNome(resultSet.getString("nome"));
                project.setDescricao(resultSet.getString("descricao"));
                project.setDataCriacao(resultSet.getDate("dataCriacao"));
                project.setDataAtualizacao(resultSet.getDate("dataAtualizacao"));
                        
                projects.add(project);
                
            }
        } catch (Exception ex) {
            
             throw new RuntimeException("Erro ao buscar os projetos" +ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection( connection , statement , resultSet);
        }
        
        
        
        //lista de tarefas que foi criada e carregada no banco de dados
        return projects;
   
    }

    public void removeById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
    
}



