package com.devsu.test;

import com.devsu.test.model.Cliente;
import com.devsu.test.repository.ClienteRepository;
import com.devsu.test.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceApplicationTests {
/*
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testCreateAndDeleteCliente() {
        // Crear un cliente
        Cliente cliente = new Cliente();
        cliente.setNombre("Luisa Montalvo");
        cliente.setGenero("Femenino");
        cliente.setEdad(21);
        cliente.setIdentificacion("14235789");
        cliente.setDireccion("Latam");
        cliente.setContrasena("Test7889789");
        cliente.setTelefono("310000000");
        cliente.setEstado(true);

        Cliente savedCliente = clienteService.createCliente(cliente);

        assertNotNull(savedCliente.getId(), "El ID del cliente no debe ser nulo después de guardar en el repositorio simulado");

        // Borrar el cliente
        clienteService.deleteCliente(savedCliente.getId());

        // Verificar que el cliente ya no existe
        assertFalse(clienteRepository.existsById(savedCliente.getId()), "El cliente debe haber sido eliminado de la base de datos");
    }
*/
}
