package com.jetair.lottery.model.request;

import java.io.Serializable;

public class LotteryPayConfirmReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5492036921083826241L;
	private String orderNo;
	private String redeemVoucher;
	private String points;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getRedeemVoucher() {
		return redeemVoucher;
	}
	public void setRedeemVoucher(String redeemVoucher) {
		this.redeemVoucher = redeemVoucher;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "LotteryPayConfirmReq [orderNo=" + orderNo + ", redeemVoucher=" + redeemVoucher + "]";
	}
}
