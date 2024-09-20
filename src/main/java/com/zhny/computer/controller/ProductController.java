package com.zhny.computer.controller;

import com.zhny.computer.entity.Product;
import com.zhny.computer.service.ProductService;
import com.zhny.computer.service.util.JsonResult;
import com.zhny.computer.vo.ProfileCreateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController {
    @Autowired
    private ProductService productService;

    //根据行商品id显示商品信息
    @RequestMapping("/show_details/{id}")
    public JsonResult<Product> showDetails(@PathVariable("id") Integer id) {
        Product product = productService.findById(id);
        return new JsonResult<>(SUCCESS, product);
    }

    //返回所有商品总数
    @RequestMapping("/count_productAll")
    public JsonResult<Integer> countProductAll() {
        Integer countProductAll = productService.countShowProduct();
        return new JsonResult<>(SUCCESS, countProductAll);
    }

    //返回该祖类商品总数
    @RequestMapping("/count_productAn/{ancestorId}")
    public JsonResult<Integer> countProductAn(@PathVariable("ancestorId") Integer ancestorId) {
        Integer countProductAn = productService.countFindByAnId(ancestorId);
        return new JsonResult<>(SUCCESS, countProductAn);
    }

    //返回该父类商品总数
    @RequestMapping("/count_productPa/{parentId}")
    public JsonResult<Integer> countProductPa(@PathVariable("parentId") Integer parentId) {
        Integer countProductPa = productService.countFindByPaId(parentId);
        return new JsonResult<>(SUCCESS, countProductPa);
    }

    //返回该子类商品总数
    @RequestMapping("/count_productCh/{childId}")
    public JsonResult<Integer> countProductCh(@PathVariable("childId") Integer childId) {
        Integer countProductCh = productService.countFindByChId(childId);
        return new JsonResult<>(SUCCESS, countProductCh);
    }

    //返回搜索结果的商品总数
    @RequestMapping("/count_productSch/{itemType}")
    public JsonResult<Integer> countProductRe(@PathVariable("itemType") String itemType) {
        Integer countProductRe = productService.countSearchProduct(itemType);
        return new JsonResult<>(SUCCESS, countProductRe);
    }

    //返回该关键字祖类商品总数
    @RequestMapping("/count_productAnS/{itemType}/{ancestorId}")
    public JsonResult<Integer> countProductAnS(@PathVariable("itemType") String itemType, @PathVariable("ancestorId") Integer ancestorId) {
        Integer countProductAn = productService.countSchByAnId(itemType, ancestorId);
        return new JsonResult<>(SUCCESS, countProductAn);
    }

    //返回该关键字父类商品总数
    @RequestMapping("/count_productPaS/{itemType}/{parentId}")
    public JsonResult<Integer> countProductPaS(@PathVariable("itemType") String itemType, @PathVariable("parentId") Integer parentId) {
        Integer countProductPa = productService.countSchByPaId(itemType, parentId);
        return new JsonResult<>(SUCCESS, countProductPa);
    }

    //返回该关键字子类商品总数
    @RequestMapping("/count_productChS/{itemType}/{childId}")
    public JsonResult<Integer> countProductChS(@PathVariable("itemType") String itemType, @PathVariable("childId") Integer childId) {
        Integer countProductCh = productService.countSchByChId(itemType, childId);
        return new JsonResult<>(SUCCESS, countProductCh);
    }


    //分页展示搜索商品
    @RequestMapping("rearch_productSF/{itemType}/{pageNumber}/{pageSize}")
    public JsonResult<List<Product>> rearchProductF(@PathVariable("itemType") String itemType, @PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
        List<Product> products = productService.searchProductFen(itemType, pageNumber, pageSize);
        return new JsonResult<>(SUCCESS, products);
    }

    //分页展示所有商品
    @RequestMapping("show_productsALLF/{pageNumber}/{pageSize}")
    public JsonResult<List<Product>> showProductsF(@PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
        List<Product> products = productService.showProductFen(pageNumber, pageSize);
        return new JsonResult<>(SUCCESS, products);
    }

    //根据所选的祖ID分页展示商品
    @RequestMapping("show_an_productsAF/{ancestorId}/{pageNumber}/{pageSize}")
    public JsonResult<List<Product>> showAnProductsF(@PathVariable("ancestorId") Integer ancestorId, @PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
        List<Product> products = productService.findByAnIdFen(ancestorId, pageNumber, pageSize);
        return new JsonResult<>(SUCCESS, products);
    }

    //根据所选的父ID分页展示商品
    @RequestMapping("show_pa_productsPF/{parentId}/{pageNumber}/{pageSize}")
    public JsonResult<List<Product>> showPaProductsF(@PathVariable("parentId") Integer parentId, @PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
        List<Product> products = productService.findByPaIdFen(parentId, pageNumber, pageSize);
        return new JsonResult<>(SUCCESS, products);
    }

    //根据所选的子ID分页展示商品
    @RequestMapping("show_ch_productsCF/{childId}/{pageNumber}/{pageSize}")
    public JsonResult<List<Product>> showChProductsF(@PathVariable("childId") Integer childId, @PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
        List<Product> products = productService.findByChIdFen(childId, pageNumber, pageSize);
        return new JsonResult<>(SUCCESS, products);
    }

    //根据搜索关键字和所选的祖ID分页展示商品
    @RequestMapping("show_an_productsAFS/{ancestorId}/{itemType}/{pageNumber}/{pageSize}")
    public JsonResult<List<Product>> showAnProductsFS(@PathVariable("ancestorId") Integer ancestorId, @PathVariable("itemType") String itemType, @PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
        List<Product> products = productService.schByAnIdFen(ancestorId, itemType, pageNumber, pageSize);
        return new JsonResult<>(SUCCESS, products);
    }

    //根据搜索关键字和所选的父ID分页展示商品
    @RequestMapping("show_pa_productsPFS/{parentId}/{itemType}/{pageNumber}/{pageSize}")
    public JsonResult<List<Product>> showPaProductsFS(@PathVariable("parentId") Integer parentId, @PathVariable("itemType") String itemType, @PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
        List<Product> products = productService.schByPaIdFen(parentId, itemType, pageNumber, pageSize);
        return new JsonResult<>(SUCCESS, products);
    }

    //根据搜索关键字和所选的子ID分页展示商品
    @RequestMapping("show_ch_productsCFS/{childId}/{itemType}/{pageNumber}/{pageSize}")
    public JsonResult<List<Product>> showChProductsFS(@PathVariable("childId") Integer childId, @PathVariable("itemType") String itemType, @PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
        List<Product> products = productService.schByChIdFen(childId, itemType, pageNumber, pageSize);
        return new JsonResult<>(SUCCESS, products);
    }
    //定制化生成配置
    @RequestMapping("/auto_createProfileBySelect/")
    public JsonResult<Map<String, Object>> autoCreateProfileBySelect(@RequestBody ProfileCreateVO request) {
        // 获取用户的总预算
        Map<String, Object> config = new HashMap<>();
        // 获取用户的总预算
        Integer totalBudget = request.getTotalBudget();
        System.out.println(request);
        // Step 1: 查询最便宜的配件作为保底
        Product cpuBase = selectCheapCpu(request.getCpuType());
        Product gpuBase = selectCheapGpu(request.getGpuType(),request.getGpuModel(), request.getGpuSize());
        Product motherboardBase = selectCheapMotherboard(request.getMotherboardType(),request.getMotherboardVersion(),request.getMotherboardModel());
        Product memoryBase = selectCheapMemory(request.getMemoryType(),request.getMemoryModel(), request.getMemorySize());
        Product ssdBase = selectCheapSsd(request.getSsdType(),request.getSsdSize());
        Product coolerBase = selectCheapCooler(request.getCoolingType(),request.getCoolingSize());
        Product caseBase = selectCheapCase(request.getCaseType(),request.getCaseModel());
        Product psuBase = selectCheapSupplyE(request.getSupplySize(),request.getSupplyType(),request.getSupplyModel());
        // Step 2: 计算所有最低价格配件的总价（保底配置）
        long baseTotal = cpuBase.getPrice() + gpuBase.getPrice() + motherboardBase.getPrice() + memoryBase.getPrice() + ssdBase.getPrice() + coolerBase.getPrice() +caseBase.getPrice() + psuBase.getPrice();
        // Step 3: 如果预算不足以覆盖保底配置，直接返回保底配置
        if (totalBudget < baseTotal) {
            config.put("CPU", cpuBase);
            config.put("Motherboard", motherboardBase);
            config.put("GPU", gpuBase);
            config.put("Memory", memoryBase);
            config.put("SSD", ssdBase);
            config.put("Cooling", coolerBase);
            config.put("Case", caseBase);
            config.put("PowerSupply", psuBase);
            return new JsonResult<>(SUCCESS,config);
        }
        // Step 4: 预算足够时，逐步选择用户需求的较高价格商品
        System.out.println("保底配置："+config);
        int remainingBudget = totalBudget - (int)baseTotal;
        Map<String, Integer> budgetMap = allocateBudget(remainingBudget);
        Product cpu = selectCpu(request.getCpuType(), (int)(budgetMap.get("cpuMin") + cpuBase.getPrice()), (int)(budgetMap.get("cpuMax") + cpuBase.getPrice()));
        Product gpu = selectGpu(request.getGpuType(),request.getGpuModel(), request.getGpuSize(), (int)(budgetMap.get("gpuMin") + gpuBase.getPrice()), (int)(budgetMap.get("gpuMax") + gpuBase.getPrice()));
        Product motherboard = selectMotherboard(request.getMotherboardType(),request.getMotherboardVersion (),request.getMotherboardModel(),(int)(budgetMap.get("motherboardMin") + motherboardBase.getPrice()), (int)(budgetMap.get("motherboardMax") + motherboardBase.getPrice()));
        Product memory = selectMemory(request.getMemoryType(),request.getMemoryModel(), request.getMemorySize(), (int)(budgetMap.get("memoryMin") + memoryBase.getPrice()), (int)(budgetMap.get("memoryMax") + memoryBase.getPrice()));
        Product ssd = selectSsd(request.getSsdType(),request.getSsdSize(), (int)(budgetMap.get("ssdMin") + ssdBase.getPrice()), (int)(budgetMap.get("ssdMax") + ssdBase.getPrice()));
        Product cooling = selectCooler(request.getCoolingType(),request.getCoolingSize (),(int)(budgetMap.get("coolingMin") + coolerBase.getPrice()), (int)(budgetMap.get("coolingMax") + coolerBase.getPrice()));
        Product psu = selectSupplyE(request.getSupplySize(),request.getSupplyType(),request.getSupplyModel(),(int)(budgetMap.get("powerSupplyMin") + psuBase.getPrice()), (int)(budgetMap.get("powerSupplyMax") + psuBase.getPrice()));
        Product Case = selectCase(request.getCaseType(),request.getCaseModel(),(int)(budgetMap.get("caseMin") + psuBase.getPrice()), (int)(budgetMap.get("caseMax") + psuBase.getPrice()));
        System.out.println("cup预算:"+(int)(budgetMap.get("cpuMin") + cpuBase.getPrice())+'-'+(int)(budgetMap.get("cpuMax") + cpuBase.getPrice()));
        System.out.println("gpu预算:"+(int)(budgetMap.get("gpuMin") + gpuBase.getPrice())+'-'+(int)(budgetMap.get("gpuMax") + gpuBase.getPrice()));
        System.out.println("主板预算:"+(int)(budgetMap.get("motherboardMin") + motherboardBase.getPrice())+'-'+(int)(budgetMap.get("motherboardMax") + motherboardBase.getPrice()));
        System.out.println("内存预算:"+(int)(budgetMap.get("memoryMin") + memoryBase.getPrice())+'-'+(int)(budgetMap.get("memoryMax") + memoryBase.getPrice()));
        System.out.println("固态预算:"+(int)(budgetMap.get("ssdMin") + ssdBase.getPrice())+'-'+(int)(budgetMap.get("ssdMax") + ssdBase.getPrice()));
        System.out.println("散热器预算:"+(int)(budgetMap.get("coolingMin") + coolerBase.getPrice())+'-'+(int)(budgetMap.get("coolingMax") + coolerBase.getPrice()));
        System.out.println("电源预算:"+(int)(budgetMap.get("powerSupplyMin") + psuBase.getPrice())+'-'+(int)(budgetMap.get("powerSupplyMax") + psuBase.getPrice()));
        System.out.println("机箱预算"+(int)(budgetMap.get("caseMin") + psuBase.getPrice())+'-'+ (int)(budgetMap.get("caseMax") + psuBase.getPrice()));
        // Step 5: 将最终选择的配件配置到返回结果
        config.put("CPU", (cpu != null) ? cpu : cpuBase);
        config.put("Motherboard", (motherboard != null) ? motherboard : motherboardBase);
        config.put("GPU", (gpu != null) ? gpu : gpuBase);
        config.put("Memory", (memory != null) ? memory : memoryBase);
        config.put("SSD", (ssd != null) ? ssd : ssdBase);
        config.put("Cooling", (cooling != null) ? cooling : coolerBase);
        config.put("Case", (Case != null) ? Case : caseBase);
        config.put("PowerSupply", (psu != null) ? psu : psuBase);
        System.out.println("动态规划后的配置："+config);
        // 返回最终配置
        return new JsonResult<>(SUCCESS, config);
    }




    private Map<String, Integer> allocateBudget(Integer totalBudget) {
        // 定义初始预算分配比例
        double cpuPercentage = calculateCpuPercentage(totalBudget);
        double gpuPercentage = calculateGpuPercentage(totalBudget);
        double motherboardPercentage = calculateMotherboardPercentage(totalBudget);
        double memoryPercentage = 0.10;    // 内存固定10%
        double powerSupplyPercentage = 0.05; // 电源固定5%
        double ssdPercentage = 0.10;       // SSD 固定10%
        double coolingPercentage = 0.05;   // 散热器固定5%
        double casePercentage = 0.05;      // 机箱固定5%

        // 存储所有配件的预算
        Map<String, Integer> budgetMap = new HashMap<>();

        // 调用回溯算法分配预算
        boolean success = allocateWithBacktracking(totalBudget, budgetMap, cpuPercentage, gpuPercentage,
                motherboardPercentage, memoryPercentage, powerSupplyPercentage, ssdPercentage,
                coolingPercentage, casePercentage);

        if (!success) {
            System.out.println("未能找到满足所有配件需求的预算分配。");
        }

        return budgetMap;
    }

    // 动态调整 CPU 的预算比例
    private double calculateCpuPercentage(int totalBudget) {
        if (totalBudget > 10000) {
            return 0.30;  // 高预算时 CPU 占比提升到30%
        } else if (totalBudget > 6000) {
            return 0.25;  // 中等预算时 CPU 占比25%
        }
        return 0.20;  // 默认20%
    }

    // 动态调整 GPU 的预算比例
    private double calculateGpuPercentage(int totalBudget) {
        if (totalBudget > 20000) {
            return 0.40;  // 高预算时 GPU 占比40%
        } else if (totalBudget > 10000) {
            return 0.35;  // 中等预算时 GPU 占比35%
        }
        return 0.30;  // 默认30%
    }

    // 动态调整主板的预算比例
    private double calculateMotherboardPercentage(int totalBudget) {
        if (totalBudget > 20000) {
            return 0.20;  // 高预算时主板占比20%
        } else if (totalBudget > 10000) {
            return 0.18;  // 中等预算时主板占比18%
        }
        return 0.15;  // 默认15%
    }

    private boolean allocateWithBacktracking(int totalBudget, Map<String, Integer> budgetMap, double cpuPercentage,
                                             double gpuPercentage, double motherboardPercentage, double memoryPercentage,
                                             double powerSupplyPercentage, double ssdPercentage, double coolingPercentage,
                                             double casePercentage) {
        int remainingBudget = totalBudget;

        // 选择 CPU
        budgetMap.put("cpuMin", (int) (remainingBudget * cpuPercentage * 0.9));
        budgetMap.put("cpuMax", Math.min((int) (remainingBudget * cpuPercentage * 1.1), 5000));  // 加入上限控制
        remainingBudget -= budgetMap.get("cpuMax");

        // 选择 GPU
        budgetMap.put("gpuMin", (int) (remainingBudget * gpuPercentage * 0.9));
        budgetMap.put("gpuMax", Math.min((int) (remainingBudget * gpuPercentage * 1.1), 15000));  // 加入上限控制
        remainingBudget -= budgetMap.get("gpuMax");

        // 选择主板
        budgetMap.put("motherboardMin", (int) (remainingBudget * motherboardPercentage * 0.9));
        budgetMap.put("motherboardMax", Math.min((int) (remainingBudget * motherboardPercentage * 1.1), 5000));
        remainingBudget -= budgetMap.get("motherboardMax");

        if (remainingBudget < 0) {
            return backtrackAndAdjust(totalBudget, budgetMap, cpuPercentage, gpuPercentage, motherboardPercentage,
                    memoryPercentage, powerSupplyPercentage, ssdPercentage, coolingPercentage, casePercentage);
        }

        // 选择内存
        budgetMap.put("memoryMin", (int) (remainingBudget * memoryPercentage * 0.9));
        budgetMap.put("memoryMax", Math.min((int) (remainingBudget * memoryPercentage * 1.1), 2000));
        remainingBudget -= budgetMap.get("memoryMax");

        if (remainingBudget < 0) {
            return backtrackAndAdjust(totalBudget, budgetMap, cpuPercentage, gpuPercentage, motherboardPercentage,
                    memoryPercentage, powerSupplyPercentage, ssdPercentage, coolingPercentage, casePercentage);
        }

        // 选择电源
        budgetMap.put("powerSupplyMin", (int) (remainingBudget * powerSupplyPercentage * 0.9));
        budgetMap.put("powerSupplyMax", Math.min((int) (remainingBudget * powerSupplyPercentage * 1.1), 2000));
        remainingBudget -= budgetMap.get("powerSupplyMax");

        if (remainingBudget < 0) {
            return backtrackAndAdjust(totalBudget, budgetMap, cpuPercentage, gpuPercentage, motherboardPercentage,
                    memoryPercentage, powerSupplyPercentage, ssdPercentage, coolingPercentage, casePercentage);
        }

        // 选择 SSD
        budgetMap.put("ssdMin", (int) (remainingBudget * ssdPercentage * 0.9));
        budgetMap.put("ssdMax", Math.min((int) (remainingBudget * ssdPercentage * 1.1), 2000));
        remainingBudget -= budgetMap.get("ssdMax");

        if (remainingBudget < 0) {
            return backtrackAndAdjust(totalBudget, budgetMap, cpuPercentage, gpuPercentage, motherboardPercentage,
                    memoryPercentage, powerSupplyPercentage, ssdPercentage, coolingPercentage, casePercentage);
        }

        // 选择散热器
        budgetMap.put("coolingMin", (int) (remainingBudget * coolingPercentage * 0.9));
        budgetMap.put("coolingMax", Math.min((int) (remainingBudget * coolingPercentage * 1.1), 1000));
        remainingBudget -= budgetMap.get("coolingMax");

        if (remainingBudget < 0) {
            return backtrackAndAdjust(totalBudget, budgetMap, cpuPercentage, gpuPercentage, motherboardPercentage,
                    memoryPercentage, powerSupplyPercentage, ssdPercentage, coolingPercentage, casePercentage);
        }

        // 选择机箱
        budgetMap.put("caseMin", (int) (remainingBudget * casePercentage * 1.0));
        budgetMap.put("caseMax", Math.min((int) (remainingBudget * casePercentage * 1.0), 1500));

        return remainingBudget >= 0;
    }
    // 回溯并调整预算比例
    private boolean backtrackAndAdjust(int totalBudget, Map<String, Integer> budgetMap, double cpuPercentage,
                                       double gpuPercentage, double motherboardPercentage, double memoryPercentage,
                                       double powerSupplyPercentage, double ssdPercentage, double coolingPercentage,
                                       double casePercentage) {
        // 逐步降低上一个配件的预算比例以释放更多预算
        if (cpuPercentage > 0.10) {
            cpuPercentage -= 0.05;
        } else if (gpuPercentage > 0.15) {
            gpuPercentage -= 0.05;
        } else if (motherboardPercentage > 0.10) {
            motherboardPercentage -= 0.05;
        } else if (memoryPercentage > 0.05) {
            memoryPercentage -= 0.03;
        }

        // 重新分配预算
        return allocateWithBacktracking(totalBudget, budgetMap, cpuPercentage, gpuPercentage, motherboardPercentage,
                memoryPercentage, powerSupplyPercentage, ssdPercentage, coolingPercentage, casePercentage);
    }
    // 根据CPU类型和预算选择
    private Product selectCpu(String cpuType, int minCPUBudget, int maxCPUBudget) {
        String orderPrice = "ASC";
        if (minCPUBudget>4500){
            orderPrice = "DESC";
        }
        switch (cpuType) {
            case "IntelD4":
                return productService.autoSelectBestValueD4IntelCPU(minCPUBudget, maxCPUBudget, orderPrice);
            case "AmdD5":
                return productService.autoSelectBestValueD5AmdCPU(minCPUBudget, maxCPUBudget, orderPrice);
            case "IntelD4D5":
                return productService.autoSelectBestValueD4D5IntelCPU(minCPUBudget, maxCPUBudget, orderPrice);
            case "AmdD4":
                return productService.autoSelectBestValueD4AmdCPU(maxCPUBudget, maxCPUBudget, orderPrice);
            default:
                throw new IllegalArgumentException("无效的 CPU 类型: " + cpuType);
        }
    }
    // 根据GPU类型和显存大小选择最佳 GPU
    private Product selectGpu(Integer gpuType, Integer gpuModel,Integer gpuSize, int minGPUBudget, int maxGPUBudget) {
        // 验证 GPU 类型
        if (gpuType == null || (gpuType != 21 && gpuType != 22)) {
            throw new IllegalArgumentException("无效的 GPU 类型: " + gpuType);
        }
        // 确定价格排序
        String priceOrder = (minGPUBudget >= 20000) ? "DESC" : "ASC";

        // 根据 GPU 大小选择最佳产品
        switch (gpuSize) {
            case 4:
                return productService.autoSelectBestValue4GPU(gpuType,gpuModel, minGPUBudget, maxGPUBudget, priceOrder);
            case 8:
                return productService.autoSelectBestValue8GPU(gpuType,gpuModel, minGPUBudget, maxGPUBudget, priceOrder);
            case 12:
                return productService.autoSelectBestValue12GPU(gpuType,gpuModel, minGPUBudget, maxGPUBudget, priceOrder);
            case 16:
                return productService.autoSelectBestValue16GPU(gpuType,gpuModel, minGPUBudget, maxGPUBudget, priceOrder);
            default:
                throw new IllegalArgumentException("无效的 GPU 大小: " + gpuSize);
        }
    }
    // 根据主板类型和预算选择最佳主板
    private Product selectMotherboard(Integer motherboardType, Integer motherboardVersion, Integer motherboardModel,int minMotherboardBudget,int maxMotherboardBudget ) {


        String order = "ASC";
        if(minMotherboardBudget >= 4500) {
            order = "DESC";
        }
        // 定义要调用的方法
        Product selectedProduct = null;

        // 判断主板类型（1 = Intel, 2 = AMD）
        if (motherboardType == 1 || motherboardType == 2) {
            // Intel 和 AMD 共用的版本和模型判断逻辑
            switch (motherboardVersion) {
                case 41:
                case 42:
                    switch (motherboardModel) {
                        case 411:
                        case 412:
                        case 413:
                        case 421:
                        case 422:
                        case 423:
                            // 根据类型调用不同的方法
                            if (motherboardType == 1) {
                                selectedProduct = productService.autoSelectBestValueIntel(
                                        motherboardVersion, motherboardModel, minMotherboardBudget, maxMotherboardBudget, order
                                );
                            } else if (motherboardType == 2) {
                                selectedProduct = productService.autoSelectBestValueAmd(
                                        motherboardVersion, motherboardModel, minMotherboardBudget, maxMotherboardBudget, order
                                );
                            }
                            break;
                        default:
                            // 处理无效模型的情况
                            throw new IllegalArgumentException("Invalid motherboard model: " + motherboardModel);
                    }
                    break;
                default:
                    // 处理无效版本的情况
                    throw new IllegalArgumentException("Invalid motherboard version: " + motherboardVersion);
            }
        } else {
            // 处理无效类型的情况
            throw new IllegalArgumentException("Invalid motherboard type: " + motherboardType);
        }

        return selectedProduct;
    }
    // 根据内存类型和大小选择最佳内存
    private Product selectMemory(Integer memoryType,Integer memoryModel, Integer memorySize, int minMemoryBudget, int maxMemoryBudget) {
        String order = "ASC";
        if(minMemoryBudget>=2500){
            order = "DESC";
        }
        switch (memoryType) {
            case 61:
                switch (memoryModel){
                    case 611:
                        switch (memorySize) {
                            case 8:
                            case 16:
                            case 32:
                                return productService.autoSelectBestValueMemory(memoryType,memoryModel,memorySize,minMemoryBudget,maxMemoryBudget,order);
                        }
                    case 612:
                        switch (memorySize) {
                            case 8:
                            case 16:
                            case 32:
                                return productService.autoSelectBestValueMemory(memoryType,memoryModel,memorySize,minMemoryBudget,maxMemoryBudget,order);
                        }
                }

            case 62:
                switch (memoryModel){
                    case 621:
                        switch (memorySize) {
                            case 16:
                            case 24:
                            case 32:
                            case 64:
                                return productService.autoSelectBestValueMemory(memoryType,memoryModel,memorySize,minMemoryBudget,maxMemoryBudget,order);
                        }
                    case 622:
                        switch (memorySize) {
                            case 16:
                            case 24:
                            case 32:
                            case 64:
                                return productService.autoSelectBestValueMemory(memoryType,memoryModel,memorySize,minMemoryBudget,maxMemoryBudget,order);
                        }
                }


            default:
                throw new IllegalArgumentException("无效的内存类型: " + memoryType);
        }
    }
    private Product selectSsd(Integer ssdType, String ssdSize, int minSsdBudget, int maxSsdBudget) {
        // 确定排序方式
        String order = "ASC";
        if(minSsdBudget>=3000){
            order = "DESC";
        }
        // 确保 parentId 是有效的
        if (ssdType != 71 && ssdType != 72) {
            throw new IllegalArgumentException("无效的 Parent ID: " + ssdType);
        }
        // 处理 SSD 容量
        switch (ssdSize) {
            case "215G":
            case "512G":
            case "1T":
            case "2T":
            case "4T":
                return productService.autoSelectBestValueSSD(ssdType, ssdSize, minSsdBudget, maxSsdBudget, order);
            default:
                throw new IllegalArgumentException("无效的 SSD 容量: " + ssdSize);
        }
    }
    // 根据散热类型和预算选择最佳散热器
    private Product selectCooler(Integer coolingType,Integer coolingSize, int minCoolingBudget, int maxCoolingBudget) {
        String order = "ASC";
        if (minCoolingBudget>=2000)
            order = "DESC";
        switch (coolingType) {
            case 31:
                switch (coolingSize) {
                    case 311:
                    case 312:
                        return productService.autoSelectBestValueCooler(coolingType,coolingSize,minCoolingBudget, maxCoolingBudget,order);
                    default:
                        break;
                }
                break;
            case 32:
                switch (coolingSize) {
                    case 321:
                    case 322:
                    case 323:
                        return productService.autoSelectBestValueCooler(coolingType,coolingSize,minCoolingBudget, maxCoolingBudget,order);
                    default:
                        break;
                }
                break;
            default:
                throw new IllegalArgumentException("无效的散热类型: " + coolingType);
        }
        return null;
    }
    // 选择电源
    private Product selectSupplyE(Integer supplySize,Integer supplyType, Integer supplyModel, int minSUEBudget, int maxSUEBudget) {
        String priceOrder = "ASC";
        if (maxSUEBudget >= 4000) {
            priceOrder = "DESC";
        }

        switch (supplyType) {
            case 51:
                switch (supplyModel) {
                    case 511:
                    case 512:
                        return productService.autoSelectBestValueSUE(supplySize,supplyType, supplyModel, minSUEBudget, maxSUEBudget, priceOrder);
                    default:
                        break;
                }
                break;

            case 52:
                switch (supplyModel) {
                    case 521:
                    case 522:
                        return productService.autoSelectBestValueSUE(supplySize,supplyType, supplyModel, minSUEBudget, maxSUEBudget, priceOrder);
                    default:
                        break;
                }
                break;

            default:
                break;
        }

        // 如果没有符合的返回情况，返回 null 或根据逻辑返回合适的默认值
        return null;
    }
    // 选择机箱
    private Product selectCase( Integer caseType,Integer caseModel, int minCaseBudget, int maxCaseBudget) {
        String priceOrder = "ASC";  // 修正拼写
        if (maxCaseBudget >= 1500) {
            priceOrder = "DESC";
        }

        switch (caseType) {
            case 81:
                switch (caseModel) {
                    case 811:
                    case 812:
                        return productService.autoSelectBestValueCase( caseType,caseModel, minCaseBudget, maxCaseBudget, priceOrder);
                    default:
                        break;  // 添加 break，防止 fall-through
                }
                break;  // 添加 break，防止 fall-through

            case 82:
                switch (caseModel) {
                    case 821:
                    case 822:
                        return productService.autoSelectBestValueCase( caseType,caseModel, minCaseBudget, maxCaseBudget, priceOrder);
                    default:
                        break;  // 添加 break
                }
                break;  // 添加 break

            default:
                break;  // 添加默认情况
        }

        // 如果没有符合的条件，返回 null 或其他适当的默认值
        return null;
    }
    // 根据CPU类型和预算选择
    private Product selectCheapCpu(String cpuType) {
        int minCPUBudget =0;
        int maxCPUBudget =20000;
        String orderPrice = "ASC";
        switch (cpuType) {
            case "IntelD4":
                return productService.autoSelectBestValueD4IntelCPU(minCPUBudget, maxCPUBudget, orderPrice);
            case "AmdD5":
                return productService.autoSelectBestValueD5AmdCPU(minCPUBudget, maxCPUBudget, orderPrice);
            case "IntelD4D5":
                return productService.autoSelectBestValueD4D5IntelCPU(minCPUBudget, maxCPUBudget, orderPrice);
            case "AmdD4":
                return productService.autoSelectBestValueD4AmdCPU(maxCPUBudget, maxCPUBudget,orderPrice);
            default:
                throw new IllegalArgumentException("无效的 CPU 类型: " + cpuType);
        }
    }
    // 根据 GPU 类型和显存大小选择最佳 GPU
    private Product selectCheapGpu(Integer gpuType,Integer gpuModel, Integer gpuSize) {
        // 验证 GPU 类型
        if (gpuType == null || (gpuType != 21 && gpuType != 22)) {
            throw new IllegalArgumentException("无效的 GPU 类型: " + gpuType);
        }
        int minGPUBudget = 0;
        int maxGPUBudget = 20000;
        // 确定价格排序
        String priceOrder = "ASC";

        // 根据 GPU 大小选择最佳产品
        switch (gpuSize) {
            case 4:
                return productService.autoSelectBestValue4GPU(gpuType,gpuModel, minGPUBudget, maxGPUBudget, priceOrder);
            case 8:
                return productService.autoSelectBestValue8GPU(gpuType,gpuModel, minGPUBudget, maxGPUBudget, priceOrder);
            case 12:
                return productService.autoSelectBestValue12GPU(gpuType,gpuModel, minGPUBudget, maxGPUBudget, priceOrder);
            case 16:
                return productService.autoSelectBestValue16GPU(gpuType,gpuModel, minGPUBudget, maxGPUBudget, priceOrder);
            default:
                throw new IllegalArgumentException("无效的 GPU 大小: " + gpuSize);
        }
    }
    // 根据主板类型和预算选择最佳主板
    private Product selectCheapMotherboard(Integer motherboardType, Integer motherboardVersion, Integer motherboardModel) {
        int minMotherboardBudget = 0;
        int maxMotherboardBudget = 20000;
        String order = "ASC";

        // 定义要调用的方法
        Product selectedProduct = null;

        // 判断主板类型（1 = Intel, 2 = AMD）
        if (motherboardType == 1 || motherboardType == 2) {
            // Intel 和 AMD 共用的版本和模型判断逻辑
            switch (motherboardVersion) {
                case 41:
                case 42:
                    switch (motherboardModel) {
                        case 411:
                        case 412:
                        case 413:
                        case 421:
                        case 422:
                        case 423:
                            // 根据类型调用不同的方法
                            if (motherboardType == 1) {
                                selectedProduct = productService.autoSelectBestValueIntel(
                                        motherboardVersion, motherboardModel, minMotherboardBudget, maxMotherboardBudget, order
                                );
                            } else if (motherboardType == 2) {
                                selectedProduct = productService.autoSelectBestValueAmd(
                                        motherboardVersion, motherboardModel, minMotherboardBudget, maxMotherboardBudget, order
                                );
                            }
                            break;
                        default:
                            // 处理无效模型的情况
                            throw new IllegalArgumentException("Invalid motherboard model: " + motherboardModel);
                    }
                    break;
                default:
                    // 处理无效版本的情况
                    throw new IllegalArgumentException("Invalid motherboard version: " + motherboardVersion);
            }
        } else {
            // 处理无效类型的情况
            throw new IllegalArgumentException("Invalid motherboard type: " + motherboardType);
        }

        return selectedProduct;
    }
    // 根据内存类型和大小选择最佳内存
    private Product selectCheapMemory(Integer memoryType,Integer memoryModel, Integer memorySize) {
        int minMemoryBudget = 0;
        int maxMemoryBudget = 20000;
        String order="ASC";
        switch (memoryType) {
            case 61:
                switch (memoryModel){
                    case 611:
                        switch (memorySize) {
                            case 8:
                            case 16:
                            case 32:
                                return productService.autoSelectBestValueMemory(memoryType,memoryModel,memorySize,minMemoryBudget,maxMemoryBudget,order);
                        }
                    case 612:
                        switch (memorySize) {
                            case 8:
                            case 16:
                            case 32:
                                return productService.autoSelectBestValueMemory(memoryType,memoryModel,memorySize,minMemoryBudget,maxMemoryBudget,order);
                        }
                }

            case 62:
                switch (memoryModel){
                    case 621:
                        switch (memorySize) {
                            case 16:
                            case 24:
                            case 32:
                            case 64:
                                return productService.autoSelectBestValueMemory(memoryType,memoryModel,memorySize,minMemoryBudget,maxMemoryBudget,order);
                        }
                    case 622:
                        switch (memorySize) {
                            case 16:
                            case 24:
                            case 32:
                            case 64:
                                return productService.autoSelectBestValueMemory(memoryType,memoryModel,memorySize,minMemoryBudget,maxMemoryBudget,order);
                        }
                }


            default:
                throw new IllegalArgumentException("无效的内存类型: " + memoryType);
        }
    }
    // 根据 SSD 容量和预算选择最佳 SSD
    private Product selectCheapSsd(Integer ssdType, String ssdSize) {
        // 确定排序方式
        int minSsdBudget = 0;
        int maxSsdBudget = 20000;
        String order = "ASC";


        // 确保 parentId 是有效的
        if (ssdType != 71 && ssdType != 72) {
            throw new IllegalArgumentException("无效的 Parent ID: " + ssdType);
        }
        // 处理 SSD 容量
        switch (ssdSize) {
            case "215G":
            case "512G":
            case "1T":
            case "2T":
            case "4T":
                return productService.autoSelectBestValueSSD(ssdType, ssdSize, minSsdBudget, maxSsdBudget, order);
            default:
                throw new IllegalArgumentException("无效的 SSD 容量: " + ssdSize);
        }
    }
    // 根据散热类型和预算选择最佳散热器
    private Product selectCheapCooler(Integer coolingType,Integer coolingSize) {
        String order = "ASC";
        int minCoolingBudget = 0;
        int maxCoolingBudget = 20000;

        switch (coolingType) {
            case 31:
                switch (coolingSize) {
                    case 311:
                    case 312:
                        return productService.autoSelectBestValueCooler(coolingType,coolingSize,minCoolingBudget, maxCoolingBudget,order);
                }
            case 32:
                switch (coolingSize) {
                    case 321:
                    case 322:
                    case 323:
                        return productService.autoSelectBestValueCooler(coolingType,coolingSize,minCoolingBudget, maxCoolingBudget,order);
                }
            default:
                throw new IllegalArgumentException("无效的散热类型: " + coolingType);
        }
    }
    // 选择电源
    private Product selectCheapSupplyE(Integer supplySize,Integer supplyType,Integer supplyModel) {
        String priceOrder = "ASC";
        int minSUEBudget = 0;
        int maxSUEBudget = 20000;
        return productService.autoSelectBestValueSUE(supplySize,supplyType,supplyModel,minSUEBudget, maxSUEBudget,priceOrder);
    }
    // 选择机箱
    private Product selectCheapCase(Integer CaseType,Integer CaseModel) {
        String priceOrder = "ASC";
        int minCaseBudget = 0;
        int maxCaseBudget = 20000;
        return productService.autoSelectBestValueCase(CaseType,CaseModel,minCaseBudget, maxCaseBudget,priceOrder);
    }

}