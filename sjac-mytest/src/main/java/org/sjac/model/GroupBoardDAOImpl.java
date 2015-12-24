package org.sjac.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GroupBoardDAOImpl implements GroupBoardDAO{
   @Resource
   private SqlSessionTemplate sqlSessionTemplate;
   
   
   @Override
   public int write(Map<String, Object> gbmap) {
      return (Integer) sqlSessionTemplate.insert("groupBoard.write", gbmap);
   }

   @Override
   public List<GroupBoardVO> getGroupBoardList(Map<String, Object> gbmap) {
      return sqlSessionTemplate.selectList("groupBoard.getGroupBoardList", gbmap);
   }

   @Override
   public int totalContent(Object table) {
      String stable = (String) table;
      return sqlSessionTemplate.selectOne("groupBoard.totalContent", stable);
   }

   @Override
   public void updateCount(Map<String, Object> gbmap) {
      sqlSessionTemplate.update("groupBoard.updateCount", gbmap);   
   }
   
   @Override
   public GroupBoardVO showContent(Map<String, Object> gbmap) {
      return (GroupBoardVO)sqlSessionTemplate.selectOne("groupBoard.showContent", gbmap);
   }

   @Override
   public void updateChildBeforeDelete(Map<String, Object> gbmap) {
	   //System.out.println("^^" +  gbmap);
	   GroupBoardVO gbvo = sqlSessionTemplate.selectOne("groupBoard.getGroupBoard", gbmap);
	      if(gbvo != null){
	         gbmap.put("ref", gbvo.getRef());
	         gbmap.put("restep", gbvo.getRestep());
	         gbmap.put("relevel", gbvo.getRelevel());
	         if(gbvo.getRelevel()==0){
	        	 System.out.println("$1");
	 			sqlSessionTemplate.update("groupBoard.updateChild1", gbmap);
	         } else {
	 			List<Object> restepList = sqlSessionTemplate.selectList("groupBoard.findNextSibling", gbmap);
	 			if(restepList.isEmpty()){
		        	 System.out.println("$2");
					sqlSessionTemplate.update("groupBoard.updateChild2", gbmap);
				}else{
		        	 System.out.println("$3");
					gbmap.put("siblingRestep", restepList.get(0));
					sqlSessionTemplate.update("groupBoard.updateChild3", gbmap);
				}
	         }
	      }    
   }

   @Override
   public void deleteBoard(Map<String, Object> gbmap) {
      sqlSessionTemplate.delete("groupBoard.deleteGroupBoard", gbmap);      
   }

   @Override
   public void updateBoard(Map<String, Object> gbmap) {
      sqlSessionTemplate.update("groupBoard.updateGroupBoard", gbmap);
   }

   @Override
   public void updateRestep(Map<String, Object> gbmap) {
      sqlSessionTemplate.update("groupBoard.updateRestep", gbmap);         
   }

   @Override
   public void insertRefContent(Map<String, Object> gbmap) {
      sqlSessionTemplate.insert("groupBoard.writeReply", gbmap);            
   }
   @Override
   public List<GroupBoardVO> getGroupBoardTest(String gLeaderId) {
      return sqlSessionTemplate.selectList("groupBoard.getGroupBoardTest", gLeaderId);
   }

   @Override
   public void createGroupBoard(String id) {
      sqlSessionTemplate.insert("group.createGroupBoard", id);
   }

   @Override
   public void createSequence(String id) {
      sqlSessionTemplate.insert("group.createSequence", id);
   }
   
   // 그룹보드 시퀀스 삭제
   @Override
   public void dropGroupBoardSequence(String id) {
      sqlSessionTemplate.update("group.dropGroupBoardSequence", id);
      
   }
   // 그룹보드 삭제
   @Override
   public void dropGroupBoard(String id) {
      sqlSessionTemplate.update("group.dropGroupBoard", id);
      
   }

@Override
public int writeUpload(Map<String, Object> gbmap) {
	return (Integer) sqlSessionTemplate.insert("groupBoard.writeUpload", gbmap);
}
   
@Override
public List<GroupBoardVO> findboardListTitleAndContent(Map<String, Object> gbmap) {
 return sqlSessionTemplate.selectList("groupBoard.findboardListTitleAndContent", gbmap);
}  

// 게시판 카테고리별
@Override
public List<GroupBoardVO> findBoardListByCategory(Map<String, Object> gbmap) {
 return sqlSessionTemplate.selectList("groupBoard.findBoardListByCategory", gbmap);
}
// 게시판 카테고리별 키워드 검색
@Override
public List<GroupBoardVO> findCategorizedList(Map<String, Object> gbmap) {
 return sqlSessionTemplate.selectList("groupBoard.findCategorizedList", gbmap);
}
   
}