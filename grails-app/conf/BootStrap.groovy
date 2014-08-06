import com.dmahapatro.example.Passenger
import com.dmahapatro.example.Reservation

class BootStrap {

    def init = { servletContext ->
        // Create Passengers and Reservations

        def jim = new Passenger(firstName: "Jim", lastName: "Kirkbride", age: 37)
        def dj = new Passenger(firstName: "DJ", lastName: "Daugherty", age: 38)
        def don = new Passenger(firstName: "Don", lastName: "Abney", age: 35)
        def kevin = new Passenger(firstName: "Kevin", lastName: "Smith", age: 32)

        Date today = new Date()

        def res1 = new Reservation(departure: "KCMH", arrival: "KDFW", travelDate: today + 4, airline: "Delta")
        def res2 = new Reservation(departure: "KDFW", arrival: "KCMH", travelDate: today + 2, airline: "United")
        def res3 = new Reservation(departure: "KMCI", arrival: "KCLE", travelDate: today + 5, airline: "US Airways")
        def res4 = new Reservation(departure: "KCLE", arrival: "KMCI", travelDate: today + 3, airline: "Southwest")
        def res5 = new Reservation(departure: "KORD", arrival: "KLUK", travelDate: today + 2, airline: "American")
        def res6 = new Reservation(departure: "KLUK", arrival: "KORD", travelDate: today + 8, airline: "Frontier")

        [res1, res2].each { jim.addToReservations it }
        [res3, res4].each { dj.addToReservations it }
        [res5, res6].each { don.addToReservations it }

        [ jim, dj, don, kevin ]*.save(flush: true, failOnError: true)
    }
    def destroy = {
    }
}
