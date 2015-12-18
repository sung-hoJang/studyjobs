package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface CartService {
	
	public List<GroupVO> getAllMyCart(String id);

	public List<GroupVO> findMyCartListBySubject(Map<String, String> map);

	public List<GroupVO> findMyCartListByCategory(Map<String, String> map);
	
	public int MyCartCount(String id);
	
	public void waitlist(String gleaderId, String id);
	
	public boolean checkCart(String gleaderId, String id);
	 
	public void deleteMyCart(Map<String, String> map);
	
}
