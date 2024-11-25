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
<title>Imex Lanka - Contact Us</title>

<!--=====================================
                    CSS LINK PART START
        =======================================-->
<!-- FAVICON -->
<link rel="icon" href="images/blue-logo.png">

<!-- FONTS -->
<link rel="stylesheet" href="fonts/flaticon/flaticon.css">
<link rel="stylesheet" href="fonts/font-awesome/fontawesome.css">

<!-- VENDOR -->
<link rel="stylesheet" href="css/vendor/bootstrap.min.css">

<!-- CUSTOM -->
<link rel="stylesheet" href="css/custom/main.css">
<link rel="stylesheet" href="css/custom/contact.css">
<!--=====================================
                    CSS LINK PART END
        =======================================-->
</head>

<body>
	<jsp:include page="includes/header.jsp" />

	<jsp:include page="includes/sidebar.jsp" />

	<jsp:include page="includes/mobilenav.jsp" />

	<!--=====================================
                  SINGLE BANNER PART START
        =======================================-->
	<section class="single-banner">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="single-content">
						<h2>contact us</h2>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">contact</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--=====================================
                      SINGLE BANNER PART END
            =======================================-->


	<!--=====================================
                        CONTACT PART START
            =======================================-->
	<section class="contact-part">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="contact-info">
						<i class="fas fa-map-marker-alt"></i>
						<h3>Find us</h3>
						<p>
							<a href="https://maps.app.goo.gl/3CtvSWSWsWJhFoF8A">172/B
								Dutugemunu St, <span> Nugegoda 10250.</span>
							</a>
						</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="contact-info">
						<i class="fas fa-phone-alt"></i>
						<h3 class="mt-4">Make a Call</h3>
						<p>
							<a href="tel:077 794 9032">077 794 9032</a>
						</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="contact-info">
						<i class="fas fa-envelope"></i>
						<h3 class="mt-4">Send Mail</h3>
						<p>
							<a href="mailto:info.imexlink@gmail.com">info.imexlink@gmail.com</a>
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<div class="contact-map">
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3961.178895858568!2d79.87923977483496!3d6.8691553931295335!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ae253dd7878c73b%3A0x4bf67af9a0a44e5b!2sIMEX%20LINK%20(PVT)%20LTD!5e0!3m2!1sen!2slk!4v1708970972661!5m2!1sen!2slk"
							width="600" height="450" style="border: 0;" allowfullscreen=""
							loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
					</div>
				</div>
				<div class="col-lg-6">
					<form action="{{ route('contactUsMessage') }}" method="POST"
						class="contact-form">

						<div class="row">
							<div class="col-lg-12">
								<div class="form-group">
									<input type="text" name="customerName" class="form-control"
										placeholder="Your Name" 
										required>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group">
									<input type="email" name="customerEmail" class="form-control"
										placeholder="Your Email" 
										required>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group">
									<input type="mobileNumber" name="customerMobile"
										class="form-control" placeholder="Your Mobile Number"
										 required>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group">
									<input type="subject" name="subject" class="form-control"
										placeholder="Subject"  required>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group">
									<textarea class="form-control" name="message"
										placeholder="Describe" required></textarea>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-btn">
									<button class="btn btn-inline">
										<i class="fas fa-paper-plane"></i> <span>send message</span>
									</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!--=====================================
                        CONTACT PART END
            =======================================-->


	<jsp:include page="includes/footer.jsp" />

	<jsp:include page="includes/alert.jsp" />


	<!--=====================================
                    JS LINK PART START
        =======================================-->
	<!-- VENDOR -->
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<script src="js/vendor/popper.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>

	<!-- CUSTOM -->
	<script src="js/custom/main.js"></script>
	<!--=====================================
                    JS LINK PART END
        =======================================-->
</body>

</html>