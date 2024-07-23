import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "loja")
public class Loja {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String nome;

    @DatabaseField(unique = true)
    private String usuario;

    @DatabaseField
    private String senha;

    @DatabaseField
    private String cnpj;

    @DatabaseField
    private String telefone;

    @DatabaseField
    private String endereco;
    
    @DatabaseField
    private String servicos;

    public Loja(String nome, String usuario, String senha, String cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.usuario = usuario;
        this.senha = senha;
    }
    public Loja(){
        this.nome = "";
        this.cnpj = "";
        this.endereco = "";
        this.usuario = "";
        this.senha = "";
    }

    public String getNome() {
        return nome;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getSenha(){
        return senha;
    }
    public String getCnpj() {
        return cnpj;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getServicos() {
        return servicos;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setServicos(String servicos) {
        this.servicos = servicos;
    }
}

