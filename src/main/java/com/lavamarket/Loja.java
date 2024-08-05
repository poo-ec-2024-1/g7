package com.lavamarket;

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
    private int precomedioCarro;

    @DatabaseField
    private int precomedioMoto;

    @DatabaseField
    private int precomedioCaminhao;

    @DatabaseField
    private String endereco;

    @DatabaseField
    private int review = 0;

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
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public void setPrecomedioCarro(int precomedioCarro) {
        this.precomedioCarro = precomedioCarro;
    }
    public int getPrecomedioCarro() {
        int contagem = 0;
        for (Servico s : App.servicoRepository.loadAllFromLojaId(this.id)) {
            this.precomedioCarro += s.getValorCarro();
            contagem++;
        }
        if (contagem == 0) {
            return this.precomedioCarro;
        }
        return this.precomedioCarro/contagem;
    }
    public int getPrecomedioMoto() {
        int contagem = 0;
        for (Servico s : App.servicoRepository.loadAllFromLojaId(this.id)) {
            this.precomedioMoto += s.getValorMoto();
            contagem++;
        }
        if (contagem == 0) {
            return this.precomedioMoto;
        }
        return this.precomedioMoto/contagem;
    }
    public int getPrecomedioCaminhao() {
        int contagem = 0;
        for (Servico s : App.servicoRepository.loadAllFromLojaId(this.id)) {
            this.precomedioCaminhao += s.getValorCaminhao();
            contagem++;
        }
        if (contagem == 0) {
            return this.precomedioCaminhao;
        }
        return this.precomedioCaminhao/contagem;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getId() {
        return id;
    }
    public float getReview() {
        App.reviewRepository.loadAllFromLojaId(this.id);
        int contagem = 0;
        for (Review r : App.reviewRepository.loadAll()) {
            review += r.getReview();
            contagem++;
        }
        if (contagem == 0) {
            return review;
        }
        return this.review/contagem;
    }
    
}

