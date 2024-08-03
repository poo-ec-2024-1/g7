package com.lavamarket;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    static Database db = new Database("Database.db");
    static ClienteRepository clienteRepository = new ClienteRepository(db);
    static LojaRepository lojaRepository = new LojaRepository(db);
    static FuncionarioRepository funcionarioRepository = new FuncionarioRepository(db);
    static VeiculoRepository veiculoRepository = new VeiculoRepository(db);
    static ServicoRepository servicoRepository = new ServicoRepository(db);
    static ReviewRepository reviewRepository = new ReviewRepository(db);
    
    public static void print(String s)
    {
        System.out.println(s);
    }
    
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}

