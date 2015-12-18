package org.sjac.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	@Resource
	private CartDAO cartDAO;

	
	@Override
	public List<GroupVO> getAllMyCart(String id) {
		return cartDAO.getAllMyCart(id);
	}

	@Override
	public List<GroupVO> findMyCartListBySubject(Map<String, String> map) {
		return cartDAO.findMyCartListBySubject(map);
	}

	@Override
	public List<GroupVO> findMyCartListByCategory(Map<String, String> map) {
		return cartDAO.findMyCartListByCategory(map);
	}

	@Override
	public int MyCartCount(String id) {
		return cartDAO.MyCartCount(id);
	}

	@Override
	public void waitlist(String gleaderId, String id) {
		cartDAO.waitlist(gleaderId, id);
	}

	@Override
	public boolean checkCart(String gleaderId, String id) {
		if ((cartDAO.checkGroupMember(gleaderId, id)) || (cartDAO.checkCart(gleaderId, id)))
			return true;
		else
			return false;
	}

	@Override
	public void deleteMyCart(Map<String, String> map) {
		cartDAO.deleteMyCart(map);
	}

}
