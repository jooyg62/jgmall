package com.cafe24.jgmall.dto;

public class JSONResultSender {
	private String result;  //success, fail
	private String message; //if fail, set
	private Object data;    //if success, set

	public static JSONResultSender success(Object data) {
		return new JSONResultSender("success", null, data);
	}

	public static JSONResultSender fail(String message) {
		return new JSONResultSender("fail", message, null);
	}
	
	private JSONResultSender(String result, String message, Object data) {
		this.result = result;
		this.message = message;
		this.data = data;
	}
	
	public String getResult() {
		return result;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
}
