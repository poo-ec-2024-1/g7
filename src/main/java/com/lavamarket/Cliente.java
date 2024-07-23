package com.lavamarket;

public class Cliente extends Usuario {
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
}
