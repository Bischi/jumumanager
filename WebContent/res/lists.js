    function getInstrumentList()
    {
      $.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/JumuManagerWebGIT/api/instruments",
					success : function(response) {
						var code = "";
						if (response.instrument.length !== undefined) {
							for (var i = 0; i < response.instrument.length; i++) {
                code = code + '<option value="'+response.instrument[i].id+'">'+response.instrument[i].name+'</option>';
              }
            }else {
							code = code + '<option value="'+response.instrument.id+'">'+response.instrument.name+'</option>';
            }
            $("#instrumentSelect").html(code);
          } 
      });
    }
  
   
  function getRightList() //Rechte bekommen
    {
      $.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/JumuManagerWebGIT/api/rights",
					success : function(response) {
						var code = "";
						if (response.right.length !== undefined) {
							for (var i = 0; i < response.right.length; i++) {
                code = code + '<option value="'+response.right[i].id+'">'+response.right[i].right+'</option>';
              }
            }else {
							code = code + '<option value="'+response.right.id+'">'+response.right.right+'</option>';
            }
            $("#rightSelect").html(code);
          } 
      });
    }

  function getTypList() //Rechte bekommen
    {
      $.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/JumuManagerWebGIT/api/types",
					success : function(response) {
						var code = "";
						if (response.probentyp.length !== undefined) {
							for (var i = 0; i < response.probentyp.length; i++) {
                code = code + '<option value="'+response.probentyp[i].id+'">'+response.probentyp[i].typ+'</option>';
              }
            }else {
							code = code + '<option value="'+response.probentyp.id+'">'+response.probentyp.typ+'</option>';
            }
            $("#typSelect").html(code);
          } 
      });
    }
             
