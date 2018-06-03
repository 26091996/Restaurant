<%--
  Created by IntelliJ IDEA.
  User: leroi
  Date: 05/16/2018
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <tags:importStyles/>
</head>
<body>
<tags:body>
    <div class="main-panel">
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header card-header-primary">
                                <h4 class="card-title">Cập nhật sản phẩm</h4>
                            </div>
                            <div class="card-body">
                                <fieldset class="form-horizontal">
                                    <form:form action="/saveUpdate" method="post" modelAttribute="command"
                                               enctype="multipart/form-data">

                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <form:hidden path="productId" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="productName"
                                                        class="bmd-label-floating">Tên sản phẩm</form:label>
                                            <div class="col-md-12">
                                                <form:input type="text" path="productName" class="form-control"/>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <form:label path="categoryId"
                                                                class="bmd-label-floating">Loại sản phẩm</form:label>
                                                    <form:select path="categoryId" class="form-control m-b">
                                                        <form:options items="${cateList}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Giá tiền</label>
                                                    <form:input path="productPrice" type="text" class="form-control"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Đơn vị tính</label>
                                                    <form:input path="productUnit" type="text" class="form-control"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Mô tả sản phẩm</label>
                                                    <form:input path="productDetails" type="text" class="form-control"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Số lượng</label>
                                                    <form:input path="productQuantity" type="text"
                                                                class="form-control"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Trạng thái</label>
                                                    <form:select path="productStatus" class="form-control m-b">
                                                        <form:options items="${statusList}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>
                                        <%-- <div class="row">
                                             <div class="col-md-12">--%>
                                        <%--<div class="form-group">--%>
                                        <label class="bmd-label-floating">Hình ảnh: </label>
                                        <div class="col-sm-10">
                                            <input formenctype="multipart/form-data" path="productImage" type="file" name="image">
                                        </div>
                                        <%--</div>--%>
                                        <%--  </div>
                                      </div>--%>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group" align="center">
                                                    <button type="submit" class="btn btn-primary pull-right">Cập nhật sản phẩm
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="clearfix"></div>
                                    </form:form>
                                </fieldset>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>

</tags:body>

</body>
</html>
