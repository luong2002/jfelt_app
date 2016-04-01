package com.example.felipe.safe_drive_app;

/**
 * Created by felipe on 2/29/2016.
 */
import android.os.AsyncTask;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connect_Thread extends AsyncTask<String, Void, Integer> {


    protected Integer doInBackground(String... messsage) {
        PrintWriter printwriter;
        Socket client;

        try {
            client = new Socket("10.0.2.2", 4444);  //connect to server
            printwriter = new PrintWriter(client.getOutputStream(),true);
            printwriter.write(messsage[0]);  //write the message to output stream

            printwriter.flush();
            printwriter.close();
            client.close();   //closing the connection


        } catch (UnknownHostException e) {
            e.printStackTrace();
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }


        return 0;
    }

}
