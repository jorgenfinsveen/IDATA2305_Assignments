package no.ntnu.idata2305.group10;

import java.io.PrintWriter;
import java.net.Socket;

public class AsyncSearchSimulator implements Runnable {

    protected Socket clientSocket = null;
    protected String serverText = null;
  
    public AsyncSearchSimulator(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText = serverText;
    }
  
    public void run() {

        /* Uses the responsegenerator to create a response. */
        try {
            long time1 = System.currentTimeMillis();
            Thread.sleep(10 * (long) 1000);
    
            long time2 = System.currentTimeMillis();
    
            String body = ResponseGenerator.generatorResponseHTML(serverText, time1, time2);
            String header = ResponseGenerator.generatorResponseHeader(body.length());

            new PrintWriter(clientSocket.getOutputStream(), true).println(header + body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}