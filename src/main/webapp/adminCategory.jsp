
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
				<div class="col-md-12">
					<h4>Categories</h4>
				</div>
			</div>

			<div class="row">
				<div class="col-12 col-md-8">

					<div class="card mb-4">
						<div class="card-header">
							<h5 class="text-start font-weight-light my-2">Profile
								Information</h5>
							<span class="text-primary">Update your account's profile
								information and email address.</span>
						</div>

						<div class="card-body">

							<form method="post" action="profile">

								<div class="mb-3">
									<label for="exampleInputName" class="form-label">Name</label> <input
										type="text" class="form-control" id="exampleInputName"
										name="name" value="<%=session.getAttribute("name")%>"
										aria-describedby="nameHelp">
								</div>
								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label">Email</label>
									<input type="email" class="form-control"
										id="exampleInputEmail1"
										value="<%=session.getAttribute("email")%>" name="email"
										aria-describedby="emailHelp">
								</div>
								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">New
										Password</label> <input type="password" name="password"
										class="form-control" id="exampleInputPassword1">
								</div>

								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Re
										Enter New Password</label> <input type="password" name="repassword"
										class="form-control" id="exampleInputPassword1">
								</div>

								<div
									class="d-flex align-items-center justify-content-between mt-4 mb-0">
									<button class="btn btn-primary" type="submit">Save</button>
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
						<div class="card-header fw-bold text-warning">
							<span><i class="bi bi-star-fill me-2"></i></span> Featured
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
											<th>Body Type</th>
											<th>Transmission</th>
											<th>Drive Type</th>
											<th>Condition</th>
											<th>Manage</th>
										</tr>
									</thead>

									<tbody>
										<tr>
											<td>01</td>
											<td>Tesla Model 3</td>
											<td>$35,000</td>
											<td>2024</td>
											<td>Sedan</td>
											<td>Automatic</td>
											<td>RWD</td>
											<td>Brand New</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
										<tr>
											<td>02</td>
											<td>Nissan Leaf</td>
											<td>$27,400</td>
											<td>2023</td>
											<td>Hatchback</td>
											<td>Automatic</td>
											<td>FWD</td>
											<td>Used</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
										<tr>
											<td>03</td>
											<td>Chevrolet Bolt</td>
											<td>$31,000</td>
											<td>2024</td>
											<td>Hatchback</td>
											<td>Automatic</td>
											<td>FWD</td>
											<td>Used</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
										<tr>
											<td>04</td>
											<td>BMW i3</td>
											<td>$44,450</td>
											<td>2023</td>
											<td>Hatchback</td>
											<td>Automatic</td>
											<td>RWD</td>
											<td>Brand New</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
										<tr>
											<td>05</td>
											<td>Hyundai Kona Electric</td>
											<td>$37,390</td>
											<td>2024</td>
											<td>SUV</td>
											<td>Automatic</td>
											<td>FWD</td>
											<td>Used</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
										<tr>
											<td>06</td>
											<td>Kia Soul EV</td>
											<td>$33,950</td>
											<td>2023</td>
											<td>SUV</td>
											<td>Automatic</td>
											<td>FWD</td>
											<td>Brand New</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
										<tr>
											<td>07</td>
											<td>Audi e-tron</td>
											<td>$65,900</td>
											<td>2024</td>
											<td>SUV</td>
											<td>Automatic</td>
											<td>AWD</td>
											<td>Used</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
										<tr>
											<td>08</td>
											<td>Mercedes-Benz EQC</td>
											<td>$67,900</td>
											<td>2023</td>
											<td>SUV</td>
											<td>Automatic</td>
											<td>AWD</td>
											<td>Brand New</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
										<tr>
											<td>09</td>
											<td>Jaguar I-PACE</td>
											<td>$69,850</td>
											<td>2024</td>
											<td>SUV</td>
											<td>Automatic</td>
											<td>AWD</td>
											<td>Used</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
										<tr>
											<td>10</td>
											<td>Porsche Taycan</td>
											<td>$79,900</td>
											<td>2023</td>
											<td>Sedan</td>
											<td>Automatic</td>
											<td>AWD</td>
											<td>Brand New</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
										<tr>
											<td>11</td>
											<td>Ford Mustang Mach-E</td>
											<td>$42,895</td>
											<td>2024</td>
											<td>SUV</td>
											<td>Automatic</td>
											<td>RWD</td>
											<td>Used</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
										<tr>
											<td>12</td>
											<td>Volkswagen ID.4</td>
											<td>$39,995</td>
											<td>2023</td>
											<td>SUV</td>
											<td>Automatic</td>
											<td>RWD</td>
											<td>Brand New</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
										<tr>
											<td>13</td>
											<td>Volvo XC40 Recharge</td>
											<td>$53,990</td>
											<td>2024</td>
											<td>SUV</td>
											<td>Automatic</td>
											<td>AWD</td>
											<td>Used</td>
											<td><a href="#"><button type="button"
														class="btn-sm btn-outline-primary">View</button></a></td>
										</tr>
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