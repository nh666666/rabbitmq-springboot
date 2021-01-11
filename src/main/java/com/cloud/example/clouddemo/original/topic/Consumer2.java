package com.cloud.example.clouddemo.original.topic;

import com.cloud.example.clouddemo.original.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/5 11:00
 */
public class Consumer2 {

    public static void main(String[] args) throws Exception {
        // 获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        // 通过连接获取连接中的通道对象
        Channel channel = connection.createChannel();

        String exchangeName = "logs_topic";
        // 通道绑定交换机
        channel.exchangeDeclare(exchangeName,"topic");
        //临时队列
        String queue = channel.queueDeclare().getQueue();
        //绑定交换机和队列
        channel.queueBind(queue,exchangeName,"user.#");

        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者-2："+new String(body));
            }
        });
    }

}
