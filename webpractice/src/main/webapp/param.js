/**
 * 
 */

 function check(){
	 if(document.memberform.id.value === ""){
		 alert("아이디를 입력해주세요");
		 document.memberform.id.focus();
		 return false;
	 }else if(document.memberform.age.value === ""){
		 alert("나이를 입력해주세요");
		 document.memberform.age.focus();
		 return false;
	 }else if(isNaN(document.memberform.age.value)){ //숫자인지 아닌지 확인
		 alert("나이는 숫자로 입력하세요")
		 document.memberform.age.focus();
		 return false;
	 }else {
		 return true;
	 }
 }