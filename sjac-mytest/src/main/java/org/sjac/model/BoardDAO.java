package org.sjac.model;

import java.util.HashMap;

public interface BoardDAO {

   public  int write(BoardVO bvo);   

   public  HashMap getBoardList(String pageNo);

   public  BoardVO showContent(int no);

   public  void updateCount(int no);

   public  void deleteBoard(String no);

   public  void updateBoard(BoardVO bvo);

   public  int totalContent();

   public void updateRestep(int ref, int restep);

   public void insertRefContent(BoardVO bvo);

   public void getCategory(BoardVO bvo);

   public void updateChildBeforeDelete(String no);
   
   public HashMap findBoardListByTitleAndContent(String pageNo, String keyText);

}