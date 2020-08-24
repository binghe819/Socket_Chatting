package com.Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    view.getFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // 채팅 접속버튼 이벤트
        view.getLoginBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ip, port, name받아오기
                String ip = view.getIpInputText().getText();
                String port = view.getPortInputText().getText();
                String name = view.getNameInputText().getText();

                // 화면 전환
                view.getLoginPanel().setVisible(false);
                view.getChattingPanel().setVisible(true);

                // Controller를 통해 채팅 동작
                try {
                    Socket socket = new Socket(ip, Integer.parseInt(port));
                    Controller controller = new Controller(socket, view, name);
                } catch (UnknownHostException unknownHostException) {
                    unknownHostException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
