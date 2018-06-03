
$(document).ready(function () {

    category();
    area();
    order();

    $.ajax({
        cache: false,
        url: "getProduct",
        type: 'GET',
        success: function (data, textStatus, jqXHR) {
            var $tbody = $('#tb-product tbody');
            // var header = $('<div
            // class="page-header"><h3>Điện
            // thoại</h3></div>');

            for (var i = 0; i < data.length; i++) {
                var $tr = $('<tr></tr>');
                var $tdProductName = $('<td></td>');
                var $span = $('<span></span>');
                $tr.attr('class', 'footable-even');
                $tdProductName
                    .attr('class',
                        'footable-visible footable-first-column');
                $span.attr('class', 'footable-toggle');
                $tdProductName.html(data[i].productName);
                $tdProductName.append($span);
                $tr.append($tdProductName);

                var $tdCategoryName = $('<td></td>');
                $tdCategoryName.attr('class',
                    'footable-visible')
                $tdCategoryName.html(data[i].categoryName);
                $tr.append($tdCategoryName);

                var $tdProductPrice = $('<td></td>');
                $tdProductPrice.attr('class',
                    'footable-visible')
                $tdProductPrice.html(data[i].productPrice + ' vnđ');
                $tr.append($tdProductPrice);

                var $img = $('<img/>');
                var $tdProductImage = $('<td></td>');
                $img.attr('src',
                    'img/'
                    + data[i].productImage);
                $img.attr('alt', 'image');
                $img.attr('width', '20');
                $tdProductImage.append($img);
                $tr.append($tdProductImage);

                var $tdProductUnit = $('<td></td>');
                $tdProductUnit.attr('class',
                    'footable-visible')
                $tdProductUnit.html(data[i].productUnit);
                $tr.append($tdProductUnit);

                var $tdProductDetails = $('<td></td>');
                $tdProductDetails.attr('class',
                    'footable-visible')
                $tdProductDetails.html(data[i].productDetails);
                $tr.append($tdProductDetails);

                var $tdProductQuanity = $('<td></td>');
                $tdProductQuanity.attr('class',
                    'footable-visible')
                $tdProductQuanity.html(data[i].productQuanity);
                $tr.append($tdProductQuanity);

                var $tdStatus = $('<td></td>');
                var $span = $('<span></span>');
                // $tr.attr('class', 'footable-even');
                $tdStatus.attr('class',
                    'footable-visible');
                $span.attr('class',
                    'label label-primary');
                $span.html(data[i].productStatus);
                $tdStatus.append($span);
                $tr.append($tdStatus);

                var $tdActions = $('<td></td>');
                var $div = $('<div></div>');
                $tdActions
                    .attr('class',
                        'text-right footable-visible footable-last-column');
                $div.attr('class', 'btn-group');

                var $btnView = $('<a href="#" data-id="'
                    + data[i].productId
                    + '" class="btn-white btn btn-xs btn-viewProduct">View</a>');
                $div.append($btnView);

                var $btnEdit = $('<a href="#" data-id="'
                    + data[i].productId
                    + '" class="btn-white btn btn-xs btn-editProduct">Edit</a>');
                $div.append($btnEdit);

                var $btnDelete = $('<a href="#" data-id="'
                    + data[i].productId
                    + '" class="btn-white btn btn-xs btn-deleteProduct">Delete</a>');
                $div.append($btnDelete);

                $tdActions.append($div);
                $tr.append($tdActions);
                $tbody.append($tr);

            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console
                .log("error request: "
                    + errorThrown);
        }
    });

    $('#tb-product').on('click', '.btn-viewProduct', function () {
        var id = $(this).attr('data-id');
        doView(id);
    });

    function doView(id) {
        location.href = 'viewProduct' + id;
    }

    $('#tb-product').on('click', '.btn-editProduct', function () {
        var id = $(this).attr('data-id');
        doEditProduct(id);
    });

    function doEditProduct(id) {
        location.href = 'updateProduct/' + id;
    }

    $('#tb-product').on('click', '.btn-deleteProduct',
        function (event) {
            var conBox = confirm("Are you sure ?");
            if (conBox) {
                doDelete($(this));
            }
            event.preventDefault();
        });

    function doDelete(element) {
        var id = element.attr('data-id');
        $.ajax({
            url: "delete/" + id + "/",
            type: "DELETE",
            method: "delete",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept",
                    "application/json");
                xhr.setRequestHeader("Content-Type",
                    "application/json");
            },
            success: function () {
                var tr = element.closest("tr");
                tr.css("background-color", "#000000");
                tr.fadeIn(1000).fadeOut(200, function () {
                    tr.remove();
                })
            }
        });
    }

    function category() {

//Thể loại
        $.ajax({
            cache: false,
            url: "getCategory",
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                var $tbody = $('#tb-category tbody');
                // var header = $('<div
                // class="page-header"><h3>Điện
                // thoại</h3></div>');

                for (var i = 0; i < data.length; i++) {
                    var $tr = $('<tr></tr>');
                    var $tdCategoryName = $('<td></td>');
                    var $span = $('<span></span>');
                    $tr.attr('class', 'footable-even');
                    $tdCategoryName
                        .attr('class',
                            'footable-visible footable-first-column');
                    $span.attr('class', 'footable-toggle');
                    $tdCategoryName.html(data[i].categoryName);
                    $tdCategoryName.append($span);
                    $tr.append($tdCategoryName);

                    // var $tdCategoryName = $('<td></td>');
                    // $tdCategoryName.attr('class',
                    //     'footable-visible')
                    // $tdCategoryName.html(data[i].categoryName);
                    // $tr.append($tdCategoryName);

                    var $tdActions = $('<td></td>');
                    var $div = $('<div></div>');
                    $tdActions
                        .attr('class',
                            'text-right footable-visible footable-last-column');
                    $div.attr('class', 'btn-group');

                    // var $btnView = $('<a href="#" data-id="'
                    //     + data[i].productId
                    //     + '" class="btn-white btn btn-xs btn-view">View</a>');
                    // $div.append($btnView);

                    var $btnEdit = $('<a href="#" data-id="'
                        + data[i].categoryId
                        + '" class="btn-white btn btn-xs btn-editCategory">Edit</a>');
                    $div.append($btnEdit);

                    var $btnDelete = $('<a href="#" data-id="'
                        + data[i].categoryId
                        + '" class="btn-white btn btn-xs btn-deleteCategory">Delete</a>');
                    $div.append($btnDelete);

                    $tdActions.append($div);
                    $tr.append($tdActions);
                    $tbody.append($tr);
                }
            }
        });

        $('#tb-category').on('click', '.btn-editCategory', function () {
            var id = $(this).attr('data-id');
            doEditCategory(id);
        });

        function doEditCategory(id) {
            location.href = 'updateCategory/' + id;
        }

        $('#tb-category').on('click', '.btn-deleteCategory',
            function (event) {
                var conBox = confirm("Xác nhận xóa");
                if (conBox) {
                    doDeleteCategory($(this));
                }
                event.preventDefault();
            });

        function doDeleteCategory(element) {
            var id = element.attr('data-id');
            $.ajax({
                url: "delete/" + id + "/",
                type: "DELETE",
                method: "delete",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept",
                        "application/json");
                    xhr.setRequestHeader("Content-Type",
                        "application/json");
                },
                success: function () {
                    var tr = element.closest("tr");
                    tr.css("background-color", "#000000");
                    tr.fadeIn(1000).fadeOut(200, function () {
                        tr.remove();
                    })
                }
            });
        }
    }
