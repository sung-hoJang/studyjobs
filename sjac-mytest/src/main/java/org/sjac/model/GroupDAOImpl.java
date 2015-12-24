package org.sjac.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class GroupDAOImpl implements GroupDAO{
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override  
	public GroupVO findGroupByLeaderId(String id) {
		return sqlSessionTemplate.selectOne("group.findGroupByLeaderId", id);
	}
	
	@Override  
	public boolean checkMyGroup(Map<String, String> map) {
		if(sqlSessionTemplate.selectOne("member.checkMyGroup", map) == null){
			return false;
		}else{
			return true;
		}
	}
	
	
	@Override
	public List<GroupVO> getAllMyGroup(String id) {
		return sqlSessionTemplate.selectList("group.getAllmyGroup", id); 
	}
	
	@Override
	public void createGroup(GroupVO vo) {
		sqlSessionTemplate.insert("group.createGroup", vo);
	}

	@Override
	public List<GroupVO> getAllGroupList() {
		return sqlSessionTemplate.selectList("group.getAllGroupList");
	}

	
    
	@Override
	public GroupVO createMyGroupInfo(String id) {
		return sqlSessionTemplate.selectOne("group.createMyGroupInfo", id);
	}

	@Override
	public List<GroupVO> findGroupListByCategory(Map<String, String> map) {
		return sqlSessionTemplate.selectList("group.findGroupListByCategory", map);
	}

	@Override
	public List<GroupVO> findMyGroupListBySubject(Map<String, String> map) {
		return sqlSessionTemplate.selectList("group.findMyGroupListBySubject", map);
	}
	


	@Override
	public List<GroupVO> findGroupListByLocation(GroupVO vo) {
		return sqlSessionTemplate.selectList("group.findGroupListByLocation",vo);
	}
	
	@Override
	public List<GroupVO> findGroupListBySubjectCategory(GroupVO vo) {
		return sqlSessionTemplate.selectList("group.findGroupListBySubjectCategory",vo);
	}

	@Override
	public List<GroupVO> findGroupListBySubject(GroupVO vo) {
		return sqlSessionTemplate.selectList("group.findGroupListBySubject",vo);
	}



	   @Override // Location+SubjectCategory
	   public List<GroupVO> findGroupListByLocationAndSubjectCategory(GroupVO vo) {
	      HashMap<String, String> paramMap = new HashMap<String, String>();
	      paramMap.put("gLocation", vo.getgLocation());
	      paramMap.put("subjectCategory", vo.getSubjectVO().getSubjectCategory());
	      return sqlSessionTemplate.selectList("group.findGroupListByLocationAndSubjectCategory", paramMap);
	   }

	   @Override // Location+Subject
	   public List<GroupVO> findGroupListByLocationAndSubject(GroupVO vo) {
	      HashMap<String, String> paramMap = new HashMap<String, String>();
	      paramMap.put("gLocation", vo.getgLocation());
	      paramMap.put("subject", vo.getSubjectVO().getSubject());
	      return sqlSessionTemplate.selectList("group.findGroupListByLocationAndSubject", paramMap);
	   }
	  
	   @Override    //Location+GName
	   public List<GroupVO> findGroupListByLocationAndGName(GroupVO vo) {
	      HashMap<String, String> paramMap = new HashMap<String, String>();
	      paramMap.put("gLocation", vo.getgLocation());
	      paramMap.put("gName", vo.getgName());
	      return sqlSessionTemplate.selectList("group.findGroupListByLocationAndGName", paramMap);
	   }
	 
	   @Override    //Location+Subject+GName
	   public List<GroupVO> findGroupListByLocationAndSubjectAndGName(GroupVO vo) {
	      HashMap<String, String> paramMap = new HashMap<String, String>();
	      paramMap.put("gLocation", vo.getgLocation());
	      paramMap.put("subject", vo.getSubjectVO().getSubject());
	      paramMap.put("gName", vo.getgName());
	      return sqlSessionTemplate.selectList("group.findGroupListByLocationAndSubjectAndGName", paramMap);
	   }
	 
	   @Override    //Location+SubjectCategory+GName
	   public List<GroupVO> findGroupListByLocationAndSubjectCategoryAndGName(GroupVO vo) {
	      HashMap<String, String> paramMap = new HashMap<String, String>();
	      paramMap.put("gLocation", vo.getgLocation());
	      paramMap.put("subjectCategory", vo.getSubjectVO().getSubjectCategory());
	      paramMap.put("gName", vo.getgName());
	      return sqlSessionTemplate.selectList("group.findGroupListByLocationAndSubjectCategoryAndGName", paramMap);
	   }
	 
	   @Override    //SubjectCategory+GName
	   public List<GroupVO> findGroupListBySubjectCategoryAndGName(GroupVO vo) {
	      HashMap<String, String> paramMap = new HashMap<String, String>();
	      paramMap.put("subjectCategory", vo.getSubjectVO().getSubjectCategory());
	      paramMap.put("gName", vo.getgName());
	      return sqlSessionTemplate.selectList("group.findGroupListBySubjectCategoryAndGName", paramMap);
	   }
	  
	   @Override   //Subject+GName
	   public List<GroupVO> findGroupListBySubjectAndGName(GroupVO vo) {
	      HashMap<String, String> paramMap = new HashMap<String, String>();
	      paramMap.put("subject", vo.getSubjectVO().getSubject());
	      paramMap.put("gName", vo.getgName());
	      return sqlSessionTemplate.selectList("group.findGroupListBySubjectAndGName", paramMap);
	   }

	   @Override  //GName
	   public List<GroupVO> findGroupListByGNameKeyword(GroupVO vo) {
	      return sqlSessionTemplate.selectList("group.findGroupListByGNameKeyword", vo);
	   }

	@Override
	public List<GroupVO> findMyJoinGroupListByCategory(Map<String, String> map) {
		return sqlSessionTemplate.selectList("group.findMyJoinGroupListByCategory", map);
	}

	@Override
	public List<GroupVO> findMyJoinGroupListBySubject(Map<String, String> map) {
		return sqlSessionTemplate.selectList("group.findMyJoinGroupListBySubject", map);
	}

	@Override
	public int MyGroupCount(String id) {
		return sqlSessionTemplate.selectOne("member.MyGroupCount", id);
	}

	// 그룹의 현재 인원 받아오기 
	   @Override
    public int getCurMember(String gLeaderId) {
	      return sqlSessionTemplate.selectOne("group.getCurMember", gLeaderId);
	   }

	   // 가입 승인시 그룹의 현재 인원 추가하기 
	   @Override
    public void updateCurMember(String gLeaderId) {
	      sqlSessionTemplate.update("group.updateCurMember", gLeaderId);
	   }

	

	@Override
	public void downCurMember(String gLeaderId) {
	    sqlSessionTemplate.update("group.downCurMember", gLeaderId);
	}

	 @Override
	   public void deleteGroupByLeaderId(String gLeaderId) {
	      sqlSessionTemplate.delete("group.deleteGroupByLeaderId", gLeaderId);
	   }	

	 @Override
	public void updateGroup(GroupVO gvo) {
		 sqlSessionTemplate.update("group.updateGroup", gvo);
	}
	 
	 @Override
	   public int allSearchCount() {
	      return sqlSessionTemplate.selectOne("report.allSearchCount");
	   }

	   @Override
	   public void updateSearchCount() {
	      sqlSessionTemplate.update("report.updateSearchCount");
	   } 
	 
	   @Override
	   public List<GroupVO> findGroupListByGNameAndGInfo(String keyText) {
	      return sqlSessionTemplate.selectList("group.findGroupListByGNameAndGInfo", keyText);
	   }


}
