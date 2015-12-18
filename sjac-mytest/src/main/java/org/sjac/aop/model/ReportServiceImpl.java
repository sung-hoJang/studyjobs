package org.sjac.aop.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService{
	@Resource
	private ReportDAO reportDAO;
	
	@Override
	public void countKeyWord(String cval) {
		
	}

	@Override
	public List<ReportVO> showCount() {
		return reportDAO.showCount();
	}
	
}
