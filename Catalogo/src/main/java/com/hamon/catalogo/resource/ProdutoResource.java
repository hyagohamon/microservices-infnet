package com.hamon.catalogo.resource;

import com.hamon.catalogo.models.services.ProdutoService;
import com.hamon.catalogo.resource.dto.ProdutoCatalogoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoResource.class);

    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public ResponseEntity<List<ProdutoCatalogoDTO>> findAll() {

        logger.info("CHAMANDO LISTAGEM DE PRODUTOS");
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ProdutoCatalogoDTO findById(@PathVariable Long id) {

        logger.info("CHAMANDO LISTAGEM DE PRODUTOS");
        return produtoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.delete(id);
    }
}
