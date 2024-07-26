package com.lavamarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Util {
    public static void mudarScene(String fxml, ActionEvent event, Class classe, Loja stored) throws Exception{
        FXMLLoader loader = new FXMLLoader(classe.getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setUserData(stored);
        System.out.println(stored.getNome());
        System.out.println(stored.getUsuario());
        System.out.println(stored.getSenha());
        stage.show();
    }
    public static void mudarScene(String fxml, ActionEvent event, Class classe) throws Exception{
        Parent root = FXMLLoader.load(classe.getResource(fxml));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
