app.factory('massageService',['$http','$location','$interval',function($http,$location,$interval){
		
		var massageService = {};
		massageService.getUsers = function(rootscope,scope){
					  $http({
							url 		: "/chartApp/user/getUserList?userId="+rootscope.data.userId,
							dataType 	: "json",
							method 		: "post",
							headers 	: {
											"Content-Type"     					: "application/json",
											"Access-Control-Allow-Origin" 		: "*",
											"Access-Control-Allow-Credentials" 	: true
								       	  }
					    }).then(function mySuccess(response) {
					    	scope.users = response.data.result;
	
					      },function myError(response) {
					    	alert(response.status);
					    }
					 );
			     }
		massageService.saveMsg = function(scope,msgBody,rootScope){
			$interval.cancel(scope.interval);
			 $http({
					url 		: "/chartApp/massage/add",
					dataType 	: "json",
					data        : msgBody,
					method 		: "post",
					headers 	: {
									"Content-Type"     					: "application/json",
									"Access-Control-Allow-Origin" 		: "*",
									"Access-Control-Allow-Credentials" 	: true
						       	  }
			    }).then(function mySuccess(response) {
			    	alert( response.data.result);
			    	massageService.getConversionData(scope,scope.selectedRcvrId,rootScope.data.userId)

			      },function myError(response) {
			    	alert(response.status);
			    }
			 );
		}
		massageService.getConversionData = function(scope,reciverId,senderId){
			if(scope.interval != null)	
				$interval.cancel(scope.interval);
			scope.interval=$interval(function () {
				  $http({
						url 		: "/chartApp/massage/getMsgs?reciverId="+reciverId+"&senderId="+senderId,
						dataType 	: "json",
						method 		: "post",
						headers 	: {
										"Content-Type"     					: "application/json",
										"Access-Control-Allow-Origin" 		: "*",
										"Access-Control-Allow-Credentials" 	: true
							       	  }
				    }).then(function mySuccess(response) {
				    	scope.ChatData =  response.data.result;

				      },function myError(response) {
				    	alert(response.status);
				    }
				 );
			  }, 8000);
		}
		
			return massageService;
	}]);