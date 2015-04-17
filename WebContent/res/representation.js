/**
 * 
 */
var email;

function next(email) {
	this.email = email;
	window.location.href = "dashboard.jsp";
	checkRights(email);
}
function checkRights(email){
	var getright = {}
	
	
	$.ajax({
		headers : {
			Accept : 'application/json'
		},
		contentType : 'application/json',
		type : 'GET',
		url : "/JumuManagerWebGIT/api/users/rights/" +email,
		data : JSON.stringify(getright),
		success : function(response) {
		right = response.fk_rights_id;
				alert(right);
				if(response.fk_rights_id == "User"){
					window.location.href = "dashboardu.jsp";
					
				}
				
				if(response.fk_rights_id == "Admin"){
					window.location.href = "dashboarda.jsp";
					
				}
				
				if(response.fk_rights_id == "Guru"){
					window.location.href = "dashboard.jsp";
					
				}
				
		},
		error : function(e) {
			console.log(e);
		}
	});


	
}




