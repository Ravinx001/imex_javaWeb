<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
if (session.getAttribute("userId") == null) {
	response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap5.min.css" />
<link rel="stylesheet" href="css/style.css" />
<!-- FAVICON -->
<link rel="icon" href="images/blue-logo.png">
<title>Imex - Admin Panel</title>
</head>

<body>
	<jsp:include page="includes/navigation.jsp" />

	<jsp:include page="includes/offcanvas.jsp" />

	<main class="mt-5 pt-3">
		<div class="container-fluid">

			<br>
			<div class="row">
				<div class="col-md-12">
					<h4>Brands</h4>
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-12 col-md-8">

					<div class="card mb-4">
						<div class="card-header">
							<h5 class="text-start font-weight-light my-2">Create a New
								Brand</h5>
						</div>

						<div class="card-body">

							<form method="post" action="brand">

								<div class="mb-3">
									<label for="exampleInputName" class="form-label">Brand
										Name</label> <input type="text" class="form-control"
										id="exampleInputName" name="brandName"
										aria-describedby="nameHelp" required>
								</div>

								<div
									class="d-flex align-items-center justify-content-between mt-4 mb-0">
									<input type="hidden" name="process" value="create">
									<button class="btn btn-primary" type="submit">Create</button>
								</div>

							</form>

						</div>

					</div>

				</div>
			</div>


			<!-- Featured Ads Table -->
			<div class="row">
				<div class="col-md-12 mb-3">
					<div class="card">
						<div class="card-header fw-bold text-primary">
							<span><i class="bi bi-nintendo-switch"></i></span> Brands
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="example" class="table table-striped data-table"
									style="width: 100%">
									<thead>
										<tr>
											<th>Id</th>
											<th>Brand Name</th>
											<th>Manage</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="brand" items="${brands}">
											<tr>
												<td>${brand.brandId}</td>
												<td>${brand.brandName}</td>
												<td><a href="brandupdate?brandId=${brand.brandId}"><button
															class="btn btn-sm btn-primary" type="submit">Edit</button></a>
												</td>
											</tr>
										</c:forEach>
									</tbody>

									<tfoot>
										<tr>
											<th>Id</th>
											<th>Brand Name</th>
											<th>Manage</th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</main>

	<script src="./js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@3.0.2/dist/chart.min.js"></script>
	<script src="./js/jquery-3.5.1.js"></script>
	<script src="./js/jquery.dataTables.min.js"></script>
	<script src="./js/dataTables.bootstrap5.min.js"></script>
	<script src="./js/script.js"></script>

	<jsp:include page="includes/alert.jsp" />
</body>

</html>