package com.lavamarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Controla os dados do modelo e a interação com a interface (visão)
 * 
 * @author Erick
 * @version 0.01
 */
public class LojasController
{
   @FXML
   private void loginButton(ActionEvent event) throws Exception {
        Util.mudarScene("lojas.fxml", event, getClass());
   }
    
}
