package com.kong.example.boot.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费rabbitmq的消息
 * 可以手动创建队列交换机 ，也可以自动创建
 */
@Component
@Slf4j
public class MqReceiver {
    //消费数据之前，先


    //1. 手动创建，需在RabbitMQ中手动创建myQueue1 队列，否则报错
//    @RabbitListener(queues = "queue.out1")
    public void process1(String message) {
        log.info("queue.out: {}", message);
    }

    //2. 自动创建队列
    @RabbitListener(queuesToDeclare = @Queue("myQueue2"))
    public void process2(String message) {
        log.info("MqReceiver2: {}", message);

    }

    /**
     * 监听时自动创建 交换机 、队列 ，并且根据key将队列和交换机绑定
     * durable 表示是否持久化
     *
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "time-exchange", durable = "true", type = "fanout"),
            value = @Queue(value = "time-exchange-data", durable = "true")
    ))
    public void time(String message) {
//        log.info("time-exchange-data: {}", message);
        //消费fanout交换机的时候不需要设置key
    }


    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "demo", durable = "true", type = "fanout"),
            value = @Queue(value = "demo-data", durable = "true")
    ))
    public void demo(String message) {
//        log.info("time-exchange-data: {}", message);
        //消费fanout交换机的时候不需要设置key
    }
}
