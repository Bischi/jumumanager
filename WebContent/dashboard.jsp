<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
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

<title>JumuManager</title>

<!-- Bootstrap core CSS -->
<link href="./bootstrap/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="./bootstrap/bootstrap.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="./bootstrap/ie-emulation-modes-warning.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
  <script src="./res/group.js"> </script>  <!--Groupconfig-->
  <script src="./res/member.js"> </script> <!--Memberconfig-->
  <script src="./res/termin.js"> </script> <!--Terminconfig-->
  <script src="./res/lists.js"> </script> <!--get InstrumentList,... -->
<!-- <link rel="icon" href="http://getbootstrap.com/favicon.ico"> -->

<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(document).on("click", "#GroupButton", function() {
					loadGroupList();
					viewGroupList();
					hideMainPage();
				});
				$(document).on("click", ".editGroupButton", function() {
					var selectedGroupID = $(this).attr('name');
					var newGroupName = prompt("Neuer Gruppenname: ");
					updateGroup(selectedGroupID, newGroupName);
				});
				$(document).on("click", ".deleteGroupButton", function() {
					var selectedGroupID = $(this).attr('name');
					deleteGroup(selectedGroupID);
				});
				$(document).on("click", "#MemberButton", function() {
					loadMemberList();
					viewMemberList();
					hideMainPage();
				});
				$(document).on("click",	".editMemberButton", function() {
							var selectedMemberID = $(this).attr('name');
							editMemberdata();
							updateMember(selectedMemberID, fname, lname, email,	passwd, instrument, group); //Update of Userdata
						});
				$(document).on("click", ".deleteMemberButton", function() {
					var selectedMemberID = $(this).attr('name');
					deleteMember(selectedMemberID);
				});
				$(document).on("click", "#TerminButton", function() {
					loadTerminList();
					viewTerminList();
					hideMainPage();
				});
        $(document).on("click", "#addMemberButton", function() {
          hideMemberList();
          getInstrumentList();
          getRightList();
          fillGroupSelect(); // Selection button for selecting group
          viewMemberEditContainer();
					hideMainPage(); 
				});
        $(document).on("click", "#saveMemberButton", function() {
          addMember();
          loadMemberList();
          //hideMemberEditConfig();
          //viewMemberList();
				});
			});

	function hideMainPage() {
		$(".mainpage").hide();
	}
  
    

</script>
<body>

	<!-- Fixed navbar -->
	<div class="row">
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">JumuManager</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="./dashboard.jsp">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li><a href="#logout">Logout</a></li>
					
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		</nav>
	</div>
	<!-- Begin page content -->

	<div style="margin-top: 50px" class="container mainpage">
		<div class="page-header">
			<h1>DASHBOARD</h1>
		</div>
		<p class="lead">
			
		</p>


		<div class="row">
			<div class="col-md-4">
				<button type="submit" class="btn btn-default" id="GroupButton">
					<img data-holder-rendered="true" src="./img/group.svg"
						style="width: 140px; height: 140px;" data-src="holder.js/140x140"
						class="img-rounded" alt="140x140">
					<p class="lead">Gruppeneinstellung</p>
				</button>
			</div>
			<div class="col-md-4">
				<button type="submit" class="btn btn-default" id="MemberButton">
					<img data-holder-rendered="true" src="./img/members.svg"
						style="width: 140px; height: 140px;" data-src="holder.js/140x140"
						class="img-rounded" alt="140x140">
					<p class="lead">Mitglieder</p>
				</button>
			</div>
			<div class="col-md-4">
				<button type="submit" class="btn btn-default" id="TerminButton">
					<img data-holder-rendered="true" src="./img/calendar.svg"
						style="width: 140px; height: 140px;" data-src="holder.js/140x140"
						class="img-rounded" alt="140x140">
					<p class="lead">Termine</p>
				</button>
			</div>
		</div>
	</div>

	<div class="conatiner" style="display: none">
		<div class="bs-callout bs-callout-info calloutADD"
			id="callout-type-b-i-elems" style="display: none">
			<h4 id="alternate-elements">
				Hinweis!<a class="anchorjs-link" href="#alternate-elements"><span
					class="anchorjs-icon"></span></a>
			</h4>
			<p>Add successful!</p>
		</div>
		<div class="bs-callout bs-callout-info calloutUPDATE"
			id="callout-type-b-i-elems" style="display: none">
			<h4 id="alternate-elements">
				Hinweis!<a class="anchorjs-link" href="#alternate-elements"><span
					class="anchorjs-icon"></span></a>
			</h4>
			<p>Update successful!</p>
		</div>
		<div class="bs-callout bs-callout-info calloutDELETE"
			id="callout-type-b-i-elems" style="display: none">
			<h4 id="alternate-elements">
				Hinweis!<a class="anchorjs-link" href="#alternate-elements"><span
					class="anchorjs-icon"></span></a>
			</h4>
			<p>Delete successful!</p>
		</div>
	</div>
	<div class="container editMemberContainer" style="display: none">
		// Membereditansicht
		<div class="page-header">
			<h1>Userdata</h1>
		</div>
		<table class="table table-hover" id="editMemberConfigData">
      <tr><td><label for="fnameInput">Vorname</label><input type="text" class="form-control" placeholder="Vorname" id="fnameInput" /></td>
          <td><label for="lnameInput">Nachname</label><input type="text" class="form-control" placeholder="Nachname" id="lnameInput" /></td>
      </tr>
      <tr>
          <td><label for="emailInput">Email</label><input type="email" class="form-control" placeholder="Email" id="emailInput" /></td>
          <td><label for="passwdInput">Passwort</label><input type="password" class="form-control" placeholder="Password" id="passwdInput" /></td>
      </tr>
      <tr> 
        <td><label for="instrumentSelect">Instrument</label><select id="instrumentSelect" class="form-control"></select></td>
        <td><label for="groupSelect">Gruppe</label><select id="groupSelect" class="form-control"></select></td>
      </tr>
      <tr>
        <td><label for="rightSelect">Rechte</label><select id="rightSelect" class="form-control"></select></td>
      </tr>
      
    </table>
    <button type="submit" class="btn btn-default" id="saveMemberButton" style="font-size: 17px;"><img data-holder-rendered="true" src="./img/personadd.svg" style="width: 24px; height: 24px;" data-src="holder.js/140x140" class="img-rounded" alt="30x30">
					Save
				</button>
	</div>

	<div class="container GroupContainer" style="display: none">
		// Gruppenansicht
		<div class="page-header">
			<h1>Groupmanagment</h1>
		</div>
		<table class="table table-hover" id="Groupconfig"></table>
	</div>
	<div class="container MemberContainer" style="display: none">
		// Mitgliederansicht
		<div class="page-header">
      <h1>Usermanagement</h1> <button type="submit" class="btn btn-primary" id="addMemberButton" style="font-size: 17px;"><img data-holder-rendered="true" src="./img/personadd.svg" style="width: 24px; height: 24px;" data-src="holder.js/140x140" class="img-rounded" alt="50x30">   neuer User</button>
		</div>
		<table class="table table-hover" id="Memberconfig"></table>
	</div>
	<div class="container TerminContainer" style="display: none">
		// Mitgliederansicht
		<div class="page-header">
			<h1>Terminmanagement</h1>
		</div>
		<table class="table table-hover" id="Terminconfig"></table>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="res/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="bootstrap/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>

