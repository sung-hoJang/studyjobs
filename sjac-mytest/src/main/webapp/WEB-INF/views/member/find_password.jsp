<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">
function checkLogin(){
   var f=document.findPasswordForm;
   if(f.id.value==""){
      alert("아이디를 입력하세요");
      return false;
   }else if(f.tel.value==""){
      alert("전화번호를 입력하세요");
      return false;
   }
}
 $(document).ready(function(){
      $("#finder").click(function(){
          $.ajax({
                   type : "get",
                   url : "findPassword.do",
                   data : $("#f1").serialize(),
                   success : function(data) {
                      if (data.check == "ok") {
                         $("#resultView").text(data.mvo.password);
                      } else if (data.check == "fail") {
                         $("#resultView").text("입력정보가 정확하지 않습니다.").css("color","red");
                      }
                   }
                }) //ajax 시작
         });
      });
</script>

 <div class="row">
                        <div class="col-sm-5 login-form">
                    
                               <div class="panel panel-default">
                                   <div class="panel-intro text-center">
                                   <img src="${initParam.root}assets/img/background/apple1.jpg">
                                    <h1 class="logo"> StudyJobs </h1>
                                </div>
                                <div class="panel-body">
                                   <form id="f1" name="findPasswordForm" onsubmit="return checkLogin()">
                                        <div class="form-group">
                                            아이디를 입력하세요 <input type="text" name="id" id="id" placeholder="아이디" class="form-control input-lg">
                                        </div>
                                        <div class="form-group">
                                            전화번호를 입력하세요 <input type="text" name="tel" id="tel" placeholder="전화번호" class="form-control input-lg" >
                                        </div>
                                        <div class="form-group">
                                            <button type="button" class="btn btn-block btn-custom"  id="finder">비밀번호찾기 </button>
                                          <br>
                                          Password : <span id="resultView"></span> 
                                        </div>
                                    </form>
                                </div>
                                <div class="panel-footer">
                                       <a href="findIdView.do">아이디 찾기</a> | <a href="member_login.do">로그인하기</a>
                                    <div style=" clear:both"></div>
                                </div>
                            </div>
                            <p class="text-center">아직 회원이 아니신가요? <a href="member_register.do"><strong>회원가입</strong></a></p>
                                     
                        </div>
                    </div>

