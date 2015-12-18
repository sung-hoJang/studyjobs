package org.sjac.model;

import java.util.HashMap;

public interface BoardService {
 /**
  * 자유게시판 새로운 글 저장한다.
  * @param bvo
  */
   public  void write(BoardVO bvo);            
   /**
    * 자유게시판에서 pageNo에 해당되는 글 목록 반환한다.
    * @param pageNo
    * @return
    */
   public  HashMap<String, Object> getBoardList(String pageNo);
   /**
    * 자유게시판의 no 를 갖고있는 글 상세 내용 보여준다.
    * @param no
    * @return
    */
   public  BoardVO showContent(int no);   
   /**
    *  자유게시판의 no를 갖고있는 글 상세를 조회수를 높이지 않고 보여준다.
    * @param no
    * @return
    */
   public BoardVO showContentNoHit(int no);
   /**
    * 해당 게시글을 삭제한다.
    * @param no
    */
   public  void deleteBoard(String no);
   /**
    * 해당 게시글의 수정한다.
    * @param bvo
    */
   public  void updateBoard(BoardVO bvo);
   /**
    * 답변글을 입력한다.
    * @param bvo
    */
   public void reply(BoardVO bvo);
   /**
    * 자유게시판에서 제목과 내용에 해당 keyText가 있는 게시글을 반환한다.
    * @param pageNo
    * @param keyText
    * @return
    */
   public HashMap<String, Object> findBoardListByTitleAndContent(String pageNo, String keyText);

}