package com.lavamarket;

import java.sql.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "agendamento")
public class Agendamento {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private int idCliente;
    @DatabaseField
    private int idLoja;
    @DatabaseField
    private int idVeiculo;
    @DatabaseField
    private int idServicos;
    @DatabaseField
    private Date data;

    public Agendamento(int idCliente, int idLoja, int idVeiculo, int idServicos, Date data) {
        this.idCliente = idCliente;
        this.idLoja = idLoja;
        this.idVeiculo = idVeiculo;
        this.idServicos = idServicos;
        this.data = data;
    }

    public Agendamento() {
        this.idCliente = 0;
        this.idLoja = 0;
        this.idVeiculo = 0;
        this.idServicos = 0;
        this.data = new Date(0);
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public int getIdServicos() {
        return idServicos;
    }

    public Date getData() {
        return data;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public void setIdServicos(int idServicos) {
        this.idServicos = idServicos;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
