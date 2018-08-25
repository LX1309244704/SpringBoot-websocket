package com.websocket.config;

import java.security.Principal;

/**  
* @ClassName: BasicUserPrincipal  
* @Description: TODO(用户信息)  
* @author lixin(1309244704@qq.com)  
* @date 2018年4月17日 上午9:09:31  
* @version V1.0  
*/ 
public class BasicUserPrincipal implements Principal {

	private String group;
	private String uid;

	public BasicUserPrincipal(String group, String uid) {
		super();
		this.group = group;
		this.uid = uid;
	}

	@Override
	public String getName() {
		return this.group + this.uid;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
