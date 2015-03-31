function bindDeleteRecordConfirm() {
	var deleteConfirm = false;
	$("a#confirm-delete-alert").bind("click", function(e){
		$(".alert").fadeIn();
		e.preventDefault();

		$("#delete-confirm").bind("click", function() {
			alert("Delete confirmed!");
		});
	});
	
} 
$(document).ready(function(){
	bindDeleteRecordConfirm();
});