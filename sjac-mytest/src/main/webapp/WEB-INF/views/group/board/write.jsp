<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>

     <script src="//code.jquery.com/jquery-1.10.2.js"></script>
     <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
      <link rel="stylesheet" href="/resources/demos/style.css">
<script type="text/javascript">
   $(document).ready(function(){
      $("#category").change(function(){
         if($(this).val()=='일반글')
            $("#uploadFile").hide();
         else
            $("#uploadFile").show();
      });
      $("#writeImg").click(function(){
         if($("#category").val()==""){
            alert("카테고리를 선택하세요!");
            return;
         }else if($("#title").val()==""){
            alert("제목을 입력하세요!");
            return;
         }else if($("#content").val()==""){
            alert("본문 내용을 입력하세요!");
            return;
         }else if(($("#category").val()=='업로드') && ($("#uploadFile").val()=="")){
            alert("업로드 파일을 선택하세요!")
            return;
         }
         $("#writeForm").submit();
      });
   });
</script>
<form action="${initParam.root }group_board_write.do?gLeaderId=${requestScope.map.gLeaderId }" enctype="multipart/form-data" method="post" id="writeForm" >
 <table class="table">
    <thead>
    	<tr><td colspan=2><center><font size="5">글쓰기</font></center> </td></tr>
    </thead>
    <tbody>
   <tr>
      <td style="width: 10%; font-size: 15px; vertical-align: middle;">
      <center>제목</center>
      
      </td>
      <td>
      <select name="gbCategory" id="category">
        <option value="">카테고리</option>
        <option value="일반글">일반글</option>
        <option value="업로드">업로드</option>
   </select>
      <input type="text" name="gbTitle" id="title" class="form-control" placeholder = "Title"></td>
    </tr>
    <tr>
      <td colspan=2><textarea cols="32" rows="10" name="gbContent" id="content" class="form-control" placeholder = "Content"
      style="height:300px;width: 100%"
      ></textarea></td>
    </tr>
    <tr>
      <td colspan=2>
         <input type = "file" name = "file[0]" id="uploadFile">
      </td>
   </tr>
    <tr>
       <td  colspan=2 >
          <img id="writeImg" src="${initParam.root}boardtool/img/write_btn.jpg"  />          
       </td>
    </tr>
    </tbody>
 </table> 
 </form>