/**
 * Classe controladora do login 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginController
{


    /**
     * Metodo que constroi o botao de login das lojas
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    private void loginLojasButton(ActionEvent event) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login - Loja.fxml"));
            LoginLojaController controller = new LoginLojaController();
            loader.setController(controller);
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e){
            System.out.println("Falha na busca do usuario: "+e);
        }
    }

    
    /**
     * Metodo que constroi os botoes dos clientes
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    private void loginClientesButton(ActionEvent event) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login -Cliente.fxml"));
            LoginClienteController controller = new LoginClienteController();
            loader.setController(controller);
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e){
            System.out.println("Falha na busca do usuario: "+e);
        }
    }


}
