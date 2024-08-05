/**
 * Classe que controla o modelo da janela de serviços 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Serviço;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ServicoModel {
    private final SimpleStringProperty nomePacote;
    private final SimpleFloatProperty valorCarro;
    private final SimpleIntegerProperty id;
    private final SimpleFloatProperty valorMoto;
    private final SimpleFloatProperty valorCaminhao;

    /**
     * Metodo construtor da classe Seviço
     * 
     * @param id
     * @param nomePacote
     * @param valorCarro
     * @param valorMoto
     * @param valorCaminhao
     */
    public ServicoModel(int id, String nomePacote, Float valorCarro, Float valorMoto, Float valorCaminhao) {
        this.id = new SimpleIntegerProperty(id);
        this.nomePacote = new SimpleStringProperty(nomePacote);
        this.valorCarro = new SimpleFloatProperty(valorCarro);
        this.valorMoto = new SimpleFloatProperty(valorMoto);
        this.valorCaminhao = new SimpleFloatProperty(valorCaminhao);
    }

    /**
     * Metodo que retorna o nome do pacote
     * 
     * @return
     */
    public String getNomePacote() {
        return nomePacote.get();
    }

    /**
     * Metodo que altera o nome do pacote
     * 
     * @param nomePacote
     */
    public void setNomePacote(String nomePacote) {
        this.nomePacote.set(nomePacote);
    }

    /**
     * Metodo retorna o valor da lavagem do carro
     * 
     * @return
     */
    public float getValorCarro() {
        return valorCarro.get();
    }

    /**
     * Metodo que altera o valor da lavagem do carro
     * 
     * @param valorCarro
     */
    public void setValorCarro(float valorCarro) {
        this.valorCarro.set(valorCarro);
    }

    /**
     * Metodo que retorna a propriedade do pacote
     * 
     * @return
     */
    public SimpleStringProperty nomePacoteProperty() {
        return nomePacote;
    }

    /**
     * Metodo que retorna a propriedade do valor da lavagem do veiculo
     * 
     * @return
     */
    public SimpleFloatProperty valorCarroProperty() {
        return valorCarro;
    }

    /**
     * Metodo que retorna o id do serviço
     * 
     * @return
     */
    public int getId() {
        return id.get();
    }

    /**
     * Metodo que retorna o a propriedade do id
     * 
     * @return
     */
    public SimpleIntegerProperty idProperty() {
        return id;
    }

    /**
     * metodo que altera o id
     * 
     * @param id
     */
    public void setId(int id) {
        this.id.set(id);
    }

    /**
     * Metodo que retorna o valor da lavagem de moto
     * 
     * @return
     */
    public float getValorMoto() {
        return valorMoto.get();
    }

    /**
     * Metodo que retorna a propriedade do valor da lavagem da moto
     * 
     * @return
     */
    public SimpleFloatProperty valorMotoProperty() {
        return valorMoto;
    }

    /**
     * Metodo que altera o valor da lavagem da moto
     * 
     * @param valorMoto
     */
    public void setValorMoto(float valorMoto) {
        this.valorMoto.set(valorMoto);
    }

    /**
     * Metodo que retorna o valor da lavagem do caminhão
     * 
     * @return
     */
    public float getValorCaminhao() {
        return valorCaminhao.get();
    }

    /**
     * Metodo que retorna a propriedade do valor da lavgem do caminhão
     * 
     * @return
     */
    public SimpleFloatProperty valorCaminhaoProperty() {
        return valorCaminhao;
    }

    /**
     * Metodo que altera o valor da lavagem de caminhão
     * 
     * @param valorCaminhao
     */
    public void setValorCaminhao(float valorCaminhao) {
        this.valorCaminhao.set(valorCaminhao);
    }
}
