package com.taotoa.common.pojo;

public class taotaores {
	private Integer status;  
	  
    // 响应消息  
    private String msg;  
  
    // 响应中的数据  
    private Object data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}  
	public taotaores() {  
        this.status = 200;  
        this.msg = "OK";  
        this.data = data;  
    }  
	public taotaores(Object data) {  
        this.status = 200;  
        this.msg = "OK";  
        this.data = data;  
    }  
	public static taotaores ok() {  
        return new taotaores(null);  
    }  
	public static taotaores ok(Object data) {  
        return new taotaores(data);  
    } 
}
