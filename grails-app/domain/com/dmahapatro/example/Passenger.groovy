package com.dmahapatro.example

class Passenger {
    String firstName
    String lastName
    Integer age

    static hasMany = [reservations: Reservation]

    static mapping = {
        //reservations fetch: 'join'
    }

    static fetchMode = [reservations: 'eager']
}
