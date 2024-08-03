package com.lavamarket;

import com.j256.ormlite.field.DatabaseField;

public class Servico {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nomePacote;
    @DatabaseField
    private float valor;
    @DatabaseField
    private int lavajato_Id;
    @DatabaseField
    private boolean lavagemc;
    @DatabaseField
    private boolean lavagems;
    @DatabaseField
    private boolean lavagemt;
    @DatabaseField
    private boolean cerap;
    @DatabaseField
    private boolean ceran;
    @DatabaseField
    private boolean outros;
    @DatabaseField
    private String infoadicional;

    public Servico(String nomePacote, float valor, int lavajato_Id, Boolean lavagemc, Boolean lavagems, Boolean lavagemt, Boolean cerap, Boolean ceran, Boolean outros, String infoadicional) {
        this.nomePacote = nomePacote;
        this.valor = valor;
        this.lavajato_Id = lavajato_Id;
        this.lavagemc = lavagemc;
        this.lavagems = lavagems;
        this.lavagemt = lavagemt;
        this.cerap = cerap;
        this.ceran = ceran;
        this.outros = outros;
        this.infoadicional = infoadicional;
    }
    
    public Servico() {
        this.nomePacote = "";
        this.valor = 0;
        this.lavajato_Id = 0;
        this.lavagemc = false;
        this.lavagems = false;
        this.lavagemt = false;
        this.cerap = false;
        this.ceran = false;
        this.outros = false;
        this.infoadicional = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePacote() {
        return nomePacote;
    }

    public void setNomePacote(String nomePacote) {
        this.nomePacote = nomePacote;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getLavajato_Id() {
        return lavajato_Id;
    }

    public void setLavajato_Id(int lavajato_Id) {
        this.lavajato_Id = lavajato_Id;
    }

    public boolean isLavagemc() {
        return lavagemc;
    }

    public void setLavagemc(boolean lavagemc) {
        this.lavagemc = lavagemc;
    }

    public boolean isLavagems() {
        return lavagems;
    }

    public void setLavagems(boolean lavagems) {
        this.lavagems = lavagems;
    }

    public boolean isLavagemt() {
        return lavagemt;
    }

    public void setLavagemt(boolean lavagemt) {
        this.lavagemt = lavagemt;
    }

    public boolean isCerap() {
        return cerap;
    }

    public void setCerap(boolean cerap) {
        this.cerap = cerap;
    }

    public boolean isCeran() {
        return ceran;
    }

    public void setCeran(boolean ceran) {
        this.ceran = ceran;
    }

    public boolean isOutros() {
        return outros;
    }

    public void setOutros(boolean outros) {
        this.outros = outros;
    }

    public String getInfoadicional() {
        return infoadicional;
    }

    public void setInfoadicional(String infoadicional) {
        this.infoadicional = infoadicional;
    }
}
