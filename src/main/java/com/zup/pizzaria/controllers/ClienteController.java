package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.ClienteRequestDTO;
import com.zup.pizzaria.dtos.ClienteResponseDTO;
import com.zup.pizzaria.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
@Validated
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criarCliente(@Valid @RequestBody ClienteRequestDTO clienteRequestDTODTO) {
        ClienteResponseDTO clienteResponse = clienteService.criarCliente(clienteRequestDTODTO);
        return ResponseEntity.status(201).body(clienteResponse);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes(){
        return ResponseEntity.status(201).body(clienteService.listaClientes());
    }

}
