<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Login | Smart Lock</title>
	
	<link href="/html/css/bootstrap.min.css" rel="stylesheet">
	<link href="/html/css/modern-business.css" rel="stylesheet">
	<link href="/html/font-awesome/css/font-awesome.min.css" rel="stylesheet"	type="text/css">
	<link href="/html/css/login.css" rel="stylesheet">
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="main.html">Smart Lock</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="Main.html">Home</a></li>
					<li><a href="About_us.html">About Us</a></li>
					<li><a href="Software.html">Software</a></li>
                    <li><a href="Download.html">Download</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="Log_in.html">로그인</a></li>
					<li class="divider-vertical"></li>
					<li><a href="Sign_up_select.html">회원가입</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
 
	<div class="container">
	    <div class="card card-container">
	        <img id="logo-img" class="logo-img" src="/html/img/login.png" />
	        <form class="form-signin">
	            <input type="text" id="id" class="form-control" placeholder="아이디" required autofocus>
	            <input type="password" id="pwd" class="form-control" placeholder="비밀번호" required>
	            <button id="login-btn" class="btn btn-lg btn-primary btn-block btn-signin">로그인</button>
	        </form><!-- /form -->
	        <div class="login-help">
				<p>비밀번호를 잊으셨나요? <a href="Search_pw.html">여기를 클릭하세요</a></p>
				<p>아직 회원이 아니신가요? <a href="/signup">지금 가입하세요</a></p>
			</div>
	    </div>
	</div>

	<!-- Footer -->
	<footer class="text-center">
		<div class="row">
			<div class="col-lg-12">
				<p>
					서울특별시 서초구 양재대로2길 90, 아세아타워 TEL : 02-971-0321 FAX : 02-527-0321 <br>
					사업자등록번호 : 220-88-03210 캐드서브(주) 대표이사 : 김형준 <br> Copyright ⓒ
					Cadserv co., LTD.all rights reserved.
				</p>
			</div>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="/html/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/html/js/bootstrap.min.js"></script>
	<script src="/html/js/member.js"></script>

</body>

</html>
