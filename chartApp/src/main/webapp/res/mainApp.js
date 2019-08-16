var app = angular.module('app', [ "ui.router" ]);



app.config(function($stateProvider,  
        $urlRouterProvider) { 
 
		$stateProvider.state('home', {
		url : 'home',
		templateUrl : "res/logIn.html",
		controller : "logInCtrl"
		/*})
		
		.state('logIn', {
		url : '/logIn',
		template : "<h1>Login success</h1>",
		controller : "logInCtrl"*/
	});
/*.state('Signup', {
		url : '/signup',
		template : "<h1>Signup Page</h1>",
		controller : "SignupCtrl"
	});

 
//	$urlRouterProvider.otherwise("/home");
*/});
app.controller("mainController",['$scope', '$http', '$state', function($scope,$http,$state ) {/*
//	alert($scope.message );
//	alert($scope.mydiv);
	
//	$scope.mydiv = 'it can access';*/
	$scope.initFile = function (){
		$state.go("home");
	}
/*	$scope.fun = function()
	{
		alert($scope.msg);
	}*/
	}]);
