
/**  
 * @Title: BaseService.java
 * @Package com.fjt.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author fujiantao
 * @date 2019年9月9日 下午2:31:54 
 * @version V1.0  
 */

package com.fjt.service;

import java.io.Serializable;

/**
 * @ClassName: 基础接口，把所有接口中通用的方法封装在这里
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author fujiantao
 * @date 2019年9月9日
 *
 */

public interface BaseService {
	//通过id,来获取一个对象实例
	public Object findById(Class clazz, Serializable id);

}
