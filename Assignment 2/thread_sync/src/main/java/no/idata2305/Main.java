package no.idata2305;

import no.idata2305.booking.MovieTicketClient;
import no.idata2305.booking.MovieTicketServer;

/**
 * Represents the starting point of the application.
 */
public class Main {

    /**
     * Starts the application by initializing a server as well as four
     * different clients running on their own threads.
     */
    public static void main(String[] args) {
        System.out.println("");

        /* Creating a new server for a movie. */
        MovieTicketServer movieTicketServer = new MovieTicketServer("Troll", 10);

        /* Creating 4 threads. */ 
        Thread t1 = new MovieTicketClient(movieTicketServer, "Xiangming", 3);
        Thread t2 = new MovieTicketClient(movieTicketServer, "Ilaria", 2);
        Thread t3 = new MovieTicketClient(movieTicketServer, "Sam", 3);
        Thread t4 = new MovieTicketClient(movieTicketServer, "Andreas", 4);
        
        /* Starting all threads. */ 
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
