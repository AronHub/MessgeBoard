package com.fjt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fjt.dao.ProjRrep;
import com.fjt.pojo.Project;
import com.fjt.service.ProjectService;
import com.fjt.util.ProjectRrepUP;

@Service
public class ProjectServiceImpl extends BaseSericeImpl
		implements ProjectService {
	@Autowired
	private ProjRrep projRrep;

	@Override
	public void reportUp(MultipartFile file) {
		// TODO Auto-generated method stub
		ProjectRrepUP projectRrepUp = new ProjectRrepUP();
		List<Project> lists = projectRrepUp.check(file);
		if (lists != null) {
			for (Project project : lists) {
				projRrep.save(project);
			}
		}

	}

	@Override
	public Map<String, Object> serch(Pageable pageble,
			Map<String, String> map) {
		// TODO Auto-generated method stub
		if (pageble == null) {
			return null;
		}

		Map<String, Object> resultMap = new HashMap<String, Object>();
		Page<Project> page = projRrep.serch(pageble, map);
		if (page != null) {
			List<Project> list = page.getContent();
			int pageSize = page.getTotalPages();
			resultMap.put("content", list);
			resultMap.put("rows", pageSize);

			return resultMap;
		}

		return null;

	}

	/* (非 Javadoc)
	 * 
	 * 
	 * @param projectName
	 * @param projectId
	 * @return
	 * @see com.fjt.service.ProjectService#getProjectByNameAndID(java.lang.String, java.lang.String)
	 */

	@Override
	public List<Project> getProjectByNameAndID(String projectName,
			String projectId) {
		// TODO Auto-generated method stub
		Integer ID = Integer.valueOf(projectId);
		return projRrep.getProjectByNameAndID(projectName, ID);
	}

}
