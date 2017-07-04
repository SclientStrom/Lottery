package com.jetair.db.param;

public class PayRecordParam {
	private String mileageCard; 
	private String surName;
	private String givenName;
	private String phone;
	private String cardNo;
	private String cardType;
	private String channel;
	public String getMileageCard() {
		return mileageCard;
	}
	public void setMileageCard(String mileageCard) {
		this.mileageCard = mileageCard;
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
		this.phone = phone;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	@Override
	public String toString() {
		return "PayRecordParam [mileageCard=" + mileageCard + ", surName=" + surName + ", givenName=" + givenName
				+ ", phone=" + phone + ", cardNo=" + cardNo + ", cardType=" + cardType + ", channel=" + channel + "]";
	}
}
