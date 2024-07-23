package com.lavamarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


/**
 * Controla os dados do modelo e a interação com a interface (visão)
 * 
 * @author Erick
 * @version 0.01
 */
public class LoginController
{
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    TextField username1;
    @FXML
    TextField password1;


    @FXML
    private void loginLojasButton(ActionEvent event) throws Exception {
        try {
            LojaRepository lojaRepository = new LojaRepository(new Database("loja.db"));
            Loja user = lojaRepository.loadFromUsuario(username.getText());
            if (username.getText().equals(user.getUsuario()) && password.getText().equals(user.getSenha())) {
                Util.mudarScene("lojas.fxml", event, getClass());
            }
        } catch(Exception e){
            System.out.println("Falha na busca do usuario");
        }
    }
    @FXML
    private void loginClientesButton(ActionEvent event) throws Exception {
        try {
            ClienteRepository clienteRepository = new ClienteRepository(new Database("cliente.db"));
            Cliente user = clienteRepository.loadFromUsuario(username1.getText());
            if (username1.getText().equals(user.getUsuario()) && password1.getText().equals(user.getSenha())) {
                Util.mudarScene("lojas.fxml", event, getClass());
            }
        } catch(Exception e){
            System.out.println("Falha na busca do usuario");
        }
    }

    @FXML
    private void registerLojasButton(ActionEvent event) throws Exception {
        Util.mudarScene("registroLojas.fxml", event, getClass());
    }

    @FXML
    private void registerClientesButton(ActionEvent event) throws Exception {
        Util.mudarScene("registroClientes.fxml", event, getClass());
    }
        
}
