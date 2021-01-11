package com.cloud.example.clouddemo.original;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/5 10:30
 */
public class RabbitMQUtils {
    private static ConnectionFactory connectionFactory;
    static {
        // 创建连接mq的连接工厂
        connectionFactory = new ConnectionFactory();
        // 设置链接rabbitmq主机
        connectionFactory.setHost("10.4.7.116");
        // 设置主机端口号
        connectionFactory.setPort(5672);
        // 设置连接哪个虚拟主机
        connectionFactory.setVirtualHost("/ems");
        // 设置访问虚拟主机的用户名和密码
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");
    }

    public static Connection getConnection(){
        try {
            return connectionFactory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnectionAndChanel(Channel channel,Connection connection){
        try {
            if(channel != null) channel.close();
            if(connection != null) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
