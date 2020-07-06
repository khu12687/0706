<%@page import="com.pub.model.notice.Notice"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Notice notice = (Notice)request.getAttribute("notice");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록 폼</title>
<style >
div{
margin:auto;
}
div{
	width:500px;
	height:500px;
	border:2px solid blue;
	text-align:center;
}
div input, textarea{
	width:98%;
}
textarea{
	height:350px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	//등록버튼 누르면..
	$("#bt_list").click(function(){
		//history.back(); //이전 페이지로가기 
		//케시를 보여주는 거라서, 누군가가 글을 썻을때 갱신된 내용을 볼수 없다
		
		//새롭게 서버에게 요청을 시도하는 것임
		$(location).attr("href","/notice/list");
	});
	
	$("#bt_del").click(function() {
		if(confirm("삭제하시겠습니가?")){
			del();	
		}
	});
	
	$("#bt_edit").click(function() {
			if(confirm("수정하시겠습니가?")){
				edit();	
			}
		});
});

function del(){
	//alert("삭제요청 시도!!");
	location.href="/notice/delete?notice_id=<%=notice.getNotice_id()%>";
}

function edit(){
	//수정을 담당하는 서블릿에게 요청!!
	$("form").attr("method","post"); //양이 많아서
	$("form").attr("action","/notice/edit"); //양이 많아서
	$("form").submit();
}
</script>

</head>
<body bgcolor="yellow">
	<div>
		<form>
			<input type ="hidden" name="notice_id" value="<%=notice.getNotice_id() %>"/>
			<input type ="text" name="title" value="<%=notice.getTitle() %>"/>
			<input type ="text" name="writer" value="<%=notice.getWriter() %>"/>
			<textarea name ="content" ><%=notice.getContent() %> </textarea>
		</form>
		<button id="bt_list">리스트</button>
		<button id="bt_edit">수정</button>
		<button id="bt_del">삭제</button>
	</div>
</body>
</html>
