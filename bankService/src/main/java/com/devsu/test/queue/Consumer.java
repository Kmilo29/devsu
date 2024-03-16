package com.devsu.test.queue;

import com.devsu.test.model.Cliente;
import com.devsu.test.service.ClienteService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private final ClienteService clienteService;

    public Consumer(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RabbitListener(queues = { "${devsu.queue.name}" })
    public void receive(@Payload String mensaje) {
        String[] partes = mensaje.split(",");
        String nombre = partes[0].split(":")[1];
        String clienteId = partes[1].split(":")[1].trim();
        Boolean estado = Boolean.parseBoolean(partes[2].split(":")[1].trim());

        if (estado) {
            Cliente cliente = new Cliente(nombre, clienteId, true);
            clienteService.createCliente(cliente);
        } else {
            clienteService.desactivarCliente(clienteId);
        }
    }

}