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
                        '<button class="btn btn-warning" onclick="editProduct(' + product.id + ')">编辑</button>' +
                        ' <button class="btn btn-danger" onclick="deleteProduct(' + product.id + ')">删除</button>' +
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





