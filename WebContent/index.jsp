<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="img/note.ico">

<title>Login</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="bootstrap/signin.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="bootstrap/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="res/jquery.js"></script>
<script src="res/sha256.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(document).on("click", "#loginButton", function() {

			loginUser();
		});
		
		$(document).keydown(function (e) {
			  if (e.keyCode == 13) {
			    loginUser();
			  }
			});
	});

	function loginUser() {
		var user = {};
		user.email = $('#inputmail').val();
		user.passwd = $('#inputPassword').val();
		
		$.ajax({
			contentType : 'application/json',
			type : 'POST',
			url : '/JumuManagerWebGIT/api/logincheck',
			data : JSON.stringify(user),
			success : function() {
				window.location.href = "dashboard.jsp";
			},
			error : function(e) {
				if (e.status == 200) {
					window.location.href = "dashboard.jsp";
					return;
				}
				$('#alertLogin').fadeIn('slow').delay(10000).fadeOut("slow");
				console.log(e);
			}

		});

	}
</script>

</head>

<body>

	<div class="container">
		<img src="img/logo.png" class="img-responsive center-block"
			alt="Responsive image">

		<form class="form-signin" method="post" action="#">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label> <input
				id="inputmail" class="form-control" placeholder="Email address"
				required="" autofocus="" type="email" name="email"> <label
				for="inputPassword" class="sr-only">Password</label> <input
				id="inputPassword" class="form-control" placeholder="Password"
				required="" type="password" name="passwd">
			<div class="checkbox">
				<label> <input value="remember-me" type="checkbox">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" id="loginButton"
				type="button">Login</button>
		</form>

		<div id="alertLogin" class="alert alert-danger" role="alert" style="display:none">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">Error:</span> Enter a valid email address or/and password
		</div>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="login/login_files/ie10-viewport-bug-workaround.js"></script>


</body>
</html>