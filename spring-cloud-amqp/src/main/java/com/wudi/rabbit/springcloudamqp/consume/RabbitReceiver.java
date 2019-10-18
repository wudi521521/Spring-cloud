package com.wudi.rabbit.springcloudamqp.consume;


import com.rabbitmq.client.Channel;
import com.wudi.rabbit.springcloudamqp.config.Barista;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


/**
 * @author Dillon Wu
 * @Title: RabbitReceiver
 * @Description: TODO
 * @date 2019/10/18 15:51
 */
@EnableBinding(Barista.class)
@Component
public class RabbitReceiver {

    @StreamListener(Barista.INPUT_CHANNEL)
    public void receiver(Message message) throws Exception{
        Channel channel = (Channel)message.getHeaders().get(AmqpHeaders.CHANNEL);
        Long tag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        System.out.println("input Stream 接受消息:"+message);
        System.out.println("消费完毕:");
        channel.basicAck(tag,false);

    }
}
