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
                                <h4 class="card-title">Thêm sảm phẩm</h4>
                            </div>
                            <div class="card-body">
                                <fieldset class="form-horizontal">
                                    <form:form action="saveArea" method="post" modelAttribute="AddArea">
                                        <div class="form-group">
                                            <form:label path="areaName"
                                                        class="bmd-label-floating">Tên khu vực</form:label>
                                            <div class="col-md-12">
                                                <form:input type="text" path="areaName" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group" align="center">
                                                    <button type="submit" class="btn btn-primary pull-right">Thêm khu vực
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
