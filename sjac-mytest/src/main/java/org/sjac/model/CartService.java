package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface CartService {
	
	/**
	 * 내 찜 리스트 가져오기
	 * @param id
	 * @return
	 */
	public List<GroupVO> getAllMyCart(String id);

	/**
	 * 서브젝트로 내 찜 리스트 찾기
	 * @param map
	 * @return
	 */
	public List<GroupVO> findMyCartListBySubject(Map<String, String> map);

	/**
	 * 카테고리로 내 찜 리스트 찾기
	 * @param map
	 * @return
	 */
	public List<GroupVO> findMyCartListByCategory(Map<String, String> map);
	
	/**
	 * 내 찜 개수
	 * @param id
	 * @return
	 */
	public int MyCartCount(String id);
	
	/**
	 * 찜하기
	 * @param gleaderId
	 * @param id
	 */
	public void waitlist(String gleaderId, String id);
	
	/**
	 * 자신이 찜을 했던 그룹인지 아닌지 체크
	 * @param gleaderId
	 * @param id
	 * @return
	 */
	public boolean checkCart(String gleaderId, String id);
	
	/**
	 * 내 찜 삭제 
	 * @param map
	 */
	public void deleteMyCart(Map<String, String> map);
	
}
