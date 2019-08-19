		app.controller("massageCtrl", function($scope,$rootScope,user,commonService,massageService) {
			
			$scope.onload = function()
			{
				$scope.loggedInUser = $rootScope.data.userName;
				$scope.loggedInUserId = $rootScope.data.userId;
				massageService.getUsers($rootScope,$scope);
			}
			$scope.selectedSender = function(user){
				$scope.selectedRcvrId = user.userId;
				massageService.getConversionData($scope,$scope.selectedRcvrId,$rootScope.data.userId);
				$scope.selectedReciver = user.userName;
				
			}
			$scope.sendMsg = function(){
				if($scope.msgContent != "" && $scope.selectedRcvrId != null ){
					$scope.msgBody={
							"message"  : $scope.msgContent,
							"reciverUserId" : $scope.selectedRcvrId,
							"senderUserId" : $rootScope.data.userId
						}
					 $scope.msgContent = "";
					massageService.saveMsg($scope,$scope.msgBody,$rootScope);
				}
			}
		});