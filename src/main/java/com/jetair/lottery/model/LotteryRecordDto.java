package com.jetair.lottery.model;

import java.io.Serializable;

public class LotteryRecordDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4025847617813516579L;
	private String redRecord;
	private String blueRecord;
	private String type;  //type : 0 位单式，1：复式。单式：一个记录只有一注，复式：一个记录有多注。
	private Integer times;
	public String getRedRecord() {
		return redRecord;
	}
	public void setRedRecord(String redRecord) {
		this.redRecord = redRecord;
	}
	public String getBlueRecord() {
		return blueRecord;
	}
	public void setBlueRecord(String blueRecord) {
		this.blueRecord = blueRecord;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	@Override
	public String toString() {
		return "LotteryRecordDto [redRecord=" + redRecord + ", blueRecord=" + blueRecord + ", type=" + type + ", times="
				+ times + "]";
	}
}
