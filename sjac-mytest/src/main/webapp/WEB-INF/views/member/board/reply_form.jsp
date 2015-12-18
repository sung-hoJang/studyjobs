<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<script type="text/javascript">
   $(document).ready(function(){
      $("#answerImg").click(function(){
         if($("#title").val()==""){
            alert("제목을 입력하세요!");
            return;
         }else if($("#content").val()==""){
            alert("본문 내용을 입력하세요!");
            return;
         }
         $("#writeForm").submit();
      });
   });
</script>
<form action="auth_board_reply.do" method="post" id="writeForm"  >
 <table class="table" >
    <caption>답변글쓰기</caption>
    <tbody>
    <tr>
      <td>제목</td>
      <td><input type="text" name="title" id="title" class="form-control"
      value="RE:${requestScope.bvo.title }"></td>
    </tr>
    <tr>
      <td colspan=2 >
      <textarea class="form-control" cols="40" rows="10" name="content" id="content">>>${requestScope.bvo.content}</textarea>      
      </td>
    </tr>
    <tr>
       <td  colspan=2 >
          <img src="${initParam.root}boardtool/img/answer_btn.jpg"  id="answerImg" />      
       </td>
    </tr>
 </table> 
  <input type="hidden" name="ref" value="${requestScope.bvo.ref }">
 <input type="hidden" name="restep" value="${requestScope.bvo.restep }">
 <input type="hidden" name="relevel" value="${requestScope.bvo.relevel }">
 <input type="hidden" name="no" value="${requestScope.bvo.no }"> 
 </form>
</body>
</html>




