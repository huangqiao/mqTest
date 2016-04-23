package com.hai.util;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * JMS消费者
 * 消息题的内容定义
 * 消息对象 接收消息对象后： 接收到的消息体* <p> 
 */
public class Consumer2 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    	System.out.println("初始化消息消费者");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-mq.xml");
        JmsTemplate template = (JmsTemplate) applicationContext.getBean("jmsTemplate");  
        Destination destination = (Destination) applicationContext.getBean("destination");  
        while (true) {  
                TextMessage txtmsg = (TextMessage) template.receive(destination);  
					try {
						 if (null != txtmsg){
							 System.out.println("消费者2：手动收到消息内容为: " + txtmsg.getText());
						 }else{
							 break; 
						 }	
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        }  
        
       
    }

}