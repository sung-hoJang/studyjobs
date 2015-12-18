<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>   

<script type="text/javascript">
    var flag="";
    $(document).ready(function(){
       $.ajax({
          type:"get",
          url:"existMyGroup.do",
          data:"gLeaderId=${sessionScope.mvo.id}",
          success:function(data){
        	  var comp="";
             if(data == "nothing"){
                flag = "false";
                comp += "<a href='auth_member_create_group.do' class='btn btn-ads btn-block'>";
                comp += "그룹생성</a>";
             }
             else{
                flag="true";
                comp += "<a href='' onclick=myGroupPopup('${sessionScope.mvo.id}') class='btn btn-ads btn-block'>";
                comp += "내 그룹</a>";
             }
             
             $(".new-ads").html(comp);
             
          }
       });//ajax
       
      $("#LoginForm").submit(function() {
        if($("#user_remember_me").is(":checked")==true){
          var userid= $("#id").val();
          setCookie("userid", userid, 365);    
        }
      });
    });
    
    function checkCookie() {
       var userid=getCookie("userid");
       if (userid!="") {
           $("#id").val(userid);
           $( "#user_remember_me" ).prop( "checked", true );
       }
   }
    
    function setCookie(cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays*24*60*60*1000));
        var expires = "expires="+d.toUTCString();
        document.cookie = cname + "=" + cvalue + "; " + expires;
    }

    function getCookie(cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for(var i=0; i<ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1);
            if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
        }
        return "";
    }
    
    function myGroupPopup(id){
          if(flag=="true"){
               window.open("group_member_home.do?gLeaderId="+id, "popup",  "width=1000, height=700, left=200");
          }else{
   		   alert("생성한 그룹이 없습니다. 그룹을 생성해 주세요.")
  		  }
      }
</script> 
   
    
    
   <!-- 제일 꼭대기(헤더) 시작 -->
            <header class="navbar navbar-default navbar-fixed-top navbar-top">
                <div class="container">
                    <div class="navbar-header">
                        <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="home.do" class="navbar-brand"><span class="logo"><img src="${initParam.root}assets/img/background/apple2.jpg">StudyJobs</span></a>
                    </div>

                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right">
                       <c:choose>
                       	<c:when test="${sessionScope.mvo != null}">
                       		 <li class="new-ads">
                       		 <!-- <a href="auth_member_create_group.do" class="btn btn-ads btn-block">그룹생성</a> -->  
                       		 </li>	
                       		 <li><a href="member_find_group.do">그룹검색</a></li>
                       		 <li><a href="auth_board_list.do">자유게시판</a></li>
                       		 <c:choose>
                       		 	<c:when test="${sessionScope.mvo.id=='admin'}">
                       		 	    <li class="dropdown">
                               		  <a class="dropdown-toggle" href="#" data-toggle="dropdown"><strong class="caret"></strong>&nbsp;관리자 Page</a>
                               			 <ul class="dropdown-menu">
                                 		   <li><a href="auth_admin_getAllMemberList.do">회원 검색</a></li>
                                           <li><a href="auth_admin_getAllGroupList.do">그룹 검색</a></li>
                       		 	         </ul>
                       		 	    </li>
                       		 	</c:when>
                       		 </c:choose>
                       		 <li class="dropdown">
                                <a class="dropdown-toggle" href="#" data-toggle="dropdown"><strong class="caret"></strong>&nbsp;MyPage</a>
                                <ul class="dropdown-menu">
                                    <li><a href="auth_mypage_grouplist.do">내가 가입한 그룹</a></li>
                                    <li><a href="auth_mypage_join_grouplist.do">가입 요청한 그룹</a></li>
                                   <%--  <li><a href="" onclick="myGroupPopup('${sessionScope.mvo.id}')">내가 만든 그룹</a></li>  --%>
									<li><a href="auth_mypage_schedule.do">내 스케줄</a></li>
                                    <li><a href="auth_mypage_info.do">내 정보</a></li>
                                    <li><a href="auth_mypage_cart.do">내 찜 목록</a></li>
                                </ul>
                            </li>
                           <li class="dropdown">
                                <a class="dropdown-toggle" href="logout.do" ><i class="fa fa-user"></i> 로그아웃 &nbsp;</a>
                            </li> 
                       	</c:when>
                       	<c:otherwise>
                            <li><a href="member_register.do">회원가입</a></li>
                            <li><a href="member_find_group.do">그룹검색</a></li>
                            <li><a href="auth_board_list.do">자유게시판</a></li>
                          
                            <li class="dropdown">
                               <a class="dropdown-toggle" href="#" data-toggle="dropdown" onclick="checkCookie()"><i class="fa fa-user"></i> 로그인<strong class="caret"></strong>&nbsp;</a>                           
                                  <div class="dropdown-menu dropdown-login" style="padding:15px;min-width:250px">
                                    <form action="login.do" method="post" id="LoginForm">                       
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon addon-login"><i class="fa fa-user"></i></span>
                                                <input type="text" placeholder="Id" required="required" class="form-control input-login" name="id" id="id">                                            
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon addon-login"><i class="addon fa fa-lock"></i></span>
                                                <input type="password" placeholder="Password" required="required" class="form-control input-login" name="password">                                            
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="checkbox">
                                                <label class="string optional" for="user_remember_me">
                                                    <input type="checkbox" id="user_remember_me" style="">
                                                    Remember me
                                                </label>
                                            </div>
                                        </div>
                                        <input type="submit" class="btn btn-custom btn-block" value="Login" id="LoginBtn">
                                        <a href="findIdView.do" class="btn-block text-center">Forgot ID?</a>
                                        <a href="findPasswordView.do" class="btn-block text-center">Forgot password?</a>
                                    </form>                                    
                                </div>
                            </li>
                       	</c:otherwise>
                       </c:choose>
                        </ul>
                    </div>
                </div>
            </header>
            <!-- 제일 꼭대기(헤더) 끝 -->