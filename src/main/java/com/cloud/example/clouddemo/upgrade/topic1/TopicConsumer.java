package com.cloud.example.clouddemo.upgrade.topic1;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/8 17:20
 */
@Component
public class TopicConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(
                    value = "topic_exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key={"person.*"}
    ))
    public void listen(String msg) {
        System.out.println("persion接收到消息：" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(
                    value = "topic_exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key={"person.submit"}
    ))
    public void listen2(String msg) {
        System.out.println("persion2接收到消息：" + msg);
    }
}
