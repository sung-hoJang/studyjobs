package org.sjac.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class GroupBoardServiceImpl implements GroupBoardService{

   @Resource(name="groupBoardDAOImpl")
   private GroupBoardDAO groupBoardDAO;
   
   
   @Override
   public int write(Map<String, Object> gbmap) {
      return groupBoardDAO.write(gbmap);      
   }

   @Override
   public GListVO getBoardList(Map<String, Object> gbmap) {
      String pageNo = (String) gbmap.get("page");
      if(pageNo==null||pageNo=="") 
         pageNo="1";
      gbmap.put("page", pageNo);
      List<GroupBoardVO> glist = groupBoardDAO.getGroupBoardList(gbmap);
      int total=groupBoardDAO.totalContent(gbmap.get("gbtable"));
      PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
      GListVO glvo=new GListVO(glist,paging);
      return glvo;
   }

@Override
   public GroupBoardVO showContent(Map<String, Object> gbmap){
      groupBoardDAO.updateCount(gbmap);
      return groupBoardDAO.showContent(gbmap);
   }
   @Override
   public GroupBoardVO showContentNoHit(Map<String, Object> gbmap){      
      return groupBoardDAO.showContent(gbmap);
   }
      @Override
   public void deleteBoard(Map<String, Object> gbmap){
      groupBoardDAO.updateChildBeforeDelete(gbmap);
      groupBoardDAO.deleteBoard(gbmap);
   }
   @Override
   public void updateBoard(Map<String, Object> gbmap){
      groupBoardDAO.updateBoard(gbmap);
   }
   @Override
   public void reply(Map<String, Object> gbmap) {
      groupBoardDAO.updateRestep(gbmap);
      GroupBoardVO gbvo = (GroupBoardVO) gbmap.get("gbvo");
      gbvo.setRestep(gbvo.getRestep()+1);
      gbvo.setRelevel(gbvo.getRelevel()+1);
      gbmap.put("gbvo", gbvo);
      groupBoardDAO.insertRefContent(gbmap);
   }
      @Override
   public List<GroupBoardVO> getGroupBoardTest(String gLeaderId){
      return groupBoardDAO.getGroupBoardTest(gLeaderId);
   }   

      // 게시판 검색
      @Override
      public GListVO findboardListTitleAndContent(Map<String, Object> gbmap) {
         String pageNo = (String) gbmap.get("page");
            if(pageNo==null||pageNo=="") 
               pageNo="1";
            gbmap.put("page", pageNo);
            List<GroupBoardVO> glist = groupBoardDAO.findboardListTitleAndContent(gbmap);
            int total=groupBoardDAO.totalContent(gbmap.get("gbtable"));
            PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
            GListVO glvo=new GListVO(glist,paging);
            return glvo;
      }
      
     //게시판 카테고리별로
   @Override
   public GListVO findBoardListByCategory(Map<String, Object> gbmap) {
      String pageNo = (String) gbmap.get("page");
        if(pageNo==null||pageNo=="") 
           pageNo="1";
        gbmap.put("page", pageNo);
        List<GroupBoardVO> glist = groupBoardDAO.findBoardListByCategory(gbmap);
        int total=groupBoardDAO.totalContent(gbmap.get("gbtable"));
        PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
        GListVO glvo=new GListVO(glist,paging);
        return glvo;
   }
   
   //게시판 카테고리별로 키워드 검색
   @Override
   public GListVO findCategorizedList(Map<String, Object> gbmap) {
      String pageNo = (String) gbmap.get("page");
        if(pageNo==null||pageNo=="") 
           pageNo="1";
        gbmap.put("page", pageNo);
        List<GroupBoardVO> glist = groupBoardDAO.findCategorizedList(gbmap);
        int total=groupBoardDAO.totalContent(gbmap.get("gbtable"));
        PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
        GListVO glvo=new GListVO(glist,paging);
        return glvo;
   }
}