package com.revature;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import com.revature.controllers.EmployeeController;
import com.revature.utils.ConnectionUtil;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Starting server...");

        HttpServer server = HttpServer.create(new InetSocketAddress(4000), 0);

        server.createContext("/employees", new EmployeeController());
        server.setExecutor(null);
        server.start();

        ConnectionUtil.getConnection();
    }
}
