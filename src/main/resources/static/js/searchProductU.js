function loadProducts(itemType, pageNumber, ancestorId = '', parentId = '', childId = '') {
    var url = '/products/rearch_productSF/' + itemType + '/' + pageNumber + '/' + pageSize;

    if (childId) {
        url = '/products/show_ch_productsCFS/' + childId + '/' + itemType + '/' + pageNumber + '/' + pageSize;
    } else if (parentId) {
        url = '/products/show_pa_productsPFS/' + parentId + '/' + itemType + '/' + pageNumber + '/' + pageSize;
    } else if (ancestorId) {
        url = '/products/show_an_productsAFS/' + ancestorId + '/' + itemType + '/' + pageNumber + '/' + pageSize;
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
                // 调用分页设置函数，并传递正确的参数
                // 实时更新商品数量
                updateCategoryCount(itemType, ancestorId, parentId, childId);
                setupPagination(itemType, ancestorId, parentId, childId);
            } else {
                clearProductsAndPagination(); // 如果没有结果，清空商品列表和分页控件
                alert('没有找到相关商品');
            }
        },
        error: function () {
            clearProductsAndPagination(); // 如果请求失败，清空商品列表和分页控件
            alert('加载商品失败，服务器错误');
        }
    });
}