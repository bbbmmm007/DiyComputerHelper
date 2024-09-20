// productManager.js
var pageSize = 15; // 每页显示的商品数量
var totalPages = 1; // 总页数，初始为1
var currentPage = 1; // 当前页数，初始为1

function loadProducts(pageNumber, ancestorId = '', parentId = '', childId = '') {
    var url = '/products/show_productsALLF/' + pageNumber + '/' + pageSize;

    if (childId) {
        url = '/products/show_ch_productsCF/' + childId + '/' + pageNumber + '/' + pageSize;
    } else if (parentId) {
        url = '/products/show_pa_productsPF/' + parentId + '/' + pageNumber + '/' + pageSize;
    } else if (ancestorId) {
        url = '/products/show_an_productsAF/' + ancestorId + '/' + pageNumber + '/' + pageSize;
    }

    $.ajax({
        url: url,
        type: 'GET',
        success: function (json) {
            if (json.state === 200) {
                var products = json.data;
                var $productList = $('#productList');
                $productList.empty();
                $.each(products, function (index, product) {
                    var productRow = '<tr id="product-' + product.id + '">' +
                        '<td>' + product.id + '</td>' +
                        '<td>' + product.childId + '</td>' +
                        '<td>' + product.parentId + '</td>' +
                        '<td>' + product.ancestorId + '</td>' +
                        '<td>' + product.itemType + '</td>' +
                        '<td>' + product.price + '</td>' +
                        '<td><img src="' + product.image + '" alt="商品图片" style="width: 100px; height: auto;"></td>' +
                        '<td>' +
                        '<button class="btn btn-warning" onclick="addToCollection(' + product.id + ')">加入收藏</button>' +
                        ' <button class="btn btn-danger" onclick="addToCart(' + product.id + ')">加入配置车</button>' +
                        '</td>' +
                        '</tr>';
                    $productList.append(productRow);
                });
                setupPagination(); // 调用分页设置函数
            } else {
                alert('加载商品失败: ' + json.message);
            }
        },
        error: function () {
            alert('加载商品失败，服务器错误');
        }
    });
}

function updateCategoryCount(ancestorId = '', parentId = '', childId = '') {
    var url = '/products/count_productAll';

    if (childId) {
        url = '/products/count_productCh/' + childId;
    } else if (parentId) {
        url = '/products/count_productPa/' + parentId;
    } else if (ancestorId) {
        url = '/products/count_productAn/' + ancestorId;
    }

    $.ajax({
        url: url,
        type: 'GET',
        success: function (json) {
            if (json.state === 200) {
                $('#categoryCount').text('商品数量: ' + json.data);
            } else {
                alert('获取商品数量失败: ' + json.message);
            }
        },
        error: function () {
            alert('获取商品数量失败，服务器错误');
        }
    });
}

function setupPagination() {
    var url = '/products/count_productAll';
    var data = {};

    var ancestorId = $('#categorySelect1').val();
    var parentId = $('#categorySelect2').val();
    var childId = $('#categorySelect3').val();

    if (childId) {
        url = '/products/count_productCh/' + childId;
    } else if (parentId) {
        url = '/products/count_productPa/' + parentId;
    } else if (ancestorId) {
        url = '/products/count_productAn/' + ancestorId;
    }

    $.ajax({
        url: url,
        type: 'GET',
        data: data,
        success: function (json) {
            if (json.state === 200) {
                var totalCount = json.data;
                totalPages = Math.ceil(totalCount / pageSize);
                var $pagination = $('#pagination .pagination');
                $pagination.empty();

                // Previous page button
                if (currentPage > 1) {
                    $pagination.append('<li><a href="#" data-page="' + (currentPage - 1) + '">&laquo; 上一页</a></li>');
                }

                // Page number buttons
                for (var i = 1; i <= totalPages; i++) {
                    var activeClass = (i === currentPage) ? ' class="active"' : '';
                    $pagination.append('<li' + activeClass + '><a href="#" data-page="' + i + '">' + i + '</a></li>');
                }

                // Next page button
                if (currentPage < totalPages) {
                    $pagination.append('<li><a href="#" data-page="' + (currentPage + 1) + '">下一页 &raquo;</a></li>');
                }
            } else {
                alert('获取总数失败: ' + json.message);
            }
        },
        error: function () {
            alert('获取总数失败，服务器错误');
        }
    });
}