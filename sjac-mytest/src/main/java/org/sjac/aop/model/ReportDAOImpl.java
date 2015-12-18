package org.sjac.aop.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDAOImpl implements ReportDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Boolean checkKeyWord(String cval) {
		return null;
	}

	@Override
	public void insertKeyWord(String cval) {

	}

	@Override
	public void countUpKeyWord(String cval) {

	}

	@Override
	public List<ReportVO> showCount() {
		return sqlSessionTemplate.selectList("report.showCount");
	}

}
