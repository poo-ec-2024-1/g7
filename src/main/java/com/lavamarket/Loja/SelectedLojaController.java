/**
 * Classe que controla a janela da loja selecionada 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Loja;


import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.Action;

import com.lavamarket.App;
import com.lavamarket.Agendamento.Agendamento;
import com.lavamarket.Cliente.Cliente;
import com.lavamarket.Serviço.Servico;
import com.lavamarket.Serviço.ServicoModel;
import com.lavamarket.Veiculo.Veiculo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SelectedLojaController implements Initializable {
    @FXML
    private TableView<ServicoModel> tabelaServicos;
    @FXML
    private TableColumn<ServicoModel, String> nomeColumn;
    @FXML
    private TableColumn<ServicoModel, Float> precoCarroColumn;
    @FXML
    private TableColumn<ServicoModel, Float> precoMotoColumn;
    @FXML
    private TableColumn<ServicoModel, Float> precoCaminhaoColumn;

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
    private TextArea infoAdicional;
    @FXML
    private Label valorPacote;
    @FXML
    private ChoiceBox<String> veiculo;
    @FXML
    private DatePicker dataAgendamento;
    @FXML
    private TextField idField;
    @FXML
    private Label dataError;
    @FXML
    private Label veiculoError;
    @FXML
    private Label servicoError;
    @FXML
    private Button botaoAgendamento;
    
    private Loja loja;
    private Cliente cliente;

    /**
     * Metodo criador da classe selected loja controller
     * 
     * @param cliente
     * @param loja
     */
    public SelectedLojaController(Cliente cliente, Loja loja) {
        this.cliente = cliente;
        this.loja = loja;
    }
 
    
    List<ServicoModel> servicos = new ArrayList<>();
    ObservableList<ServicoModel> servicosObs;
    List<String> veiculosApelidos = new ArrayList<>();
    ObservableList<String> veiculosApelidosObs;

    /**
     * Classe que sobreescreve e inicializa a janela
     * 
     * @param resources
     * @param location
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeColumn.setCellValueFactory(new PropertyValueFactory<ServicoModel, String>("nomePacote"));
        precoCarroColumn.setCellValueFactory(new PropertyValueFactory<ServicoModel, Float>("valorCarro"));
        precoMotoColumn.setCellValueFactory(new PropertyValueFactory<ServicoModel, Float>("valorMoto"));
        precoCaminhaoColumn.setCellValueFactory(new PropertyValueFactory<ServicoModel, Float>("valorCaminhao"));
        veiculo.setOnAction(this::setChoicebox);
        setChoicebox(null);
        loadServicos();
    }

    /**
     * Metodo que configura a caixa de seleção
     * 
     * @param event
     */
    private void setChoicebox(ActionEvent event){
        try{
            if (veiculo.getItems().isEmpty()){
                for (Veiculo veiculo : App.veiculoRepository.loadAllFromClienteId(cliente.getId())) {
                    veiculosApelidos.add(veiculo.getApelido());
                }
                veiculo.getItems().addAll(veiculosApelidos);
                
            }  
            setPreco();
        }catch(Exception e){
            System.out.printf("ERRO NA CLASSE SelectedLojaController durante a inicialização: ",e.getMessage());
        }
    }


    /**
     * Metodo que altera o preço do serviço
     * 
     * @return
     */
    private float setPreco(){
        if (veiculo.getValue() == null){
            return -1;
        } else if (App.veiculoRepository.loadFromApelido(veiculo.getValue()).getTipo().equals("Moto")){
            String valor = String.valueOf(tabelaServicos.getSelectionModel().getSelectedItem().getValorMoto());
            valorPacote.setText("Preço: " + valor + "R$");
            return App.servicoRepository.loadFromId(Integer.parseInt(idField.getText())).getValorMoto();
        } else if (App.veiculoRepository.loadFromApelido(veiculo.getValue()).getTipo().equals("Carro")){
            String valor = String.valueOf(tabelaServicos.getSelectionModel().getSelectedItem().getValorCarro());
            valorPacote.setText("Preço: " + valor + "R$");
            return App.servicoRepository.loadFromId(Integer.parseInt(idField.getText())).getValorCarro();
        } else if (App.veiculoRepository.loadFromApelido(veiculo.getValue()).getTipo().equals("Caminhão")){
            String valor = String.valueOf(tabelaServicos.getSelectionModel().getSelectedItem().getValorCaminhao());
            valorPacote.setText("Preço: " + valor + "R$");
            return App.servicoRepository.loadFromId(Integer.parseInt(idField.getText())).getValorCaminhao();
        }
        return -1;
    }

    /**
     * Metodo que carrega os serviços
     * 
     */
    private void loadServicos(){
        try{
            for (Servico servico : App.servicoRepository.loadAllFromLojaId(loja.getId())) {
                ServicoModel servicoModel = new ServicoModel(servico.getId(), servico.getNomePacote(), servico.getValorCarro(), servico.getValorMoto(), servico.getValorCaminhao());
                servicos.add(servicoModel);
            }
            if (this.servicos != null) {
                servicosObs = FXCollections.observableArrayList(servicos);
                tabelaServicos.setItems(servicosObs);
                servicos.clear();
            }
        }catch(NullPointerException e){
            System.out.printf("ERRO NA CLASSE SelectedLojaController durante o carregamento dos serviços: ",e.getMessage());
        }
    }

    /**
     * Metodo de seleção de serviços
     * 
     */
    @FXML
    private void selectServico(){
        try{
            Servico servico = App.servicoRepository.loadFromId(tabelaServicos.getSelectionModel().getSelectedItem().getId());
            lavagemc.setSelected(servico.isLavagemc());
            lavagems.setSelected(servico.isLavagems());
            lavagemt.setSelected(servico.isLavagemt());
            cerap.setSelected(servico.isCerap());
            ceran.setSelected(servico.isCeran());
            outros.setSelected(servico.isOutros());
            infoAdicional.setText(servico.getInfoadicional());
            idField.setText(String.valueOf(servico.getId()));
            setPreco();
        }catch(NullPointerException e){
            System.out.printf("ERRO NA CLASSE SelectedLojaController durante a seleção do serviço: ",e.getMessage());
        }
    }

    /**
     * Metodo de agendamento e data
     * 
     */
    @FXML
    private void dataAgendamento(){
            LocalDate data = dataAgendamento.getValue();
            String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            dataAgendamento.setPromptText(dataFormatada);
    }

    /**
     * Metodo que agenta o serviço
     * 
     */
    @FXML
    private void agendar(){
        try{
            if (validaAgendamento()){
                int idVeiculo = App.veiculoRepository.loadFromApelido(veiculo.getValue()).getId();
                int idServico = Integer.parseInt(idField.getText());
                Date data = Date.valueOf(dataAgendamento.getValue());
                Agendamento agendamento = new Agendamento(cliente.getId(), loja.getId(), idVeiculo, idServico, data, setPreco());
                App.agendamentoRepository.create(agendamento);
                botaoAgendamento.setText("Agendamento realizado com sucesso");
            }
        }catch(NullPointerException e){
            System.out.printf("ERRO NA CLASSE SelectedLojaController durante o agendamento: ",e.getMessage());
        }
    }

    /**
     * Metodo que valida o agendamento
     * 
     * @return
     */
    private Boolean validaAgendamento(){
        if (idField.getText().isEmpty()){
            servicoError.setVisible(true);
            return false;
        } else {
            servicoError.setVisible(false);
        }
        if (veiculo.getValue() == null){
            veiculoError.setVisible(true);
            return false;
        } else {
            veiculoError.setVisible(false);
        }
        if (dataAgendamento.getValue() == null){
            dataError.setVisible(true);
            return false;
        } else {
            dataError.setVisible(false);
        }
        if (setPreco() == -1){
            return false;
        }
        for (Agendamento agendamento : App.agendamentoRepository.loadAll()) {
            if (agendamento.getData().equals(Date.valueOf(dataAgendamento.getValue())) && agendamento.getIdLoja() == loja.getId()){
                botaoAgendamento.setText("Data já agendada");
                return false;
            } else {
                botaoAgendamento.setText("Agendar lavagem");
            }
        }
        return true;
    }
}