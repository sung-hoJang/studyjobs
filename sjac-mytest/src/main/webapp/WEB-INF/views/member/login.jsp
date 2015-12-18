<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#loginBtn").click(function(){
		location.href="login.do?id="+$("#id").val() + "&password=" + $("#password").val();
	});
});
</script>
    
    
<div class="row">
                        <div class="col-sm-5 login-form">
                            <c:choose>
                            	<c:when test="${requestScope.id != null}">
                            	<div class="panel panel-default">
                            		 <div class="panel-intro text-center">
                            		 <img src="${initParam.root}assets/img/background/apple1.jpg"> 
                                    <h1 class="logo">StudyJobs </h1>
                                </div>
                                <div class="panel-body">
                                    <form action="login.do" id="loginForm" method="post">
                                        <div class="form-group">
                                            <input type="text" placeholder="ID" class="form-control input-lg" name="id" id="id" value="${requestScope.id}">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" placeholder="Password" class="form-control input-lg" name="password" id="password">
                                        </div>
                                        <div class="form-group">
                                        	<font size="3" color="red">아이디 또는 비밀번호를 다시 확인하세요.</font>
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn-block btn-custom"  id="loginBtn">로그인 </button>
                                        </div>
                                    </form>
                                </div>
                                <div class="panel-footer">
                                    <div class="checkbox pull-left">
                                        <label for="terms" class="string optional">
                                            <input type="checkbox" style="" id="terms">Remember me
                                        </label>
                                    </div>
                                    <p class="text-center pull-right">
                                    	<a href="findIdView.do">아이디 찾기</a> | 
                                        <a href="findPasswordView.do">비밀번호 찾기</a>
									</p>
                                    <div style=" clear:both"></div>
                                </div>
                            </div>
                            <p class="text-center">아직 회원이 아니신가요? <a href="member_register.do"><strong>회원가입</strong></a></p>
                            
                            	</c:when>
                            <c:otherwise>
                            <div class="panel panel-default">
                                <div class="panel-intro text-center">
                                    <h1 class="logo"><i class="fa fa-recycle"></i> Job∩Study</h1>
                                </div>
                                <div class="panel-body">
                                    <form action="login.do" id="loginForm" method="post">
                                        <div class="form-group">
                                            <input type="text" placeholder="ID" class="form-control input-lg" name="id" id="id">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" placeholder="Password" class="form-control input-lg" name="password" id="password">
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn-block btn-custom"  id="loginBtn">로그인 </button>
                                        </div>
                                    </form>
                                </div>
                                <div class="panel-footer">
                                    <div class="checkbox pull-left">
                                        <label for="terms" class="string optional">
                                            <input type="checkbox" style="" id="terms">Remember me
                                        </label>
                                    </div>
                                    <p class="text-center pull-right">
                                    	<a href="findIdView.do">아이디 찾기</a> | 
                                        <a href="findPasswordView.do">비밀번호 찾기</a>
                                     </p>
                                    <div style=" clear:both"></div>
                                </div>
                            </div>
                            <p class="text-center">아직 회원이 아니신가요? <a href="member_register.do"><strong>회원가입</strong></a></p>
                            </c:otherwise>
                            </c:choose>
                                  	
                        </div>
                    </div>