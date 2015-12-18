<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
     <script type="text/javascript">
$(document).ready(function(){
   // 삭제버튼 누를시 그룹 삭제
     $("#findGroupResult").on("click","#UserProfileForm :input[name=deleteGroup]",function(){
        $(location).attr('href', "auth_admin_deleteGroupById.do?id="+$("#UserProfileForm :input[name=id]").val());
        
   });
   
   // 리스트 클릭시 상세정보 보여주기
     $("#idList").on("click","tr",function(){
        var idInfo=$(this).find("td:first").text();
        
        $.ajax({
                type:"GET",
                url:"auth_admin_getGroupInfo.do",            
                data:"id="+idInfo,
                dataType:"json",   
                success:function(result){
                      var listComp="";
                      listComp +="<h3>검색 결과</h3>"; 
                      listComp +="<br>";
                      listComp +="<div class='panel panel-default'><div class='panel-heading'><h4 class='panel-title'> <a href=''#collapseB1' data-toggle='collapse'> Group Infomation </a> </h4></div>";
                      listComp +="<form id='UserProfileForm' class='form-horizontal'><div class='panel-body'><div class='form-group'><label class='col-sm-3 control-label'>그룹장아이디</label>";
                      listComp +="<div class='col-sm-9'><input type='text' name='id'  value='"+result.memberVO.id+"'  class='form-control' readonly ></div></div>";
                      listComp +="<div class='form-group'><label class='col-sm-3 control-label'>그룹명</label><div class='col-sm-9'>";
                      listComp +="<input type='text' name='GroupName'   value='"+result.gName+"' class='form-control'  readonly></div></div>";                      
                      listComp +="<div class='form-group'><label class='col-sm-3 control-label'>그룹정보</label><div class='col-sm-9'>";
                      listComp +="<input type='text' name='GroupInfo'   value='"+result.gInfo+"' class='form-control'  readonly></div></div>";
                      listComp +="<div class='form-group'><label class='col-sm-3 control-label'>참여가능 인원수</label><div class='col-sm-9'>";
                      listComp +="<input type='text' name='AvailableCount' value='"+result.gCount+"' maxlength='100' class='form-control'  readonly></div></div>";
                      listComp +="<div class='form-group'><label class='col-sm-3 control-label'>과목</label><div class='col-sm-9'>";
                      listComp +="<input type='text' name='subject' value='"+result.subjectVO.subject+"' class='form-control'  readonly></div></div>";
                      listComp +="<div class='form-group'><label  class='col-sm-3 control-label'>지역</label><div class='col-sm-9'>";
                      listComp +="<input type='text' name='location' class='form-control'  value='"+result.gLocation+"'  readonly><span class='help-block'></span></div></div>";
                      listComp +="<div class='form-group'><div class='col-sm-offset-3 col-sm-9'> </div></div></div><div class='panel-footer'><div class='row'><div  class='col-sm-offset-3 col-sm-9'>";
                      listComp +="<input type='button' class='btn btn-custom' name='deleteGroup' value='그룹 삭제'>  &nbsp;</div></div></div></form> </div>";
                     
                      $("#findGroupResult").html(listComp);
                }// success
             });//ajax    
    
     });
   
   //키워드 입력으로 검색(그룹명, 그룹장아이디)
   $("#keywordSelect").submit(function(event){
      var keyText=$("input:text[name=keywordBlank]").val();
       $.ajax({
             type:"GET",
             url:"auth_admin_getGroupInfo.do",            
             data:"id="+keyText,
             dataType:"json",   
             success:function(result){
                if(result.flag=="false"){
                     $("#findGroupResult").html("");
                     $("#findGroupResult").html("<div class='col-sm-12'>"+keyText+"와 일치하는 정보가 없습니다."+"</div>");
                     }else{
                   var listComp="";
                     listComp +="<h3>검색 결과</h3>"; 
                     listComp +="<br>";
                     listComp +="<div class='panel panel-default'><div class='panel-heading'><h4 class='panel-title'> <a href=''#collapseB1' data-toggle='collapse'> Member Profile </a> </h4></div>";
                     listComp +="<form id='UserProfileForm' class='form-horizontal'><div class='panel-body'><div class='form-group'><label class='col-sm-3 control-label'>그룹장아이디</label>";
                     listComp +="<div class='col-sm-9'><input type='text' name='id'  value='"+result.memberVO.id+"'  class='form-control' readonly ></div></div>";
                     listComp +="<div class='form-group'><label class='col-sm-3 control-label'>그룹명</label><div class='col-sm-9'>";
                     listComp +="<input type='text' name='GroupName'   value='"+result.gName+"' class='form-control'  readonly></div></div>";
                     listComp +="<div class='form-group'><label class='col-sm-3 control-label'>그룹정보</label><div class='col-sm-9'>";
                     listComp +="<input type='text' name='GroupInfo'   value='"+result.gInfo+"' class='form-control'  readonly></div></div>";
                     listComp +="<div class='form-group'><label class='col-sm-3 control-label'>참여가능 인원수</label><div class='col-sm-9'>";
                     listComp +="<input type='text' name='AvailableCount' value='"+result.gCount+"' maxlength='100' class='form-control'  readonly></div></div>";
                     listComp +="<div class='form-group'><label class='col-sm-3 control-label'>과목</label><div class='col-sm-9'>";
                     listComp +="<input type='text' name='subject' value='"+result.subjectVO.subject+"' class='form-control'  readonly></div></div>";
                     listComp +="<div class='form-group'><label  class='col-sm-3 control-label'>지역</label><div class='col-sm-9'>";
                     listComp +="<input type='text' name='location' class='form-control'  value='"+result.gLocation+"'  readonly><span class='help-block'></span></div></div>";
                     listComp +="<div class='form-group'><div class='col-sm-offset-3 col-sm-9'> </div></div></div><div class='panel-footer'><div class='row'><div  class='col-sm-offset-3 col-sm-9'>";
                     listComp +="<input type='button' class='btn btn-custom' name='deleteGroup' value='그룹 삭제'>  &nbsp;</div></div></div></form> </div>";
                 
                     $("#findGroupResult").html(listComp);
                  }
               }// success
            });//ajax    
            event.preventDefault();//페이지 초기화 방지
   });//submit
});//ready
</script>

 




 <!-- 검색 키워드 입력 -->
      <h3>키워드 검색</h3>
      <br>
      <div id="keyword" >
         <table class="table table-striped table-bordered table-hover" border="1" cellpadding="10" id="selectKeywordTable">
         <form id="keywordSelect">
         <tr>
         <td>
             그룹장아이디:
             <input type="text" name="keywordBlank">
             <input type="submit" value="검색">
         </td>
         </tr>
         </form>
         </table>
      </div>
      <hr>

 
<div id="findGroupResult">
  </div>            
                            
<h3 id="tableTitle">그룹 리스트</h3>
<br>
      <div id="groupList" >
         <table class="table table-striped table-bordered table-hover" border="1" cellpadding="10" id="selectKeywordTable">
         <thead>
                   <tr align="center"  bgcolor="#E3C4FF"> <td style="width: 10%"><b>ID</b></td><td  style="width: 15%"><b>그룹 이름</b></td><td  style="width: 40%"><b>그룹 정보</b></td><td  style="width: 15%"><b>참여가능 인원 수</b></td><td><b>과목</b></td><td><b>지역</b></td>
         </thead>
         <tbody id="idList">
         <c:forEach var="gvo" items="${requestScope.list}">   
                   <tr><td><center>${gvo.memberVO.id}</center></td>         <td><center>${gvo.gName}</center></td>      <td>${gvo.gInfo }</td>      <td><center>${gvo.gCount }</center></td>      <td><center>${gvo.subjectVO.subject}</center></td>      <td><center>${gvo.gLocation}</center></td></tr>
        </c:forEach>
         </tbody>
         </table>
         
      </div>