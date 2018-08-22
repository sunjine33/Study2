<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page session="false"%>




<%@include file="../include/header.jsp"%>

<c:choose>
	<c:when test="${msg eq 'success'}">
		<h1 class="text-center">등록이 완료되었습니다.</h1>
	</c:when>

	<c:when test="${msg eq 'remove-ok'}">
		<h1 class="text-center">삭제가 완료되었습니다.</h1>
	</c:when>
</c:choose>



<table class="table table-bordered text-center">
	<tr>
		<th style="width: 10px">BNO</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일시</th>
		<th style="width: 100px">조회수</th>
	</tr>

	<c:forEach items="${listAll}" var="board">
		<tr>
			<td>${board.bno}</td>
			<td><a href='/board/read?bno=${board.bno}'>${board.title }</a></td>
			<td>${board.writer }</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm"
					value="${board.regdate }" /></td>
			<td><span class="badge bg-red">${board.viewcnt }</span></td>
		</tr>
	</c:forEach>

</table>

	<div class="text-center">
		<nav aria-label="loabel_pagination">
			<ul class="pagination">
			
				<li class="disabled">
					<a href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
					<li class="active">
						<a href="#">1 
							<span class="sr-only">(current)
							</span>
						</a>
					</li>
				<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
			</ul>
		</nav>
	</div>


<a href="/board/register">
	<button class="btn btn-primary">Submit</button>
</a>


<%@include file="../include/footer.jsp"%>
