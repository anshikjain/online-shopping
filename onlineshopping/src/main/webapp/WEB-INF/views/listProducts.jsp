<div class="container">

	<!-- side menu bar -->
	<div class="row">
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!-- Products -->
		<div class="col-md-9">
			<!-- Breadcrumb -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true }">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true }">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>


				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">

					<table id="productListTable"
						class=" table table-striped table-bordered">
						<thead>
							<tr>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity Available</th>
								<th></th>
							</tr>
						</thead>
						
						<tfoot>
							<tr>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity Available</th>
								<th></th>
							</tr>
						</tfoot>
					</table>

				</div>

			</div>
		</div>
	</div>

</div>