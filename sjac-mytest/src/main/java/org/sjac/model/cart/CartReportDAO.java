package org.sjac.model.cart;

import java.util.List;
import java.util.Map;

public interface CartReportDAO {

	/*public Boolean checkKeyWord(String cval);

	public void insertKeyWord(String cval);

	public void countUpKeyWord(String cval);*/

	public List<CartReportVO> showCountCart();

	public int updateCartReport(String gleaderId);

	public void insertCartReport(String gleaderId);
	
	

}
