<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${initParam.root}jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#showAnnounce").click(function() {
					$("#announceTable").toggle("slow", function() {
						if ($(this).css('display') == 'none') {
							$("#showAnnounce").val("공지글보이기");
						} else {
							$("#showAnnounce").val("공지글감추기");
						}
					});
				});

				$.ajax({
					type : "get",
					url : "existMyGroup.do",
					data : "gLeaderId=${sessionScope.mvo.id}",
					success : function(data) {
						if (data == "nothing") {
							flag = "false";
							return false;
						} else {
							flag = "true";
						}
					}
				});

				//auth_board_list.do
				$("#searchForm").submit(
						function(event) {
							var keyText = $("input:text[name=keywordBlank]")
									.val();
							$(location).attr(
									"href",
									"auth_board_findBoardListByTitleAndContent.do?keyText="
											+ keyText);
							event.preventDefault();//페이지 초기화 방지
						});//자유 게시판 검색 

			});
</script>
<style>
.myButton {
	-moz-box-shadow: inset 0px 1px 3px 0px #3dc21b;
	-webkit-box-shadow: inset 0px 1px 3px 0px #3dc21b;
	box-shadow: inset 0px 1px 3px 0px #3dc21b;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #46a860
		), color-stop(1, #5cbf2a));
	background: -moz-linear-gradient(top, #46a860 5%, #5cbf2a 100%);
	background: -webkit-linear-gradient(top, #46a860 5%, #5cbf2a 100%);
	background: -o-linear-gradient(top, #46a860 5%, #5cbf2a 100%);
	background: -ms-linear-gradient(top, #46a860 5%, #5cbf2a 100%);
	background: linear-gradient(to bottom, #46a860 5%, #5cbf2a 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#46a860',
		endColorstr='#5cbf2a', GradientType=0);
	background-color: #46a860;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	border: 1px solid #18ab29;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 13px;
	font-weight: bold;
	padding: 6px 14px;
	text-decoration: none;
	text-shadow: 0px -1px 0px #2f6627;
}

.myButton:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #5cbf2a
		), color-stop(1, #46a860));
	background: -moz-linear-gradient(top, #5cbf2a 5%, #46a860 100%);
	background: -webkit-linear-gradient(top, #5cbf2a 5%, #46a860 100%);
	background: -o-linear-gradient(top, #5cbf2a 5%, #46a860 100%);
	background: -ms-linear-gradient(top, #5cbf2a 5%, #46a860 100%);
	background: linear-gradient(to bottom, #5cbf2a 5%, #46a860 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#5cbf2a',
		endColorstr='#46a860', GradientType=0);
	background-color: #5cbf2a;
}

.myButton:active {
	position: relative;
	top: 1px;
}
</style>



<div class="panel panel-default">
	<div class="panel-heading">
	</div>
	<div class="panel-body">
		<div class="before-table">
			<div class="row">
				&nbsp; <input type="button" class="myButton" id="showAnnounce"
					value="공지글감추기">
			</div>
		</div>
		<table class="table table-bordered" style="text-align: center;">
			<thead>
				<tr bgcolor="#58b325" style="font-weight: bold;">
					<td class="no" style="width: 10%">NO</td>
					<td class="category" style="width: 15%">카테고리</td>
					<td class="title" style="width: 40%">제목</td>
					<td class="id" style="width: 15%">아이디</td>
					<td class="myDate" style="width: 15%">작성일</td>
					<td class="hits" style="width: 10%">HIT</td>
				</tr>
			</thead>
			<tbody id="announceTable">
				<c:forEach var="bvo"
					items="${requestScope.map['announcementList'] }">
					<tr bgcolor="#EAEAEA" style="font-weight: bold;">
						<td>${bvo.no }</td>
						<td>${bvo.category }</td>
						<%-- bvo에 relevel이 0이 아니면 답변글이므로 relevel만큼 공백으로 제목을 밀어준다  --%>
						<td class="titleView"><c:if test="${bvo.parent==0}">
								<div class="deletedParent">[원글이 삭제된 답글]</div>
							</c:if> <c:if test="${bvo.relevel!=0}">
								<c:forEach begin="0" end="${bvo.relevel}" step="1">&nbsp;&nbsp;</c:forEach>
								<img src="${initParam.root }/boardtool/img/reply.jpg">
							</c:if> <a
							href="${initParam.root}/auth_board_show_content.do?no=${bvo.no }">${bvo.title}</a>
						</td>
						<td>${bvo.memberVO.id }</td>
						<td>${bvo.myDate }</td>
						<td>${bvo.hits }</td>
					</tr>
				</c:forEach>
			</tbody>
			<c:forEach var="bvo" items="${requestScope.map['lvo'].list}">
				<tr>
					<td>${bvo.no }</td>
					<td>${bvo.category }</td>
					<%-- bvo에 relevel이 0이 아니면 답변글이므로 relevel만큼 공백으로 제목을 밀어준다  --%>
					<td class="titleView"><c:if test="${bvo.parent==0}">
							<div class="deletedParent">[원글이 삭제된 답글]</div>
						</c:if> <c:if test="${bvo.relevel!=0}">
							<c:forEach begin="0" end="${bvo.relevel}" step="1">&nbsp;&nbsp;</c:forEach>
							<img src="${initParam.root }/boardtool/img/reply.jpg">
						</c:if> <a
						href="${initParam.root}/auth_board_show_content.do?no=${bvo.no }">${bvo.title}</a>
					</td>
					<td>${bvo.memberVO.id }</td>
					<td>${bvo.myDate }</td>
					<td>${bvo.hits }</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="${initParam.root}auth_board_show_write.do"><img
			id="writeImg" src="${initParam.root }boardtool/img/write_btn.jpg"
			border="0"></a> <br>
		<br>

		<form class="form-inline pull-right" id="searchForm">
			<div class="form-group">
				<div class="input-group">
					<input type="text" name="keywordBlank"
						placeholder="Type keyword ..." class="form-control2">
					<div class="input-group-addon">
						<button type="submit" class="myButton">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</div>
		</form>

		<div class="row">
			<div class="col-md-12 text-right">
				<ul class="pagination">
					<c:if
						test="${requestScope.map['lvo'].pagingBean.previousPageGroup}">
						<c:choose>
							<c:when test="${requestScope.map['hidden']=='find'}">
								<li><a
									href="auth_board_findBoardListByTitleAndContent.do?pageNo=${requestScope.map['lvo'].pagingBean. startPageOfPageGroup-1}&keyText=${requestScope.map['keyText']}">◀</a></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="auth_board_list.do?pageNo=${requestScope.map['lvo'].pagingBean. startPageOfPageGroup-1}">◀</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
					<c:forEach var="i"
						begin="${requestScope.map['lvo'].pagingBean.startPageOfPageGroup}"
						end="${requestScope.map['lvo'].pagingBean.endPageOfPageGroup}">
						<c:choose>
							<c:when test="${requestScope.map['lvo'].pagingBean.nowPage!=i}">
								<c:choose>
									<c:when test="${requestScope.map['hidden']=='find'}">
										<li><a
											href="auth_board_findBoardListByTitleAndContent.do?pageNo=${i}&keyText=${requestScope.map['keyText']}">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="auth_board_list.do?pageNo=${i}">${i}</a></li>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<li class="active"><a href="">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${requestScope.map['lvo'].pagingBean.nextPageGroup}">
						<c:choose>
							<c:when test="${requestScope.map['hidden']=='find'}">
								<li><a href="auth_board_findBoardListByTitleAndContent.do?pageNo=${requestScope.map['lvo'].pagingBean.endPageOfPageGroup+1}&keyText=${requestScope.map['keyText']}">
							</c:when>
							<c:otherwise>
								<li><a href="auth_board_list.do?pageNo=${requestScope.map['lvo'].pagingBean.endPageOfPageGroup+1}">
							</c:otherwise>
						</c:choose>
                                        ▶
                               </a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>

	</div>
</div>
