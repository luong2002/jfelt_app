package com.example.felipe.safe_drive_app;

/**
 * Created by felipe on 2/29/2016.
 */
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Connect_Thread extends AsyncTask<String, Void, Integer> {


    private static boolean connected;
    private static Socket server;
    private static PrintWriter printwriter;
    private static Communication_Thread cm;

    protected Integer doInBackground(String... message) {

        if(!connected) {
            try {
                server = new Socket("10.0.2.2", 4444);  //connect to server
                printwriter = new PrintWriter(server.getOutputStream(), true);
                connected = true;
                cm = new Communication_Thread(server);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Log.i("info", message[0]);

        printwriter.println(message[0]);  //write the message to output stream
        if(printwriter.checkError())
        {
            Log.i("ERROR:","Message not sent");
        }
        printwriter.flush();


        return 0;
    }

    public static void setConnected(boolean bool)
    {

        connected = bool;
    }

    public void closeConnection()
    {
        try {
            cm.stopCommunication();
            printwriter.close();
            server.close();   //closing the connection
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startCommunication()
    {
        if(connected)
            if(!cm.isExecuting())
            cm.start();
    }
}
