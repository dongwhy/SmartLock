$("#login-btn").on("click", function() {
	var data = {
		"id" : $("#id").val(),
		"pwd" : $("#pwd").val()
	};
	$.ajax({
		url : "/login",
		type : "POST",
		dataType : "json",
		data : data,
		success : function (data){
			if(data.satus == "success") {
				//메인페이지로이동
				//href.location="/login";
			} else {
				
			}
		},
		error : function(data, textStatus, errorThrown) {
			
		}
	});
});

$("#check-id-btn").on("click",function(){
	if($("#id").val() == '') {
		$("#id").focus();
		return;
	}
	
	$.ajax({
		url : "/ckeck/id",
		type : "GET",
		dataType : "json",
		data : {
			"id" : $("#id").val(),
		},
		success : function (data){
			if(data.status == "success") {
				if(data.data == "ok") {
					alert("사용가능한 아이디 입니다.");
					$("#is-ckeck-id").val("true");
					$("#checked-id").val($("#id").val());
				} else {
					alert("중복된 아이디 입니다.");
					$("#is-ckeck-id").val("false");
					$("#checked-id").val();
				}
			} else {
				
			}
		},
		error : function(data, textStatus, errorThrown) {
			
		}
	});
});

$("#signup-btn").on("click", function() {
	// check validation
	if($("#id").val() == '') {
		$("#id").focus();
		alert("아이디를 입력하세요.");
		return;
	}
	if($("#pwd").val() == '') {
		$("#pwd").focus();
		alert("비밀번호를 입력하세요.");
		return;
	}
	if($("#check-pwd").val() == '') {
		$("#pwd").focus();
		alert("비밀번호 확인을 입력하세요.");
		return;
	}
	if($("#name").val() == '') {
		$("#name").focus();
		alert("이름을 입력하세요.");
		return;
	}
	if($("#email").val() == '') {
		$("#email").focus();
		alert("이메일을 입력하세요.");
		return;
	}
	if($("#phone").val() == '') {
		$("#phone").focus();
		alert("전화번호를 입력하세요.");
		return;
	}
	if($("#corp_id").val() == '') {
		$("#corp_name").focus();
		alert("기업명을 입력하세요.");
		return;
	}
	if($("#checked-id").val() != $("#id").val()) {
		$("#is-ckeck-id").val("false");
	} else {
		$("#is-ckeck-id").val("true");
	}
	if($("#is-ckeck-id").val() == "false") {
		$("#id").focus();
		alert("아이디 중복체크를 하세요.");
		return;
	}
	if($("#pwd").val() != $("#ckeck-pwd").val()) {
		$("#check-pwd").focus();
		alert("비밀번호가 다릅니다.");
		return;
	}

	$.ajax({
		url : "/signup",
		type : "POST",
		dataType : "json",
		data : {
			"id" : $("#id").val(),
			"pwd" : $("#pwd").val(),
			"name" : $("#name").val(),
			"email" : $("#email").val(),
			"phone" : $("#phone").val(),
			"corp_id" : $("#company").val()
		},
		success : function (data){
			if(data.status == "success") {
				//회원가입 성공 페이지로 이동(로그인페이지이동버튼제공)
				location.href="/signup/ok";
			} else {
				
			}
		},
		error : function(data, textStatus, errorThrown) {
			
		}
	});
});