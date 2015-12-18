package org.sjac.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SubjectService {
	//모든 카테고리 받아오는 함수
	public List<SubjectVO> getAllCategory();		
	
	// 카테고리로 서브젝트 리스트 받아오는 함수 
	public List<SubjectVO> getAllSubject(String category); 
	
	 //과목에 해당하는 카테고리 받아오는 함수
	public List<SubjectVO> findSubjectBySubjectCategory(String subjectCategory);  
}
