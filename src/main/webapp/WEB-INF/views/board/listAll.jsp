<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="false" %>


<%@include file="../include/header.jsp"%>



<table class="table table-bordered">
	<tr>
		<th style="width: 10px">BNO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th style="width: 40px">VIEWCNT</th>
	</tr>
	
	<c:forEach items="${listAll}" var="board">
	<tr>
		<td>${board.bno}</td>
		<td><a href='/board/read?bno=${board.bno}'>${board.title }</a></td>
		<td>${board.writer }</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${board.regdate }" /></td>
		<td><span class="badge bg-red">${board.viewcnt }</span></td>
	</tr>
	</c:forEach>
</table>
	<a href="/board/register">
	<button class="btn btn-primary">Submit</button>
	</a>
<script>
		var result = '${msg}';
		
		if(result == 'success'){
			alert("처리가 완료되었습니다.");
		}
		
</script>

<%@include file="../include/footer.jsp"%>
