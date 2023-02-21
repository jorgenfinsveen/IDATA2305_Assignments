# IDATA2305_Assignments

To run the code you simply run the main class and the results will be printed in the terminal

We observed that when running the code after implementing main class without having done any 
changes to MovieTicketServer, all the users are ordering at the same time. Therefore
everyone is informed about there being 10 tickets left, and the last to order is not allowed to 
order their tickets, even though it is less than 10

To fix this, we made the method bookTickets from public to synchronized and added a sleep to Thread.
This way the users order one by one, and are shown the correct information about available tickets
