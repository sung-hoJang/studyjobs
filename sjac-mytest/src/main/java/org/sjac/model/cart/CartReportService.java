package org.sjac.model.cart;

import java.util.List;
import java.util.Map;

public interface CartReportService {

	/* public void countKeyWord(String cval); */

	public List<CartReportVO> showCountCart();

	public void saveCartReport(String gleaderId);

}
