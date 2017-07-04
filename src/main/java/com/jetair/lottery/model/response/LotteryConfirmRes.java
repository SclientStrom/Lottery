package com.jetair.lottery.model.response;

import java.io.Serializable;
import java.util.List;

import com.jetair.lottery.model.LotteryRecordDto;
public class LotteryConfirmRes extends BaseRes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8172690168120255194L;
	private List<LotteryRecordDto> records;
	private String points;
	private Long betCount;
	private String orderNo;
	private String lotteryIssue;
	
	public List<LotteryRecordDto> getRecords() {
		return records;
	}
	
	public void setRecords(List<LotteryRecordDto> records) {
		this.records = records;
	}
	
	public String getLotteryIssue() {
		return lotteryIssue;
	}
	public void setLotteryIssue(String lotteryIssue) {
		this.lotteryIssue = lotteryIssue;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public Long getBetCount() {
		return betCount;
	}
	public void setBetCount(Long betCount) {
		this.betCount = betCount;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "LotteryConfirmRes [records=" + records + ", points=" + points + ", betCount=" + betCount + ", orderNo="
				+ orderNo + ", lotteryIssue=" + lotteryIssue + "]";
	}
}
