<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String _nav = request.getParameter("_nav"); %>

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
            <a class="navbar-brand" href="/main.jsp">Smart Lock</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-left">
                <li <%= (_nav != null && _nav.equals("main")) ? "class=\"active\"" : "" %>>
                    <a href="/main.jsp">Home</a>
                </li>
                <li <%= (_nav != null && _nav.equals("statistics")) ? "class=\"active\"" : "" %>>
                    <a href="/statistics.jsp">Statistics</a>
                </li>
                <li <%= (_nav != null && _nav.equals("license")) ? "class=\"active\"" : "" %>>
                    <a href="/license.jsp">License</a>
                </li>
                <li <%= (_nav != null && _nav.equals("qna")) ? "class=\"active\"" : "" %>>
                    <a href="/qna.jsp">Q&A</a>
                </li>
                <li <%= (_nav != null && _nav.equals("notice")) ? "class=\"active\"" : "" %>>
                    <a href="/notice.jsp">Notice</a>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown"><a href="#" class="dropdown-toggle"
                                        data-toggle="dropdown"><span
                        class="glyphicon glyphicon-user pull-leftt"></span></a>
                    <ul class="dropdown-menu">
                        <li><br>
                            <div class="col-md-5">
                                <img class="img-responsive" style="margin-left: 15px; margin-right: 20px" align="left" width="100px" src="/html/img/profile.png" alt=""></div>
                            <div class="col-md-7">
                                <h4>홍길동 님</h4>
                                <h5>example@google.com</h5>
                                <a class="btn btn-sm btn-default btn-block" href="/profile.jsp">마이페이지</a>
                                <br>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li><a href="/log_out.jsp">로그아웃</a></li>
                    </ul></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>