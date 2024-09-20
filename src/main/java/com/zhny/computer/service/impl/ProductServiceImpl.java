package com.zhny.computer.service.impl;


import com.zhny.computer.entity.Product;
import com.zhny.computer.mapper.ProductMapper;
import com.zhny.computer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    //根据商品id查询商品
    @Override
    public Product findById(Integer id) {
        Product product = productMapper.findById(id);
        product.setId(null);
        product.setAncestorId(null);
        product.setParentId(null);
        product.setChildId(null);
        product.setStatus(null);

        return product;
    }
    //统计所有商品总数
    @Override
    public Integer countShowProduct() {
        return productMapper.countShowProduct(1);
    }
    //统计搜索商品的总数
    @Override
    public Integer countSearchProduct(String itemType) {
        return productMapper.countSearchProduct(itemType);
    }
    //统计该祖类所有商品数量
    @Override
    public Integer countFindByAnId(Integer ancestorId) {
        return productMapper.countFindByAnId(ancestorId);
    }
    //统计该父类所有商品数量
    @Override
    public Integer countFindByPaId(Integer parentId) {
        return productMapper.countFindByPaId(parentId);
    }
    //统计该子类所有商品数量
    @Override
    public Integer countFindByChId(Integer childId) {
        return productMapper.countFindByChId(childId);
    }
    //统计搜索商品和其祖类的总数
    @Override
    public Integer countSchByAnId(String itemType, Integer ancestorId) {
        return productMapper.countSchByAnId(itemType, ancestorId);
    }
    //统计搜索商品和其父类的总数
    @Override
    public Integer countSchByPaId(String itemType, Integer parentId) {
        return productMapper.countSchByPaId(itemType, parentId);
    }
    //统计搜索商品和其子类的总数
    @Override
    public Integer countSchByChId(String itemType, Integer childId) {
        return productMapper.countSchByChId(itemType, childId);
    }

    //展示所有商品
    @Override
    public List<Product> showProductFen(Integer pageNumber, Integer pageSize) {
        Integer offset = (pageNumber - 1) * pageSize;//pageNumber表示你想查询第几页  pageSize每页查询多少条数据
        return productMapper.showProductFen(1,pageSize,offset);
    }
    //搜索商品
    @Override
    public List<Product> searchProductFen(String itemType,Integer pageNumber, Integer pageSize) {
        Integer offset = (pageNumber - 1) * pageSize;
        return productMapper.searchProductFen(itemType,pageSize,offset);

    }
    //根据祖id查询商品
    @Override
    public List<Product> findByAnIdFen(Integer ancestorId,Integer pageNumber, Integer pageSize) {
        Integer offset = (pageNumber - 1) * pageSize;
        return productMapper.findByAnIdFen(ancestorId,pageSize,offset);
    }
    //根据父id查询商品
    @Override
    public List<Product> findByPaIdFen(Integer parentId,Integer pageNumber, Integer pageSize) {
        Integer offset = (pageNumber - 1) * pageSize;
        return productMapper.findByPaIdFen(parentId,pageSize,offset);
    }
    //根据子id查询商品
    @Override
    public List<Product> findByChIdFen(Integer childId,Integer pageNumber, Integer pageSize) {
        Integer offset = (pageNumber - 1) * pageSize;
        return productMapper.findByChIdFen(childId,pageSize,offset);
    }
    //根据祖id和关键字查询商品
    @Override
    public List<Product> schByAnIdFen(Integer ancestorId, String itemType, Integer pageNumber, Integer pageSize) {
        Integer offset = (pageNumber - 1) * pageSize;
        return productMapper.schByAnIdFen(ancestorId,itemType,pageSize,offset);
    }
    //根据父id和关键字查询商品
    @Override
    public List<Product> schByPaIdFen(Integer parentId, String itemType, Integer pageNumber, Integer pageSize) {
        Integer offset = (pageNumber - 1) * pageSize;
        return productMapper.schByPaIdFen(parentId,itemType,pageSize,offset);
    }
    //根据子id和关键字查询商品
    @Override
    public List<Product> schByChIdFen(Integer childId, String itemType, Integer pageNumber, Integer pageSize) {
        Integer offset = (pageNumber - 1) * pageSize;
        return productMapper.schByChIdFen(childId,itemType,pageSize,offset);
    }



    @Override
    public Product autoSelectBestValueD4IntelCPU(Integer minCPUBudget, Integer maxCPUBudget,String priceOrder) {
        return productMapper.autoSelectBestValueD4IntelCPU(minCPUBudget, maxCPUBudget,priceOrder);
    }

    @Override
    public Product autoSelectBestValueD4D5IntelCPU(Integer minCPUBudget, Integer maxCPUBudget,String priceOrder) {
        return productMapper.autoSelectBestValueD4D5IntelCPU(minCPUBudget, maxCPUBudget,priceOrder);
    }

    @Override
    public Product autoSelectBestValueD5AmdCPU(Integer minCPUBudget, Integer maxCPUBudget,String priceOrder) {
        return productMapper.autoSelectBestValueD5AmdCPU(minCPUBudget, maxCPUBudget,priceOrder);
    }

    @Override
    public Product autoSelectBestValueD4AmdCPU(Integer minCPUBudget, Integer maxCPUBudget,String priceOrder) {
        return productMapper.autoSelectBestValueD4AmdCPU(minCPUBudget, maxCPUBudget,priceOrder);
    }

    @Override
    public Product autoSelectBestValue16GPU(Integer parentId,Integer childId, Integer minGPUBudget, Integer maxGPUBudget, String priceOrder) {
        return productMapper.autoSelectBestValue16GPU(parentId,childId,minGPUBudget,maxGPUBudget,priceOrder);
    }

    @Override
    public Product autoSelectBestValue12GPU(Integer parentId,Integer childId, Integer minGPUBudget, Integer maxGPUBudget, String priceOrder) {
        return productMapper.autoSelectBestValue12GPU(parentId,childId,minGPUBudget,maxGPUBudget,priceOrder);
    }

    @Override
    public Product autoSelectBestValue8GPU(Integer parentId,Integer childId, Integer minGPUBudget, Integer maxGPUBudget, String priceOrder) {
        return productMapper.autoSelectBestValue8GPU(parentId,childId,minGPUBudget,maxGPUBudget,priceOrder);
    }

    @Override
    public Product autoSelectBestValue4GPU(Integer parentId,Integer childId, Integer minGPUBudget, Integer maxGPUBudget, String priceOrder) {
        return productMapper.autoSelectBestValue4GPU(parentId,childId,minGPUBudget,maxGPUBudget,priceOrder);
    }


    @Override
    public Product autoSelectBestValueCooler(Integer parentId,Integer childId, Integer minCoolingBudget, Integer maxCoolingBudget,String order) {
        return productMapper.autoSelectBestValueCooler(parentId,childId, minCoolingBudget, maxCoolingBudget,order);
    }

    //选择intel主板
    @Override
    public Product autoSelectBestValueIntel(Integer parentId, Integer childId, Integer minMotherboardBudget, Integer maxMotherboardBudget, String order) {
        return productMapper.autoSelectBestValueIntel(parentId, childId, minMotherboardBudget, maxMotherboardBudget,order);
    }
    //选择amd主板
    @Override
    public Product autoSelectBestValueAmd(Integer parentId, Integer childId, Integer minMotherboardBudget, Integer maxMotherboardBudget, String order) {
        return productMapper.autoSelectBestValueAmd(parentId, childId, minMotherboardBudget, maxMotherboardBudget,order);
    }

    //机箱选择
    @Override
    public Product autoSelectBestValueCase(Integer parentId, Integer childId, Integer minCaseBudget, Integer maxCaseBudget, String priceOrder) {
        return productMapper.autoSelectBestValueCase(parentId,childId,minCaseBudget,maxCaseBudget,priceOrder);
    }
    //电源选择
    @Override
    public Product autoSelectBestValueSUE(Integer supplySize, Integer parentId, Integer childId, Integer minSUEBudget, Integer maxSUEBudget, String priceOrder) {
        return productMapper.autoSelectBestValueSUE(supplySize,parentId,childId,minSUEBudget,maxSUEBudget,priceOrder);
    }


    //固态选择
    @Override
    public Product autoSelectBestValueSSD(Integer parentId, String ssdSize, Integer minSsdBudget, Integer maxSsdBudget, String order) {
        return productMapper.autoSelectBestValueSSD(parentId, ssdSize, minSsdBudget, maxSsdBudget, order);
    }

    //内存选择
    @Override
    public Product autoSelectBestValueMemory(Integer parentId,Integer childId,Integer memorySize, Integer minMemoryBudget, Integer maxMemoryBudget, String order) {
        return productMapper.autoSelectBestValueMemory(parentId,childId,memorySize, minMemoryBudget, maxMemoryBudget, order);
    }

}
