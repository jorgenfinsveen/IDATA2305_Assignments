package no.idata2305.booking;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

/**
 * Represents a server in the MovieTicket application.
 * 
 * Responsible for servicing clients by trying to handle
 * reservations of seats to the movie which the server is
 * configured to be responsible for.
 */
public class MovieTicketServer {
    
    /** The name of the movie which the server is responsible for. */
    private String movieName;
    /** Number of seats available to the movie.  */
    private int availableSeats;

    /**
     * Creates a new instance of the MovieTicketServer-class.
     */
    public MovieTicketServer(String movieName, int availableSeats) {
        this.movieName = movieName;
        this.availableSeats = availableSeats;
    }

    /**
     * Book tickets for the movie which the server is responsible for.
     * 
     * The method is synchronized, ensuring that each client is handled
     * in an orderly fashion. If there are avialable tickets, the server
     * will inform the client of successful booking, else, it will not
     * book any tickets and inform the client.
     * 
     * @param user the name of the user of the client.
     * @param numberOfSeats the number of seats which the clients wish to reserve.
     * @param TEXT_COLOR the color-code which are to be used in STDOUT.
     */
    public synchronized void bookTicket(String user, int numberOfSeats, Attribute TEXT_COLOR) {
        try { Thread.sleep(100); } 
        catch (InterruptedException e) { e.printStackTrace(); }

        print("Welcome, " + user, true, TEXT_COLOR);
        print("Available tickets for " + movieName + ": " + availableSeats, true, TEXT_COLOR);

        if ((availableSeats - numberOfSeats) < 0) {
            print("Unfortunately, we have only " + availableSeats + " left.", true, TEXT_COLOR);
        } else {
            decrementAvailableSeats(numberOfSeats);
            print("Succesfull booking of " + numberOfSeats 
                + " seats by " + user + " to the movie \"" + movieName 
                + "\".\n", true, TEXT_COLOR
            );
        }
    }

    /**
     * Decrement the number of available seats upon booking.
     * 
     * @param numberOfSeats number of seats which are to be removed.
     */
    private void decrementAvailableSeats(int numberOfSeats) {
        if (this.availableSeats - numberOfSeats >= 0) {
            this.availableSeats -= numberOfSeats;
        } else {
            throw new IllegalArgumentException("We do not have enough seats available.");
        }
    }

    
    /**
     * Write colorized text to STDOUT.
     * 
     * @param string the string to print.
     * @param newLine wether to add a new line or not (true if yes).
     * @param color the color of the text to print.
     */
    private void print(String string, boolean newLine, Attribute color) {
        if (newLine) System.out.println(Ansi.colorize(string, color));
        else System.out.print(Ansi.colorize(string, color));
    }
}
