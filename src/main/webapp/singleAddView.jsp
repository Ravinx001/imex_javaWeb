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
<title>Imex Lanka</title>

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
<link rel="stylesheet" href="css/custom/ad-details.css">
<!--=====================================
                    CSS LINK PART END
        =======================================-->
</head>

<body>

	<jsp:include page="includes/header.jsp" />

	<jsp:include page="includes/sidebar.jsp" />

	<jsp:include page="includes/mobilenav.jsp" />

	<!--=====================================
                    AD DETAILS PART START
        =======================================-->
	<section class="inner-section ad-details-part pt-5">
		<div class="container-lg">
			<div class="row">
				<div class="col-12">

					<!-- AD DETAILS CARD -->
					<div class="common-card text-center">

						<div class="ad-details-slider-group">
							<div class="ad-details-slider slider-arrow">
								<div>
									<img src="images/cars/car5.jpg" alt="details">
								</div>
								<div>
									<img src="images/cars/car5(6).jpg" alt="details">
								</div>
								<div>
									<img src="images/cars/car5(3).jpg" alt="details">
								</div>
								<div>
									<img src="images/cars/car5(4).jpg" alt="details">
								</div>
							</div>
						</div>
						<div class="ad-thumb-slider">
							<div>
								<img src="images/cars/car5.jpg" alt="details">
							</div>
							<div>
								<img src="images/cars/car5(6).jpg" alt="details">
							</div>
							<div>
								<img src="images/cars/car5(3).jpg" alt="details">
							</div>
							<div>
								<img src="images/cars/car5(4).jpg" alt="details">
							</div>
						</div>
						<h3 class="ad-details-title">${vehicle.title}</h3>
						<span class="flat-badge rent">${vehicle.categotryName}</span>
					</div>

					<!-- SPECIFICATION CARD -->
					<div class="common-card">
						<div class="card-header">
							<h5 class="card-title">Specification</h5>
						</div>
						<ul class="ad-details-specific">
							<li>
								<h6>Price</h6>
								<p>LKR ${vehicle.price}</p>
							</li>
							<li>
								<h6>Manufacture year</h6>
								<p>${vehicle.manufactureYear}</p>
							</li>
							<li>
								<h6>Model:</h6>
								<p>${vehicle.model}</p>
							</li>
							<li>
								<h6>Model Variant:</h6>
								<p>${vehicle.modelVariant}</p>
							</li>
							<li>
								<h6>Mileage:</h6>
								<p>${vehicle.mileage}</p>
							</li>
							<li>
								<h6>Engine Capacity:</h6>
								<p>${vehicle.engineCapacity}</p>
							</li>
							<li>
								<h6>Transmission</h6>
								<p>${vehicle.transmissionName}</p>
							</li>
							<li>
								<h6>Fuel Type</h6>
								<p>${vehicle.fueltypeName}</p>
							</li>
							<li>
								<h6>Brand</h6>
								<p>${vehicle.brandName}</p>
							</li>
							<li>
								<h6>Condition</h6>
								<p>${vehicle.conditionName}</p>
							</li>
							<li>
								<h6>Featuring</h6>
								<p>${vehicle.featuringName}</p>
							</li>
							<li>
								<h6>Location</h6>
								<p>${vehicle.locationName}</p>
							</li>
						</ul>
					</div>

					<!-- DESCRIPTION CARD -->
					<div class="common-card">
						<div class="card-header">
							<h5 class="card-title">description</h5>
						</div>
						<p class="ad-details-desc">${vehicle.description}</p>
					</div>

					<!-- REVIEWS CARD -->
					<div class="common-card" id="review">
						<div class="card-header">
							<h5 class="card-title">Contact Seller</h5>
						</div>
						<div class="ad-details-review">
							<form action="inquiry" method="post">
								<div class="row">
									<div class="col-12 col-lg-4 p-3">
										<input required type="text" name="name" class="form-control"
											placeholder="Your Name"> <input required type="hidden"
											name="vehicleId" value="${vehicle.vehicleId}" class="form-control">
									</div>
									<div class="col-12 col-lg-4 p-3">
										<input required type="email" name="email" class="form-control"
											placeholder="Your Email">
									</div>
									<div class="col-12 col-lg-4 p-3">
										<input required type="text" name="mobile" class="form-control"
											placeholder="Your Mobile Number">
									</div>
								</div>
								<div class="form-group pt-2">
									<textarea required class="form-control" name="inquiry"
										placeholder="Describe"></textarea>
								</div>
								<button type="submit" class="btn btn-inline review-submit">
									<i class="fas fa-tint"></i> <span>Drop Your Message</span>
								</button>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!--=====================================
                    AD DETAILS PART END
        =======================================-->


	<!--=====================================
                    RELATED PART START
        =======================================-->
	<section class="inner-section related-part">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-center-heading">
						<h2>
							Related <span>Ads</span>
						</h2>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit
							aspernatur illum vel sunt libero voluptatum repudiandae veniam
							maxime tenetur.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="related-slider slider-arrow">
						<div class="product-card">
							<div class="product-media">
								<div class="product-img">
									<img src="images/cars/car1.jpg" alt="product">
								</div>
								<div class="cross-vertical-badge product-badge">
									<i class="fas fa-clipboard-check"></i> <span>recommend</span>
								</div>
								<div class="product-type">
									<span class="flat-badge booking">Used Vehicles</span>
								</div>
								<ul class="product-action">
									<li class="view"><i class="fas fa-eye"></i><span>264</span></li>
								</ul>
							</div>
							<div class="product-content">
								<ol class="breadcrumb product-category">
									<li><i class="fas fa-tags"></i></li>
									<li class="breadcrumb-item">Recommended</li>
								</ol>
								<h5 class="product-title">
									<a href="ad-details-left.html">Lorem ipsum dolor sit amet
										consect adipisicing elit</a>
								</h5>
								<div class="product-meta">
									<span><i class="fas fa-map-marker-alt"></i>Colombo</span> <span><i
										class="fas fa-clock"></i>35 min ago</span>
								</div>
								<div class="product-info">
									<h5 class="product-price">LKR 20 Million</h5>

								</div>
							</div>
						</div>
						<div class="product-card">
							<div class="product-media">
								<div class="product-img">
									<img src="images/gems/gem3.jpg" alt="product">
								</div>
								<div class="cross-vertical-badge product-badge">
									<i class="fas fa-clipboard-check"></i> <span>recommend</span>
								</div>
								<div class="product-type">
									<span class="flat-badge sale">Gems</span>
								</div>
								<ul class="product-action">
									<li class="view"><i class="fas fa-eye"></i><span>264</span></li>
								</ul>
							</div>
							<div class="product-content">
								<ol class="breadcrumb product-category">
									<li><i class="fas fa-tags"></i></li>
									<li class="breadcrumb-item">Recommended</li>
									<h5 class="product-title">
										<a href="ad-details-left.html">Lorem ipsum dolor sit amet
											consect adipisicing elit</a>
									</h5>
									<div class="product-meta">
										<span><i class="fas fa-map-marker-alt"></i>Colombo</span> <span><i
											class="fas fa-clock"></i>4 Days ago</span>
									</div>
									<div class="product-info">
										<h5 class="product-price">LKR 12 Million</h5>
									</div>
							</div>
						</div>
						<div class="product-card">
							<div class="product-media">
								<div class="product-img">
									<img src="images/cars/car2.jpg" alt="product">
								</div>
								<div class="cross-vertical-badge product-badge">
									<i class="fas fa-clipboard-check"></i> <span>recommend</span>
								</div>
								<div class="product-type">
									<span class="flat-badge rent">E-Vehicles</span>
								</div>
								<ul class="product-action">
									<li class="view"><i class="fas fa-eye"></i><span>264</span></li>
								</ul>
							</div>
							<div class="product-content">
								<ol class="breadcrumb product-category">
									<li><i class="fas fa-tags"></i></li>
									<li class="breadcrumb-item">Recommended</li>
								</ol>
								<h5 class="product-title">
									<a href="ad-details-left.html">Lorem ipsum dolor sit amet
										consect adipisicing elit</a>
								</h5>
								<div class="product-meta">
									<span><i class="fas fa-map-marker-alt"></i>Malabe</span> <span><i
										class="fas fa-clock"></i>10 Days ago</span>
								</div>
								<div class="product-info">
									<h5 class="product-price">LKR 11 Million</h5>
								</div>
							</div>
						</div>
						<div class="product-card">
							<div class="product-media">
								<div class="product-img">
									<img src="images/gems/gem4.webp" alt="product">
								</div>

								<div class="product-type">
									<span class="flat-badge sale">Gems</span>
								</div>
								<ul class="product-action">
									<li class="view"><i class="fas fa-eye"></i><span>264</span></li>
								</ul>
							</div>
							<div class="product-content">
								<ol class="breadcrumb product-category">
									<li><i class="fas fa-tags"></i></li>
									<li class="breadcrumb-item">Related</li>
								</ol>
								<h5 class="product-title">
									<a href="ad-details-left.html">Lorem ipsum dolor sit amet
										consect adipisicing elit</a>
								</h5>
								<div class="product-meta">
									<span><i class="fas fa-map-marker-alt"></i>Rathnapura</span> <span><i
										class="fas fa-clock"></i>1 month ago</span>
								</div>
								<div class="product-info">
									<h5 class="product-price">LKR 800,000</h5>
								</div>
							</div>
						</div>
						<div class="product-card">
							<div class="product-media">
								<div class="product-img">
									<img src="images/cars/car5.jpg" alt="product">
								</div>
								<div class="product-type">
									<span class="flat-badge booking">Used Vehicles</span>
								</div>
								<ul class="product-action">
									<li class="view"><i class="fas fa-eye"></i><span>264</span></li>
								</ul>
							</div>
							<div class="product-content">
								<ol class="breadcrumb product-category">
									<li><i class="fas fa-tags"></i></li>
									<li class="breadcrumb-item">Related</li>
								</ol>
								<h5 class="product-title">
									<a href="ad-details-left.html">Lorem ipsum dolor sit amet
										consect adipisicing elit</a>
								</h5>
								<div class="product-meta">
									<span><i class="fas fa-map-marker-alt"></i>Colombo</span> <span><i
										class="fas fa-clock"></i>20 days ago</span>
								</div>
								<div class="product-info">
									<h5 class="product-price">LKR 22 Million</h5>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</section>
	<!--=====================================
                    RELATED PART START
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