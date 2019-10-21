<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Otree_회원가입</title>
	<link rel="stylesheet" href="/resources/css/default.css" >
	<link rel="stylesheet" href="/resources/css/index.css" >
</head>
<body>
<div id="wrapper">
	<header>Otree_회원정보</header>
	<nav>
		<ul>
			<li class="on_menu"><a href="/">회원 가입</a></li>
			<li><a href="/search/list">회원 검색</a></li>
		</ul>
	</nav>
	<section>
		<article>
			<h2>회원 가입</h2>
			<form action="signUp" method="post" name="registForm">
				<div class="item"><label for="name">이름 : </label><input type="text" id="name" name="name" data-code="이름"><div class="alert"></div></div>
				<div class="item"><label for="birth">생년월일 : </label><input type="text" id="birth" name="birth" data-code="생년월일"><div class="alert"></div></div>
				<div class="item"><label for="email">이메일 : </label><input type="text" id="email" name="email" data-code="이메일"><div class="alert"></div></div>
				<div class="item"><label for="address">주소 : </label><input type="text" id="address" name="address" data-code="주소"><div class="alert"></div></div>
				<div class="item">
					<label for="gender" data="성별">성별 : </label>
					<select name="gender">
						<option value="남자" >남자</option>
						<option value="여자">여자</option>
					</select>
					<div class="alert"></div>
				</div>	
				<div class="item"><label for="phone">핸드폰 : </label><input type="text" id="phone" name="phone" data-code="핸드폰"><div class="alert"></div></div>
	
			</form>
			<button type="button" id="regist_btn")>회원 가입</button>
		</article>
	</section>
</div>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="/resources/js/signUp.js"></script>
</body>
</html>