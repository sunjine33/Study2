<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<form role="form" method="post">
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputemail1">제목</label> <input type="text"
				name='title' class="form-control" placeholder="Enter Title">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">본문</label>
			<textarea class="form-control" name="content" rows="3"
				placeholde="Enter ..."></textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">작성자</label> <input type="text"
				name="writer" class="form-control" placeholder="Enter writer">
			</textarea>
		</div>
	</div>

	<div class="box-footer">
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
</form>



<%@include file="../include/footer.jsp"%>
