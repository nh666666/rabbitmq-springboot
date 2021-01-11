package com.cloud.example.clouddemo.upgrade.topic1;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/8 17:20
 */
@Component
public class TopicProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void testSendMessage() {
        String message = "这是一个路由模式";
        rabbitTemplate.convertAndSend("topic_exchange","person.*",message+"person.*");
        rabbitTemplate.convertAndSend("topic_exchange","person.submit",message+"person.submit");
    }
}
