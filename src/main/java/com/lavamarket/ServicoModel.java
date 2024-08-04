package com.lavamarket;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ServicoModel {
    private final SimpleStringProperty nomePacote;
    private final SimpleFloatProperty valorCarro;
    private final SimpleIntegerProperty id;
    private final SimpleFloatProperty valorMoto;
    private final SimpleFloatProperty valorCaminhao;

    public ServicoModel(int id, String nomePacote, Float valorCarro, Float valorMoto, Float valorCaminhao) {
        this.id = new SimpleIntegerProperty(id);
        this.nomePacote = new SimpleStringProperty(nomePacote);
        this.valorCarro = new SimpleFloatProperty(valorCarro);
        this.valorMoto = new SimpleFloatProperty(valorMoto);
        this.valorCaminhao = new SimpleFloatProperty(valorCaminhao);
    }

    public String getNomePacote() {
        return nomePacote.get();
    }

    public void setNomePacote(String nomePacote) {
        this.nomePacote.set(nomePacote);
    }

    public float getValorCarro() {
        return valorCarro.get();
    }

    public void setValorCarro(float valorCarro) {
        this.valorCarro.set(valorCarro);
    }

    public SimpleStringProperty nomePacoteProperty() {
        return nomePacote;
    }

    public SimpleFloatProperty valorCarroProperty() {
        return valorCarro;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public float getValorMoto() {
        return valorMoto.get();
    }

    public SimpleFloatProperty valorMotoProperty() {
        return valorMoto;
    }

    public void setValorMoto(float valorMoto) {
        this.valorMoto.set(valorMoto);
    }

    public float getValorCaminhao() {
        return valorCaminhao.get();
    }

    public SimpleFloatProperty valorCaminhaoProperty() {
        return valorCaminhao;
    }

    public void setValorCaminhao(float valorCaminhao) {
        this.valorCaminhao.set(valorCaminhao);
    }
}
