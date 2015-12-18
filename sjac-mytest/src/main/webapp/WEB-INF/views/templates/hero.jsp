<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
   
   $("#findGroupForm").submit(function(event){
   var keyType=$("select[name=keyType]").val();
    var keyText=$("input:text[name=keyText]").val();
    
    if(keyType=="groupNameAndInfo"){// 그룹명 이름과 정보로 검색
       $(location).attr("href","findGroupByGNameAndGInfo.do?keyText="+keyText);
       
    }// 그룹장 이름과 정보로 검색
      event.preventDefault();//페이지 초기화 방지
   });//서브밋 
});//레뒤

</script>    
            <!-- 히어로 부 시작(메인 위 사진부분) -->
            <section class="hero">
                <div class="container text-center">
                    <h2 class="hero-title">Find an Awesome Study Group Here</h2>
                    <p class="hero-description hidden-xs">Find all Member you need for getting a job. We give you a simple way.</p>
                    <div class="row hero-search-box">
                        <form id="findGroupForm" >
                            <div class="col-md-4 col-sm-4 search-input">
                                <select name="keyType" class="form-control" style="height: 34px;">
                                            <option  value="groupNameAndInfo">그룹명+그룹정보</option>
                                </select>
                            </div>
                            <div class="col-md-4 col-sm-4 search-input">
                                  <input type="text" name="keyText" class="form-control"  style="height: 34px;" placeholder="검색어를 입력하세요">
                            </div>
                            
                            <div class="col-md-4 col-sm-4 search-input">
                                <button type="submit" class="btn btn-custom btn-block" style="height: 34px;"><i class="fa fa-search"></i></button>
                            </div>
                        </form>
                    </div>
                </div>
            </section>