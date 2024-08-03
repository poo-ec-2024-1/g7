package com.lavamarket;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClienteController {
    @FXML
    private TableView<VeiculoModel> tabelaVeiculos;
    @FXML
    private TableColumn<VeiculoModel, Integer> id;
    @FXML
    private TableColumn<VeiculoModel, String> placa;
    @FXML
    private TableColumn<VeiculoModel, String> marca;
    @FXML
    private TableColumn<VeiculoModel, String> modelo;
    @FXML
    private TableColumn<VeiculoModel, String> cor;
    @FXML
    private TableColumn<VeiculoModel, String> tipo;

    @FXML
    private TableView<Loja> tabelaLojas;
    @FXML
    private TableColumn<Loja, Integer> nomeLoja;
    @FXML
    private TableColumn<Loja, String> servicosLoja;
    @FXML
    private TableColumn<Loja, String> precomedioLoja;

    @FXML
    private TextField idField;
    @FXML
    private TextField placaField;
    @FXML
    private TextField marcaField;
    @FXML
    private TextField modeloField;
    @FXML
    private TextField corField;
    @FXML
    private TextField tipoField;

    private Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    List<VeiculoModel> veiculos = new ArrayList<>();

    ObservableList<VeiculoModel> veiculosObs;

    List<Loja> lojas = new ArrayList<>();

    ObservableList<Loja> lojasObs;
    
    @FXML
    private void startVeiculos(Event event) {
        id.setCellValueFactory(new PropertyValueFactory<VeiculoModel, Integer>("id"));
        placa.setCellValueFactory(new PropertyValueFactory<VeiculoModel, String>("placa"));
        marca.setCellValueFactory(new PropertyValueFactory<VeiculoModel, String>("marca"));
        modelo.setCellValueFactory(new PropertyValueFactory<VeiculoModel, String>("modelo"));
        cor.setCellValueFactory(new PropertyValueFactory<VeiculoModel, String>("cor"));
        tipo.setCellValueFactory(new PropertyValueFactory<VeiculoModel, String>("tipo"));
        loadVeiculos();
    }

    @FXML
    private void adicionarVeiculo(ActionEvent event) {
        try {
                Veiculo v = new Veiculo(placaField.getText(), marcaField.getText(), modeloField.getText(), corField.getText(), tipoField.getText(), cliente.getId());
                App.veiculoRepository.create(v);
                loadVeiculos();
        } catch (Exception e) {
            System.out.println("ERRO AO ADICIONAR FUNCIONARIO: " + e);
        }
    }

    @FXML
    private void removerVeiculo(ActionEvent event) {
        try {
            Veiculo v = App.veiculoRepository.loadFromId(Integer.parseInt(idField.getText()));
            App.veiculoRepository.delete(v);
            loadVeiculos();
        } catch (Exception e) {
            System.out.println("ERRO AO REMOVER FUNCIONARIO: " + e);
        }
    }

    @FXML
    private void updateVeiculo(ActionEvent event) {
        try {
            Veiculo v = App.veiculoRepository.loadFromId(Integer.parseInt(idField.getText()));
            v.setPlaca(placaField.getText());
            v.setMarca(marcaField.getText());
            v.setModelo(modeloField.getText());
            v.setCor(corField.getText());
            v.setTipo(tipoField.getText());
            App.veiculoRepository.update(v);
            loadVeiculos();
        } catch (Exception e) {
            System.out.println("ERRO AO EDITAR FUNCIONARIO: " + e);
        }
    }

    @FXML
    private void selectVeiculo(Event event) {
        try {
            Veiculo v = App.veiculoRepository.loadFromId(tabelaVeiculos.getSelectionModel().getSelectedItem().getId());
            idField.setText(String.valueOf(v.getId()));
            placaField.setText(v.getPlaca());
            marcaField.setText(v.getMarca());
            modeloField.setText(v.getModelo());
            corField.setText(v.getCor());
            tipoField.setText(v.getTipo());
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR FUNCIONARIO: "+e);
        }
    }

    private void loadVeiculos(){
        try{
            for (Veiculo v : App.veiculoRepository.loadAllFromClienteId(cliente.getId())) {
                VeiculoModel vm = new VeiculoModel(v.getId(), v.getPlaca(), v.getMarca(), v.getModelo(), v.getCor(), v.getTipo());
                veiculos.add(vm);
            }
            veiculosObs = FXCollections.observableArrayList(veiculos);
            tabelaVeiculos.setItems(veiculosObs);
            veiculos.clear();
        } catch (Exception e) {
            System.out.println("ERRO NA TABELA: "+e);
        }
    }

    @FXML
    private void startLojas(Event event) {
        nomeLoja.setCellValueFactory(new PropertyValueFactory<Loja, Integer>("id"));
        servicosLoja.setCellValueFactory(new PropertyValueFactory<Loja, String>("servicos"));
        precomedioLoja.setCellValueFactory(new PropertyValueFactory<Loja, String>("precomedio"));
        loadLojas();
    }

    private void loadLojas(){
        try{
            lojas = App.lojaRepository.loadAll();
            lojasObs = FXCollections.observableArrayList(lojas);
            tabelaLojas.setItems(lojasObs);
            lojas.clear();
        } catch (Exception e) {
            System.out.println("ERRO NA TABELA: " + e);
        }
    }
}
