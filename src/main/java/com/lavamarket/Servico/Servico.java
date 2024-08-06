/**
 * Classe Que contem os atrubutos da classe serviço 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Servico;

import com.j256.ormlite.field.DatabaseField;

public class Servico {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(unique = true)
    private String nomePacote;
    @DatabaseField
    private float valorCarro;
    @DatabaseField
    private float valorMoto;
    @DatabaseField
    private float valorCaminhao;
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

    /**
     * Metodo construtor da classe serviço
     * 
     * @param nomePacote
     * @param valorCarro
     * @param valorMoto
     * @param valorCaminhao
     * @param lavajato_Id
     * @param lavagemc
     * @param lavagems
     * @param lavagemt
     * @param cerap
     * @param ceran
     * @param outros
     * @param infoadicional
     */
    public Servico(String nomePacote, float valorCarro, float valorMoto, float valorCaminhao, int lavajato_Id, Boolean lavagemc, Boolean lavagems, Boolean lavagemt, Boolean cerap, Boolean ceran, Boolean outros, String infoadicional) {
        this.nomePacote = nomePacote;
        this.valorCarro = valorCarro;
        this.valorMoto = valorMoto;
        this.valorCaminhao = valorCaminhao;
        this.lavajato_Id = lavajato_Id;
        this.lavagemc = lavagemc;
        this.lavagems = lavagems;
        this.lavagemt = lavagemt;
        this.cerap = cerap;
        this.ceran = ceran;
        this.outros = outros;
        this.infoadicional = infoadicional;
    }
    
    /**
     * Metodo Construtor padrão da classe serviço
     * 
     */
    public Servico() {
        this.nomePacote = "";
        this.valorMoto = 0;
        this.valorCarro = 0;
        this.valorCaminhao = 0;
        this.lavajato_Id = 0;
        this.lavagemc = false;
        this.lavagems = false;
        this.lavagemt = false;
        this.cerap = false;
        this.ceran = false;
        this.outros = false;
        this.infoadicional = "";
    }

    /**
     * Metodo que retorna o id do serviço
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que altera o id do serviço
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo que retorna o nome do pacote
     * 
     * @return
     */
    public String getNomePacote() {
        return nomePacote;
    }

    /**
     * Metodo que altera o nome do pacote
     * 
     * @param nomePacote
     */
    public void setNomePacote(String nomePacote) {
        this.nomePacote = nomePacote;
    }
    
    /**
     * Metodo que retorna o id do lavajato
     * 
     * @return
     */
    public int getLavajato_Id() {
        return lavajato_Id;
    }

    /**
     * Metodo que altera o id do lava jato
     * 
     * @param lavajato_Id
     */
    public void setLavajato_Id(int lavajato_Id) {
        this.lavajato_Id = lavajato_Id;
    }

    /**
     * Metodo que verifica se é lavagem completa 
     * 
     * @return
     */
    public boolean isLavagemc() {
        return lavagemc;
    }

    /**
     * metodo que altera pra lavagem copleta
     * 
     * @param lavagemc
     */
    public void setLavagemc(boolean lavagemc) {
        this.lavagemc = lavagemc;
    }

    /**
     * Metodo que retorna se é lavagem simples
     * 
     * @return
     */
    public boolean isLavagems() {
        return lavagems;
    }

    /**
     * Metodo que altera lavagem simples
     * 
     * @param lavagems
     */
    public void setLavagems(boolean lavagems) {
        this.lavagems = lavagems;
    }

    /**
     * Metodo que altera pra lavagem mt
     * 
     * @return
     */
    public boolean isLavagemt() {
        return lavagemt;
    }

    /**
     * Metodo que altera pra lavagem mt
     * 
     * @param lavagemt
     */
    public void setLavagemt(boolean lavagemt) {
        this.lavagemt = lavagemt;
    }

    /**
     * Metodo getter para cera plastica
     * 
     * @return
     */
    public boolean isCerap() {
        return cerap;
    }

    /**
     * Metodo setter da cera plastica
     * 
     * @param cerap
     */
    public void setCerap(boolean cerap) {
        this.cerap = cerap;
    }

    /**
     * Metodo  getter para cera simples
     * 
     * @return
     */
    public boolean isCeran() {
        return ceran;
    }

    /**
     * Metodo setter para cera simples
     * 
     * @param ceran
     */
    public void setCeran(boolean ceran) {
        this.ceran = ceran;
    }

    /**
     * Metodo getter para outros itens
     * 
     * @return
     */
    public boolean isOutros() {
        return outros;
    }

    /**
     * Metodo setter dos outros itens
     * 
     * @param outros
     */
    public void setOutros(boolean outros) {
        this.outros = outros;
    }

    /**
     * metodo que retorna informações adicionais
     * 
     * @return
     */
    public String getInfoadicional() {
        return infoadicional;
    }

    /**
     * Metodo que altera informações adicionais
     * 
     * @param infoadicional
     */
    public void setInfoadicional(String infoadicional) {
        this.infoadicional = infoadicional;
    }

    /**
     * Metodo que retorna valor da lavagem do carro
     * 
     * @return
     */
    public float getValorCarro() {
        return valorCarro;
    }

    /**
     * Metodo que altera o valor da lavagem do carro
     * 
     * @param valorCarro
     */
    public void setValorCarro(float valorCarro) {
        this.valorCarro = valorCarro;
    }

    /**
     * Metodo que retorna o valor da lavagem da moto
     * 
     * @return
     */
    public float getValorMoto() {
        return valorMoto;
    }

    /**
     * Metodo que altera o valor da lavagem da moto
     * 
     * @param valorMoto
     */
    public void setValorMoto(float valorMoto) {
        this.valorMoto = valorMoto;
    }

    /**
     * Metodo que retorna o valor da lavagem de caminhão
     * 
     * @return
     */
    public float getValorCaminhao() {
        return valorCaminhao;
    }

    /**
     * Metodo que altera o valor da lavagem do caminhão
     * 
     * @param valorCaminhao
     */
    public void setValorCaminhao(float valorCaminhao) {
        this.valorCaminhao = valorCaminhao;
    }
}
