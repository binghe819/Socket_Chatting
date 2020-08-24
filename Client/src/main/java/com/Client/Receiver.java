package com.Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver extends Thread{

    View view;
    Socket socket;
    DataInputStream in;

    public Receiver(View view, Socket socket) throws IOException {
        this.view = view;
        this.socket = socket;
        in = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        while(in != null){
            try {
                view.getContentText().append(in.readUTF()+"\n");
            } catch (IOException e){e.printStackTrace();}
        }
    }
}
