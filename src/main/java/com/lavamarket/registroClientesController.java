package com.lavamarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class registroClientesController 
{
    @FXML
    TextField usuario;
    @FXML
    TextField senha;
    @FXML
    TextField nome;
    @FXML
    TextField cpf;
    @FXML
    TextField endereco;
    @FXML 
    TextField telefone;
    @FXML
    Button registerButton;
    @FXML
    Label erro;
    @FXML
    Label concluido;
    
    /**
     * @param event
     */
    
    @FXML
    private void registerClienteButton(ActionEvent event) {
        try{   
            if (usuario.getText().isEmpty() || senha.getText().isEmpty() || nome.getText().isEmpty() || cpf.getText().isEmpty() || endereco.getText().isEmpty() || telefone.getText().isEmpty()) {
                erro.setVisible(true);
            } else {
                Cliente cliente = new Cliente(usuario.getText(), senha.getText(), nome.getText(), cpf.getText(), telefone.getText(), endereco.getText());
                App.clienteRepository.create(cliente);
                concluido.setVisible(true);
                Util.mudarScene("login.fxml", event, getClass());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void voltarButton(ActionEvent event) {
        try{
            Util.mudarScene("login.fxml", event, getClass());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
