package com.fjt.dao.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fjt.pojo.Role;

public interface RolereportCustom {

	public Page<Role> findRoleInfo(Pageable pageable, String rolename,
			String levl);

	public void delteRole(int id);

	public void deltAll();

	public Role getRoleByID(int id);
}
