package com.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {

    private JFrame frame;
    private JTextField myIPText;
    private JTextField portInputText;
    private JPanel adminLoginPanel;
    private JPanel adminPanel;
    private JButton startServerBtn;
    private JTextArea logText;

    public View() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 480, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        /* 로그인 패널 */
        adminLoginPanel = new JPanel();
        adminLoginPanel.setLayout(null);
        adminLoginPanel.setBounds(34, 72, 420, 520);
        frame.getContentPane().add(adminLoginPanel);

        JLabel MYIP = new JLabel("MY IP");
        MYIP.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 22));
        MYIP.setBounds(24, 143, 61, 40);
        adminLoginPanel.add(MYIP);

        myIPText = new JTextField();
        myIPText.setEditable(false);
        myIPText.setColumns(10);
        myIPText.setBounds(92, 138, 274, 45);
        adminLoginPanel.add(myIPText);

        portInputText = new JTextField();
        portInputText.setColumns(10);
        portInputText.setBounds(92, 242, 274, 45);
        adminLoginPanel.add(portInputText);

        JLabel lblNewLabel_1_1 = new JLabel("PORT");
        lblNewLabel_1_1.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 22));
        lblNewLabel_1_1.setBounds(24, 247, 96, 40);
        adminLoginPanel.add(lblNewLabel_1_1);

        startServerBtn = new JButton("서버 시작");
        startServerBtn.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 25));
        startServerBtn.setBackground(Color.WHITE);
        startServerBtn.setBounds(24, 365, 342, 45);
        adminLoginPanel.add(startServerBtn);

        /* 로그인 패널 끝 */

        /* 어드민 페이지 */
        adminPanel = new JPanel();
        adminPanel.setLayout(null);
        adminPanel.setBounds(34, 72, 420, 520);
        frame.getContentPane().add(adminPanel);

        logText = new JTextArea();
        logText.setEditable(false);
        logText.setBounds(20, 5, 379, 403);
        adminPanel.add(logText);

        JButton serverExitBtn = new JButton("서버 종료");
        serverExitBtn.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 30));
        serverExitBtn.setBounds(20, 420, 379, 82);
        adminPanel.add(serverExitBtn);
        serverExitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel logoPanel = new JPanel();
        logoPanel.setBounds(34, 6, 420, 46);
        frame.getContentPane().add(logoPanel);
        logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel = new JLabel("==== 채팅 서버 ====");
        lblNewLabel.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 22));
        lblNewLabel.setBackground(Color.WHITE);
        logoPanel.add(lblNewLabel);

        /* 어드민 페이지 끝 */
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getMyIPText() {
        return myIPText;
    }

    public JTextField getPortInputText() {
        return portInputText;
    }

    public JPanel getAdminLoginPanel() {
        return adminLoginPanel;
    }

    public JPanel getAdminPanel() {
        return adminPanel;
    }

    public JButton getStartServerBtn() {
        return startServerBtn;
    }

    public JTextArea getLogText() {
        return logText;
    }
}
