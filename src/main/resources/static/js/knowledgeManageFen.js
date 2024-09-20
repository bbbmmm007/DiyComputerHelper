// productManager.js
var pageSize = 10; // 每页显示的商品数量
var totalPages = 1; // 总页数，初始为1
var currentPage = 1; // 当前页数，初始为1

function loadProducts(pageNumber, ancestorId = '') {
    var url = '/knowledges/show_all_knowledgeF/' + pageNumber + '/' + pageSize;

    if (ancestorId) {
        url = '/knowledges/show_knowledgeF/' + ancestorId + '/' + pageNumber + '/' + pageSize;
    }

    $.ajax({
        url: url,
        type: 'GET',
        success: function (json) {
            if (json.state === 200) {
                var knowledges = json.data;
                var $knowledgeList = $('#knowledgeList');
                $knowledgeList.empty();
                $.each(knowledges, function (index, knowledge) {
                    var knowledgeRow = '<tr id="product-' + product.knid + '">' +
                        '<td>' + knowledge.knid + '</td>' +
                        '<td>' + knowledge.topic + '</td>' +
                        '<td>' + knowledge.content + '</td>' +
                        '<td>' +
                        '<button class="btn btn-warning" onclick="editKnowledge(' + knowledge.knid + ')">编辑</button>' +
                        ' <button class="btn btn-danger" onclick="deleteKnowledge(' + knowledge.knid + ')">删除</button>' +
                        '</td>' +
                        '</tr>';
                    $knowledgeList.append(knowledgeRow);
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


function updateCategoryCount(ancestorId = '') {
    var url = '/knowledges/count_all_knowledge/';
    if (ancestorId) {
        url = '/knowledges/count_knowledge/' + ancestorId;
    }

    $.ajax({
        url: url,
        type: 'GET',
        success: function (json) {
            if (json.state === 200) {
                $('#categoryCount').text('词条数量: ' + json.data);
            } else {
                alert('获取词条数量失败: ' + json.message);
            }
        },
        error: function () {
            alert('获取词条数量失败，服务器错误');
        }
    });
}




