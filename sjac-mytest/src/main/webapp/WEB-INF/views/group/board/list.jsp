<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${initParam.root}jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    //group_board_findCategorizedList.do
     $("#searchForm").submit(function(event){
        if("${requestScope.map['hidden']}"=='category'){
           var keyText=$("input:text[name=keywordBlank]").val();
             $(location).attr("href","group_board_findCategorizedList.do?keyText="+keyText+"&gLeaderId=${requestScope.map.gLeaderId }&category=${requestScope.map.category}"); 
            event.preventDefault();//페이지 초기화 방지
        }else{
            var keyText=$("input:text[name=keywordBlank]").val();
             $(location).attr("href","group_board_findList.do?keyText="+keyText+"&gLeaderId=${requestScope.map.gLeaderId }"); 
            event.preventDefault();//페이지 초기화 방지
        }
     });//자유 게시판 검색
   
   //group_board_findListByCategory
     $("#showGeneral,#showUpload").click(function(){
           var category=$(this).val();
           $(location).attr("href","group_board_findListByCategory.do?category="+category+"&gLeaderId=${requestScope.map.gLeaderId }");
     });//카테고리별 리스트 가져오기
     $("#showAll").click(function(){
         $(location).attr("href","group_board_list.do?gLeaderId=${requestScope.map.gLeaderId}");
   });//전체보기 버튼
     
 
   
});//ready

</script>

