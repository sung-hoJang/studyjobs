<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script> 
    <script type="text/javascript">
    $(document).ready(function(){
       $("#deleteImg").click(function(){ 
          if(confirm("게시물을 삭제하시겠습니까?"))
          location.href="group_board_deleteBoard.do?no=${requestScope.map.gbvo.gbNo }&gLeaderId=${requestScope.map.gLeaderId}";
       });
       $("#updateImg").click(function(){  
          if(confirm("게시물을 수정하시겠습니까?"))
          location.href="group_board_updateView.do?no=${requestScope.map.gbvo.gbNo }&gLeaderId=${requestScope.map.gLeaderId}";
       });
    });   
</script>
   <table class="table">
               <tr>
                  <td><b>제목 : ${requestScope.map.gbvo.gbTitle}</b>
                  </td>
               </tr>
               <tr>
                  <td>글쓴이: ${requestScope.map.gbvo.memberVO.id }
                     |   조회수: ${requestScope.map.gbvo.gbHits } 
                     |   ${requestScope.map.gbvo.gbDate}</td>
               </tr>
               <c:if test="${requestScope.map.gbvo.gbCategory=='업로드'}">
                <tr>
                  <td>
                  파일 : <a href = "fileDownLoad.do?filename=${requestScope.map.gbvo.groupVO.memberVO.id}_${requestScope.map.gbvo.gbNo}&fname=${requestScope.map.gbvo.fname}&gLeaderId=${requestScope.map.gLeaderId}">${requestScope.map.gbvo.fname }</a>
                  </td>
               </tr>
               </c:if>
               <tr>
                  <td><textarea cols="75" rows="15" name="content"
                        readonly="readonly">${requestScope.map.gbvo.gbContent }</textarea></td>
               </tr>
               <tr>
                  <td valign="middle">
                  <a href="group_board_replyView.do?no=${requestScope.map.gbvo.gbNo}&gLeaderId=${requestScope.map.gLeaderId}">
                     <img src="${initParam.root}boardtool/img/answer_btn.jpg"></a>
                     <a href="group_board_list.do?gLeaderId=${requestScope.map.gLeaderId }"><img src="${initParam.root}boardtool/img/list_btn.jpg"></a>
                     <c:if test="${requestScope.map.gbvo.memberVO.id==sessionScope.mvo.id}"> 
                     <img id="updateImg" src="${initParam.root}boardtool/img/modify_btn.jpg">
                     <img id="deleteImg" src="${initParam.root}boardtool/img/delete_btn.jpg">
                     </c:if>
                  </td>
               </tr>
               <tr>
                  <td><span id="inputPass"></span></td>
               </tr>
   </table>