package org.sjac.model;

public class SubjectVO {
   private String subject;
   private String subjectCategory;
   private String categoryImg;  
   
   public SubjectVO() {
      super();
   }   
   public SubjectVO(String subject, String subjectCategory, String categoryImg) {
      super();
      this.subject = subject;
      this.subjectCategory = subjectCategory;
      this.categoryImg = categoryImg;
   }
   public String getSubject() {
      return subject;
   }
   public void setSubject(String subject) {
      this.subject = subject;
   }
   public String getSubjectCategory() {
      return subjectCategory;
   }
   public void setSubjectCategory(String subjectCategory) {
      this.subjectCategory = subjectCategory;
   }
   public String getCategoryImg() {
      return categoryImg;
   }
   public void setCategoryImg(String categoryImg) {
      this.categoryImg = categoryImg;
   }
   @Override
   public String toString() {
      return "SubjectVO [subject=" + subject + ", subjectCategory="
            + subjectCategory + ", categoryImg=" + categoryImg + "]";
   }   
}