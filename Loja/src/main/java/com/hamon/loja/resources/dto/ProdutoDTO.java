package com.hamon.loja.resources.dto;

public class ProdutoDTO {

    private Long id;
    private Long qntd;
    private String nome;
    private String preco;

    public ProdutoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQntd() {
        return qntd;
    }

    public void setQntd(Long qntd) {
        this.qntd = qntd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" +
                "id=" + id +
                ", qntd=" + qntd +
                ", nome='" + nome + '\'' +
                ", preco='" + preco + '\'' +
                '}';
    }
}
