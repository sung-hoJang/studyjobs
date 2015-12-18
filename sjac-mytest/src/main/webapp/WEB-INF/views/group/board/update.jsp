<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <form method=post action="group_board_update.do?gLeaderId=${requestScope.map.gLeaderId }">
         <table class="table">
            <tr>
               <td>
               <b>글번호: <input type=text name=gbNo value=${requestScope.map.gbvo.gbNo } readonly></input>
               | 타이틀:<input type=text name=gbTitle value=${requestScope.map.gbvo.gbTitle }></input></b>
               </td></tr><tr>   <td>
                  작성일시:${requestScope.map.gbvo.gbDate } 
               </td>
            </tr>
            <tr>
               <td>                  
   <textarea rows="15" cols="75" name="gbContent">${requestScope.map.gbvo.gbContent }</textarea>
               </td>
            </tr>
            <tr>
               <td valign="middle">                  
               <input type="submit" value="수정하기"   ></input>         
               </td>            
            </tr>
         </table>
</form>   
         