package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface GroupBoardDAO {
		/**
		 * 그룹게시판 글쓰기
		 * @param gbmap
		 * @return
		 */
       public int write(Map<String, Object> gbmap);
       
       /**
        * 그룹게시판 리스트
        * @param gbmap
        * @return
        */
	   public List<GroupBoardVO> getGroupBoardList(Map<String, Object> gbmap);
	   
	   	/**
	   	 * 그룹게시판 글 개수 세기
	   	 * @param object
	   	 * @return
	   	 */
	   public int totalContent(Object object);
	   
	   	/**
	   	 * 그룹게시판 조회수 업데이트
	   	 * @param gbmap
	   	 */
	   public void updateCount(Map<String, Object> gbmap);
	   
	   	/**
	   	 * 그룹게시판 상세보기
	   	 * @param gbmap
	   	 * @return
	   	 */
	   public GroupBoardVO showContent(Map<String, Object> gbmap);
	   
	   	/**
	   	 * 답글 게시글에 원글이 없다고 표시 
	   	 * @param gbmap
	   	 */
	   public void updateChildBeforeDelete(Map<String, Object> gbmap);
	   
	   	/**
	   	 * 그룹게시판 게시글 삭제
	   	 * @param gbmap
	   	 */
	   public void deleteBoard(Map<String, Object> gbmap);
	   
	   	/**
	   	 * 그룹게시판 게시글 수정
	   	 * @param gbmap
	   	 */
	   public void updateBoard(Map<String, Object> gbmap);
	   
	   	/**
	   	 * 그룹게시판 게시글 조회수 수정
	   	 * @param gbmap
	   	 */
	   public void updateRestep(Map<String, Object> gbmap);
	   
	   	/**
	   	 * 혹시 모르니 남겨둠 안씀														<<<<<<<<<<<<<<<<<<<<<<<
	   	 * @param gbmap
	   	 */
	   public void insertRefContent(Map<String, Object> gbmap);
	   
	   	/**
	   	 * ????????????????????????????????????????????????
	   	 * @param gbmap
	   	 * @return
	   	 */
	   public String getCategory(Map<String, Object> gbmap);
	   
	   	/**
	   	 * 그룹게시판 최신글 불러오기
	   	 * @param gLeaderId
	   	 * @return
	   	 */
	   public List<GroupBoardVO> getGroupBoardTest(String gLeaderId);
	   
	   /**
	    * 그룹게시판 글쓰기(업로드)
	    * @param gbmap
	    * @return
	    */
	   public int writeUpload(Map<String, Object> gbmap);
	   
	   
	   	/**
	   	 * 그룹게시판 생성 매서드
	   	 * @param id
	   	 */
       public void createGroupBoard(String id); 
       
       /**
        * 그룹게시판 시퀀스 생성 메서드
        * @param id
        */
       public void createSequence(String id); 
       
       
       /**
        * 그룹게시판 시퀀스 드롭 메서드
        * @param id
        */
       public void dropGroupBoardSequence(String id);  
       
       /**
        * 그룹게시판 드롭 메서드
        * @param id
        */
       public void dropGroupBoard(String id);  
       
       /**
        * 게시판 검색
        * @param gbmap
        * @return
        */
       public List<GroupBoardVO> findboardListTitleAndContent(Map<String, Object> gbmap);
       
		/**
		 * 게시판 카테고리별로
		 * @param gbmap
		 * @return
		 */
       public List<GroupBoardVO> findBoardListByCategory(Map<String, Object> gbmap);
       
       /**
        * 게시판 카테고리별로 키워드검색
        * @param gbmap
        * @return
        */
       public List<GroupBoardVO> findCategorizedList(Map<String, Object> gbmap);
       
}     






