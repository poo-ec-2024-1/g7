/**
 * Classe App que inicia a aplicação software
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    
    /**
     * Classe sobreescrita que inicia o app, e inicia a tela incial de login
     * 
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // Inicializadores dos bancos de dados a serem ultilizados pelo programa
    static Database db = new Database("Database.db");
    static ClienteRepository clienteRepository = new ClienteRepository(db);
    static LojaRepository lojaRepository = new LojaRepository(db);
    static FuncionarioRepository funcionarioRepository = new FuncionarioRepository(db);
    static VeiculoRepository veiculoRepository = new VeiculoRepository(db);
    static ServicoRepository servicoRepository = new ServicoRepository(db);
    static ReviewRepository reviewRepository = new ReviewRepository(db);
    static AgendamentoRepository agendamentoRepository = new AgendamentoRepository(db);
    
    /**
     * Metodo principal da aplicação 
     * 
     * @param args
     * @throws Exception
     */    
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}

