package com.hq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ConsumerListenerQueue implements MessageListener{

	private static Log log = LogFactory.getLog(ConsumerListenerQueue.class);
	
	@Override
	public void onMessage(Message message) {
       if(message instanceof TextMessage){
			TextMessage tm = (TextMessage) message;
			try {
				if(1==1){
//					System.out.println("-----来自对服务器监听的消息:"+tm.getText());
					System.out.println("-----来自对服务器监听的消息:"+tm.getText());
					throw new RuntimeException();
				}
			} catch (JMSException e) {
				log.error("消费者接受消息异常！",e);
			}
		}
	}

}
