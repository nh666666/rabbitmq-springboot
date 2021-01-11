package com.cloud.example.clouddemo.upgrade.defaultexchanges1;

import com.cloud.example.clouddemo.original.RabbitMQUtils;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/8 16:36
 */
//@Component
public class ExchangeProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void testSendMessage() {
        String message = new Date() + "Beijing";
        System.out.println("生产者生产消息======" + message);
        rabbitTemplate.convertAndSend("rabbitmq_queue",message);
    }
}
