
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
					<h4>Add a New Vehicle</h4>
				</div>

				<div class="col-12 px-lg-5 pb-3">
					<div class="row">
						<div class="col-6 col-lg-3">
							<div class="card mb-3">
								<img src="images/no-image.svg" id="image0" class="card-img-top"
									alt="...">
							</div>
						</div>
						<div class="col-6 col-lg-3">
							<div class="card mb-3">
								<img src="images/no-image.svg" id="image1" class="card-img-top"
									alt="...">
							</div>
						</div>
						<div class="col-6 col-lg-3">
							<div class="card mb-3">
								<img src="images/no-image.svg" id="image2" class="card-img-top"
									alt="...">
							</div>
						</div>
						<div class="col-6 col-lg-3">
							<div class="card mb-3">
								<img src="images/no-image.svg" id="image3" class="card-img-top"
									alt="...">
							</div>
						</div>

						<div class="col-6 col-lg-3">
							<div class="card mb-3">
								<img src="images/no-image.svg" id="image4" class="card-img-top"
									alt="...">
							</div>
						</div>
						<div class="col-6 col-lg-3">
							<div class="card mb-3">
								<img src="images/no-image.svg" id="image5" class="card-img-top"
									alt="...">
							</div>
						</div>
						<div class="col-6 col-lg-3">
							<div class="card mb-3">
								<img src="images/no-image.svg" id="image6" class="card-img-top"
									alt="...">
							</div>
						</div>
						<div class="col-6 col-lg-3">
							<div class="card mb-3">
								<img src="images/no-image.svg" id="image7" class="card-img-top"
									alt="...">
							</div>
						</div>
						<div class="col-6 col-lg-3">
							<div class="card mb-3">
								<img src="images/no-image.svg" id="image8" class="card-img-top"
									alt="...">
							</div>
						</div>
						<div class="col-6 col-lg-3">
							<div class="card mb-3">
								<img src="images/no-image.svg" id="image9" class="card-img-top"
									alt="...">
							</div>
						</div>
					</div>

					<form action="vehicle" method="POST" enctype="multipart/form-data"
						class="row g-3">

						<div class="col-12">
							<label for="formFileMultiple" class="form-label">Images</label>
							<div class="input-group">
								<input onchange="changeImage();" name="images[]"
									class="form-control" type="file" id="images" multiple>
							</div>
						</div>
						<div class="col-md-12">
							<label for="exampleFormControlInput1" class="form-label">Title</label>
							<input type="text" class="form-control"
								id="exampleFormControlInput1" name="title">
						</div>
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Price</label>
							<input type="number" class="form-control"
								id="exampleFormControlInput1" placeholder="20,000,000"
								name="price">
							<div class="mt-2 form-check">
								<input type="checkbox" name="negotiable"
									class="form-check-input" id="exampleCheck1"> <label
									class="form-check-label" for="exampleCheck1">Negotiable</label>
							</div>
						</div>
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Manufacture
								Year</label> <input type="number" class="form-control"
								id="exampleFormControlInput1" name="manufactureYear">
						</div>
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Model</label>
							<input type="text" class="form-control"
								id="exampleFormControlInput1" name="model">
						</div>
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Model
								Variant</label> <input type="text" class="form-control"
								id="exampleFormControlInput1" name="modelVariant">
						</div>
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Mileage</label>
							<input type="text" class="form-control"
								id="exampleFormControlInput1" name="mileage">
						</div>
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Engine
								Capacity</label> <input type="text" class="form-control"
								id="exampleFormControlInput1" name="engineCapacity">
						</div>
						<div class="col-md-4">
							<label for="formFileMultiple" class="form-label">Category</label>
							<select name="category" class="form-select" id="fueTtype"
								aria-describedby="validationServer04Feedback" required>
								<option value="">Select the Category</option>
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
							</select>
						</div>
						<div class="col-md-4">
							<label for="formFileMultiple" class="form-label">Brand
								Type</label> <select name="brand" class="form-select" id="brand"
								aria-describedby="validationServer04Feedback" required>
								<option value="">Select the Brand</option>
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
								id="transmission" aria-describedby="validationServer04Feedback">
								<option value="">Select the Transmission</option>
							</select>
						</div>
						<div class="col-md-4">
							<label for="formFileMultiple" class="form-label">Condition</label>
							<select name="condition" class="form-select" id="condition"
								aria-describedby="validationServer04Feedback">
								<option value="">Select the condition</option>
							</select>
						</div>
						<div class="col-md-4">
							<label for="formFileMultiple" class="form-label">Featuring
								Type</label> <select name="featuring" class="form-select" id="featuring"
								aria-describedby="validationServer04Feedback" required>
								<option value="">Select the Ad Featuring</option>
							</select>
						</div>
						<div class="col-md-4">
							<label for="formFileMultiple" class="form-label">Location</label>
							<select name="location" class="form-select" id="location"
								aria-describedby="validationServer04Feedback">
								<option value="">Select the location</option>
							</select>
						</div>
						<div class="col-md-12">
							<textarea class="form-control" placeholder="Description"
								id="floatingTextarea2" rows="10" name="description"></textarea>
						</div>

						<div class="col-md-12 mb-3">
							<button type="button" class="btn btn-primary">Create</button>
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
</body>

</html>