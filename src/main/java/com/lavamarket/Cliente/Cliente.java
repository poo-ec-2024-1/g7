/**
 * Classe Que gerencia o cliente e atribui atributos
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Cliente;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "cliente")
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

    /**
     * Metodo construtor da classe cliente
     * 
     * @param usuario
     * @param senha
     * @param nome
     * @param cpf
     * @param telefone
     * @param endereco
     */
    public Cliente(String usuario, String senha, String nome, String cpf, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.usuario = usuario;
        this.senha = senha;
    }

    /**
     * Metodo Construtor padrão para mitigar erros
     * 
     */
    public Cliente(){
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
        this.endereco = "";
    }

    /**
     * Getter do atributo usuario
     * 
     * @return
     */
    public String getUsuario(){
        return this.usuario;
    }

    /**
     * Getter da senha
     * 
     * @return
     */
    public String getSenha(){
        return this.senha;
    }

    /**
     * Getter do nome do usuario
     * 
     * @return
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Getter do cpf do usuario
     * 
     * @return
     */
    public String getCpf(){
        return this.cpf;
    }

    /**
     * Getter do telefone do usuario
     * 
     * @return
     */
    public String getTelefone(){
        return this.telefone;
    }

    /**
     * Getter do endereço do usuario
     * 
     * @return
     */
    public String getEndereco(){
        return this.endereco;
    }

    /**
     * Getter do Id do usuario
     * 
     * @return
     */
    public int getId(){
        return this.id;
    }

    /**
     * Setter do Usuario
     * 
     * @param usuario
     */
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    /**
     * Setter da senha do usuario
     * 
     * @param senha
     */
    public void setSenha(String senha){
        this.senha = senha;
    }

    /**
     * Setter do nome do usuario
     * 
     * @param nome
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Setter do cpf do usuario
     * 
     * @param cpf
     */
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    /**
     * Setter do telefone do usuario
     * 
     * @param telefone
     */
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    /**
     * Setter do endereço do usuario
     * 
     * @param endereco
     */
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    /**
     * Setter do id do funcionario
     * 
     * @param id
     */
    public void setId(int id){
        this.id = id;
    }
}
