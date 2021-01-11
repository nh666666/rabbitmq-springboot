package com.cloud.example.clouddemo.original.work;

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
        //一次只能消费一个消息
        channel.basicQos(1);

        channel.queueDeclare("work",true,false,false,null);

        channel.basicConsume("work",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者-2："+new String(body));
                //手动确认，发送ack，代表当前消息消费结束，可以去消费下一个消息
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
        //RabbitMQUtils.closeConnectionAndChanel(channel,connection);
    }

}
