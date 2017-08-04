<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="private/_header.jsp">
	<jsp:param name="_nav" value="" />
</jsp:include>

<!-- Page Content -->
<div class="container">

	<!-- Page Heading/Breadcrumbs -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header" align="center">아직 회원이 아니신가요?</h1>
		</div>
	</div>

	<br>

	<div class="col-lg-2"></div>
	<div class="col-lg-4" align="center">

			<button type="button" class="btn btn-default btn-circle btn-xl"
				onclick="location.href='sign_up_user.jsp' ">
				<img class="img-responsive"
					style="margin-left: auto; margin-right: auto; display: block;"
					width="100px" src=".\img\user.png" alt="">
				<h2>개인회원</h2>
				<h4>일반 소비자 회원가입</h4>
			</button>
	</div>

	<div class="col-lg-4" align="center">
			<button type="button" class="btn btn-default btn-circle btn-xl"
				onclick="location.href='sign_up_manager.jsp'">
				<img class="img-responsive"
					style="margin-left: auto; margin-right: auto; display: block;"
					width="100px" src=".\img\building.png" alt="">
				<h2>기업회원</h2>
				<h4>사업자 회원가입</h4>
			</button>
	</div>
	<div class="col-lg-2"></div>

	<div class="col-md-12">
		<br> <br>
		<hr>
	</div>

	<!-- Footer -->
	<jsp:include page="private/_footer_content.jsp" />

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<jsp:include page="private/_footer.jsp" />
