document.getElementById('configForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        cpuType: formData.get('cpuType'),
        gpuType: formData.get('gpuType'),
        gpuSize: parseInt(formData.get('gpuSize')),
        motherboardType: formData.get('motherboardType'),
        memoryType: formData.get('memoryType'),
        memorySize: parseInt(formData.get('memorySize')),
        ssdSize: parseInt(formData.get('ssdSize')),
        coolingType: formData.get('coolingType'),
        totalBudget: parseInt(formData.get('totalBudget'))
    };

    // 使用fetch将数据发送到后端
    fetch('/products/auto_createProfileBySelect/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(result => {
            if (result.code === 200) {
                displayConfig(result.data);
            } else {
                alert("生成配置失败，请重试！");
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("提交失败，请稍后再试！");
        });
});

function displayConfig(config) {
    const resultDiv = document.getElementById('result');
    resultDiv.innerHTML = `
        <h3>生成的配置</h3>
        <ul>
            <li>CPU: ${config.CPU.name}</li>
            <li>GPU: ${config.GPU.name}</li>
            <li>主板: ${config.Motherboard.name}</li>
            <li>内存: ${config.Memory.name}</li>
            <li>SSD: ${config.SSD.name}</li>
            <li>散热: ${config.Cooler.name}</li>
            <li>机箱: ${config.Case.name}</li>
            <li>电源: ${config["Power Supply"].name}</li>
        </ul>
    `;
}
