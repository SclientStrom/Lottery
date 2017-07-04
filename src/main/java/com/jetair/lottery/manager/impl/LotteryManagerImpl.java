package com.jetair.lottery.manager.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jetair.common.CodeService;
import com.jetair.common.TimeHelper;
import com.jetair.common.UniqueService;
import com.jetair.db.dao.LotteryPassengerDao;
import com.jetair.db.dao.LotteryRecordDao;
import com.jetair.db.model.LotteryPassenger;
import com.jetair.db.model.LotteryRecord;
import com.jetair.lottery.manager.LotteryManager;
import com.jetair.lottery.model.LotteryRecordDto;
import com.jetair.lottery.model.request.LotteryConfirmReq;
import com.jetair.lottery.model.request.LotteryPayConfirmReq;
import com.jetair.lottery.model.response.LotteryConfirmRes;
import com.jetair.lottery.model.response.LotteryPayConfirmRes;

@Component
public class LotteryManagerImpl implements LotteryManager{
	@Autowired
	private LotteryPassengerDao lotteryPassengerDao;
	@Autowired
	private LotteryRecordDao lotteryRecordDao;
	
	@Transactional(rollbackFor = { RuntimeException.class, SQLException.class,
			NestedRuntimeException.class })
	public LotteryConfirmRes confirmRecord(LotteryConfirmReq request,LotteryConfirmRes result) {
		LotteryPassenger passenger=new LotteryPassenger();
		List<LotteryRecord> records=new ArrayList<>();
		copyPassenger(passenger,request);
		copyRecord(records,request.getLotteryRecords(),passenger,request.getTimes());
//		lotteryPassengerDao.insert(passenger);
		for (LotteryRecord record : records) {
			record.setRecordId(passenger.getId());
//			lotteryRecordDao.insert(record);
		}
		copyConfirmRecordRes(result,passenger,records);
		return result;
	}

	@Transactional(rollbackFor = { RuntimeException.class, SQLException.class,
			NestedRuntimeException.class })
	@Override
	public LotteryPayConfirmRes confirmPay(LotteryPayConfirmReq request,LotteryPayConfirmRes res) {
		LotteryPassenger passenger= lotteryPassengerDao.findByOrderNo(request.getOrderNo());
		if(passenger!=null){
			updateLotterInfo(passenger,request,res);
			lotteryPassengerDao.update(passenger);
			res.setOk(true);
		}else{
			res.setOk(false);
			res.setMessage("不存在此订单");
		}
		return res;
	}
	private void updateLotterInfo(LotteryPassenger passenger,LotteryPayConfirmReq request,LotteryPayConfirmRes res) {
		passenger.setRedeemVoucherNo(request.getRedeemVoucher());
		passenger.setRedeemState(CodeService.LOTTERY_REDEEM);
	}

	private void copyConfirmRecordRes(LotteryConfirmRes result, LotteryPassenger passenger,
			List<LotteryRecord> records) {
		result.setOrderNo(passenger.getOrderNo());
		result.setBetCount(passenger.getBetCount().longValue());
		result.setPoints(passenger.getPoints());
		result.setLotteryIssue(passenger.getLotteryIssue());
		List<LotteryRecordDto> recordDtos=new ArrayList<>(records.size());
		for (LotteryRecord record : records) {
			LotteryRecordDto recordDto=new LotteryRecordDto();
			recordDto.setRedRecord(record.getRedBallRecord());
			recordDto.setBlueRecord(record.getBlueBallRecord());
			recordDto.setType(record.getType());
			recordDto.setTimes(record.getTimes());
			recordDtos.add(recordDto);
		}
		result.setRecords(recordDtos);
		result.setOk(true);
	}
	private int  getBetCount(String redBall,String blueBall){
		int redCount=redBall.split(" ").length;
		int blueCount=blueBall.split(" ").length;
		return getThisRecordCount(redCount,blueCount);
	}
	private int  getThisRecordCount(int redCount, int blueCount) {
		int recordCount=1;
		recordCount=recordCount*blueCount;
		for(int i=1;i<=6;i++){
			recordCount=recordCount*(redCount)/i;
			redCount=redCount-1;
		}
		return recordCount;
	}
	private void  copyRecord(List<LotteryRecord> records, List<LotteryRecordDto> lotteryRecords
			,LotteryPassenger passenger,Integer times) {
		if(lotteryRecords==null || lotteryRecords.isEmpty()){
			return ;
		}
		int allBetCount=0;
		if(times==null){
			times=1;
		}
		for (LotteryRecordDto lotteryRecordDto : lotteryRecords) {
			LotteryRecord record=new LotteryRecord();
			record.setRedBallRecord(lotteryRecordDto.getRedRecord());
			record.setBlueBallRecord(lotteryRecordDto.getBlueRecord());
			record.setType(getType(lotteryRecordDto));
			int theRecordBet=getBetCount(lotteryRecordDto.getRedRecord(), lotteryRecordDto.getBlueRecord());
			record.setBetCount(theRecordBet);
			record.setPoint(String.valueOf(theRecordBet*100*times));
			record.setTimes(times);
			records.add(record);
			allBetCount+=theRecordBet;
		}
		passenger.setBetCount(allBetCount);
		passenger.setTimes(times);
		passenger.setPoints(String.valueOf(allBetCount*100*times));
		
	}
	//获取为单式，还是复式。
	private String getType(LotteryRecordDto recordDto) {
		if(StringUtils.isEmpty(recordDto.getType())){
			String []redBalls=recordDto.getRedRecord().split(" ");
			String []blueBalls=recordDto.getBlueRecord().split(" ");
			if(redBalls.length==6 && blueBalls.length==1){
				return CodeService.LOTTERY_SIMPLE;
			}
			return CodeService.LOTTERY_MULTIPLE;
		}
		return recordDto.getType();
	}
	private void copyPassenger(LotteryPassenger passenger,
			LotteryConfirmReq request) {
		passenger.setMileageCard(request.getMileageCard());
		passenger.setCardNo(request.getCardNo());
		passenger.setCardType(request.getCardType());
		passenger.setChannel(request.getChannel());
		passenger.setSurName(request.getSurName());
		passenger.setGivenName(request.getGivenName());
		passenger.setPhone(request.getPhone());
		passenger.setCreateTime(TimeHelper.getCurrentDate());
		passenger.setOrderNo(UniqueService.getUniqueStr());
		passenger.setRedeemState(CodeService.LOTTERY_WAIT_REDEEM);
	}
}
