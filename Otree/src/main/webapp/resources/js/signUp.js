	
window.onload = function validation() {
	
	const checkList = {
			"name" : false,
			"birth" : false,
			"email" : false,
			"address" : false,
			"phone" : false
	}

	let inputBlurEvent = {
			
			"name":function() {
				ajax(this.id,this);
			},
			
			"birth": function() {
				
				if(isNaN(this.value)) {
					let msg = "생년월일은 숫자만 가능합니다";
					this.nextSibling.textContent = msg;
					checkList[this.id] = false;
				}
				else {
					this.nextSibling.textContent = null;
					checkList[this.id] = true;
					
				}
			
			},
			"email": function() {
				ajax(this.id,this);
				
				
			},
			"address":function() {
				checkList[this.id] = true;
			},
			"phone": function() {
				if(isNaN(this.value)) {
					let msg = "휴대폰 번호는 숫자로만 입력해주세요.";
					this.nextSibling.textContent = msg;
					checkList[this.id] = false;
				}
				else {
					this.nextSibling.textContent = null;
					ajax(this.id,this);
				}
				
		
				
			}
	};
	
	
	function isEmpty(input) {
		if(input.value == "") {
			let msg = `${input.dataset.code} 을(를) 입력해야합니다`; 
			input.nextSibling.textContent = msg;		
			
			return false;
			
		}
		else {
			input.nextSibling.textContent = null;
			
			return true;
		}
	}
	
	function ajax(inputValue,input) {
		if(input.value != "") {
			$.ajax({
				type:"GET",
				url:"/isExist",
				data:{
					"inputType" : inputValue,
					inputValue : input.value			
				},
				success:function(result) {		
					if(result > 0) {
						let msg = `중복된 ${input.dataset.code}이 있습니다`;
						input.nextSibling.textContent = msg;
						checkList[input.id] = false;
					}
					else {
						input.nextSibling.textContent = null;
						checkList[input.id] = true;
					}
				},
				error:function(e) {
					console.log(e.statusText);
				}
			})
		}
	}

	
	$('form[name=registForm]').on("blur","input",function(event) {
		
		let target = event.target || event.srcElement;
	
		
		if(inputBlurEvent.hasOwnProperty(target.id) && isEmpty(target) == true) {
			
			inputBlurEvent[target.id].call(this);
		}
		
	}); 
	

	
	document.getElementById("regist_btn").addEventListener("click",function(e) {
		
		const unSatisfiedArr = Object.values(checkList).filter(v => v == false);
		
		if(unSatisfiedArr.length == 0) {
			document.registForm.submit();
			alert("회원가입이 완료되었습니다");
		}
		else  alert("회원가입 양식을 지켜주세요 ^^");
	},false)

	
}	
	
