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

			<div class="col-12 px-lg-5 pb-3">
				<div class="row d-flex justify-content-center mt-4">
					<div class="col-12 col-lg-6">
						<div class="card mb-3">
							<img src="${vehicle.imagePath}" id="image0" class="card-img-top"
								alt="...">
						</div>
					</div>
				</div>

				<form action="vehicleimage" method="post"
					enctype="multipart/form-data" class="row g-3">

					<div class="col-12">
						<label for="formFileMultiple" class="form-label">Image</label>
						<div class="input-group">
							<input onchange="changeImage();" name="image"
								class="form-control" type="file" id="images">
						</div>
					</div>

					<div class="col-md-12 mb-3">
						<button type="submit" class="btn btn-primary">Upload</button>
					</div>
				</form>


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