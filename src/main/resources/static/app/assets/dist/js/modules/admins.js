
(function () {
	var formLogin = $("#f-admin-login");
	if (formLogin.length) {
		formLogin.on('submit', function (e) {
			e.preventDefault();

			$.ajax({
				url: formLogin.attr('action'),
				data: formLogin.serialize(),
				type: 'post',
				dataType: 'json',
				success: function (response) {
					if (response.message) {
						block_form(formLogin, false);

						var type = response.success ? 'success' : 'error';
						var notice = new PNotify({
							title: type == 'success' ? 'Tudo certo!' : 'Oops!',
							text: response.message,
							type: type,
						});				
						notice.get().click(function() {
							notice.remove();
						});
					}
					if (response.redirect) {
						var redirect = setTimeout(function () {
							window.location.href = make_url(response.redirect);
							clearTimeout(redirect);
						}, 1500)
					}
				}
			});
			block_form(formLogin, true);
		});
	}
})();