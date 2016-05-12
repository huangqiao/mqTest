package com.hq.util;

import javax.jms.JMSException;
import javax.jms.Session;

import javax.jms.Destination;
import javax.jms.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Producers2 {

	/**
	 * @param args
	 *            jmsTemplate和destination都是在spring配置文件中进行配制的
	 *            Sender只使用了配置文件中的jmsFactory，jmsTemplate，还有destination这三个属性
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext-mq.xml");
		JmsTemplate template = (JmsTemplate) applicationContext.getBean("jmsTemplate");
//		Destination destination = (Destination) applicationContext.getBean("destination");
		for (int i = 20000; i < 30000; i++) {
			final String s = "发送消息：queue Message！"+i;
			template.send(new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(s);
				}
			});
		}
		
//		JmsTemplate toptemplate = (JmsTemplate) applicationContext.getBean("jmsTopicTemplate");
//		Destination topdestination = (Destination) applicationContext.getBean("destination");
//		for (int i = 200; i < 300; i++) {
//			final String s = "发送消息：topic Message！"+i;
//			toptemplate.send( new MessageCreator() {
//				public Message createMessage(Session session) throws JMSException {
//					return session.createTextMessage(s);
//				}
//			});
//		}
		System.out.println("成功发送了一条JMS消息");
	}
}
