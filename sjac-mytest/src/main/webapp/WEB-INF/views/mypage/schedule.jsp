<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#scheduleSelect").change(function(){
		$.ajax({
			type:"get",
			url:"lastSchedule.do",
			data:"scheduleSelect="+$(this).val(),
			success:function(list){
				var comp="";
				$.each(list, function(index, data){
					$("#tableSet").empty();
					comp += "<tr>";
					comp += "<td><img alt='' class='thumb-img img-responsive' src='"+data.groupVO.subjectVO.categoryImg+"'></td>"
					if( data.deadline < 4 && data.deadline >= 0 ){
						comp += "<td bgcolor='#FFCBCB'>";
						comp += "<i class='fa fa-clock-o'></i><strong>"+data.scheduleDate+"</strong>";
						comp += "</td>";
					} else {
						comp += "<td>";
						comp += "<i class='fa fa-clock-o'></i>"+data.scheduleDate;
            	        comp += "</td>";
					}
                    comp += "<td>"; 
					comp += "<div class='item-title'>" + data.groupVO.gName + "</div>";                    
					comp += "</td>";
                    comp += "<td style='word-break:break-all;'>" + data.scheduleInfo;
					comp += "</td>";
					comp += "</tr>";
				})
				$("#tableSet").html(comp);
			}
		})
	});
});

</script>
<div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">My Schedule</h4>
                                </div>
                                <div class="panel-body">
                                    <div class="before-table">
                                        <div class="row">
                                        </div>
                                    </div>
                                    <table class="table table-bordered"> 
                                        <thead>
                                            <tr align="center" style="font-weight: bold;">
                                                <td style="width:15%">Group</td>
                                                <td style="width:25%">Schedule date</td>
                                                <td style="width:25%">Group Name</td>
                                                 <td style="width:40%">Schedule Info</td>
                                            </tr>
                                        </thead>
                                        <tbody id="tableSet">
                                        	<c:forEach items="${requestScope.scheduleList}" var="scheduleList">
                                        		<tr>
                                                <td><img alt="" class="thumb-img img-responsive"  src="${scheduleList.groupVO.subjectVO.categoryImg}"></td>
                                                <c:choose>
                                                	<c:when test="${scheduleList.deadline < 3}">
                                                	  <td bgcolor="#FFCBCB">
                                                        
                                                           <i class="fa fa-clock-o"></i><strong>${scheduleList.scheduleDate}</strong>
                                                        
                                              		  </td>
                                                	</c:when>
                                                	<c:otherwise>
                                                	  <td>
                                                        <i class="fa fa-clock-o"></i>${scheduleList.scheduleDate}
                                                      </td>
                                                	</c:otherwise>
                                                </c:choose> 
                                                <td>
                                                    <div class="item-title">${scheduleList.groupVO.gName}</div>
                                                </td>
                                                <td style="word-break:break-all;">
                                                		${scheduleList.scheduleInfo}
                                                </td>
                                            </tr>
                                        	</c:forEach>
                                        </tbody>
                                    </table>
                                    
                                    
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <select class="form-control" id="scheduleSelect">
                                                <option value="현재 스케줄" selected>현재 스케줄</option>
                                                <option value="지난 스케줄">지난 스케줄</option>
                                            </select>
                                        </div>
                                        <div class="col-xs-9 text-right">
                                        <table><tr><td bgcolor="#FFCBCB"><b>* 임박한 스케줄</b> </td></tr></table>
                                        </div>
                                        
                                    </div>    
                                          
                                </div>
                            </div>