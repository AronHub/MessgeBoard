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

import com.fjt.dao.custom.RolereportCustom;
import com.fjt.pojo.Role;
import com.fjt.service.RoleService;

/**
 * 
     * @ClassName: 这是一个Dao层
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @author fujiantao
     * @date 2019年9月10日
     *
 */
public class RoleReposImpl implements RolereportCustom {

	@PersistenceContext
	private EntityManager entitymange;

	@Autowired
	private RoleService roleService;

	@Override
	public Page<Role> findRoleInfo(Pageable pageable, String rolename,
			String levl) {

		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String jpql = "select rn from Role rn where 1=1 ";
		if (rolename != null && !rolename.equals("")) {
			jpql += "and rn.name like :rolename";
			map.put("rolename", "%" + rolename + "%");

		}
		if (levl != null && !levl.equals("")) {
			jpql += " and rn.levl like :levl";
			map.put("levl", "%" + levl + "%");
		}
		jpql += " order by rn.id";

		Query query = entitymange.createQuery(jpql);
		query.setFirstResult(pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());

		if (map != null) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				String key = entry.getKey();
				Object objec = entry.getValue();
				query.setParameter(key, objec);

			}
		}

		List<Role> roles = query.getResultList();
		List<Role> list = roleService.serchAll();
		int total = list.size();
		System.out.println("total=" + total);
		Page<Role> page = new PageImpl<Role>(roles, pageable, total);
		return page;
	}

	@Override
	public void delteRole(int id) {
		// TODO Auto-generated method stub
		String jpql = "delete from Role rn where rn.id=:id";
		Query query = entitymange.createQuery(jpql);
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public void deltAll() {
		// TODO Auto-generated method stub
		String jpql = "delete from Role";
		Query query = entitymange.createQuery(jpql);
		query.executeUpdate();

	}

	@Override
	public Role getRoleByID(int id) {
		// TODO Auto-generated method stub
		String jpql = "select rn from Role rn where rn.id=?1";
		Query query = entitymange.createQuery(jpql);
		query.setParameter(1, id);
		Object obj = query.getSingleResult();
		return (Role) obj;

	}

}
