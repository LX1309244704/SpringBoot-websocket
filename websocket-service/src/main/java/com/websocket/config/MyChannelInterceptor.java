package com.websocket.config;

import java.security.Principal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;

/**
 * @ClassName: MyChannelInterceptor.java
 * @Description: TODO(头部信息处理)
 * @author vaneu(zhaoxiong1003@qq.com)
 * @date 2017年5月6日 下午4:53:01
 * @version V1.0
 */
public class MyChannelInterceptor extends ChannelInterceptorAdapter {

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {

		StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
		if (accessor != null && StompCommand.CONNECT.equals(accessor.getCommand())) {
			String group = accessor.getFirstNativeHeader("group");
			String uid = accessor.getFirstNativeHeader("uid");
			// 后期可以从数据库验证，目前暂时不做
			if (StringUtils.isNotBlank(group) && StringUtils.isNotBlank(uid)) {
				Principal principal = new BasicUserPrincipal(group, uid);
				accessor.setUser(principal);
			}
		}
		return message;
	}
}
