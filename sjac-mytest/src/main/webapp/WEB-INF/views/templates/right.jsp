<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />  
   

 <script>

 var groupScheduleDay = new Array("${requestScope.map.scheduleList.size()}");
 
 for ( var i = 0; i < "${requestScope.map.scheduleList.size()}"; i++){
    groupScheduleDay[i] = new Array(4);
 }
 var count= 0;
 $(document).ready(function() {
   var scheduleMonth = "";
     $.datepicker.regional['ko'] = {
     closeText: '닫기',
     prevText: '이전달',
     nextText: '다음달',
     currentText: '오늘',
     monthNames: ['1월','2월','3월','4월','5월','6월',
     '7월','8월','9월','10월','11월','12월'],
     monthNamesShort: ['1월','2월','3월','4월','5월','6월',
     '7월','8월','9월','10월','11월','12월'],
     dayNames: ['일','월','화','수','목','금','토'],
     dayNamesShort: ['일','월','화','수','목','금','토'],
     dayNamesMin: ['일','월','화','수','목','금','토'],
     weekHeader: 'Wk',
     dateFormat: 'yy-mm-dd',
     firstDay: 0,
     isRTL: false,
     duration:200,
     showAnim:'show',
     showMonthAfterYear: true,
     yearSuffix: '년',
     onChangeMonthYear: function (year, month, inst) {
//       alert("이게 나중??");
      initializeDate(year, month, inst);
         count = 0;
         var tableArea="";
      if( (month / 10) < 1 )
         scheduleMonth = "0"+month;
      else 
         scheduleMonth = month;
      
      $("#clickThisCal").text("달력의 날짜 하나를 클릭하세요.");
//       alert("이게나중2??");
//          $.ajax({
//             type:"get",
//             url:"findGroupPageScheduleByYearAndMonth.do",
//             data:"gLeaderId=${requestScope.map.gLeaderId}&selectedYearMonth="+year+"/"+scheduleMonth,
//             success:function(data){
               
//                $("#scheduleBody").empty();
//                $.each(data,function(index, result){
//                   var scheduleValue = result.scheduleDate;
//                   var value = scheduleValue.substring(0,4);
//                   value += "-" + scheduleValue.substring(5, 7);
//                   value += "-" + scheduleValue.substring(8, 10);
                  
//                      tableArea += "<tr>";
//                      if( result.deadline < 3 && result.deadline >= 0){
//                         tableArea += "<td><font color='red'>"+result.scheduleDate+"</font></td>";
//                         tableArea += "<td><font color='red'>"+result.deadline+"</font></td>";
//                         tableArea += "<td><font color='red'>"+result.scheduleInfo+"</font></td>";
//                      } else{
//                         tableArea += "<td>"+result.scheduleDate+"</td>";
//                          tableArea += "<td>"+result.deadline+"</td>";
//                          tableArea += "<td>"+result.scheduleInfo+"</td>";                
//                      }
// //                      else{
// //                         tableArea += "<td><font color='black'>"+result.scheduleDate+"</font></td>";
// //                          tableArea += "<td><font color='black'>"+result.deadline+"</font></td>";
// //                          tableArea += "<td><font color='black'>"+result.scheduleInfo+"</font></td>";
// //                      }
//                      tableArea += "</tr>";
//                });
               
//                $("#scheduleBody").html(tableArea);
//             }
//          });
     },
     beforeShowDay : selectedDays
     };
     
     //////////////////////////////////////
     function initializeDate(year, month, inst){
//         alert("ll");
        groupScheduleDay=new Array("${requestScope.map.scheduleList.size()}");
        for ( var i = 0; i < "${requestScope.map.scheduleList.size()}"; i++){
           groupScheduleDay[i] = new Array(4);
        }
        count = 0;
         var tableArea="";
      if( (month / 10) < 1 )
         scheduleMonth = "0"+month;
      else 
         scheduleMonth = month;
        $.ajax({
             type:"get",
             url:"findGroupPageScheduleByYearAndMonth.do",
             data:"gLeaderId=${requestScope.map.gLeaderId}&selectedYearMonth="+year+"/"+scheduleMonth,
             success:function(data){
                
                $("#scheduleBody").empty();
                $.each(data,function(index, result){
                  var temp = result.scheduleDate;
//                   temp.substring(0,4);
                      groupScheduleDay[index][0] = temp.substring(0,4);
                      groupScheduleDay[index][1] = temp.substring(5,7);
                      groupScheduleDay[index][2] = temp.substring(8,10);
                      groupScheduleDay[index][3] = "ko";
//                       alert(groupScheduleDay[index][0]+"-"+groupScheduleDay[index][1]+"-"+groupScheduleDay[index][2]);
                   var scheduleValue = result.scheduleDate;
                   var value = scheduleValue.substring(0,4);
                   value += "-" + scheduleValue.substring(5, 7);
                   value += "-" + scheduleValue.substring(8, 10);
                   
                      tableArea += "<tr>";
                      if( result.deadline < 3 && result.deadline >= 0){
                          tableArea += "<td><font color='red'>"+result.scheduleDate+"</font></td>";
                          tableArea += "<td><font color='red'>"+result.deadline+"</font></td>";
                          tableArea += "<td style='word-break:break-all;'><font color='red'>"+result.scheduleInfo+"</font></td>";
                       } else if( result.deadline < 0){
                          tableArea += "<td>"+result.scheduleDate+"</td>";
                           tableArea += "<td>"+result.deadline+"</td>";
                           tableArea += "<td  style='word-break:break-all;'>"+result.scheduleInfo+"</td>";                
                       }
                       else{
                          tableArea += "<td><font color='black'>"+result.scheduleDate+"</font></td>";
                           tableArea += "<td><font color='black'>"+result.deadline+"</font></td>";
                           tableArea += "<td style='word-break:break-all;'><font color='black'>"+result.scheduleInfo+"</font></td>";
                       }
                      tableArea += "</tr>";
                });
                
                $("#scheduleBody").html(tableArea);
             }
          });
     }
     
     
     $.datepicker.setDefaults($.datepicker.regional['ko']); 
     
   $( "#datepicker" ).datepicker({ 
      dateFormat: 'yy-mm-dd' ,
      minDate: new Date(2010, 1, 1),  // 날짜 선택 가능 시작일자 선택 가능 
      maxDate: new Date(2030, 12, 31),   // 날짜 선택 가능 종료일자 선택 가능
   }); 
   
   $("#datepicker").change(function(){
      console.log("change 시점  : " + count);
      count=0;
      var flag="";
      var tableArea="";
      var clickDate = $(this).val();
      $.ajax({
         type:"get",
         url:"groupPageSchedule.do",
         data:"gLeaderId=${requestScope.map.gLeaderId}",
         success:function(data){
            $("#scheduleBody").empty();
            $.each(data,function(index, result){
               
               var scheduleValue = result.scheduleDate;
               var value = scheduleValue.substring(0,4);
               value += "-" + scheduleValue.substring(5, 7);
               value += "-" + scheduleValue.substring(8, 10);
               
               if(value == clickDate){
                  tableArea += "<tr>";
                  if( result.deadline < 3 && result.deadline >= 0){
                     tableArea += "<td><font color='red'>"+result.scheduleDate+"</font></td>";
                     tableArea += "<td><font color='red'>"+result.deadline+"</font></td>";
                     tableArea += "<td style='word-break:break-all;'><font color='red'>"+result.scheduleInfo+"</font></td>";
                  } else if( result.deadline < 0){
                     tableArea += "<td>"+result.scheduleDate+"</td>";
                      tableArea += "<td>"+result.deadline+"</td>";
                      tableArea += "<td>"+result.scheduleInfo+"</td>";                
                  }
                  else{
                     tableArea += "<td><font color='black'>"+result.scheduleDate+"</font></td>";
                      tableArea += "<td><font color='black'>"+result.deadline+"</font></td>";
                      tableArea += "<td style='word-break:break-all;'><font color='black'>"+result.scheduleInfo+"</font></td>";
                  }
                  tableArea += "</tr>";
                  
                  flag = true;
                  return false;
               } else
                  flag = false;
            });
            
            $("#scheduleBody").html(tableArea);
            if(flag==false){
                tableArea = "";
                tableArea = "<tr><td colspan = '3'>해당 날짜에 스케줄이 없습니다.</td></tr>";
                $("#scheduleBody").html(tableArea);    
            }
         }
      });
    
    
   })
   $("#viewAllListBtn").click(function(){
      var tableArea = "";
      $.ajax({
         type:"get",
         url:"getGroupScheduleListByGLeaderId.do",
         data:"gLeaderId=${requestScope.map.gLeaderId}",
         success:function(data){
            $("#scheduleBody").empty();
            $.each(data,function(index, result){
               tableArea += "<tr>";
               if( result.deadline < 3 && result.deadline >= 0){
               tableArea += "<td><font color='red'>"+result.scheduleDate+"</font></td>";
               tableArea += "<td><font color='red'>"+result.deadline+"</font></td>";
               tableArea += "<td style='word-break:break-all;'><font color='red'>"+result.scheduleInfo+"</font></td>";
                } else if( result.deadline < 0){
               tableArea += "<td>"+result.scheduleDate+"</td>";
                    tableArea += "<td>"+result.deadline+"</td>";
                    tableArea += "<td>"+result.scheduleInfo+"</td>";                
                }
                else{
               tableArea += "<td><font color='black'>"+result.scheduleDate+"</font></td>";
                    tableArea += "<td><font color='black'>"+result.deadline+"</font></td>";
                    tableArea += "<td style='word-break:break-all;'><font color='black'>"+result.scheduleInfo+"</font></td>";
            }
               
               tableArea += "</tr>";
           
            });
            
            $("#scheduleBody").html(tableArea);
         }
      });
      
   });
   
   
   $("#scheduleBody tr").click(function(){
       var date = $(this).children().eq(0).text();
       if(confirm(date+"해당날짜의 스케쥴을 수정하시겠습니까?")){
       var url = "find_scheduleByScheduleDate.do?scheduleDate="+date+"&gLeaderId=${requestScope.map.gLeaderId}";    
       $(location).attr('href',url);
    }
       
    }); 
   
   $("#scheduleBody").on("click", "tr", function(){
	   var date = $(this).children().eq(0).text();
       if(confirm(date+"해당날짜의 스케쥴을 수정하시겠습니까?")){
       var url = "find_scheduleByScheduleDate.do?scheduleDate="+date+"&gLeaderId=${requestScope.map.gLeaderId}";    
       $(location).attr('href',url);
       }
   });
   
   
 });

 </script>

 <style>
