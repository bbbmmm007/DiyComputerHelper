// pagination.js
function setupPagination() {
    var url = '/knowledges/count_all_knowledge/';
    var ancestorId = $('#categorySelect1').val();

    if (ancestorId) {
        url = '/knowledges/count_knowledge/' + ancestorId;
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
            } else {
                alert('获取总数失败: ' + json.message);
            }
        },
        error: function () {
            alert('获取总数失败，服务器错误');
        }
    });
}

