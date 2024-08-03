package com.lavamarket;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ClienteController {
    @FXML
    private TableView<VeiculoModel> tabelaVeiculos;
    @FXML
    private TableColumn<VeiculoModel, Integer> id;
    @FXML
    private TableColumn<VeiculoModel, String> apelido;
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
    private TableView<LojaModel> tabelaLojas;
    @FXML
    private TableColumn<LojaModel, Integer> nomeLoja;
    @FXML
    private TableColumn<LojaModel, String> precomedioLoja;
    @FXML
    private TableColumn<LojaModel, Float> reviewLoja;

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
    @FXML
    private TextField apelidoField;

    private Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    List<VeiculoModel> veiculos = new ArrayList<>();

    ObservableList<VeiculoModel> veiculosObs;

    List<LojaModel> lojas = new ArrayList<>();

    ObservableList<LojaModel> lojasObs;
    
    @FXML
    private void startVeiculos(Event event) {
        id.setCellValueFactory(new PropertyValueFactory<VeiculoModel, Integer>("id"));
        apelido.setCellValueFactory(new PropertyValueFactory<VeiculoModel, String>("apelido")); 
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
                Veiculo v = new Veiculo(apelidoField.getText(), placaField.getText(), marcaField.getText(), modeloField.getText(), corField.getText(), tipoField.getText(), cliente.getId());
                App.veiculoRepository.create(v);
                loadVeiculos();
                clear();
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
            v.setApelido(apelidoField.getText());
            App.veiculoRepository.update(v);
            loadVeiculos();
            clear();
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
            apelidoField.setText(v.getApelido());
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR FUNCIONARIO: "+e);
        }
    }

    private void loadVeiculos(){
        try{
            for (Veiculo v : App.veiculoRepository.loadAllFromClienteId(cliente.getId())) {
                VeiculoModel vm = new VeiculoModel(v.getApelido(), v.getId(), v.getPlaca(), v.getMarca(), v.getModelo(), v.getCor(), v.getTipo());
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
        nomeLoja.setCellValueFactory(new PropertyValueFactory<LojaModel, Integer>("nome"));
        reviewLoja.setCellValueFactory(new PropertyValueFactory<LojaModel, Float>("review"));
        precomedioLoja.setCellValueFactory(new PropertyValueFactory<LojaModel, String>("precomedio"));

        loadLojas();
    }

    private void loadLojas(){
        try{
            
            for (Loja l : App.lojaRepository.loadAll()) {
                LojaModel lm = new LojaModel(l.getNome(), l.getReview(), l.getPrecomedio(), l.getId());
                lojas.add(lm);
            }
            lojasObs = FXCollections.observableArrayList(lojas);
            tabelaLojas.setItems(lojasObs);
            lojas.clear();
        } catch (Exception e) {
            System.out.println("ERRO NA TABELA: " + e);
        }
    }

    @FXML
    private void selectLoja(Event event) {
        try {
            Loja l = App.lojaRepository.loadFromId(tabelaLojas.getSelectionModel().getSelectedItem().getId());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("selectedLoja.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            SelectedLojaController controller = loader.getController();
            controller.setLoja(l);
            controller.setCliente(cliente);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR LOJA: "+e);
        }
    }

    private void clear(){
        idField.clear();
        placaField.clear();
        marcaField.clear();
        modeloField.clear();
        corField.clear();
        tipoField.clear();
        apelidoField.clear();
    }
}
