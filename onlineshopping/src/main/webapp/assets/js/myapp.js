// For displaying active menu
$(function() {
	console.log(menu);
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Product Management':
		$('#manageProduct').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

});

// For displaying products in jQuery table

var $table = $('#productListTable')

var jsonUrl = '';

if (window.categoryId == '') {
	jsonUrl = window.contextRoot + '/rest/all/products';
} else {
	jsonUrl = window.contextRoot + '/rest/category/' + window.categoryId
			+ '/products';
}

if ($table.length) {
	$table
			.DataTable({

				pageLength : 5,

				ajax : {
					url : jsonUrl,
					dataSrc : ''
				},

				columns : [

						{
							data : 'name'
						},

						{
							data : 'brand'
						},

						{
							data : 'unitPrice',
							mRender : function(data, type, row) {
								return '&#8377; ' + data
							}

						},

						{
							data : 'quantity',
							mRender : function(data, type, row) {
								if (data < 1) {
									return '<span style = "color:red">Out of stock</span>'
								}
								return data;
							}
						},

						{
							data : 'id',
							bSortable : false,
							mRender : function(data, type, row) {

								var str = '';
								str += '<a href="'
										+ window.contextRoot
										+ '/show/'
										+ data
										+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

								if (row.quantity < 1) {
									str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
								} else {

									str += '<a href="'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
								}

								return str;

							}
						}

				]

			});
}