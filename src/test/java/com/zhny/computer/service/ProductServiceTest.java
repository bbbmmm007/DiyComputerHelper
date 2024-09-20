package com.zhny.computer.service;



import com.zhny.computer.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private AdminService adminService;
    @Test
    public  void main() {
        // 设置预算范围
        Integer minMemoryBudget = 0;
        Integer maxMemoryBudget = 20000;
        String order = "DESC";

        Product bm= productService.autoSelectBestValueIntel(42,423,minMemoryBudget,maxMemoryBudget,order);
        Product nm = productService.autoSelectBestValueAmd(41,413,minMemoryBudget,maxMemoryBudget,order);
        System.out.println(bm);
        System.out.println(nm);



}
}