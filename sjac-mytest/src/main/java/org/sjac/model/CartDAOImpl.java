package org.sjac.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAOImpl implements CartDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public List<GroupVO> getAllMyCart(String id) {
		return sqlSessionTemplate.selectList("group.getAllMyCart", id);
	}

	@Override
	public List<GroupVO> findMyCartListBySubject(Map<String, String> map) {
		return sqlSessionTemplate.selectList("group.findMyCartListBySubject", map);
	}

	@Override
	public List<GroupVO> findMyCartListByCategory(Map<String, String> map) {
		return sqlSessionTemplate.selectList("group.findMyCartListByCategory", map);
	}

	@Override
	public int MyCartCount(String id) {
		return sqlSessionTemplate.selectOne("group.MyCartCount", id);
	}
	
	@Override
	   public void waitlist(String gleaderId, String id) {
	      HashMap<String, String> map = new HashMap<String, String>();
	      map.put("gleaderId", gleaderId);
	      map.put("id", id);
	      sqlSessionTemplate.insert("group.waitlist", map);
	   }

	   @Override
	   public boolean checkCart(String gleaderId, String id) {
	      HashMap<String, String> map = new HashMap<String, String>();
	      map.put("gleaderId", gleaderId);
	      map.put("id", id);
	      boolean flag = false;
	      int count = sqlSessionTemplate.selectOne("group.checkCart", map);
	      if(count==1)
	         flag = true;
	      return flag;
	   }

	@Override
	public void deleteMyCart(Map<String, String> map) {
		sqlSessionTemplate.delete("member.deleteMyCart", map);
	}
	
	 @Override
	   public boolean checkGroupMember(String gleaderId, String id) {
	      HashMap<String, String> map = new HashMap<String, String>();
	      map.put("gleaderId", gleaderId);
	      map.put("id", id);
	      boolean flag = false;
	      int count = sqlSessionTemplate.selectOne("group.checkGroupMember", map);
	      if(count==1)
	         flag = true;
	      return flag;
	   }
	 
	 @Override
	   public void deleteMyCartById(String id) {
	      sqlSessionTemplate.delete("member.deleteMyCartById", id);
	      
	   }

	   @Override
	   public void deleteMyCartByGroupLeaderId(String id) {
	      sqlSessionTemplate.delete("member.deleteMyCartByGroupLeaderId", id);
	      
	   }

}
