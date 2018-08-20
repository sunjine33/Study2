<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp" %>

	

	<form role="form" action="/board/modify" method="post">
	 <input type="hidden" name='bno' value="${boardVO.bno}" />
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputemail1">제목</label>
				 <input type="text" value="${boardVO.title}"
					name='title' class="form-control" placeholder="Enter Title">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">내용</label>
				<textarea class="form-control" name="content" rows="3"
					placeholde="Enter ...">${boardVO.title}</textarea>
			</div>
			
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
	
<%@include file="../include/footer.jsp" %>
