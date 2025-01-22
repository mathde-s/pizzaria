package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteRequestDTO;
import com.zup.pizzaria.dtos.ClienteResponseDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO criarCliente(ClienteRequestDTO clienteRequest) {
        Cliente cliente = converteClienteRequestParaCliente(clienteRequest);
        clienteRepository.save(cliente);
        return converteClienteParaClienteResponse(cliente);
    }

    public List<ClienteResponseDTO> listaClientes() {
        List<Cliente> clientesSalvos = clienteRepository.findAll();
        // retorna uma lista de ClienteResponseDTO
        return clientesSalvos.stream()
                .map(cliente -> new ClienteResponseDTO(cliente.getId(), cliente.getNome()
                        ,cliente.getEmail(), cliente.getTelefone()))
                .collect(Collectors.toList());
    }

    private Cliente converteClienteRequestParaCliente(ClienteRequestDTO clienteRequest) {
        return new Cliente(clienteRequest.getNome(), clienteRequest.getEmail(), clienteRequest.getTelefone());
    }

    private ClienteResponseDTO converteClienteParaClienteResponse(Cliente cliente){
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
    }

}
