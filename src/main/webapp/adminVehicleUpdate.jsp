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
<link rel="stylesheet" href="css/admin/admin.css" />

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

				<div class="col-md-12 my-3 text-center">
					<h4>Update Vehicle</h4>
				</div>

				<div class="col-12 px-lg-5 pb-3">

					<form action="vehicleupdate" method="POST" class="row g-3">

						<div class="col-md-12">
							<label for="exampleFormControlInput1" class="form-label">Title</label>
							<input value="${vehicle.title}" required type="text"
								class="form-control" id="exampleFormControlInput1" name="title">
							<input value="${vehicle.vehicleId}" required type="hidden"
								class="form-control" id="exampleFormControlInput1"
								name="vehicleId">
						</div>
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Price</label>
							<input value="${vehicle.price}" type="text" class="form-control"
								id="exampleFormControlInput1" name="vehicleprice">
						</div>
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Manufacture
								Year</label> <input value="${vehicle.manufactureYear}" type="number"
								class="form-control" id="exampleFormControlInput1"
								name="manufactureYear">
						</div>
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Model</label>
							<input value="${vehicle.model}" type="text" class="form-control"
								id="exampleFormControlInput1" name="model">
						</div>
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Model
								Variant</label> <input type="text" value="${vehicle.modelVariant}"
								class="form-control" id="exampleFormControlInput1"
								name="modelVariant">
						</div>
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Mileage</label>
							<input value="${vehicle.mileage}" type="text"
								class="form-control" id="exampleFormControlInput1"
								name="mileage">
						</div>
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Engine
								Capacity</label> <input type="text" class="form-control"
								id="exampleFormControlInput1" name="engineCapacity"
								value="${vehicle.engineCapacity}">
						</div>
						<div class="col-md-4">
							<label for="formFileMultiple" class="form-label">Category</label>
							<select name="category" class="form-select" id="fueTtype"
								aria-describedby="validationServer04Feedback" required>
								<option value="">Select the Category</option>
								<c:forEach var="category" items="${categories}">
									<option
										${vehicle.categotry == category.categoryId ? 'selected' : ''}
										value="${category.categoryId}">${category.categoryName}</option>
								</c:forEach>
							</select>
						</div>
						<div
							class="col-md-4 d-flex align-items-end justify-content-center">
							<a href="category">
								<button type="button" class="btn btn-primary">Edit
									Categories</button>
							</a>
						</div>
						<div class="col-md-4">
							<label for="formFileMultiple" class="form-label">Fuel
								Type</label> <select name="fuelType" class="form-select" id="fuelType"
								aria-describedby="validationServer04Feedback" required>
								<option value="">Select a Fuel Type</option>
								<c:forEach var="fuelType" items="${fuelTypes}">
									<option
										${vehicle.fueltype == fuelType.fuelTypeId ? 'selected' : ''}
										value="${fuelType.fuelTypeId}">${fuelType.fuelType}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-4">
							<label for="formFileMultiple" class="form-label">Brand
								Type</label> <select name="brand" class="form-select" id="brand"
								aria-describedby="validationServer04Feedback" required>
								<option value="">Select the Brand</option>
								<c:forEach var="brand" items="${brands}">
									<option ${vehicle.brand == brand.brandId ? 'selected' : ''}
										value="${brand.brandId}">${brand.brandName}</option>
								</c:forEach>
							</select>
						</div>

						<div
							class="col-md-4 d-flex align-items-end justify-content-center">
							<a href="brand">
								<button type="button" class="btn btn-primary">Edit
									Brands</button>
							</a>
						</div>
						<div class="col-md-4">
							<label for="formFileMultiple" class="form-label">Transmission
								Type</label> <select name="transmission" class="form-select"
								id="transmission" aria-describedby="validationServer04Feedback"
								required>
								<option value="">Select the Transmission</option>
								<c:forEach var="transmission" items="${transmissions}">
									<option
										${vehicle.transmission == transmission.transmissionId ? 'selected' : ''}
										value="${transmission.transmissionId}">${transmission.transmission}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-4">
							<label for="formFileMultiple" class="form-label">Condition</label>
							<select name="condition" class="form-select" id="condition"
								aria-describedby="validationServer04Feedback" required>
								<option value="">Select the Condition</option>
								<c:forEach var="condition" items="${conditions}">
									<option
										${vehicle.condition == condition.conditionId ? 'selected' : ''}
										value="${condition.conditionId}">${condition.condition}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-4">
							<label for="formFileMultiple" class="form-label">Featuring
								Type</label> <select name="featuring" class="form-select" id="featuring"
								aria-describedby="validationServer04Feedback" required>
								<option value="">Select the Ad Featuring</option>
								<c:forEach var="featuring" items="${featurings}">
									<option
										${vehicle.featuring == featuring.featuringId ? 'selected' : ''}
										value="${featuring.featuringId}">${featuring.featuring}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-4">
							<label for="formFileMultiple" class="form-label">Location</label>
							<select name="location" class="form-select" id="location"
								aria-describedby="validationServer04Feedback" required>
								<option value="">Select the location</option>
								<c:forEach var="location" items="${locations}">
									<option
										${vehicle.location == location.locationId ? 'selected' : ''}
										value="${location.locationId}">${location.location}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-12">
							<textarea class="form-control" placeholder="Description"
								id="floatingTextarea2" rows="10" name="description">${vehicle.description}</textarea>
						</div>

						<div class="col-md-12 mb-3">
							<button type="submit" class="btn btn-primary">Update</button>
						</div>

					</form>

				</div>
			</div>

		</div>
	</main>

	<script src="./js/admin/admin.js"></script>
	<script src="./js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@3.0.2/dist/chart.min.js"></script>
	<script src="./js/jquery-3.5.1.js"></script>
	<script src="./js/jquery.dataTables.min.js"></script>
	<script src="./js/dataTables.bootstrap5.min.js"></script>
	<script src="./js/script.js"></script>

	<jsp:include page="includes/alert.jsp" />
	<jsp:include page="includes/session_alert.jsp" />
</body>

</html>