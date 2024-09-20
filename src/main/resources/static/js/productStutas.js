// 初始化收藏和配置车状态（从 localStorage 或服务端加载）
let collectionIds = new Set(JSON.parse(localStorage.getItem('collectionIds')) || []);
let cartIds = new Set(JSON.parse(localStorage.getItem('cartIds')) || []);

// 加入收藏函数
function addToCollection(productId) {
    $.ajax({
        url: '/collections/add_collection',
        type: 'POST',
        data: { id: productId },
        success: function (json) {
            if (json.state === 200) {
                alert('商品已加入收藏');
                collectionIds.add(productId); // 更新本地状态
                localStorage.setItem('collectionIds', JSON.stringify(Array.from(collectionIds))); // 同步到 localStorage
                updateProductState(productId); // 更新商品状态
            } else {
                alert('加入收藏失败: ' + json.message);
            }
        },
        error: function () {
            alert('加入收藏失败，服务器错误');
        }
    });
}

// 加入配置车函数
function addToCart(productId) {
    $.ajax({
        url: '/carts/add_carts',
        type: 'POST',
        data: { id: productId },
        success: function (json) {
            if (json.state === 200) {
                alert('商品已加入配置车');
                cartIds.add(productId); // 更新本地状态
                localStorage.setItem('cartIds', JSON.stringify(Array.from(cartIds))); // 同步到 localStorage
                updateProductState(productId); // 更新商品状态
            } else {
                alert('加入配置车失败: ' + json.message);
            }
        },
        error: function () {
            alert('加入配置车失败，服务器错误');
        }
    });
}

// 移除收藏或配置车中的商品时，更新全局状态
function removeFromCollection(productId) {
    collectionIds.delete(productId);
    localStorage.setItem('collectionIds', JSON.stringify(Array.from(collectionIds)));
    updateProductState(productId);
}

function removeFromCart(productId) {
    cartIds.delete(productId);
    localStorage.setItem('cartIds', JSON.stringify(Array.from(cartIds)));
    updateProductState(productId);
}

// 更新商品状态的函数
function updateProductState(productId) {
    if (collectionIds.has(productId)) {
        // 显示已加入收藏状态
        $('#product-' + productId).find('.collection-button').text('已加入收藏').prop('disabled', true);
    } else {
        // 显示加入收藏按钮
        $('#product-' + productId).find('.collection-button').text('加入收藏').prop('disabled', false);
    }

    if (cartIds.has(productId)) {
        // 显示已加入配置车状态
        $('#product-' + productId).find('.cart-button').text('已加入配置车').prop('disabled', true);
    } else {
        // 显示加入配置车按钮
        $('#product-' + productId).find('.cart-button').text('加入配置车').prop('disabled', false);
    }
}

// 页面加载时，同步所有商品的状态
$(document).ready(function () {
    $('.product-row').each(function () {
        const productId = $(this).data('product-id');
        updateProductState(productId); // 根据全局状态更新每个商品的按钮状态
    });
});
