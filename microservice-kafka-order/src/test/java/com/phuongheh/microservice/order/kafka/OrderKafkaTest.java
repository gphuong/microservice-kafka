package com.phuongheh.microservice.order.kafka;

import com.phuongheh.microservice.order.OrderApp;
import com.phuongheh.microservice.order.logic.OrderService;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.KafkaContainer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApp.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
@ContextConfiguration(initializers = {OrderKafkaTest.Initializer.class})
public class OrderKafkaTest {
    public static Logger logger = LoggerFactory.getLogger(OrderKafkaTest.class);
    @ClassRule
    public static KafkaContainer kafkaContainer = new KafkaContainer();
    @Autowired
    private KafkaListenerBean kafkaListenerBean;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderTest
}
