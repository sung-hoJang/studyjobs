<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(document).ready(function(){
		 $("#selLocation").change(function(){
	         $("#location").val($(this).val()); 
	       }); 
		 $("#selLocation").val("${sessionScope.mvo.location}");
		$("#cancelBtn").click(function(){
			location.href="auth_mypage_info.do";
		});
		  $("#selGender").change(function(){
		         $("#gender").val($(this).val());
	    });
		
	});
</script>


<div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title"> <a href="#collapseB1" data-toggle="collapse"> My Profile </a> </h4>
                                </div>

                                <form action="auth_mypage_updateInfo.do" accept-charset="utf-8" method="post"  id="UserProfileForm" class="form-horizontal">
                                    <div class="panel-body">            
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">ID</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="id" required="required" value="${sessionScope.mvo.id }" maxlength="100" class="form-control" readonly >                                  </div>
                                        </div>
                                          <hr>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Password</label>
                                            <div class="col-sm-9">
                                                <input type="password" required="required"  name="password" value="${sessionScope.mvo.password}" maxlength="100" class="form-control" >                        
                                            </div>
                                        </div>
                        				<hr>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Name</label>
                                            <div class="col-sm-9">
                                                <input type="text" required="required"  name="name" value="${sessionScope.mvo.name}" class="form-control" >                                   </div>
                                        </div>
                                        <hr>
                                         <div class="form-group" id="scroll2">
     									 <label class="col-sm-3 control-label">Location</label>
     									   <div class="col-sm-9">
     									   <select name="location" class="item-meta" id="selLocation" >
     									    <c:forEach items="${requestScope.locationList}" var="locationList">
     									   		<option value ="${locationList.gLocation}">${locationList.gLocation}</option>	
     									   </c:forEach> 
     									      </select>
     									       <input type="text" value="${sessionScope.mvo.location }" placeholder="지역" class="form-control input-lg" id="location"   readonly> 								        									        									        									   				         
					                      </div>                
                                        </div>
                                        <hr>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Tel</label>
                                            <div class="col-sm-9">
                                                <input type="tel"  name="tel" value="${sessionScope.mvo.tel}" maxlength="11" class="form-control" >                                  </div>
                                        </div>
                                        <hr>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Gender</label>
                                            <div class="col-sm-9">
                                             <select id="selGender"  class="item-meta">
							                     <option value ="" >성별을 입력하세요</option>   
							                     <c:choose>
							                     	<c:when test="${sessionScope.mvo.gender == '남' }">
							                     		<option value ="남" selected="selected">남</option>
							                     		<option value ="여">여</option>	
							                     	</c:when>
							                     	<c:otherwise>
							                     		<option value ="남" >남</option>
							                     		<option value ="여" selected="selected">여</option>
							                     	</c:otherwise>
							                     </c:choose>
							                  </select>
                                            <input type="text" id="gender" name="gender" value="${sessionScope.mvo.gender}" class="form-control" readonly>                                 </div>
                                        </div>
                                        <hr>
                                         <div class="form-group">
                                            <label  class="col-sm-3 control-label">Birthdate</label>
                                            <div class="col-sm-9">
                                                <input type="date" name="birthdate" class="form-control"  value="${sessionScope.mvo.birthdate}" >                                 <span class="help-block"></span>
                                            </div>
                                        </div>  
                                        <hr>
                          
                           
                                    <div class="panel-footer">
                                        <div class="row">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <input type="submit" class="btn btn-custom" value="수정완료"> 
                                                <button type="button" class="btn btn-default" id="cancelBtn"><i class="fa fa-close">취소</i> </button>
                                            </div>
                                        </div>
                                    </div>
                                    </div>
                                </form> 
                            </div>