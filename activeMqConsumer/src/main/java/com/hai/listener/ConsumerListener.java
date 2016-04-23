package com.hai.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ConsumerListener implements MessageListener{

	private static Log log = LogFactory.getLog(ConsumerListener.class);
	
	@Override
	public void onMessage(Message message) {
       if(message instanceof TextMessage){
			TextMessage tm = (TextMessage) message;
			try {
				System.out.println("-----来自对服务器监听的消息:"+tm.getText());
			} catch (JMSException e) {
				log.error("消费者接受消息异常！");
			}
		}
	}

}
