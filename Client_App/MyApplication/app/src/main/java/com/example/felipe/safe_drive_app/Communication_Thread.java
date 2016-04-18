package com.example.felipe.safe_drive_app;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.os.Looper;

/**
 * Created by felipe on 4/18/2016.
 */
public class Communication_Thread extends Thread{

    private Socket server;
    private InputStreamReader streamReader;
    private BufferedReader bufferedReader;
    private boolean execute;



    public Communication_Thread(Socket server) throws IOException
    {
        this.server = server;
        this.streamReader = new InputStreamReader(server.getInputStream());
        this.bufferedReader = new BufferedReader(streamReader);
        this.execute = false;
    }

    public void  run() {
        String messageReceived;
        execute = true;
       while (execute) {
            try {
                if (bufferedReader.ready()) {
                    messageReceived = bufferedReader.readLine();
                    Log.i("info", messageReceived);
                }
            } catch (IOException e) {
                execute = false;
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        try {
            Log.i("info", "Ended Info Receiver");
            bufferedReader.close();
            streamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stopCommunication()
    {
        this.execute = false;
    }

    public boolean isExecuting()
    {
        return execute;
    }
}
