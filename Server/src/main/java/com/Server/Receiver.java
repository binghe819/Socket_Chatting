package com.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class Receiver extends Thread{

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    HashMap<String, DataOutputStream> clients;
    View view;

    public Receiver(Socket socket, HashMap<String, DataOutputStream> clients, View view) {
        this.socket = socket;
        this.clients = clients;
        this.view = view;
        try {
            in = new DataInputStream(this.socket.getInputStream());
            out = new DataOutputStream(this.socket.getOutputStream());
        } catch (IOException e){e.printStackTrace();}
    }

    @Override
    public void run() {
        String name = "";
        try {
            name = in.readUTF();
            sendToAll("# "+name+"님이 입장하셨습니다. ");

            clients.put(name, this.out);
            view.getLogText().append("# "+name+"님이 입장하셨습니다. \n");
            view.getLogText().append("현재 서버 접속자 수는 " + clients.size()+" 입니다.\n");

            while(in != null) {
                sendToAll(in.readUTF());
            }

        } catch (IOException e) {
            view.getLogText().append("퇴장자가 있습니다.\n");
        } finally {
            // 로그아웃 처리
            sendToAll("# "+name+"님이 퇴장하셨습니다. ");
            view.getLogText().append("# "+name+"님이 퇴장하셨습니다. \n");
            clients.remove(name);
            view.getLogText().append("["+socket.getInetAddress()+ ":"+socket.getPort()+", name : "+name+" ] 에서 접속을 종료하였습니다.\n"); //Log
            view.getLogText().append("현재 서버 접속자 수는 " + clients.size()+" 입니다.\n");
        }
    }

    public void sendToAll(String content) {
        Iterator it = clients.keySet().iterator();

        while(it.hasNext()) {
            try {
                DataOutputStream out = (DataOutputStream) clients.get(it.next());
                out.writeUTF(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

