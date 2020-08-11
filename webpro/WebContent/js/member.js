/**
 * 
 */

//function idchk() {
//	
//}

var datachk = function() {
	vid = f.id.value.trim();
	// 공백
	if(vid.length < 1){
		alert("id를 입력하세요")
		f.id.focus();
		return;
	}
	// 4~12
	if(vid.length < 4 || vid.length > 12){
		alert("id는 4 ~ 12 자리 입니다");
		return;			
	}
	// 정규식 - 영문자로 시작 숫자와 조합
	idreg = /^[a-zA-Z][0-9a-zA-Z]{3,11}$/; // 뒤에 문자는 3자리에서 11자리가 온다
	if(idreg.test(vid)){
		alert("id 입력 성공");
	}else{
		alert("형식과 일치하지 않습니다");
		f.id.focus();
		return;
	}
	////////////////////////////////////
	// pass 체크 - 공백, 길이, 정규식
	vpass = f.pass.value.trim();
	// 공백
	if(vpass.length < 1){
		alert("비밀번호를 입력하세요")
		f.pass.focus();
		return;
	}
	// 8~20
	if(vpass.length < 8 || vpass.length > 20){
		alert("비밀번호는 8 ~ 20 자리 입니다");
		return;			
	}
	// 정규식 - 영문자로 시작 숫자와 조합
	passreg = /^[a-zA-Z0-9_-][a-zA-Z0-9_-]{7,19}$/; // 뒤에 문자는 3자리에서 11자리가 온다
	if(passreg.test(vpass)){
		alert("비밀번호 입력 성공");
	}else{
		alert("형식과 일치하지 않습니다(영어 대소문자, 숫자 0~9, 특수문자 _-!@# 허용)");
		f.pass.focus();
		return;
	}
	
	// 이름 체크 - 공백, 길이, 정규식
	vname = f.name.value.trim();
	// 공백
	if(vname.length < 1){
		alert("이름를 입력하세요");
		f.name.focus();
		return;
	}
	
	// 2~6
	if(vname.length < 2 || vname > 6){
		alert("이름은 2 ~ 6 자리 입니다");
		return;	
	}
	
	// 정규식
	namereg = /^[가-힣]{2,6}$/;
	if(namereg.test(vname)){
		alert("이름 입력 성공");
	}else{
		alert("형식과 일치하지 않습니다(2~6자리)");
		f.name.focus();
		return;
	}
	
	// 전화번호 체크 - 공백, 정규식
	vtel = f.tel.value.trim();
	// 공백
	if(vtel.length < 1){
		alert("전화번호를 입력하세요");
		f.tel.focus();
		return;
	}
	
	// 정규식
	telreg = /^010-\d{4}-\d{4}$/;
	if(telreg.test(vtel)){
		alert("전화번호 입력 성공");
	}else{
		alert("형식과 일치하지 않습니다(010-4자리-4자리)");
		f.tel.focus();
		return;
	}
	
	// 이메일 체크 - 공백, 정규식
	vemail = f.email.value.trim();
	// 공백
	if(vemail.length < 1){
		alert("이메일을 입력하세요");
		f.email.focus();
		return;
	}
	
	// 정규식
	emailreg = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	if(emailreg.test(vemail)){
		alert("이메일 입력 성공");
	}else{
		alert("형식과 일치하지 않습니다");
		f.eamil.focus();
		return;
	}
	
	return true;
}