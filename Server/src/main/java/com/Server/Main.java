package com.Server;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        // View 출력
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
        // 서버의 공인 IP 받아와서 뷰에 출력
        try { view.getMyIPText().setText(Controller.getIp()); } catch (Exception e) { e.printStackTrace(); }

        // 서버 시작버튼 이벤트
        view.getStartServerBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 포트 번호 받아오기
                String port = view.getPortInputText().getText();
                if(port == null) // 유효한 포트인지 확인
                    return;
                // 화면 전환
                view.getAdminLoginPanel().setVisible(false);
                view.getAdminPanel().setVisible(true);
                // Controller 실행
                Controller controller = new Controller(view, Integer.parseInt(port));
                controller.start();
            }
        });

    }
}

