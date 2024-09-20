// 更新主板和内存类型
function updateMotherboardAndMemory() {
    const cpuType = document.getElementById('cpuType').value;
    const motherboardType = document.getElementById('motherboardType');
    const motherboardVersion = document.getElementById('motherboardVersion');
    const motherboardModel = document.getElementById('motherboardModel');
    const memoryType = document.getElementById('memoryType');
    const memorySize = document.getElementById('memorySize');

    // 重置所有下拉框
    motherboardType.innerHTML = '<option value="">请选择主板类型</option>';
    motherboardVersion.innerHTML = '<option value="">请选择主板版本</option>';
    motherboardModel.innerHTML = '<option value="">请选择主板型号</option>';
    memoryType.innerHTML = '<option value="">请选择内存类型</option>';
    memorySize.innerHTML = '<option value="">请选择内存大小</option>';

    if (cpuType === 'IntelD4') {
        motherboardType.innerHTML += '<option value="1">Intel</option>';
        motherboardVersion.innerHTML += '<option value="41">D4</option>';
        motherboardModel.innerHTML += '<option value="411">入门级</option><option value="412">中端级</option><option value="413">高端定制</option>';
        memoryType.innerHTML += '<option value="61">D4</option>';
        memorySize.innerHTML += '<option value="8">8 GB</option><option value="16">16 GB</option><option value="32">32 GB</option>';
    } else if (cpuType === 'AmdD5') {
        motherboardType.innerHTML += '<option value="2">AMD</option>';
        motherboardVersion.innerHTML += '<option value="42">D5</option>';
        motherboardModel.innerHTML += '<option value="421">入门级</option><option value="422">中端级</option><option value="423">高端定制</option>';
        memoryType.innerHTML += '<option value="62">D5</option>';
        memorySize.innerHTML += '<option value="16">16 GB</option><option value="24">24 GB</option><option value="32">32 GB</option><option value="64">64 GB</option>';
    }  else if (cpuType === 'AmdD4') {
        motherboardType.innerHTML += '<option value="2">AMD</option>';
        motherboardVersion.innerHTML += '<option value="41">D4</option>';
        motherboardModel.innerHTML += '<option value="411">入门级</option><option value="412">中端级</option><option value="413">高端定制</option>';
        memoryType.innerHTML += '<option value="61">D4</option>';
        memorySize.innerHTML += '<option value="8">8 GB</option><option value="16">16 GB</option><option value="32">32 GB</option>';
    }else if (cpuType === 'IntelD4D5') {
        // 清空现有的选项
        motherboardType.innerHTML = '<option value="">请选择主板类型</option>';
        motherboardVersion.innerHTML = '<option value="">请选择主板版本</option>';
        motherboardModel.innerHTML = '<option value="">请选择主板型号</option>';

        // 添加主板类型选项
        motherboardType.innerHTML += '<option value="1">Intel</option>';

        // 添加主板版本选项
        motherboardVersion.innerHTML += '<option value="41">D4</option>';
        motherboardVersion.innerHTML += '<option value="42">D5</option>';

        // 更新主板型号选项根据选择的版本
        motherboardVersion.addEventListener('change', function() {
            var version = motherboardVersion.value;
            motherboardModel.innerHTML = '<option value="">请选择主板型号</option>';

            if (version === '41') {
                motherboardModel.innerHTML += '<option value="411">入门级</option>';
                motherboardModel.innerHTML += '<option value="412">中端级</option>';
                motherboardModel.innerHTML += '<option value="413">高端定制</option>';
            } else if (version === '42') {
                motherboardModel.innerHTML += '<option value="421">入门级</option>';
                motherboardModel.innerHTML += '<option value="422">中端级</option>';
                motherboardModel.innerHTML += '<option value="423">高端定制</option>';
            }
        });
    }

}

