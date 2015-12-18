package org.sjac.model.cart;

import java.util.List;
import java.util.Map;

public interface CartReportDAO {
	/**
	 * 회원이 그룹을 찜한 횟수 보여주기
	 * @return
	 */
	public List<CartReportVO> showCountCart();
	/**
	 * 회원이 그룹을 찜한 횟수 업데이트
	 * @param gleaderId
	 * @return
	 */
	public int updateCartReport(String gleaderId);
	/**
	 * 회원이 그룹을 찜한 횟수 처음 등록 할때 
	 * @param gleaderId
	 */
	public void insertCartReport(String gleaderId);
	
	

}
