package com.hq.util;

import javax.jms.JMSException;
import javax.jms.Session;

import javax.jms.Destination;
import javax.jms.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Producers {

	/**
	 * @param args
	 *            jmsTemplate和destination都是在spring配置文件中进行配制的
	 *            Sender只使用了配置文件中的jmsFactory，jmsTemplate，还有destination这三个属性
	 */
	public static void main(String[] args) {
		// 加载spring配置文件
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext-mq.xml");
		// 获取配置文件中定义的queuejmsTemplate的bean对象
		JmsTemplate template = (JmsTemplate) applicationContext.getBean("queuejmsTemplate");
		// template中已经定义了目标对象，这里可以注释
//		Destination destination = (Destination) applicationContext.getBean("destination");
		for (int i = 0; i < 10; i++) {
			final String s = "发送消息：queue Message！"+i;
			// 发送消息
			template.send(new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(s);
				}
			});
		}
		
		// 获取配置文件中定义的jmsTopicTemplate的bean对象，topic对象
		JmsTemplate toptemplate = (JmsTemplate) applicationContext.getBean("jmsTopicTemplate");
//		Destination topdestination = (Destination) applicationContext.getBean("destination");
//		for (int i = 0; i < 10; i++) {
//			final String s = "发送消息：topic Message！"+i;
//			// 发送消息
//			toptemplate.send( new MessageCreator() {
//				public Message createMessage(Session session) throws JMSException {
//					return session.createTextMessage(s);
//				}
//			});
//		}
		System.out.println("完成");
	}
}
