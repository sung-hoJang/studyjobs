package org.sjac.model;

import java.util.List;

public class GListVO {
   private List<GroupBoardVO> glist;
   private PagingBean paging;
 
   public GListVO() {
      super();
   }
   
   public GListVO(List<GroupBoardVO> glist, PagingBean paging) {
      super();
      this.glist = glist;
      this.paging = paging;
   }
   
   public List<GroupBoardVO> getGlist() {
      return glist;
   }
   
   public void setGlist(List<GroupBoardVO> glist) {
      this.glist = glist;
   }
   
   public PagingBean getPaging() {
      return paging;
   }
   
   public void setPaging(PagingBean paging) {
      this.paging = paging;
   }
   
   @Override
   public String toString() {
      return "GListVO [glist=" + glist + ", paging=" + paging + "]";
   }
   
}