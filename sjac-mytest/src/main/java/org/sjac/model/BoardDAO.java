package org.sjac.model;

import java.util.HashMap;

public interface BoardDAO {
   /**
    * 자유게시판 새로운 글 저장한다.
    * @param bvo
    * @return
    */
   public  int write(BoardVO bvo);   
   /**
    * 자유게시판에서 pageNo에 해당되는 글 목록 반환한다.
    * @param pageNo
    * @return
    */
   public  HashMap getBoardList(String pageNo);
   /**
    * 자유게시판의 no 를 갖고있는 글 상세 내용 보여준다.
    * @param no
    * @return
    */
   public  BoardVO showContent(int no);
   /**
    * 해당 게시글의 조회수(hit)를 올려준다.
    * @param no
    */
   public  void updateCount(int no);
   /**
    * 해당 게시글을 삭제한다.
    * @param no
    */
   public  void deleteBoard(String no);
   /**
    * 해당 게시글의 수정내용을 저장한다.
    * @param bvo
    */
   public  void updateBoard(BoardVO bvo);
   /**
    * 자유게시판 글 개수를 반환한다.
    * @return
    */
   public  int totalContent();
   /**
    * 원글들의 답변글의 순서를 보기좋게 정해준다.
    * @param ref
    * @param restep
    */
   public void updateRestep(int ref, int restep);
   /**
    * 답글을 저장한다. 
    * @param bvo
    */
   public void insertRefContent(BoardVO bvo);
   /**
    * 원글의 category를 받아온다.
    * @param bvo
    */
   public void getCategory(BoardVO bvo);
   /**
    * 원글 삭제시 해당 답글의 원글이 삭제되어 존재하지 않는다는 것을 표시한다.
    * @param no
    */
   public void updateChildBeforeDelete(String no);
   /**
    * 자유게시판에서 제목과 내용에 해당 keyText가 있는 게시글을 반환한다.
    * @param pageNo
    * @param keyText
    * @return
    */
   public HashMap findBoardListByTitleAndContent(String pageNo, String keyText);

}