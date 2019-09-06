
/**  
 * @Title: Message.java
 * @Package com.fjt.pojo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author fujiantao
 * @date 2019年9月5日 下午5:42:22 
 * @version V1.0  
 */

package com.fjt.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
     * @ClassName: 留言板信息表
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @author fujiantao
     * @date 2019年9月5日
     *
     */

@Table(name = "Message")
@Entity
@SequenceGenerator(name = "seq_Message", sequenceName = "seq_Message")
public class Message implements Serializable {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = 1L;
	private Integer messgeId;
	private String conetent;
	private Date messageTime;
	private Integer getterId;
	private Integer senderId;

	@Id
	@Column(name = "messge_id")
	@GeneratedValue(generator = "seq_Message", strategy = GenerationType.SEQUENCE)
	public Integer getMessgeId() {
		return messgeId;
	}

	public void setMessgeId(Integer messgeId) {
		this.messgeId = messgeId;
	}

	public String getConetent() {
		return conetent;
	}

	public void setConetent(String conetent) {
		this.conetent = conetent;
	}

	@Column(name = "message_time")
	@Temporal(TemporalType.DATE)
	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	@Column(name = "getter_id")
	public Integer getGetterId() {
		return getterId;
	}

	public void setGetterId(Integer getterId) {
		this.getterId = getterId;
	}

	@Column(name = "sender_id")
	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

}
