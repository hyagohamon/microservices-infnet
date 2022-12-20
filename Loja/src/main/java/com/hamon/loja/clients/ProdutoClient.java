package com.hamon.loja.clients;

import com.hamon.loja.resources.dto.ProdutoCatalogoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("produto")
public interface ProdutoClient {

    @GetMapping("/produtos")
    ResponseEntity<List<ProdutoCatalogoDTO>> getProdutos();

}
