package com.lavamarket;

import com.j256.ormlite.field.DatabaseField;

public class Funcionario {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String nome;

    @DatabaseField
    private String cpf;

    @DatabaseField
    private String telefone;

    @DatabaseField
    private String endereco;

    @DatabaseField
    private double salario;

    @DatabaseField
    private int lavajato_id;
    
    public Funcionario(){
    }
    public Funcionario(String nome, String cpf, String telefone, String endereco, double salario, int lavajato_id) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.salario = salario;
        this.lavajato_id = lavajato_id;
    }
    
    public int getId(){
        return this.id;
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
    public double getSalario(){
        return this.salario;
    }
    public int getlavajato_id(){
        return this.lavajato_id;
    }

}
