package org.sjac.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class GroupBoardVO {
   private int gbNo;
   private String gbCategory;
   private String gbTitle;
   private String gbContent;
   private String gbDate;
   private int gbHits;
   private int ref; 
   private int restep;
   private int relevel;
   private int parent;
   private String fname;
   private List<MultipartFile> file;
   private MemberVO memberVO;
   private GroupVO groupVO;
  
   public GroupBoardVO() {
      super();
   }
   
   public GroupBoardVO(int gbNo, String gbCategory, String gbTitle,
         String gbContent, String gbDate, int gbHits, int ref, int restep,
         int relevel, int parent, String fname, List<MultipartFile> file,
         MemberVO memberVO, GroupVO groupVO) {
      super();
      this.gbNo = gbNo;
      this.gbCategory = gbCategory;
      this.gbTitle = gbTitle;
      this.gbContent = gbContent;
      this.gbDate = gbDate;
      this.gbHits = gbHits;
      this.ref = ref;
      this.restep = restep;
      this.relevel = relevel;
      this.parent = parent;
      this.fname = fname;
      this.file = file;
      this.memberVO = memberVO;
      this.groupVO = groupVO;
   }
   public GroupBoardVO(int gbNo, String gbCategory, String gbTitle,
         String gbContent, String gbDate, int gbHits, int ref, int restep,
         int relevel, int parent, MemberVO memberVO, GroupVO groupVO) {
      super();
      this.gbNo = gbNo;
      this.gbCategory = gbCategory;
      this.gbTitle = gbTitle;
      this.gbContent = gbContent;
      this.gbDate = gbDate;
      this.gbHits = gbHits;
      this.ref = ref;
      this.restep = restep;
      this.relevel = relevel;
      this.parent = parent;
      this.memberVO = memberVO;
      this.groupVO = groupVO;
   }
   public int getGbNo() {
      return gbNo;
   }
   public void setGbNo(int gbNo) {
      this.gbNo = gbNo;
   }
   public String getGbCategory() {
      return gbCategory;
   }
   public void setGbCategory(String gbCategory) {
      this.gbCategory = gbCategory;
   }
   public String getGbTitle() {
      return gbTitle;
   }
   public void setGbTitle(String gbTitle) {
      this.gbTitle = gbTitle;
   }
   public String getGbContent() {
      return gbContent;
   }
   public void setGbContent(String gbContent) {
      this.gbContent = gbContent;
   }
   public String getGbDate() {
      return gbDate;
   }
   public void setGbDate(String gbDate) {
      this.gbDate = gbDate;
   }
   public int getGbHits() {
      return gbHits;
   }
   public void setGbHits(int gbHits) {
      this.gbHits = gbHits;
   }
   public int getRef() {
      return ref;
   }
   public void setRef(int ref) {
      this.ref = ref;
   }
   public int getRestep() {
      return restep;
   }
   public void setRestep(int restep) {
      this.restep = restep;
   }
   public int getRelevel() {
      return relevel;
   }
   public void setRelevel(int relevel) {
      this.relevel = relevel;
   }
   public int getParent() {
      return parent;
   }
   public void setParent(int parent) {
      this.parent = parent;
   }
   public String getFname() {
      return fname;
   }
   public void setFname(String fname) {
      this.fname = fname;
   }
   public List<MultipartFile> getFile() {
      return file;
   }
   public void setFile(List<MultipartFile> file) {
      this.file = file;
   }
   public MemberVO getMemberVO() {
      return memberVO;
   }
   public void setMemberVO(MemberVO memberVO) {
      this.memberVO = memberVO;
   }
   public GroupVO getGroupVO() {
      return groupVO;
   }
   public void setGroupVO(GroupVO groupVO) {
      this.groupVO = groupVO;
   }
   @Override
   public String toString() {
      return "GroupBoardVO [gbNo=" + gbNo + ", gbCategory=" + gbCategory
            + ", gbTitle=" + gbTitle + ", gbContent=" + gbContent
            + ", gbDate=" + gbDate + ", gbHits=" + gbHits + ", ref=" + ref
            + ", restep=" + restep + ", relevel=" + relevel + ", parent="
            + parent + ", fname=" + fname + ", file=" + file
            + ", memberVO=" + memberVO + ", groupVO=" + groupVO + "]";
   }
}