package com.websocket.dto;

/**  
* @ClassName: MessageDto  
* @Description: TODO(消息)  
* @author lixin(1309244704@qq.com)  
* @date 2018年4月17日 上午9:08:45  
* @version V1.0  
*/ 
public class MessageDto implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields type : TODO(消息类别：1为通知消息，2....)
	 */
	private Integer type;
	
	/**
	 * @Fields title : TODO(消息标题)
	 */
	private String title;
	
	/**
	 * @Fields content : TODO(消息内容)
	 */
	private String content;

	public MessageDto() {
		super();
	}
	
	public MessageDto(String content) {
		super();
		this.content = content;
	}
	
	public MessageDto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public MessageDto(Integer type, String title, String content) {
		super();
		this.type = type;
		this.title = title;
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
