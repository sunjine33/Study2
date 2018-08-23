<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

	<script>
		var result = '${msg}';
		
		if(result == 'save-ok'){
			alert("업데이트가 완료되었습니다.");
		
		}
	</script>

<session class="content">
<div class="box-body">
	<div class="form-group">
		<label for="title">제목</label> <span>${ boardVO.title }</span>
	</div>

	<div class="form-group">
		<label for="wirter">작성자</label> <span>${ boardVO.writer }</span>
	</div>

	<div class="form-group">
		<label for="content">내용</label> <span>${ boardVO.content }</span>
	</div>

	<div class="form-group">
		<label for="viewcnt">조회수</label> <span>${ boardVO.viewcnt }</span>
	</div>

	<div class="form-group">
		<label for="regDate">작성일자</label> <span>${ boardVO.regdate }</span>
	</div>
</div>

<div class="box-footer text-center">
	<button id="btn-remove" class="btn btn-danger">삭제</button> 
	<a href="/board/modify${criteria.makeQuery()}&bno=${boardVO.bno}" class="btn btn-primary">수정</a>
	<a href="/board/listPage${criteria.makeQuery()}" class="btn btn-default">목록</a>
</div>
</session>

	<script>
		$(document).ready(function(){
			$('#btn-remove').on('click', function(){
				if(confirm("정말 삭제하시겠습니까?")){
					self.location.href= "/board/remove${criteria.makeQuery()}&bno=${boardVO.bno}";
				}
			});
		});
	</script>

<%@include file="../include/footer.jsp"%>