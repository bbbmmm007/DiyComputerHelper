// 填充祖分类下拉选择框
function populateCategorySelect1() {
    var $categorySelect1 = $('#categorySelect1');
    $categorySelect1.empty().append('<option value="">选择祖分类</option>');  // 添加默认提示项
    for (var key in categories) {
        $categorySelect1.append('<option value="' + categories[key].id + '">' + key + '</option>');
    }
    // Trigger the change event to load initial products
    $categorySelect1.change();
}

// 获取根据祖分类ID选择的分类数据
function getCategoryDataById(id) {
    return Object.values(categories).find(category => category.id === id);
}

// 更新页面其他部分（比如商品列表）的逻辑可以继续基于祖分类来实现
$('#categorySelect1').change(function () {
    var ancestorId = $(this).val();
    if (ancestorId) {
        var ancestorData = getCategoryDataById(ancestorId);
        console.log("当前选择的祖分类: ", ancestorData);
        // 这里可以基于选择的祖分类加载相关的商品或进行其他操作
        // loadProducts(ancestorId); // 例如：加载该祖分类下的商品
    } else {
        console.log("未选择祖分类");
        // 清空或重置商品列表等操作
    }
});
