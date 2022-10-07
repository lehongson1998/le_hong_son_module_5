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
<button class="btn"><i class="fa-solid fa-trash-can text-danger fs-3"></i></button>
<button class="btn"><i class="fa-solid fa-pen-to-square fs-3 text-info"></i></button>
<button class="btn"><i class="fa-solid fa-magnifying-glass fs-3"></i></button>
<button class="btn"><i class="fa-solid fa-circle-plus fs-3 text-success"></i></button>

<form action="/example?action=showCustomerById" method="post">
<div class="form-check">
    <input class="form-check-input" type="checkbox" value="1" id="flexCheckDefault" name="id">
    <label class="form-check-label" for="flexCheckDefault">
        Default checkbox
    </label>
</div>

<div class="form-check">
    <input class="form-check-input" type="checkbox" value="2" id="flexCheckDefault1" name="id">
    <label class="form-check-label" for="flexCheckDefault">
        Default checkbox
    </label>
</div>

<div class="form-check">
    <input class="form-check-input" type="checkbox" value="3" id="flexCheckDefault2" name="id">
    <label class="form-check-label" for="flexCheckDefault">
        Default checkbox
    </label>
</div>
    <button type="button" onclick="submitForm()">subimt</button>
</form>
<form action="" hidden id="formDelete">
    <input type="text">
</form>





<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
    Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>










<c:forEach var="i" items="${id}">
    <h4>${i}</h4>
</c:forEach>

<script>
    function submitForm(){
        document.getElementById("formDelete").submit();
    }
</script>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="https://kit.fontawesome.com/8a4e8d8d08.js" crossorigin="anonymous"></script>
</body>
</html>
