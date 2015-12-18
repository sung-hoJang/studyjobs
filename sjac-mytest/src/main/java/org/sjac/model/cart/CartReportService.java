package org.sjac.model.cart;

import java.util.List;
import java.util.Map;

public interface CartReportService {
	/**
	 *  회원이 찜한 그룹 갯수 보여주기
	 * @return
	 */
	public List<CartReportVO> showCountCart();
		/**
		 * 이미 찜했던 그룹일 경우 찜 조회수를 1 높여주고
		 * 새로운 그룹경우 찜하기 기록에 새로 저장해준다.
		 * @param gleaderId
		 */
	public void saveCartReport(String gleaderId);

}
