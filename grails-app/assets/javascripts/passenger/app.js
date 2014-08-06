angular.module("passenger", ["ngResource"])
    .controller("passengerController", function($scope, passengerService){
        $scope.passengers = [];

        passengerService.PassengerList.query().$promise.then(function(data){
            $scope.passengers = data;
        }).catch(function(error){

        }).finally(function(){

        });


    })
    .factory("passengerService", function($resource){
        var PassengerList = $resource("http://localhost:8080/grails-angular-ales/passenger/list", {}, {isCache: true});

        return {
            PassengerList: PassengerList
        }
    });
