package com.cloud.example.clouddemo.original.direct;

import com.cloud.example.clouddemo.original.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/5 14:33
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        // 获取连接
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        // 将通道声明指定交换机  参数1: 交换机的名称  参数2 交换机的类型
        channel.exchangeDeclare("logs","direct");
        // 发送消息
        String routingKey = "error";
        channel.basicPublish("logs",routingKey,null,("fanout type message"+routingKey).getBytes());
        // 关闭资源
        RabbitMQUtils.closeConnectionAndChanel(channel,connection);
    }
}
