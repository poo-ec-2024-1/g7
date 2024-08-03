package com.lavamarket;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SelectedLojaController {
    @FXML
    private TableView<Servico> tableView;
    @FXML
    private TableColumn<Servico, String> nomeColumn;
    @FXML
    private TableColumn<Servico, String> precoColumn;

    @FXML
    private CheckBox lavagemc;
    @FXML
    private CheckBox lavagems;
    @FXML
    private CheckBox lavagemt;
    @FXML
    private CheckBox cerap;
    @FXML
    private CheckBox ceran;
    @FXML
    private CheckBox outros;
    @FXML
    private ;




    private Loja loja;
    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}
