package lk.iit.level6.concurrent.assignment;

import java.math.BigDecimal;

public class TicketPrintingSystem {
    public static void main(String[] args) {

        PassengerInfo passengerInfo = new PassengerInfo("John", "0771234567", "test@gmail.com");
        PassengerInfo passengerInfo1 = new PassengerInfo("Janindu", "0771234567", "test@gmail.com");
        PassengerInfo passengerInfo2 = new PassengerInfo("Pathiran", "0771234567", "test@gmail.com");

        TravelInfo travelInfo = new TravelInfo("Colombo", "Kandy");
        TravelInfo travelInfo2 = new TravelInfo("Galle", "Kandy");
        TravelInfo travelInfo3 = new TravelInfo("Matara", "Kandy");


        Ticket ticket = new Ticket(1, new BigDecimal(1000), passengerInfo, travelInfo);
        Ticket ticket2 = new Ticket(2, new BigDecimal(2000), passengerInfo1, travelInfo2);
        Ticket ticket3 = new Ticket(3, new BigDecimal(3000), passengerInfo2, travelInfo3);


        TicketMachine ticketMachine = new Machine(10, 10);

        Passenger passenger = new Passenger(ticketMachine, ticket);
        Passenger passenger2 = new Passenger(ticketMachine, ticket2);
        Passenger passenger3 = new Passenger(ticketMachine, ticket3);

        TicketTonerTechnician ticketTonerTechnician = new TicketTonerTechnician("Toner Technician", (ServiceTicketMachine) ticketMachine);
        TicketPaperTechnician ticketPaperTechnician = new TicketPaperTechnician("Paper Technician", (ServiceTicketMachine) ticketMachine);

        Thread passengerThread = new Thread(passenger, "John");
        Thread passengerThread2 = new Thread(passenger2, "Janindu");
        Thread passengerThread3 = new Thread(passenger3, "Pathiran");

        Thread tonerTechnicianThread = new Thread(ticketTonerTechnician, "Toner Technician");
        Thread paperTechnicianThread = new Thread(ticketPaperTechnician, "Paper Technician");


        passengerThread.start();
        passengerThread2.start();
        passengerThread3.start();

        tonerTechnicianThread.start();
        paperTechnicianThread.start();

    }
}