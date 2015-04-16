function loadTerminList() {
		$.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/JumuManagerWebGIT/api/termine",
					success : function(response) {
						var code = "<thead><tr><th>#</th><th>Bezeichnung</th><th>Typ</th><th>Datum</th><th>Startzeit</th><th>Endzeit</th></tr></thead><tbody>";
						if (response.termin.length !== undefined) {
							for (var i = 0; i < response.termin.length; i++) {
								code = code
										+ '<tr><th scope="row">'
										+ (i + 1)
										+ '</th><td width="90%">'
										+ response.termin[i].name
										+ '</td><td><option value='+response.termin[i].id+'></td><td width="5%"></option><button type="button" class="btn btn-warning editGroupButton" name="'+response.termin[i].id+'">edit</button></td><td width="5%"><button type="button" class="btn btn-danger deleteGroupButton" name="'+response.termin[i].id+'">delete</button></td></tr>';								

							}
						} else {
							code = code
									+ '<tr><th scope="row">'
									+ 1
									+ '</th><td>'
									+ response.termin.name
									+ '</td><td>'
									+ response.termin.typName
									+ '</td><td>'
									+ response.termin.date
									+ '</td><td>'
									+ response.termin.starttime
									+ '</td><td>'
									+ response.termin.endtime
									+ '</td><td><option value='+response.termin.id+'></td><td width="5%"></option><button type="button" class="btn btn-warning editGroupButton" name="'+response.termin.id+'">edit</button></td><td width="5%"><button type="button" class="btn btn-danger deleteGroupButton" name="'+response.termin.id+'">delete</button></td></tr>';
									
									
						}
						code = code + "</tbody>";
						$("#Terminconfig").html(code);
					},
					error : function(e) {
						console.log(e);
					}
				});
  }


	function viewTerminList() {
		$(".TerminContainer").fadeIn("slow");
	}