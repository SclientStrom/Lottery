package com.jetair.mq.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jetair.mq.domain.User;
import com.jetair.mq.producer.ProducerService;
import com.jetair.mq.web.response.ResultRespone;

@Controller
@RequestMapping("/push")
public class PushController {
	
	@Resource(name="userPush")
	private ProducerService userPushService;
	
	
	@RequestMapping(value="/user",method=RequestMethod.POST)  
    @ResponseBody  
    public ResultRespone userPush(User info){  
        ResultRespone respone = new ResultRespone();  
        try {  
        	userPushService.push(info);  
            respone.setData(info);  
        } catch (Exception e) {  
            e.printStackTrace();  
            respone = new ResultRespone(false, e.getMessage());  
        }  
        return respone;  
    }  
	
	@RequestMapping(value="/",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView getPushPage(HttpSession session){
		return new ModelAndView("/mqpush");
	}
}