//
// //Khu vực
//
//
    function area() {
        $.ajax({
            cache: false,
            url: "getArea",
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                var $tbody = $('#tb-area tbody');
                // var header = $('<div
                // class="page-header"><h3>Điện
                // thoại</h3></div>');

                for (var i = 0; i < data.length; i++) {
                    var $tr = $('<tr></tr>');
                    var $tdareaName = $('<td></td>');
                    var $span = $('<span></span>');
                    $tr.attr('class', 'footable-even');
                    $tdareaName
                        .attr('class',
                            'footable-visible footable-first-column');
                    $span.attr('class', 'footable-toggle');
                    $tdareaName.html(data[i].areaName);
                    $tdareaName.append($span);
                    $tr.append($tdareaName);

                    // var $tdCategoryName = $('<td></td>');
                    // $tdCategoryName.attr('class',
                    //     'footable-visible')
                    // $tdCategoryName.html(data[i].categoryName);
                    // $tr.append($tdCategoryName);

                    var $tdActions = $('<td></td>');
                    var $div = $('<div></div>');
                    $tdActions
                        .attr('class',
                            'text-right footable-visible footable-last-column');
                    $div.attr('class', 'btn-group');

                    // var $btnView = $('<a href="#" data-id="'
                    //     + data[i].productId
                    //     + '" class="btn-white btn btn-xs btn-view">View</a>');
                    // $div.append($btnView);

                    var $btnEdit = $('<a href="#" data-id="'
                        + data[i].areaId
                        + '" class="btn-white btn btn-xs btn-edit">Edit</a>');
                    $div.append($btnEdit);

                    var $btnDelete = $('<a href="#" data-id="'
                        + data[i].areaId
                        + '" class="btn-white btn btn-xs btn-delete">Delete</a>');
                    $div.append($btnDelete);

                    $tdActions.append($div);
                    $tr.append($tdActions);
                    $tbody.append($tr);
                }
            }
        });

        $('#tb-area').on('click', '.btn-edit', function () {
            var id = $(this).attr('data-id');
            doEditArea(id);
        });

        function doEditArea(id) {
            location.href = 'updateArea/' + id;
        }

        $('#tb-area').on('click', '.btn-delete',
            function (event) {
                var conBox = confirm("Xác nhận xóa");
                if (conBox) {
                    doDeleteArea($(this));
                }
                event.preventDefault();
            });

        function doDeleteArea(element) {
            var id = element.attr('data-id');
            $.ajax({
                url: "delete/" + id + "/",
                type: "DELETE",
                method: "delete",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept",
                        "application/json");
                    xhr.setRequestHeader("Content-Type",
                        "application/json");
                },
                success: function () {
                    var tr = element.closest("tr");
                    tr.css("background-color", "#000000");
                    tr.fadeIn(1000).fadeOut(200, function () {
                        tr.remove();
                    })
                }
            });
        }
    }
