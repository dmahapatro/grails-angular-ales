package com.dmahapatro.example

class Reservation {
    String departure
    String arrival
    Date travelDate
    String airline

    static belongsTo = [passenger: Passenger]
}
