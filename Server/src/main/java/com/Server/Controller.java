package com.Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

// Controller 겸 Model
public class Controller extends Thread{

    View view;
    HashMap<String, DataOutputStream> clients;
    int port;

    public Controller(View view, int port) {
        this.view = view;
        clients = new HashMap<>();
        Collections.synchronizedMap(clients); // 동기화
        this.port = port;
    }

    @Override
    public synchronized void run() {
        ServerSocket serverSocket;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(this.port);
            view.getLogText().append("### 서버가 동작하기 시작합니다. ###\n");
            SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
            Date time = new Date();
            view.getLogText().append("- Time : "+format.format(time)+"\n");
            view.getLogText().append("- Port : "+this.port+"\n");
            // 화면 전환
            view.getAdminLoginPanel().setVisible(false);
            view.getAdminPanel().setVisible(true);
            while(true){
                // 새로운 유저 접속 (socket)
                socket = serverSocket.accept(); // 블록
                view.getLogText().append("### ["+socket.getInetAddress()+":"+socket.getPort()+"] 에서 접속하였습니다. ###\n");

                // 새로운 유저의 Receiver스레드 실행
                new Receiver(socket, this.clients, view).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 공인 IP 조회하는 메서드
    public static String getIp() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}