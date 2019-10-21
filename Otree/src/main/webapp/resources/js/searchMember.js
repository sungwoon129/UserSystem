function registMember() {
	

	$.ajax({
		type:"GET",
		url: '/member/list',
		contentType: "application/json; chraset=utf-8;",
		success:function(response) {
			console.log(response );
		},
		error:function(e) {
			console.log(e.statusText);
		}
		
	})
}

