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


			<div class="row">
				<div class="col-md-12 my-3 d-flex justify-content-between">
					<h4>Vehicles</h4>
					<a href="vehiclecreate">
						<button class="btn btn-primary">Add a New Vehicle</button>
					</a>
				</div>
			</div>

			<!-- Used Vehicles Table -->
			<div class="row">
				<div class="col-md-12 mb-3">
					<div class="card">
						<div class="card-header fw-bold text-primary">
							<span><i class="bi bi-car-front me-1"></i></span> Used - Vehicles
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="example" class="table table-striped data-table"
									style="width: 100%">
									<thead>
										<tr>
											<th>Id</th>
											<th>Title</th>
											<th>Price</th>
											<th>M-Year</th>
											<th>Model</th>
											<th>Model Variant</th>
											<th>Mileage</th>
											<th>Engine Capacity</th>
											<th>Category</th>
											<th>Fuel Type</th>
											<th>Brand</th>
											<th>Transmission</th>
											<th>Featuring</th>
											<th>Condition</th>
											<th>Manage</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="vehicle" items="${vehicles}">
											<tr>
												<td>${vehicle.vehicleId}</td>
												<td>${vehicle.title}</td>
												<td>${vehicle.price}</td>
												<td>${vehicle.manufactureYear}</td>
												<td>${vehicle.model}</td>
												<td>${vehicle.modelVariant}</td>
												<td>${vehicle.mileage}</td>
												<td>${vehicle.engineCapacity}</td>
												<td>${vehicle.categotryName}</td>
												<td>${vehicle.fueltypeName}</td>
												<td>${vehicle.brandName}</td>
												<td>${vehicle.transmissionName}</td>
												<td>${vehicle.featuringName}</td>
												<td>${vehicle.conditionName}</td>
												<td><a
													href="vehicleupdate?vehicleId=${vehicle.vehicleId}"><button
															class="btn btn-sm btn-primary" type="submit">Edit</button></a>

													<form class="mt-2" action="vehicledelete" method="post">
														<input name="vehicleId" type="hidden"
															value="${vehicle.vehicleId}">
														<button class="btn btn-sm btn-danger" type="submit">Delete</button>
													</form></td>
											</tr>
										</c:forEach>
									</tbody>

									<tfoot>
										<tr>
											<th>Id</th>
											<th>Title</th>
											<th>Price</th>
											<th>M-Year</th>
											<th>Body Type</th>
											<th>Transmission</th>
											<th>Drive Type</th>
											<th>Condition</th>
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