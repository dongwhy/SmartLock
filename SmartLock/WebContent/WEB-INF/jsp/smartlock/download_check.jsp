<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="include/_header.jsp">
	<jsp:param name="_nav" value="download" />
</jsp:include>

<!-- Page Content -->
<div class="container">

	<!-- Page Heading/Breadcrumbs -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header" align="center">다운로드 하시겠습니까?</h1>
		</div>
	</div>

	<br>

	<div class="col-md-12 text-center">

						<img class="img-responsive"
			style="margin-left: auto; margin-right: auto; display: block;"
			width="100px" src="/html/img/Microsoft_Excel.png" alt="">
						<h3>Microsoft Excel</h3>
				   <br>
						<div><a class="btn btn-lg btn-default btn-block"
			style="margin-right:10px; display: inline-block;width: 100px; "
			href="/html/img/Microsoft_Excel.png" download>다운로드</a>
			<a class="btn btn-lg btn-default btn-block"
			style="margin-left: auto; margin-right: auto; display: inline-block;width: 100px; "
			href="download.jsp">취소</a></div>
			</div>

	<div class="col-md-12">
		<br> <br>
		<hr>
	</div>

	<!-- Footer -->
	<jsp:include page="include/_footer_content.jsp" />

</div>
<!-- /.container -->

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />
