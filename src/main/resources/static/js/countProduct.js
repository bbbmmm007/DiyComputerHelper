// pagination.js
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
