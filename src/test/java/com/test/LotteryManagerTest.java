package com.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.jetair.common.UniqueService;
import com.jetair.lottery.manager.LotteryManager;
import com.jetair.lottery.model.LotteryRecordDto;
import com.jetair.lottery.model.request.LotteryConfirmReq;
import com.jetair.lottery.model.request.LotteryPayConfirmReq;
import com.jetair.lottery.model.response.LotteryConfirmRes;
import com.jetair.lottery.model.response.LotteryPayConfirmRes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:context/applicationContext.xml"})
@TransactionConfiguration(defaultRollback=true)
public class LotteryManagerTest {
	@Autowired
	private LotteryManager manager;
	@Test
	public void insertLotteryRecord(){
		LotteryConfirmReq request=new LotteryConfirmReq();
		request.setCardNo("410323232323323");
		request.setCardType("PP");
		request.setChannel("MN");
		request.setMileageCard("7039178100");
		request.setSurName("测试");
		request.setGivenName("双色球");
		request.setPhone("124820280323");
		request.setTimes(2);
		List<LotteryRecordDto> recordDtos=new ArrayList<>();
		LotteryRecordDto recordDto=new LotteryRecordDto();
		recordDto.setRedRecord("10 32 08 04 23 45");
		recordDto.setBlueRecord("12");
		recordDtos.add(recordDto);
		LotteryRecordDto recordDto2=new LotteryRecordDto();
		recordDto2.setRedRecord("10 32 08 04 23 45 05 10");
		recordDto2.setBlueRecord("12 16 05");
		recordDtos.add(recordDto2);
		request.setLotteryRecords(recordDtos);
		LotteryConfirmRes res=new LotteryConfirmRes();
		manager.confirmRecord(request,res);
		System.out.println(res.toString());
	}
	@Test
	public void confirmPayTest(){
		LotteryPayConfirmReq request=new LotteryPayConfirmReq();
		request.setOrderNo("2017060911375225295");
		request.setRedeemVoucher("80093456");
//		LotteryPayConfirmRes result=manager.confirmPay(request,result);
//		System.out.println(result.toString());
	}
	@Test
	public void uniqueService(){
		System.out.println(UniqueService.getUniqueStr());
	}
}
