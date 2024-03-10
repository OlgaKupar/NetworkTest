package com.example.networktest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
public class ClientTCP {

    String getServerAnswer (String mNr) throws IOException{

        String serverAnswer;

        Socket clientSocket = new Socket("se2-submission.aau.at", 20080);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        outToServer.writeBytes(mNr+'\n');
        serverAnswer = inFromServer.readLine();

        clientSocket.close();

        return serverAnswer;
    }



}
