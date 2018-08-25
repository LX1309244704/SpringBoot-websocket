package websocket.api;

import com.websocket.enums.ESocketGroup;

/**  
* @ClassName: IWebSocketService  
* @Description: TODO(消息发送)  
* @author lixin(1309244704@qq.com)  
* @date 2018年4月17日  
*    
*/ 
public interface IWebSocketService {

	/**
	 * @Title: broadcast 
	 * @Description: TODO(广播-所有) 
	 * @param payload 消息DTO
	 */
	public void broadcast(Object payload);
	
	/**
	 * @Title: group 
	 * @Description: TODO(分组广播) 
	 * @param ESocketGroup 分组
	 * @param payload 消息DTO
	 */
	public void group(ESocketGroup group, Object payload);

	/**
	 * @Title: p2p 
	 * @Description: TODO(点对点) 
	 * @param ESocketGroup gc=后台，p=客户，s=大屏
	 * @param uid 编号
	 * @param payload 消息DTO
	 */
	public void p2p(ESocketGroup group, Long uid, Object payload);
}
