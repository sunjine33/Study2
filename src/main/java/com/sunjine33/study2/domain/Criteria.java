package com.sunjine33.study2.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class Criteria {
	private int page;
	private int perPageNum;
	private String searchType;
	private String keyword;

	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
		}
		this.page = page;
	}

	public int getPageStart() {
		return (this.page - 1) * this.perPageNum;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
		} else
			this.perPageNum = perPageNum;
	}

	
	
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String makeQuery() {
		return UriComponentsBuilder.newInstance()
				.queryParam("page", this.page)
				.queryParam("perPageNum", this.getPerPageNum())
				.queryParam("searchType", this.searchType)
				.queryParam("keyword", this.keyword)
				.build().encode().toString();
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", searchType=" + searchType + ", keyword="
				+ keyword + "]";
	}

}
