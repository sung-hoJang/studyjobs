<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
   var parentURL;
   function deleteRequest(gLeaderId){
	   parentURL = window.opener.document.URL;
	   if(confirm("삭제하시겠습니까?"))
		   opener.window.location.href="deleteRequestGroup.do?id=${sessionScope.mvo.id}&gLeaderId="+gLeaderId + "&parentURL="+parentURL;
   		   self.close();
   }
   
   
   function deleteCart(gLeaderId){
	   var parentURL1 = window.opener.document.URL;
	   var parentURL2 = document.URL;
	   parentURL = "";
	   var arr = [];
	   arr = parentURL1.split('/');
	   for( var i = 0; i < arr.length; i++){
		   if( arr[i] == 'home.do'){
			   parentURL = parentURL1;
			   break;
		   } else {
			   parentURL = parentURL2;	   
		   }
	   }
	   
	
	   if(confirm("찜 취소 하시겠습니까?"))
		    opener.window.location.href="deleteCart.do?id=${sessionScope.mvo.id}&gLeaderId="+gLeaderId +"&parentURL="+parentURL;
		    self.close();
   }
   
   $(document).ready(function(){
	 $("#close").click(function(){
	 	   window.opener.document.location.href = window.opener.document.URL;
		   self.close();
		});
   }); 

          var gleaderId;
          function waitlist(gLeaderId, id){
           parentURL = window.opener.document.URL;
           gleaderId = gLeaderId;
           if (confirm("찜하시겠습니까?")) {
             xhr=new XMLHttpRequest();
             xhr.onreadystatechange=callback;
             xhr.open("post", "checkCart.do");
             xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
             xhr.send("gleaderId="+gLeaderId+"&id="+id+"&parentURL="+parentURL); 
           }
        }
           function callback(){
        	  	 parentURL = window.opener.document.URL;
                if(xhr.readyState==4){
                 if(xhr.status==200){
				  if(xhr.responseText=="true"){
					alert("그룹에 이미 가입하거나 벌써 찜했습니다. 찜할수 없습니다.");
                  }else{
					alert("찜하기에 더해졌습니다.");
					opener.window.location.href = "waitlist.do?gleaderId="+gleaderId+"&parentURL="+parentURL;
                  } 
                }
            }
        }
           
 </script>

<div class="post">
   <div class="post-title1">
      <h2><center><< ${requestScope.map.groupInfo.gName} >></center></h2>
   </div>
   
   
   <div class="flexslider post-images"> 
   
         <img alt="" src="${requestScope.map.groupInfo.subjectVO.categoryImg}"  style="width: 100%"/>

   </div>
   
   <div class="post-meta1">
      <ul>
         <li>분야 : ${requestScope.map.groupInfo.subjectVO.subjectCategory}</li>
         <li>과목 : ${requestScope.map.groupInfo.subjectVO.subject}</li> 
         <li>지역 : ${requestScope.map.groupInfo.gLocation }</li>
         <li>모집인원수 : ${requestScope.map.groupInfo.gCount}</li>
         <li>${requestScope.map.groupInfo.gInfo}</li> 
      </ul>
   </div>
   
   <div class="post-footer">
      <div class="row">
         <div class="col-xs-6">
            <div class="post-meta2">
               <i class="fa fa-star"></i> 그룹장 <br>
               :  ${requestScope.map.groupInfo.memberVO.id}
            </div>
            
         </div>
         <div class="col-xs-6">
            <div class="item-action pull-right">
            <ul>
           <li>
          
               <c:choose>
               
                  <c:when test="${requestScope.map.groupJoinVO == null}">
					<button class="btn btn-warning" data-target="#sendMessageModal" data-toggle="modal"> <i class="fa fa-envelope"></i> <span class="hidden-xs hidden-sm">가입 신청</span></button>
					<c:choose>
						<c:when test="${requestScope.map.flag == 'fail' }">
							<button class="btn btn-success" onclick="deleteCart('${requestScope.map.groupInfo.memberVO.id}')"><i class="fa fa-trash-o"></i> 찜 취소</button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-success" onclick="waitlist('${requestScope.map.groupInfo.memberVO.id}','${sessionScope.mvo.id }')"><i class="fa fa-heart"></i> 찜 하기</button>
						</c:otherwise>
					</c:choose>
                  </c:when>
                  
                  <c:otherwise>
                  	<button class="btn btn-warning" data-target="#sendMessageModal" data-toggle="modal"> <i class="fa fa-envelope"></i> <span class="hidden-xs hidden-sm">신청 수정</span></button>
                 	<button class="btn btn-success" onclick="deleteRequest('${requestScope.map.groupInfo.memberVO.id}')"><i class="fa fa-trash-o"></i> 신청 철회</button>
                  </c:otherwise>
               </c:choose>
               
               <button type="button" id="close" class="btn btn-info"  aria-haspopup="true" aria-expanded="false">
							     <i class="fa fa-close">  CLOSE</i>
							  </button>
            </li></ul>
            <ul>
           <li>
           
           </ul>
            </div>
         </div>
      </div>
   </div>
