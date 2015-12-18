package org.sjac.aop.model;

import java.util.List;
import java.util.Map;

public interface ReportService {

	public void countKeyWord(String cval);

	public List<ReportVO> showCount();

}
