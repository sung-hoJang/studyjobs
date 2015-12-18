<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<title>탈퇴 페이지</title>
<script type="text/javascript">
   $(document).ready(function(){ 
       $("#leaveMyself").click(function(){
             var password=$("#password").val();
                  $.ajax({
                     type : "post",
                     url : "passwordcheck.do",
                     data : "password="+password,
                     success : function(data) {
                        if (data == "ok") {
                           var url="auth_member_deleteMemberById.do?"+$("#leaveForm").serialize();
                           $(location).attr('href',url);
                        } else if (data == "fail") {
                           alert("비밀번호가 일치하지 않습니다.");
                           $("#password").val("");
                        }
                     }
                  }) //ajax 시작
              
         });
      
   });

</script>
</head>
<body>
<h4><b>회원 탈퇴</b></h4>
<hr>

<form id="leaveForm"> 
    <select required="required" name="reason" class="form-control" >
		<option value="">탈퇴사유를 선택해 주세요.</option>
		<option value="1.정보가 부족해서">1.정보가 부족해서</option>
		<option value="2.그룹생성이 하나만 가능해서">2.그룹생성이 하나만 가능해서</option>
		<option value="3.이용이 불편해서">3.이용이 불편해서</option>
		<option value="4.활동이 적어서">4.활동이 적어서</option>
		<option value="5.원하는 스터디 분야가 없어서">5.원하는 스터디 분야가 없어서</option>
		<option value="6.개인정보 삭제를 위해서">6.개인정보 삭제를 위해서</option>
		<option value="7.취업에 성공해서">7.취업에 성공해서</option>
		<option value="8.더 이상 스터디를 원하지 않아서">8.더 이상 스터디를 원하지 않아서</option>
		<option value="9.이유없음">9.이유없음</option>
		<option value="10.기타">10.기타</option>
   </select>
<br>
   <textarea name="detailreason" style="height: 200px; width: 100%" class="form-control" name="gInfo" required="required" placeholder="기타 개선사항 이나 추가사항이 있으면 적어주세요."></textarea>   
 	<br>
 	<b>PASSWORD</b> 
     <input type="password" placeholder="비밀번호를 입력해주세요" class="form-control" name="password" id="password" required="required" style="width: 200px;">
   <br>
     <button type="button" id="leaveMyself" class="btn btn-danger" >탈퇴하기 <i class="material-icons">directions_run</i></button>
   <br>
     <div id="passwordcheck"></div>
</form>

</body>
</html>