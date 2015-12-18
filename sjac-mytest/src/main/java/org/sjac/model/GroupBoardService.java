package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface GroupBoardService {

   public int write(Map<String, Object> gbmap);

   public GListVO getBoardList(Map<String, Object> gbmap);

   public GroupBoardVO showContent(Map<String, Object> gbmap);

   public GroupBoardVO showContentNoHit(Map<String, Object> gbmap);

   public void deleteBoard(Map<String, Object> gbmap);

   public void updateBoard(Map<String, Object> gbmap);

   public void reply(Map<String, Object> gbmap);

   public List<GroupBoardVO> getGroupBoardTest(String gLeaderId);

   //게시판 검색 
   public GListVO findboardListTitleAndContent(Map<String, Object> gbmap);
   
   // 게시판 카테고리별로
   public GListVO findBoardListByCategory(Map<String, Object> gbmap);
   
   // 게시판 카테고리별 키워드 검색
   public GListVO findCategorizedList(Map<String, Object> gbmap);
}