/**
 * Classe controladora da janela javafx 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Cliente;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.lavamarket.App;
import com.lavamarket.Agendamento.Agendamento;
import com.lavamarket.Agendamento.AgendamentoModel;
import com.lavamarket.Loja.Loja;
import com.lavamarket.Loja.LojaModel;
import com.lavamarket.Loja.SelectedLojaController;
import com.lavamarket.Veiculo.Veiculo;
import com.lavamarket.Veiculo.VeiculoModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    private TableColumn<LojaModel, String> precomedioCarroLoja;
    @FXML
    private TableColumn<LojaModel, Float> precomedioMotoLoja;
    @FXML
    private TableColumn<LojaModel, Integer> precomedioCaminhaoLoja;
    @FXML
    private TableColumn<LojaModel, Float> reviewLoja;

    @FXML
    private TableView<AgendamentoModel> tabelaAgendamentos;
    @FXML
    private TableColumn<AgendamentoModel, String> veiculoAgendamento;
    @FXML
    private TableColumn<AgendamentoModel, Float> valorAgendamento;
    @FXML
    private TableColumn<AgendamentoModel, String> lojaAgendamento;
    @FXML
    private TableColumn<AgendamentoModel, Date> dataAgendamento;

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
    private ChoiceBox<String> tipoField;
    @FXML
    private TextField apelidoField;
    @FXML
    private Label valoresVazios;
    @FXML 
    private Label erroPlaca;
    @FXML
    private Label erroApelido;

    @FXML
    private TextField nomeField;
    @FXML
    private TextField usuarioField;
    @FXML
    private TextField cpfField;
    @FXML
    private TextField telefoneField;
    @FXML
    private TextField senhaField;
    @FXML
    private TextField enderecoField;
    @FXML
    private Label erroCliente;

    private Cliente cliente;
    /**
    * Metodo construtor do controlador do clinte
    *
    * @param cliente
    */
    public ClienteController(Cliente cliente) {
        this.cliente = cliente;
    }

    List<VeiculoModel> veiculos = new ArrayList<>();

    ObservableList<VeiculoModel> veiculosObs;

    List<LojaModel> lojas = new ArrayList<>();

    ObservableList<LojaModel> lojasObs;

    List<AgendamentoModel> agendamentos = new ArrayList<>();

    ObservableList<AgendamentoModel> agendamentosObs;
    
    @FXML
    /**
     * Metodo que controla os dados nos veiculos
     * 
     * @param event
     */
    private void startVeiculos(Event event) {
        id.setCellValueFactory(new PropertyValueFactory<VeiculoModel, Integer>("id"));
        apelido.setCellValueFactory(new PropertyValueFactory<VeiculoModel, String>("apelido")); 
        placa.setCellValueFactory(new PropertyValueFactory<VeiculoModel, String>("placa"));
        marca.setCellValueFactory(new PropertyValueFactory<VeiculoModel, String>("marca"));
        modelo.setCellValueFactory(new PropertyValueFactory<VeiculoModel, String>("modelo"));
        cor.setCellValueFactory(new PropertyValueFactory<VeiculoModel, String>("cor"));
        tipo.setCellValueFactory(new PropertyValueFactory<VeiculoModel, String>("tipo"));
        tipoField.getItems().add("Carro");
        tipoField.getItems().add("Moto");
        tipoField.getItems().add("Caminhão");
        loadVeiculos();
    }

    /**
     * Adiciona veiculos dentro da lista
     * 
     * @param event
     */
    @FXML
    private void adicionarVeiculo(ActionEvent event) {
        try {
            if (validaAdicao()) {
                Veiculo v = new Veiculo(apelidoField.getText(), placaField.getText(), marcaField.getText(), modeloField.getText(), corField.getText(), tipoField.getValue(), cliente.getId());
                App.veiculoRepository.create(v);
                loadVeiculos();
                clear();
            }
        } catch (Exception e) {
            System.out.println("ERRO AO ADICIONAR VEICULO: " + e);
        }
    }

    /**
     * Remove veiculos da lista
     * 
     * @param event
     */
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

    /**
     * Atualiza os veiculos da lista
     *  
     * @param event
     */
    @FXML
    private void updateVeiculo(ActionEvent event) {
        try {
            if (validaAtualizacaoVeiculo()) {
                Veiculo v = App.veiculoRepository.loadFromId(Integer.parseInt(idField.getText()));
                v.setPlaca(placaField.getText());
                v.setMarca(marcaField.getText());
                v.setModelo(modeloField.getText());
                v.setCor(corField.getText());
                v.setTipo(tipoField.getValue());
                v.setApelido(apelidoField.getText());
                App.veiculoRepository.update(v);
                loadVeiculos();
                clear();
            }
        } catch (Exception e) {
            System.out.println("ERRO AO EDITAR FUNCIONARIO: " + e);
        }
    }

    /**
     * Seleciona os veiculos da lista
     * 
     * @param event
     */
    @FXML
    private void selectVeiculo(Event event) {
        try {
            Veiculo v = App.veiculoRepository.loadFromId(tabelaVeiculos.getSelectionModel().getSelectedItem().getId());
            idField.setText(String.valueOf(v.getId()));
            placaField.setText(v.getPlaca());
            marcaField.setText(v.getMarca());
            modeloField.setText(v.getModelo());
            corField.setText(v.getCor());
            tipoField.setValue(v.getTipo());
            apelidoField.setText(v.getApelido());
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR FUNCIONARIO: "+e);
        }
    }

    /**
     * Metodo que carrega os veiculos do repositorio do cliente
     *  
     */
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

    /**
     * Metodo que inicia as lojas dentro do controlador do cliente
     * 
     * @param event
     */
    @FXML
    private void startLojas(Event event) {
        nomeLoja.setCellValueFactory(new PropertyValueFactory<LojaModel, Integer>("nome"));
        reviewLoja.setCellValueFactory(new PropertyValueFactory<LojaModel, Float>("review"));
        precomedioCarroLoja.setCellValueFactory(new PropertyValueFactory<LojaModel, String>("precomedioCarro"));
        precomedioMotoLoja.setCellValueFactory(new PropertyValueFactory<LojaModel, Float>("precomedioMoto"));
        precomedioCaminhaoLoja.setCellValueFactory(new PropertyValueFactory<LojaModel, Integer>("precomedioCaminhao"));

        loadLojas();
    }

    /**
     * Metodo que carrega as lojas dentro do controlador do cliente
     * 
     */
    private void loadLojas(){
        try{ 
            for (Loja l : App.lojaRepository.loadAll()) {
                LojaModel lm = new LojaModel(l.getNome(), l.getReview(), l.getPrecomedioCarro(), l.getPrecomedioMoto(), l.getPrecomedioCaminhao(), l.getId());
                lojas.add(lm);
            }
            lojasObs = FXCollections.observableArrayList(lojas);
            tabelaLojas.setItems(lojasObs);
            lojas.clear();
        } catch (Exception e) {
            System.out.println("ERRO NA TABELA: " + e);
        }
    }

    /**
     * Metodo que seleciona as lojas dentro do controlador do cliente
     * 
     * 
     * @param event
     */
    @FXML
    private void selectLoja(Event event) {
        try {
            Loja l = App.lojaRepository.loadFromId(tabelaLojas.getSelectionModel().getSelectedItem().getId());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("selectedLoja.fxml"));
            SelectedLojaController controller = new SelectedLojaController(cliente, l);
            loader.setController(controller);
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR LOJA: "+e);
        }
    }

    /**
     *  Metodo que carrega os dados do cliente
     * 
     * @param event
     */
    @FXML
    private void loadCliente(Event event) {
        nomeField.setText(cliente.getNome());
        usuarioField.setText(cliente.getUsuario());
        cpfField.setText(cliente.getCpf());
        telefoneField.setText(cliente.getTelefone());
        senhaField.setText(cliente.getSenha());
        enderecoField.setText(cliente.getEndereco());
    }

    /**
     * Metodo que atualiza os dados do cliente
     * 
     * @param event
     */
    @FXML
    private void updateCliente(ActionEvent event) {
        try {
            if (validaAtualizacaoCliente()) {
                Cliente c = App.clienteRepository.loadFromId(cliente.getId());
                c.setNome(nomeField.getText());
                c.setUsuario(usuarioField.getText());
                c.setCpf(cpfField.getText());
                c.setTelefone(telefoneField.getText());
                c.setSenha(senhaField.getText());
                c.setEndereco(enderecoField.getText());
                App.clienteRepository.update(c);
                erroCliente.setTextFill(javafx.scene.paint.Color.GREEN);
                erroCliente.setText("Usuário atualizado com successo");
                erroCliente.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO ATUALIZAR CLIENTE: "+e);
        }
    }

    /**
     * Metodo que desloga o cliente
     * 
     * @param event
     */
    @FXML
    private void logout(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("ERRO AO FAZER LOGOUT: "+e);
        }
    }

    /**
     * Metodo que inicia e gerencia os argumentos
     * 
     * @param event
     */
    @FXML
    private void startAgendamentos(Event event) {
        veiculoAgendamento.setCellValueFactory(new PropertyValueFactory<AgendamentoModel, String>("veiculo"));
        valorAgendamento.setCellValueFactory(new PropertyValueFactory<AgendamentoModel, Float>("valor"));
        lojaAgendamento.setCellValueFactory(new PropertyValueFactory<AgendamentoModel, String>("loja"));
        dataAgendamento.setCellValueFactory(new PropertyValueFactory<AgendamentoModel, Date>("data"));

        loadAgendamentos();
    }

    /**
     * Metodos que carregam os agendamentos
     * 
     */
    private void loadAgendamentos(){
        try{
            for (Agendamento a : App.agendamentoRepository.loadAllFromClienteId(cliente.getId())) {
                Veiculo v = App.veiculoRepository.loadFromId(a.getIdVeiculo());
                Loja l = App.lojaRepository.loadFromId(a.getIdLoja());
                AgendamentoModel am = new AgendamentoModel(a.getData(), v.getApelido(), a.getValor(), l.getNome());
                agendamentos.add(am);
            }
            agendamentosObs = FXCollections.observableArrayList(agendamentos);
            tabelaAgendamentos.setItems(agendamentosObs);
            agendamentos.clear();
        } catch (Exception e) {
            System.out.println("ERRO NA TABELA: "+e);
        }
    }

    /**
     * Metodo que limpa os agendamentos
     * 
     */
    private void clear(){
        idField.clear();
        placaField.clear();
        marcaField.clear();
        modeloField.clear();
        corField.clear();
        tipoField.setValue(null);
        apelidoField.clear();
    }

    /**
     * Metodo de validação dos dados do veiculo
     * 
     * @return
     */
    private Boolean validaAdicao(){
        if (apelidoField.getText().isEmpty() || placaField.getText().isEmpty() || marcaField.getText().isEmpty() || modeloField.getText().isEmpty() || corField.getText().isEmpty() || tipoField.getValue() == null) {
            valoresVazios.setVisible(true);
            return false;
        } else {
            valoresVazios.setVisible(false);
        }
        for (Veiculo v : App.veiculoRepository.loadAll()) {
            if (v.getPlaca().equals(placaField.getText())) {
                erroPlaca.setText("Placa já cadastrada");
                erroPlaca.setTextFill(javafx.scene.paint.Color.RED);
                erroPlaca.setVisible(true);
                return false;
            } else {
                erroPlaca.setVisible(false);
            }
            if (v.getApelido().equals(apelidoField.getText())) {
                erroApelido.setText("Apelido ja cadastrado");
                erroApelido.setTextFill(javafx.scene.paint.Color.CRIMSON);
                erroApelido.setVisible(true);
                return false;
            } else {
                erroApelido.setVisible(false);
            }
        }
        if (placaField.getText().length() != 7) {
            erroPlaca.setText("Placa inválida");
            erroPlaca.setTextFill(javafx.scene.paint.Color.CRIMSON);
            erroPlaca.setVisible(true);
            return false;
        } else{
            erroPlaca.setVisible(false);
        }
        if (apelidoField.getText().length() > 20) {
            erroApelido.setText("Apelido muito grande");
            erroApelido.setTextFill(javafx.scene.paint.Color.RED);
            erroApelido.setVisible(true);
            return false;
        } else {
            erroApelido.setVisible(false);
        }
        return true;
    }

    /**
     * Metodo de validação da atualização dos dados do veiculo
     * 
     * @return
     */
    private Boolean validaAtualizacaoVeiculo(){
        if (apelidoField.getText().isEmpty() || placaField.getText().isEmpty() || marcaField.getText().isEmpty() || modeloField.getText().isEmpty() || corField.getText().isEmpty() || tipoField.getValue() == null) {
            valoresVazios.setVisible(true);
            return false;
        } else {
            valoresVazios.setVisible(false);
        }
        for (Veiculo v : App.veiculoRepository.loadAllFromClienteId(cliente.getId())) {
            if (v.getPlaca().equals(placaField.getText()) && v.getId() != Integer.parseInt(idField.getText())) {
                erroPlaca.setText("Placa já cadastrada");
                erroPlaca.setTextFill(javafx.scene.paint.Color.RED);
                erroPlaca.setVisible(true);
                return false;
            } else {
                erroPlaca.setVisible(false);
            }
            if (v.getApelido().equals(apelidoField.getText()) && v.getId() != Integer.parseInt(idField.getText())) {
                erroApelido.setText("Apelido ja cadastrado");
                erroApelido.setTextFill(javafx.scene.paint.Color.CRIMSON);
                erroApelido.setVisible(true);
                return false;
            } else {
                erroApelido.setVisible(false);
            }
        }
        if (placaField.getText().length() != 7) {
            erroPlaca.setText("Placa inválida");
            erroPlaca.setTextFill(javafx.scene.paint.Color.CRIMSON);
            erroPlaca.setVisible(true);
            return false;
        } else{
            erroPlaca.setVisible(false);
        }
        if (apelidoField.getText().length() > 20) {
            erroApelido.setText("Apelido muito grande");
            erroApelido.setTextFill(javafx.scene.paint.Color.RED);
            erroApelido.setVisible(true);
            return false;
        } else {
            erroApelido.setVisible(false);
        }
        return true;
    }

    /**
     * Metodo que valida atualização de dados do cliente
     * 
     * @return
     */
    private Boolean validaAtualizacaoCliente(){
        if (nomeField.getText().isEmpty() || usuarioField.getText().isEmpty() || cpfField.getText().isEmpty() || telefoneField.getText().isEmpty() || senhaField.getText().isEmpty() || enderecoField.getText().isEmpty()) {
            erroCliente.setText("Preencha todos os campos");
            erroCliente.setTextFill(javafx.scene.paint.Color.RED);
            erroCliente.setVisible(true);
            return false;
        } else {
            erroCliente.setVisible(false);
        }
        for (Cliente c : App.clienteRepository.loadAll()) {
            if (c.getUsuario().equals(usuarioField.getText()) && c.getId() != cliente.getId()) {
                erroCliente.setText("Usuário já cadastrado");
                erroCliente.setTextFill(javafx.scene.paint.Color.RED);
                erroCliente.setVisible(true);
                return false;
            } else {
                erroCliente.setVisible(false);
            }
        }
        return true;
    }
}
