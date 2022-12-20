package com.hamon.catalogo.resource;

import com.hamon.catalogo.models.services.ProdutoService;
import com.hamon.catalogo.resource.dto.ProdutoCatalogoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {


    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public ResponseEntity<List<ProdutoCatalogoDTO>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }
}
