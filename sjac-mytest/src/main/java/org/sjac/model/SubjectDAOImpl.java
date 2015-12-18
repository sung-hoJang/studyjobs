package org.sjac.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDAOImpl implements SubjectDAO{
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<SubjectVO> getAllCategory() {
		return sqlSessionTemplate.selectList("subject.getAllCategory");
	}


	@Override
	public List<SubjectVO> getAllSubject(String category) {
		return sqlSessionTemplate.selectList("group.getAllSubject", category);
	}

	@Override
	public List<SubjectVO> findSubjectBySubjectCategory(String subjectCategory) {
		return sqlSessionTemplate.selectList("subject.findSubjectBySubjectCategory", subjectCategory);
	}

	
}
