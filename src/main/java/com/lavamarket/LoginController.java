package com.lavamarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
            Loja user = App.lojaRepository.loadFromUsuario(username.getText());
            if (username.getText().equals(user.getUsuario()) && password.getText().equals(user.getSenha())) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("lojas.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                LojaController controller = loader.getController();
                controller.setLoja(user);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch(Exception e){
            System.out.println("Falha na busca do usuario: "+e);
        }
    }
    @FXML
    private void loginClientesButton(ActionEvent event) throws Exception {
        try {
            Cliente user1 = App.clienteRepository.loadFromUsuario(username1.getText());
            if (username1.getText().equals(user1.getUsuario()) && password1.getText().equals(user1.getSenha())) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("clientes.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                ClienteController controller = loader.getController();
                controller.setCliente(user1);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch(Exception e){
            System.out.println("Falha na busca do usuario: "+e);
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
