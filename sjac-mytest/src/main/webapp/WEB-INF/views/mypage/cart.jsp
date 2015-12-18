<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
   function popup(id){
      window.open("checkMyGroup.do?gLeaderId="+id, "popup",  "width=1000, height=700, left=200");
   }
</script> 
<script type="text/javascript">
$(document).ready(function(){
   $("#category").change(function(){
      if($("#category").val() == ""){
         $("#subject").empty();
         return false;
      }else{
         $.ajax({
            type:"get",
            url:"auth_mypage_subject_category.do",
            data:"category="+$(this).val(),
            success:function(list){
               var comp="<option value='전체'>소분류</option>";
               $.each( list, function(index, data){
                  comp += "<option value='"+data.subject+"'>" + data.subject + "</option>";
               })
               $("#subject").html(comp);
            }
         });
      }
      
      $.ajax({
         type:"get",
         url:"auth_mypage_getCartListByCategory.do",
         data:"category="+$(this).val(),
         success:function(list){
            var comp="";
            $("#grouplist").empty();
            $.each( list, function(index, data){
               comp += "<div class='col-sm-12' style='cursor:pointer' onclick=popup('" + data.memberVO.id +"')> <div class='item-ads1'> <div class='row'> <div class='col-sm-2 col-xs-3'><div class='item-img'>";
               comp += "<img src='"+data.subjectVO.categoryImg+"'></div></div>";
               comp += "<div class='col-sm-8 col-xs-6'><div class='item-title'>";
               comp += "<a href=''><h4>"+data.gName+"</h4></a>"; 
               comp += "</div>";
               comp += "<div class='item-meta'>";
               comp += "<ul>";
               comp += "<li class='item-date' style='width:230px;height:40px;text-overflow: ellipsis;-o-text-overflow:ellipsis;overflow: hidden;    white-space: nowrap;word-wrap: normal !important;cursor:hand'><i class='fa fa-comment-o'></i> " + data.gInfo + "</li>";
               comp += "</ul><ul>";
               comp += "<li class='item-cat hidden-xs'><i class='fa fa-bars'></i> "+ data.subjectVO.subjectCategory + ", " + data.subjectVO.subject + "</li>";
               comp += "<li class='item-location hidden-xs'><i class='fa fa-map-marker'></i> " + data.gLocation + "</li>";
               comp += "<li class='item-type'><i class='fa fa-user'></i> " + data.curMember + "/" + data.gCount + "</li>";
               comp += "</ul>";
               comp += "<ul>";
               comp += "<li ><i class='fa fa-clock-o'> 그룹 시작 : " + data.gDate + "</i></li>";
               comp += "</ul>";
               comp += "</div>";
               comp += "</div>";
               comp += "<div class='col-sm-2 col-xs-3'><div class='item-price'><h4>그룹장</h4>";
               comp += "<h3>"+ data.memberVO.id + "</h3>";
               comp += "</div>";
               comp += "<div class='item-action' id ='1'>";
               comp += "<ul>";
               comp+= "</ul></div></div>";
               comp+= "</div></div></div>";
            })
            $("#grouplist").html(comp);   
         }
      })
   });
   
   $("#subject").on("change", function(){
      $.ajax({
         type:"get",
         url:"auth_mypage_cart_select.do",
         data:"subject="+$(this).val()+"&category="+$("#category").val(),
         success:function(sublist){
            var listComp ="";
            $("#grouplist").empty();

            $.each(sublist, function(index, data){
               listComp += "<div class='col-sm-12' style='cursor:pointer' onclick=popup('" + data.memberVO.id +"')> <div class='item-ads1'> <div class='row'> <div class='col-sm-2 col-xs-3'><div class='item-img'>";
               listComp += "<img src='"+data.subjectVO.categoryImg+"'></div></div>";
               listComp += "<div class='col-sm-8 col-xs-6'><div class='item-title'>";
               listComp += "<a href=''><h4>"+data.gName+"</h4></a>"; 
               listComp += "</div>";
               listComp += "<div class='item-meta'>";
               listComp += "<ul>";
               listComp += "<li class='item-date' style='width:230px;height:40px;text-overflow: ellipsis;-o-text-overflow:ellipsis;overflow: hidden;    white-space: nowrap;word-wrap: normal !important;cursor:hand'><i class='fa fa-comment-o'></i> " + data.gInfo + "</li>";
               listComp += "</ul><ul>";
               listComp += "<li class='item-cat hidden-xs'><i class='fa fa-bars'></i> "+ data.subjectVO.subjectCategory + ", " + data.subjectVO.subject + "</li>";
               listComp += "<li class='item-location hidden-xs'><i class='fa fa-map-marker'></i> " + data.gLocation + "</li>";
               listComp += "<li class='item-type'><i class='fa fa-user'></i> " + data.curMember + "/" + data.gCount + "</li>";
               listComp += "</ul>";
               listComp += "<ul>";
               listComp += "<li ><i class='fa fa-clock-o'> 그룹 시작 : " + data.gDate + "</i></li>";
               listComp += "</ul>";
               listComp += "</div>";
               listComp += "</div>";
               listComp += "<div class='col-sm-2 col-xs-3'><div class='item-price'><h4>그룹장</h4>";
               listComp += "<h3>"+ data.memberVO.id + "</h3>";
               listComp += "</div>";
               listComp += "<div class='item-action' id ='1'>";
               listComp += "<ul>";
               listComp+= "</ul></div></div>";
               listComp+= "</div></div></div>";
            });
            
            $("#grouplist").html(listComp);
         }
      });
   });
});

