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
					<h4>Categories</h4>
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-12 col-md-8">

					<div class="card mb-4">
						<div class="card-header">
							<h5 class="text-start font-weight-light my-2">Create a New
								Category</h5>
						</div>

						<div class="card-body">

							<div class="mb-3">
								<form method="post" action="categoryupdate">
									<label for="exampleInputName" class="form-label">Category
										Name</label> <input type="text" class="form-control"
										id="exampleInputName" name="categoryName"
										aria-describedby="nameHelp" value="${category.categoryName}"
										required> <input type="hidden" name="categoryId"
										value="${category.categoryId}" required> <input
										type="hidden" name="process" value="update" required>

									<button class="mt-3 btn btn-primary" type="submit">Update</button>
								</form>
								<button class="mt-3 btn btn-danger" data-bs-toggle="modal"
									data-bs-target="#modalDeleteConfirm">Delete</button>

							</div>

						</div>

					</div>

				</div>
			</div>



		</div>
	</main>

	<!-- Vertically centered modal -->
	<!-- Vertically centered modal -->
	<div class="modal fade" id="modalDeleteConfirm" tabindex="-1"
		aria-labelledby="modalDeleteConfirmLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalDeleteConfirmLabel">Confirm</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>Are you sure you want to delete this category?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<form method="post" action="categoryupdate">
						<input type="hidden" name="categoryId"
							value="${category.categoryId}" required> <input
							type="hidden" name="process" value="delete" required>
						<button class="btn btn-danger" type="submit">Delete</button>
					</form>
				</div>
			</div>
		</div>
	</div>


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