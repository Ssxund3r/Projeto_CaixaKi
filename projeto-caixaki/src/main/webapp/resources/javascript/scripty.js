function logout(contextPath) {
	var post = 'invalidar_session';

	$.ajax({
		type: "POST",
		url: post
	}).always(function(resposta) {
		document.location = contextPath + '/j_spring_security_logout';
	});
}

function invalidarSession(context, pagina) {
	document.location = (context + pagina + ".jsf");
}

function validarSenhaLogin() {
	j_username = document.getElementById("j_username").value;
	j_password = document.getElementById("j_password").value;

	if (j_username === null || j_username.trim() === '') {
		alert("Informe o login!");
		$('#j_username').focus;
		return false;
	}

	if (j_password === null || j_password.trim() === '') {
		alert("Informe a senha!");
		$('#j_password').focus();
		return false;
	}
	return true;
}

function ocultarMenu() {
	$('#barramenu').animate({ "left": "-200px" }, "slow", function() {
		$('#barramenu').hide();
	});
}

function abrirMenupop() {
	$('#menupop').show('slow').mouseleave(function() {
		fecharMenupop();
	});
}

function fecharMenupop() {
	if ($("#menupop").is(":visible")) {
		$('#menupop').hide('slow');
	}
}

function fecharPesquisa() {
	$('#paginapesquisa').html('&nbsp;');
	$('#valorpesquisa').val('');
	$('#dialogopesquisa').hide();
}

function alterarSenhaDialog(){}


