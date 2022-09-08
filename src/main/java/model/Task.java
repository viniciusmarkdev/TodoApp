/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis
 */
public class Task {
    
    private int id ;
    private int tb_projetos_id;
    private String nome;   
    private String descricao;
    private String notas;
    private boolean status;
    private Date prazo;
    private Date dataCriacao;
    private Date dataAtualizacao; 
   

    public Task(int id, int tb_projetos_id, String nome, String descricao, String notas, boolean status, Date prazo, Date dataCriacao, Date dataAtualizacao) {
        this.id = id;
        this.tb_projetos_id = tb_projetos_id;
        this.nome = nome;
        this.descricao = descricao;
        this.notas = notas;
        this.status = status;
        this.prazo = prazo;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
         
    }
    
    
     public Task() {
        this.status = false;
        this.dataCriacao = new Date();
        this.dataAtualizacao = new Date();
    }
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTb_projetos_id() {
        return tb_projetos_id;
    }

    public void setTb_projetos_id(int tb_projetos_id) {
        this.tb_projetos_id = tb_projetos_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", tb_projetos_id=" + tb_projetos_id + ", nome=" + nome + ", descricao=" + descricao + ", notas=" + notas + ", status=" + status + ", prazo=" + prazo + ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + '}';
    }
    
    
}
