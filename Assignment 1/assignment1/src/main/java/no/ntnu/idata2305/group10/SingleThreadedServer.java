package no.ntnu.idata2305.group10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Represents a server which is single-threaded.
 */
public class SingleThreadedServer implements Runnable {

    protected int serverPort = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;

    public SingleThreadedServer(int port) {
        this.serverPort = port;
    }

    public void run() {
        System.out.println("Single-threaded server listening on port: " + serverPort);

        openServerSocket();
        Socket clientSocket;
        while (!isStopped()) {
            /* Listens for incoming messages from clients. */
            try { 
                clientSocket = serverSocket.accept();
                handleClient(clientSocket); 
            } catch (Exception e) { 
                stop();
                e.printStackTrace(); 
            }
        }   
        System.out.println("Server Stopped.");
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }


    public synchronized void stop()  {
        isStopped = true;
        try { serverSocket.close(); } 
        catch (Exception e) { e.printStackTrace(); } 
    }


    private void openServerSocket() {
        try { serverSocket = new ServerSocket(serverPort); } 
        catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * Displays the address of the client and proceeds to request processing.
     */
    private void handleClient(Socket clientSocket) throws Exception {
            System.out.println(clientSocket.getInetAddress() + ":" + clientSocket.getPort());
            SearchSimulator.processClientRequest(clientSocket, "Singlethreaded Server: "); 
    }
}