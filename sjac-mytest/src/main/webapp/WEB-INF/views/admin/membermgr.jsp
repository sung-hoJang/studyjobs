<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
     <script type="text/javascript">
$(document).ready(function(){
   
   // 삭제버튼 누를시 회원 삭제
     $("#findMemberResult").on("click","#UserProfileForm :input[name=deleteMember]",function(){
       $(location).attr('href', "auth_admin_deleteMemberById.do?id="+$("#UserProfileForm :input[name=id]").val());
   });
   //리스트에서 클릭으로 상세정보 보기
        $("#idList").on("click","tr",function(){
        var idInfo=$(this).find("td:first").text();
        $.ajax({
                type:"GET",
                url:"auth_admin_getMemberInfo.do",            
                data:"id="+idInfo,
                dataType:"json",   
                success:function(result){
                      var listComp="";
                           listComp +="<h3>검색 결과</h3>"; 
                           listComp +="<br>";
                           listComp +="<div class='panel panel-default'><div class='panel-heading'><h4 class='panel-title'> <a href=''#collapseB1' data-toggle='collapse'> Member Profile </a> </h4></div>";
                           listComp +="<form id='UserProfileForm' class='form-horizontal'><div class='panel-body'><div class='form-group'><label class='col-sm-3 control-label'>아이디</label>";
                           listComp +="<div class='col-sm-9'><input type='text' name='id'  value='"+result.id+"'  class='form-control' readonly ></div></div>";
                           listComp +="<div class='form-group'><label class='col-sm-3 control-label'>이름</label><div class='col-sm-9'>";
                           listComp +="<input type='text' name='name'   value='"+result.name+"' class='form-control'  readonly></div></div>";
                           listComp +="<div class='form-group'><label class='col-sm-3 control-label'>지역</label><div class='col-sm-9'>";
                           listComp +="<input type='text' name='location'   value='"+result.location+"' class='form-control'  readonly></div></div>";
                           listComp +="<div class='form-group'><label class='col-sm-3 control-label'>전화번호</label><div class='col-sm-9'>";
                           listComp +="<input type='tel' name='tel' value='"+result.tel+"' maxlength='100' class='form-control'  readonly></div></div>";
                           listComp +="<div class='form-group'><label class='col-sm-3 control-label'>성별</label><div class='col-sm-9'>";
                           listComp +="<input type='text' name='gender' value='"+result.gender+"' class='form-control'  readonly></div></div>";
                           listComp +="<div class='form-group'><label  class='col-sm-3 control-label'>생년월일</label><div class='col-sm-9'>";
                           listComp +="<input type='text' name='birthdate' class='form-control'  value='"+result.birthdate+"'  readonly><span class='help-block'></span></div></div>";
                           listComp +="<div class='form-group'><div class='col-sm-offset-3 col-sm-9'> </div></div></div><div class='panel-footer'><div class='row'><div class='col-sm-offset-3 col-sm-9'>";
                           listComp +="<input type='button' name='deleteMember' class='btn btn-custom' value='회원 삭제'>  &nbsp;</div></div></div></form> </div>";
                      
                           $("#findMemberResult").html(listComp);
                  }// success
               });//ajax    
        });
   
   //키워드 입력으로 검색(회원아이디) 시작!!!!!!!!!!!
   $("#keywordSelect").submit(function(event){
      var keyText=$("input:text[name=keywordBlank]").val();
       $.ajax({
             type:"GET",
             url:"auth_admin_getMemberInfo.do",            
             data:"id="+keyText,
             dataType:"json",   
             success:function(result){
                if(result.flag=="false"){
                     $("#findMemberResult").html("");
                     $("#findMemberResult").html("<div class='col-sm-12'>"+keyText+"와 일치하는 정보가 없습니다."+"</div>");
                     }else{
                   var listComp="";
                   listComp +="<h3>검색 결과</h3>"; 
                        listComp +="<div class='panel panel-default'><div class='panel-heading'><h4 class='panel-title'> <a href=''#collapseB1' data-toggle='collapse'> Member Profile </a> </h4></div>";
                        listComp +="<form id='UserProfileForm' class='form-horizontal'><div class='panel-body'><div class='form-group'><label class='col-sm-3 control-label'>아이디</label>";
                        listComp +="<div class='col-sm-9'><input type='text' name='id'  value='"+result.id+"'  class='form-control' readonly ></div></div>";
                        listComp +="<div class='form-group'><label class='col-sm-3 control-label'>이름</label><div class='col-sm-9'>";
                        listComp +="<input type='text' name='name'   value='"+result.name+"' class='form-control'  readonly></div></div>";
                        listComp +="<div class='form-group'><label class='col-sm-3 control-label'>지역</label><div class='col-sm-9'>";
                        listComp +="<input type='text' name='location'   value='"+result.location+"' class='form-control'  readonly></div></div>";
                        listComp +="<div class='form-group'><label class='col-sm-3 control-label'>전화번호</label><div class='col-sm-9'>";
                        listComp +="<input type='tel' name='tel' value='"+result.tel+"' maxlength='100' class='form-control'  readonly></div></div>";
                        listComp +="<div class='form-group'><label class='col-sm-3 control-label'>성별</label><div class='col-sm-9'>";
                        listComp +="<input type='text' name='gender' value='"+result.gender+"' class='form-control'  readonly></div></div>";
                        listComp +="<div class='form-group'><label  class='col-sm-3 control-label'>생년월일</label><div class='col-sm-9'>";
                        listComp +="<input type='text' name='birthdate' class='form-control'  value='"+result.birthdate+"'  readonly><span class='help-block'></span></div></div>";
                        listComp +="<div class='form-group'><div class='col-sm-offset-3 col-sm-9'> </div></div></div><div class='panel-footer'><div class='row'><div class='col-sm-offset-3 col-sm-9'>";
                        listComp +="<input type='button' name='deleteMember' class='btn btn-custom' value='회원 삭제'>  &nbsp;</div></div></div></form> </div>";
                 
                        $("#findMemberResult").html(listComp);
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
             회원아이디:
             <input type="text" name="keywordBlank">
             <input type="submit" value="검색">
         </td>
         </tr>
         </form>
         </table>
      </div>
      <hr>
 <!-- 검색 키워드 입력 끝  --> 
 
<div id="findMemberResult">
  </div>            
                            
<h3 id="tableTitle">회원 리스트</h3>
<br>
      <div id="memberList" >
         <table class="table table-striped table-bordered table-hover" border="1" cellpadding="10" id="selectKeywordTable">
         <thead>
                   <tr align="center"  bgcolor="#E3C4FF"><td><b>아이디</b></td><td><b>이름</b></td><td><b>지역</b></td><td><b>전화번호</b></td><td><b>성별</b></td><td><b>생년월일</b></td></tr>
         </thead>
         <tbody id="idList">
         <c:forEach var="mvo" items="${requestScope.list}">   
                   <tr align="center"><td>${mvo.id}</td>         <td>${mvo.name}</td>      <td>${mvo.location}</td>      <td>${mvo.tel}</td>      <td>${mvo.gender}</td>      <td>${mvo.birthdate}</td></tr>
        </c:forEach>
         </tbody>
         
         </table>
      </div>