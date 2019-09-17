package com.fjt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.fjt.dao.custom.ProjRrepCustom;
import com.fjt.pojo.Project;

/**
 * 
     * @ClassName: 这是一个Dao层
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @author fujiantao
     * @date 2019年9月10日
     *
 */
public class ProjRrepImpl implements ProjRrepCustom {

	@PersistenceContext
	private EntityManager entitymange;

	@Override
	public Page<Project> serch(Pageable pageb, Map<String, String> map) {
		String hql = "select pt from Project pt where 1=1 ";
		HashMap<String, Object> param = new HashMap<String, Object>();
		if (map.get("projeName") != null && !map.get("projeName").equals("")) {
			hql += " and pt.name like :projeName ";
			param.put("projeName", "%" + map.get("projeName") + "%");
		}

		if (map.get("projeNo") != null && !map.get("projeNo").equals("")) {
			hql += "and pt.id=:projeNo  ";
			//这边注意要把map.get("projeNo")转换成integer，不然会报类型转换异常
			param.put("projeNo", Integer.valueOf(map.get("projeNo")));

		}

		// TODO Auto-generated method stub
		Query query = entitymange.createQuery(hql);
		query.setFirstResult(pageb.getOffset());
		query.setMaxResults(pageb.getPageSize());

		for (Map.Entry<String, Object> enty : param.entrySet()) {
			String key = enty.getKey();
			Object value = enty.getValue();
			query.setParameter(key, value);
		}

		List<Project> list = query.getResultList();
		//int total = this.serchAll().size();
		int total = 0;
		Page<Project> pages = new PageImpl<Project>(list, pageb, total);

		return pages;
	}

}
