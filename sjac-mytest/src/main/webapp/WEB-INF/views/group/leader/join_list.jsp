<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
   $(document).ready(function(){
      $("#checkAll").change(function () {
         var flag = $("#checkAll").prop("checked");
         $("input[name=checkList]").prop("checked", flag);
      });
      
      
      $("#accept").click(function(){
         if($("input[name=checkList]:checked").length == 0){
            alert("수락할 요청을 선택해주세요.");
            return false;
         }
         else if(parseInt($("#possible").text()) == 0){
            alert("그룹 허용인원을 초과하였습니다.");
            $("#checkAll").attr("checked", false);
            $("input[name=checkList]").attr("checked", false);
            return false;
         }
         else if($("input[name=checkList]:checked").length > parseInt($("#possible").text()) ){
            alert("수락할 요청 수가 그룹 허용인원을 초과합니다.");
            $("#checkAll").attr("checked", false);
            $("input[name=checkList]").attr("checked", false);
            return false;
         }
         
         
         else if(confirm("해당 요청을 수락 하시겠습니까?")){
               var accept = $(":checkbox[name=checkList]:checked");
               var list = [];
               accept.each(function(index){
                   list[index] = $(this).val();
                });
               
               jQuery.ajaxSettings.traditional = true;   //배열타입 넘기려면 사용해야 함
               
               $.ajax({
                  type:"get",
                  url:"accept.do",
                  data:{
                     'acceptList' : list,
                     'gLeaderId' : "${requestScope.map.gvo.memberVO.id}"
                  },
                  success:function(data){
                     
                     var curMember = data.gvo.curMember;
                     var maxMember = data.gvo.gCount;
                     var posMember = maxMember - curMember;
                     var text = "그룹의 현재인원 : " + curMember + " 명 입니다.<span id='possible'>" + posMember + "</span> 명 수락 가능합니다.";
	                     $("#curMember").empty();
	                     $("#listTable").empty();
	                     $("#curMember").html(text);
                     
                     var list = "";
	                     list += "<table class='table table-bordered'>";
	                     list += "<thead>";
	                     list += "<tr>";
	                     list += "<th style='width:10%'><input name='checkAll' id='checkAll' type='checkbox'></th>";
	                     list += "<th style='width:10%'>ID</th>";
	                     list += "<th style='width:30%'>신청 제목</th>";
	                     list += "<th style='width:45%'>신청 내용</th>";
	                     list += "</tr>";
	                     list += "</thead>";
	                     list += "<tbody id='tableSet'>";
	                     
                     $.each(data.joinRequestList, function(index, result){
	                        list += "<tr>";
	                        list += "<td>";
	                        list += "<input type='checkbox' name='checkList' value='"+result.memberVO.id+"'>";
	                        list += "</td>";
	                        list += "<td>" + result.memberVO.id + "</td>";
	                        list += "<td>" + result.gjTitle + "</td>";
	                        list += "<td>";
	                        list += "<div class ='item-title'>" + result.gjContent + "</div>";
	                        list += "</td>";
	                        list += "</tr>";
                     });
                     
	                       list += "</tbody>";
	                       list += "</table>";
                     
                          $("#listTable").html(list);
                  }
               });
         }
      });
      
      $("#listTable").on("change", "#checkAll", function(){
         var flag = $("#checkAll").prop("checked");
         $("input[name=checkList]").prop("checked", flag);
      });
      
      
      $("#reject").click(function(){
    	  if($("input[name=checkList]:checked").length == 0){
              alert("거절할 요청을 선택해주세요.");
              return false;
           }
    	  
         if(confirm("해당 요청을 거절 하시겠습니까?")){
            var reject = $(":checkbox[name=checkList]:checked");
            var list = [];
            reject.each(function(index){
                list[index] = $(this).val();
             });
            
            jQuery.ajaxSettings.traditional = true;   //배열타입 넘기려면 사용해야 함
            
            $.ajax({
               type:"get",
               url:"reject.do",
               data:{
                  'rejectList' : list,
                  'gLeaderId' : "${requestScope.map.gvo.memberVO.id}"
               },
               success:function(data){
                  $("#listTable").empty();
                  
                  var list = "";
	                  list += "<table class='table table-bordered'>";
	                  list += "<thead>";
	                  list += "<tr>";
	                  list += "<th style='width:10%'><input name='checkAll' id='checkAll' type='checkbox'></th>";
	                  list += "<th style='width:10%'>ID</th>";
	                  list += "<th style='width:30%'>신청 제목</th>";
	                  list += "<th style='width:45%'>신청 내용</th>";
	                  list += "</tr>";
	                  list += "</thead>";
	                  list += "<tbody id='tableSet'>";
                  
                  $.each(data, function(index, result){
                     list += "<tr>";
                     list += "<td>";
                     list += "<input type='checkbox' name='checkList' value='"+result.memberVO.id+"'>";
                     list += "</td>";
                     list += "<td>" + result.memberVO.id + "</td>";
                     list += "<td>" + result.gjTitle + "</td>";
                     list += "<td>";
                     list += "<div class ='item-title'>" + result.gjContent + "</div>";
                     list += "</td>";
                     list += "</tr>";
                  });
                  
	                  list += "</tbody>";
	                  list += "</table>";
	                  
               		  $("#listTable").html(list);
               }
            });
         }
      });
      
   });
   
</script>

<div class="post">
   <div class="section-header">
      <h2>가입 요청</h2>

   </div>
   <div class="post-body">
      <div id="curMember">
         그룹의 현재인원 : ${requestScope.map.gvo.curMember } 명 입니다. 
         <span id="possible">${requestScope.map.gvo.gCount-requestScope.map.gvo.curMember }</span> 명 수락 가능합니다.
      </div>
      <div id="listTable">
         <table class="table table-bordered">
            <thead>
               <tr>
                  <th style="width: 10%"><input name="checkAll" id="checkAll" type="checkbox"></th>
                  <th style="width: 10%">ID</th>
                  <th style="width: 30%">신청 제목</th>
                  <th style="width: 45%">신청 내용</th>
               </tr>
            </thead>
            <tbody id="tableSet">
               <c:forEach items="${requestScope.map.joinList}" var="vo">
                  <tr>
                     <td>
                        <input type="checkbox" name="checkList" value="${vo.memberVO.id }">
                     </td>
                     <td>${vo.memberVO.id }</td>
                     <td>${vo.gjTitle }</td>
   
                     <td>
                        <div class="item-title">${vo.gjContent }</div>
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
   </div>

</div>

<script>
$(document).ready(function(){
   
});
   
   
</script>

<div class="post-footer">
   <div class="col-xs-6  pull-right">
            <div class="item-action pull-right">
               <ul>
                  <li>
                  <a data-toggle="tooltip" id="accept" data-placement="top" title="수락" class="btn btn-success btn"> 
                  <i class="fa fa-check-square"></i> 수락</a></li>
                  <li><a data-toggle="tooltip" id="reject" data-placement="top" title="거절" class="btn btn-info btn"> 
                  <i class="fa fa-cut"></i> 거절
            </a></li>
               </ul>
            </div>
         </div>
</div>