package com.fjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fjt.dao.custom.ProjRrepCustom;
import com.fjt.pojo.Project;

public interface ProjRrep
		extends CrudRepository<Project, Integer>, ProjRrepCustom {

	@Query("select pt from Project pt where name=:projectName and id=:projectId")
	List<Project> getProjectByNameAndID(
			@Param("projectName") String projectName,
			@Param("projectId") Integer projectId);

}