// 更新内存类型和大小
function updateMemoryOptions() {
    const motherboardVersion = document.getElementById('motherboardVersion').value;
    const memoryType = document.getElementById('memoryType');
    const memorySize = document.getElementById('memorySize');

    memoryType.innerHTML = '<option value="">请选择内存类型</option>';
    memorySize.innerHTML = '<option value="">请选择内存大小</option>';

    if (motherboardVersion === '41') {  // D4
        memoryType.innerHTML += '<option value="61">D4</option>';
        memorySize.innerHTML += '<option value="8">8 GB</option><option value="16">16 GB</option><option value="32">32 GB</option>';
    } else if (motherboardVersion === '42') {  // D5
        memoryType.innerHTML += '<option value="62">D5</option>';
        memorySize.innerHTML += '<option value="16">16 GB</option><option value="24">24 GB</option><option value="32">32 GB</option><option value="64">64 GB</option>';
    }
}
//更新内存颗粒
function updateMemoryModel() {
    const memoryType = document.getElementById('memoryType').value;
    const memoryModel = document.getElementById('memoryModel');

    memoryModel.innerHTML = '<option value="">请选择内存颗粒</option>';

    if (memoryType === '61') { // DDR4
        memoryModel.innerHTML += '<option value="611">特调颗粒</option>';
        memoryModel.innerHTML += '<option value="612">非特调颗粒</option>';
    } else if (memoryType === '62') { // DDR5
        memoryModel.innerHTML += '<option value="621">特调颗粒</option>';
        memoryModel.innerHTML += '<option value="622">非特调颗粒</option>';
    }
}
// 绑定事件
document.getElementById('memoryType').addEventListener('change', updateMemoryModel);



// 更新显卡型号和显存大小
function updateGpuModel() {
    const gpuType = document.getElementById('gpuType').value;
    const gpuModel = document.getElementById('gpuModel');
    const gpuSize = document.getElementById('gpuSize');

    gpuModel.innerHTML = '<option value="">请选择显卡型号</option>';
    gpuSize.innerHTML = '<option value="">请选择显存大小</option>';

    if (gpuType === '21') {  // N卡
        gpuModel.innerHTML += '<option value="211">10系</option><option value="212">20系</option><option value="213">30系</option><option value="214">40系</option>';
    } else if (gpuType === '22') {  // A卡
        gpuModel.innerHTML += '<option value="221">5000系</option><option value="222">6000系</option><option value="223">7000系</option>';
    }
}
function updateGpuSize() {
    const gpuModel = document.getElementById('gpuModel').value;
    const gpuSize = document.getElementById('gpuSize');

    gpuSize.innerHTML = '<option value="">请选择显存大小</option>';

    if (gpuModel === '211' || gpuModel === '221') {
        gpuSize.innerHTML += '<option value="4">4GB及以下</option><option value="8">8GB及以下</option>';
    } else if (gpuModel === '212' || gpuModel === '222') {
        gpuSize.innerHTML += '<option value="8">8GB及以下</option><option value="12">12GB及以下</option>';
    } else if (gpuModel === '213' || gpuModel === '223' || gpuModel === '214') {
        gpuSize.innerHTML += '<option value="8">8GB及以下</option><option value="12">12GB及以下</option><option value="16">16GB及以上</option>';
    }
}

// 更新电源型号选项
function updateSupplyModelOptions() {
    const supplyType = document.getElementById('supplyType').value;
    const supplyModel = document.getElementById('supplyModel');

    // 清空电源型号的选项
    supplyModel.innerHTML = '<option value="">请选择电源型号</option>';

    if (supplyType === '51') { // 全模组
        supplyModel.innerHTML += '<option value="511">金牌</option>';
        supplyModel.innerHTML += '<option value="512">铜牌</option>';
    } else if (supplyType === '52') { // 非全模组
        supplyModel.innerHTML += '<option value="521">金牌</option>';
        supplyModel.innerHTML += '<option value="522">铜牌</option>';
    }
}
// 绑定事件
document.getElementById('supplyType').addEventListener('change', updateSupplyModelOptions);


// 更新散热型号
function updateCoolingSize() {
    const coolingType = document.getElementById('coolingType').value;
    const coolingSize = document.getElementById('coolingSize');

    coolingSize.innerHTML = '<option value="">请选择散热规格</option>';

    if (coolingType === '31') {  // 风冷
        coolingSize.innerHTML += '<option value="311">单塔</option><option value="312">双塔</option>';
    } else if (coolingType === '32') {  // 水冷
        coolingSize.innerHTML += '<option value="321">120水冷</option><option value="322">240水冷</option><option value="323">360水冷</option>';
    }
}
document.getElementById('coolingType').addEventListener('change', updateCoolingSize);
// 更新机箱型号
function updateCaseModel() {
    const caseType = document.getElementById('caseType').value;
    const caseModel = document.getElementById('caseModel');

    // 清空机箱型号的选项
    caseModel.innerHTML = '<option value="">请选择机箱型号</option>';

    // 根据机箱类型更新型号
    if (caseType === '81') {  // 普通机箱
        caseModel.innerHTML += '<option value="811">普通海景房</option>';
        caseModel.innerHTML += '<option value="812">普通非海景房</option>';
    } else if (caseType === '82') {  // 高端定制
        caseModel.innerHTML += '<option value="821">高端定制海景房</option>';
        caseModel.innerHTML += '<option value="822">高端定制非海景房</option>';
    }
}
// 绑定机箱类型选择事件
document.getElementById('caseType').addEventListener('change', updateCaseModel);


