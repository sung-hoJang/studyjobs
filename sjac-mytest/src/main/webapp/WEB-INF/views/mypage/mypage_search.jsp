<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
$(document).ready(function(){
	$("#category").change(function(){
		if($("#category").val() == ""){
		}else{
			$.ajax({
				type:"get",
				url:"mypage_subject_category.do",
				data:"category="+$(this).val(),
				success:function(list){
					var comp="";
					$.each( list, function(index, data){
						comp += "<option value='"+data.subject+"'>" + data.subject + "</option>";
					} )
				}
			})
		}
	});
});
</script>
	<div class="row">
		 <div class="col-md-4  cat-search-input">
			 <select class="form-control" id="category">
				<option value="">전체</option>
				<option value="영어">영어</option>
				<option value="프로그래밍">프로그래밍</option>
				<option value="취업">취업</option>
				<option value="금융">금융</option>
			</select>
		</div>
		<div class="col-md-4  cat-search-input">
			<div id="optionList"></div>
		</div>
		<div class="col-md-4 text-right  cat-search-input">
			<div class="view-type">
				<a href="mypage_grouplist.do" data-toggle="tooltip"
			data-placement="top" title="List"><i class="fa fa-th-list"></i></a> 
			<a href="mypage_grouplist_grid.do" data-toggle="tooltip"
			data-placement="top" title="Grid"><i class="fa fa-th"></i></a>
			</div>
		</div>
	</div>