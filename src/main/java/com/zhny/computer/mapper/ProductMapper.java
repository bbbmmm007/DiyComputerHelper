package com.zhny.computer.mapper;

import com.zhny.computer.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    //通过商品id查询商品信息
    Product findById(Integer id);

    Product showAllProductId(Integer id);

    //统计所有商品数量
    Integer countShowProduct(Integer status);

    //统计搜索的商品数量
    Integer countSearchProduct(String itemType);

    //统计对应主类所有商品数量
    Integer countFindByAnId(@Param("ancestorId") Integer ancestorId);

    //统计对应父类所有商品数量
    Integer countFindByPaId(@Param("parentId") Integer parentId);

    //统计对应子类所有商品数量
    Integer countFindByChId(@Param("childId") Integer childId);

    //统计搜索商品和其祖类的总数
    Integer countSchByAnId(@Param("itemType") String itemType, @Param("ancestorId") Integer ancestorId);

    //统计搜索商品和其父类的总数
    Integer countSchByPaId(@Param("itemType") String itemType, @Param("parentId") Integer parentId);

    //统计搜索商品和其子类的总数
    Integer countSchByChId(@Param("itemType") String itemType, @Param("childId") Integer childId);

    //展示所有商品
    List<Product> showProductFen(@Param("status") Integer status,
                                 @Param("pageSize") Integer pageSize,
                                 @Param("offset") Integer offset);
    //通过商品关键字搜索商品
    List<Product> searchProductFen(@Param("itemType") String itemType,
                                   @Param("pageSize") Integer pageSize,
                                   @Param("offset") Integer offset);
    //通过子分类id查询对应商品
    List<Product> findByAnIdFen(@Param("ancestorId") Integer ancestorId,
                                @Param("pageSize") Integer pageSize,
                                @Param("offset") Integer offset);
    //通过父分类id查询对应商品
    List<Product> findByPaIdFen(@Param("parentId") Integer parentId,
                                @Param("pageSize") Integer pageSize,
                                @Param("offset") Integer offset);
    //通过祖分类id查询对应商品
    List<Product> findByChIdFen(@Param("childId") Integer childId,
                                @Param("pageSize") Integer pageSize,
                                @Param("offset") Integer offset);

    //通过子分类id和关键字查询对应商品
    List<Product> schByAnIdFen(@Param("ancestorId") Integer ancestorId,
                               @Param("itemType") String itemType,
                               @Param("pageSize") Integer pageSize,
                               @Param("offset") Integer offset);

    //通过父分类id和关键字查询对应商品
    List<Product> schByPaIdFen(@Param("parentId") Integer parentId,
                               @Param("itemType") String itemType,
                               @Param("pageSize") Integer pageSize,
                               @Param("offset") Integer offset);

    //通过祖分类i和关键字d查询对应商品
    List<Product> schByChIdFen(@Param("childId") Integer childId,@Param("itemType") String itemType, @Param("pageSize") Integer pageSize, @Param("offset") Integer offset);
   //选择cpu
    Product autoSelectBestValueD4IntelCPU( @Param("minCPUBudget") Integer minCPUBudget, @Param("maxCPUBudget") Integer maxCPUBudget,@Param("priceOrder") String priceOrder);
    Product autoSelectBestValueD4D5IntelCPU( @Param("minCPUBudget") Integer minCPUBudget, @Param("maxCPUBudget") Integer maxCPUBudget,@Param("priceOrder") String priceOrder);
    Product autoSelectBestValueD5AmdCPU( @Param("minCPUBudget") Integer minCPUBudget, @Param("maxCPUBudget") Integer maxCPUBudget,@Param("priceOrder") String priceOrder);
    Product autoSelectBestValueD4AmdCPU(@Param("minCPUBudget") Integer minCPUBudget, @Param("maxCPUBudget") Integer maxCPUBudget,@Param("priceOrder") String priceOrder);
    //选择显卡
    Product autoSelectBestValue16GPU( @Param("parentId") Integer parentId,@Param("childId") Integer childId,@Param("minGPUBudget") Integer minGPUBudget, @Param("maxGPUBudget") Integer maxGPUBudget,@Param("priceOrder") String priceOrder);
    Product autoSelectBestValue12GPU( @Param("parentId") Integer parentId,@Param("childId") Integer childId,@Param("minGPUBudget") Integer minGPUBudget, @Param("maxGPUBudget") Integer maxGPUBudget,@Param("priceOrder") String priceOrder);
    Product autoSelectBestValue8GPU( @Param("parentId") Integer parentId,@Param("childId") Integer childId,@Param("minGPUBudget") Integer minGPUBudget, @Param("maxGPUBudget") Integer maxGPUBudget,@Param("priceOrder") String priceOrder);
    Product autoSelectBestValue4GPU( @Param("parentId") Integer parentId,@Param("childId") Integer childId,@Param("minGPUBudget") Integer minGPUBudget, @Param("maxGPUBudget") Integer maxGPUBudget,@Param("priceOrder") String priceOrder);
    //散热选择
    Product autoSelectBestValueCooler(@Param("parentId") Integer parentId,@Param("childId") Integer childId, @Param("minCoolingBudget") Integer minCoolingBudget,@Param("maxCoolingBudget") Integer maxCoolingBudget, @Param("order") String order);
    //cpu选择
    Product autoSelectBestValueIntel(@Param("parentId") Integer parentId,@Param("childId") Integer childId, @Param("minMotherboardBudget") Integer minMotherboardBudget, @Param("maxMotherboardBudget") Integer maxMotherboardBudget,@Param("order") String order);
    Product autoSelectBestValueAmd(@Param("parentId") Integer parentId,@Param("childId") Integer childId, @Param("minMotherboardBudget") Integer minMotherboardBudget, @Param("maxMotherboardBudget") Integer maxMotherboardBudget,@Param("order") String order);
    //机箱选择
    Product autoSelectBestValueCase(@Param("parentId") Integer parentId,@Param("childId") Integer childId, @Param("minCaseBudget") Integer minCaseBudget, @Param("maxCaseBudget") Integer maxCaseBudget, @Param("priceOrder") String priceOrder);
    //电源选择
    Product autoSelectBestValueSUE(@Param("supplySize") Integer supplySize,@Param("parentId") Integer parentId,@Param("childId") Integer childId, @Param("minSUEBudget") Integer minSUEBudget, @Param("maxSUEBudget") Integer maxSUEBudget, @Param("priceOrder") String priceOrder);
    //固态选择
    Product autoSelectBestValueSSD(@Param("parentId") Integer parentId,@Param("ssdSize") String ssdSize, @Param("minSsdBudget") Integer minSsdBudget,@Param("maxSsdBudget") Integer maxSsdBudget, @Param("order") String order);
    //内存选择
    Product autoSelectBestValueMemory(@Param("parentId") Integer parentId,@Param("childId") Integer childId,@Param("memorySize") Integer memorySize, @Param("minMemoryBudget") Integer minMemoryBudget,@Param("maxMemoryBudget") Integer maxMemoryBudget, @Param("order") String order);
}

