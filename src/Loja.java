public class Loja {
    private String nome;
    private String cnpj;
    private String telefone;
    private String endereco;
    private String[] servicos;

    public Loja(String nome, String cnpj, String telefone, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
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
    public String[] getServicos() {
        return servicos;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setServicos(String[] servicos) {
        this.servicos = servicos;
    }
}

