/**
 * Classe Loja que possui os atributos das lojas 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Loja;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lavamarket.App;
import com.lavamarket.Review.Review;
import com.lavamarket.Serviço.Servico;


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
    private int review;

    /**
     * Metodo construtor da loja 
     * 
     * @param nome
     * @param usuario
     * @param senha
     * @param cnpj
     * @param endereco
     */
    public Loja(String nome, String usuario, String senha, String cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    /**
     * Metodo construtor padrão da loja
     * 
     */
    public Loja(){
        this.nome = "";
        this.cnpj = "";
        this.endereco = "";
        this.usuario = "";
        this.senha = "";
    }

    /**
     * Getter do nome da loja
     * 
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter do nome da loja
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter do usuario
     * 
     * @return
     */
    public String getUsuario(){
        return usuario;
    }

    /**
     * setter do Usuario
     * 
     * @param usuario
     */
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    /**
     * Getter da senhas
     * 
     * @return
     */
    public String getSenha(){
        return senha;
    }

    /**
     * setter da senha
     * 
     * @param senha
     */
    public void setSenha(String senha){
        this.senha = senha;
    }

    /**
     * Getter do cnpj da loja
     * 
     * @return
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Setter do cnpj da loja
     * 
     * @param cnpj
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Setter do precomedioCarro
     * 
     * @param precomedioCarro
     */
    public void setPrecomedioCarro(int precomedioCarro) {
        this.precomedioCarro = precomedioCarro;
    }

    /**
     * Getter do precomediocarro
     * 
     * @return
     */
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

    /**
     * getter do precomedio da moto
     * 
     * @return
     */
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

    /**
     * Getter do precomedio de caminhoes
     * 
     * @return
     */
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

    /**
     * Getter do endereço
     * 
     * @return
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Setter do endereço da loja
     * 
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Getter do id da loja
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Getter da avaliação da loja
     * 
     * @return
     */
    public float getReview() {
        int contagem = 0;
        for (Review r : App.reviewRepository.loadAllFromLojaId(this.id)) {
            review += r.getReview();
            contagem++;
        }
        if (contagem == 0) {
            return this.review;
        }
        return this.review/contagem;
    }
    
}

