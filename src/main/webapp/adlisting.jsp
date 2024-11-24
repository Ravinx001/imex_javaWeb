<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!--=====================================
                    META-TAG PART START
        =======================================-->
<!-- REQUIRE META -->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--=====================================
                    META-TAG PART END
        =======================================-->

<!-- FOR WEBPAGE TITLE -->
<title>Imex Lanka - All Ads</title>

<!--=====================================
                    CSS LINK PART START
        =======================================-->
<!-- FAVICON -->
<link rel="icon" href="images/blue-logo.png">

<!-- FONTS -->
<link rel="stylesheet" href="fonts/flaticon/flaticon.css">
<link rel="stylesheet" href="fonts/font-awesome/fontawesome.css">

<!-- VENDOR -->
<link rel="stylesheet" href="css/vendor/slick.min.css">
<link rel="stylesheet" href="css/vendor/bootstrap.min.css">

<!-- CUSTOM -->
<link rel="stylesheet" href="css/custom/main.css">
<!--=====================================
                    CSS LINK PART END
        =======================================-->
</head>

<body>

	<jsp:include page="includes/header.jsp" />

	<jsp:include page="includes/sidebar.jsp" />

	<jsp:include page="includes/mobilenav.jsp" />

	<!--=====================================
                    AD LIST PART START
        =======================================-->
	<section class="inner-section ad-list-part mt-4">
		<div class="container">
			<div class="row">

				<div class="col-lg-4 col-xl-3">
					<div class="row">
						<div class="col-md-6 col-lg-12">
							<div class="product-widget">
								<h6 class="product-widget-title">Filter by Price</h6>

								<form class="product-widget-form" action="allads" method="post">

									<div class="search-input">
										<input type="text" name="title"
											value="<%=request.getAttribute("title") != null ? request.getAttribute("title") : ""%>"
											placeholder="Search by Name or Title">
									</div>
									<div class="product-widget-group mb-4">
										<input type="number"
											value="${not empty requestScope.price_min && requestScope.price_min != -1 ? requestScope.price_min : ''}"
											name="price-min" placeholder="min price"> <input
											type="number"
											value="${not empty requestScope.price_max && requestScope.price_max != -1 ? requestScope.price_max : ''}"
											name="price-max" placeholder="max price">

									</div>

									<ul class="product-widget-list mb-4">
										<li class="product-widget-item">
											<div class="product-widget-checkbox">
												<input type="checkbox" name="condition-nr" value="1"
													id="check2"
													${not empty requestScope.condition_nr && requestScope.condition_nr != -1 ? 'checked' : ''}>

											</div> <label class="product-widget-label" for="chcek2"> <span
												class="product-widget-type rent">Brand New -
													Registered</span>
										</label>
										</li>
										<li class="product-widget-item">
											<div class="product-widget-checkbox">
												<input type="checkbox" name="condition-nur" value="2"
													id="chcek1"
													${not empty requestScope.condition_nur && requestScope.condition_nur != -1 ? 'checked' : ''}>
											</div> <label class="product-widget-label" for="chcek1"> <span
												class="product-widget-type sale">Brand New - Un
													Registered</span>
										</label>
										</li>
										<li class="product-widget-item">
											<div class="product-widget-checkbox">
												<input type="checkbox" name="condition-ur" value="3"
													id="chcek3"
													${not empty requestScope.condition_ur && requestScope.condition_ur != -1 ? 'checked' : ''}>
											</div> <label class="product-widget-label" for="chcek3"> <span
												class="product-widget-type booking">Used - Registered</span>
										</label>
										</li>
										<li class="product-widget-item">
											<div class="product-widget-checkbox">
												<input type="checkbox" name="condition-uur" value="4"
													id="chcek4"
													${not empty requestScope.condition_uur && requestScope.condition_uur != -1 ? 'checked' : ''}>
											</div> <label class="product-widget-label" for="chcek4"> <span
												class="product-widget-type manufac">Used - Un
													Registered</span>
										</label>
										</li>
									</ul>
									<button type="submit" class="product-widget-btn mb-3">
										<i class="fas fa-search"></i> <span>search</span>
									</button>

									<a href="allads" type="button" class="product-widget-btn">
										<i class="fas fa-broom"></i> <span>Clear Filter</span>
									</a>
								</form>

							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-8 col-xl-9">

					<div class="row">
						<div class="col-lg-12">
							<div class="ad-feature-slider slider-arrow">

								<c:forEach var="recomendedvehicle" items="${recomendedvehicles}">

									<div class="feature-card">
										<a href="viewadd?vehicleId=${recomendedvehicle.vehicleId}"
											class="feature-img"> <img src="images/cars/car5.jpg"
											alt="feature">
										</a>
										<div class="cross-inline-badge feature-badge">
											<span>Recommended</span>
										</div>
										<div class="feature-content">
											<ol class="breadcrumb feature-category">
												<li><span class="flat-badge booking">${recomendedvehicle.conditionName}</span></li>
											</ol>
											<h3 class="feature-title">
												<a href="viewadd?vehicleId=${recomendedvehicle.vehicleId}">${recomendedvehicle.title}</a>
											</h3>
											<div class="feature-meta">
												<span class="feature-price">LKR
													${recomendedvehicle.price}</span>
											</div>
										</div>
									</div>

								</c:forEach>

							</div>
						</div>
					</div>

					<div class="row">

						<c:forEach var="allvehicle" items="${allvehicles}">

							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
								<div class="product-card standard">
									<div class="product-media">
										<div class="product-img">
											<img src="images/cars/car1.jpg" alt="product">
										</div>
										<div class="product-type">
											<span class="flat-badge booking">${allvehicle.conditionName}</span>
										</div>
										<ul class="product-action">
											<li class="view"><i class="fas fa-eye"></i><span>264</span></li>
										</ul>
									</div>
									<div class="product-content">
										<ol class="breadcrumb product-category">
											<li class="breadcrumb-item">
												<h3>
													<a href="viewadd?vehicleId=${allvehicle.vehicleId}">${allvehicle.title}</a>
												</h3>
											</li>
										</ol>
										<h5 class="product-title">
											<a href="viewadd?vehicleId=${allvehicle.vehicleId}">${allvehicle.description}</a>
										</h5>
										<div class="product-meta">
											<span><i class="fas fa-map-marker-alt"></i>${allvehicle.locationName}</span>
										</div>
										<div class="product-info">
											<h5 class="product-price">LKR ${allvehicle.price}</h5>
										</div>
									</div>
								</div>
							</div>

						</c:forEach>

					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="footer-pagection">
								<p class="page-info">Showing 12 of 60 Results</p>
								<ul class="pagination">
									<li class="page-item"><a class="page-link" href="#"> <i
											class="fas fa-long-arrow-alt-left"></i>
									</a></li>
									<li class="page-item"><a class="page-link active" href="#">1</a></li>
									<li class="page-item"><a class="page-link" href="#">2</a></li>
									<li class="page-item"><a class="page-link" href="#">3</a></li>
									<li class="page-item">...</li>
									<li class="page-item"><a class="page-link" href="#">67</a></li>
									<li class="page-item"><a class="page-link" href="#"> <i
											class="fas fa-long-arrow-alt-right"></i>
									</a></li>
								</ul>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!--=====================================
                    AD LIST PART END
        =======================================-->



	<!--=====================================
                    FOOTER PART PART
        =======================================-->
	<footer class="footer-part">
		<div class="container">

			<div class="row mb-5 pb-5">
				<div class="col-sm-6 col-md-6 col-lg-3">
					<div class="footer-content">
						<h3>Contact Us</h3>
						<ul class="footer-address">
							<li><i class="fas fa-map-marker-alt"></i>
								<p>
									172/B Dutugemunu St,<span>Nugegoda 10250.</span>
								</p></li>
							<li><i class="fas fa-envelope"></i>
								<p>
									info@imexlanka.com<span></span>
								</p></li>
							<li><i class="fas fa-phone-alt"></i>
								<p>
									077 794 9032<span></span>
								</p></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-md-6 col-lg-3">
					<div class="footer-content">
						<h3>Quick Links</h3>
						<ul class="footer-widget">
							<li><a href="#">Store Location</a></li>
							<li><a href="#">Faq</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-md-6 col-lg-3">
					<div class="footer-content">
						<h3>Information</h3>
						<ul class="footer-widget">
							<li><a href="about.html">About Us</a></li>
							<li><a href="contact.html">Contact Us</a></li>
							<li><a href="#">Sitemap</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-md-6 col-lg-3">
					<div class="footer-info">
						<div>
							<a href="#"><img class="footer-logo"
								src="images/blue-logo.png" alt="logo"></a>
						</div>
						<ul class="footer-count">
							<li>
								<h5>242,789</h5>
								<p>Ads</p>
							</li>
						</ul>
					</div>
				</div>
			</div>

		</div>
		<div class="footer-end">
			<div class="container">
				<div class="footer-end-content">
					<p>All Copyrights Reserved &copy; 2024</p>
					<ul class="footer-social">
						<li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
						<li><a href="#"><i class="fab fa-twitter"></i></a></li>
						<li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
						<li><a href="#"><i class="fab fa-youtube"></i></a></li>
						<li><a href="#"><i class="fab fa-instagram"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>

	<jsp:include page="includes/alert.jsp" />
	<!--=====================================
                        FOOTER PART END
            =======================================-->


	<!--=====================================
                    JS LINK PART START
        =======================================-->
	<!-- VENDOR -->
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<script src="js/vendor/popper.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/vendor/slick.min.js"></script>

	<!-- CUSTOM -->
	<script src="js/custom/slick.js"></script>
	<script src="js/custom/main.js"></script>
	<!--=====================================
                    JS LINK PART END
        =======================================-->
</body>

</html>