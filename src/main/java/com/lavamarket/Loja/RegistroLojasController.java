/**
 * Classe que gerencia o controller da janela registro de lojas
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Loja;

import com.lavamarket.App;
import com.lavamarket.Util;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


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
    Button registerButton;
    @FXML
    Label erro;


    /**
     * Botao de registrar lojas
     * 
     * @param event
     */
    @FXML
    private void registerLojaButton(ActionEvent event) {
        try{    
            if (usuario.getText().isEmpty() || senha.getText().isEmpty() || nome.getText().isEmpty() || cnpj.getText().isEmpty() || endereco.getText().isEmpty()) {
                erro.setVisible(true);
            } else {
                Loja loja = new Loja(nome.getText(), usuario.getText(), senha.getText(), cnpj.getText(), endereco.getText());
                App.lojaRepository.create(loja);
                Util.mudarScene("login.fxml", event, getClass());
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
            Util.mudarScene("login.fxml", event, getClass());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
