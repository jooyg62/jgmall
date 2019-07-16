package com.cafe24.jgmall.utils;

public enum JgmallMsg {
	UNDEFINED_MSG("JG0001", "Undefined Message");
	
	private String code;
	private String message;
	
	JgmallMsg(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
}
