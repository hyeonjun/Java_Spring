package com.encore.rmgmt.Service;

import java.util.List;

public interface ProjectService {
	
	boolean insertProject(ProjectVO vo);
	
	boolean updateProject(ProjectVO vo);
	
	boolean deleteProject(ProjectVO vo);
	
	ProjectVO getProject(ProjectVO vo);
	
	List<ProjectVO> getProjectList(ProjectVO vo);

}
