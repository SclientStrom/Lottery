package com.jetair.db.model;

import java.util.Date;

public class LotteryPassenger {
    private Integer id;

    private String orderNo;

    private String mileageCard;

    private String surName;
    
    private String givenName;

    private String phone;

    private String cardNo;

    private String cardType;

    private String redeemVoucherNo;

    private String redeemState;

    private String lotteryVoucharNo;

    private String channel;

    private Date createTime;

    private Date optTime;

    private String points;

    private Integer betCount;
    
    private String lotteryIssue;
    private Integer times;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getMileageCard() {
        return mileageCard;
    }

    public void setMileageCard(String mileageCard) {
        this.mileageCard = mileageCard == null ? null : mileageCard.trim();
    }


    public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getRedeemVoucherNo() {
        return redeemVoucherNo;
    }

    public void setRedeemVoucherNo(String redeemVoucherNo) {
        this.redeemVoucherNo = redeemVoucherNo == null ? null : redeemVoucherNo.trim();
    }

    public String getRedeemState() {
        return redeemState;
    }

    public void setRedeemState(String redeemState) {
        this.redeemState = redeemState == null ? null : redeemState.trim();
    }

    public String getLotteryVoucharNo() {
        return lotteryVoucharNo;
    }

    public void setLotteryVoucharNo(String lotteryVoucharNo) {
        this.lotteryVoucharNo = lotteryVoucharNo == null ? null : lotteryVoucharNo.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points == null ? null : points.trim();
    }

    public Integer getBetCount() {
        return betCount;
    }

    public void setBetCount(Integer betCount) {
        this.betCount = betCount;
    }

	public String getLotteryIssue() {
		return lotteryIssue;
	}

	public void setLotteryIssue(String lotteryIssue) {
		this.lotteryIssue = lotteryIssue;
	}
	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "LotteryPassenger [id=" + id + ", orderNo=" + orderNo + ", mileageCard=" + mileageCard + ", surName="
				+ surName + ", givenName=" + givenName + ", phone=" + phone + ", cardNo=" + cardNo + ", cardType="
				+ cardType + ", redeemVoucherNo=" + redeemVoucherNo + ", redeemState=" + redeemState
				+ ", lotteryVoucharNo=" + lotteryVoucharNo + ", channel=" + channel + ", createTime=" + createTime
				+ ", optTime=" + optTime + ", points=" + points + ", betCount=" + betCount + ", lotteryIssue="
				+ lotteryIssue + ", times=" + times + "]";
	}

}
