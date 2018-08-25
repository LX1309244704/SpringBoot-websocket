package com.websocket.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.alibaba.dubbo.config.annotation.Service;
import com.websocket.Util.JsonUtil;
import com.websocket.enums.ESocketGroup;
import com.websocket.web.controller.WebSocketController;

import websocket.api.IWebSocketService;

/**  
* @ClassName: WebSocketServiceImpl  
* @Description: TODO(消息发送)  
* @author lixin(1309244704@qq.com)  
* @date 2018年4月17日  
*    
*/ 
@Service
public class WebSocketServiceImpl implements IWebSocketService {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);
	
	private @Autowired SimpMessagingTemplate messagingTemplate;

	@Override
	public void broadcast(Object payload) {
		String dest = "/topic/broadcast";
		logger.debug("message->broadcast:", JsonUtil.toJson(payload));
		messagingTemplate.convertAndSend(dest, payload);
	}

	@Override
	public void group(ESocketGroup group, Object payload) {
		String dest = "/topic/group." + group.name();
		logger.debug("message->group." + group.name(), JsonUtil.toJson(payload));
		messagingTemplate.convertAndSend(dest, payload);
	}

	@Override
	public void p2p(ESocketGroup group, Long uid, Object payload) {
		String user = group.name() + uid;
		String dest = "/topic/p2p." + user;
		logger.debug("message->p2p." + user, JsonUtil.toJson(payload));
		messagingTemplate.convertAndSendToUser(user, dest, payload);
	}
}
