
/**  
 * @Title: MessageService.java
 * @Package com.fjt.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author fujiantao
 * @date 2019年9月9日 下午4:13:41 
 * @version V1.0  
 */

package com.fjt.service;

import java.util.List;

import com.fjt.pojo.Message;

/**
 * @ClassName: MessageService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author fujiantao
 * @date 2019年9月9日
 *
 */

public interface MessageService extends BaseService {

	/**
	 * 
	     * @Title: 显示所以留言信息
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @return 参数
	     * @author fujiantao
	     * @return List<Message> 返回类型
	     * @throws
	 */
	List<Message> showMessage();

	void saveMessage(Message message);

}
