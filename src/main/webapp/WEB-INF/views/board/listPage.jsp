<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page session="false"%>




<%@include file="../include/header.jsp"%>
<section id = "section">
<c:choose>
	<c:when test="${msg eq 'success'}">
		<h1 class="text-center">등록이 완료되었습니다.</h1>
	</c:when>
	<c:when test="${msg eq 'remove-ok'}">
		<h1 class="text-center">삭제가 완료되었습니다.</h1>
	</c:when>
</c:choose>
<div class="content" >
	<div class="row">
		<div class="col-md-8 text-left">
			<div class="form-inline">
			<select id="searchType">
				<option value="">검색조건이 없음</option>
				<option value="t">제목으로 검색</option>
				<option value="c">내용으로 검색</option>
				<option value="w">작성자로 검색</option>
				<option value="tc">제목이나 내용으로 검색</option>
				<option value="a">전체</option>
			</select>
				<input type="text" id="keyword" name="keyword"
					value="${pageMaker.criteria.keyword}" placeholder="검색어를 입력하세요."
					class="form-control" />
				<button id="searchBtn" class="btn btn-primary">Search</button>
			</div>
		</div>
		<div class="col-md-4 text-right">
			<select id="perPageSel">
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="50">50</option>
			</select> <a href="/board/register" class="btn btn-primary">글쓰기</a>
		</div>
	</div>
</div>
<table class="table table-bordered text-center">
	<tr>
		<th style="width: 10px">BNO</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일시</th>
		<th style="width: 100px">조회수</th>
	</tr>
	<c:forEach items="${listPage}" var="board">
		<tr>
			<td>${board.bno}</td>
			<td><a
				href="/board/read${pageMaker.makeQuery(pageMaker.criteria.page)}&bno=${board.bno}">${board.title}</a></td>
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

			<li id="page-prev"><a href="listpage${ pageMaker.startPage}"
				onclick="gogo(${pageMaker.startPage - 1})" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
			</a></li>


			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<li id="page${idx}"><a
					href="listPage${pageMaker.makeQuery(idx)}" onclick="gogo(${idx})">${idx}
						<span class="sr-only">(current) </span>
				</a></li>
			</c:forEach>


			<li id="page-next"><a href="listpage${ pageMaker.endPage }"
				onclick="gogo(${pageMaker.endPage + 1})" aria-label="next"> <span
					aria-hidden="true">&raquo;</span>
			</a></li>

		</ul>
	</nav>
</div>
</section>
<script>
	
function setSelect(){
	var perPageNum = "${pageMaker.criteria.perPageNum}";

	var $perPageSel = $("#perPageSel");
	$perPageSel.val(perPageNum).prop("selected", true);
	
	var thisPage = "${pageMaker.criteria.page}";
	$perPageSel.on('change', function() {
		gogo(thisPage, $perPageSel.val());
	});
}

function gogo(page, perPageNum){
	perPageNum = perPageNum || $("#perPageSel").val();
	window.location.href = "listPage?page=" + page + "&perPageNum=" + $perPageNum;
}

	
	$(document).ready(function(){
		setSelect();
		
		var canPrev = '${pageMaker.prev}';
		if(canPrev !== 'true'){
			$('#page-prev').addClass('disabled');
		}
		
		var canPrev = '${pageMaker.next}';
		if(canPrev !== 'true'){
			$('#page-next').addClass('disabled');
		}
		
		var thisPage = '${pageMaker.criteria.page}';
		$('#page' + thisPage).addClass('active');
		
		
		$('#searchBtn').on('click',function(event){
			event.preventDefault();
				var $searchType = $("#searchType");
				var $keyWord = $("#keyword");
				
				var keyWordStr = $keyWord.val();
				var searchTypeStr = $searchType.val();
				if(!searchTypeStr){
					alert("검색조건을 선택하세요.");
					$searchType.focus();
					return;
				}else if(!keyWordStr){
					alert("검색어를 입력하세요.");
					$keyWord.focus();
					return;
				}
				
				var url = "listPage${pageMaker.makeQuery(1,false)}"
				+"&searchType=" + searchTypeStr
				+"&keyword=" + encodeURIComponent(keyWordStr);
				console.log(">>search.url=",url)
				window.location.href=url;
		});
	});	
</script>


<%@include file="../include/footer.jsp"%>
