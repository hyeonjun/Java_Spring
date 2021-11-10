package com.encore.rmgmt.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.rmgmt.Service.ProjectService;
import com.encore.rmgmt.Service.ProjectVO;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectDAO projectDAO;
	
	public ProjectServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("===> ProjectServiceImpl() 객체 생성");
	}
	
	// 추가
	@Override 
	public boolean insertProject(ProjectVO vo) {
		// TODO Auto-generated method stub
		return this.projectDAO.insertProject(vo);
	}
	
	// 수정
	@Override
	public boolean updateProject(ProjectVO vo) {
		// TODO Auto-generated method stub
		return this.projectDAO.updateProject(vo);
	}
	
	// 삭제
	@Override
	public boolean deleteProject(ProjectVO vo) {
		// TODO Auto-generated method stub
		return this.projectDAO.deleteProject(vo);
	}

	// 수정할 때 가져오기
	@Override
	public ProjectVO getProject(ProjectVO vo) {
		// TODO Auto-generated method stub
		return this.projectDAO.getProjectOne(vo);
	}
	
	// 메인 화면
	@Override
	public List<ProjectVO> getProjectList(ProjectVO vo) {
		// TODO Auto-generated method stub
		return this.projectDAO.getProjectList(vo);
	}

}
