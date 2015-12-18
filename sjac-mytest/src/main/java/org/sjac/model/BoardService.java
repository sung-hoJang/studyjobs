package org.sjac.model;

import java.util.HashMap;

public interface BoardService {
	
   public  void write(BoardVO bvo);            
   
   public  HashMap<String, Object> getBoardList(String pageNo);
   
   public  BoardVO showContent(int no);   
   
   public BoardVO showContentNoHit(int no);
   
   public  void deleteBoard(String no);
   
   public  void updateBoard(BoardVO bvo);
   
   public void reply(BoardVO bvo);
   
   public HashMap<String, Object> findBoardListByTitleAndContent(String pageNo, String keyText);

}