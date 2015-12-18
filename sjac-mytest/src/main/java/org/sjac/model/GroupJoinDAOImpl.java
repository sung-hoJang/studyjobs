package org.sjac.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GroupJoinDAOImpl implements GroupJoinDAO{
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<GroupJoinVO> getAllJoinRequestList(String gLeaderId) {
		return sqlSessionTemplate.selectList("join.getAllJoinRequestList", gLeaderId);
	}

  
 
	@Override
	public List<GroupVO> getAllJoinRequestGroup(String id) {
		return sqlSessionTemplate.selectList("group.getAllJoinRequestGroup", id);
	}

	@Override
	public void joinGroup(GroupJoinVO gjvo) {
		sqlSessionTemplate.insert("join.joinGroup", gjvo);
	}

	@Override
	public void deleteRequestGroup(Map<String, String> map) {
		sqlSessionTemplate.delete("group.deleteRequestGroup" , map);
	}

	@Override
	public void joinGroupUpdate(GroupJoinVO gjvo) {
		sqlSessionTemplate.update("join.joinGroupUpdate", gjvo);
	}

	@Override
	public GroupJoinVO getMyJoinRequest(Map<String, String> map) {
		return sqlSessionTemplate.selectOne("join.getMyJoinRequest", map);
	}

	@Override
	public int MyRequestGroupCount(String id) {
		return sqlSessionTemplate.selectOne("join.MyRequestGroupCount", id);
	}

	// 그룹장 아이디로 그룹 조인 리스트 받아오기 
	   @Override
	   public List<GroupVO> getGroupJoinListByGroupLeaderId(String id) {
	      return sqlSessionTemplate.selectList("group.getGroupJoinListByGroupLeaderId",id);
	}

	 //그룹장 아이디로 그룹멤버 삭제
	   @Override
	   public void deleteGroupJoinByGroupLeaderId(String id) {
	      sqlSessionTemplate.delete("group.deleteGroupJoinByGroupLeaderId", id);
	}

	   @Override
	   public void deleteGroupJoinById(String id) {
	      sqlSessionTemplate.delete("group.deleteGroupJoinById", id);
	   }

}
