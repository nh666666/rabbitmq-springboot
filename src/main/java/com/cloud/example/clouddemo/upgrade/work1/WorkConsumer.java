package com.cloud.example.clouddemo.upgrade.work1;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/8 16:36
 */
//@Component
public class WorkConsumer {
    // 通过注解自动创建 spring.work.queue 队列
    @RabbitListener(queuesToDeclare = @Queue("work_queue"))
    public void listen(String msg) {
        System.out.println("work模式 接收到消息：" + msg);
    }

    // 创建两个队列共同消费
    @RabbitListener(queuesToDeclare = @Queue("work_queue"))
    public void listen2(String msg) {
        System.out.println("work模式二 接收到消息：" + msg);
    }

}
