<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <form method=post action="auth_board_update.do">
         <table class="table">
            <tr>
               <td>
               <b>글번호: </b><input type=text name=no value=${bvo.no } readonly></input></td></tr>
               <tr><td>
               <b>타이틀: </b><input style="width: 80%;" class="form-control" type=text name=title  value=${bvo.title }></input>
               </td></tr><tr>   <td>
                  <font size="2"> 
                  작성일시:${bvo.myDate } 
               </font>
               </td>
            </tr>
            <tr>
               <td>                  
   <textarea rows="15" cols="75" name="content" class="form-control">${bvo.content }</textarea>
               </td>
            </tr>
            <tr>
               <td valign="middle">                  
               <input type="submit" value="수정하기"   ></input>         
               </td>            
            </tr>
         </table>
</form>   
         