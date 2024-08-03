package com.lavamarket;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "funcionario")
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
    
    public Funcionario(String nome, String cpf, String telefone, String endereco, double salario, int lavajato_id) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.salario = salario;
        this.lavajato_id = lavajato_id;
    }

    public Funcionario(){
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
        this.endereco = "";
        this.salario = 0;
        this.lavajato_id = 0;
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
    public void setId(int id){
        this.id = id;
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
    public void setSalario(double salario){
        this.salario = salario;
    }
    public void setlavajato_id(int lavajato_id){
        this.lavajato_id = lavajato_id;
    }
}
