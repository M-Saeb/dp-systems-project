import com.sun.net.httpserver.HttpServer;

import endpoint.*;

import java.net.InetSocketAddress;
import java.io.IOException;
// import java.util.concurrent.ThreadPoolExecutor;
// import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args){
        HttpServer server;
        try{
           server = HttpServer.create(new InetSocketAddress("localhost", 8081), 0);
        } catch (IOException e){
            System.out.println("<=== IOException Occured ===>");
            e.printStackTrace();
            return;
        }

        // ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        // server.setExecutor(threadPoolExecutor);
        
        server.createContext("/generate-id", new EndpointGenerateID());
        server.createContext("/get-id", new EndpointGetAllMasters());
        server.createContext("/create-trip", new EndpointCreateTrip());
        // server.setExecutor(0);
        server.start();
        System.out.println(" Server started on port 8001");
    }


}
