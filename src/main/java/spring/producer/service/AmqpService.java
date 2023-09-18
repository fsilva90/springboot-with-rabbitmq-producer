package spring.producer.service;

import spring.producer.dto.MessageQueueDTO;

public interface AmqpService {

    void sendToConsumer(MessageQueueDTO message);

}
