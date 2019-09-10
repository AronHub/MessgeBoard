
/**  
 * @Title: MessageRepo.java
 * @Package com.fjt.repositery
 * @Description: TODO(用一句话描述该文件做什么)
 * @author fujiantao
 * @date 2019年9月9日 下午4:16:50 
 * @version V1.0  
 */

package com.fjt.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fjt.pojo.Message;
import com.fjt.repositery.custom.MessageRepoCustom;

/**
     * @ClassName: MessageRepo
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @author fujiantao
     * @date 2019年9月9日
     *
     */

public interface MessageRepo
		extends CrudRepository<Message, Integer>, MessageRepoCustom {

	@Query("from Message ")
	List<Message> showMessage();
}
