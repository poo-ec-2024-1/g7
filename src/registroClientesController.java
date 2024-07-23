import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class registroClientesController 
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
    Button registerButton;


    /**
     * @param event
     */
    @FXML
    private void registerClienteButton(ActionEvent event) {
        try{   
            Cliente cliente = new Cliente(usuario.getText(), senha.getText(), nome.getText(), cpf.getText(), telefone.getText(), endereco.getText());
            Database db = new Database("cliente.db");
            db.getConnection();
            ClienteRepository clienteRepository = new ClienteRepository(db);
            clienteRepository.create(cliente);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
