/* info.js (for button) */
let inputType=[];
let inputName=[];
$(function(){
	$("#delete").on("click",function(){
		var bookId=$(this).data("id");
		var isOk=confirm("정말로 삭제하시겠습니까?");
		if(isOk){
			location.href="/book2/bookDelete?id="+bookId;
		}
	});
	$("#delete2").on("click",function(){
		var coffeId=$(this).data("id");
		var isOk=confirm("정말로 삭제하시겠습니까?");
		if(isOk){
			location.href="/coffe/coffeeDelete?id="+coffeId;
		}
	});
	$("#delete3").on("click",function(){
		var userNb=$(this).data("id");
		var isOk=confirm("정말로 삭제하시겠습니까?");
		if(isOk){
			location.href="/mytest/member/memberDelete?id="+userNb;
		}
	});
	$("#modify").on("click",function(){
		$.each( $(".value"),function(i,v){  // i=인덱스, v=인덱스의 값
			var text=$(v).text().trim();
			if(inputType[i]==="number"){
				text=text.replace(/[^0-9]/g,"");  // 숫자 제외 글자 모두 제거
				//text=text.replace(",","");  // 천 단위 콤마 제거
				//if(isNaN(text)) text=text.substring(1);  // 원 표시 제거
			}
			//$(v).html("<input type='"+inputType[i]+"' name='"+inputName[i]+"' value='"+text+"'>");
			$input="<input type='"+inputType[i]+"' name='"+inputName[i]+"' value='"+text+"'>";
				if(inputName[i]==="decaffein"){
					$input="<input type='radio' name='decaffein' value='0'> 카페인 "+
						"<input type='radio' name='decaffein' value='1' checked> 디카페인 ";
				}
			$(v).empty();
			$(v).append($input);
		});  // 클래스명이 value인 td 내부 설정
/*
		$(this).text("등록");  // 버튼 텍스트를 '등록'으로 변경
		$(this).off("click").on("click", function() {  // 변경된 내용을 서버로 전송하거나 저장하는 로직 추가
		    $.each($(".value"), function(i, v) {
		        var input = $(v).find("input");
		        var newValue = input.val();
		        $(v).text(newValue);  // 입력된 값으로 HTML 내용을 대체
		    });
		    $(this).text("수정");  // 버튼 텍스트를 다시 '수정'으로 변경
		    $(this).off("click").on("click", arguments.callee);  // '수정' 버튼 클릭 이벤트 다시 설정
		});
*/
		$(this).attr("id","mod");
		var url=$("#fm").attr("action");  // form action 값 가져오기
		url=url.replace("delete","update");  // 삭제를 갱신으로 변경
		$("#fm").attr("action",url);
		$(this).off("click");
		$("#mod").on("click",function(){ $("#fm").submit(); });
	});
	$("#modify2").on("click",function(){
		$.each( $(".value"),function(i,v){
			var text=$(v).text().trim();
			if(inputType[i]==="number"){ text=text.replace(/[^0-9]/g,""); }
			$input="<input type='"+inputType[i]+"' name='"+inputName[i]+"' value='"+text+"'>";
				if(inputName[i]==="decaffein"){
					$input="<input type='radio' name='decaffein' value='0'> 카페인 "+
						"<input type='radio' name='decaffein' value='1' checked> 디카페인 ";
				}
			$(v).empty();
			$(v).append($input);
		});
		$(this).attr("id","mod");
		var url=$("#fm").attr("action");
		url=url.replace("delete","update");
		$("#fm").attr("action",url);
		$(this).off("click");
		$("#mod").on("click",function(){ $("#fm").submit(); });
	});
});
