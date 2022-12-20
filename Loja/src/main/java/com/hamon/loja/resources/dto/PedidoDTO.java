package com.hamon.loja.resources.dto;

import java.util.List;

public class PedidoDTO {

    private Long userId;
    private List<ProdutoDTO> produtos;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" +
                "userId=" + userId +
                ", produtos=" + produtos +
                '}';
    }
}
