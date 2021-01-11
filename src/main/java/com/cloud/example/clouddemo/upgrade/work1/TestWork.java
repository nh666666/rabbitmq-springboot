package com.cloud.example.clouddemo.upgrade.work1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2021/1/8 16:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWork {
    @Autowired
    WorkProducer workProducer;

    //@Test
    public void testExch(){
        workProducer.testSendMessage();
    }
}
