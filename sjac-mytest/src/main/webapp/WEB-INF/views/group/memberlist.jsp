<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
         
<div id="groupMember">
<c:forEach var="mvo" items ="${requestScope.map.list }" varStatus="status">
	
   <div class="col-xs-4 col-sm-3" style="width: 300px;">
   
   <c:choose>
	<c:when test="${mvo.id != requestScope.map.gLeaderId}">
		<div class="shortcut" >
	</c:when>
	<c:otherwise>
		<div class="shortcut" style="background-color: #E4F7BA;">
			
	</c:otherwise>
	</c:choose>
	
	
<!--       <div class="shortcut"> -->
      <c:choose>
         <c:when test="${mvo.gender=='남' }">
            <div style="background: #5AAEFF;"><i class="fa fa-mars"></i></div>
         </c:when>
         <c:otherwise>
            <div style="background: #FFFF48;"><i class="fa fa-venus"></i></div>
         </c:otherwise>
      </c:choose>
         
         <div class="item-title">
          <h4><i class="fa fa-smile-o"> ${mvo.name }</i></h4>
            </div>
         <div class="item-meta">
            <ul>
               <li class="item-location"><i class="fa fa-map-marker"></i><strong> 지역</strong><br>${mvo.location }</li>
               <li class="item-cat"><i class="fa fa-phone"></i><strong> 전화번호</strong><br>
               ${fn:substring(mvo.tel, 0,3) }-${fn:substring(mvo.tel, 3, 7)}-${fn:substring(mvo.tel, 7,11)}</li>
               <li class="item-type"><i class="fa fa-hand-peace-o"></i><strong> 나이</strong><br>
               ${mvo.birthdate} 세</li>
            </ul>
         </div>
         
         <script type="text/javascript">
         $(document).ready(function(){
            $("#getAwayGroupMember${status.count}").click(function(){
                if(confirm("${mvo.name} 회원을 삭제하시겠습니까?")){
                 	location.href = "getAwayGroupMember.do?id=${mvo.id}&gLeaderId=${requestScope.map.gLeaderId }";
                }
           });    
         });
         </script>
         
         <div class="item-meta">
            <c:choose>
               <c:when test="${requestScope.map.checkLeader == 'OK' && mvo.id != requestScope.map.gLeaderId}">
                  <a data-toggle="tooltip" id="getAwayGroupMember${status.count }" data-placement="top" title="강퇴" class="btn btn-success btn"> 
                        <i class="fa fa-trash-o"></i> 얘 강퇴
                     </a>   
               </c:when>
               <c:when test="${requestScope.map.checkLeader == 'OK' }">
               	<a data-toggle="tooltip" data-placement="top" title="방장" class="btn btn-default btn"> 
                        <i class="fa fa-star"></i> 난 방장
                     </a>
               </c:when>
            </c:choose>
            
         </div>
      </div>
   </div>

</c:forEach>
</div>