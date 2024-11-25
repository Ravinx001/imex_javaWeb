<c:if test="${not empty sessionScope.status}">

	<c:if test="${not empty sessionScope.validation}">

		<script>alert(${sessionScope.validation});</script>

		<c:remove var="status" />
		<c:remove var="validation" />
	</c:if>

</c:if>