/*angular
		.module("app111", ["Authenticate"])*/
		app.controller("logInCtrl", function($scope,user,commonService) {
			$scope.authenticate = function(){
				commonService.ValidateEmail( $scope.userName,$scope);
				commonService.checkPassword( $scope.password,$scope);
				if($scope.isValidPassword && $scope.isValidEmail)
					{
					$scope.body={
							"userName" : $scope.userName,
							"password" : $scope.password
						}
					user.dologIn($scope,$scope.body);
					}		
			}
		});
		