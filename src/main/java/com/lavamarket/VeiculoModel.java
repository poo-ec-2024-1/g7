package com.lavamarket;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class VeiculoModel  {
    private SimpleIntegerProperty id;

    private final SimpleStringProperty placa;

    private final SimpleStringProperty marca;

    private final SimpleStringProperty modelo;

    private final SimpleStringProperty cor;

    private final SimpleStringProperty tipo;

    private final SimpleStringProperty apelido;
    
    public VeiculoModel(String apelido, int id, String placa, String marca, String modelo, String cor, String tipo) {
        this.apelido = new SimpleStringProperty(apelido);
        this.id = new SimpleIntegerProperty(id);
        this.placa = new SimpleStringProperty(placa);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.cor = new SimpleStringProperty(cor);
        this.tipo = new SimpleStringProperty(tipo);
    }

    public VeiculoModel() {
        this.apelido = new SimpleStringProperty();
        this.placa = new SimpleStringProperty();
        this.marca = new SimpleStringProperty();
        this.modelo = new SimpleStringProperty();
        this.cor = new SimpleStringProperty();
        this.tipo = new SimpleStringProperty();
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

    public String getPlaca() {
		return this.placa.get();
	}

    public SimpleStringProperty placaProperty() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa.set(placa);
    }

    public String getMarca() {
        return this.marca.get();
    }

    public SimpleStringProperty marcaProperty() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    public String getModelo() {
        return this.modelo.get();
    }

    public SimpleStringProperty modeloProperty() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo.set(modelo);
    }

    public String getCor() {
        return this.cor.get();
    }

    public SimpleStringProperty corProperty() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor.set(cor);
    }

    public String getTipo() {
        return this.tipo.get();
    }

    public SimpleStringProperty tipoProperty() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public String getApelido() {
        return this.apelido.get();
    }

    public SimpleStringProperty apelidoProperty() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido.set(apelido);
    }
}
