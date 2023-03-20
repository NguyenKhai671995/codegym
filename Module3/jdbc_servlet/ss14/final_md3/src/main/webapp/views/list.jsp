<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 8/31/2022
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <script src="bootstrap-5.1.3/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
    <div class="col-md-4 col-lg-4" style="text-align: center">
        <a href="/product?action=create">
            <button class="btn btn-success">Create New</button>
        </a>
    </div>
    <div class="col-md-3 col-lg-3">

    </div>
    <div class="col-md-5 col-lg-5" style="text-align: center">
        <form method="get">
            <input type="hidden"  name="action" value="searchName">
            <input type="text" name="name_search" placeholder="name search">
            <button class="btn btn-info" type="submit">Search</button>
        </form>
    </div>
</div>
<div class="row">
    <div class="col-md-1 col-lg-1">
    </div>
    <div class="col-md-10 col-lg-10">
        <table class="table table-striped table-dark">
            <tr>
                <th>No.</th>
                <th>MaMb</th>
                <th>Dien Tich</th>
                <th>Trang Thai</th>
                <th>Tang</th>
                <th>Loai Van Phong</th>
                <th>Gia Cho Thue</th>
                <th>Ngay Bat Dau</th>
                <th>Ngay Ket Thuc</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${nameList}" var="item" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${item.ma_mb}</td>
                    <td>${item.dien_tich}</td>
<%--                    <td>${item.trang_thai}</td>--%>

                    <c:forEach items="${trangThaiList}" var="check">
                        <c:if test="${check.ma_trang_thai == item.trang_thai}">
                            <td>${check.ten_tran_thai}</td>
                        </c:if>
                    </c:forEach>
                    <td>${item.tang}</td>
<%--                    <td>${item.van_phong}</td>--%>

                    <c:forEach items="${vanPhongList}" var="check">
                        <c:if test="${check.ma_van_phong == item.van_phong}">
                            <td>${check.loai_phong}</td>
                        </c:if>
                    </c:forEach>
                    <td>${item.gia}</td>
                    <td>${item.ngay_vao}</td>
                    <td>${item.ngay_het}</td>
                    <td>
                        <a onclick="showInfoDelete('${item.ma_mb}')"
                           data-bs-toggle="modal" data-bs-target="#delete">
                            <i class="fa-solid fa-eraser"></i>
                        </a>
                        <a href="/product?action=edit&&id=${item.ma_mb}"><i class="fa-solid fa-wrench"></i></a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
    <div class="col-md-1 col-lg-1">

    </div>
</div>


<%--delete modal--%>
<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/product?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete Mat Bang</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="deleteId" name="id">
                    <span>Are you delete mat bang </span><span id="deleteName"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function showInfoDelete(id) {
        document.getElementById("deleteId").value = id;

    }
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
        integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
        crossorigin="anonymous"></script>
</body>
</html>
