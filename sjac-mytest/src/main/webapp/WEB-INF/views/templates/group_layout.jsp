   <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
   <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
   <html>
   <head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta name="robots" content="index, follow">
   <title>STUDYJOBS</title>
   <link rel="stylesheet"
      href="//fonts.googleapis.com/css?family=Open+Sans:regular,700,600&amp;latin"
      type="text/css" />
   <!-- Essential styles -->
   <link rel="stylesheet"
      href="${initParam.root}assets/bootstrap/css/bootstrap.min.css"
      type="text/css">
   <link rel="stylesheet"
      href="${initParam.root}assets/plugins/font-awesome/css/font-awesome.css"
      type="text/css">
   
   <!-- Dlapak styles -->
   <link id="theme_style" type="text/css"
      href="${initParam.root}assets/css/style1.css" rel="stylesheet"
      media="screen">
   
   
   <!-- Favicon -->
   <link href="${initParam.root}assets/img/favicon.png" rel="icon"
      type="image/png">
   
   <!-- Assets -->
   <link rel="stylesheet"
      href="${initParam.root}assets/plugins/owl-carousel/owl.carousel.css">
   <link rel="stylesheet"
      href="${initParam.root}assets/plugins/owl-carousel/owl.theme.css">
   <link rel="stylesheet"
      href="${initParam.root},assets/plugins/flexslider/flexslider.css"
      type="text/css" media="screen" />
   
   <!-- JS Library -->
   <script src="${initParam.root}assets/js/jquery.js"></script>
   
   

   
<script type="text/javascript">
   $(document).ready(function(){
      $("#groupMemberHome").click(function(){
         location.href = "group_member_home.do?gLeaderId=${requestScope.map.gLeaderId}";
      });
      
      $("#groupShowInfo").click(function(){
         location.href= "group_show_info.do?gLeaderId=${requestScope.map.gLeaderId}";
      });
      
      $("#getRequestList").click(function(){
         location.href = "getRequestList.do?gLeaderId=${requestScope.map.gLeaderId }";
      });
      
      $("#leaveThisGroup").click(function(){
         if(confirm("해당 그룹에서 탈퇴하시겠습니까?"))
            location.href = "leaveThisGroup.do?gLeaderId=${requestScope.map.gLeaderId }";
      });
      
      $("#groupBoard").click(function(){
          location.href="group_board_list.do?gLeaderId=${requestScope.map.gLeaderId }";
       })
      
      $("#groupSchedule").click(function(){
    	  location.href="group_schedule.do?gLeaderId=${requestScope.map.gLeaderId }";
      });
      
      $("#deleteGroup").click(function(){
          if(confirm("해당 그룹을 삭제하시겠습니까?"))
             location.href="deleteGroup.do?gLeaderId=${requestScope.map.gLeaderId}";
        });
      
      $("#updateGroupInfo").click(function(){
          location.href="updateGroupInfo.do?gLeaderId=${requestScope.map.gLeaderId}";
       });
      
      $("#close").click(function(){
         self.close();
      });
   });
   
   
   
   
   
</script>
                       
   </head>
   <body>
      <div class="wrapper">
         <div id="container">
            <div id="header">
               <tiles:insertAttribute name="header" />
            </div>
            <section class="main">
               <div class="container">
                  <div class="row">
                     <div class="col-md-12">
   

                           <div class="panel panel-default" style="background-color: #896AB7; color: #fff; height: 60px;">
                              <div class="panel-body">
                                 <h3>${requestScope.map.gvo.gName }(그룹장 - <i class="fa fa-star"> ${requestScope.map.gLeaderId }</i>)</h3>
                              </div>
                           </div>
                           
                          
   
                              <div class="container-fluid">

                           <div> 
                     <div class="btn-group">
                       <button type="button" id="groupMemberHome" class="btn btn-primary"  aria-haspopup="true" aria-expanded="false">
                       <i class="fa fa-home">  Home </i> 
                       </button>
                        <button type="button" id="groupBoard" class="btn btn-success"  aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-pencil-square-o">  게시판 </i> 
                       </button>
                        <button type="button" id="groupSchedule" class="btn btn-danger"  aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-calendar">  스케줄 </i> 
                       </button>
                        <button type="button" id="groupShowInfo" class="btn btn-warning"  aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-child">  그룹원 정보 </i> 
                       </button>
                       <c:choose>
                          <c:when test="${requestScope.map.checkLeader == 'OK' }">
                           <button type="button" id="getRequestList" class="btn btn-default"  aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-list">  가입 요청 </i> 
                          </button>
                          <button type="button" id="deleteGroup" class="btn btn-primary"  aria-haspopup="true" aria-expanded="false">
                   		    <i class="fa fa-trash-o">  그룹 삭제 </i> 
                      	   </button>
                      	   <button type="button" id="updateGroupInfo" class="btn btn-warning"  aria-haspopup="true" aria-expanded="false">
                              <i class="fa fa-gear">  그룹페이지 수정 </i> 
                            </button>
                          </c:when>
                          <c:otherwise>
                             <button type="button" id="leaveThisGroup" class="btn btn-default"  aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-sign-out">그룹 탈퇴</i>
                             </button>
                          </c:otherwise>
                       </c:choose>
                        <button type="button" id="close" class="btn btn-info"  aria-haspopup="true" aria-expanded="false">
                          <i class="fa fa-close"> close</i>
                       </button>
                     </div>
                      
                                 </div> 
                              </div>
                        <br>
                     </div>
                  </div>
                  <div class="row">
                     <div class="col-md-8 col-sm-8">
                        <div class="row">
                           <div class="col-md-12">
                              <tiles:insertAttribute name="mainpart" />
                           </div>
                        </div>
                        <div class="row">
                           <div class="col-md-12">
   
   
                              <div class="row"></div>
   
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4 col-sm-4">
                        <tiles:insertAttribute name="right" />
                     </div>
                  </div>
               </div>
            </section>
   
            <div class="footer">
               <tiles:insertAttribute name="footer" />
            </div>
         </div>
      </div>
   
      <!-- Essentials -->
      <script src="assets/bootstrap/js/bootstrap.min.js"></script>
      <script src="assets/plugins/owl-carousel/owl.carousel.js"></script>
      <script src="assets/plugins/counter/jquery.countTo.js"></script>
      <script defer src="assets/plugins/flexslider/jquery.flexslider.js"></script>
      <script type="text/javascript">
         $(document).ready(function() {
            // ===============Flexslider=====================
            $('.flexslider').flexslider({
               animation : "slide",
               controlNav : "thumbnails",
               directionNav : false,
               start : function(slider) {
                  $('body').removeClass('loading');
               }
            });
            // ==========tooltip initial=================
            $('[data-toggle="tooltip"]').tooltip();
         });
      </script>
   </body>
   </html>