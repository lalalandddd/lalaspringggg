/* view.js */
$(function() {
    $("#delete").off("click").on("click", function() {
        var bid = $(this).data("bid");
        var isOk = confirm("정말로 삭제하십니까?");
		if (isOk) {
            location.href="/delete?bid="+bid;
        }
    });
	$("#modify").on("click",function(){
		$("#fm").submit();
	});
	$(".bview").on("click",function(){
		var bid=$(this).data("bid");
		if(bid!=''){
			window.location.href="/view/"+bid;
		}else{
			console.error("href값 미설정");
		}
	});
});
