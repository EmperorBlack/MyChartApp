/*var ser = angular.module("logInService",[]);*/

	app.factory('Authenticate',['$http','$location',function($http,$location){
		
		var Authenticate = {};
			Authenticate.dologIn = function(scope ,bodyCredetial){
					  $http({
							url 		: "/chartApp/user/login",
							dataType 	: "json",
							method 		: "post",
							data   		: bodyCredetial,
							headers 	: {
											"Content-Type"     					: "application/json",
											"Access-Control-Allow-Origin" 		: "*",
											"Access-Control-Allow-Credentials" 	: true
								       	  }
					    }).then(function mySuccess(response) {
					    	 $location.path('/ChatPage');
					      },function myError(response) {
					    	alert(response.status);
					    }
					 );
			     }
			return Authenticate;
	}]);