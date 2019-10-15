package com.fjt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fjt.dao.UserRepos;
import com.fjt.pojo.User;
import com.fjt.service.UserService;
import com.fjt.util.UserReporUp;

//这是一个业务层的类，完成对user domain对象的各种操作
@Service
public class UserSeviceImpl extends BaseSericeImpl implements UserService {
	@Autowired
	private UserRepos userRepos;

	@Override
	public User findUser(String username, String passwd) {
		// TODO Auto-generated method stub
		return userRepos.findUser(username, passwd);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepos.save(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void count() {
		// TODO Auto-generated method stub
		userRepos.count();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userRepos.findAllUser();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<String, Object> findPage(Pageable pageable) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		//使用 了JpaRepository接口提供的分页实现的方法findAll(Pageable pageable)
		Page<User> page = userRepos.findAll(pageable);

		List<User> content = page.getContent();
		//查询的是总的记录数
		//Long total=page.getTotalElements();
		//		//每页有几条记录。
		//		int number=page.getSize();
		//共有几页
		int pagecount = page.getTotalPages();
		map.put("content", content);
		map.put("total", pagecount);
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<String, Object> getUserInfo(Pageable pageable, String userName,
			String telp) {
		// TODO Auto-generated method stub
		Page<User> userList = userRepos.getUserInfo(pageable, userName, telp);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("content", userList.getContent());
		result.put("total", userList.getTotalElements());

		return result;
	}

	@Override
	public void delet(int id) {
		userRepos.delete(id);
	}

	@Override
	public User finOne(int id) {
		// TODO Auto-generated method stub
		return userRepos.findOne(id);
	}

	@Override
	public void reportUpload(MultipartFile file) {
		// TODO Auto-generated method stub
		UserReporUp userReporUp = new UserReporUp();
		List<User> userList = userReporUp.exreport(file);
		if (userList != null) {
			for (User user : userList) {
				this.save(user);
			}
		}

	}

	@Override
	public List<User> getUserBynameAndTelp(String userName, String telep) {
		// TODO Auto-generated method stub
		return userRepos.getUserBynameAndTelp(userName, telep);
	}

}
