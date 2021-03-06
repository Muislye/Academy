function eliminar(idUser) {
	swal({
  title: "Are you sure?",
  text: "Once deleted, you will not be able to recover this user!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/delete/"+idUser,
		success: function(res){
			console.log(res);
		},
	});
    swal("Poof! Your user has been deleted!", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/get";
		}
});
  } else {
    swal("Your user is safe!");
  }
});
}