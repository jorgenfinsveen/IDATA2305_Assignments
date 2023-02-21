package no.ntnu.idata2305.group10;

/**
 * Main class of the application.
 */
public class Main {

    /** Determines which server-mode to use. Single-threaded if true, else Multi-threaded. */
    private static boolean singleThreadMode = false;
    /** Port number which the server will be listening on.*/
    private static int serverPort = 8080;

    /** 
     * Method starting the server.
    */
    public static void main(String[] args) {
        System.out.println("\n");
        if (singleThreadMode) new SingleThreadedServer(serverPort).run();
        else new MultiThreadedServer(serverPort).run(); 
    }
}
