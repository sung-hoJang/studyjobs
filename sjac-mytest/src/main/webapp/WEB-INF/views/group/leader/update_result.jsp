<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<script>
$(document).ready(function(){
   $("#goHome").click(function(){
      location.href = "group_member_home.do?gLeaderId=${requestScope.map.gLeaderId}";
   });   
});

</script>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title"> <a href="#collapseB1" data-toggle="collapse"> Update Group </a> </h4>
                                </div>

                                <form action="" accept-charset="utf-8" method="post"  id="UserProfileForm" class="form-horizontal">
                                    <div class="panel-body">             
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">ID</label>
                                            <div class="col-sm-9">
                                                <input type="text" required="required" value="${sessionScope.mvo.id}" class="form-control" readonly>                                   
                                 </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">그룹 이름</label>
                                            <div class="col-sm-9">
                                                <input type="text"  required="required" value="${requestScope.map.gvo.gName }"  maxlength="10" class="form-control" name="gName" readonly>                                
                                            </div>
                                        </div>
                                         <div class="form-group">
                                            <label class="col-sm-3 control-label">최대인원</label>
                                            <div class="col-sm-9">
                                                <input type="number" min="1" required="required" class="form-control" name="gCount" value="${requestScope.map.gvo.gCount }" readonly>                                
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">현재인원</label>
                                            <div class="col-sm-9">
                                                <input type="text" required="required" value="${requestScope.map.gvo.curMember }" class="form-control" readonly>                                
                                            </div>
                                        </div>
                                        
                                        
                                         <div class="form-group">
                                            <label class="col-sm-3 control-label">카테고리</label>
                                            <div class="col-sm-9">
                                     <input type="text"  required="required" value="${requestScope.map.gvo.subjectVO.subjectCategory }"  class="form-control" readonly>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">과목</label>
                                            <div class="col-sm-9">
                                                <input type="text" value="${requestScope.map.gvo.subjectVO.subject }"  required="required" class="form-control" name="subjectVO.subject" readonly>                                
                                            </div>
                                        </div>
                                        
                                         <div class="form-group">
                                            <label class="col-sm-3 control-label">지역</label>
                                            <div class="col-sm-9">
                                               <input type="text" value="${requestScope.map.gvo.gLocation }"  required="required" class="form-control"  readonly>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">그룹 정보</label>
                                            <div class="col-sm-9">
                                                <textarea style="height: 300px; width: 100%" class="form-control" name="gInfo" readonly>${requestScope.map.gvo.gInfo }</textarea>                                
                                            </div>
                                        </div>
                                     
                                    <div class="panel-footer">
                                        <div class="row">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <button type="button" id="goHome" class="btn btn-custom" ><i class="fa fa-home"></i> 그룹 홈으로</button>
                                            </div>
                                        </div>
                                    </div>
                                    </div>
                                </form> 
                            </div>