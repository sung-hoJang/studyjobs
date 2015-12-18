<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <script type="text/javascript">
    $(document).ready(function(){
       $("#deleteImg").click(function(){ 
          if(confirm("게시물을 삭제하시겠습니까?"))
          location.href="auth_board_deleteBoard.do?no=${requestScope.bvo.no }";
       });
       $("#updateImg").click(function(){  
          if(confirm("게시물을 수정하시겠습니까?"))
          location.href="auth_board_updateView.do?no=${requestScope.bvo.no }";
       });
    });   
</script>
   <table class="table">
               <tr>
                  <td><b>${requestScope.bvo.title}</b>
                  </td>
               </tr>
               <tr>
                  <td><font size="2">글쓴이: ${requestScope.bvo.memberVO.id }
                     |   조회수: ${requestScope.bvo.hits } 
                     |   ${requestScope.bvo.myDate}</font></td>
               </tr>
               <tr>
                  <td><textarea cols="40" rows="10" name="content" class="form-control"
                        readonly="readonly">${requestScope.bvo.content }</textarea></td>
               </tr>
               <tr>
                  <td valign="middle">
                  <c:if test="${requestScope.bvo.category!='공지' }">
                  <a href="auth_board_replyView.do?no=${requestScope.bvo.no}">
                     <img src="${initParam.root}boardtool/img/answer_btn.jpg"></a>
                  </c:if>
                     <a href="auth_board_list.do"><img src="${initParam.root}boardtool/img/list_btn.jpg"></a>
                     <c:if test="${requestScope.bvo.memberVO.id==sessionScope.mvo.id}"> 
                     <img id="updateImg" src="${initParam.root}boardtool/img/modify_btn.jpg">
                     <img id="deleteImg" src="${initParam.root}boardtool/img/delete_btn.jpg">
                     </c:if>
                  </td>
               </tr>
               <tr>
                  <td><span id="inputPass"></span></td>
               </tr>
   </table>