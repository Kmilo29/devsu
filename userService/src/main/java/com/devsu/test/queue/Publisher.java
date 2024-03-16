package com.devsu.test.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Autowired
    public Publisher(RabbitTemplate rabbitTemplate,
                              Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void send(String message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }

}
