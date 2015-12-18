<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<style>
select{
   height: 34px;
   padding-top: 5px;
   padding-bottom: 5px;
}
</style>

<script type="text/javascript">
$(document).ready(function(){
   $("#cancelBtn").click(function(){
      location.href="home.do";
   });
   
   $("#maxMember").keyup(function(){
         if($(this).val() > 8 || $(this).val() == 0 ){
            $(this).val("");
         }
         
         $(this).val (
               // 숫자가 아닌 값들을 공백으로 .replace() 메서드 사용
                  $(this).val().replace(/[^0-9]/g,"")
                 );
      });
      
      
      $("#subjectCategoty").change(function(){
           $.ajax({
                type:"get",
                url:"auth_mypage_subject_category.do",            
                data:"category="+$(this).val(),
                success:function(result){
               var newInfo="";
               $("#subjectminorSelect").empty();
               newInfo+="<option value=''>과목을 선택하세요</option>";
                       
               $.each(result,function(index,sh){
                  newInfo+="<option value='"+sh.subject+"'>"+sh.subject+"</option>"
               });
               
               $("#subjectminorSelect").html(newInfo);
                }// success
               });//ajax    
       });
 });
 


</script>

                            <div class="panel panel-default">
                               <div class="panel-heading">
                                </div> 

                               <form action="auth_createNewGroup.do" accept-charset="utf-8" method="post"  id="UserProfileForm" class="form-horizontal">
                                    <div class="panel-body">             
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">ID</label>
                                            <div class="col-sm-9">
                                                <input type="text" required="required" value="${sessionScope.mvo.id}" class="form-control" name="memberVO.id" readonly>                                   
                                 </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">그룹 이름</label>
                                            <div class="col-sm-9">
                                                <input type="text"  required="required"  maxlength="10" class="form-control" name="gName">                                
                                            </div>
                                        </div>
                                        
                                         <div class="form-group">
                                            <label class="col-sm-3 control-label">최대인원</label>
                                            <div class="col-sm-9">
                                                <input type="text" id="maxMember" min="1" max="8" required="required" class="form-control" name="gCount"  placeholder="그룹원은 최대 8명까지 가능합니다.">                                
                                            </div>
                                        </div>
                                        
                                         <div class="form-group">
                                            <label class="col-sm-3 control-label">카테고리</label>
                                            <div class="col-sm-9">
                                    <select id="subjectCategoty" name="subjectVO.subjectCategory">
                              <option value="">카테고리를 선택하세요</option>
                                       <c:forEach items="${requestScope.map['categoryList']}" var="categoryVO">
                                 <option value="${categoryVO.subjectCategory}">${categoryVO.subjectCategory}</option>
                                       </c:forEach>

                                    </select>  
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">과목</label>
                                            <div class="col-sm-9">
                                            <div>
                                               <select id="subjectminorSelect" name="subjectVO.subject">
                                                  <option value="">과목을 선택하세요</option>
                                                  
                                               </select>
                                            </div>
                                            </div>
                                        </div>
                                        
                                         <div class="form-group" >
                                            <label class="col-sm-3 control-label">지역</label>
                                            <div class="col-sm-9" style="vertical-align: bottom; ">
                                             <select id="subjectCategoty" name="gLocation" > 
                                                <option value="">지역을 선택하세요</option>
                                           <c:forEach items="${requestScope.map['locationList']}" var="lvolist">
                                                    <option value="${lvolist.gLocation}">${lvolist.gLocation}</option>
                                              </c:forEach>
                                           </select>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">그룹 정보</label>
                                            <div class="col-sm-9">
                                                <textarea style="height: 200px; width: 100%" class="form-control" name="gInfo"></textarea>                                
                                            </div>
                                        </div>
                                     
                                    <div class="panel-footer">
                                        <div class="row">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <button type="submit" id="updateGroup" class="btn btn-custom" ><i class="fa fa-save"></i> 만들기</button>
                                                <button type="button" class="btn btn-default" id="cancelBtn"><i class="fa fa-close"></i> 취소</button>
                                            </div>
                                        </div>
                                    </div>
                                    </div>
                                </form>
                            </div>