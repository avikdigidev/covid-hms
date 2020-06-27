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
app.controller('RegisTrationcontroller', function($scope, $http, $location,$timeout,$window,$filter) {
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
	//		alert("Added Successfully");

		});
		$timeout( function(){
			alert("Added Successfully");
			
			$window.location.reload();
			}, 1500 		);
		
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
		$scope.getfunction();
		
	}
	$scope.getfunction = function() {
		$http({
			method : 'GET',
			url : '/covid/patients'
		}).then(function successCallback(response) {

			console.log(response);
			$scope.patientdata = response.data;
			console.log($scope.patientdata);

			$scope.Clinical = false;
			$scope.inPatient = false;
			// this callback will be called asynchronously
			// when the response is available
			
		//	$apply();
			
		}, function errorCallback(response) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	}
	

});

/*
 * function postcontroller($scope, $http, $location){
 * 
 * $scope.submitForm = function(){
 * 
 * $location.path('/'); } }
 */
app.controller('getcontroller', function($scope, $http, $location,$window,$filter,$timeout) {

	//$scope.$watch('$scope.patientDiv', $scope.getfunction);
	$scope.$watch('searchtxt', function(newValue,oldValue){ 
		if(oldValue!=newValue){
        $scope.currentPage = 0;
      }
    },true);
	  $scope.currentPage = 0;
	    $scope.pageSize = 10;
	    $scope.patientdata=[];
	    $scope.numberOfPages=function(){
	        return Math.ceil($scope.patientdata.length/$scope.pageSize);                
	    }
	$scope.getfunction = function() {
		$http({
			method : 'GET',
			url : '/covid/patients'
		}).then(function successCallback(response) {

			console.log(response);
			$scope.patientdata = response.data;
			console.log($scope.patientdata);
			$scope.backToList();
			// this callback will be called asynchronously
			// when the response is available
			
		//	$apply();
			
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
		$scope.dateOfAdmission = patient.admittedon;
		$scope.editPatient = patient.firstname;
		$scope.patientId = patient.patientid;
		$scope.Clinical = true;
		$scope.inPatient = false;

	}
	$scope.submitFunctionClinical = function(obj) {
		obj["patientid"] = $scope.patientId;
		obj["admittedon"] = $scope.dateOfAdmission;
		console.log(obj);
		var regObj = {};
		regObj = {
				"admittedon" : obj.admittedon,
				"actiontaken" : obj.actiontaken,
				"comment" : obj.comment,
				"comorbidity" : obj.comorbidity,
				"contacthistory" : obj.contacthistory,
				"covidactivestatus": obj.covidactivestatus,
				"patientid" : obj.patientid,
				"symptomstatus" : obj.symptomstatus,
				"travelhistory" : obj.travelhistory

		}

		console.log(regObj);
		$http.post('/covid/updateInClinic', regObj).then(function(response) {
console.log(response);
			// This function handles success
		//	alert("Updated Succesfully");
		});
		$timeout( function(){
			alert("Updated Successfully");
			
		$window.location.reload();
			}, 1500 		);

	}

	$scope.submitFunctionInPatient = function(obj) {
		obj["patientid"] = $scope.patientId;
		obj["admittedon"] = $scope.dateOfAdmission;
		console.log(obj);
		
		var regObj = {};
		regObj = {
				"dateoffirst" : obj.SamplecollectionDate1,
				"dateofsecondtest" : obj.SamplecollectionDate2,
				"dateofthirdtest" : obj.SamplecollectionDate3,
				"admittedon" : obj.admittedon,
				"dateoffirstresult" : obj.dateoffirstresult,
				"dateofsecondresult" : obj.dateofsecondresult,
				"dateofthirdresult" : obj.dateofthirdresult,
				"firstresult" : obj.firstresult,
				"outcome" : obj.outcome,
				"patientid" : obj.patientid,
				"secondresult" : obj.secondresult,
				"thirdresult" : obj.thirdresult

		}

		console.log(regObj);
		$http.post('/covid/updateInPatient', regObj).then(function(response) {
			console.log(response);

			// This function handles success
			//alert("Updated Succesfully");

		});
		$timeout( function(){
			alert("Updated Successfully");
			
			$window.location.reload();
			}, 1500 		);

	}
	
	$scope.openModal=function(details){
		console.log(details);
		$scope.patientFullDetails=details;
		$('#myModal').modal('show');
		
	}

	$scope.addInPat = function(patient) {
		$scope.dateOfAdmission = patient.admittedon;
		$scope.editPatient = patient.firstname;
		$scope.patientId = patient.patientid;
		$scope.Clinical = false;
		$scope.inPatient = true;
	}
});



app.filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});
