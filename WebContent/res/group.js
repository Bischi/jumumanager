//Groupmanagement

	function loadGroupList() {
		$
				.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/JumuManagerWebGIT/api/groups",
					success : function(response) {

						var code = "<thead><tr><th>#</th><th>Groupname</th></tr></thead><tbody>";
						if (response.group.length !== undefined) {

							for (var i = 0; i < response.group.length; i++) {
								code = code
										+ '<tr><th scope="row">'
										+ (i + 1)
										+ '</th><td width="90%">'
										+ response.group[i].name
										+ '</td><td><option value='+response.group[i].id+'></td><td width="5%"></option><button type="button" class="btn btn-warning editGroupButton" name="'+response.group[i].id+'">edit</button></td><td width="5%"><button type="button" class="btn btn-danger deleteGroupButton" name="'+response.group[i].id+'">delete</button></td></tr>';
							}
						} else {
							code = code
									+ '<tr><th scope="row">'
									+ (1)
									+ '</th><td width="90%">'
									+ response.group.name
									+ '</td><td><option value='+response.group.id+'></td><td width="5%"></option><button type="button" class="btn btn-warning editGroupButton" name="'+response.group.id+'">edit</button></td><td width="5%"><button type="button" class="btn btn-danger deleteGroupButton" name="'+response.group.id+'">delete</button></td></tr>';
						}

						code = code + "</tbody>";
						$("#Groupconfig").html(code);
					},
					error : function(e) {
						console.log(e);
					}
				});
	}

	function viewGroupList() {
		$(".GroupContainer").fadeIn("slow");
	}

	function hideGroupList() {
		$(".GroupContainer").hide();
	}

	function updateGroup(id, newGroupName) {
		var group = {};
		group.id = id;
		group.name = newGroupName;
		$.ajax({
			headers : {
				Accept : 'application/json'
			},
			contentType : 'application/json',
			type : 'PUT',
			url : '/JumuManagerWebGIT/api/groups/' + id,
			data : JSON.stringify(group),
			success : function(response) {
				$(".calloutUPDATE").fadeIn("slow");
				$(".calloutUPDATE").delay(3000).fadeOut("fast");
				loadGroupList();
			},
			error : function(e) {
				console.log(e);
			}
		});
	}

	function deleteGroup(id) {
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
 function fillGroupSelect() // gruppen bekommen
    {
      $.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/JumuManagerWebGIT/api/groups",
					success : function(response) {
						var code = "";
            //Copyright Abfalterer = liebt Phillip
						if (response.group.length !== undefined) {
							for (var i = 0; i < response.group.length; i++) {
                code = code + '<option value="'+response.group[i].id+'">'+response.group[i].name+'</option>';
              }
            }else {
							code = code + '<option value="'+response.group.id+'">'+response.group.name+'</option>';
            }
            $("#groupSelect").html(code);
          } 
      });
    }
    