</div>

<c:choose>
   <c:when test="${requestScope.map.groupJoinVO == null }">
              <!-- Send Message Modal -->
        <div aria-labelledby="sendMessageModalLabel" role="dialog" tabindex="-1" id="sendMessageModal" class="modal fade in">
            <div role="document" class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button aria-label="Close" data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span></button>
                        <h4 id="sendMessageModalLabel" class="modal-title">가입 신청</h4>
                    </div>
                    <div class="modal-body">
                        <form action="joinGroup.do">
                           <input type="hidden" name="groupVO.memberVO.id" value="${requestScope.map.groupInfo.memberVO.id}">
                            <div class="form-group">
                                <label class="control-label">ID:</label>
                                <input type="text" value="${sessionScope.mvo.id }" class="form-control input-lg" placeholder="Your ID"  name="memberVO.id" required readonly>
                            </div>
                            <div class="form-group">
                                <label class="control-label">제목:</label>
                                <input type="text" class="form-control input-lg" placeholder="Title" name="gjTitle" required>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="message-text">신청내용:</label>
                                <textarea id="message-text" class="form-control input-lg" placeholder="Your message"  name="gjContent" required></textarea>
                            </div>
                          <div class="modal-footer">
                            <button id="requestSubmit" class="btn btn-custom" type="submit"><i class="fa fa-paper-plane"></i> Send</button>
                            <button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
                       </div>
                        </form>
                    </div>
                  
                </div>
            </div>
        </div>
<!--         End Message Modal -->
   </c:when>
   <c:otherwise>
      <!-- sendmessage 버튼 누르면 뜨는 신기한 폼 시작 -->
        <!-- Send Message Modal -->
        <div aria-labelledby="sendMessageModalLabel" role="dialog" tabindex="-1" id="sendMessageModal" class="modal fade in">
            <div role="document" class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button aria-label="Close" data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span></button>
                        <h4 id="sendMessageModalLabel" class="modal-title">가입 신청 수청</h4>
                    </div>
                    <div class="modal-body">
                        <form action="joinGroupUpdate.do">
                           <input type="hidden" name="groupVO.memberVO.id" value="${requestScope.map.groupInfo.memberVO.id}">
                            <div class="form-group">
                                <label class="control-label">ID:</label>
                                <input type="text" value="${sessionScope.mvo.id }" class="form-control input-lg" placeholder="Your ID"  name="memberVO.id" required readonly>
                            </div>
                            <div class="form-group">
                                <label class="control-label">제목:</label>
                                <input type="text" value="${requestScope.map.groupJoinVO.gjTitle }" class="form-control input-lg" placeholder="Title" name="gjTitle" required>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="message-text">신청내용:</label>
                                <textarea id="message-text" class="form-control input-lg" placeholder="Your message"  name="gjContent" required>${requestScope.map.groupJoinVO.gjContent }</textarea>
                            </div>
                          <div class="modal-footer">
                           <button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
                             <button id="requestSubmit"  class="btn btn-custom" type="submit"><i class="fa fa-paper-plane"></i> Send</button>
                       </div>
                        </form>
                    </div>
                  
                </div>
            </div>
        </div>
<!--         End Message Modal -->
<!-- sendmessage 버튼 누르면 뜨는 신기한 폼 끝 -->   
   </c:otherwise>
</c:choose>