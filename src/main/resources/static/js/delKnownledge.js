function deleteKnowledge(knid) {
    if (confirm('确定要删除这条词条吗？')) {
        fetch(`/knowledges/delete_knowledge?knid=${knid}`, {
            method: 'DELETE'
        })
            .then(response => response.json())
            .then(data => {
                if (data.state === 200) {
                    alert('词条已删除');
                    loadKnowledge();
                } else {
                    alert("删除失败。 " + (data.message || ""));
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert("删除词条时发生错误。");
            });
    }
}

$('#editKnowledge').click(function () {
    window.location.href = "adminEditKnowledge.html";
});