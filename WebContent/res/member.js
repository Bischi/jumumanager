function loadMemberList() {
		$.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/JumuManagerWebGIT/api/users",
					success : function(response) {
						var code = "<thead><tr><th></th><th>Vorname</th><th>Nachname</th><th>email</th><th>Instrument</th><th>Gruppe</th></tr></thead><tbody>";
						if (response.user.length !== undefined) {

							for (var i = 0; i < response.user.length; i++) {
								code = code
										+ '<tr><th scope="row">'
										+ (i + 1)
										+ '</th><td>'
										+ response.user[i].fname
										+ '</td><td> '
										+ response.user[i].lname
										+ '</td><td> '
										+ response.user[i].email
										+ '</td><td>'
										+ response.user[i].fk_instrument_id
										+ '</td><td> '
										+ response.user[i].fk_groups_id
										+ '</td><td><option value='+response.user[i].id+'></td><td width="5%"></option><button type="button" class="btn btn-warning editMemberButton" name="'+response.user[i].id+'">edit</button></td><td width="5%"><button type="button" class="btn btn-danger deleteMemberButton" name="'+response.user[i].id+'">delete</button></td></tr>';
							}
						} else {
							code = code
									+ '<tr><th scope="row">'
									+ 1
									+ '</th><td> '
									+ response.user.fname
									+ '</td><td> '
									+ response.user.lname
									+ '</td><td> '
									+ response.user.email
									+ '</td><td> '
									+ response.user.fk_instrument_id
									+ '</td><td width="90%"> '
									+ response.user.fk_groups_id
									+ '</td><td><option value='+response.user.id+'></td><td width="5%"></option><button type="button" class="btn btn-warning editMemberButton" name="'+response.user.id+'">edit</button></td><td width="5%"><button type="button" class="btn btn-danger deleteMemberButton" name="'+response.user.id+'">delete</button></td></tr>';
						}

						code = code + "</tbody>";
						$("#Memberconfig").html(code);
					},
					error : function(e) {
						console.log(e);
					}
				});
	}
  
  function addMember()
  {
    var user = {};
    user.fname=$("#fnameInput").val();
    user.lname=$("#lnameInput").val();
    user.email=$("#emailInput").val();
    user.passwd=$("#passwdInput").val();
    user.fk_instrument_id=$("#instrumentSelect").val();
    user.fk_groups_id=$("#groupSelect").val();
    user.fk_rights_id=$("#rightSelect").val();
    $.ajax({
    headers:{Accept:'application/json'}, 
    contentType:'application/json',
    type:'POST',
    url: "/JumuManagerWebGIT/api/users",
    data: JSON.stringify(user),
    success: function(response)
    {
        $("#fnameInput").val('');
        $("#lnameInput").val('');
        $("#emailInput").val('');
        $("#passwdInput").val('');
        $(".calloutADD").fadeIn("slow");
        $(".calloutADD").delay(3000).fadeOut("fast");
    },
    error : function(e){console.log(e);}
    });
  }
  
  
	function viewMemberList() {
		$(".MemberContainer").fadeIn("slow");
	}
  
  function hideMemberList() {
		$(".MemberContainer").hide();
	}
  
  function hideMemberEditConfig()
  {
    $("#editMemberContainer").fadeOut("slow");
  }

	function updateMember() {
		var user = {};
    user.fname=$("#fnameInput").val();
    user.lname=$("#lnameInput").val();
    user.email=$("#emailInput").val();
    user.passwd=$("#passwdInput").val();
    user.fk_instrument_id=$("#instrumentSelect").val();
    user.fk_groups_id=$("#groupSelect").val();
    user.fk_rights_id=$("#rightSelect").val();
    $.ajax({
    headers:{Accept:'application/json'}, 
    contentType:'application/json',
    type:'PUT',
    url: "/JumuManagerWebGIT/api/users/"+id,
    data: JSON.stringify(user),
    success: function(response)
    {
        $("#fnameInput").val('');
        $("#lnameInput").val('');
        $("#emailInput").val('');
        $("#passwdInput").val('');
        $(".calloutADD").fadeIn("slow");
        $(".calloutADD").delay(3000).fadeOut("fast");
    },
    error : function(e){console.log(e);}
    });
	}

	function deleteMember(id) {
		$.ajax({
			headers : {
				Accept : 'application/json'
			},
			contentType : 'application/json',
			type : 'DELETE',
			url : '/JumuManagerWebGIT/api/groups/' + id,
			success : function(response) {
				$(".calloutDELETE").fadeIn("slow");
				$(".calloutDELETE").delay(3000).fadeOut("fast");
				loadGroupList();
			},
			error : function(e) {
				console.log(e);
			}
		});
	}

 function viewMemberEditContainer() {
    $(".editMemberContainer").fadeIn("slow");
  }