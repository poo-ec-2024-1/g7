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

    //@DatabaseField
    //private String telefone;

    @DatabaseField
    private String endereco;
    
    //@DatabaseField
    //private String servicos;

    public Loja(String nome, String usuario, String senha, String cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.usuario = usuario;
        this.senha = senha;
    }
    public Loja(){
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
    /*public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }*/
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    /*public String getServicos() {
        return servicos;
    }
    public void setServicos(String servicos) {
        this.servicos = servicos;
    }*/
    public int getId() {
        return id;
    }
    
}
