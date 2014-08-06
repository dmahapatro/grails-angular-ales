<%@ page contentType="text/html;charset=UTF-8" %>
<html ng-app="passenger">
<head>
    <base href="grails-angular-ales">
    <title>Passengers</title>
    <asset:javascript src="application.js"/>
    <asset:stylesheet src="application.css"/>
    <asset:link rel="shortcut icon" href="airplane.ico" type="image/x-icon"/>
</head>

<body ng-controller="passengerController" class="container">
    <h4 class="alert alert-warning">
        <span>Passengers and Reservations</span>
        <sub class="pull-right text-muted">Show Json <input type="checkbox" ng-model="showJson" ng-click="showJson=!showJson"/></sub>
    </h4>
    <div ng-repeat="pax in passengers" class="panel panel-success">
        <div class="panel-heading">
            <span>{{ pax.firstName }} {{ pax.lastName }}</span>
            <span class="pull-right">AGE: {{ pax.age }}</span>
        </div>
        <div class="panel-body">
            <div ng-repeat="reservation in pax.reservations"
                 class="well" ng-if="pax.reservations.length > 0">
                <div>
                    Date of Travel  : <span class="label label-warning">{{ reservation.travelDate | date:'medium' }}</span>
                    Departure       : <span class="label label-success">{{ reservation.departure }}</span>
                    Arrival         : <span class="label label-success">{{ reservation.arrival }}</span>
                    Airline         : <span class="label label-success">{{ reservation.airline }}</span>
                    <div class="pull-right">
                        <button type="button" ng-click="reservation.isModify=!reservation.isModify"
                                class="btn btn-warning btn-xs">Modify</button>
                        <button type="button" class="btn btn-danger btn-xs">Delete</button>
                    </div>

                    <div ng-if="reservation.isModify" class="form-group">
                        Departure : <input ng-model="reservation.departure" class="form-control"/>
                        Arrival   : <input ng-model="reservation.arrival" class="form-control"/>
                        Airline   : <input ng-model="reservation.airline" class="form-control"/>
                    </div>

                    <div ng-if="showJson"><br><code>{{ reservation | json }}</code></div>
                </div>
            </div>
            <div ng-if="pax.reservations.length < 1">
                <div class="alert alert-danger">No Reservations found for {{ pax.firstName }} {{ pax.lastName }}.</div>
            </div>
        </div>
    </div>
</body>
</html>