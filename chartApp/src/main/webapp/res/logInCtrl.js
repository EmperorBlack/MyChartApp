/*angular
		.module("app111", ["Authenticate"])*/
		app.controller("logInCtrl", function($scope) {
			$scope.authenticate = function(){
				alert($scope.email);
			}
		});