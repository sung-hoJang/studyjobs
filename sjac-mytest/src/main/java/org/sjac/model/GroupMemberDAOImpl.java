package org.sjac.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GroupMemberDAOImpl implements GroupMemberDAO{
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public void addGroupMember(GroupMemberVO gmvo) {
		sqlSessionTemplate.insert("group.addGroupMember", gmvo);
	}


	@Override
	public List<GroupMemberVO> getMemberList(String gLeaderId) {
		 return sqlSessionTemplate.selectList("group.getMemberList",gLeaderId);
	}
	
	// 그룹장 아이디로 그룹멤버 삭제
	   @Override
	   public void deleteGroupMemberByGroupLeaderId(String id) {
	      sqlSessionTemplate.delete("group.deleteGroupMemberByGroupLeaderId", id);
	   }


	// 회원 아이디로 그룹멤버 삭제
	      @Override
	      public void deleteGroupMemberById(String id) {
	         sqlSessionTemplate.delete("group.deleteGroupMemberById", id);
       }


		@Override
		public void getAwayGroupMember(String id, String gLeaderId) {
			Map<String, String> map = new HashMap<String, String>();
		    map.put("id", id);
		    map.put("gLeaderId", gLeaderId);
		    sqlSessionTemplate.delete("group.getAwayGroupMember", map);
		}
		
		@Override
	      public void deleteAllMember(String gLeaderId) {
	         sqlSessionTemplate.delete("group.deleteAllMember", gLeaderId);
	      }

}