.ui-datepicker{
   width: 100%;
}

.ui-datepicker .ui-state-active, .ui-widget-content .ui-state-active, .ui-widget-header .ui-state-active {  
    color: lime;  /*글자색상*/
    background: black; /*배경색상*/
}

.ko_day { 
   color: lime;  /*글자색상*/ 
   background: red; /*배경색상*/ 
}

/* .ko_day { text-indent : -9999px; background: #eee url(/imgs/korea.png) no-repeat center;} */

</style> 

   
<div class="widget">

<div  class="widget-body" id="datepicker" style="width: 100%;"></div> 
<div class="widget-body" id="clickThisCal"></div>

</div>
<div class="widget">
<div class="section-header">
         <h2>Our Schedule</h2>
</div>  
<div id="viewAllList" align="center">
<button type="button" id="viewAllListBtn" class="btn btn-default"  aria-haspopup="true" aria-expanded="false"><i class="fa fa-calendar-o">  이번 달 모든 스케줄 </i> </button>
</div>
<table class="table">
<thead>
<tr bgcolor="#C4DEFF">
<td style="width: 30%; vertical-align: middle;">날짜</td>
<td style="width: 10%;"> D-Day</td>
<td style="width: 60%; vertical-align: middle;">스케줄 정보</td>

</tr>
</thead>

