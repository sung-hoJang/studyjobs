<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 푸터 바로 위 시작 -->
            <div class="counter">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="item-counter">
                                <span class="item-icon"><i class="fa fa-line-chart"></i></span>
                                <div data-refresh-interval="100" data-speed="2000" data-to="${requestScope.map.totalVisitor }" data-from="0" class="item-count">${requestScope.map.totalVisitor }</div>
                                <span class="item-info">방문자수</span>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="item-counter">
                                <span class="item-icon"><i class="fa fa-search"></i></span>
                                <div data-refresh-interval="50" data-speed="1000" data-to="${requestScope.map.allSearchCount }" data-from="0" class="item-count">${requestScope.map.allSearchCount }</div>
                                <span class="item-info">검색 횟수</span>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="item-counter">
                                <span class="item-icon"><i class="fa fa-users"></i></span>
                                <div data-refresh-interval="80" data-speed="2000" data-to="${requestScope.map.allGroupCount}" data-from="0" class="item-count">${requestScope.map.allGroupCount}</div>
                                <span class="item-info">그룹 수</span>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="item-counter">
                                <span class="item-icon"><i class="fa fa-male"></i><i class="fa fa-female"></i></span>
                                <div data-refresh-interval="80" data-speed="3000" data-to="${requestScope.map.allMemberCount}" data-from="0" class="item-count">${requestScope.map.allMemberCount}</div>
                                <span class="item-info">회원 수</span>
                            </div>
                        </div>
                    </div>
                </div>
      </div>
      <!-- 푸터 바로 위 끝 -->