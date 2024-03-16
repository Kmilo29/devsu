package com.devsu.test.service;

import com.devsu.test.model.Cliente;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface ClienteService {

    Iterable<Cliente> getAllClientes();

    Optional<Cliente> getClienteByClienteId(String clienteId);

    Cliente createCliente(Cliente cliente);

    void desactivarCliente(String clienteId);

}
