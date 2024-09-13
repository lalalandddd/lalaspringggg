/* view.js */
let inputType=[];
let inputName=[];
$(function(){
	$("#modify").on("click",function(){
		$.each($(".value"),function(i,v){
			var text=$(v).text().trim();
			if(inputType[i]==="number"){
				text=text.replce(/[^0-9]/g,"");
			}
			$input="<input type='"+inputType[i]+"' name='"+inputName[i]+"' value='"+text+"'>";
			$(v).empty();
			$(v).append($input);
		});
		$(this).attr("id","mod");
		var url=$("#fm").attr("action");
		url=url.replace("delete","update");
		$("#fm").attr("action",url);
		$(this).off("click");
		$("#mod").on("click",function(){
			$("#fm").submit();
		});
	});
	$("#delete").on("click",function(){
		var bid=$(this).data("bid")
		var isOk=confirm("정말로 삭제하십니까?");
		if(isOk){
			location.href="/library/delete?bid="+bid;
		}
	});
});