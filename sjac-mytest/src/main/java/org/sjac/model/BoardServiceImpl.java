package org.sjac.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
   @Resource(name = "boardDAOImpl")
   private BoardDAO boardDAO;

   @Override
   public void write(BoardVO bvo) {
      boardDAO.write(bvo);
   }

   @Override
   public HashMap<String, Object> getBoardList(String pageNo) {
      if (pageNo == null || pageNo == "")
         pageNo = "1";
      HashMap<String, List<BoardVO>> oldMap = boardDAO.getBoardList(pageNo);
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("announcementList", oldMap.get("announcementList"));
      List<BoardVO> list = oldMap.get("generalList");
      int total = boardDAO.totalContent();
      PagingBean paging = new PagingBean(total, Integer.parseInt(pageNo));
      ListVO lvo = new ListVO(list, paging);
      map.put("hidden", "default");
      map.put("lvo", lvo);
      return map;
   }
   
   @Override
   public HashMap<String, Object> findBoardListByTitleAndContent(String pageNo, String keyText) {
      if (pageNo == null || pageNo == "")
         pageNo = "1";
      HashMap<String, List<BoardVO>> oldMap = boardDAO.findBoardListByTitleAndContent(pageNo, keyText);
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("announcementList", oldMap.get("announcementList"));
      List<BoardVO> list = oldMap.get("generalList");
      int total = boardDAO.totalContent();
      PagingBean paging = new PagingBean(total, Integer.parseInt(pageNo));
      ListVO lvo = new ListVO(list, paging);
      map.put("hidden", "find");
      map.put("keyText", keyText);
      map.put("lvo", lvo);
      return map;
   }
   

   @Override
   public BoardVO showContent(int no) {
      boardDAO.updateCount(no);
      return boardDAO.showContent(no);
   }

   @Override
   public BoardVO showContentNoHit(int no) {
      return boardDAO.showContent(no);
   }

   @Override
   public void deleteBoard(String no) {
      boardDAO.updateChildBeforeDelete(no);
      boardDAO.deleteBoard(no);
   }

   @Override
   public void updateBoard(BoardVO bvo) {
      boardDAO.updateBoard(bvo);
   }

   @Override
   public void reply(BoardVO bvo) {
      int ref = bvo.getRef();
      int restep = bvo.getRestep();
      int relevel = bvo.getRelevel();
      boardDAO.updateRestep(ref, restep);
      bvo.setRestep(restep + 1);
      bvo.setRelevel(relevel + 1);
      boardDAO.getCategory(bvo);
      boardDAO.insertRefContent(bvo);// 답변 글 입력
   }

   

}