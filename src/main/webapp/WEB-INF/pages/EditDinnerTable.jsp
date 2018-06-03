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
                                <h4 class="card-title">Cập nhật bàn</h4>
                            </div>
                            <div class="card-body">
                                <fieldset class="form-horizontal">
                                    <form:form action="/saveUpdateDinnerTable" method="post" modelAttribute="command">

                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <form:hidden path="dinnerTableID" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="dinnerTableName"
                                                        class="bmd-label-floating">Tên bàn</form:label>
                                            <div class="col-md-12">
                                                <form:input type="text" path="dinnerTableName" class="form-control"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="areaID"
                                                        class="bmd-label-floating">Khu vực</form:label>
                                            <div class="col-md-12">
                                                <form:input type="text" path="areaID" class="form-control"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="dinnerTableQuanity"
                                                        class="bmd-label-floating">Số ghế</form:label>
                                            <div class="col-md-12">
                                                <form:input type="text" path="dinnerTableQuanity" class="form-control"/>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group" align="center">
                                                    <button type="submit" class="btn btn-primary pull-right">Cập nhật
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
