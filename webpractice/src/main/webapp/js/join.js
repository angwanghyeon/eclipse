/**
 * 
 */
function check_ok(){
	if(document.joinfrm.pers_1.value.length != 6){
		alert("주민번호 앞자리는 6글자입니다")
		document.joinfrm.pers_1.focus();
		return false;
	}
	if(document.joinfrm.pers_2.value.length != 7){
		alert("주민번호 뒷자리는 7글자입니다")
		document.frm.pers_2.focus();
		return false;
	}
	if(document.joinfrm.id.value.length < 4){
		alert("아이디는 최소 4글자 이상 입력하세요")
		document.joinfrm.id.focus();
		return false;
	}
	if(document.joinfrm.pwd.value != document.reg_frm.pwd_ch.value){
		alert("비밀번호가 일치하지 않습니다")
		document.joinfrm.pwd_ch.focus();
		return false;
	}
	return true;
}