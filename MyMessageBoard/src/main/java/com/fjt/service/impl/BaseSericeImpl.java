
/**  
 * @Title: BaseSericeImpl.java
 * @Package com.fjt.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author fujiantao
 * @date 2019年9月9日 下午4:05:38 
 * @version V1.0  
 */

package com.fjt.service.impl;

import java.io.Serializable;

import com.fjt.service.BaseService;

/**
 * @ClassName: 这个类是对BaseService接口的实现
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author fujiantao
 * @date 2019年9月9日
 *
 */

public abstract class BaseSericeImpl implements BaseService {

	@Override
	public Object findById(Class clazz, Serializable id) {
		return null;
	}
}
