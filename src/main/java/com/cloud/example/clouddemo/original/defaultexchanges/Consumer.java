package com.cloud.example.clouddemo.original.defaultexchanges;

import com.cloud.example.clouddemo.original.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/5 11:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Consumer {

    //@Test
    public void testGetMessage() throws Exception{
        // 获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        // 通过连接获取连接中的通道对象
        Channel channel = connection.createChannel();
        // 通道绑定对应的消息队列
        // 参数1:队列名称(不存在的时候自动创建)
        // 参数2:用来定义队列特征是要持久化
        // 参数3:是否独占队列(true 就只能被当前连接使用)
        // 参数4:是否在消费完成后自动删除队列
        // 参数5:附加参数
        channel.queueDeclare("hello",false,false,false,null);

        // 消费消息
        //参数  消费哪个对列的消息 队列名称
        //     开启消息的自动确认机制
        //     消费时的回调接口
        channel.basicConsume("hello",true,new DefaultConsumer(channel));
        RabbitMQUtils.closeConnectionAndChanel(channel,connection);
    }

}
