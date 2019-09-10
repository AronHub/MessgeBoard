
/**  
 * @Title: MessageBiz.java
 * @Package com.fjt.bussiness
 * @Description: TODO(用一句话描述该文件做什么)
 * @author fujiantao
 * @date 2019年9月9日 下午4:14:58 
 * @version V1.0  
 */

package com.fjt.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fjt.pojo.Message;
import com.fjt.repositery.MessageRepo;

/**
 * @ClassName: 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author fujiantao
 * @date 2019年9月9日
 *
 */
@Component
public class MessageBiz {

	@Autowired
	private MessageRepo messageRepo;

	public List<Message> showMessage() {
		return messageRepo.showMessage();
	}

	public void saveMessage(Message message) {
		messageRepo.save(message);
	}

}