// 表单提交时向后端发送请求，获取具体的配置
document.getElementById('configForm').addEventListener('submit', function (event) {
    event.preventDefault();

    // 获取表单数据
    const formData = new FormData(event.target);

    // 构建数据对象
    const data = {
        cpuType: formData.get('cpuType'),
        gpuType: parseInt(formData.get('gpuType')),
        gpuModel: parseInt(formData.get('gpuModel')),
        gpuSize: parseInt(formData.get('gpuSize')),
        motherboardType: parseInt(formData.get('motherboardType')),
        motherboardVersion: parseInt(formData.get('motherboardVersion')),
        motherboardModel: parseInt(formData.get('motherboardModel')),
        memoryType: parseInt(formData.get('memoryType')),
        memorySize: parseInt(formData.get('memorySize')),
        memoryModel: parseInt(formData.get('memoryModel')),
        ssdType: parseInt(formData.get('ssdType')),
        ssdSize: formData.get('ssdSize'),
        coolingType: parseInt(formData.get('coolingType')),
        coolingSize: parseInt(formData.get('coolingSize')),
        supplyType: parseInt(formData.get('supplyType')),
        supplyModel: parseInt(formData.get('supplyModel')),
        supplySize: parseInt(formData.get('supplySize')),
        caseType: parseInt(formData.get('caseType')),
        caseModel: parseInt(formData.get('caseModel')),
        totalBudget: parseInt(formData.get('totalBudget'))
    };

    // 显示加载动画
    document.getElementById('loading').style.display = 'block';
    document.getElementById('result').innerHTML = '';

    // 使用 Fetch API 发送请求到后端
    fetch('/products/auto_createProfileBySelect/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(responseData => {
            // 隐藏加载动画
            document.getElementById('loading').style.display = 'none';

            // 显示结果
            displayConfig(responseData.data);
        })
        .catch(error => {
            document.getElementById('loading').style.display = 'none';
            console.error('请求失败:', error);
            alert('生成配置失败，请稍后再试');
        });
});

// 显示生成的配置
function displayConfig(config) {
    // 初始化总价为0
    let totalPrice = 0;

    // 定义一个辅助函数，用于将组件价格添加到总价中
    function addPrice(component) {
        if (component && component.price) {
            totalPrice += component.price;
        }
    }

    // 依次累加每个组件的价格
    addPrice(config.CPU);
    addPrice(config.Motherboard);
    addPrice(config.Memory);
    addPrice(config.GPU);
    addPrice(config.PowerSupply);
    addPrice(config.SSD);
    addPrice(config.Cooling);
    addPrice(config.Case);

    // 更新总价
    config.totalPrice = totalPrice;

    // 显示配置及总价
    const resultDiv = document.getElementById('result');
    resultDiv.innerHTML = `
        <h3>生成的配置</h3>
        <ul>
            <li>CPU: ${config.CPU ? `${config.CPU.itemType} - ￥${config.CPU.price}` : '未选择'}</li>
            <li>主板: ${config.Motherboard ? `${config.Motherboard.itemType} - ￥${config.Motherboard.price}` : '未选择'}</li>
            <li>内存: ${config.Memory ? `${config.Memory.itemType} - ￥${config.Memory.price}` : '未选择'}</li>
            <li>显卡: ${config.GPU ? `${config.GPU.itemType} - ￥${config.GPU.price}` : '未选择'}</li>
            <li>电源: ${config.PowerSupply ? `${config.PowerSupply.itemType} - ￥${config.PowerSupply.price}` : '未选择'}</li>
            <li>SSD: ${config.SSD ? `${config.SSD.itemType} - ￥${config.SSD.price}` : '未选择'}</li>
            <li>散热器: ${config.Cooling ? `${config.Cooling.itemType} - ￥${config.Cooling.price}` : '未选择'}</li>
            <li>机箱: ${config.Case ? `${config.Case.itemType} - ￥${config.Case.price}` : '未选择'}</li>
        </ul>
        <p><strong>总价: ￥${config.totalPrice}</strong></p>
    `;
}
