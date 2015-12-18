<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="widget">
	<div class="widget-header">
		<h3>My Page</h3>
	</div>
	<div class="widget-body">
		<ul class="author-menus">
			<li><a href="auth_mypage_grouplist.do">◈ 내가 가입한 그룹</a></li>
			<li><a href="auth_mypage_join_grouplist.do">◈ 가입 요청한 그룹</a></li>
			<li><a href="" onclick="myGroupPopup('${sessionScope.mvo.id}')">◈ 내가 만든 그룹</a></li>
			<li><a href="auth_mypage_schedule.do">◈ 내 스케줄</a></li>
			<li><a href="auth_mypage_info.do">◈ 내 정보</a></li>
			<li><a href="auth_mypage_cart.do">◈ 내 찜 목록</a></li>
		</ul>
	</div>
</div>