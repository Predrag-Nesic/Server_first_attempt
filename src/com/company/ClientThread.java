package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {
    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello client.");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responce = input.readLine();
            System.out.println(responce);
            input.close();
            out.close();
            socket.close();
        } catch(Exception ex) {
            System.err.println(ex.toString());
        }
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
