package com.lavamarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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


    /**
     * @param event
     */
    @FXML
    private void registerLojaButton(ActionEvent event) {
        try{    
            Loja loja = new Loja(nome.getText(), usuario.getText(), senha.getText(), cnpj.getText(), endereco.getText());
            Database db = new Database("loja.db");
            db.getConnection();
            LojaRepository lojaRepository = new LojaRepository(db);
            lojaRepository.create(loja);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
