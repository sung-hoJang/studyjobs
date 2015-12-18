<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/sunny/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
      
      $("#scheduleDelete").click(function(){
          var date= "${fn:substring(requestScope.map.schvo.scheduleDate, 0,4) }-${fn:substring(requestScope.map.schvo.scheduleDate, 5, 7)}-${fn:substring(requestScope.map.schvo.scheduleDate, 8,10)}";
          var time= "${fn:substring(requestScope.map.schvo.scheduleDate, 11,16) }"
          if(confirm(date+"해당날짜의 스케쥴을 삭제하시겠습니까?")){
          var url = "delete_scheduleByScheduleDate.do?scheduleDate="+date+"&scheduleTime="+time+"&gLeaderId=${requestScope.map.gLeaderId}";    
          $(location).attr('href',url);
       }
       });
      
      
      $("#scheduleSubmit").click(function(){
         if($("#datepicker").val()==""){
            alert("약속 날짜를 선택하세요!");
            return false;
         }else if($("#timepicker").val()==""){
             alert("약속 시간를 선택하세요!");
             return false;
          }else if($("#scheduleInfo").val()==""){
            alert("스케줄 정보를 입력하세요!");
            return false;
         }
         $("#scheduleForm").submit();
      });
   });
</script>

<div class="row" style="width: 70%; margin-left: 17%;" >
      <div class="panel panel-default">
         <div class="panel-intro text-center">
         <c:set var="date" value="${requestScope.map.schvo.scheduleDate}"/>
         <h1>스케쥴 수정</h1>
         </div>
         <div class="panel-body">
            <form action="update_schedule.do?gLeaderId=${requestScope.map.gLeaderId }&orgScheduleDate=${date}" method="post" id="registerForm">             
               <hr>
               <div class="form-group">
                     <input type="date"  value=${fn:substring(date, 0,4) }-${fn:substring(date, 5, 7)}-${fn:substring(date, 8,10)}  class="form-control input-lg" name="scheduleDate" >
                     <input type="time" value=${fn:substring(date, 11,16) } class="form-control input-lg" name="scheduleTime" id="timepicker">
               </div>
               <div class="form-group">
                  <textarea  placeholder="만남내용" class="form-control input-lg"   value=${requestScope.map.schvo.scheduleInfo}
                     name="scheduleInfo" id="scheduleInfo" style="height: 100px; width: 100%;">${requestScope.map.schvo.scheduleInfo}</textarea>
               </div> 
               
               <div class="form-group">
                  <button class="btn btn-block btn-custom" id = "scheduleSubmit">스케줄수정</button>
                  
               </div>
            </form>
            <button class="btn btn-block btn-custom" id = "scheduleDelete">스케줄삭제</button>
         </div>
   </div>
</div>