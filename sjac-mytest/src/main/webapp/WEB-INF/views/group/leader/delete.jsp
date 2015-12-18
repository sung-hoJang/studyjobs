<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
      alert("그룹이 삭제되었습니다. 메인화면으로 돌아갑니다~")
      window.opener.location.reload(true);
      window.close();
   });
</script>