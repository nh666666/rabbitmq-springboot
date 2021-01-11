package com.cloud.example.clouddemo.upgrade.defaultexchanges1;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/8 16:36
 */
//@Component
public class ExchangeConsumer {
    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue("rabbitmq_queue"))
    public void consumMessage(String message) {
        System.out.println("消费者消费消息======" + message);
    }
}
