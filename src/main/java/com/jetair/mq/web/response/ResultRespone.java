package com.jetair.mq.web.response;


public class ResultRespone {

	private Object data;
	private boolean ok=true;
	private String message;
	
	public ResultRespone() {
		super();
	}

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

	public Object getData() {
		return data;
	}

	public ResultRespone(boolean ok, String message) {
		this.ok=ok;
		this.message=message;
	}

	public void setData(Object info) {
		this.data=info;
	}

}
