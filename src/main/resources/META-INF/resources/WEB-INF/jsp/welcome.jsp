<html>
<head>
<title>Welcome Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<%@ include file="common/nav.jspf"%>
</head>
<body>
    <div class="container">
	    <h1>Welcome, ${name}</h1>
	    <hr>
	    <a href="list-todos">Manage Todo's</a>
    </div>
</body>
</html>