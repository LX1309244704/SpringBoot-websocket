package com.websocket.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.websocket.dto.MessageDto;
import com.websocket.dto.MessageGroupDto;
import com.websocket.dto.MessageP2pDto;
import com.websocket.enums.ESocketGroup;

import websocket.api.IWebSocketService;

/**  
* @ClassName: WebSocketController  
* @Description: TODO(消息控制)  
* @author lixin(1309244704@qq.com)  
* @date 2018年4月17日  
*    
*/ 
@Controller
@MessageMapping("/message")
public class WebSocketController {

	private @Autowired IWebSocketService websocketService;
	
	/**
	 * 广播消息(所有)
	 */
	@MessageMapping("/broadcast")
	@SendTo("/topic/broadcast")
	public MessageDto broadcast(MessageDto message) {
		return message;
	}

	/**
	 * 广播消息(页面发送的请求)
	 */
	@MessageMapping("/group")
	@SendTo("/topic/group")
	public Object group(MessageGroupDto<?> groupDto) {
		websocketService.group(ESocketGroup.valueOf(groupDto.getGroup()), groupDto.getMessage());
		return groupDto.getMessage();
	}

	/**
	 * 点对点消息
	 */
	@MessageMapping("/p2p")
	@SendToUser("/topic/p2p")
	public Object p2p(MessageP2pDto<?> p2pDto) {
		websocketService.p2p(ESocketGroup.valueOf(p2pDto.getGroup()), p2pDto.getUid(), p2pDto.getMessage());
		return p2pDto.getMessage();
	}
}
