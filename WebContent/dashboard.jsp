<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- <link rel="icon" href="http://getbootstrap.com/favicon.ico"> -->

    <title>JumuManager</title>

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./bootstrap/bootstrap.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="bootstrap/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
    
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="res/jquery.js"></script>
    <script type="text/javascript">

        $(document).ready(function(){  
          $(document).on("click", "#GroupConfigButton",function(){ loadGroupList(); viewGroupList(); hideMainPage(); });
          $(document).on("click", ".editGroupButton",function(){            
            //Select name where id = buttonname
            var selectedGroupID =  $(this).attr('name');
            var newGroupName = prompt("Neuer Gruppenname: ");
            updateGroup(selectedGroupID, newGroupName);
            });
          $(document).on("click", ".deleteGroupButton",function(){
            //Select name where id = buttonname
            var selectedGroupID =  $(this).attr('name');
            deleteGroup(selectedGroupID);
            }); 
          $(document).on("click", "#MemberButton",function(){ loadMemberList(); viewMemberList(); hideMainPage(); });
          
        });
            
            
        function hideMainPage()
        {
            $(".mainpage").hide();
        } 
        //Groupmanagement
            
        function loadGroupList()
        {
            $.ajax({ headers:{Accept:'application/json'}, type:'GET', url: "/JumuManagerWebGIT/api/groups", 
            success: function(response)
            {
                var code ="<thead><tr><th>#</th><th>Groupname</th></tr></thead><tbody>"; 
                for(i=0;i<response.group.length;i++)
                {	
                    code = code + '<tr><th scope="row">'+(i+1)+'</th><td width="90%">'+ response.group[i].name +'</td><td><option value='+response.group[i].id+'></td><td width="5%"></option><button type="button" class="btn btn-warning editGroupButton" name="'+response.group[i].id+'">edit</button></td><td width="5%"><button type="button" class="btn btn-danger deleteGroupButton" name="'+response.group[i].id+'">delete</button></td></tr>'; 

                }
                code = code + "</tbody>";
                $("#Groupconfig").html(code);
            },
            error : function(e){console.log(e);} });
        }

        function viewGroupList()
        {
            $(".GroupContainer").fadeIn("slow");
        }
            
        function hideGroupList()
        {
            $(".GroupContainer").hide();
        }
      
      function updateGroup(id, newGroupName)
      {
        var group = {};
        group.id=id;
        group.name=newGroupName;
          $.ajax({
          headers:{Accept:'application/json'}, 
          contentType:'application/json',
          type:'PUT',
          url: '/JumuManagerWebGIT/api/groups/'+id,
          data: JSON.stringify(group),
          success: function(response)
          {
              $(".calloutUPDATE").fadeIn("slow");
              $(".calloutUPDATE").delay(3000).fadeOut("fast");
              loadGroupList();
          },
          error : function(e){console.log(e);}
          });
      }
      
      function deleteGroup(id)
      {
        $.ajax({
        headers:{Accept:'application/json'}, 
        contentType:'application/json',
        type:'DELETE',
        url: '/JumuManagerWebGIT/api/groups/'+id,
        success: function(response)
        {
            $(".calloutDELETE").fadeIn("slow");
            $(".calloutDELETE").delay(3000).fadeOut("fast");
            loadGroupList();
        },
        error : function(e){console.log(e);}
        });
      }
      
      function viewMemberList()
      {
        $.ajax({ headers:{Accept:'application/json'}, type:'GET', url: "/JumuManagerWebGIT/api/group/user", 
            success: function(response)
            {
                var code ="<thead><tr><th>#</th><th>Groupname</th></tr></thead><tbody>"; 
                for(i=0;i<response.group.length;i++)
                {
                    code = code + '<tr><th scope="row">'+(i+1)+'</th><td width="90%">'+ response.group[i].name +'</td><td><option value='+response.group[i].id+'></td><td width="5%"></option><button type="button" class="btn btn-warning editGroupButton" name="'+response.group[i].id+'">edit</button></td><td width="5%"><button type="button" class="btn btn-danger deleteGroupButton" name="'+response.group[i].id+'">delete</button></td></tr>'; 
                }
                code = code + "</tbody>";
                $("#Groupconfig").html(code);
            },
            error : function(e){console.log(e);} });
      }
              
              
    </script>
  <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="./dashboard.jsp">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>        
    </nav>

    <!-- Begin page content -->
    <div class="container mainpage">
      <div class="page-header">
        <h1>GROUP NAME</h1>
      </div>
      <p class="lead">JUMUMANAGER <code>padding-top: 60px;</code> on the <code>body &gt; .container</code>.</p>
      
      
      <div class="row">
          <div class="col-md-4"><button type="submit" class="btn btn-default" id="GroupConfigButton"><img data-holder-rendered="true"  src="./img/group.png" style="width: 140px; height: 140px;" data-src="holder.js/140x140" class="img-rounded" alt="140x140"><p class="lead">Gruppeneinstellung</p></button></div> 
        <div class="col-md-4"><button type="submit" class="btn btn-default" id="MemberButton"><img data-holder-rendered="true"  src="./img/group.png" style="width: 140px; height: 140px;" data-src="holder.js/140x140" class="img-rounded" alt="140x140"><p class="lead">Mitglieder</p></button></div>
        <div class="col-md-4"><button type="submit" class="btn btn-default" id="GroupConfigButton"><img data-holder-rendered="true"  src="./img/group.png" style="width: 140px; height: 140px;" data-src="holder.js/140x140" class="img-rounded" alt="140x140"><p class="lead">Termine</p></button></div>
      </div>
    </div>
      
    <div class="conatiner" style="display:none">
      <div class="bs-callout bs-callout-info calloutADD" id="callout-type-b-i-elems" style="display:none">
            <h4 id="alternate-elements">Hinweis!<a class="anchorjs-link" href="#alternate-elements"><span class="anchorjs-icon"></span></a></h4>
            <p>Add successful!</p>
        </div>
        <div class="bs-callout bs-callout-info calloutUPDATE" id="callout-type-b-i-elems" style="display:none">
            <h4 id="alternate-elements">Hinweis!<a class="anchorjs-link" href="#alternate-elements"><span class="anchorjs-icon"></span></a></h4>
            <p>Update successful!</p>
        </div>
        <div class="bs-callout bs-callout-info calloutDELETE" id="callout-type-b-i-elems" style="display:none">
            <h4 id="alternate-elements">Hinweis!<a class="anchorjs-link" href="#alternate-elements"><span class="anchorjs-icon"></span></a></h4>
            <p>Delete successful!</p>
        </div>
    </div>
      
      
    <div class="container GroupContainer" style="display:none"><div class="page-header"><h1>Groupmanagment</h1></div><table class="table table-hover" id="Groupconfig"></table></div>
      


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="res/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="bootstrap/js/ie10-viewport-bug-workaround.js"></script>
  

</body></html>