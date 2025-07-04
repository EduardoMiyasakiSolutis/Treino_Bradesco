function deletarBanco(id){
	if(confirm("Tem certeza que deseja excluir o banco com o id " + id + "?")) {
		fetch(contextPath + '/banco?id=' + id, {
			method: 'DELETE'
		})
		.then(response => {
			if(response.ok){
				console.log("Banco deletado com sucesso");
				window.location.href = "sucessoDelete.jsp";
			} else {
				response.text().then(text => alert("Erro: " + text));
			}
		}).catch(error => alert("Erro ao deletar o usuário: " + error));
	}
}
