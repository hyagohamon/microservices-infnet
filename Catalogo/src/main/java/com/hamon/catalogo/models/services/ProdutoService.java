package com.hamon.catalogo.models.services;

import com.hamon.catalogo.models.entities.Produto;
import com.hamon.catalogo.models.repositories.ProdutoRepository;
import com.hamon.catalogo.resource.dto.ProdutoCatalogoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProdutoCatalogoDTO> findAll() {
        List<Produto> listProduct = produtoRepository.findAll();
        return Arrays.asList(modelMapper.map(listProduct, ProdutoCatalogoDTO[].class));
    }

    public void save(Produto produto) {
        produtoRepository.save(produto);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoCatalogoDTO findById(Long id) {
        Optional<Produto> byId = produtoRepository.findById(id);
        return modelMapper.map(byId.get(), ProdutoCatalogoDTO.class);
    }
}
