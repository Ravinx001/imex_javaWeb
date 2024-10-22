
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
<title>Imex - Admin Profile</title>
</head>

<body>

	<jsp:include page="includes/navigation.jsp" />

	<jsp:include page="includes/offcanvas.jsp" />


	<main>
		<div class="container-fluid px-4">
			<h3 class="mt-4">Profile</h3>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="admin.jsp">Dashboard</a></li>
				<li class="breadcrumb-item active">Profile</li>
			</ol>


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
									<label for="exampleInputPassword1" class="form-label">New Password</label>
									<input type="password" name="password"
										class="form-control" id="exampleInputPassword1">
								</div>

								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Re Enter New Password</label>
									<input type="password" name="repassword"
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