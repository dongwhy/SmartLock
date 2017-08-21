<%@ page import="smartlock.license.vo.LicenseUserVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% ArrayList<LicenseUserVO> licenseUserVOArrayList = (ArrayList<LicenseUserVO>) request.getAttribute("licenseUserVOArrayList"); %>
<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); %>

<jsp:include page="include/_header.jsp">
    <jsp:param name="_nav" value="license" />
</jsp:include>

<!-- Page Content -->
<div class="container">
    <!-- Service Panels -->
    <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">라이센스 발급현황</h2>
            <ol class="breadcrumb">
                <li class="active">라이센스 발급현황
                </li>
                <li><a href="/license/user/request">라이센스 요청현황</a></li>
            </ol>
        </div>
        <!-- 검색필터-->
        <div class="row">
            <div class="col-sm-12">
                <div class="col-sm-2">
                    <div class="input-group">
                        <select name="" id="location1"
                                style="width: 180px; height: 35px;">
                            <option value="">소프트웨어명</option>
                            <option value="">Microsoft Excel</option>
                            <option value="">Parallels Desktop</option>
                            <option value="">Adobe CC</option>
                            <option value="">Football Manager</option>
                        </select>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div class="input-group">
                        <select name="" id="location1"
                                style="width: 180px; height: 35px;">
                            <option value="">만료 날짜</option>
                            <option value="">오름차순</option>
                            <option value="">내림차순</option>
                        </select>
                    </div>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="col-md-4" placeholder="검색어를 입력하세요"
                           id="searchField" style="width: 300px; height: 35px;">&nbsp;&nbsp;
                    <button class="btn btn-primary" type="button" id="searchButton"
                            data-loading-text="Searching..">
                        <i class="fa fa-search"></i>
                    </button>
                </div>
            </div>

        </div>
        <br>
        <!-- 검색필터-->
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2 class="text-center">
                </h2>
            </div>
            <div id="no-more-tables">
                <table class="col-sm-12 table-bordered table-striped table-condensed cf">
                    <thead class="cf" align="center">
                    <tr>
                        <td width="10px"><h4><b>No.</h4></td>
                        <td width="230px"><h4><b>소프트웨어</h4></td>
                        <td width="180px"><h4><b>장치명</h4></td>
                        <td width="200px"><h4><b>회사명</h4></td>
                        <td width="150px"><h4><b>시작일자</h4></td>
                        <td width="150px"><h4><b>만료기간</h4></td>
                        <td width="100px"><h4><b>상태</h4></td>
                    </tr>
                    </thead>
                    <tbody align="center">
                    <% for (int i = 0; i < licenseUserVOArrayList.size(); i++) { %>
                    <% LicenseUserVO licenseUserVO = licenseUserVOArrayList.get(i); %>
                    <tr>
                        <td data-title="No."><%= i+1 %></td>
                        <td data-title="소프트웨어"><%=licenseUserVO.getSw_name()%></td>
                        <td data-title="장치명"><%=licenseUserVO.getNickname()%></td>
                        <td data-title="회사명"><%=licenseUserVO.getCorp_name()%></td>
                        <td data-title="시작일자"><%=sdf.format(licenseUserVO.getStart_date())%></td>
                        <td data-title="만료기간"><%=sdf.format(licenseUserVO.getEnd_date())%></td>

                        <% if (licenseUserVO.getState() == 1) { %>
                        <td data-title="상태">
                            <span class="label label-success">
                                발급 완료
                            </span>
                        </td>
                        <% } else if (licenseUserVO.getState() == 2) { %>
                        <td data-title="상태">
                            <span class="label label-success"
                                  onmouseout="this.style.background='#5cb85c';this.innerText='데모 버전';"
                                  onmouseover="this.style.background='#58ACFA';this.innerText='연장 요청';"
                                  onclick="return requestDemo('<%=licenseUserVO.getSw_name()%>');">
                                데모 버전
                            </span>
                        </td>
                        <% } else { %>
                        <td data-title="상태">
                            <span class="label label-danger"
                                  onmouseout="this.style.background='#DF5A5A';this.innerText='발급 거절';"
                                  onmouseover="this.style.background='#58ACFA';this.innerText='발급 재요청';"
                                  onclick="return requestLicense('<%=licenseUserVO.getSw_name()%>');">
                                발급거절
                            </span>
                        </td>
                        <% } %>
                    </tr>
                    <% } %>
                    
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- /.container -->
<!-- Pagination -->
<!--
<div class="row text-center">
    <div class="col-lg-12">
        <ul class="pagination">
            <li>
                <a href="#">&laquo;</a>
            </li>
            <li class="active">
                <a href="#">1</a>
            </li>
            <li>
                <a href="#">2</a>
            </li>
            <li>
                <a href="#">3</a>
            </li>
            <li>
                <a href="#">4</a>
            </li>
            <li>
                <a href="#">5</a>
            </li>
            <li>
                <a href="#">&raquo;</a>
            </li>
        </ul>
    </div>
</div>
-->
<!-- /.row -->
<hr>

<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />

<jsp:include page="include/_jslib.jsp" />

<script>
    function requestDemo(swName) {
        alert(swName + " 에 대한 데모 기간 연장을 요청합니다.");
    }

    function requestLicense(swName) {
        alert(swName + " 에 대한 라이센스를 요청합니다.");
    }
</script>

<jsp:include page="include/_footer.jsp" />
