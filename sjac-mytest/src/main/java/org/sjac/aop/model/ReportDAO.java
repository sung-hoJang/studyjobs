package org.sjac.aop.model;

import java.util.List;
import java.util.Map;

public interface ReportDAO {

	public Boolean checkKeyWord(String cval);

	public void insertKeyWord(String cval);

	public void countUpKeyWord(String cval);

	public List<ReportVO> showCount();

}
