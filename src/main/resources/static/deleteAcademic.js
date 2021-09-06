function eliminar(idAcademy) {
	swal({
  title: "Are you sure?",
  text: "Once deleted, you will not be able to recover this academy!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/deleteAcademic/"+idAcademy,
		success: function(res){
			console.log(res);
		},
	});
    swal("Poof! Your academy has been deleted!", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/academic";
		}
});
  } else {
    swal("Your academy is safe!");
  }
});
}