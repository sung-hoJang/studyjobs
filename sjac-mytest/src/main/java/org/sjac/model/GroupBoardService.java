package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface GroupBoardService {
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
   public GListVO getBoardList(Map<String, Object> gbmap);
   	
   	/**
   	 * 그룹게시판 상세보기
   	 * @param gbmap
   	 * @return
   	 */
   public GroupBoardVO showContent(Map<String, Object> gbmap);
   	
   	/**
   	 * 상세보기시 조회수 올라가지 않음
   	 * @param gbmap
   	 * @return
   	 */
   public GroupBoardVO showContentNoHit(Map<String, Object> gbmap);

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
   	 * 그룹게시판 답글
   	 * @param gbmap
   	 */
   public void reply(Map<String, Object> gbmap);
   	
   /**
   	 * 그룹게시판 최신글 불러오기
   	 * @param gLeaderId
   	 * @return
   	 */
   public List<GroupBoardVO> getGroupBoardTest(String gLeaderId);

   	/**
   	 * 게시판 검색 
   	 * @param gbmap
   	 * @return
   	 */
   public GListVO findboardListTitleAndContent(Map<String, Object> gbmap);
   
   	/**
   	 * 게시판 카테고리별로
   	 * @param gbmap
   	 * @return
   	 */
   public GListVO findBoardListByCategory(Map<String, Object> gbmap);
   
   	/**
   	 * 게시판 카테고리별 키워드 검색
   	 * @param gbmap
   	 * @return
   	 */
   public GListVO findCategorizedList(Map<String, Object> gbmap);
}











