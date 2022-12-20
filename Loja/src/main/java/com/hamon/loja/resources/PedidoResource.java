package com.hamon.loja.resources;


import com.hamon.loja.clients.ProdutoClient;
import com.hamon.loja.resources.dto.PedidoDTO;
import com.hamon.loja.resources.dto.ProdutoCatalogoDTO;
import com.hamon.loja.resources.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/loja")
public class PedidoResource {

    private static final Logger log = LoggerFactory.getLogger(PedidoResource.class);

    @Autowired
    private RestTemplate restTemplate;


    @Value("${cliente.endpoint.url}")
    private String clienteApiUrl;

    @Autowired
    private ProdutoClient produtoClient;

    @PostMapping("/pedidos")
    public ResponseEntity<PedidoDTO> pedido(@RequestBody PedidoDTO pedidoDTO) {

        log.info("solicitação de pedido sendo processada:{}", pedidoDTO);
        UserDto userDto = restTemplate.getForObject(clienteApiUrl +
                pedidoDTO.getUserId(), UserDto.class);

        return ResponseEntity.ok(pedidoDTO);
    }


    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoCatalogoDTO>> produtos() {
        return produtoClient.getProdutos();
    }


}
