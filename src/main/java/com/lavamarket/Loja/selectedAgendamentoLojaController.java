/**
 * Classe Controladora da janela de agendamento da loja 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Loja;


import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.lavamarket.Main.App;
import com.lavamarket.Agendamento.Agendamento;
import com.lavamarket.Cliente.Cliente;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class selectedAgendamentoLojaController implements Initializable {
    @FXML
    private Label nomeCliente;
    @FXML
    private Label cpfCliente;

    @FXML
    private Label apelidoVeiculo;
    @FXML
    private Label placaVeiculo;
    @FXML
    private Label modeloVeiculo;
    @FXML
    private Label corVeiculo;

    @FXML
    private Label nomePacoteServicos;
    @FXML
    private Label servicosSelecionados;
    @FXML
    private Label valorServicos;

    @FXML
    private Label dataAgendamento;

    @FXML
    private Slider slider;

    private Cliente cliente;
    private Loja loja;
    private Agendamento agendamento;

    String servicos = "";
    
    /**
     * Metodo construtor da classe
     * 
     * @param cliente
     * @param loja
     * @param agendamento
     */
    public selectedAgendamentoLojaController(Cliente cliente, Loja loja, Agendamento agendamento){
        this.cliente = cliente;
        this.loja = loja;
        this.agendamento = agendamento;
    }

    /**
     * Metodo de inicialização do repositorio de agendamentos
     * 
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
        nomeCliente.setText(App.lojaRepository.loadFromId(agendamento.getIdLoja()).getNome());
        cpfCliente.setText(App.lojaRepository.loadFromId(agendamento.getIdLoja()).getEndereco());

        apelidoVeiculo.setText(App.veiculoRepository.loadFromId(agendamento.getIdVeiculo()).getApelido());
        placaVeiculo.setText(App.veiculoRepository.loadFromId(agendamento.getIdVeiculo()).getPlaca());
        modeloVeiculo.setText(App.veiculoRepository.loadFromId(agendamento.getIdVeiculo()).getModelo());
        corVeiculo.setText(App.veiculoRepository.loadFromId(agendamento.getIdVeiculo()).getCor());

        nomePacoteServicos.setText(App.servicoRepository.loadFromId(agendamento.getIdServicos()).getNomePacote());
        if (App.servicoRepository.loadFromId(agendamento.getIdServicos()).isCeran()){
            servicos += "Cera Normal ";
        }
        if (App.servicoRepository.loadFromId(agendamento.getIdServicos()).isCerap()){
            servicos += "Cera Plástica ";
        }
        if (App.servicoRepository.loadFromId(agendamento.getIdServicos()).isLavagemc()){
            servicos += "Lavagem Completa ";
        }
        if (App.servicoRepository.loadFromId(agendamento.getIdServicos()).isLavagems()){
            servicos += "Lavagem Simples ";
        }
        if (App.servicoRepository.loadFromId(agendamento.getIdServicos()).isLavagemt()){
            servicos += "Lavagem de Tapetes ";
        }
        if (App.servicoRepository.loadFromId(agendamento.getIdServicos()).isOutros()){
            servicos += "Outros";
        }

        servicosSelecionados.setText(servicos);

        valorServicos.setText("R$ " + agendamento.getValor());

        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        dataAgendamento.setText((String)d.format(agendamento.getData()));
    } catch (Exception e){
        System.out.println("ERRO AO INICIALIZAR: " + e);
    }   
    }

    /**
     * Metodo que retorna ao menu anterior a o dos agendamentos da loja
     * 
     * @param event
     */
    @FXML
    public void voltar(Event event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lojas.fxml"));
            LojaController controller = new LojaController(loja);
            loader.setController(controller);
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
           System.out.println("ERRO AO VOLTAR: " + e);
        }
    }

    /**
     * Metodo que finaliza os agendamentos
     * 
     * @param event
     */
    @FXML
    public void finalizarAgendamento(Event event) {
        try{
            App.agendamentoRepository.delete(agendamento);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lojas.fxml"));
            LojaController controller = new LojaController(loja);
            loader.setController(controller);
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            System.out.println("ERRO AO CANCELAR: " + e);
        }
    }
}
