package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.revature.service.EmployeeService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class EmployeeController implements HttpHandler {
    
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String verb = exchange.getRequestMethod();

        switch (verb) {
            case "GET":
                getRequest(exchange);
                break;
        
            case "POST":
                postRequest(exchange);
                break;

            default:
                break;
        }
    }

    private void getRequest(HttpExchange exchange) throws IOException {

        EmployeeService serv = new EmployeeService();
        String jsonCurrentList = serv.getAllEmps();

        exchange.sendResponseHeaders(200, jsonCurrentList.getBytes().length);

        OutputStream os = exchange.getResponseBody();
        os.write(jsonCurrentList.getBytes());
        os.close();
    }

    private void postRequest(HttpExchange exchange) throws IOException {

        // Input stream contains bytes
        InputStream is = exchange.getRequestBody();

        // Convert our InputStream into a String
        StringBuilder txtbuilder = new StringBuilder();

        // This will convert the input letter into letters
        try (Reader reader = new BufferedReader(new InputStreamReader(is, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c= 0;

            while ((c = reader.read()) != -1) {

                // Appends the letter to our text
                txtbuilder.append((char) c);
            }
        }
    
        exchange.sendResponseHeaders(200, txtbuilder.toString().getBytes().length);

        // Call on the service layer and execute the method
        EmployeeService serv = new EmployeeService();
        serv.register(txtbuilder.toString());

        OutputStream os = exchange.getResponseBody();
        os.write(txtbuilder.toString().getBytes());
        os.close();

    }
}