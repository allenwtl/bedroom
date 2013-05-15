var stringCheck = function(){
	
	this.isShuZi = function(inputObj,priObj){
		var reg = /^[0-9]+$/;	
		if(!reg.test(inputObj)){
			alert(priObj);
			return false;
		}
	}
	
	this.isEmpty = function(inputObj){
		
	}
}