/**
 * Classe que armazena os atributos da classe funcionario 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
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
    
    /**
     * Metodo que constroi a classe funcionario
     * 
     * @param nome
     * @param cpf
     * @param telefone
     * @param endereco
     * @param salario
     * @param lavajato_id
     */
    public Funcionario(String nome, String cpf, String telefone, String endereco, double salario, int lavajato_id) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.salario = salario;
        this.lavajato_id = lavajato_id;
    }

    /**
     * Classe construtora padrão do funcionario
     * 
     */
    public Funcionario(){
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
        this.endereco = "";
        this.salario = 0;
        this.lavajato_id = 0;
    }
    
    /**
     * Getter do id do funcionario
     * 
     * @return
     */
    public int getId(){
        return this.id;
    }

    /**
     * Getter do nome do funcionario
     * 
     * @return
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Getter do cpf do Funcionario
     * 
     * @return
     */
    public String getCpf(){
        return this.cpf;
    }

    /**
     * Getter do telefone do funcionario
     * 
     * @return
     */
    public String getTelefone(){
        return this.telefone;
    }

    /**
     * Getter que retorna o endereço do funcionario
     * 
     * @return
     */
    public String getEndereco(){
        return this.endereco;
    }

    /**
     * Getter que retorna o salario do usuario
     * 
     * @return
     */
    public double getSalario(){
        return this.salario;
    }

    /**
     * Getter que retorna o id do lava jato
     * 
     * @return
     */
    public int getlavajato_id(){
        return this.lavajato_id;
    }

    /**
     * Setter do id do funcionario
     * 
     * @param id
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Setter do nome do funcionario
     * 
     * @param nome
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Setter do cpf do funcionario
     * 
     * @param cpf
     */
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    /**
     * Setter do telefone do funcionario
     * 
     * @param telefone
     */
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    /**
     * setter do endereço do funcionario
     * 
     * @param endereco
     */
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    /**
     * Setter do salario do funcionario
     * 
     * @param salario
     */
    public void setSalario(double salario){
        this.salario = salario;
    }

    /**
     * Setter do id do lavajato o qual o funcionario trabalha
     * 
     * @param lavajato_id
     */
    public void setlavajato_id(int lavajato_id){
        this.lavajato_id = lavajato_id;
    }
}
