package com.lavamarket;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "veiculo")
public class Veiculo {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(unique = true)
    private String apelido;

    @DatabaseField(unique = true)
    private String placa;

    @DatabaseField
    private String marca;

    @DatabaseField
    private String modelo;

    @DatabaseField
    private String cor;
    
    @DatabaseField
    private String tipo;

    @DatabaseField
    private int cliente_id;

    public Veiculo(String apelido, String placa, String marca, String modelo, String cor, String tipo, int cliente_id) {
        this.apelido = apelido;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.tipo = tipo;
        this.cliente_id = cliente_id;
    }

    public Veiculo() {
        this.apelido = "";
        this.placa = "";
        this.marca = "";
        this.modelo = "";
        this.cor = "";
        this.tipo = "";
        this.cliente_id = 0;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}

