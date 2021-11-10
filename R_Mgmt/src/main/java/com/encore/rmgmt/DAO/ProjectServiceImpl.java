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
		System.out.println("===> ProjectServiceImpl() ��ü ����");
	}
	
	// �߰�
	@Override 
	public boolean insertProject(ProjectVO vo) {
		// TODO Auto-generated method stub
		return this.projectDAO.insertProject(vo);
	}
	
	// ����
	@Override
	public boolean updateProject(ProjectVO vo) {
		// TODO Auto-generated method stub
		return this.projectDAO.updateProject(vo);
	}
	
	// ����
	@Override
	public boolean deleteProject(ProjectVO vo) {
		// TODO Auto-generated method stub
		return this.projectDAO.deleteProject(vo);
	}

	// ������ �� ��������
	@Override
	public ProjectVO getProject(ProjectVO vo) {
		// TODO Auto-generated method stub
		return this.projectDAO.getProjectOne(vo);
	}
	
	// ���� ȭ��
	@Override
	public List<ProjectVO> getProjectList(ProjectVO vo) {
		// TODO Auto-generated method stub
		return this.projectDAO.getProjectList(vo);
	}

}
