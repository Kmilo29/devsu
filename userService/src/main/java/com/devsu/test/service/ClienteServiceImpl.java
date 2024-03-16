package com.devsu.test.service;

import com.devsu.test.model.Cliente;
import com.devsu.test.repository.ClienteRepository;
import com.devsu.test.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final PublisherService publisherService;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository,
                              PublisherService publisherService) {
        this.clienteRepository = clienteRepository;
        this.publisherService = publisherService;
    }

    @Override
    public Iterable<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteByClienteId(String clienteId) {
        return clienteRepository.findOneByIdentificacion(clienteId);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        String encryptedPassword = PasswordUtil.encodePassword(cliente.getContrasena());
        cliente.setContrasena(encryptedPassword);
        cliente = clienteRepository.save(cliente);
        if (cliente != null) {
            String mensaje = String.format("nombre:%s, clienteId:%s, estado:%s",
                    cliente.getNombre(), cliente.getClienteId(), cliente.getEstado());
            publisherService.sendToRabbit(mensaje);
        }
        return cliente;
    }

    @Override
    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNombre(clienteDetails.getNombre());
            cliente.setGenero(clienteDetails.getGenero());
            cliente.setEdad(clienteDetails.getEdad());
            cliente.setDireccion(clienteDetails.getDireccion());
            cliente.setTelefono(clienteDetails.getTelefono());
            cliente.setContrasena(clienteDetails.getContrasena());
            cliente.setEstado(clienteDetails.getEstado());
            cliente = clienteRepository.save(cliente);
        }
        return cliente;
    }

    @Override
    public Cliente updateEstadoCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setEstado(!cliente.getEstado());
            cliente = clienteRepository.save(cliente);
        }
        return cliente;
    }

    @Override
    public Boolean deleteCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            String mensaje = String.format("nombre:%s, clienteId:%s, estado:%s",
                    cliente.getNombre(), cliente.getClienteId(), Boolean.FALSE);
            publisherService.sendToRabbit(mensaje);
            clienteRepository.deleteById(id);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}