<style>
.myButton {
   -moz-box-shadow: 0px 1px 0px 0px #f0f7fa;
   -webkit-box-shadow: 0px 1px 0px 0px #f0f7fa;
   box-shadow: 0px 1px 0px 0px #f0f7fa;
   background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #33bdef), color-stop(1, #019ad2));
   background:-moz-linear-gradient(top, #33bdef 5%, #019ad2 100%);
   background:-webkit-linear-gradient(top, #33bdef 5%, #019ad2 100%);
   background:-o-linear-gradient(top, #33bdef 5%, #019ad2 100%);
   background:-ms-linear-gradient(top, #33bdef 5%, #019ad2 100%);
   background:linear-gradient(to bottom, #33bdef 5%, #019ad2 100%);
   filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#33bdef', endColorstr='#019ad2',GradientType=0);
   background-color:#33bdef;
   -moz-border-radius:6px;
   -webkit-border-radius:6px;
   border-radius:6px;
   border:1px solid #057fd0;
   display:inline-block;
   cursor:pointer;
   color:#ffffff;
   font-family:Arial;
   font-size:12px;
   font-weight:bold;
   padding:6px 15px;
   text-decoration:none;
   text-shadow:0px -1px 0px #5b6178;
}
.myButton:hover {
   background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #019ad2), color-stop(1, #33bdef));
   background:-moz-linear-gradient(top, #019ad2 5%, #33bdef 100%);
   background:-webkit-linear-gradient(top, #019ad2 5%, #33bdef 100%);
   background:-o-linear-gradient(top, #019ad2 5%, #33bdef 100%);
   background:-ms-linear-gradient(top, #019ad2 5%, #33bdef 100%);
   background:linear-gradient(to bottom, #019ad2 5%, #33bdef 100%);
   filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#019ad2', endColorstr='#33bdef',GradientType=0);
   background-color:#019ad2;
}
.myButton:active {
   position:relative;
   top:1px;
}


</style>
                                    <div class="before-table">
                                        <div class="row">
                                           &nbsp;
                                      <input type="button"  class="myButton" id="showGeneral" value="일반글"> 
                                      <input type="button"  class="myButton" id="showUpload" value="업로드"> 
                                      <input type="button"  class="myButton" id="showAll" value="전체"> 
                                        </div>
                                    </div>
   <table class="table">
      <thead>
      <tr bgcolor="#C4DEFF">
         <th class="gbNo">NO</th>
         <th class="gbCategory">카테고리</th>
         <th class="gbTitle">제목</th>
         <th class="gbName">작성자</th>
         <th class="gbDate">작성일</th>
         <th class="gbHits">HIT</th>
         </tr>      
         <c:forEach var="gbvo" items="${requestScope.map.glvo.glist}">      
         <tr>
             <td>${gbvo.gbNo }</td>         
             <td>${gbvo.gbCategory }</td>                           
            <td class="titleView">
            <c:if test="${gbvo.parent==0}">
               <div class="deletedParent">[원글이 삭제된 답글]</div>
               </c:if>
               <c:if test="${gbvo.relevel!=0}">
               <c:forEach begin="0" end="${gbvo.relevel}" step="1">&nbsp;&nbsp;</c:forEach>
               <img src="${initParam.root }boardtool/img/reply.jpg">
               </c:if>
               <a href="${initParam.root}group_board_show_content.do?no=${gbvo.gbNo }&gLeaderId=${requestScope.map.gLeaderId }">${gbvo.gbTitle}</a>
            </td>            
            <td>${gbvo.memberVO.id }</td>
            <td>${gbvo.gbDate }</td>
            <td>${gbvo.gbHits }</td>
         </tr>         
         </c:forEach>
   </table><br>
   <a href="${initParam.root }group_board_show_write.do?gLeaderId=${requestScope.map.gLeaderId }"><img id="writeImg" src="${initParam.root }/boardtool/img/write_btn.jpg" border="0"></a>
   <br></br>   
   
                                   <form class="form-inline pull-right" id="searchForm">
                                                    <div class="form-group">
                                                            <div class="input-group">
                                                                <input type="text" name="keywordBlank"  placeholder="Type keyword ..." class="form-control2">
                                                                <div class="input-group-addon" >
                                                                 <button type="submit"  class="myButton" ><i class="fa fa-search"></i></button>
                                                        <!--    <button type="submit"><i class="fa fa-search"></i></button> -->
                                                                </div>
                                                            </div>
                                                    </div>
                                                </form>
   
    
            <div class="row">
                                <div class="col-md-12 text-right">
                                    <ul class="pagination">
                                     <c:if test="${requestScope.map.glvo.paging.previousPageGroup}">
                              <c:choose >
                              <c:when test="${requestScope.map['hidden']=='find'}">
                              <li>  <a href= "group_board_findList.do?pageNo=${requestScope.map.glvo.paging.startPageOfPageGroup-1}&gLeaderId=${requestScope.map.gLeaderId }&keyText=${requestScope.map.keyText }">◀</a></li>
                              </c:when>
                              <c:when test="${requestScope.map['hidden']=='category'}">
                              <li>  <a href= "group_board_findListByCategory.do?pageNo=${requestScope.map.glvo.paging.startPageOfPageGroup-1}&gLeaderId=${requestScope.map.gLeaderId }&category=${requestScope.map.category}">◀</a></li>
                              </c:when>
                               <c:when test="${requestScope.map['hidden']=='categoryfind'}">
                               <li>  <a href= "group_board_findCategorizedList.do?pageNo=${requestScope.map.glvo.paging.startPageOfPageGroup-1}&gLeaderId=${requestScope.map.gLeaderId }&category=${requestScope.map.category}&keyText=${requestScope.map.keyText}">◀</a></li>
                              </c:when>
                              <c:otherwise>
                              <li>  <a href= "group_board_list.do?pageNo=${requestScope.map.glvo.paging.startPageOfPageGroup-1}&gLeaderId=${requestScope.map.gLeaderId }">◀</a></li>
                              </c:otherwise>
                      </c:choose>
                               </c:if>
                               <!--  됨 -->
                                  <c:forEach var="i"  begin="${requestScope.map.glvo.paging.startPageOfPageGroup}"
                                           end="${requestScope.map.glvo.paging.endPageOfPageGroup}">
                                  <c:choose>
                                    <c:when test="${requestScope.map.glvo.paging.nowPage!=i}">
                                   <c:choose >
                                 <c:when test="${requestScope.map['hidden']=='find'}">
                                 <li><a href="group_board_findList.do?pageNo=${i}&gLeaderId=${requestScope.map.gLeaderId }&keyText=${requestScope.map.keyText }">${i}</a></li>
                                 </c:when>
                                 <c:when test="${requestScope.map['hidden']=='category'}">
                                  <li><a href="group_board_findListByCategory.do?pageNo=${i}&gLeaderId=${requestScope.map.gLeaderId }&category=${requestScope.map.category}">${i}</a></li>
                                 </c:when>
                                  <c:when test="${requestScope.map['hidden']=='categoryfind'}">
                                   <li><a href="group_board_findCategorizedList.do?pageNo=${i}&gLeaderId=${requestScope.map.gLeaderId }&category=${requestScope.map.category}&keyText=${requestScope.map.keyText}">${i}</a></li>
                                 </c:when>
                                 <c:otherwise>
                                   <li><a href="group_board_list.do?pageNo=${i}&gLeaderId=${requestScope.map.gLeaderId }">${i}</a></li>
                                 </c:otherwise>
                            </c:choose>
                                  </c:when>
                                   <c:otherwise>
                                          <li class="active1"><a href="">${i}</a></li>
                                         </c:otherwise>
                                        </c:choose>
                                </c:forEach>    
                                   <c:if test="${requestScope.map.glvo.paging.nextPageGroup}">
                                  <c:choose >
                                 <c:when test="${requestScope.map['hidden']=='find'}">
                                 <li> <a href="group_board_findList.do?pageNo=${requestScope.map.glvo.paging.endPageOfPageGroup+1}&gLeaderId=${requestScope.map.gLeaderId }&keyText=${requestScope.map.keyText }">▶</a></li>
                                 </c:when>
                                 <c:when test="${requestScope.map['hidden']=='category'}">
                                 <li> <a href="group_board_findListByCategory.do?pageNo=${requestScope.map.glvo.paging.endPageOfPageGroup+1}&gLeaderId=${requestScope.map.gLeaderId }&category=${requestScope.map.category}">▶</a></li>
                                 </c:when>
                                  <c:when test="${requestScope.map['hidden']=='categoryfind'}">
                                   <li> <a href="group_board_findCategorizedList.do?pageNo=${requestScope.map.glvo.paging.endPageOfPageGroup+1}&gLeaderId=${requestScope.map.gLeaderId }&category=${requestScope.map.category}&keyText=${requestScope.map.keyText}">▶</a></li>
                                 </c:when>
                                 <c:otherwise>
                                   <li> <a href="group_board_list.do?pageNo=${requestScope.map.glvo.paging.endPageOfPageGroup+1}&gLeaderId=${requestScope.map.gLeaderId }">▶</a></li>
                                 </c:otherwise>
                            </c:choose>
                                        
                                </c:if>   
                                    </ul>
                                </div>
                            </div>   
     
 