# IDATA2305_Assignments

## How to start

To run the code you simply run <code>Main.main()</code> and the results will be printed to the terminal.


## Observations

### Before applying <code>Thread Synchronization</code>

We noticed several problems when running the application:
* The server handling its requests did not do so in a orderly fashion.
* It was difficult to determine which client the server was handling when reading STDOUT messages.
* The amount of available tickets were not up to date.


### Solution

As well as having the server handle the request in the same order as they arrive, we wanted to be able see which client was which in STDOUT. We resolved this by adding a randomly generated color to each client which were applied to the STDOUT for each client. In this way, each client has their own color, making it easier to differentiate between them.

For the synchronization issue, we made <code>MovieTicketServer.bookTicket()</code> a <i>synchronized</i> method. This allows us to make sure that the method is not executed concurrently, which ensures that each client will be serviced in the order which they contacted the server, as well as each client receiving up to date information regarding the amount of available tickets.


### After applying <code>Thread Synchronization</code>

After implementing our solution, we noticed that each client is handled before the next is. This ensures that each client is prioritized based on the time of contact, and that each client receives the correct information.

By adding color-codes to each client's STDOUT, it became much easier to distingush between them as well.