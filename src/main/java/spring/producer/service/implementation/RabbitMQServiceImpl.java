package spring.producer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.producer.amqp.AmqpProducer;
import spring.producer.dto.MessageQueueDTO;
import spring.producer.service.AmqpService;

@Service
public class RabbitMQServiceImpl implements AmqpService {

    @Autowired
    private AmqpProducer<MessageQueueDTO> amqp;

    @Override
    public void sendToConsumer(MessageQueueDTO message) {
        amqp.producer(message);
    }

}
