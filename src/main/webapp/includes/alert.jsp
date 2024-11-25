<button onclick="topFunction()" id="myBtn" class="mb-5 mb-lg-0"
	title="Go to top">
	<img src="images/arrow-small-up.png">
</button>

<input type="hidden" id="status"
	value="<%=request.getAttribute("status")%>">
<input type="hidden" id="validation"
	value="<%=request.getAttribute("validation")%>">

<link
	href="https://cdn.jsdelivr.net/npm/sweetalert2@11.14.3/dist/sweetalert2.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.14.3/dist/sweetalert2.all.min.js"></script>

<script>
var status = document.getElementById("status").value;
var validation = document.getElementById("validation").value;

	if (status == "failed" && validation != "null") {
		Swal.fire({
			title : "<%=request.getAttribute("validation")%>",
			icon : "error"
		});
		
	}

	if (status == "success" && validation != "null") {
		Swal.fire({
			title : "<%=request.getAttribute("validation")%>
	",
			icon : "success"
		});

	}
</script>

<input type="hidden" id="url_status"
	value="<%=request.getParameter("status")%>">
<input type="hidden" id="url_validation"
	value="<%=request.getParameter("validation")%>">

<script>
	var status = document.getElementById("url_status").value;
	var validation = document.getElementById("url_validation").value;

	if (status == "failed" && validation) { // Check for status and non-null validation
		Swal.fire({
			title : decodeURIComponent(validation), // Decode URL-encoded text
			icon : "error"
		});
	}

	if (status == "success" && validation) {
		Swal.fire({
			title : decodeURIComponent(validation),
			icon : "success"
		});
	}
</script>

