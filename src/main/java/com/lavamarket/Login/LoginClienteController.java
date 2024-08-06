package com.lavamarket.Login;

import com.lavamarket.Main.App;
import com.lavamarket.Cliente.Cliente;
import com.lavamarket.Cliente.ClienteController;
import com.lavamarket.Cliente.RegistroClientesController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginClienteController {
    @FXML
    TextField username;
    @FXML
    TextField password;
    
    
    /**
     * Metodo que constroi os botoes dos clientes
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    private void loginButton(ActionEvent event) throws Exception {
        try {
            Cliente user = App.clienteRepository.loadFromUsuario(username.getText());
            if (username.getText().equals(user.getUsuario()) && password.getText().equals(user.getSenha())) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lavamarket/Cliente/clientes.fxml"));
                ClienteController controller = new ClienteController(user);
                loader.setController(controller);
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch(Exception e){
            System.out.println("Falha na busca do usuario: "+e);
        }
    }

    /**
     * Botao de registrar clientes
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    private void registerButton(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lavamarket/Cliente/RegistroClientes.fxml"));
        RegistroClientesController controller = new RegistroClientesController();
        loader.setController(controller);
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } 
}
