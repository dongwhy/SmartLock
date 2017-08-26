<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="smartlock.license.vo.LicenseManagerVO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:bundle basename="resources/properties/softwareInfo">
<jsp:include page="include/_header.jsp">
	<jsp:param name="_nav" value="softwareUser" />
</jsp:include>

<!-- Header Carousel -->
<div class="container">

	<!-- Page Heading/Breadcrumbs -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				Softwares <small>소프트웨어 라이센스 요청</small>
			</h1>
		</div>
	</div>
	<!-- /.row -->

	<!-- Projects Row -->
	<c:forEach var="software" items="${softwareList}" varStatus="count">
	
	<div class="col-md-3 img-portfolio">
		<div align="center"><span class="fa-stack fa-5x">
                              <i class="fa fa-circle fa-stack-2x"></i>
                        </span></div>
		<h3 class="text-center">${software.sw_name }</h3>
		<h5 class="text-center">v${software.version }</h5>
		<p>
		<fmt:message key="${software.sw_name }" />
		</p>
		<div align="center">
        <a class="btn btn-md btn-default btn-block" style="width:100px" onclick="request('${software.id}', '${software.sw_name }');">신청하기</a>
    	</div>
	</div>
	</c:forEach>
</div>
<hr>
</fmt:bundle>
<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />

<!-- /.container -->

<script>
	function request(sw_id, sw_name) {
		var state = confirm(sw_name + " 에 대한 라이센스를 요청하시겠습니까?");
		if(state == true){
			$.ajax({
				url : "/software/user/request",
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify({
					sw_id : sw_id
				}),
				success : function(data) {
					window.location = "/software/user/request";
				},
				error : function(data, textStatus, errorThrown) {
					console.log(data);
				}
			});
		} else {
			alert("라이센스 요청을 취소합니다.");
		}
	}

	}
</script>

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />
