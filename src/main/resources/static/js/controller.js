/*//var app2 = angular.module('app', []);
app.controller('postcontroller', function($scope, $http, $location) {
  $scope.submitForm = function(){
	  
	  $location.path('/');
  }
});
 

function postcontroller($scope, $http, $location){
	
	  $scope.submitForm = function(){
		  
		  $location.path('/');
	  }
	
}
app.controller('getcontroller', function($scope, $http, $location) {
  $scope.getfunction = function(){
	  $http({
		  method: 'GET',
		  url: '/covid/patients'
		}).then(function successCallback(response) {
			
			console.log(response);
		    // this callback will be called asynchronously
		    // when the response is available
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
  }
});
*/