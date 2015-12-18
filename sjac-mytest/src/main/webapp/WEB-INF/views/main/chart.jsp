<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type="text/javascript">
FusionCharts.ready(function () {
    var ageGroupChart = new FusionCharts({
        type: 'pie3d',
        renderAt: 'chart-container',
        width: '100%',
        height: '400',
        dataFormat: 'json',
        dataSource: {
            "chart": {
                "paletteColors": "#0075c2,#1aaf5d,#f2c500,#f45b00,#8e0000",
                "bgColor": "#ffffff",
                "showBorder": "0",
                "use3DLighting": "0",
                "showShadow": "0",
                "enableSmartLabels": "0",
                "startingAngle": "0",
                "showPercentValues": "1",
                "showPercentInTooltip": "0",
                "decimals": "1",
                "captionFontSize": "14",
                "subcaptionFontSize": "14",
                "subcaptionFontBold": "0",
                "toolTipColor": "#ffffff",
                "toolTipBorderThickness": "0",
                "toolTipBgColor": "#000000",
                "toolTipBgAlpha": "80",
                "toolTipBorderRadius": "2",
                "toolTipPadding": "5",
                "showHoverEffect":"1",
                "showLegend": "1",
                "legendBgColor": "#ffffff",
                "legendBorderAlpha": '0',
                "legendShadow": '0',
                "legendItemFontSize": '10',
                "legendItemFontColor": '#666666'
            },
            "data": [
                {
                   "label": "${requestScope.map.cartReportList[0].gleaderId}",
                   "value": "${requestScope.map.cartReportList[0].count}"   
                },
                {
                   "label": "${requestScope.map.cartReportList[1].gleaderId}",
                   "value": "${requestScope.map.cartReportList[1].count}"   
                },
                
                {
                   "label": "${requestScope.map.cartReportList[2].gleaderId}",
                   "value": "${requestScope.map.cartReportList[2].count}"   
                },
                
                {
                   "label": "${requestScope.map.cartReportList[3].gleaderId}",
                   "value": "${requestScope.map.cartReportList[3].count}"   
                },
                
                {
                   "label": "${requestScope.map.cartReportList[4].gleaderId}",
                   "value": "${requestScope.map.cartReportList[4].count}"   
                }
              
            ]
        }
    }).render();
});
</script>

<script>
function popup(id){
	var check = "${sessionScope.mvo}";
	if(check == ""){
		alert("로그인이 필요한 서비스입니다.");
		return false;
	}
   window.open("checkMyGroup.do?gLeaderId="+id, "popup",  "width=1000, height=700, left=200");
}
</script>

<div class="widget">
   <div class="widget-header">
      <h3>찜한 그룹 순위</h3>
   </div>
   <br>
   <div class="widget-body">
      <c:forEach items="${requestScope.map.cartReportList }" begin="0" end="4"  var="crvo" varStatus="status">
          <div class="input-group">
            <span class="input-group-addon addon-login"><label>${status.count}위 <a href=""  onclick="popup('${crvo.gleaderId }')">${crvo.gleaderId }</a></label></span>
         </div>
      </c:forEach>
   </div>
   
   <div class="widget-body">
      <div id="chart-container"></div>
   </div>
</div>

