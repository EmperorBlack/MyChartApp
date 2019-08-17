/*angular
		.module("app111", ["Authenticate"])*/
		app.controller("logInCtrl", function($scope,Authenticate) {
			$scope.authenticate = function(){
				$scope.body={
					"userName" : $scope.email,
					"password" : $scope.password
				}
				 Authenticate.dologIn($scope,$scope.body);
				
			}
		});
		