# Assignment - IDATA2305
--------
## How to start the program:

1. Go to Main.java
2. Set the desired listening port at <i>Main.serverPort</i>.
3. Chose the servermode at <i>Main.singleThreadMode</i>:
   * <i>true</i>: Single-Threaded server
   * <i>false</i>: Multi-Threaded server
4. Run <i>Main.main(args)</i>.
5. Send HTTP GET requests on localhost:port


## Q&A:

Q: "A question that you might want to think about is why do we want to run the server on its own thread? Can we not run it on the main thread itself?" <br>
A: If we run both the server and the client in the same application, then the server must run on its own thread. This is because different parts of the application waits for
responses from other parts. If there is only one thread running, it will be waiting for a response it cannot process without running the responding component in parallell.
<br><br>


## Single-Threaded vs. Multiple-Threaded

* Single-Threaded:
  * Time: 20.02s
  * Status: 200 OK
  * Size: 156B
* Multiple-Threaded:
  * Time: 10.02s
  * Status: 200 OK
  * Size: 156B

We noticed that when a client sends a HTTP GET request, there are actually two data transmissions from the client to the server. The first message has no content, and we assume that this is the initial step of the TCP three-way-handshake. The second message is the HTTP GET request.<br>

The application is designed in such a way that the server will generate the same type of response regardless of what the client sends it. This means that the server will respond to the first empty message the same way as the actual request. When using the single-threaded server, the server will have to generate a message (which takes 10 seconds) two times. This slows down the efficiency. However, when the server is multi-threaded, both messages receivied from the client can be handled in parallel, and hence, the time of the HTTP interaction between a client and our server has been reduced from 20.02s to 10.02s.<br>

We tried to read the content of the messages which the servers received. The idea was that we could determine whether there were content in the message or not. If it was empty, we could just return an empty response rather than using 10 seconds to generate a response. This did not work out because the server would get stuck in an eternal loop trying to read the empty messages. When the server did not respond to the empty message, the client would wait on sending the actual request. We concluded on just leaving the single-threaded server to generate a response for each message it received regardless of the content, since it really shows why multi-threading is favourable when developing server software such as in this assignment.


