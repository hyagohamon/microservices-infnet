package com.hamon.catalogo;

import com.hamon.catalogo.models.entities.Produto;
import com.hamon.catalogo.models.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoApplication implements CommandLineRunner {

    @Autowired
    private ProdutoService produtoService;

    public static void main(String[] args) {
        SpringApplication.run(CatalogoApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        Produto p = new Produto();
        p.setNome("Camisa Nike");
        p.setPreco(99.90);

        Produto p2 = new Produto();
        p2.setNome("Iphone 13 Pro Max");
        p2.setPreco(7999.90);

        Produto p3 = new Produto();
        p3.setNome("Monitor Lg 34 Polegadas");
        p3.setPreco(2500.75);


        produtoService.save(p);
        produtoService.save(p2);
        produtoService.save(p3);

    }
}
