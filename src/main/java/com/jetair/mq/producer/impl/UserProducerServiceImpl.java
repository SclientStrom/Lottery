package com.jetair.mq.producer.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.jetair.mq.domain.User;
import com.jetair.mq.producer.ProducerService;

@Service("userPush")
public class UserProducerServiceImpl implements ProducerService {

	@Autowired
	private JmsTemplate jmstemplate;
//	@Autowired
//	@Qualifier("userServiceQueue")
	
	@Resource(name="userServiceQueue")
	private Destination destination;

	@Override
	public void push(Object info) {
		jmstemplate.send(destination, new MessageCreator() {
			@Override
			public ObjectMessage createMessage(Session session) throws JMSException {
				User userInfo=(User) info;
				return session.createObjectMessage(userInfo);
			}
		});
	}
}
