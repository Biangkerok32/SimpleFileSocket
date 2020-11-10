package com.company;

import Client.SimpleFileClient;
import Server.SimpleFileServer;

import java.io.File;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SimpleFileServer Server = new SimpleFileServer(3000, "/users/derekjames/Downloads");
        Server.listen();

    }
}


