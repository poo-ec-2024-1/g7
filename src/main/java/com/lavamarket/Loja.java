package com.lavamarket;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "loja")
public class Loja {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String nome;

    @DatabaseField(unique = true)
    private String usuario;

    @DatabaseField
    private String senha;

    @DatabaseField
    private String cnpj;

    @DatabaseField
    private int precomedio = 0;

    @DatabaseField
    private String endereco;
    
    @DatabaseField
    private String servicos = "";

    @DatabaseField
    private int review = 0;

    public Loja(String nome, String usuario, String senha, String cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.usuario = usuario;
        this.senha = senha;
    }
    public Loja(){
        this.nome = "";
        this.cnpj = "";
        this.endereco = "";
        this.usuario = "";
        this.senha = "";
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public void setPrecomedio(int precomedio) {
        this.precomedio = precomedio;
    }
    public int getPrecomedio() {
        App.servicoRepository.loadAllFromLojaId(this.id);
        int contagem = 1;
        for (Servico s : App.servicoRepository.loadAll()) {
            precomedio += s.getValor();
            contagem++;
        }
        return this.precomedio/contagem;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getServicos() {
        return servicos;
    }
    public void setServicos(String servicos) {
        this.servicos = servicos;
    }
    public int getId() {
        return id;
    }
    public float getReview() {
        App.reviewRepository.loadAllFromLojaId(this.id);
        int contagem = 1;
        for (Review r : App.reviewRepository.loadAll()) {
            review += r.getReview();
            contagem++;
        }
        return this.review/contagem;
    }
    
}

