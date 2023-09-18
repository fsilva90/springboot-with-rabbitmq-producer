package spring.producer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import spring.producer.amqp.AmqpProducer;
import spring.producer.dto.MessageQueueDTO;

@Component
public class ProducerRabbitMQ implements AmqpProducer<MessageQueueDTO> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.exchange.producer}")
    private String exchange;

    @Override
    public void producer(MessageQueueDTO message) {
        try {
            rabbitTemplate.convertAndSend(exchange, queue, message);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
