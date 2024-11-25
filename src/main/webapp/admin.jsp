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
				<div class="col-md-12 my-3">
					<h4>Dashboard</h4>
				</div>
			</div>


			<!-- Featured Ads Table -->
			<div class="row">
				<div class="col-md-12 mb-3">
					<div class="card">
						<div class="card-header fw-bold text-warning">
							<span><i class="bi bi-star-fill me-2"></i></span> Inquiries
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="example" class="table table-striped data-table"
									style="width: 100%">
									<thead>
										<tr>
											<th>Id</th>
											<th>Customer Name</th>
											<th>Customer Email</th>
											<th>Customer Mobile</th>
											<th>Inquiry</th>
											<th>Vehicle Id</th>
											<th>Vehicle Title</th>
											<th>Vehicle Price</th>
											<th>Manage</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="inquiry" items="${inquires}">
											<tr>
												<td>${inquiry.inquiryId}</td>
												<td>${inquiry.customerName}</td>
												<td>${inquiry.customerEmail}</td>
												<td>${inquiry.customerMobile}</td>
												<td>${inquiry.inquiry}</td>
												<td>${inquiry.vehicleId}</td>
												<td>${inquiry.vehicleTitle}</td>
												<td>${inquiry.vehiclePrice}</td>
												<td><a href="#"><button type="button"
															class="btn-sm btn-outline-primary">View</button></a></td>
											</tr>
										</c:forEach>

									</tbody>

									<tfoot>
										<tr>
											<th>Id</th>
											<th>Customer Name</th>
											<th>Customer Email</th>
											<th>Customer Mobile</th>
											<th>Inquiry</th>
											<th>Vehicle Id</th>
											<th>Vehicle Title</th>
											<th>Vehicle Price</th>
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
	<jsp:include page="includes/session_alert.jsp" />
</body>

</html>