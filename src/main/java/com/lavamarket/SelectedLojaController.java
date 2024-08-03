package com.lavamarket;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class SelectedLojaController implements Initializable {
    @FXML
    private TableView<ServicoModel> tabelaServicos;
    @FXML
    private TableColumn<ServicoModel, String> nomeColumn;
    @FXML
    private TableColumn<ServicoModel, Float> precoColumn;

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
    private TextArea valorPacote;
    @FXML
    private ChoiceBox<String> veiculo;

    private Cliente cliente;
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    private Loja loja;
    public void setLoja(Loja loja) {
        this.loja = loja;
    }
    
    List<ServicoModel> servicos = new ArrayList<>();
    ObservableList<ServicoModel> servicosObs;
    List<String> veiculosApelidos = new ArrayList<>();
    ObservableList<String> veiculosApelidosObs;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void startServico(Event event){
        nomeColumn.setCellValueFactory(new PropertyValueFactory<ServicoModel, String>("nomePacote"));
        precoColumn.setCellValueFactory(new PropertyValueFactory<ServicoModel, Float>("valor"));
        loadServicos();
        try{
            if (veiculo.getItems().isEmpty()){
                for (Veiculo veiculo : App.veiculoRepository.loadAllFromClienteId(cliente.getId())) {
                    veiculosApelidos.add(veiculo.getApelido());
                }
                veiculo.getItems().addAll(veiculosApelidos);
            }
        }catch(NullPointerException e){
            App.print("ERRO NA CLASSE SelectedLojaController durante a inicialização: ",e.getMessage());
        }
    }
    private void loadServicos(){
        try{
            for (Servico servico : App.servicoRepository.loadAllFromLojaId(loja.getId())) {
                ServicoModel servicoModel = new ServicoModel(servico.getId(), servico.getNomePacote(), servico.getValor());
                servicos.add(servicoModel);
            }
            if (this.servicos != null) {
                servicosObs = FXCollections.observableArrayList(servicos);
                tabelaServicos.setItems(servicosObs);
                servicos.clear();
            }
        }catch(NullPointerException e){
            App.print("ERRO NA CLASSE SelectedLojaController durante o carregamento dos serviços: ",e.getMessage());
        }
    }
    @FXML
    private void selectServico(){
        Servico servico = App.servicoRepository.loadFromId(tabelaServicos.getSelectionModel().getSelectedItem().getId());
        lavagemc.setSelected(servico.isLavagemc());
        lavagems.setSelected(servico.isLavagems());
        lavagemt.setSelected(servico.isLavagemt());
        cerap.setSelected(servico.isCerap());
        ceran.setSelected(servico.isCeran());
        outros.setSelected(servico.isOutros());
        infoAdicional.setText(servico.getInfoadicional());
        valorPacote.setText(String.valueOf(servico.getValor()));
    }

}