/*var ser = angular.module("logInService",[]);*/

	app.factory('Authenticate',function(){
		
		var Authenticate = {};
			Authenticate.dologIn = function(scope){
				alert(scope.email);
				return scope.password;
			}
			return Authenticate;
	});