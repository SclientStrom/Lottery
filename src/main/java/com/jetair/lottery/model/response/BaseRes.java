package com.jetair.lottery.model.response;

import java.io.Serializable;

public class BaseRes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 662934066280387133L;
	private boolean ok;
	private String message;
	private String errorCode;
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "BaseRes [ok=" + ok + ", message=" + message + ", errorCode=" + errorCode + "]";
	}
}
