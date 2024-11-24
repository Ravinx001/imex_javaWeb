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
<title>Imex Lanka - Ads</title>

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
<link
	href="https://cdn.jsdelivr.net/npm/sweetalert2@11.14.3/dist/sweetalert2.min.css"
	rel="stylesheet">

<!-- CUSTOM -->
<link rel="stylesheet" href="css/custom/main.css">
<link rel="stylesheet" href="css/custom/index.css">
<!--=====================================
                    CSS LINK PART END
        =======================================-->
</head>

<body>

	<jsp:include page="includes/header.jsp" />

	<jsp:include page="includes/sidebar.jsp" />

	<jsp:include page="includes/mobilenav.jsp" />

	<!--=====================================
                    BANNER PART START
        =======================================-->
	<section class="banner-part">
		<div class="container">
			<div class="banner-content">
				<h1>The best place to #Buy Your Dream Vehicle</h1>
				<p>
					#First Sri Lankan company to Import Electric Vehicles<br /> Those
					who qualify for the government-issued licence to import electric
					automobiles for foriegn wokers
				</p>
				<a href="allads" class="btn btn-outline"> <i class="fas fa-eye"></i>
					<span>Show all ads</span>
				</a>
			</div>
		</div>
	</section>
	<!--=====================================
                    BANNER PART END
        =======================================-->


	<!--=====================================
                    SUGGEST PART START
        =======================================-->
	<section class="suggest-part">
		<div class="container">
			<div class="suggest-slider slider-arrow">
				<c:forEach var="brand" items="${brands}">
					<a href="#" class="suggest-card">
						<h6>${brand.brandName}</h6>
					</a>
				</c:forEach>
			</div>
		</div>
	</section>
	<!--=====================================
                    SUGGEST PART END
        =======================================-->



	<!--=====================================
                    FEATURE1 PART START
        =======================================-->
	<section class="section feature-part">
		<div class="container">
			<div class="row">
				<div class="col-md-5 col-lg-5">
					<div class="section-side-heading">
						<h2>
							Find your dream Brand New automobile in our <span>Brand
								New</span> category
						</h2>
						<p>Chase your dreams with modernity integrated with latest
							technology. Experience a comfortable, smooth ride.</p>
						<a href="#" class="btn btn-inline"> <i class="fas fa-eye"></i>
							<span>view all</span>
						</a>
					</div>
				</div>
				<div class="col-md-7 col-lg-7">
					<div class="feature-card-slider slider-arrow">
						<c:if test="${not empty newvehicles}">
							<c:forEach var="newvehicle" items="${newvehicles}">
								<div class="feature-card">
									<a href="viewadd?vehicleId=${newvehicle.vehicleId}"
										class="feature-img"> <img src="images/cars/car1.jpg"
										alt="feature">
									</a>
									<div class="cross-inline-badge feature-badge">
										<span>featured</span>
									</div>
									<div class="feature-content">
										<ol class="breadcrumb feature-category">
											<li><span class="flat-badge rent">${newvehicle.conditionName}</span></li>
										</ol>
										<h3 class="feature-title">
											<a href="viewadd?vehicleId=${newvehicle.vehicleId}">${newvehicle.title}</a>
										</h3>
										<div class="feature-meta">
											<span class="feature-price">LKR ${newvehicle.price}</span>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:if>

						<c:if test="${empty newvehicles}">
							<h4>No vehicles available at the moment.</h4>
						</c:if>

					</div>
					<div class="feature-thumb-slider">
						<c:forEach var="newvehicle" items="${newvehicles}">
							<div class="feature-thumb">
								<img src="images/cars/car1.jpg" alt="feature">
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--=====================================
                    FEATURE1 PART END
        =======================================-->



	<!--=====================================
                    FEATURE2 PART START
        =======================================-->
	<section class="section feature-part">
		<div class="container">
			<div class="row">

				<div class="col-md-5 col-lg-5">
					<div class="section-side-heading">
						<h2>
							Find your ideal used car from our <span>Used Vehicles</span>
							category
						</h2>
						<p>Built to last, built to drive. Find your ideal match from
							our trusted, local selection of dependable & fuel-efficient used
							cars.</p>
						<a href="#" class="btn btn-inline"> <i class="fas fa-eye"></i>
							<span>view all</span>
						</a>
					</div>
				</div>

				<div class="col-md-7 col-lg-7">
					<div class="feature-card-slider slider-arrow">

						<c:if test="${not empty usedvehicles}">
							<c:forEach var="usedvehicle" items="${usedvehicles}">
								<div class="feature-card">
									<a href="viewadd?vehicleId=${usedvehicle.vehicleId}"
										class="feature-img"> <img src="images/cars/car5.jpg"
										alt="feature">
									</a>
									<div class="cross-inline-badge feature-badge">
										<span>featured</span>
									</div>
									<div class="feature-content">
										<ol class="breadcrumb feature-category">
											<li><span class="flat-badge booking">${usedvehicle.conditionName}</span></li>
										</ol>
										<h3 class="feature-title">
											<a href="viewadd?vehicleId=${usedvehicle.vehicleId}">${usedvehicle.title}</a>
										</h3>
										<div class="feature-meta">
											<span class="feature-price">LKR ${usedvehicle.price}</span>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:if>

						<c:if test="${empty usedvehicles}">
							<h4>No vehicles available at the moment.</h4>
						</c:if>

					</div>

					<div class="feature-thumb-slider">
						<c:forEach var="usedvehicle" items="${usedvehicles}">
							<div class="feature-thumb">
								<img src="images/cars/car5.jpg" alt="feature">
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--=====================================
                    FEATURE2 PART END
        =======================================-->



	<!--=====================================
                    RECOMEND PART START
        =======================================-->
	<section class="section recomend-part">
		<div class="container">

			<div class="row">
				<div class="col-lg-12">
					<div class="section-center-heading">
						<h2>
							Our Recommend <span>Ads</span>
						</h2>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit
							aspernatur illum vel sunt libero voluptatum repudiandae veniam
							maxime tenetur.</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="recomend-slider slider-arrow">

						<c:forEach var="recomendedvehicle" items="${recomendedvehicles}">
							<div class="product-card">
								<a href="viewadd?vehicleId=${recomendedvehicle.vehicleId}">
									<div class="product-media">
										<div class="product-img">
											<img src="images/cars/car5.jpg" alt="product">
										</div>
										<div class="cross-vertical-badge product-badge">
											<i class="fas fa-clipboard-check"></i> <span>recommend</span>
										</div>
										<div class="product-type">
											<span class="flat-badge booking">${recomendedvehicle.conditionName}</span>
										</div>
										<ul class="product-action">
											<li class="view"><i class="fas fa-eye"></i><span>0</span></li>
										</ul>
									</div>
									<div class="product-content">
										<ol class="breadcrumb product-category">
											<li><i class="fas fa-tags"></i></li>
											<li class="breadcrumb-item">Recommended</li>
										</ol>
										<h5 class="product-title">
											<a href="viewadd?vehicleId=${recomendedvehicle.vehicleId}">${recomendedvehicle.title}</a>
										</h5>
										<div class="product-meta">
											<span><i class="fas fa-map-marker-alt"></i>${recomendedvehicle.locationName}</span>
										</div>
										<div class="product-info">
											<h5 class="product-price">LKR ${recomendedvehicle.price}</h5>

										</div>
									</div>
								</a>
							</div>

						</c:forEach>

					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="center-50">
						<a href="allads" class="btn btn-inline"> <i
							class="fas fa-eye"></i> <span>view all recommend</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--=====================================
                    RECOMEND PART START
        =======================================-->


	<!--=====================================
                    CATEGORY PART START
        =======================================-->
	<section class="section category-part">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-center-heading">
						<h2>
							Top Categories by <span>Ads</span>
						</h2>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit
							aspernatur illum vel sunt libero voluptatum repudiandae veniam
							maxime tenetur.</p>
					</div>
				</div>
			</div>
			<div class="row">

				<c:forEach var="category" items="${categories}">
					<div class="col-sm-6 col-md-6 col-lg-4 col-xl-3">
						<div class="category-card">
							<div class="category-head">
								<img src="images/cars/car5.jpg" alt="category"> <a
									href="#" class="category-content">
									<h4>${category.categoryName}</h4>
								</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
	</section>
	<!--=====================================
                    CATEGORY PART END
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
	<!--=====================================
                    FOOTER PART END
        =======================================-->
	<jsp:include page="includes/alert.jsp" />

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
