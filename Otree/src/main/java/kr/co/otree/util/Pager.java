package kr.co.otree.util;

import java.net.URLEncoder;

public class Pager {
	int page = 1;
	int perPage = 10;
	float total = 0;
	int start;
	String searchMode;
	String search;
	String keyword = "";
	
	public String getPagination() {
		String html;
		int maxPage = 1;
		int startPage =1;
		int endPage = maxPage;
		
		String searchSQL = "";
		
		keyword = URLEncoder.encode(keyword);
		
		if(searchMode != null && keyword != null)
			searchSQL = "searchMode=" + searchMode + "&keyword=" + keyword + "&";		
		
		String link = "<li class='page_off'><a href='?" + searchSQL + "page=";
		
		maxPage = (int) Math.ceil(total / perPage);
		
		startPage = ((page - 1) / 5) * 5 + 1;
		
		endPage = startPage + 4 > maxPage ? maxPage : startPage + 4;
		
		html = "<ul class='pager'>";
		
		html += link + "1'>처음</a></li>";
		html += link + (page <= 1 ? 1 : page - 1) + "'>이전</a></li>";
		//삼항연산자 : page <= 1 가 참이면 1 아니면 page - 1 이 됨
		for(int i = startPage; i <= endPage; i++) {
			html += "<li class='" + (i == page ? "page_on" : "page_off") + "'><a href='?" + searchSQL + "page=" + i + "'>" + i + "</a></li>";
		}
		html += link + (page >= maxPage ? maxPage : page + 1) + "'>다음</a></li>";
		html += link + maxPage + "'>끝</a></li>";
		
		html += "</ul>";
		
		return html;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page < 1)
			this.page = 1;
		else
			this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	

	public int getStart() {
		return (page -1) * perPage;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearchMode() {
		return searchMode;
	}

	public void setSearchMode(String searchMode) {
		this.searchMode = searchMode;
	}

}
