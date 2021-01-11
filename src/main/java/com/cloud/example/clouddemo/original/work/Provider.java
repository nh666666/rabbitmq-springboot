package com.cloud.example.clouddemo.original.work;

import com.cloud.example.clouddemo.original.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/5 10:29
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        // 获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        // 获取通道对象
        Channel channel = connection.createChannel();
        // 通过通道声明队列
        channel.queueDeclare("work",true,false,false,null);
        for (int i = 0; i < 20; i++) {
            // 生成消息
            channel.basicPublish("","work",null,(i+"hello rabbitmq").getBytes());
        }
        //关闭资源
        RabbitMQUtils.closeConnectionAndChanel(channel,connection);
    }

}
