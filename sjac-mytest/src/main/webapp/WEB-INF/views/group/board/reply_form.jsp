<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
      $("#answerImg").click(function(){
         if($("#category").val()==""){
            alert("카테고리를 선택하세요!");
            return;
         }else if($("#title").val()==""){
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
<form action="group_board_reply.do?gLeaderId=${requestScope.map.gLeaderId }" method="post" id="writeForm"  >
 <table class="table" >
    <caption>답변글쓰기</caption>
    <tbody>
    <tr>
          <td>   
          <input type="text" name="gbCategory" value = "일반글" readonly>   
   </td>
      <td>제목</td>
      <td><input type="text" name="gbTitle" id="title"
      value="RE:${requestScope.map.gbvo.gbTitle }"></td>
    </tr>
    <tr>
      <td colspan=2 >
      <textarea cols="40" rows="10" name="gbContent" id="content">>>${requestScope.map.gbvo.gbContent}</textarea>      
      </td>
    </tr>
    <tr>
       <td  colspan=2 >
          <img src="${initParam.root}boardtool/img/answer_btn.jpg"  id="answerImg" />      
       </td>
    </tr>
 </table> 
  <input type="hidden" name="ref" value="${requestScope.map.gbvo.ref }">
 <input type="hidden" name="restep" value="${requestScope.map.gbvo.restep }">
 <input type="hidden" name="relevel" value="${requestScope.map.gbvo.relevel }">
 </form>
</body>
</html>



