var app = angular.module('app', [ "ui.router" ]);



app.config(function($stateProvider, $urlRouterProvider) {

	$stateProvider.state('home', {
		url : '/home',
		templateUrl : "res/logIn.html",
		controller : "logInCtrl"
	})

	.state('chartPage', {
		url : '/chartPage',
		templateUrl : "res/chartPage.html",
		controller : "massageCtrl"
	}).state('failed', {
		url : '/failed',
		template : "<h1>LogIn Failed </h1>",
	// controller : "SignupCtrl"
	}).state('signUp', {
		url : '/signUp',
		templateUrl : "res/signUp.html",
		controller : "signUpCtrl"
	}).state('SignUpfailed', {
		url : '/SignUpfailed',
		template : "<h1>signUp Failled</h1>",
	// controller : "signUpCtrl"
	});
});
app.controller("mainController",['$scope', '$http', '$state', function($scope,$http,$state ) {

	$scope.initFile = function (){
		$state.go("home");
	}
	}]);
