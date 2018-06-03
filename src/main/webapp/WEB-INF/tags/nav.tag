<%@ tag language="java" pageEncoding="UTF-8" %>
    <div class="sidebar" data-color="purple" data-background-color="white" data-image="../img/sidebar-1.jpg">
        <!--
    Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

    Tip 2: you can also add an image using data-image tag
    -->
        <div class="logo">
            <a href="http://www.creative-tim.com" class="simple-text logo-normal">
                Creative Tim
            </a>
        </div>
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="/index">
                        <i class="material-icons">dashboard</i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/ProductManager">
                        <i class="material-icons">bubble_chart</i>
                        <p>Quản lý sản phẩm</p>
                    </a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="/showCategoryManager">
                        <i class="material-icons">content_paste</i>
                        <p>Quản lý loại sản phẩm</p>
                    </a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="/showArea">
                        <i class="material-icons">library_books</i>
                        <p>Quản lý sơ đồ</p>
                    </a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="/showEmployeeManager">
                        <i class="material-icons">person</i>
                        <p>Quản lý nhân viên</p>
                    </a>
                </li>
                <%--<li class="nav-item ">--%>
                    <%--<a class="nav-link" href="show">--%>
                        <%--<i class="material-icons">location_ons</i>--%>
                        <%--<p>Maps</p>--%>
                    <%--</a>--%>
                <%--</li>--%>

            </ul>
        </div>
    </div>