<tbody id="scheduleBody">
<c:forEach items="${requestScope.map.scheduleList}" var="scheduleList" varStatus="status">

<tr>
<c:choose>
   <c:when test="${scheduleList.deadline < 3 && scheduleList.deadline >= 0}">
      <td><font color="red">${scheduleList.scheduleDate}</font> </td>
      <td><font color="red"> ${ scheduleList.deadline}</font></td>
      <td style="word-break:break-all;"><font color="red" > ${scheduleList.scheduleInfo}</font></td>
    </c:when>
    <c:when test="${scheduleList.deadline < 0 }">
      <td> ${scheduleList.scheduleDate}</td>
      <td> ${ scheduleList.deadline}</td>
      <td style="word-break:break-all;"> ${scheduleList.scheduleInfo}</td>             
    </c:when>
   <c:otherwise>
      <td><font color="black">${scheduleList.scheduleDate}</font> </td>
      <td><font color="black"> ${ scheduleList.deadline}</font></td>
      <td style="word-break:break-all;"><font color="black"> ${scheduleList.scheduleInfo}</font></td>
      
   </c:otherwise>
</c:choose>
</tr>

<script>
   var index = "${status.count}";
   index = parseInt(index)-1;
//    groupScheduleDay[index] = ["${fn:substring(scheduleList.scheduleDate, 0, 4)}", "${fn:substring(scheduleList.scheduleDate, 5,7)}", "${fn:substring(scheduleList.scheduleDate, 8, 10)}", "ko"];
   console.log(index);
   groupScheduleDay[index][0] = "${fn:substring(scheduleList.scheduleDate, 0, 4)}";
   groupScheduleDay[index][1] = "${fn:substring(scheduleList.scheduleDate, 5,7)}";
   groupScheduleDay[index][2] = "${fn:substring(scheduleList.scheduleDate, 8, 10)}";
   groupScheduleDay[index][3] = "ko";
