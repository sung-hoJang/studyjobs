<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="account-header">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-4 col-md-3 col-lg-2">
                                <!-- User avatar -->
                                <div class="profile_avatar">
                                </div>
                            </div>
                            <div class="col-sm-8 col-md-9 col-lg-10">
                                <div class="profile_summary">
                                    <!-- User name --> 
                                    <c:choose>
                                    <c:when test="${sessionScope.mvo!=null }">
                                    <h3 class="profile_name">${sessionScope.mvo.name } 님 로그인</h3>
                                    <!-- User status -->
                                    <p> ID : ${sessionScope.mvo.id }</p>
                                    </c:when>
                                    <c:otherwise>
                                          비회원
                                    </c:otherwise>
                                    </c:choose>
                                    <!-- Contact -->
                                    <a href="logout.do" class="btn btn-primary btn-warning btn-sm"><i class="fa fa-sign-out"></i> 로그아웃</a>
                                </div> <!-- / .profile__summary -->
                            </div>
                        </div> <!-- / .row -->
                    </div> <!-- / .container -->
                </div>