package com.example.felipe.safe_drive_app;

/**
 * Created by felipe on 2/29/2016.
 */
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connect_Thread extends AsyncTask<String, Void, Integer> {


    private static boolean connected;
    private static Socket client;
    private static PrintWriter printwriter;

    protected Integer doInBackground(String... message) {

        if(!connected)
        {
            try{
                client = new Socket("10.0.2.2", 4444);  //connect to server
                printwriter = new PrintWriter(client.getOutputStream(),true);
                connected = true;
            }catch (IOException e)
            {
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
            printwriter.close();
            client.close();   //closing the connection
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
