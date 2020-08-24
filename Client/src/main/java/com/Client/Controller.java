package com.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller{

    Socket socket;
    View view;
    String name;
    DataOutputStream out;

    public Controller(Socket socket, View view, String name) throws IOException {
        this.socket = socket;
        this.view = view;
        this.name = name;
        out = new DataOutputStream(socket.getOutputStream());
        if(out != null) // 서버에 이름 전송
            out.writeUTF(name);

        // Receiver 스레드 실행
        Receiver receiver = new Receiver(view, socket);
        receiver.start();

        // Sender 이벤트 처리
        view.getSendBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = view.getContentInputText().getText(); // 채팅 내용
                view.getContentInputText().setText(""); // 채팅 입력 초기화

                if(content == "")
                    return;
                try {
                    out.writeUTF("["+name+"] : " + content);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
