package com.lavamarket;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class LojaController  {
    @FXML
    private TableView<FuncionarioModel> tabelaFuncionarios;
    @FXML
    private TableColumn<FuncionarioModel, Integer> id;
    @FXML
    private TableColumn<FuncionarioModel, String> nome;
    @FXML
    private TableColumn<FuncionarioModel, String> cpf;
    @FXML
    private TableColumn<FuncionarioModel, String> telefone;
    @FXML
    private TableColumn<FuncionarioModel, String> endereco;
    @FXML
    private TableColumn<FuncionarioModel, Double> salario;
    
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
    @FXML
    private Button atualizarFuncionarioButton;
    
    @FXML 
    private TableView<ServicoModel> tabelaServicos;
    @FXML
    private TableColumn<ServicoModel, String> nomePacote;
    @FXML
    private TableColumn<ServicoModel, Float> valorCarro;
    @FXML
    private TableColumn<ServicoModel, Float> valorMoto;
    @FXML
    private TableColumn<ServicoModel, Float> valorCaminhao;

    @FXML
    private CheckBox lavagemc;
    @FXML
    private CheckBox lavagems;
    @FXML
    private CheckBox lavagemt;
    @FXML
    private CheckBox cerap;
    @FXML
    private CheckBox ceran;
    @FXML
    private CheckBox outros;
    @FXML
    private TextField infoadicionalField;
    @FXML
    private TextField nomeServicoField;
    @FXML
    private TextField valorCarroField;
    @FXML
    private TextField valorMotoField;
    @FXML
    private TextField valorCaminhaoField;
    @FXML
    private TextField servicoIDField;
    @FXML
    private Label erroServico;
    @FXML
    private Button atualizarServicoButton;
    @FXML
    private Label valoresNulos;
    @FXML
    private Label nomeErro;
    @FXML
    private Label cpfErro;
    @FXML
    private Label telefoneErro;
    @FXML
    private Label valoresNulosServicos;
    @FXML
    private Label erroCheckbox;



    private Loja loja;

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    List<FuncionarioModel> funcionarios = new ArrayList<>();

    ObservableList<FuncionarioModel> funcionariosObs;

    List<ServicoModel> servicos = new ArrayList<>();

    ObservableList<ServicoModel> servicosObs;

    @FXML
    private void startFuncionarios(Event event) {
        id.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, Integer>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, String>("nome"));
        cpf.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, String>("cpf"));
        telefone.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, String>("telefone"));
        endereco.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, String>("endereco"));
        salario.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, Double>("salario"));
        loadFuncionarios();
    }

    @FXML
    private void adicionarFuncionario(ActionEvent event) {
        try {
            if (validaAdicaoFuncionario()){
                Funcionario f = new Funcionario(nomeField.getText(), cpfField.getText(), telefoneField.getText(), enderecoField.getText(), Double.parseDouble(salarioField.getText()), loja.getId());
                App.funcionarioRepository.create(f);
                loadFuncionarios();
                clearFuncionarios();
            }
        } catch (Exception e) {
            System.out.println("ERRO AO ADICIONAR FUNCIONARIO: " + e);
        }
    }

    @FXML
    private void removeFuncionario(ActionEvent event) {
        try {
            Funcionario f = App.funcionarioRepository.loadFromId(Integer.parseInt(idField.getText()));
            App.funcionarioRepository.delete(f);
            loadFuncionarios();
        } catch (Exception e) {
            System.out.println("ERRO AO REMOVER FUNCIONARIO: "+e);
        }
    }

    @FXML
    private void updateFuncionario(ActionEvent event) {
        try {
            Funcionario f = App.funcionarioRepository.loadFromId(Integer.parseInt(idField.getText()));
            f.setNome(nomeField.getText());
            f.setCpf(cpfField.getText());
            f.setTelefone(telefoneField.getText());
            f.setEndereco(enderecoField.getText());
            f.setSalario(Double.parseDouble(salarioField.getText()));
            App.funcionarioRepository.update(f);
            loadFuncionarios();
            clearFuncionarios();
        } catch (Exception e) {
            System.out.println("ERRO AO ATUALIZAR FUNCIONARIO: "+e);
        }
    }

    @FXML
    private void selectFuncionario(Event event) {
        try {
            Funcionario f = App.funcionarioRepository.loadFromId(tabelaFuncionarios.getSelectionModel().getSelectedItem().getId());
            idField.setText(String.valueOf(f.getId()));
            nomeField.setText(f.getNome());
            cpfField.setText(f.getCpf());
            telefoneField.setText(f.getTelefone());
            enderecoField.setText(f.getEndereco());
            salarioField.setText(String.valueOf(f.getSalario()));
            atualizarFuncionarioButton.setDisable(false);
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR FUNCIONARIO: " + e);
        }
    }

    private void loadFuncionarios(){
        try{
            for (Funcionario f : App.funcionarioRepository.loadAllFromLojaId(loja.getId())) {
                FuncionarioModel fm = new FuncionarioModel(f.getId(), f.getNome(), f.getCpf(), f.getTelefone(), f.getEndereco(), f.getSalario());
                funcionarios.add(fm);
            }
            funcionariosObs = FXCollections.observableArrayList(funcionarios);
            tabelaFuncionarios.setItems(funcionariosObs);
            funcionarios.clear();
        } catch (Exception e) {
            System.out.println("ERRO NA TABELA: "+e);
        }
    }

    @FXML
    private void startServicos(Event event) {
        nomePacote.setCellValueFactory(new PropertyValueFactory<ServicoModel, String>("nomePacote"));
        valorCarro.setCellValueFactory(new PropertyValueFactory<ServicoModel, Float>("valorCarro"));
        valorMoto.setCellValueFactory(new PropertyValueFactory<ServicoModel, Float>("valorMoto"));
        valorCaminhao.setCellValueFactory(new PropertyValueFactory<ServicoModel, Float>("valorCaminhao"));
        loadServicos();
    }

    @FXML
    private void adicionarServico(ActionEvent event) {
        try {
            if (validaServicoAdiciona()) {
                Servico s = new Servico(nomeServicoField.getText(), Float.parseFloat(valorCarroField.getText()), Float.parseFloat(valorMotoField.getText()), Float.parseFloat(valorCaminhaoField.getText()), loja.getId(), lavagemc.isSelected(), lavagems.isSelected(), lavagemt.isSelected(), cerap.isSelected(), ceran.isSelected(), outros.isSelected(), infoadicionalField.getText());
                App.servicoRepository.create(s);
                loadServicos();
                clearServicos();
            }
        } catch (Exception e) {
            System.out.println("ERRO AO ADICIONAR SERVICO: " + e);
        }
    }

    @FXML
    private void removeServico(ActionEvent event) {
        try {
            Servico s = App.servicoRepository.loadFromId(Integer.parseInt(servicoIDField.getText()));
            App.servicoRepository.delete(s);
            loadServicos();
        } catch (Exception e) {
            System.out.println("ERRO AO REMOVER SERVICO: "+e);
        }
    }

    @FXML
    private void updateServico(ActionEvent event) {
        try {
            if (validaSericoUpdate()){
                Servico s = App.servicoRepository.loadFromId(Integer.parseInt(servicoIDField.getText()));
                s.setNomePacote(nomeServicoField.getText());
                s.setValorCarro(Float.parseFloat(valorCarroField.getText()));
                s.setValorMoto(Float.parseFloat(valorMotoField.getText()));
                s.setValorCaminhao(Float.parseFloat(valorCaminhaoField.getText()));
                s.setLavagemc(lavagemc.isSelected());
                s.setLavagems(lavagems.isSelected());
                s.setLavagemt(lavagemt.isSelected());
                s.setCerap(cerap.isSelected());
                s.setCeran(ceran.isSelected());
                s.setOutros(outros.isSelected());
                s.setInfoadicional(infoadicionalField.getText());
                App.servicoRepository.update(s);
                loadServicos();
                clearServicos();
            }
        } catch (Exception e) {
            System.out.println("ERRO AO ATUALIZAR SERVICO: "+e);
        }
    }

    @FXML
    private void selectServico(Event event) {
        try {
            Servico s = App.servicoRepository.loadFromId(tabelaServicos.getSelectionModel().getSelectedItem().getId());
            servicoIDField.setText(String.valueOf(s.getId()));
            nomeServicoField.setText(s.getNomePacote());
            valorCarroField.setText(String.valueOf(s.getValorCarro()));
            valorMotoField.setText(String.valueOf(s.getValorMoto()));
            valorCaminhaoField.setText(String.valueOf(s.getValorCaminhao()));
            lavagemc.setSelected(s.isLavagemc());
            lavagems.setSelected(s.isLavagems());
            lavagemt.setSelected(s.isLavagemt());
            cerap.setSelected(s.isCerap());
            ceran.setSelected(s.isCeran());
            outros.setSelected(s.isOutros());
            infoadicionalField.setText(s.getInfoadicional());
            atualizarServicoButton.setDisable(false);
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR SERVICO: " + e);
        }
    }

    private void loadServicos(){
        try{
            for (Servico s : App.servicoRepository.loadAllFromLojaId(loja.getId())) {
                ServicoModel sm = new ServicoModel(s.getId(), s.getNomePacote(), s.getValorCarro(), s.getValorMoto(), s.getValorCaminhao());
                servicos.add(sm);
            }
            servicosObs = FXCollections.observableArrayList(servicos);
            tabelaServicos.setItems(servicosObs);
            servicos.clear();
        } catch (Exception e) {
            System.out.println("ERRO NA TABELA: "+e);
        }
    }

    private void clearServicos(){
        servicoIDField.clear();
        nomeServicoField.clear();
        valorCarroField.clear();
        valorMotoField.clear();
        valorCaminhaoField.clear();
        lavagemc.setSelected(false);
        lavagems.setSelected(false);
        lavagemt.setSelected(false);
        cerap.setSelected(false);
        ceran.setSelected(false);
        outros.setSelected(false);
        infoadicionalField.clear();
        atualizarServicoButton.setDisable(true);
    }

    private void clearFuncionarios(){
        idField.clear();
        nomeField.clear();
        cpfField.clear();
        telefoneField.clear();
        enderecoField.clear();
        salarioField.clear();
        atualizarFuncionarioButton.setDisable(true);
    }

    private Boolean validaAdicaoFuncionario(){
        if (nomeField.getText().isEmpty() || cpfField.getText().isEmpty() || telefoneField.getText().isEmpty() || enderecoField.getText().isEmpty() || salarioField.getText().isEmpty()) {
            valoresNulos.setVisible(true);
            return false;
        }else {
            valoresNulos.setVisible(false);
        }
        for (Funcionario f : App.funcionarioRepository.loadAllFromLojaId(loja.getId())) {
            if (f.getCpf().equals(cpfField.getText())) {
                cpfErro.setText("CPF já cadastrado");
                cpfErro.setTextFill(javafx.scene.paint.Color.RED);
                cpfErro.setVisible(true);
                return false;
            }else {
                cpfErro.setVisible(false);
            }
        }
        if (cpfField.getText().length() != 11) {
            cpfErro.setText("CPF inválido");
            cpfErro.setTextFill(javafx.scene.paint.Color.CRIMSON);
            cpfErro.setVisible(true);
            return false;
        }
        if (telefoneField.getText().length() != 11) {
            telefoneErro.setText("Telefone inválido");
            telefoneErro.setTextFill(javafx.scene.paint.Color.CRIMSON);
            telefoneErro.setVisible(true);
            return false;
        }
        try {
            Double.parseDouble(salarioField.getText());
            erro.setVisible(false);
        } catch (NumberFormatException e) {
            erro.setVisible(true);
            return false;
        }
        return true;
    }

    private Boolean validaServicoAdiciona(){
        if (nomeServicoField.getText().isEmpty() || valorCarro.getText().isEmpty() || valorMoto.getText().isEmpty() || valorCaminhao.getText().isEmpty()) {
            valoresNulosServicos.setVisible(true);
            return false;
        }else {
            valoresNulosServicos.setVisible(false);
        }
        for (Servico s : App.servicoRepository.loadAllFromLojaId(loja.getId())) {
            if (s.getNomePacote().equals(nomeServicoField.getText())) {
                erroServico.setText("Nome de pacote já cadastrado");
                erroServico.setTextFill(javafx.scene.paint.Color.RED);
                erroServico.setVisible(true);
                return false;
            }else {
                erroServico.setVisible(false);
            }
        }
        try {
            Float.parseFloat(valorCarroField.getText());
            Float.parseFloat(valorMotoField.getText());
            Float.parseFloat(valorCaminhaoField.getText());
            erroServico.setVisible(false);
        } catch (NumberFormatException e) {
            erroServico.setText("Somente números nos preços");
            erroServico.setTextFill(javafx.scene.paint.Color.CRIMSON);
            erroServico.setVisible(true);
            return false;
        }
        if (!lavagemc.isSelected() && !lavagems.isSelected() && !lavagemt.isSelected() && !cerap.isSelected() && !ceran.isSelected() && !outros.isSelected()) {
            erroCheckbox.setVisible(true);
            return false;
        }else {
            erroCheckbox.setVisible(false);
        }
        return true;
    }
    public Boolean validaSericoUpdate(){
        if (nomeServicoField.getText().isEmpty() || valorCarro.getText().isEmpty() || valorMoto.getText().isEmpty() || valorCaminhao.getText().isEmpty()) {
            valoresNulosServicos.setVisible(true);
            return false;
        }else {
            valoresNulosServicos.setVisible(false);
        }
        for (Servico s : App.servicoRepository.loadAllFromLojaId(loja.getId())) {
            if (s.getNomePacote().equals(nomeServicoField.getText()) && s.getId() != Integer.parseInt(servicoIDField.getText())) {
                erroServico.setText("Nome de pacote já cadastrado");
                erroServico.setTextFill(javafx.scene.paint.Color.RED);
                erroServico.setVisible(true);
                return false;
            }else {
                erroServico.setVisible(false);
            }
        }
        try {
            Float.parseFloat(valorCarroField.getText());
            Float.parseFloat(valorMotoField.getText());
            Float.parseFloat(valorCaminhaoField.getText());
            erroServico.setVisible(false);
        } catch (NumberFormatException e) {
            erroServico.setText("Somente números nos preços");
            erroServico.setTextFill(javafx.scene.paint.Color.CRIMSON);
            erroServico.setVisible(true);
            return false;
        }
        if (!lavagemc.isSelected() && !lavagems.isSelected() && !lavagemt.isSelected() && !cerap.isSelected() && !ceran.isSelected() && !outros.isSelected()) {
            erroCheckbox.setVisible(true);
            return false;
        }else {
            erroCheckbox.setVisible(false);
        }
        return true;
    }
}
