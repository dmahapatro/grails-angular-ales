package com.dmahapatro.example

import grails.converters.JSON
import grails.rest.RestfulController

class PassengerController extends RestfulController<Passenger> {

    PassengerController() {
        super( Passenger )
    }

    def index() {

    }

    def listPassengers() {
        def passengers = Passenger.where { }.list()
        render passengers as JSON
    }
}
