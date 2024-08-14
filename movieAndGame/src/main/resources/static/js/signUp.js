/* signUp.js */
$(function(){
	$("#signUpBt").attr("disabled",true);  // 회원가입 버튼 비활성화
	$("#memberId").focus();
	$(".inputField input").on("focus",function(){
		$(this).addClass("active");
		$(this).next().addClass("focus");
	});
	$(".inputField input").on("blur",function(){
		var text=$(this).val();
		if(text=''){
			$(this).removeClass("active");
			$(this).next().removeClass("focus");
		}
	});
	$("#birthYear").empty();  // select 태그 안 년 비우기
	$("#birthMonth").empty();  // select 태그 안 월 비우기
	// 태어난 년도 select에 option 태그 추가, 1924~2024 중에 선택, 2005가 기본값으로 설정할 것
	for(var i=2024;i>=1924;i--){
		var selected=(i==2005)?"selected":"";
		$("#birthYear").append(`<option value="${i}" ${selected}>${i}</option>`);
	}
	var today=new Date();  // 오늘 날짜
	var month=today.getMonth()+1;  // 오늘 날짜에서 월 추출
	for(var i=1;i<=12;i++){
		var selected=(i==month)?"selected":"";
		$("#birthMonth").append(`<option value="${i}" ${selected}>${i}</option>`);
	}
	// 비밀번호와 비밀번호 확인 두 곳의 값이 일치하는지를 확인
	$("#password").on("keyup",function(){
		if($(this).val()!=$("#chpw").val()){
			$("#pw1").text("비밀번호가 일치하지 않습니다.");
			$("#pw1").css("color","red");
			$("#pw2").empty();
		}else{
			$("#pw1").text("비밀번호가 일치합니다.");
			$("#pw1").css("color","green");
			$("#pw2").empty();
			$("#signUpBt").attr("disabled",false);  // 비밀번호가 동일하면 회원가입 버튼 활성화
		}
	});
	$("#chpw").on("keyup",function(){
		if($(this).val()!=$("#password").val()){
			$("#pw2").text("비밀번호가 일치하지 않습니다.");
			$("#pw2").css("color","red");
			$("#pw1").empty();
		}else{
			$("#pw2").text("비밀번호가 일치합니다.");
			$("#pw2").css("color","green");
			$("#pw1").empty();
			$("#signUpBt").attr("disabled",false);  // 비밀번호가 동일하면 회원가입 버튼 활성화
		}
	});
});