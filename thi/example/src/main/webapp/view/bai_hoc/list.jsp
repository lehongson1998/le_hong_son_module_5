<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css"/>
    <link rel="stylesheet" href="/fontawesome-free-6.1.2-web/css/all.min.css">
</head>
<body>
<%@include file="/include/header.jsp"%>
<div class="container text-center pd-5 table-responsive">
    <h2>Danh Sách Bài Học</h2>
    <button class="btn btn-info text-light" onclick="location.href='/Customer?action=showCreateCustomer'">
        Thêm Mới Bài Học
    </button>
    <form class="d-flex col-md-5" action="/Customer?action=findByNameCustomer" method="post">
        <input class="form-control me-1" type="search" placeholder="Search" aria-label="Search" name="name">
        <button class="btn btn-outline-info text-light bg-success" type="submit">Search</button>
    </form>
    <table class="table table-striped table-bordered table-hover table-sm border-success" id="tableCustomer">
        <thead>
        <tr class="bg-secondary bg-gradient text-light text-center">
            <th>#</th>
            <th>Tiêu Đề</th>
            <th>mmm</th>
            <th>Loại Bài Học</th>
            <th>Độ khó</th>
            <th>Module</th>
            <th>Link Bài Học</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="baiHoc" items="${list}" varStatus="c">
            <tr class="bg-light bg-gradient">
                <td>${c.count}</td>
                <td>${baiHoc.tieuDe}</td>
                <td>${baiHoc.maBaiHoc}</td>
                <td>${baiHoc.loaiBaiHoc}</td>
                <td>${baiHoc.doKho}</td>
                <c:forEach var="module" items="${module}">
                    <c:if test="${module.maModule == baiHoc.maModule}">
                        <td>${module.tenModule}</td>
                    </c:if>
                </c:forEach>
                <td>${baiHoc.linkBaiHoc}</td>
                <td>
                    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#edit-modal" onclick="location.href='/'">
                        Edit
                    </button>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="removeSubject('${baiHoc.maBaiHoc}')">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/example?action=deleteSubject" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete Subject</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" id="removeID" name="idRemove" class="form-control-plaintext">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </div>
    </form>
</div>




<%@include file="/include/footer.jsp"%>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="https://kit.fontawesome.com/8a4e8d8d08.js" crossorigin="anonymous"></script>
<script>
    function removeSubject(id){
        console.log(id)
        document.getElementById("removeID").value = id;
        console.log(document.getElementById("removeID"));
    }
</script>
</body>
</html>
