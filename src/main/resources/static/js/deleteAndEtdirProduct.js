function editProduct(productId) {
    window.location.href = "adminEditProduct.html?id=" + productId;
}

function deleteProduct(productId) {
    if (confirm("确定要删除这个商品吗？")) {
        $.ajax({
            url: '/admin/delete_product/' + productId, // 删除商品的接口地址
            type: 'POST', // 确保你的后端接口支持 POST 或 DELETE 方法
            success: function (response) {
                if (response.state === 200) {
                    alert('商品删除成功');
                    $('#product-' + productId).remove(); // 删除页面上的该商品行
                    updateCategoryCount(); // 更新分类下的商品数量
                } else {
                    alert('删除商品失败: ' + response.message);
                }
            },
            error: function () {
                alert('删除商品失败，服务器错误');
            }
        });
    }
}