//
// // Bàn
//
    function dinnerTable() {


        $.ajax({
            cache: false,
            url: "getDinnerTable",
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                var $tbody = $('#tb-dinnertable tbody');
                // var header = $('<div
                // class="page-header"><h3>Điện
                // thoại</h3></div>');

                for (var i = 0; i < data.length; i++) {
                    var $tr = $('<tr></tr>');
                    var $tdDinnerTableName = $('<td></td>');
                    var $span = $('<span></span>');
                    $tr.attr('class', 'footable-even');
                    $tdDinnerTableName
                        .attr('class',
                            'footable-visible footable-first-column');
                    $span.attr('class', 'footable-toggle');
                    $tdDinnerTableName.html(data[i].dinnerTableName);
                    $tdDinnerTableName.append($span);
                    $tr.append($tdDinnerTableName);

                    var $tdTableQuanity = $('<td></td>');
                    $tdTableQuanity.attr('class',
                        'footable-visible')
                    $tdTableQuanity.html(data[i].dinnerTableQuanity);
                    $tr.append($tdTableQuanity);

                    var $tdareaName = $('<td></td>');
                    $tdareaName.attr('class',
                        'footable-visible')
                    $tdareaName.html(data[i].areaName);
                    $tr.append($tdareaName);

                    var $tdActions = $('<td></td>');
                    var $div = $('<div></div>');
                    $tdActions
                        .attr('class',
                            'text-right footable-visible footable-last-column');
                    $div.attr('class', 'btn-group');

                    // var $btnView = $('<a href="#" data-id="'
                    //     + data[i].productId
                    //     + '" class="btn-white btn btn-xs btn-view">View</a>');
                    // $div.append($btnView);

                    var $btnEdit = $('<a href="#" data-id="'
                        + data[i].dinnerTableID
                        + '" class="btn-white btn btn-xs btn-editdinnertable">Edit</a>');
                    $div.append($btnEdit);

                    var $btnDelete = $('<a href="#" data-id="'
                        + data[i].dinnerTableID
                        + '" class="btn-white btn btn-xs btn-deletedinnertable">Delete</a>');
                    $div.append($btnDelete);

                    $tdActions.append($div);
                    $tr.append($tdActions);
                    $tbody.append($tr);
                }
            }
        });

        $('#tb-dinnertable').on('click', '.btn-editdinnertable', function () {
            var id = $(this).attr('data-id');
            doEditdinnerTable(id);
        });

        function doEditdinnerTable(id) {
            location.href = 'updateDinnerTable/' + id;
        }

        $('#tb-dinnertable').on('click', '.btn-deletedinnertable',
            function (event) {
                var conBox = confirm("Xác nhận xóa");
                if (conBox) {
                    doDeletedinnerTable($(this));
                }
                event.preventDefault();
            });

        function doDeletedinnerTable(element) {
            var id = element.attr('data-id');
            $.ajax({
                url: "delete/" + id + "/",
                type: "DELETE",
                method: "delete",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept",
                        "application/json");
                    xhr.setRequestHeader("Content-Type",
                        "application/json");
                },
                success: function () {
                    var tr = element.closest("tr");
                    tr.css("background-color", "#000000");
                    tr.fadeIn(1000).fadeOut(200, function () {
                        tr.remove();
                    })
                }
            });
        }
    }

    function employee() {
        $.ajax({
            cache: false,
            url: "getDinnerTable",
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                var $tbody = $('#tb-employee tbody');
                // var header = $('<div
                // class="page-header"><h3>Điện
                // thoại</h3></div>');

                for (var i = 0; i < data.length; i++) {
                    var $tr = $('<tr></tr>');
                    var $tdEpoyeeName = $('<td></td>');
                    var $span = $('<span></span>');
                    $tr.attr('class', 'footable-even');
                    $tdEpoyeeName
                        .attr('class',
                            'footable-visible footable-first-column');
                    $span.attr('class', 'footable-toggle');
                    $tdEpoyeeName.html(data[i].employeeName);
                    $tdEpoyeeName.append($span);
                    $tr.append($tdEpoyeeName);

                    var $td$tdEpoyeeUsername = $('<td></td>');
                    $td$tdEpoyeeUsername.attr('class',
                        'footable-visible')
                    $td$tdEpoyeeUsername.html(data[i].userName);
                    $tr.append($td$tdEpoyeeUsername);

                    var $td$tdEpoyeePhone = $('<td></td>');
                    $td$tdEpoyeePhone.attr('class',
                        'footable-visible')
                    $td$tdEpoyeePhone.html(data[i].phone);
                    $tr.append($td$tdEpoyeePhone);

                    var $td$tdEpoyeeaddress = $('<td></td>');
                    $td$tdEpoyeeaddress.attr('class',
                        'footable-visible')
                    $td$tdEpoyeeaddress.html(data[i].address);
                    $tr.append($td$tdEpoyeeaddress);

                    var $td$tdEpoyeeRole = $('<td></td>');
                    $td$tdEpoyeeRole.attr('class',
                        'footable-visible')
                    $td$tdEpoyeeRole.html(data[i].roleName);
                    $tr.append($td$tdEpoyeeRole);

                    var $tdActions = $('<td></td>');
                    var $div = $('<div></div>');
                    $tdActions
                        .attr('class',
                            'text-right footable-visible footable-last-column');
                    $div.attr('class', 'btn-group');

                    // var $btnView = $('<a href="#" data-id="'
                    //     + data[i].productId
                    //     + '" class="btn-white btn btn-xs btn-view">View</a>');
                    // $div.append($btnView);

                    var $btnEdit = $('<a href="#" data-id="'
                        + data[i].dinnerTableID
                        + '" class="btn-white btn btn-xs btn-editdinnertable">Edit</a>');
                    $div.append($btnEdit);

                    var $btnDelete = $('<a href="#" data-id="'
                        + data[i].dinnerTableID
                        + '" class="btn-white btn btn-xs btn-deletedinnertable">Delete</a>');
                    $div.append($btnDelete);

                    $tdActions.append($div);
                    $tr.append($tdActions);
                    $tbody.append($tr);
                }
            }
        });

        $('#tb-employee').on('click', '.btn-editdinnertable', function () {
            var id = $(this).attr('data-id');
            doEditdinnerTable(id);
        });

        function doEditdinnerTable(id) {
            location.href = 'updateDinnerTable/' + id;
        }

        $('#tb-employee').on('click', '.btn-deletedinnertable',
            function (event) {
                var conBox = confirm("Xác nhận xóa");
                if (conBox) {
                    doDeletedinnerTable($(this));
                }
                event.preventDefault();
            });

        function doDeletedinnerTable(element) {
            var id = element.attr('data-id');
            $.ajax({
                url: "delete/" + id + "/",
                type: "DELETE",
                method: "delete",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept",
                        "application/json");
                    xhr.setRequestHeader("Content-Type",
                        "application/json");
                },
                success: function () {
                    var tr = element.closest("tr");
                    tr.css("background-color", "#000000");
                    tr.fadeIn(1000).fadeOut(200, function () {
                        tr.remove();
                    })
                }
            });
        }
    }

    function order() {
        $.ajax({
            cache: false,
            url: "getBillAll",
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                var $tbody = $('#tb-order tbody');
                // var header = $('<div
                // class="page-header"><h3>Điện
                // thoại</h3></div>');

                for (var i = 0; i < data.length; i++) {
                    var $tr = $('<tr></tr>');
                    var $tddinnerTableID = $('<td></td>');
                    var $span = $('<span></span>');
                    $tr.attr('class', 'footable-even');
                    $tddinnerTableID
                        .attr('class',
                            'footable-visible footable-first-column');
                    $span.attr('class', 'footable-toggle');
                    $tddinnerTableID.html(data[i].dinnerTableID);
                    $tddinnerTableID.append($span);
                    $tr.append($tddinnerTableID);

                    var $td$tdbillDate = $('<td></td>');
                    $td$tdbillDate.attr('class',
                        'footable-visible')
                    $td$tdbillDate.html(data[i].billDate);
                    $tr.append($td$tdbillDate);

                    var $td$tdgrandTotal = $('<td></td>');
                    $td$tdgrandTotal.attr('class',
                        'footable-visible')
                    $td$tdgrandTotal.html(data[i].grandTotal);
                    $tr.append($td$tdgrandTotal);

                    var $td$tdemployeeID = $('<td></td>');
                    $td$tdemployeeID.attr('class',
                        'footable-visible')
                    $td$tdemployeeID.html(data[i].employeeID);
                    $tr.append($td$tdemployeeID);

                    // var $tdActions = $('<td></td>');
                    // var $div = $('<div></div>');
                    // $tdActions
                    //     .attr('class',
                    //         'text-right footable-visible footable-last-column');
                    // $div.attr('class', 'btn-group');

                    // var $btnView = $('<a href="#" data-id="'
                    //     + data[i].productId
                    //     + '" class="btn-white btn btn-xs btn-view">View</a>');
                    // $div.append($btnView);

                    // var $btnEdit = $('<a href="#" data-id="'
                    //     + data[i].dinnerTableID
                    //     + '" class="btn-white btn btn-xs btn-editdinnertable">Edit</a>');
                    // $div.append($btnEdit);
                    //
                    // var $btnDelete = $('<a href="#" data-id="'
                    //     + data[i].dinnerTableID
                    //     + '" class="btn-white btn btn-xs btn-deletedinnertable">Delete</a>');
                    // $div.append($btnDelete);
                    //
                    // $tdActions.append($div);
                    // $tr.append($tdActions);
                    $tbody.append($tr);
                }
            }
        });

        $('#tb-employee').on('click', '.btn-editdinnertable', function () {
            var id = $(this).attr('data-id');
            doEditdinnerTable(id);
        });

        function doEditdinnerTable(id) {
            location.href = 'updateDinnerTable/' + id;
        }

        $('#tb-employee').on('click', '.btn-deletedinnertable',
            function (event) {
                var conBox = confirm("Xác nhận xóa");
                if (conBox) {
                    doDeletedinnerTable($(this));
                }
                event.preventDefault();
            });

        function doDeletedinnerTable(element) {
            var id = element.attr('data-id');
            $.ajax({
                url: "delete/" + id + "/",
                type: "DELETE",
                method: "delete",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept",
                        "application/json");
                    xhr.setRequestHeader("Content-Type",
                        "application/json");
                },
                success: function () {
                    var tr = element.closest("tr");
                    tr.css("background-color", "#000000");
                    tr.fadeIn(1000).fadeOut(200, function () {
                        tr.remove();
                    })
                }
            });
        }
    }
});
