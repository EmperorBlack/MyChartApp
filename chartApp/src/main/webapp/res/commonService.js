app.factory('commonService',[function(){
		

			var commonService = {};
	commonService.ValidateEmail = function(mail, scope) {
		if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
			scope.isValidEmail = true;
		} else {
			alert("You have entered an invalid email address!")
			scope.isValidEmail = false;
		}
	}
	commonService.checkPassword = function(inputtxt, scope) {
		var passw = /^(?=.*\d).{6,15}$/;
		if (inputtxt.match(passw)) {
			scope.isValidPassword = true;
		} else {
			alert('password must have between 6-15 char')
			scope.isValidPassword = false;
		}
	}
	commonService.confirmPassword = function(password,confirmPass,scope)
	{
		if(password == confirmPass)
			scope.isPasswordSame = true;
		else
			alert("password does not match with confirm password");
	}
	
	return commonService;
	}]);