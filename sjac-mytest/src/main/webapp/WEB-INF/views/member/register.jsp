<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/sunny/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<style>
.rainbow {
   background-image: -webkit-gradient(linear, left top, right top, color-stop(0, #f22),
      color-stop(0.15, #f2f), color-stop(0.3, #22f), color-stop(0.45, #2ff),
      color-stop(0.6, #2f2), color-stop(0.75, #2f2), color-stop(0.9, #ff2),
      color-stop(1, #f22));
   background-image: gradient(linear, left top, right top, color-stop(0, #f22),
      color-stop(0.15, #f2f), color-stop(0.3, #22f), color-stop(0.45, #2ff),
      color-stop(0.6, #2f2), color-stop(0.75, #2f2), color-stop(0.9, #ff2),
      color-stop(1, #f22));
   color: transparent;
   -webkit-background-clip: text;
   background-clip: text;
}
</style>
<script type="text/javascript">


   var tel;
   $(document).ready(function() {
	      $("#registerForm").submit(function(event){
	          var password = $("#password").val();
	          var password2 = $("#password2").val();
	       if(password != password2){
	          alert("비밀번호가 일치하지 않습니다");
	          event.preventDefault();
	       }  
	      });
	      $(function(){
	    	    $('#idComp').keydown(function() {
	    	     $('#idComp').val($('#idComp').val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ));
	    	    });
	    	   });

	      
	      $("#tel").keydown(function(){
	          $(this).val (
	              $(this).val().replace(/[^0-9]/g,"")
	             ); 
	      });
      tel ="";
      $("#selLocation").change(function(){
         $("#location").val($(this).val());
       });
      
      $("#selGender").change(function(){
         $("#gender").val($(this).val());
      });
      
      $("#idComp").keyup(function(){
    	  var id = $("#idComp").val();
    	  if(id==""){
    		  $("#idcheck").text("");
    		  return false;
    	  }
          if (id.length < 2 || id.length > 10) {
               $("#idcheck").text(" 2자이상 10자이하의 영문/숫지만 가능합니다.");
               return false;
            } else {
               $.ajax({
                  type : "post",
                  url : "idcheck.do",
                  data : $("#registerForm").serialize(),
                  success : function(data) {
                     if (data == "ok") {
                        $("#idcheck").text("사용가능한 아이디입니다람쥐다람쥐~");
                     } else if (data == "fail") {
                        $("#idcheck").text("사용 불가능한 아이디입니다");
                     }
                  }
               }) //ajax 시작
            } //첫번째 else
      });
        
      $("#password,#password2").keyup(function() {
          var password = $("#password").val();
          var password2 = $("#password2").val();
         if (password == ""|| password2 == "") {
              $("#passwordcheck").text("");
               return false; 
           } if (password == password2) {
              $("#passwordcheck").text("비밀번호가 일치합니다.");
           } if  (password != password2) {
              $("#passwordcheck").text("비밀번호가 일치하지 않습니다.");
           }
         
      }); //keyup form
      
     
   }); //ready bracelet
   
</script>

<div class="row">
   <div class="col-sm-5 login-form">
      <div class="panel panel-default">
         <div class="panel-intro text-center">
             <img src="${initParam.root}assets/img/background/apple1.jpg">
            <h1 class="logo">
            StudyJobs 
            </h1>
         </div>
         <div class="panel-body">
            <form action="register.do" method="post" id="registerForm">
               <div id="idcheck" class="rainbow"></div>
               <div class="form-group">
                  <input type="text" placeholder="아이디" class="form-control input-lg" name="id" id="idComp" maxlength="10" required="required">
               </div>
               <hr>
               <div class="form-group">
                  <input type="password" placeholder="비밀번호" class="form-control input-lg" name="password" id="password" required="required">
               </div>
               <div id="passwordcheck" class="rainbow"></div>
               <div class="form-group">
                  <input type="password" placeholder="비밀번호확인"
                     class="form-control input-lg" name="password2" id="password2" required="required">
               </div>
               <hr>
               <div class="form-group">
                  <input type="text" placeholder="이름" class="form-control input-lg"
                     name="name" required="required">
               </div>
               <hr>
               <div class="form-group">
                   <select id="selLocation" class="item-meta">
                   		<option value="-">-</option>
                         <c:forEach items="${requestScope.gvo }" var="locaList">
                               <option value="${locaList.gLocation }">${locaList.gLocation }</option>
                         </c:forEach>
                   </select>

                  <input type="text" placeholder="지역을 선택해주세요" class="form-control input-lg" id="location"  name="location" readonly required="required"> 
               </div>
               
               <hr>
               <div class="form-group">
               <input type="tel" placeholder="전화번호" class="form-control input-lg" name="tel" id="tel" maxlength="11" required="required">
               </div>
               
               <hr>
               <div class="form-group">
                  <select id="selGender"  class="item-meta">
                     <option value ="" >성별을 입력하세요</option>   
                     <option value ="남">남</option>
                     <option value ="여">여</option>
                  </select>
                  <input type="text" placeholder="성별" class="form-control input-lg"
                     name="gender" id ="gender" readonly required="required">
               </div>
               <hr>
               <div class="form-group">
                     
                     <input type="date" placeholder="생년월일" class="form-control input-lg" name="birthdate" id="datepicker" required="required">
               </div>
               
               <div class="form-group">
                  <button class="btn btn-block btn-custom"  type="submit" >회원가입</button>
               </div>
            </form>
         </div>
         <div class="panel-footer">
            <p class="text-center pull-right">
               <a href="member_login.do"> 아이디가 있습니까? </a>
            </p>
            <div style="clear: both"></div>
         </div>
      </div>
   </div>
</div>