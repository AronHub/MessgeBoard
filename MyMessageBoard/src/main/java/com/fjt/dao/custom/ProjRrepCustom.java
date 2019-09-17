package com.fjt.dao.custom;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fjt.pojo.Project;

public interface ProjRrepCustom {

	public Page<Project> serch(Pageable pageb, Map<String, String> map);

}
