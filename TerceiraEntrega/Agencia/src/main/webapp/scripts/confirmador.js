/**
 * 
 */
function confirmar(idcli){
	let resposta = confirm("Confirmar a exclusão deste cliente?")
	if(resposta === true){
//		alet(idcli)
		window.location.href = "delete?idcli=" + idcli
	}
}