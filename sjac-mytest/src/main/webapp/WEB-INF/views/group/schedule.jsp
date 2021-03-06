<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/sunny/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">

   $(document).ready(function(){
      $("#scheduleSubmit").click(function(event){
    	  var flag = "";
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
         $.ajax({
          	  type:"get",
          	  url:"checkDuplicatedDate.do",
          	  data:"scheduleDate="+$("#scheduleDate").val()+"&gLeaderId=${requestScope.map.gLeaderId}",
          	  success:function(data){
          		 if(data == "exist"){
          			 flag = "fail";
          			 $("#viewComp").html("<h6 align='right' style='color:red'>해당 날짜에 스케줄이 존재합니다. 날짜를 다시 선택해주세요.</h6>");
					return false;
          		 }
          		 else{
          			 flag = "ok";
					
          			var url="submit_schedule.do?gLeaderId=${requestScope.map.gLeaderId }&"+$("#scheduleForm").serialize();
          			$(location).attr('href',url);
          		}
          	  }
            });
			
         if( flag != "ok" ){
        	 return false;
         } 
      });
      
      
   });
</script>

<div class="row" style="width: 70%; margin-left: 17%;" >
      <div class="panel panel-default">
         <div class="panel-intro text-center">
         <h1>스케줄 등록</h1>
         </div>
         <div class="panel-body">
            <form id="scheduleForm">             
               <hr>
               <div class="form-group">
                     <input type="date" placeholder="만남날짜" class="form-control input-lg" name="scheduleDate" id="scheduleDate">
                     <span id="viewComp"></span>
                     <input type="time" placeholder="만남시간" class="form-control input-lg" name="scheduleTime" id="timepicker">
               </div>
               <div class="form-group">
                  <textarea  placeholder="만남내용" class="form-control input-lg"
                     name="scheduleInfo" id="scheduleInfo" style="height: 100px; width: 100%;"></textarea>
               </div> 
               
               <div class="form-group">
                  <button class="btn btn-block btn-custom" id = "scheduleSubmit">스케줄등록</button>
               </div>
            </form>
         </div>
   </div>
</div>