//    alert(groupScheduleDay[index][0] + groupScheduleDay[index][1] + groupScheduleDay[index][2]);
</script>
</c:forEach>
</tbody>
</table>
</div>

<script>
var number=0;
function selectedDays(date) {
//    alert("이게먼저??");
   console.log("-------------------------------------------------------------")
   console.log("--------------number : " + number++ + "-----------------------");
   console.log(" getYear etc : " + date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate());
   console.log( " count : " + count);
   console.log("그룹쒜쥴ㄷ[ㅔ이 : " + groupScheduleDay[0]);
   if(groupScheduleDay[0] != "undefined" && count < "${requestScope.map.scheduleList.size()}"){
      console.log("이프문 : " + groupScheduleDay[0][0]);
//    var availday = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
//    alert(availday);
//    if( $.inArray(availday, groupScheduleDay) > -1 ){
//       alert(availday);
//       return [true, "eventday", ""];
//    }
//    else {
//       return [true, "other", ""];   
   
//    }
//    var highlight = groupScheduleDay[date];
//     if(highlight){
//        return [true, "event", highlight];
//     }else
//        return [true, '', ''];
   
   //1달의 기간을 check함
   //문제: groupScheduleDay는 0번째꺼만 선택됨..
//    for (var i = 0; i < groupScheduleDay.length; i++) {
//        var availday = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
//        var temp = groupScheduleDay[i][0]+"-"+groupScheduleDay[i][1]+"-"+groupScheduleDay[i][2];
//        alert(availday+ " == " + temp);
//        if(availday == temp){
//           alert(availday+ " " + temp);
//           return [true , groupScheduleDay[i][3] + '_day'];
//        }
//        else
//           return [true, ""];
//        if(date.getFullYear() == groupScheduleDay[i][0] && (date.getMonth()+1) == groupScheduleDay[i][1] && date.getDate() == groupScheduleDay[i][2]){
//             return [true , groupScheduleDay[i][3] + '_day'];
//        }
//        else
//           return[true, ""];
//      }

// for (var i = count; i < groupScheduleDay.length; i++) {
//        var availday = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
      var availday = "";
       var day = parseInt(date.getDate())-10;
       var month = (parseInt(date.getMonth())+1) -10;
          
       if( day < 0 && month < 0)
          availday = date.getFullYear() + "-0" + (date.getMonth() + 1) + "-0" + date.getDate();
       else if( day < 0 )
          availday = date.getFullYear() + "-" + (date.getMonth() + 1) + "-0" + date.getDate();
       else if( month < 0 )
          availday = date.getFullYear() + "-0" + (date.getMonth() + 1) + "-" + date.getDate();
       else
          availday = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
       console.log("kk" + groupScheduleDay[count][0]);
       var temp = groupScheduleDay[count][0]+"-"+groupScheduleDay[count][1]+"-"+groupScheduleDay[count][2];
//        alert(groupScheduleDay[count][0]+"-"+groupScheduleDay[count][1]+"-"+groupScheduleDay[count][2]);
       
       
//        var priorCount = 0;
//        var flag = false;
//        if( count > 0 )
//           priorCount = count-1;
//        alert(priorCount);
//        var priorTemp = groupScheduleDay[priorCount][0]+"-"+groupScheduleDay[priorCount][1]+"-"+groupScheduleDay[priorCount][2];
//        alert(i);
//        alert(availday+ "== " + temp);
//       alert(priorCount + " " + priorTemp + " \\\\ " + count + " " + temp);
//       if( priorTemp == temp && count != 0 ){
//          flag=true;
//          count++;
//       }
       if(availday == temp){
          var temp2 = groupScheduleDay[count][3] + '_day';
          count++;
          console.log("if : " + temp2);
          return [true , temp2, ""];
       }
       else{
          console.log("else");
          return [true, "", ""];
       }
   } else{
      console.log("잘못됨")   ;
      return [true, "", ""];
   }
}
</script>