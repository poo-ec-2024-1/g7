package com.lavamarket;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class LojaController {
    @FXML
    private TableView<Funcionario> tabelaFuncionarios;
    @FXML
    private TableColumn<Funcionario, Integer> id;
    @FXML
    private TableColumn<Funcionario, String> nome;
    @FXML
    private TableColumn<Funcionario, String> cpf;
    @FXML
    private TableColumn<Funcionario, String> telefone;
    @FXML
    private TableColumn<Funcionario, String> endereco;
    @FXML
    private TableColumn<Funcionario, Double> salario;

    @FXML
    private TextField idField;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField cpfField;
    @FXML
    private TextField telefoneField;
    @FXML
    private TextField enderecoField;
    @FXML
    private TextField salarioField;
    @FXML
    private Label erro;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    List<Funcionario> funcionarios = new ArrayList<>();

    ObservableList<Funcionario> funcionariosObs;

    
    @FXML
    public void listaFuncionarios(Event event) {
        id.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
        cpf.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cpf"));
        telefone.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("telefone"));
        endereco.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("endereco"));
        salario.setCellValueFactory(new PropertyValueFactory<Funcionario, Double>("salario"));
        
        try{
        Loja loja = (Loja) stage.getUserData();
        List<Funcionario> funcionarios = new ArrayList<>();

        for (Funcionario f : App.funcionarioRepository.loadAllFromLojaId(loja.getId())) {
            funcionarios.add(f);
        }
        
        funcionariosObs = FXCollections.observableArrayList(funcionarios);
        tabelaFuncionarios.setItems(funcionariosObs);
        } catch (Exception e) {
            System.out.println("ERRO NA TABELA: "+e);
        }
    }
    @FXML
    private void adicionarFuncionario(ActionEvent event) {
        try {
            Loja loja = (Loja) stage.getUserData();
            try{
                Funcionario f = new Funcionario(nomeField.getText(), cpfField.getText(), telefoneField.getText(), enderecoField.getText(), Double.parseDouble(salarioField.getText()), loja.getId());
                App.funcionarioRepository.create(f);
                listaFuncionarios(null);
            } catch (NumberFormatException e) {
                erro.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO ADICIONAR FUNCIONARIO: " + e);
        }
    }
}
