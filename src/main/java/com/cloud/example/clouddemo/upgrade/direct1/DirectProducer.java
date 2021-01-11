package com.cloud.example.clouddemo.upgrade.direct1;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/8 17:20
 */
//@Component
public class DirectProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void testSendMessage() {
        String message = "这是一个路由模式";
//        for (int i = 0; i < 10; i++) {
//            rabbitTemplate.convertAndSend("direct_exchange","direct",message+i);
//        }
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("direct_exchange","direct-test",message+i);
        }
    }
}
