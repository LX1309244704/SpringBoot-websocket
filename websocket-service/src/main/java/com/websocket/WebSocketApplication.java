package com.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**  
* @ClassName: WebSocketApplication  
* @Description: TODO()  
* @author lixin(1309244704@qq.com)  
* @date 2018年4月17日 上午9:10:26  
* @version V1.0  
*/ 
@SpringBootApplication
//@EnableTransactionManagement
//@MapperScan("com.paiye.common.websocket.mapper")
public class WebSocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSocketApplication.class, args);
	}
}
