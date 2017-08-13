<%@ page import="smartlock.member.vo.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UserVO userVO = (UserVO) session.getAttribute("user"); %>

<jsp:include page="include/_header.jsp">
    <jsp:param name="_nav" value="" />
</jsp:include>

<!-- Page Content -->
<div class="container">
    <!-- Service Panels -->
    <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">마이페이지</h2>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <form class="form-horizontal">
                    <fieldset>
                        <div class="col-lg-12">
                            <img class="img-responsive"
                                 style="margin-left: auto; margin-right: auto; display: block;"
                                 width="100px" src="/html/img/profile.png" alt=""> <br>
                            
                            <br>
                            <br>
                        </div>
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-5 control-label" for="textinput">이름</label>
                            <div class="col-md-7">
                                <label class="control-label" for="textinput"><%= userVO.getUserName() %></label>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-5 control-label" for="textinput">소속</label>
                            <div class="col-md-7">
                                <label class="control-label" for="textinput"><%= userVO.getCorpId() %></label>
                            </div>
                        </div>

                        <!-- File Button -->
                        <div class="form-group">
                            <label class="col-md-5 control-label" for="textinput">아이디</label>
                            <div class="col-md-7">
                                <label class="control-label" for="textinput"><%= userVO.getId() %></label>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-5 control-label" for="textinput">비밀번호</label>
                            <div class="col-md-3">
                                <input id="textinput" name="textinput" type="text"
                                       placeholder="현재 비밀번호" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-5 control-label" for="textinput">이메일</label>
                            <div class="col-md-3">
                                <input id="email" name="textinput" type="text"
                                        class="form-control input-md" value="<%=userVO.getEmail() %>">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-5 control-label" for="textinput">전화번호</label>
                            <div class="col-md-3">
                                <input id="phone" name="textinput" type="text"
                                        class="form-control input-md" value="<%=userVO.getPhoneNumber() %>">
                            </div>
                        </div>
                        <br>
                        <!-- Button -->
                        <div class="form-group" align="center">
                            <button class="profile_btn"
                                    style="height: 40px; width: 80px">submit</button>
                        </div>

                    </fieldset>
                </form>

            </div>
        </div>
    </div>
    <!-- /.row -->
    <hr>

    <!-- Footer -->
    <jsp:include page="include/_footer_content.jsp" />

</div>

<jsp:include page="include/_jslib.jsp" >
	<jsp:param name="_js" value="/html/js/profile.js" />
</jsp:include>

<jsp:include page="include/_footer.jsp" />
