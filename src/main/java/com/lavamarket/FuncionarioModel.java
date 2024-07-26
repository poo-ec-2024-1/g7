package com.lavamarket;

import javafx.beans.property.SimpleBooleanProperty;
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
    private final SimpleBooleanProperty selected;
    
    public FuncionarioModel(int id, String nome, String cpf, String telefone, String endereco, Double salario) {
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.cpf = new SimpleStringProperty(cpf);
        this.telefone = new SimpleStringProperty(telefone);
        this.endereco = new SimpleStringProperty(endereco);
        this.salario = new SimpleDoubleProperty(salario);
        this.selected = new SimpleBooleanProperty(false);
    }

    public int getId() {
        return this.id.get();
	}

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
		this.id.set(id);
	}

    public String getNome() {
		return this.nome.get();
	}

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getCpf() {
        return this.cpf.get();
    }

    public SimpleStringProperty cpfProperty() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public String getTelefone() {
        return this.telefone.get();
    }

    public SimpleStringProperty telefoneProperty() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }

    public String getEndereco() {
        return this.endereco.get();
    }

    public SimpleStringProperty enderecoProperty() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco.set(endereco);
    }

    public double getSalario() {
        return this.salario.get();
    }

    public SimpleDoubleProperty salarioProperty() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario.set(salario);
    }

    public boolean isSelected() {
        return this.selected.get();
    }

    public SimpleBooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }
    

}
