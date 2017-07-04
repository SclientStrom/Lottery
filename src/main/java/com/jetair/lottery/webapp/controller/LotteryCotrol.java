package com.jetair.lottery.webapp.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.jetair.lottery.manager.LotteryManager;
import com.jetair.lottery.model.request.LotteryConfirmReq;
import com.jetair.lottery.model.request.LotteryPayConfirmReq;
import com.jetair.lottery.model.response.LotteryConfirmRes;
import com.jetair.lottery.model.response.LotteryPayConfirmRes;

@Controller
public class LotteryCotrol {
	@Autowired
	private LotteryManager lotterymanager;

	@RequestMapping(value={"/","/index.html"}, method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView orderList(@RequestParam(value="mileageCard",required=true) String mileageCard, 
			@RequestParam(value="surName",required=true) String surName,
			@RequestParam(value="givenName",required=true) String givenName,
			@RequestParam(value="phone",required=true) String phone,
			@RequestParam(value="cardNo",required=true) String cardNo,
			@RequestParam(value="cardType",required=false) String cardType,
			@RequestParam(value="channel",required=true) String channel,
			HttpSession session){
		Map<String, String> userMaps=new HashMap<String, String>();
		userMaps.put("mileageCard", mileageCard);
		userMaps.put("surName", surName);
		userMaps.put("givenName", givenName);
		userMaps.put("phone", phone);
		userMaps.put("cardNo", cardNo);
		userMaps.put("cardType", cardType);
		userMaps.put("channel", channel);
		ModelAndView view =new ModelAndView("/index");
		view.addObject("userInfo", userMaps);
		return view;
	}
	//查询最近一个星期的购买记录。
	@RequestMapping(value={"/payRecord.html"}, method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView payRecord(@RequestParam(value="mileageCard",required=true) String mileageCard, 
			@RequestParam(value="surName",required=false) String surName,
			@RequestParam(value="givenName",required=false) String givenName,
			@RequestParam(value="phone",required=false) String phone,
			@RequestParam(value="cardNo",required=false) String cardNo,
			@RequestParam(value="cardType",required=false) String cardType,
			@RequestParam(value="channel",required=true) String channel,
			HttpSession session){
		return null;
	}
	@RequestMapping(value = "/confirmLottery.json", method = {RequestMethod.POST })
	@ResponseBody
	public LotteryConfirmRes confirmRecord(LotteryConfirmReq request ,HttpSession session){
		LotteryConfirmRes result=new LotteryConfirmRes();
		isFilterConfirmRecord(request,result);
		result=lotterymanager.confirmRecord(request,result);
		session.setAttribute(result.getOrderNo(), result);
		return result;
	}
	private void isFilterConfirmRecord(LotteryConfirmReq request,LotteryConfirmRes result) {
		if(StringUtils.isEmpty(request.getMileageCard())){
			
		}
	}
	
	@RequestMapping(value="/payConfirm.json", method={RequestMethod.POST})
	@ResponseBody
	public LotteryPayConfirmRes confirmPay(LotteryPayConfirmReq request ,HttpSession session){
		LotteryPayConfirmRes result=new LotteryPayConfirmRes();
		LotteryConfirmRes res=(LotteryConfirmRes) session.getAttribute(request.getOrderNo());
		if(res==null){
			result.setOk(false);
			return result;
		}
		result=lotterymanager.confirmPay(request,result);
		return result;
	}
	
}
