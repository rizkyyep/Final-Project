<%-- 
    Document   : listPsychotest
    Created on : Jan 2, 2020, 2:51:37 AM
    Author     : Rizky
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../templates/header.jsp"></jsp:include>
<jsp:include page="../templates/topbar.jsp"></jsp:include>
<jsp:include page="../templates/sidebar.jsp"></jsp:include>

    <div class="page-wrapper">
        <!-- ============================================================== -->
        <!-- Bread crumb and right sidebar toggle -->
        <!-- ============================================================== -->
        <div class="page-breadcrumb">
            <div class="row">
                <div class="col-12 d-flex no-block align-items-center">
                    <div class="page-title">
                        <h4>${title}</h4>
                    <h6>This page contains a psychotest schedule for candidate</h6>
                </div>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Library</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <table id="listItem" class="table table-hover table-responsive table-striped listItem">
                            <tr>
                                <th>No</th>
                                <th>ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Job Role</th>
                                <th>Company</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>Score</th>
                                <th>Status Psychotest</th>
                                <th>Action</th>
                            </tr>
                            <c:forEach var = "list" items = "${list}" varStatus="loop">
                                <tr>
                                    <td><c:out value="${loop.count}"/></td>
                                    <td>${list.id}</td>
                                    <td>${list.candidate.firstName}</td>
                                    <td>${list.candidate.lastName}</td>
                                    <td>${list.vacancy.jobs.jobTitle}</td>
                                    <td>${list.vacancy.company}</td>
                                    <td><fmt:formatDate dateStyle = "long" pattern = "EEEE, dd MMMM yyyy" value = "${list.testScoreList[List<testScore> testScore].startDate}" /></td>
                                    <td><fmt:formatDate dateStyle = "long" pattern = "EEEE, dd MMMM yyyy" value = "${list.testScoreList[List<testScore> testScore].endDate}" /></td>
                                    <td>
                                        <c:if test="${list.testScoreList[List<testScore> testScore].status == 0 }" >
                                            <c:out value="-" />
                                        </c:if>
                                        <c:if test="${list.testScoreList[List<testScore> testScore].status == 1 }" >
                                            ${list.testScoreList[List<testScore> testScore].score}
                                        </c:if>
                                        <c:if test="${list.testScoreList[List<testScore> testScore].status == 2 }" >
                                            <c:out value="-" />
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${list.testScoreList[List<testScore> testScore].status == 0 }" >
                                            Psychotest Already Scheduled
                                        </c:if>
                                        <c:if test="${list.testScoreList[List<testScore> testScore].status == 1 }" >
                                            Psychotest Done
                                        </c:if>
                                        <c:if test="${list.testScoreList[List<testScore> testScore].status == 2 }" >
                                            Psychotest Failed/Is not Done
                                        </c:if>
                                    </td>
                                    <td>
                                        <a href="/addschedule/${list.candidate.id}/${list.id}">Make Interview Schedule</a> 
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#listItem').DataTable();
//                    {
//                        "columnDefs": [
//                            {"orderable": false, "targets": 3}
//                        ]
//                    }
//            );
        });
    </script>



    <jsp:include page="../templates/footer.jsp"></jsp:include>
