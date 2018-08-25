package com.websocket.dto;

/**  
* @ClassName: MessageGroupDto  
* @Description: TODO(分组广播)  
* @author lixin(1309244704@qq.com)  
* @date 2018年4月17日  
* @version V1.0  
*/ 
public class MessageGroupDto<T> implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// gc-后台用户，gp-客户，gs-大屏等
	private String group;
	
	// 消息结构
	private T message;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public T getMessage() {
		return message;
	}

	public void setMessage(T message) {
		this.message = message;
	}

}
