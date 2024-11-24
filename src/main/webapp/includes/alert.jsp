
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