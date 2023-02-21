package no.ntnu.idata2305.group10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Represents a multi-threaded server.
 */
public class MultiThreadedServer implements Runnable {

    protected int serverPort = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
  
    public MultiThreadedServer(int port) {
        this.serverPort = port;
    }
  
    public void run() {
        System.out.println("Multi-threaded server listening on port: " + serverPort);

        openServerSocket();
        Socket newClient;
  
        while (!isStopped()) {
            try { 
                newClient = serverSocket.accept();
                System.out.println(newClient.getInetAddress() + ":" + newClient.getPort());

                // on receiving a request, execute the heavy computation in a new thread
                new Thread(
                    new AsyncSearchSimulator(
                        newClient, 
                        "Multithreaded Server: "
                    )
                ).start();
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

    public synchronized void stop() {
        isStopped = true;
        try { serverSocket.close(); } 
        catch (Exception e) { e.printStackTrace(); } 
    }

    private void openServerSocket() {
        try { serverSocket = new ServerSocket(serverPort); } 
        catch (IOException e) { e.printStackTrace(); }
    }
}

