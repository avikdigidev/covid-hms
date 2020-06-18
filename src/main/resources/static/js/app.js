var app = angular.module('app', [ 'ngRoute' ]);

app.config([ '$locationProvider', function($locationProvider) {
	$locationProvider.hashPrefix('');
} ]);
app.config(function($routeProvider, $locationProvider) {
	$routeProvider.when('/covid/', {
		templateUrl : 'index.html',
	// controller: 'FirstController'
	}).when('/covid/PatientDet', {
		templateUrl : 'pages/PatientDet.htm',
		controller : 'FirstController'
	}).when('/view2', {
		templateUrl : 'view2.html',
		controller : 'SecondController'
	}).otherwise({
		redirectTo : '/covid/'
	});
	$locationProvider.html5Mode(true);
});

/*
 * app.config(function($routeProvider, $locationProvider, $httpProvider) {
 * $routeProvider .when("/covid/", { templateUrl : "index.html" })
 * .when("/PatientDet", { templateUrl : "PatientDet.html" }) .when("/clinical", {
 * templateUrl : "clinical.html" }) .when("/inPatient", { templateUrl :
 * "inPatient.html" }) .otherwise({ template : "index.html" });
 * $locationProvider.html5Mode(true); });
 */

// var app2 = angular.module('app', []);
app.controller('RegisTrationcontroller', function($scope, $http, $location) {
	$scope.submitFunction = function(obj) {
		console.log(obj);
		var regObj = {};
		regObj = {
			firstname : obj.firstname,
			age : obj.age,
			sex : obj.sex,
			city : obj.village,
			district : obj.Dist,
			Address : obj.address,
			mobilenumber : obj.Number
		}

		console.log(regObj);

		$http.post('/covid/addPatient', regObj).then(function(response) {

			// This function handles success
			alert("Added Successfully");

		});
	}
	$scope.RegPage = true;
	$scope.patientDiv = false;

	$scope.RegDiv = function() {
		$scope.patientDiv = false;
		$scope.RegPage = true;
	}

	$scope.patientListDiv = function() {
		$scope.patientDiv = true;
		$scope.RegPage = false;

	}

});

/*
 * function postcontroller($scope, $http, $location){
 * 
 * $scope.submitForm = function(){
 * 
 * $location.path('/'); } }
 */
app.controller('getcontroller', function($scope, $http, $location) {

	$scope.getfunction = function() {
		$http({
			method : 'GET',
			url : '/covid/patients'
		}).then(function successCallback(response) {

			console.log(response);
			$scope.patientdata = response.data;
			$scope.backToList();
			// this callback will be called asynchronously
			// when the response is available
		}, function errorCallback(response) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	}
	$scope.getfunction();
	$scope.backToList = function() {

		$scope.Clinical = false;
		$scope.inPatient = false;
	};

	$scope.addClin = function(patient) {
		$scope.dateOfAdmission = patient.dateOfAdmission;
		$scope.editPatient = patient.firstName;
		$scope.patientId = patient.patientId;
		$scope.Clinical = true;
		$scope.inPatient = false;

	}
	$scope.submitFunctionClinical = function(obj) {
		obj["patientid"] = $scope.patientId;
		obj["admittedon"] = $scope.dateOfAdmission;
		console.log(obj);
		var regObj = {};
		regObj = {
			firstname : obj.firstname,
			age : obj.age,
			sex : obj.sex,
			city : obj.village,
			district : obj.Dist,
			Address : obj.address,
			mobilenumber : obj.Number
		}

		console.log(regObj);
		$http.post('/covid/updatePatient', regObj).then(function(response) {

			// This function handles success
			alert("Updated Succesfully");
		});

	}

	$scope.submitFunctionInPatient = function(obj) {
		obj["patientid"] = $scope.patientId;
		obj["admittedon"] = $scope.dateOfAdmission;
		console.log(obj);
		$http.post('/covid/updatePatient', obj).then(function(response) {

			// This function handles success
			alert("Updated Succesfully");

		});

	}

	$scope.addInPat = function(patient) {
		$scope.dateOfAdmission = patient.dateOfAdmission;
		$scope.editPatient = patient.firstName;
		console.log(patient)
		$scope.patientId = patient.patientId;
		$scope.Clinical = false;
		$scope.inPatient = true;
	}
});
