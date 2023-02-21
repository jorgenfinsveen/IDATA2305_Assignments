package no.ntnu.idata2305.group10;

public class ResponseGenerator {


    public static String generatorResponseHTML(String title, long time1, long time2) {
        return ("<html><body>" + title +
            time1 + " - " + time2 +
            "</body></html>");
    }

    
    public static String generatorResponseHeader(int contentLength) {
        return ("HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: " + contentLength +
            "\r\n\r\n");
    }
}