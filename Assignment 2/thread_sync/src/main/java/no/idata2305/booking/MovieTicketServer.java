package no.idata2305.booking;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

public class MovieTicketServer {
    
    private String movieName;
    private int availableSeats;


	public MovieTicketServer(String movieName, int availableSeats) {
		this.movieName = movieName;
        this.availableSeats = availableSeats;
	}


	public synchronized void bookTicket(String user, int numberOfSeats, Attribute TEXT_COLOR) {
        try { Thread.sleep(100); } 
        catch (InterruptedException e) { e.printStackTrace(); }

        print("Welcome, " + user, true, TEXT_COLOR);
        print("Available tickets for " + movieName + ": " + availableSeats, true, TEXT_COLOR);

		if ((availableSeats - numberOfSeats) < 0) {
			print("Unfortunately, we have only " + availableSeats + " left.", true, TEXT_COLOR);
		} else {
            decrementAvailableSeats(numberOfSeats);
            print("Succesfull booking for " 
                + user + " at " + movieName 
                + " for " + numberOfSeats 
                + " seats.\n", true, TEXT_COLOR
            );
        }
	}


    private void decrementAvailableSeats(int numberOfSeats) {
        if (this.availableSeats - numberOfSeats >= 0) {
            this.availableSeats -= numberOfSeats;
        } else {
            throw new IllegalArgumentException("We do not have enough seats available.");
        }
    }

    private void print(String string, boolean newLine, Attribute color) {
        if (newLine) System.out.println(Ansi.colorize(string, color));
        else System.out.print(Ansi.colorize(string, color));
    }
}
