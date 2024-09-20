function populateCategorySelect1() {
    var $categorySelect1 = $('#categorySelect1');
    for (var key in categories) {
        $categorySelect1.append('<option value="' + categories[key].id + '">' + key + '</option>');
    }
    // Trigger the change event to load initial categories and products
    $categorySelect1.change();
}

function updateCategorySelect2(ancestorId) {
    var $categorySelect2 = $('#categorySelect2');
    $categorySelect2.empty().append('<option value="">选择父分类</option>').prop('disabled', !ancestorId);
    if (ancestorId) {
        var ancestorData = getCategoryDataById(ancestorId);
        for (var key in ancestorData) {
            if (key !== "id") {
                $categorySelect2.append('<option value="' + key + '">' + ancestorData[key].name + '</option>');
            }
        }
        $('#categorySelect3').empty().append('<option value="">选择子分类</option>').prop('disabled', true);
    }
}

function updateCategorySelect3(ancestorId, parentId) {
    var $categorySelect3 = $('#categorySelect3');
    $categorySelect3.empty().append('<option value="">选择子分类</option>').prop('disabled', !parentId);
    if (parentId) {
        var parentData = getCategoryDataById(parentId, ancestorId);
        for (var key in parentData.children) {
            $categorySelect3.append('<option value="' + key + '">' + parentData.children[key] + '</option>');
        }
    }
}

function getCategoryDataById(id, ancestorId) {
    if (ancestorId) {
        return Object.values(categories).find(category => category.id === ancestorId)[id];
    } else {
        return Object.values(categories).find(category => category.id === id);
    }
}