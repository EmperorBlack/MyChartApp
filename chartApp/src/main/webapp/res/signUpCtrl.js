app.controller("signUpCtrl", function($scope, user, commonService) {

	
	
	alert("signUp");
	$scope.register = function() {
		commonService.ValidateEmail($scope.userName, $scope);
		commonService.checkPassword($scope.password, $scope);
		commonService.confirmPassword($scope.password, $scope.confirmPass,$scope);
		if ($scope.isValidPassword && $scope.isValidEmail && $scope.isPasswordSame) {
			$scope.body = {
				"userName" : $scope.userName,
				"password" : $scope.password
			}
			user.doSignup($scope, $scope.body);
		}
	}

});
		