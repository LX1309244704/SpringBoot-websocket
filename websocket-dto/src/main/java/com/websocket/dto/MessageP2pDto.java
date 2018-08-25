package com.websocket.dto;

/**  
* @ClassName: MessageP2pDto  
* @Description: TODO(点对点消息)  
* @author lixin(1309244704@qq.com)  
* @date 2018年4月17日 上午9:08:26  
* @version V1.0  
*/ 
public class MessageP2pDto<T> implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// gc-后台用户，gp-客户，gs-大屏等
	private String group;
	// 用户唯一标识
	private Long uid;
	// 消息
	private T message;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public T getMessage() {
		return message;
	}

	public void setMessage(T message) {
		this.message = message;
	}

}
