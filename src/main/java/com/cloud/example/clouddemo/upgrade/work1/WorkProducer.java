package com.cloud.example.clouddemo.upgrade.work1;

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
public class WorkProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void testSendMessage() {
        String message = "这是一个work模式";
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work_queue",message+i);
        }
    }
}