</script>

 <div class="category-header no-margin-bottom">
                                <div class="row">
                                    <div class="col-md-4  cat-search-input">
                                        <select class="form-control" id="category">
                                           <option value="전체">전체</option>
                                            <option value="영어">영어</option>
                                            <option value="프로그래밍">프로그래밍</option>
                                            <option value="취업">취업</option>
                                            <option value="금융">금융</option>
                                        </select>
                                    </div>
                                    <div class="col-md-4  cat-search-input">
                                       <!-- 과목 선택 -->
                              <select class="form-control" id= "subject">
                                 
                              </select>
                              <!-- 과목 선택 끝-->   
                                    </div>
                                    <div class="col-md-4 text-right  cat-search-input">
                                        <div class="view-type">
                                             <a href="auth_mypage_cart.do"  data-toggle="tooltip" data-placement="top" title="List"><i class="fa fa-th-list"></i></a>
                                            <a href="auth_mypage_cart_grid.do"  data-toggle="tooltip" data-placement="top" title="Grid"><i class="fa fa-th"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>

<div class="search-results-box">
   <div class="row">
      <div class="col-md-12 search-results">
       <span>"나의 찜 리스트" &nbsp;&nbsp; 그룹 개수
       ${requestScope.map.cartCount} </span>
      </div>
   </div>
</div>

<div class="list-results">
                                <div class="row" id ="grouplist" >
                                  <c:forEach items="${requestScope.map.cartList}" var="cartList">
                                    <div class="col-sm-12" style="cursor:pointer" onclick="popup('${cartList.memberVO.id}')">
                                    
                                    
                                        <div class="item-ads1">

                                            <div class="row">
         
                              
                                    <div class="col-sm-2 col-xs-3">
                                              
                                                    <div class="item-img">
                                                       <img alt="" src="${cartList.subjectVO.categoryImg}">
                                                    </div>
                                                </div>
                                                
                                                <!-- 그룹 정보 -->
                                                <div class="col-sm-8 col-xs-6">
                                                    <div class="item-title">
                                                       <h4>${cartList.gName}</h4>
                                                    </div>
                                                    <div class="item-meta">
                                                        <ul>
                                                            <li class="item-date" style="width:230px;height:40px;text-overflow: ellipsis;-o-text-overflow:ellipsis;overflow: hidden;    white-space: nowrap;word-wrap: normal !important;cursor:hand"><i class="fa fa-comment-o"></i> ${cartList.gInfo }</li>
                                                        </ul>
                                                        <ul>
                                                            <li class="item-cat hidden-xs"><i class="fa fa-bars"></i> ${cartList.subjectVO.subjectCategory}, ${cartList.subjectVO.subject}</li>
                                                            <li class="item-location hidden-xs"><i class="fa fa-map-marker"></i> ${cartList.gLocation}</li>
                                                            <li class="item-type"><i class="fa fa-user"></i> ${cartList.curMember}/${cartList.gCount }</li>
                                                        </ul>
                                                        <ul>
                                                            <li ><i class="fa fa-clock-o"> 그룹 시작 : ${cartList.gDate}</i></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <!-- 그룹정보 끝 -->
                                                
                                                <div class="col-sm-2 col-xs-3">
                                                    <div class="item-price">
                                                    <h4>그룹장</h4>
                                                        <h3>${cartList.memberVO.id}</h3>
                                                    </div>
                                                    <div class="item-action" id="1">
                                                        <ul>
                                                        
                                                        </ul>
                                                    </div>
                                                </div>
                               
                                            </div>   
                                        </div>
                                        
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>
        