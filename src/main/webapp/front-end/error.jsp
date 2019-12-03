<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Error - Game Design Document</title>
		<script type="text/javascript">
			function redirect()
			{
				// Redirect the user to the proper error page
				var elem = document.getElementById("redirect-link");
				elem.click();
			}
		</script>
	</head>
	<body onload="redirect()">
		<p>You should be redirected soon...</p>
		<a id="redirect-link" href="/front-end/error.jsf"></a>
	</body>
</html>