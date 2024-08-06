/**
 * Classe que gerencia o controller da janela registro de lojas
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Loja;

import com.lavamarket.App;
import com.lavamarket.Login.LoginLojaController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RegistroLojasController
{
    @FXML
    TextField usuario;
    @FXML
    TextField senha;
    @FXML
    TextField nome;
    @FXML
    TextField cnpj;
    @FXML
    TextField endereco;
    @FXML
    Label erro;


    /**
     * Botao de registrar lojas
     * 
     * @param event
     */
    @FXML
    private void registerButton(ActionEvent event) {
        try{    
            if (validaRegistro()) { 
                Loja loja = new Loja(nome.getText(), usuario.getText(), senha.getText(), cnpj.getText(), endereco.getText());
                App.lojaRepository.create(loja);
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lavamarket/Login/login - Loja.fxml"));
                LoginLojaController controller = new LoginLojaController();
                loader.setController(controller);
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /**
     * Botao de voltar ao menu anterior
     * 
     * @param event
     */
    @FXML
    private void voltarButton(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lavamarket/Login/login - Loja.fxml"));
            LoginLojaController controller = new LoginLojaController();
            loader.setController(controller);
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo que valida o registro de lojas
     * 
     * @return Boolean
     */
    private Boolean validaRegistro(){
        try{
            App.lojaRepository.loadFromUsuario(usuario.getText());
            erro.setText("Usuario ja cadastrado");
            erro.setVisible(true);
            return false;
        } catch (Exception e) {
            erro.setVisible(false);
        }
        if (usuario.getText().isEmpty() || senha.getText().isEmpty() || nome.getText().isEmpty() || cnpj.getText().isEmpty() || endereco.getText().isEmpty()) {
            erro.setText("Preencha todos os campos");
            erro.setVisible(true);
            return false;
        } else{ 
            erro.setVisible(false);
        }
        if (cnpj.getText().length() != 14) {
            erro.setText("CNPJ invalido");
            erro.setVisible(true);
            return false;
        } else{
            erro.setVisible(false);
        }
        if (usuario.getText().length() < 6) {
            erro.setText("Usuario deve ter no minimo 6 caracteres");
            erro.setVisible(true);
            return false;
        } else{
            erro.setVisible(false);
        }
        if (senha.getText().length() < 6) {
            erro.setText("Senha deve ter no minimo 6 caracteres");
            erro.setVisible(true);
            return false;
        } else{
            erro.setVisible(false);
        }
        return true;
    }
}
