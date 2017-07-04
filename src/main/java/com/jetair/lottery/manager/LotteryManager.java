package com.jetair.lottery.manager;

import com.jetair.lottery.model.request.LotteryConfirmReq;
import com.jetair.lottery.model.request.LotteryPayConfirmReq;
import com.jetair.lottery.model.response.LotteryConfirmRes;
import com.jetair.lottery.model.response.LotteryPayConfirmRes;

public interface LotteryManager {
	
	public LotteryConfirmRes confirmRecord(LotteryConfirmReq request,LotteryConfirmRes result);
	
	public LotteryPayConfirmRes confirmPay(LotteryPayConfirmReq  request, LotteryPayConfirmRes res);
	
}
