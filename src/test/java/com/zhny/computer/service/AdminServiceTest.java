package com.zhny.computer.service;


import com.zhny.computer.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)

public class AdminServiceTest {
    @Autowired
    private AdminService adminService;
    private UserService userService;
    @Test
    public void insertCaseProducts() {
        Integer adminId = 2;  // 假设管理员ID
        String adminName = "admin";

        // 品牌
        String[] brands = {"先马", "长城", "玩嘉", "机械大师"};

        // 规格及对应价格
        Map<String, Integer> specPriceMap = new HashMap<>();
        specPriceMap.put("24寸及以下", 150);
        specPriceMap.put("24寸以上", 200);

        // 对应的 parentId 和 childId
        int parentId24Inches = 81; // 24寸及以下
        int parentIdAbove24Inches = 82; // 24寸以上

        int[] childIds24Inches = {811, 812}; // 海景房 和 非海景房
        int[] childIdsAbove24Inches = {821, 822}; // 海景房 和 非海景房

        // 插入数据
        insertCaseProductsForAdmin(adminId, adminName, brands, specPriceMap, parentId24Inches, childIds24Inches, parentIdAbove24Inches, childIdsAbove24Inches);
    }

    private void insertCaseProductsForAdmin(
            Integer adminId, String adminName, String[] brands,
            Map<String, Integer> specPriceMap,
            int parentId24Inches, int[] childIds24Inches,
            int parentIdAbove24Inches, int[] childIdsAbove24Inches
    ) {
        int brandCount = brands.length;

        for (Map.Entry<String, Integer> entry : specPriceMap.entrySet()) {
            String spec = entry.getKey();
            int basePrice = entry.getValue();

            for (int i = 0; i < brandCount; i++) {
                String brand = brands[i];
                // 根据品牌顺序调整价格
                long price = basePrice + i * 20;

                int[] childIds = spec.equals("24寸及以下") ? childIds24Inches : childIdsAbove24Inches;
                int parentId = spec.equals("24寸及以下") ? parentId24Inches : parentIdAbove24Inches;

                for (int j = 0; j < childIds.length; j++) {
                    int childId = childIds[j];
                    String itemType = (childId == childIds[0]) ?
                            String.format("%s海景房机箱", brand) :
                            String.format("%s机箱", brand);

                    // 插入产品
                    insertCaseProduct(adminId, adminName, parentId, childId, itemType, price);
                }
            }
        }
    }

    private void insertCaseProduct(
            Integer adminId, String adminName, Integer parentId, Integer childId, String itemType, long price
    ) {
        Product product = new Product();
        product.setAncestorId(8);
        product.setParentId(parentId);
        product.setChildId(childId);
        product.setItemType(itemType);
        product.setPrice(price);
        product.setImage("bm");
        product.setStatus(1);
        product.setCreatedUser(adminName);
        product.setModifiedUser(adminName);
        product.setCreatedTime(new Date());
        product.setModifiedTime(new Date());

        adminService.insertProduct(adminId, adminName, product);
    }

}
