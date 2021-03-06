package com.fjt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.fjt.dao.UserRepos;
import com.fjt.dao.custom.PageCustom;
import com.fjt.dao.custom.UserReporsCustom;
import com.fjt.pojo.User;

/**
 * 这是一个Dao层
 * 这边是自定义接口的实现类，这边主要实现类的名称（前缀是：UserRepos）
 * @author fujiantao
 *
 */
public class UserReposImpl implements UserReporsCustom, PageCustom {

	@PersistenceContext
	private EntityManager entitymanager;

	@Autowired
	private UserRepos userRepos;

	@Override
	public Page<User> getUserInfo(Pageable pageable, String userName,
			String telp) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		String jpql = "select us  from User us where 1=1 ";
		if (null != userName && !"".equals(userName)) {
			jpql += "and us.name like :userName";
			map.put("userName", "%" + userName + "%");
		}
		if (null != telp && !"".equals(telp)) {
			jpql += " and us.telep like :telp";
			map.put("telp", "%" + telp + "%");
		}

		Query query = entitymanager.createQuery(jpql);
		//setFirstResult表示从第几条开始。
		query.setFirstResult(pageable.getOffset());
		//setMaxResults表示取几条记录。
		query.setMaxResults(pageable.getPageSize());

		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
		}
		@SuppressWarnings("unchecked")
		List<User> content = query.getResultList();
		List<User> userList = userRepos.findAllUser();
		int total = userList.size();
		Page<User> pageUser = new PageImpl<User>(content, pageable, total);
		return pageUser;
	}

	@Override
	public void contAll() {
		// TODO Auto-generated method stub
		System.out.println("这边是操作数据库的代码");
	}

}
