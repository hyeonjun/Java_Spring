package com.encore.spring.study;

import java.util.List;

public interface StudyService {
	
	void insertStudy(StudyVO vo);
	
	void updateStudy(StudyVO vo);
	
	void deleteStudy(StudyVO vo);
	
	StudyVO getStudy(StudyVO vo);
	
	List<StudyVO> getStudyList(StudyVO vo);

}
