function eliminar(idCourses) {
	swal({
  title: "Are you sure?",
  text: "Once deleted, you will not be able to recover this course!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/deleteCourse/"+idCourses,
		success: function(res){
			console.log(res);
		},
	});
    swal("Poof! Your user has been deleted!", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/courses";
		}
});
  } else {
    swal("Your course is safe!");
  }
});
}