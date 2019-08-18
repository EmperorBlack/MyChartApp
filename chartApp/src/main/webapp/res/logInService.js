/*var ser = angular.module("logInService",[]);*/

	app.factory('user',['$http','$location',function($http,$location){
		
		var user = {};
		user.dologIn = function(scope ,bodyCredetial){
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
					    	scope.data = response.data;
					    	if(scope.data.msg == 'success')
					    			$location.path('/chartPage');
					    	else
					    		$location.path('/failed');
					      },function myError(response) {
					    	alert(response.status);
					    }
					 );
			     }
		user.doSignup = function(scope ,bodyCredetial){
		  $http({
				url 		: "/chartApp/user/signUp",
				dataType 	: "json",
				method 		: "post",
				data   		: bodyCredetial,
				headers 	: {
								"Content-Type"     					: "application/json",
								"Access-Control-Allow-Origin" 		: "*",
								"Access-Control-Allow-Credentials" 	: true
					       	  }
		    }).then(function mySuccess(response) {
		    	scope.data = response.data;
		    	if(scope.data.result == 'success')
		    			$location.path('/home');
		    	else if(scope.data.result == 'userExist'){
		    		alert("User Exit");
		    	}
		    	else
		    		$location.path('/SignUpfailed');
		      },function myError(response) {
		    	alert(response.status);
		    }
		 );
		}
			return user;
	}]);