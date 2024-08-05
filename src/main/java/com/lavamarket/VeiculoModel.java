/**
 * Classe Modelo do veiculo 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
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
    
    /**
     * Metodo construtor do modelo do veiculo
     * 
     * @param apelido
     * @param id
     * @param placa
     * @param marca
     * @param modelo
     * @param cor
     * @param tipo
     */
    public VeiculoModel(String apelido, int id, String placa, String marca, String modelo, String cor, String tipo) {
        this.apelido = new SimpleStringProperty(apelido);
        this.id = new SimpleIntegerProperty(id);
        this.placa = new SimpleStringProperty(placa);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.cor = new SimpleStringProperty(cor);
        this.tipo = new SimpleStringProperty(tipo);
    }

    /**
     * Metodo construtor padrão do veiculo
     * 
     */
    public VeiculoModel() {
        this.apelido = new SimpleStringProperty();
        this.placa = new SimpleStringProperty();
        this.marca = new SimpleStringProperty();
        this.modelo = new SimpleStringProperty();
        this.cor = new SimpleStringProperty();
        this.tipo = new SimpleStringProperty();
    }

    /**
     * Metodo que retorna o id do veiculo
     * 
     * @return
     */
    public int getId() {
        return this.id.get();
	}

    /**
     * Metodo que retorna a propriedade do id
     * 
     * @return
     */
    public SimpleIntegerProperty idProperty() {
        return id;
    }

    /**
     * Metodo que altera o id do veiculo
     * 
     * @param id
     */
    public void setId(int id) {
		this.id.set(id);
	}

    /**
     * Metodo que retorna a placa do veiculo
     * 
     * @return
     */
    public String getPlaca() {
		return this.placa.get();
	}

    /**
     * Metodo que retorna a propriedade da placa do veiculo
     * 
     * @return
     */
    public SimpleStringProperty placaProperty() {
        return placa;
    }

    /**
     * Metodo que altera a placa do veiculo
     * 
     * @param placa
     */
    public void setPlaca(String placa) {
        this.placa.set(placa);
    }

    /**
     * Metood que retorna a Marca do veiculo
     * 
     * @return
     */
    public String getMarca() {
        return this.marca.get();
    }

    /**
     * Metodo que retorna a propriedade da marca do veiculo
     * 
     * @return
     */
    public SimpleStringProperty marcaProperty() {
        return marca;
    }

    /**
     * Metodo que altera a marca do veiculo
     * 
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    /**
     * Metodo que retorna o modelo do veiculo
     * 
     * @return
     */
    public String getModelo() {
        return this.modelo.get();
    }

    /**
     * Metodo que retorna a propriedade do modelo do veiculo
     * 
     * @return
     */
    public SimpleStringProperty modeloProperty() {
        return modelo;
    }

    /**
     * Metodo que altera o modelo do veiculo
     * 
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo.set(modelo);
    }

    /**
     * Metodo que retorna a cor do veiculo
     * 
     * @return
     */
    public String getCor() {
        return this.cor.get();
    }

    /**
     * Metodo que retorna a pripriedade da cor do veiculo
     * 
     * @return
     */
    public SimpleStringProperty corProperty() {
        return cor;
    }

    /**
     * Metodo que altera a cor do veiculo
     * 
     * @param cor
     */
    public void setCor(String cor) {
        this.cor.set(cor);
    }

    /**
     * Metodo quer retorna o tipo do veiculo
     * 
     * @return
     */
    public String getTipo() {
        return this.tipo.get();
    }

    /**
     * Metodo que retorna a propriedade do tipo do veiculo
     * 
     * @return
     */
    public SimpleStringProperty tipoProperty() {
        return tipo;
    }

    /**
     * Metodo que altera o tipo do veiculo
     * 
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    /**
     * Getter do apelido do veiculo
     * 
     * @return
     */
    public String getApelido() {
        return this.apelido.get();
    }

    /**
     * Getter da propriedade do apelido do veiculo
     * 
     * @return
     */
    public SimpleStringProperty apelidoProperty() {
        return apelido;
    }

    /**
     * Metodo que altera o apelido do veiculo
     * 
     * @param apelido
     */
    public void setApelido(String apelido) {
        this.apelido.set(apelido);
    }
}
