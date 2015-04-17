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
                    + '</td><td>'
                    + response.termin[i].fk_typ
                    + '</td><td>'
                    + response.termin[i].date
                    + '</td><td>'
                    + response.termin[i].starttime
                    + '</td><td>'
                    + response.termin[i].endtime
										+ '</td><td><option value='+response.termin[i].id+'></td><td width="5%"></option><button type="button" class="btn btn-warning editTerminButton" name="'+response.termin[i].id+'">edit</button></td><td width="5%"><button type="button" class="btn btn-danger deleteTerminButton" name="'+response.termin[i].id+'">delete</button></td></tr>';								

							}
						} else {
							code = code
									+ '<tr><th scope="row">'
									+ 1
									+ '</th><td>'
									+ response.termin.name
									+ '</td><td>'
									+ response.termin.fk_typ
									+ '</td><td>'
									+ response.termin.date
									+ '</td><td>'
									+ response.termin.starttime
									+ '</td><td>'
									+ response.termin.endtime
									+ '</td><td><option value='+response.termin.id+'></td><td width="5%"></option><button type="button" class="btn btn-warning editTerminButton" name="'+response.termin.id+'">edit</button></td><td width="5%"><button type="button" class="btn btn-danger deleteTerminButton" name="'+response.termin.id+'">delete</button></td></tr>';
									
									
						}
						code = code + "</tbody>";
						$("#Terminconfig").html(code);
					},
					error : function(e) {
						console.log(e);
					}
				});
  }

function addTermin()
  {
    var termin = {};
    termin.name=$("#TerminNameInput").val();
    termin.date=$("#dateInput").val();
    termin.starttime=$("#starttimeInput").val();
    termin.endtime=$("#endtimeInput").val();
    termin.fk_typ=$("#typSelect").val();
    $.ajax({
    headers:{Accept:'application/json'}, 
    contentType:'application/json',
    type:'POST',
    url: "/JumuManagerWebGIT/api/termine",
    data: JSON.stringify(termin),
    success: function(response)
    {
        $("#nameInput").val('');
        $("#dateInput").val('');
        $("#starttimeInput").val('');
        $("#endtimeInput").val('');
        $(".calloutADD").fadeIn("slow");
        $(".calloutADD").delay(3000).fadeOut("fast");
        loadTerminList()
    },
    error : function(e){console.log(e);}
    });
  }

function deleteTermin(id) {		
		$.ajax({
			headers : {
				Accept : 'application/json'
			},
			contentType : 'application/json',
			type : 'DELETE',
			url : '/JumuManagerWebGIT/api/termine/' + id,
			success : function(response) {
				$(".calloutDELETE").fadeIn("slow");
				$(".calloutDELETE").delay(3000).fadeOut("fast");
			},
			error : function(e) {
				console.log(e);
			}
		
		});
	}



	function viewTerminList() {
		$(".TerminContainer").fadeIn("slow");
	}

  function hideTerminList(){
    $(".TerminContainer").hide();
  }


 function viewTerminEditContainer() {
    $(".editTerminContainer").fadeIn("slow");
  }

function hideTerminEditContainer()
{
  $(".editTerminContainer").hide();
}