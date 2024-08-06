/**
 * Metodos que controla a janela de registro de clientes 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Cliente;

import com.lavamarket.App;
import com.lavamarket.Login.LoginClienteController;
import com.lavamarket.Login.LoginController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RegistroClientesController 
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
    Label erro;
    @FXML
    Label concluido;
    
    /**
     * Botao de registrar o cliente
     * 
     * @param event
     */
    @FXML
    private void registerClienteButton(ActionEvent event) throws Exception {
        try{   
            if (validaRegistro()) {
                Cliente cliente = new Cliente(usuario.getText(), senha.getText(), nome.getText(), cpf.getText(), telefone.getText(), endereco.getText());
                App.clienteRepository.create(cliente);
                concluido.setVisible(true);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lavamarket/Login/login -Cliente.fxml"));
                LoginClienteController controller = new LoginClienteController();
                loader.setController(controller);
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
           }
        } catch (Exception e) {
            e.printStackTrace();
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lavamarket/Login/login -Cliente.fxml"));
            LoginController controller = new LoginController();
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
     * Metodo que valida o registro do cliente
     * 
     * @return boolean
     */
    private Boolean validaRegistro(){
        try{ 
            App.clienteRepository.loadFromUsuario(usuario.getText());
            erro.setText("Usuario ja cadastrado");
            erro.setVisible(true);
            return false;
        } catch (Exception e){
            erro.setVisible(false);
        }
        if (usuario.getText().isEmpty() || senha.getText().isEmpty() || nome.getText().isEmpty() || cpf.getText().isEmpty() || endereco.getText().isEmpty() || telefone.getText().isEmpty()) {
            erro.setText("Preencha todos os campos");
            erro.setVisible(true);
            return false;
        } else{
            erro.setVisible(false);
        }
        if (cpf.getText().length() != 11){
            erro.setText("CPF invalido");
            erro.setVisible(true);
            return false;
        } else{ 
            erro.setVisible(false);
        }  
        if (telefone.getText().length() != 11){
            erro.setText("Telefone invalido");
            erro.setVisible(true);
            return false;
        } else{
            erro.setVisible(false);
        }
        if (usuario.getText().length() < 6){
            erro.setText("Usuario deve ter no minimo 6 caracteres");
            erro.setVisible(true);
            return false;
        } else{
            erro.setVisible(false);
        }
        if (senha.getText().length() < 6){
            erro.setText("Senha deve ter no minimo 6 caracteres");
            erro.setVisible(true);
            return false;
        } else{
            erro.setVisible(false);
        }
        return true;
    }
}
