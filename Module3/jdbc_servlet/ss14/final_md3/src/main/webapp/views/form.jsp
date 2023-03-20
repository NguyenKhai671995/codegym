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
    <div class="col-md-1 col-lg-1" hidden>

    </div>
    <div class="col-md-10 col-lg-10">
        <section class="vh-100 bg-image"
                 style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
            <div class="mask d-flex align-items-center h-100 gradient-custom-3">
                <div class="container h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                            <div class="card" style="border-radius: 15px;">
                                <div class="card-body p-5">
                                    <h2 class="text-uppercase text-center mb-5">Form Controll Mat Bang</h2>
                                    <c:if test="${message != null}">
                                        <h3 style="color:red;">${message}</h3>
                                    </c:if>
                                    <form method="post">
                                        <%--                                        <input type="hidden" name="id" value="${target.id}">--%>
                                        <div class="form-outline mb-4">
                                            <input type="text" id="form3Example1cg" value="${target.ma_mb}" name="ma_mb"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example1cg">Mat Bang</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:red;">${error.get('ma_mb')}</h5>
                                            </c:if>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <input type="number" id="form3Example3cg" value="${target.dien_tich}"
                                                   name="dien_tich"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example3cg">dien tich</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:red;">${error.get('dien_tich')}</h5>
                                            </c:if>
                                        </div>

                                        <div class="form-outline mb-12">
                                            <label class="form-label" for="form3Example3cg">Trang Thai</label>
                                            <label>
                                                <select class="select" name="status" required>
                                                    <c:forEach items="${trangThaiList}" var="item">
                                                        <option value="${item.ma_trang_thai}">
                                                                ${item.ten_tran_thai}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </label>
                                        </div>

                                        <div class="form-outline mb-4">
<%--                                            <input type="number" id="form3Example5cdg" value="${target.tang}"--%>
<%--                                                   name="tang"--%>
<%--                                                   class="form-control form-control-lg"/>--%>
                                            <select id="form3Example5cdg" name="tang">
                                                <c:forEach varStatus="item" begin="1" end="15">
                                                    <option value="${item.count}">${item.count}</option>
                                                </c:forEach>
                                            </select>
                                            <label class="form-label" for="form3Example5cdg">Tang</label>

<%--                                            <c:if test="${error != null}">--%>
<%--                                                <h5 style="color:red;">${error.get('tang')}</h5>--%>
<%--                                            </c:if>--%>

                                        </div>

                                        <div class="form-outline mb-12">
                                            <label class="form-label" for="form3Example5cdg">Van Phong</label>
                                            <label>
                                                <select class="select" name="van_phong" required>
                                                    <c:forEach items="${vanPhongList}" var="item">
                                                        <option value="${item.ma_van_phong}">
                                                                ${item.loai_phong}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </label>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <input type="number" id="form3Example4cg" value="${target.gia}"
                                                   name="gia"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example4cg">Gia</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:red;">${error.get('gia')}</h5>
                                            </c:if>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <input type="date" id="form3Example1cg" value="${target.ngay_vao}"
                                                   name="ngay_vao"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example1cg">Ngay Vao</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:red;">${error.get('ngay_vao')}</h5>
                                            </c:if>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <input type="date" id="form3Example1cg" value="${target.ngay_het}"
                                                   name="ngay_het"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example1cg">Ngay het</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:red;">${error.get('ngay_het')}</h5>
                                            </c:if>
                                        </div>

                                        <div class="d-flex justify-content-center">
                                            <button type="submit"
                                                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">
                                                Submit
                                            </button>
                                            <button type="reset"
                                                    class="btn btn-warning btn-block btn-lg gradient-custom-4 text-body">
                                                Reset
                                            </button>
                                            <a href="/product">
                                                <button type="button"
                                                        class="btn btn-info btn-block btn-lg gradient-custom-4 text-body">
                                                    Back List
                                                </button>
                                            </a>
                                        </div>

                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <div class="col-md-1 col-lg-1" hidden>

    </div>
</div>
</body>
</html>
