<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">
      $(document).ready(function(){
         $("#deleteMyself").click(function(){
             if(confirm("탈퇴하시겠습니까?")){
               location.href="leave.do";
            }  
         }); 
      });

</script>


<div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title"> <a href="#collapseB1" data-toggle="collapse"> My Profile </a> </h4>
                                </div>

                                <form action="auth_mypage_update.do" accept-charset="utf-8" method="post"  id="UserProfileForm" class="form-horizontal">
                                    <div class="panel-body">            
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">ID</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="id" required="required" value="${sessionScope.mvo.id}"  class="form-control" readonly >                                  </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Name</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="name" required="required"  value="${sessionScope.mvo.name}" class="form-control"  readonly>                                   </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Location</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="location" required="required"  value="${sessionScope.mvo.location}" class="form-control"  readonly>                                   </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Tel</label>
                                            <div class="col-sm-9">
                                                <input type="tel" name="tel" value="${sessionScope.mvo.tel}" maxlength="100" class="form-control"  readonly>   
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Gender</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="gender" value="${sessionScope.mvo.gender}" class="form-control"  readonly>  
                                            </div>
                                        </div>
                                         <div class="form-group">
                                            <label  class="col-sm-3 control-label">Birthdate</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="birthdate" class="form-control"  value="${sessionScope.mvo.birthdate}"  readonly>                                         <span class="help-block"></span>
                                            </div>
                                        </div> 
                           
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9"> </div>
                                        </div>

                                    </div>
                                    <div class="panel-footer">
                                        <div class="row">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <input type="submit" class="btn btn-custom" value="나의 정보 수정하기">  &nbsp;
                                                <input type="button" class="btn btn-custom" value="탈퇴하기"  id="deleteMyself"> 
                                            </div>
                                        </div>
                                    </div>
                                </form> 
                            </div>