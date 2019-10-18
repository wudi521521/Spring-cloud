package com.wudi.rabbit.springcloudamqp.config;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @author Dillon Wu
 * @Title: Barista
 * @Description: spring cloud stream RabbitMQ
 * 这里Barista接口是定义来作为后面类的服务，这一接口定义来通道类型型和通道名称
 * 通道名称是作为配置用，通道类型则决定了APP会使用这一通道进行发送消息还是从中接受消息
 * @date 2019/10/17 20:56
 */
@Component
public interface Barista  {

    String OUTPUT_CHANNEL="output_channel";

    String INPUT_CHANNEL="input_channel";

    /**
     * 注解@OUTPUT声明了它是一个输出类型的通道，名字是output_channel,这一名字与app1中通道名一致，表明
     * 注入了一个名字为output_channel的通道
     * @return
     */
    @Output(Barista.OUTPUT_CHANNEL)
    MessageChannel logoutput();

    /**
     * 订阅
     * 注解@Input声明了它是一个输出类型的通道，名字是Barista.loginput,这个名字与app2中铜带通达名一致,表明
     * 注入了一个名字为input_channel的通道
     * @return
     */
    @Input(INPUT_CHANNEL)
    SubscribableChannel loginput();
}
