<%
if (session.getAttribute("userId") != null) {
	response.sendRedirect("admin.jsp");
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- FOR WEBPAGE TITLE -->
<title>ImexLanka</title>

<!--=====================================
                    CSS LINK PART START
        =======================================-->
<!-- FOR PAGE TITLE ICON -->
<link rel="icon" href="images/blue-logo.png">

<!-- FOR FONTAWESOME -->
<link rel="stylesheet" href="fonts/font-awesome/fontawesome.css">

<!-- FOR BOOTSTRAP -->
<link rel="stylesheet" href="css/vendor/bootstrap.min.css">

<!-- FOR COMMON STYLE -->
<link rel="stylesheet" href="css/custom/main.css">

<!-- FOR USER FORM PAGE STYLE -->
<link rel="stylesheet" href="css/custom/user-form.css">
<!--=====================================
                    CSS LINK PART END
        =======================================-->
</head>
<body>
	<!--=====================================
                    USER-FORM PART START
        =======================================-->
	<section class="user-form-part">
		<div class="user-form-banner">
			<div class="user-form-content">
				<a href="index.jsp"><img src="images/blue-logo.png" alt="logo"></a>
				<h1>The Best place to Buy Your Dream Vehicle</h1>
				<p>
					#First Sri Lankan company to Import Electric Vehicles<br /> Those
					who qualify for the government-issued licence to import electric
					automobiles for foriegn wokers
				</p>
			</div>
		</div>

		<div class="user-form-category">
			<div class="user-form-header">
				<a href="index.jsp"><i class="fas fa-arrow-left"></i></a>
			</div>

			<div class="tab-pane active mt-5 pt-5" id="login-tab">
				<div class="user-form-title">
					<h2>Admin Login</h2>
				</div>
				<form action="login" method="post">
					<div class="row">
						<div class="col-12">
							<div class="form-group">
								<input type="email" name="email" class="form-control"
									placeholder="Email">
							</div>
						</div>
						<div class="col-12">
							<div class="form-group">
								<input type="password" name="password" class="form-control"
									id="pass" placeholder="Password">
								<button type="button" class="form-icon">
									<i class="eye fas fa-eye"></i>
								</button>
							</div>
						</div>

						<div class="col-12">
							<div class="form-group">
								<button type="submit" class="btn btn-inline">
									<i class="fas fa-unlock"></i> <span>Login</span>
								</button>
							</div>
						</div>

					</div>
				</form>

			</div>

		</div>

	</section>
	<!--=====================================
                    USER-FORM PART END
        =======================================-->


	<!--=====================================
                    JS LINK PART START
        =======================================-->
	<!-- FOR BOOTSTRAP -->
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<script src="js/vendor/popper.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>

	<!-- FOR INTERACTION -->
	<script src="js/custom/main.js"></script>

		
	<jsp:include page="includes/alert.jsp" />
</body>
</html>






