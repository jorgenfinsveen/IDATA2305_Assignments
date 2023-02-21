package no.idata2305.booking;

import java.util.Random;

import com.diogonunes.jcolor.Attribute;

/**
 * Represents a client for the MovieTicket application.
 * 
 * Responsible for trying to book tickets to a specific movie, by
 * sending a request to the server by calling the bookTicket() 
 * method.
 * 
 * It is a sub-class from the Thread.class, meaning it is capapble
 * of running on its own thread.
 */
public class MovieTicketClient extends Thread {
	
    /** Server which the client will be connecting to. */
    private MovieTicketServer movieTicketServer;
    /** Name of the user which the client is being used by. */
    private String user;
    /** The number of seats desired by the user. */
    private int seats;


    /**
     * Creates a new instance of the MovieTicketClient-class.
     */
	public MovieTicketClient(MovieTicketServer server, String user, int seats ) {
		this.movieTicketServer = server;
        this.user = user;
        this.seats = seats;
	}
	
    /**
     * Runs upon start of the thread which the MovieTicketClient
     * instance is located on.
     * 
     * Generates a random color-code for STDOUT color and sends
     * a request to the MovieTicketServer instance.
     */
	@Override
	public void run() {
        Random rand = new Random();
        Attribute TEXT_COLOR = Attribute.TEXT_COLOR(rand.nextInt(255));
		movieTicketServer.bookTicket(user, seats, TEXT_COLOR);
	}
}
