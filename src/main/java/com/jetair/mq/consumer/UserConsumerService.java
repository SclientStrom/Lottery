package com.jetair.mq.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.jetair.mq.domain.User;
import net.sf.json.JSONObject;

public class UserConsumerService implements MessageListener{
	 protected static final Logger logger = Logger.getLogger(UserConsumerService.class);  
	public void onMessage(Message message) {
////		TextMessage textMessage = (TextMessage) message;  
//      
//		try {  
//            //获取数据  
//            String jsonStr = textMessage.getText();  
//            if (jsonStr != null) {  
////            	JSONObject jsonobject = JSONObject.fromObject(jsonStr);
////            	User user= (User)JSONObject.toBean(jsonobject,User.class);
//            	User user=JSON.parseObject(jsonStr, User.class);
//                System.out.println("==============================接受到的用户信息 开始====================================");  
//                System.out.println(user.toString());  
//                System.out.println("==============================接受到的用户信息 结束====================================");  
////              WebsocketController.broadcast("user", jsonStr);  
//            }  
//        } catch (JMSException e) {  
//            logger.error("[UserPushListener.onMessage]:receive message occured an exception",e);  
//        }  
		
		  ObjectMessage objectMessage=(ObjectMessage) message;
		try {
			System.out.println("==============================接受到的用户信息 开始====================================");  
			User user=(User) objectMessage.getObject();
			System.out.println(user.toString());
			System.out.println("==============================接受到的用户信息 结束===================================="); 
		} catch (JMSException e) {
			logger.error("[UserPushListener.onMessage]:receive message occured an exception", e);
		}
	}

}
