
<!-- top navigation bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container-fluid">
		<button class="navbar-toggler" type="button"
			data-bs-toggle="offcanvas" data-bs-target="#sidebar"
			aria-controls="offcanvasExample">
			<span class="navbar-toggler-icon" data-bs-target="#sidebar"></span>
		</button>
		<a class="navbar-brand me-auto ms-lg-0 ms-3 text-uppercase fw-bold"
			href="inquiry">Admin Panel</a>

		<div class="btn-group ms-auto">
			<a class="nav-link dropdown-toggle ms-auto text-white"
				data-bs-toggle="dropdown" data-bs-toggle="static"
				aria-expanded="false"> <i class="bi bi-person-fill me-1"></i> <%=session.getAttribute("name")%>
			</a>
			<ul class="dropdown-menu dropdown-menu-dark dropdown-menu-end mt-3">
				<li><a class="dropdown-item" href="profile.jsp">Profile</a></li>
				<li>
					<hr class="dropdown-divider">
				</li>
				<li><a class="dropdown-item" href="logout">Log out</a></li>
			</ul>
		</div>
		
	</div>
</nav>
<!-- top navigation bar -->