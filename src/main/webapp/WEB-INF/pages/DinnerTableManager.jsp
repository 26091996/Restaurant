<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>
        Quản lý bàn
    </title>
    <tags:importStyles/>
</head>

<body>
<tags:body>
    <div class="main-panel">
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="ibox">
                                <div class="ibox-content">
                                    <div class="form-group" align="right">
                                        <a class="btn btn-w-m btn-primary" href="AddCategory">Thêm bàn</a>
                                    </div>
                                    <div class="card-header card-header-primary">
                                        <h4 class="card-title ">Danh sách bàn</h4>
                                    </div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table id="tb-dinnertable"
                                                   class="footable table table-stripped toggle-arrow-tiny tablet breakpoint footable-loaded"
                                                   data-page-size="15">
                                                <thead class=" text-primary">
                                                <tr>
                                                    <th data-hide="phone"
                                                        class="footable-visible footable-sortable">Tên bàn<span
                                                                class="footable-sort-indicator"></span>
                                                    </th>
                                                    <th data-hide="phone"
                                                        class="footable-visible footable-sortable">Tên khu vực<span
                                                                class="footable-sort-indicator"></span>
                                                    </th>
                                                    <th data-hide="phone"
                                                        class="footable-visible footable-sortable">Số ghế<span
                                                                class="footable-sort-indicator"></span>
                                                    </th>
                                                    <th
                                                            class="text-right footable-visible footable-last-column footable-sortable">
                                                        Action<span
                                                            class="footable-sort-indicator"></span></th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                    <%-- <c:forEach items="${productList}" var="product">
                                                        <tr class="footable-even" style="">
                                                            <td class="footable-visible footable-first-column">
                                                            <span class="footable-toggle"></span> ${product.productName}</td>
                                                            <td class="footable-visible">${product.image}</td>
                                                            <td class="footable-visible">${product.price}</td>
                                                            <td class="footable-visible">${product.sku}</td>
                                                            <td style="display: none;">${product.categoryId}</td>
                                                            <td class="footable-visible"><span
                                                                class="label label-primary">Pending</span></td>
                                                            <td class="text-right footable-visible footable-last-column">
                                                                <div class="btn-group">
                                                                    <button class="btn-white btn btn-xs">View</button>
                                                                    <button class="btn-white btn btn-xs">Edit</button>
                                                                    <button class="btn-white btn btn-xs">Delete</button>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </c:forEach> --%>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
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
