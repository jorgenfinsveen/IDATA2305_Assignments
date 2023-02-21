package no.idata2305.booking;

import java.util.Random;

import com.diogonunes.jcolor.Attribute;

public class MovieTicketClient extends Thread {
	
    private MovieTicketServer movieTicketServer;
    private String user;
    private int seats;

	public MovieTicketClient(MovieTicketServer server, String user, int seats ) {
		this.movieTicketServer = server;
        this.user = user;
        this.seats = seats;
	}
	
	@Override
	public void run() {
        Random rand = new Random();
        Attribute TEXT_COLOR = Attribute.TEXT_COLOR(rand.nextInt(255));
		movieTicketServer.bookTicket(user, seats, TEXT_COLOR);
	}
}
