<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="private/_header.jsp">
    <jsp:param name="_nav" value="404" />
</jsp:include>

<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">화면이 없어요 :)
                <small>Page Not Found</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="404.jsp">Home</a>
                </li>
                <li class="active">404</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <div class="row">

        <div class="col-lg-12">
            <div class="jumbotron">
                <h1><span class="error-404">화면이 없어요 :)</span>
                </h1>
                <p>화면을 아직 안만들었어요.</p>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="private/_footer_content.jsp" />

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Script to Activate the Carousel -->
<script>
    $('.carousel').carousel({
        interval : 5000
        //changes the speed
    })
</script>

<jsp:include page="private/_footer.jsp" />
