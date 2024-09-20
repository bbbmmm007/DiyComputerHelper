// 状态管理
var collectionIds = new Set(); // 存储已加入收藏的商品 ID
var cartIds = new Set(); // 存储已加入购物车的商品 ID
// 加入收藏函数
window.addToCollection = function (productId) {
    $.ajax({
        url: '/collections/add_collection',
        type: 'POST',
        data: { id: productId },
        success: function (json) {
            if (json.state === 200) {
                alert('商品已加入收藏');
                collectionIds.add(productId); // 更新收藏状态
                updateProductRow(productId); // 更新商品行
            } else {
                alert('加入收藏失败: ' + json.message);
            }
        },
        error: function () {
            alert('加入收藏失败，服务器错误');
        }
    });
};

// 加入购物车函数
window.addToCart = function (productId) {
    $.ajax({
        url: '/carts/add_carts',
        type: 'POST',
        data: { id: productId },
        success: function (json) {
            if (json.state === 200) {
                alert('商品已加入购物车');
                cartIds.add(productId); // 更新购物车状态
                updateProductRow(productId); // 更新商品行
            } else {
                alert('加入购物车失败: ' + json.message);
            }
        },
        error: function () {
            alert('加入购物车失败，服务器错误');
        }
    });
};