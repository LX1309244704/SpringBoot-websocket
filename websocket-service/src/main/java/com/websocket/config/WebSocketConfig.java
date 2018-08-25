package com.websocket.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**  
* @ClassName: WebSocketConfig  
* @Description: TODO(配置)  
* @author lixin(1309244704@qq.com)  
* @date 2018年4月17日 上午9:09:48  
* @version V1.0  
*/ 
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Value("${rabbit.relay.host}")
	private String relayHost;
	@Value("${rabbit.relay.port}")
	private Integer relayPort; 
	@Value("${rabbit.client.login}")
	private String clientLogin;
	@Value("${rabbit.client.passcode}")
	private String clientPasscode;
	@Value("${rabbit.system.login}")
	private String systemLogin;
	@Value("${rabbit.system.passcode}")
	private String systemPasscode;
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/jmyps").setAllowedOrigins("*").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		registry.setUserDestinationPrefix("/user");
		// registry.enableSimpleBroker("/topic", "/queue");//内存模式
		// 启用RabbitMQ
		registry.enableStompBrokerRelay("/topic", "/queue")
			.setRelayHost(relayHost).setRelayPort(relayPort)
			.setClientLogin(clientLogin).setClientPasscode(clientPasscode)
			.setSystemLogin(systemLogin).setSystemPasscode(systemPasscode);
	}
	
	// 启用拦截
	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.interceptors(myWebSocketInterceptor());
		super.configureClientInboundChannel(registration);
	}

	@Bean
	public ChannelInterceptorAdapter myWebSocketInterceptor() {
		return new MyChannelInterceptor();
	}
	
}
