/* Add here all your JS customizations */
(function($) {

	'use strict';

	var datatableDefaultInit = function() {

		$('table.data').dataTable({
			dom: '<"row"<"col-lg-6"l><"col-lg-6"f>><"table-responsive"t>p',
			paging: false
		});

	};

	var datatableDefaultPaginateInit = function() {
		
		$('table.data-paginate').dataTable({
			dom: '<"row"<"col-lg-6"l><"col-lg-6"f>><"table-responsive"t>p',
			paging: true,
			"aaSorting": []
		});

	};

	$(function() {
		datatableDefaultInit();
		datatableDefaultPaginateInit();
	});

	$('a.delete').on('click', function(){
		var url = $(this).attr('data-url');
		$('#deleteModal .modal-footer a.delete-url').attr('href', url);
	});

	$('button[type="submit"],input[type="submit"],.btn.loading').on('click', function() {
		var $this = $(this);
		var loadingText = '<i class="fa fa-circle-notch fa-spin"></i> carregando...';
		if ($(this).html() !== loadingText) {
			$this.data('original-text', $(this).html());
			$this.html(loadingText);
		}
		setTimeout(function() {
			$this.html($this.data('original-text'));
		}, 5000);
	});

	$("[data-sort-source]").each(function() {

		var source = $(this);
		var destination = $("[data-sort-destination][data-sort-id=" + $(this).attr("data-sort-id") + "]");

		if(destination.get(0)) {

			$(window).on('load', function() {

				destination.isotope({
					itemSelector: ".isotope-item",
					layoutMode: 'fitRows'
				});

				$(window).on('sidebar-left-toggle inner-menu-toggle', function() {
					destination.isotope();
				});

				source.find("a[data-option-value]").click(function(e) {

					e.preventDefault();

					var $this = $(this),
						filter = $this.attr("data-option-value");

					source.find(".active").removeClass("active");
					$this.closest("li").addClass("active");

					destination.isotope({
						filter: filter
					});

					if(window.location.hash != "" || filter.replace(".","") != "*") {
						window.location.hash = filter.replace(".","");
					}

					return false;

				});

				$(window).bind("hashchange", function(e) {

					var hashFilter = "." + location.hash.replace("#",""),
						hash = (hashFilter == "." || hashFilter == ".*" ? "*" : hashFilter);

					source.find(".active").removeClass("active");
					source.find("[data-option-value='" + hash + "']").closest("li").addClass("active");

					destination.isotope({
						filter: hash
					});

				});

				var hashFilter = "." + (location.hash.replace("#","") || "*");
				var initFilterEl = source.find("a[data-option-value='" + hashFilter + "']");

				if(initFilterEl.get(0)) {
					source.find("[data-option-value='" + hashFilter + "']").click();
				} else {
					source.find(".active a").click();
				}

			});

		}

	});

}).apply(this, [jQuery]);