package com.cloud.example.clouddemo.upgrade.fanout1;

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
public class FanoutConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(
                    value = "finout_exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void listen(String msg) {
        System.out.println("订阅模式1 接收到消息：" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(
                    value = "finout_exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void listen2(String msg) {
        System.out.println("订阅模式2 接收到消息：" + msg);
    }
}
