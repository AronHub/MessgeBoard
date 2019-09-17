
/**  
 * @Title: MessageServiceImpl.java
 * @Package com.fjt.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author fujiantao
 * @date 2019年9月9日 下午4:14:06 
 * @version V1.0  
 */

package com.fjt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjt.dao.MessageRepo;
import com.fjt.pojo.Message;
import com.fjt.service.MessageService;

/**
     * @ClassName: MessageServiceImpl
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @author fujiantao
     * @date 2019年9月9日
     *
     */
@Service
public class MessageServiceImpl extends BaseSericeImpl
		implements MessageService {

	@Autowired
	private MessageRepo messageRepo;

	/* (非 Javadoc)
	 * 
	 * 
	 * @return
	 * @see com.fjt.service.MessageService#showMessage()
	 */

	@Override
	public List<Message> showMessage() {
		// TODO Auto-generated method stub
		return messageRepo.showMessage();
	}

	/* (非 Javadoc)
	 * 
	 * 
	 * @param message
	 * @see com.fjt.service.MessageService#saveMessage(com.fjt.pojo.Message)
	 */

	@Override
	public void saveMessage(Message message) {
		// TODO Auto-generated method stub
		messageRepo.save(message);
	}

}
