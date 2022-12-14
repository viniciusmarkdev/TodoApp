/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;


public class TaskTableModel extends AbstractTableModel {
    
    String[] columns = {"Nome" , "Descricão" , "Prazo" , "Tarefa Concluída" , "Editar" , "Excluir"};
    List<Task>tasks = new ArrayList();

    @Override
    public int getRowCount() {
     
         return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return  columns.length;
    }
   
    @Override
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
       
        
            return true;
        
        
       
    }
    
   
     
     
     
     
    @Override
    public Class<?>getColumnClass(int columnIndex){
        
        if(tasks.isEmpty()){
            return Object.class;
        }
        
        return this.getValueAt(0,columnIndex).getClass();
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     
        switch(columnIndex){
            
            case 0:
                return tasks.get(rowIndex).getNome();
            case 1:
                return tasks.get(rowIndex).getDescricao();
            case 2: 
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getPrazo());
            case 3:
                return tasks.get(rowIndex).isStatus();      
            case 4 :
              return "";
            case 5 :
              return "";
            
            
            
            default:
                
                return "Dados não encontrados";
            
        }
    }
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex ,int columnIndex){
        
     
        
        if( columnIndex == 0){
            tasks.get(rowIndex).setNome((String) aValue);
          
        
        }
        if(columnIndex == 1){
          
             tasks.get(rowIndex).setDescricao((String) aValue);
            
        }
        if (columnIndex == 2){
            
             tasks.get(rowIndex).setPrazo((Date) aValue);
         
      
       
        if(columnIndex == 3){
               
             tasks.get(rowIndex).setStatus((boolean) aValue);
        }
        
      
       

     

    }
    
    
    }


    public String[] getColumns() {
        return columns;
    }

  
    

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
    
}
