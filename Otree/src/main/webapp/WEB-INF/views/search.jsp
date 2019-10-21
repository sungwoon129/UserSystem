<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<title>Otree_회원정보</title>
	<link rel="stylesheet" href="/resources/css/default.css" >
	<link rel="stylesheet" href="/resources/css/search.css">
	
</head>
<body>
<div id="wrapper">
	<header>Otree_회원정보</header>

	<nav>
		<ul>
			<li><a href="/">회원 가입</a></li>
			<li class="on_menu"><a href="/search/list">회원 검색</a></li>
		</ul>
	</nav>
	<section>
		<h2>회원 정보</h2>
		<form method="get">
			<div class="search_box">
				<label for="searchMode">검색 :</label>
				<select name="searchMode" id="searchMode">
					<option value="1">이름</option>
					<option value="2">생년월일</option>
					<option value="3">이메일</option>
					<option value="4">주소</option>
					<option value="5">성별</option>
					<option value="6">핸드폰</option>
				</select>
				<input type="text" name="keyword" value="">
				<input type="submit" value="검색">
				
			</div>
		</form>
		<table class="memeber_list">
			<thead>
				<tr>
					<th>이름</th>
					<th>생년월일</th>
					<th>email</th>
					<th>주소</th>
					<th>성별</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${list.size() > 0 }">
						<c:forEach items="${list}" var="item">
							<tr>
								<td>${item.name}</td>
								<td>${item.birth}</td>
								<td>${item.email}</td>
								<td>${item.address}</td>
								<td>${item.gender}</td>
								<td>${item.phone}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td>가입한 회원이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<div class="pagenation">${pager.pagination}</div>
	</section>

</div>

<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="/resources/js/searchMember.js"></script>
</body>
</html>