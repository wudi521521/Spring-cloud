package com.wudi.rabbit.springcloudamqp.publish;

import com.wudi.rabbit.springcloudamqp.config.Barista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;


import java.util.Map;

/**
 * @author Dillon Wu
 * @Title: RabbitSender
 * @Description: 消息发布端
 * @date 2019/10/18 15:16
 */
@EnableBinding(Barista.class)
@Component
public class RabbitSender {

    @Autowired
    private Barista barista;

    //发送消息
    public String sendMessage(Object message, Map<String,Object> properties) throws Exception{
        try{
            MessageHeaders messageHeaders = new MessageHeaders(properties);
            Message msg = MessageBuilder.createMessage(message,messageHeaders);
            boolean send = barista.logoutput().send(msg);
            System.err.println("-----------sending--------------");
            System.err.println("发送数据:"+message+",sendStatus:"+send);
        }catch (Exception e){
            System.err.println("---------error----------");
        }
        return null;
    }

}
