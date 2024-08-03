package com.lavamarket;

import com.j256.ormlite.field.DatabaseField;

public class Cliente {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(unique = true)
    private String usuario;

    @DatabaseField
    private String senha;

    @DatabaseField
    private String nome;

    @DatabaseField
    private String cpf;

    @DatabaseField
    private String telefone;

    @DatabaseField
    private String endereco;

    public Cliente(String usuario, String senha, String nome, String cpf, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.usuario = usuario;
        this.senha = senha;
    }
    public Cliente(){
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
        this.endereco = "";
    }

    public String getUsuario(){
        return this.usuario;
    }
    public String getSenha(){
        return this.senha;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCpf(){
        return this.cpf;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public String getEndereco(){
        return this.endereco;
    }
    public int getId(){
        return this.id;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setId(int id){
        this.id = id;
    }
}
