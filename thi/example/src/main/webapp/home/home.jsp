
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
    <div class="col-md-12 pd-5 bg-gradient bg-light">
        <div id="carouselExampleControls" class="carousel slide pd-5" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="../image/images.jpg" class="d-block w-100 h-75" alt="cailone">
                </div>
                <div class="carousel-item">
                    <img src="../image/more-bali-zakat-lyudi-oblaka.jpg" class="d-block w-100 h-75" alt="concat">
                </div>
                <div class="carousel-item">
                    <img src="../image/wallpapersden.com_sea-ocean-waves_1920x1080.jpg" class="d-block w-100 h-75" alt="daubuoi">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
<button class="btn btn-light">
    <span class="text-danger">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash fs-3" viewBox="0 0 16 16">
              <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
              <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
        </svg>
    </span>
</button>

<button class="btn btn-success">
    <span class="text-light fs-1">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square fs-3" viewBox="0 0 16 16">
        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
    </svg>
    </span>
</button>
<%@include file="/include/footer.jsp"%>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="https://kit.fontawesome.com/8a4e8d8d08.js" crossorigin="anonymous"></script>
</body>
</html>
