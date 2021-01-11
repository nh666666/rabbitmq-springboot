package com.cloud.example.clouddemo.upgrade.direct1;

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
//@Component
public class DirectConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(
                    value = "direct_exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.DIRECT
            ),
            key={"direct"}
    ))
    public void listen(String msg) {
        System.out.println("路由模式1 接收到消息：" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(
                    value = "direct_exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.DIRECT
            ),
            key={"direct","direct-test"}
    ))
    public void listen2(String msg) {
        System.out.println("路由模式2 接收到消息：" + msg);
    }
}
