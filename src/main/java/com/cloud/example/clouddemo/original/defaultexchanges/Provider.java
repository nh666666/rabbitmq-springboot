package com.cloud.example.clouddemo.original.defaultexchanges;

import com.cloud.example.clouddemo.original.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/5 10:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Provider {
    //@Test
    public void testSendMessage() throws Exception {
        // 获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        // 通过连接获取连接中的通道对象
        Channel channel = connection.createChannel();
        // 通道绑定对应的消息队列
        // 参数1:队列名称(不存在的时候自动创建)
        // 参数2:用来定义队列特征是要持久化
        //       true持久化队列，在rabbitmq重启的时候就不会删除队列，但会删除队列里面的信息
        //       false不持久化，不持久化时则在rabbitmq重启的时候就会删除队列
        // 参数3:是否独占队列(true 就只能被当前连接使用)
        //       true独占队列，false不独占
        // 参数4:是否在消费完成后自动删除队列
        //       true自动删除，false不自动删除
        // 参数5:附加参数
        channel.queueDeclare("hello",false,false,false,null);

        //发布消息
        // 参数  交换名称
        //      对列名称
        //      传递参数的额外设置
        //      消息的具体内容
        channel.basicPublish("","hello",null,"hello rabbitmq".getBytes());
        //MessageProperties.PERSISTENT_TEXT_PLAIN,在服务器重启时，不会删除队列里面的信息
        //channel.basicPublish("","hello", MessageProperties.PERSISTENT_TEXT_PLAIN,"hello rabbitmq".getBytes());
        RabbitMQUtils.closeConnectionAndChanel(channel,connection);
    }

}
