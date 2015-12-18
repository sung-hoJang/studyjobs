<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

   <!-- Accordion -->
   <link rel="stylesheet"
      href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
   <script src="//code.jquery.com/jquery-1.10.2.js"></script>
   <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
   <link rel="stylesheet" href="/resources/demos/style.css">
   
   <style>
           #accordion-resizer {
                         padding: 7px;
                         width: 100%;
                         font-family: monospace;
                         font-size: 13px;
                       }
	</style> 
	
	<script>
  $(function() {
    $( "#accordion" ).accordion({
      heightStyle: "content"
      
    });
  });
  </script>
   <script type="text/javascript">
   
      $(function() {
         var icons = {
            heightStyle : "content",
            header : "ui-icon-circle-arrow-e",
            activeHeader : "ui-icon-circle-arrow-s"
         };
         $("#accordion").accordion({
            icons : icons
         });
         $("#toggle").button().click(function() {
            if ($("#accordion").accordion("option", "icons")) {
               $("#accordion").accordion("option", "icons", null);
            } else {
               $("#accordion").accordion("option", "icons", icons);
            }
         });
      
      });
      
  
   </script>

<div class="post">
   <div class="post-body">
      
   </div>
      <!-- accordion -->
<div class="section-header">
         <h2>RecentBoard</h2>
         </div>       
      <div id="accordion-resizer" >
         <div id="accordion">
            <c:forEach items="${requestScope.map.list }" var = "gbvo"  begin="0" end="4" varStatus="status" >
            <h3>제목 :  ${gbvo.gbTitle}</h3>
               <p>${gbvo.gbContent}</p>
            </c:forEach>               
         </div>
      </div>
   </div>
   
   <div class="post-footer">
      <div class="row">
         <div class="col-xs-6">
         </div>
      </div>
   </div>