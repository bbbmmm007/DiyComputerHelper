
// 清空商品列表和分页控件
function clearProductsAndPagination() {
    $('#productList').empty(); // 清空商品列表
    $('#pagination .pagination').empty(); // 清空分页按钮
    $('#categoryCount').text('商品数量: 0'); // 重置商品数量
}

// 更新商品数量
function updateCategoryCount(itemType, ancestorId = '', parentId = '', childId = '') {
    var url = '/products/count_productSch/' + itemType;

    if (childId) {
        url = '/products/count_productChS/' + itemType + '/' + childId;
    } else if (parentId) {
        url = '/products/count_productPaS/' + itemType + '/' + parentId;
    } else if (ancestorId) {
        url = '/products/count_productAnS/' + itemType + '/' + ancestorId;
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


// 统计该页的商品的数量
function setupPagination(itemType, ancestorId = '', parentId = '', childId = '') {
    var url = '/products/count_productSch/' + itemType;

    if (childId) {
        url = '/products/count_productChS/' + itemType + '/' + childId;
    } else if (parentId) {
        url = '/products/count_productPaS/' + itemType + '/' + parentId;
    } else if (ancestorId) {
        url = '/products/count_productAnS/' + itemType + '/' + ancestorId;
    }

    $.ajax({
        url: url,
        type: 'GET',
        success: function (json) {
            if (json.state === 200) {
                var totalCount = json.data;
                totalPages = Math.ceil(totalCount / pageSize);
                var $pagination = $('#pagination .pagination');
                $pagination.empty();

                // 上一页按钮
                if (currentPage > 1) {
                    $pagination.append('<li><a href="#" data-page="' + (currentPage - 1) + '">&laquo; 上一页</a></li>');
                }

                // 页码按钮
                for (var i = 1; i <= totalPages; i++) {
                    var activeClass = (i === currentPage) ? ' class="active"' : '';
                    $pagination.append('<li' + activeClass + '><a href="#" data-page="' + i + '">' + i + '</a></li>');
                }

                // 下一页按钮
                if (currentPage < totalPages) {
                    $pagination.append('<li><a href="#" data-page="' + (currentPage + 1) + '">下一页 &raquo;</a></li>');
                }

                // 重新绑定分页按钮的事件
                bindPaginationClick(itemType, ancestorId, parentId, childId);
            } else {
                alert('获取总数失败: ' + json.message);
            }
        },
        error: function () {
            alert('获取总数失败，服务器错误');
        }
    });
}

function bindPaginationClick(itemType, ancestorId, parentId, childId) {
    $(document).on('click', '.pagination a', function (event) {
        event.preventDefault();
        var page = $(this).data('page');
        if (page >= 1 && page <= totalPages) {
            currentPage = page;
            loadProducts(itemType, currentPage, ancestorId, parentId, childId);
        }
    });
}