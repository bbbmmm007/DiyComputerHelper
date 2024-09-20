package com.zhny.computer.service;
import com.zhny.computer.entity.Product;
import java.util.List;


public interface ProductService {
    //根据商品id查询商品相关信息
    Product findById(Integer id);
    //统计所有商品数量
    Integer countShowProduct();
    //统计搜索的商品数量
    Integer countSearchProduct(String itemType);
    //统计对应主类所有商品数量
    Integer countFindByAnId(Integer ancestorId);
    //统计对应父类所有商品数量
    Integer countFindByPaId(Integer parentId);
    //统计对应子类所有商品数量
    Integer countFindByChId(Integer childId);
    //统计搜索商品和其祖类的总数
    Integer countSchByAnId(String itemType,Integer ancestorId);
    //统计搜索商品和其父类的总数
    Integer countSchByPaId(String itemType,Integer parentId);
    //统计搜索商品和其子类的总数
    Integer countSchByChId(String itemType,Integer childId);
    //展示所有商品
    List<Product> showProductFen(Integer pageNumber, Integer pageSize);
    //根据关键字查询商品
    List<Product> searchProductFen(String itemType,Integer pageNumber, Integer pageSize);
    //根据祖id查询对应商品
    List<Product> findByAnIdFen(Integer ancestorId,Integer pageNumber, Integer pageSize);
    //根据父id查询对应商品
    List<Product> findByPaIdFen(Integer parentId,Integer pageNumber, Integer pageSize);
    //根据子id查询对应商品
    List<Product> findByChIdFen(Integer childId,Integer pageNumber, Integer pageSize);
    //通过子分类id和关键字查询对应商品
    List<Product> schByAnIdFen(Integer ancestorId,String itemType, Integer pageNumber,Integer pageSize);
    //通过父分类id和关键字查询对应商品
    List<Product> schByPaIdFen(Integer parentId, String itemType,Integer pageNumber,Integer pageSize);
    //通过祖分类i和关键字d查询对应商品
    List<Product> schByChIdFen(Integer childId, String itemType, Integer pageNumber,Integer pageSize);
    // CPU选择
    Product autoSelectBestValueD4IntelCPU(Integer minCPUBudget, Integer maxCPUBudget,String priceOrder);
    Product autoSelectBestValueD4D5IntelCPU(Integer minCPUBudget, Integer maxCPUBudget,String priceOrder);
    Product autoSelectBestValueD5AmdCPU(Integer minCPUBudget, Integer maxCPUBudget,String priceOrder);
    Product autoSelectBestValueD4AmdCPU(Integer minCPUBudget, Integer maxCPUBudget,String priceOrder);
    // GPU选择
    Product autoSelectBestValue16GPU(Integer parentId,Integer childId,Integer minGPUBudget, Integer maxGPUBudget,String priceOrder);
    Product autoSelectBestValue12GPU( Integer parentId,Integer childId,Integer minGPUBudget, Integer maxGPUBudget,String priceOrder);
    Product autoSelectBestValue8GPU( Integer parentId,Integer childId,Integer minGPUBudget, Integer maxGPUBudget,String priceOrder);
    Product autoSelectBestValue4GPU( Integer parentId,Integer childId,Integer minGPUBudget, Integer maxGPUBudget, String priceOrder);
    // 散热器选择
    Product autoSelectBestValueCooler(Integer parentId,Integer childId, Integer minCoolingBudget, Integer maxCoolingBudget, String order);
    // 主板选择
    Product autoSelectBestValueIntel(Integer parentId,Integer childId,Integer minMotherboardBudget, Integer maxMotherboardBudget,String order);
    Product autoSelectBestValueAmd(Integer parentId,Integer childId,Integer minMotherboardBudget, Integer maxMotherboardBudget,String order);
    // 机箱选择
    Product autoSelectBestValueCase(Integer parentId,Integer childId, Integer minCaseBudget, Integer maxCaseBudget, String priceOrder);
    //电源选择
    Product autoSelectBestValueSUE(Integer supplySize,Integer parentId,Integer childId, Integer minSUEBudget,  Integer maxSUEBudget, String priceOrder);
    //固态选择
    Product autoSelectBestValueSSD( Integer parentId,String ssdSize, Integer minSsdBudget,Integer maxSsdBudget, String order);
    //内存选择
    Product autoSelectBestValueMemory(Integer parentId,Integer childId,Integer memorySize, Integer minMemoryBudget, Integer maxMemoryBudget, String order);

}
