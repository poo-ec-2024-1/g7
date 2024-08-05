/**
 * Classe Modelo do funcionario  
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FuncionarioModel  {
    private final SimpleIntegerProperty id;

    private final SimpleStringProperty nome;

    private final SimpleStringProperty cpf;

    private final SimpleStringProperty telefone;

    private final SimpleStringProperty endereco;

    private final SimpleDoubleProperty salario;

    /**
     * Classe construtora do modelo do funcionario
     * 
     * @param id
     * @param nome
     * @param cpf
     * @param telefone
     * @param endereco
     * @param salario
     */
    public FuncionarioModel(int id, String nome, String cpf, String telefone, String endereco, double salario) {
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.cpf = new SimpleStringProperty(cpf);
        this.telefone = new SimpleStringProperty(telefone);
        this.endereco = new SimpleStringProperty(endereco);
        this.salario = new SimpleDoubleProperty(salario);
    }

    /**
     * Classe construtora padrão do funcionario 
     * 
     */
    public FuncionarioModel() {
        this.id = new SimpleIntegerProperty();
        this.nome = new SimpleStringProperty();
        this.cpf = new SimpleStringProperty();
        this.telefone = new SimpleStringProperty();
        this.endereco = new SimpleStringProperty();
        this.salario = new SimpleDoubleProperty();
    }

    /**
     * Getter do id da classe
     * 
     * @return
     */
    public int getId() {
        return this.id.get();
	}

    /**
     * retorna o id da propriedade
     * 
     * @return
     */
    public SimpleIntegerProperty idProperty() {
        return id;
    }

    /**
     * Seta o id do funcionarioModel
     * 
     * @param id
     */
    public void setId(int id) {
		this.id.set(id);
	}

    /**
     * 
     * pega o nome do funcionario
     * @return
     */
    public String getNome() {
		return this.nome.get();
	}

    /**
     * Getter do nome do funcionario
     * 
     * @return
     */
    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    /**
     * Altera o nome do funcionario
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome.set(nome);
    }

    /**
     * Retorna o cpf do funcionario
     * 
     * @return
     */
    public String getCpf() {
        return this.cpf.get();
    }

    /**
     * Retorna o CPF do funcionario
     * 
     * @return
     */
    public SimpleStringProperty cpfProperty() {
        return cpf;
    }

    /**
     * Altera o numero de cpf do funcionario
     * 
     * @param cpf
     */
    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    /**
     * Altera o numero de telefone do funcionario
     * 
     * @return
     */
    public String getTelefone() {
        return this.telefone.get();
    }

    /**
     * Altera a propriedade telefone do funcionario
     * 
     * @return
     */
    public SimpleStringProperty telefoneProperty() {
        return telefone;
    }

    /**
     * Setter do telefone do funcionario
     * 
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }

    /**
     * Retorna o endereço do funcionario
     * 
     * @return
     */
    public String getEndereco() {
        return this.endereco.get();
    }

    /**
     * Retorna a propriedade endereço do funcionario
     * 
     * @return
     */
    public SimpleStringProperty enderecoProperty() {
        return endereco;
    }

    /**
     * Setter do endereço do funcionario
     * 
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco.set(endereco);
    }

    /**
     * Getter do salario do funcionario model
     * 
     * @return
     */
    public double getSalario() {
        return this.salario.get();
    }

    /**
     * Retorna a propriedade do salario do funcionario
     * 
     * @return
     */
    public SimpleDoubleProperty salarioProperty() {
        return salario;
    }

    /**
     * Setter do salario do funcionario
     * 
     * @param salario
     */
    public void setSalario(double salario) {
        this.salario.set(salario);
    }
}
