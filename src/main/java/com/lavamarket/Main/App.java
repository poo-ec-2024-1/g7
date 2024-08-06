/**
 * Classe App que inicia a aplicação software
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Main;

import com.lavamarket.Login.LoginController;
import com.lavamarket.Agendamento.AgendamentoRepository;
import com.lavamarket.Cliente.ClienteRepository;
import com.lavamarket.Funcionario.FuncionarioRepository;
import com.lavamarket.Loja.LojaRepository;
import com.lavamarket.Review.ReviewRepository;
import com.lavamarket.Servico.ServicoRepository;
import com.lavamarket.Veiculo.VeiculoRepository;

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
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lavamarket/Login/login - tela inicial.fxml"));
        LoginController controller = new LoginController();
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (Exception e){
            System.out.println("Erro ao carregar tela de login" + e);
        }
    }
    
    // Inicializadores dos bancos de dados a serem ultilizados pelo programa
    static Database db = new Database("Database.db");
    public static ClienteRepository clienteRepository = new ClienteRepository(db);
    public static LojaRepository lojaRepository = new LojaRepository(db);
    public static FuncionarioRepository funcionarioRepository = new FuncionarioRepository(db);
    public static VeiculoRepository veiculoRepository = new VeiculoRepository(db);
    public static ServicoRepository servicoRepository = new ServicoRepository(db);
    public static ReviewRepository reviewRepository = new ReviewRepository(db);
    public static AgendamentoRepository agendamentoRepository = new AgendamentoRepository(db);
    
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

