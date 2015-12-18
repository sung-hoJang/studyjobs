<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

    
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
                        <a class="navbar-brand"><span class="logo"><img src="${initParam.root}assets/img/background/apple2.jpg">StudyJobs</span></a>
                    </div>

                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right">
                     
                              <li class="dropdown">
                                <a class="dropdown-toggle" href="#" data-toggle="dropdown" id="MyGroupDropDown"><strong class="caret"></strong>&nbsp;MyGroup</a>
                               <ul class="dropdown-menu">
                                   <c:forEach items="${requestScope.map.groupList }" var="gvo" >
                              <c:if test="${gvo.memberVO.id!=param.gLeaderId}">
                              <li><a href="group_member_home.do?gLeaderId=${gvo.memberVO.id }"><i class="fa fa-hand-o-right">&nbsp;${gvo.memberVO.id}(${gvo.gName })</i></a></li>
                              </c:if>                                      
                           </c:forEach>                              
                                </ul>
                            </li>
                       
                        </ul>
                    </div>
                </div>
            </header>
            <!-- 제일 꼭대기(헤더) 끝 -->