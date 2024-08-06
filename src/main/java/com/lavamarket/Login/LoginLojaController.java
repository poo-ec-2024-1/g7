package com.lavamarket.Login;

import com.lavamarket.App;
import com.lavamarket.Loja.Loja;
import com.lavamarket.Loja.LojaController;
import com.lavamarket.Loja.RegistroLojasController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginLojaController {
    @FXML
    TextField username;
    @FXML
    TextField password;

    
    /**
     * Metodo que constroi o botao de login das lojas
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    private void loginButton(ActionEvent event) throws Exception {
        try {
            Loja user = App.lojaRepository.loadFromUsuario(username.getText());
            if (username.getText().equals(user.getUsuario()) && password.getText().equals(user.getSenha())) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lavamarket/Loja/lojas.fxml"));
                LojaController controller = new LojaController(user);
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
     * Botão de registrar lojas
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    private void registerButton(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lavamarket/Loja/RegistroLojas.fxml"));
        RegistroLojasController controller = new RegistroLojasController();
        loader.setController(controller);
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void voltar(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lavamarket/Login/login - tela inicial.fxml"));
        LoginController controller = new LoginController();
        loader.setController(controller);
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}