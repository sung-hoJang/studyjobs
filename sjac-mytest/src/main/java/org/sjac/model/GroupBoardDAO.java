package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface GroupBoardDAO {

       public int write(Map<String, Object> gbmap);

	   public List<GroupBoardVO> getGroupBoardList(Map<String, Object> gbmap);

	   public int totalContent(Object object);

	   public void updateCount(Map<String, Object> gbmap);

	   public GroupBoardVO showContent(Map<String, Object> gbmap);

	   public void updateChildBeforeDelete(Map<String, Object> gbmap);

	   public void deleteBoard(Map<String, Object> gbmap);

	   public void updateBoard(Map<String, Object> gbmap);

	   public void updateRestep(Map<String, Object> gbmap);

	   public void insertRefContent(Map<String, Object> gbmap);

	   public String getCategory(Map<String, Object> gbmap);

	   public List<GroupBoardVO> getGroupBoardTest(String gLeaderId);
	   
	   public int writeUpload(Map<String, Object> gbmap);
	   
	   // 그룹게시판 생성 매서드
       public void createGroupBoard(String id);  
       
       // 그룹게시판 시퀀스 생성 메서드
       public void createSequence(String id); 
       
       // 그룹게시판 시퀀스 드롭 메서드
       public void dropGroupBoardSequence(String id); 
       
       // 그룹게시판 드롭 메서드
       public void dropGroupBoard(String id);  

       //게시판 검색
       public List<GroupBoardVO> findboardListTitleAndContent(Map<String, Object> gbmap);
       
       //게시판 카테고리별로
       public List<GroupBoardVO> findBoardListByCategory(Map<String, Object> gbmap);
       
       //게시판 카테고리별로 키워드검색
       public List<GroupBoardVO> findCategorizedList(Map<String, Object> gbmap);
}     