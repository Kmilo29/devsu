package com.devsu.test.service;

import com.devsu.test.queue.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private final Publisher publisher;

    @Autowired
    public PublisherService(Publisher publisher) {
        this.publisher = publisher;
    }

    public void sendToRabbit(String message) {
        this.publisher.send(message);
    }

}
