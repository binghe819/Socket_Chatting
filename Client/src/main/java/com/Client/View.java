package com.Client;

import javax.swing.*;
import java.awt.*;

public class View {

    private JFrame frame;
    private JTextField ipInputText;
    private JTextField portInputText;
    private JTextField nameInputText;
    private JTextField contentInputText;
    private JPanel chattingPanel;
    private JPanel loginPanel;
    private JButton loginBtn;
    private JButton sendBtn;
    private JTextArea contentText;


    /**
     * Create the application.
     */
    public View() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 480, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        JPanel logoPanel = new JPanel();
        logoPanel.setBounds(30, 6, 420, 46);
        frame.getContentPane().add(logoPanel);
        logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel = new JLabel("==== 채팅 클라이언트 ====");
        lblNewLabel.setBackground(Color.WHITE);
        lblNewLabel.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 22));
        logoPanel.add(lblNewLabel);

        /* 로그인 패널 */
        loginPanel = new JPanel();
        loginPanel.setBounds(30, 64, 420, 520);
        frame.getContentPane().add(loginPanel);
        loginPanel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("IP");
        lblNewLabel_1.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 22));
        lblNewLabel_1.setBounds(24, 39, 61, 40);
        loginPanel.add(lblNewLabel_1);

        ipInputText = new JTextField();
        ipInputText.setBounds(92, 34, 274, 45);
        loginPanel.add(ipInputText);
        ipInputText.setColumns(10);

        portInputText = new JTextField();
        portInputText.setColumns(10);
        portInputText.setBounds(92, 147, 274, 45);
        loginPanel.add(portInputText);

        JLabel lblNewLabel_1_1 = new JLabel("PORT");
        lblNewLabel_1_1.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 22));
        lblNewLabel_1_1.setBounds(24, 152, 96, 40);
        loginPanel.add(lblNewLabel_1_1);

        nameInputText = new JTextField();
        nameInputText.setColumns(10);
        nameInputText.setBounds(92, 266, 274, 45);
        loginPanel.add(nameInputText);

        JLabel lblNewLabel_1_1_1 = new JLabel("NAME");
        lblNewLabel_1_1_1.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 22));
        lblNewLabel_1_1_1.setBounds(24, 271, 96, 40);
        loginPanel.add(lblNewLabel_1_1_1);

        loginBtn = new JButton("접속 하기");
        loginBtn.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 25));
        loginBtn.setBackground(UIManager.getColor("Button.highlight"));
        loginBtn.setBounds(24, 365, 342, 45);
        loginPanel.add(loginBtn);
        /* 로그인 패널 끝 */

        /* 채팅 패널 */
        chattingPanel = new JPanel();
        chattingPanel.setBounds(30, 64, 420, 520);
        frame.getContentPane().add(chattingPanel);
        chattingPanel.setLayout(null);

        contentText = new JTextArea();
        contentText.setEditable(false);
        contentText.setBounds(20, 5, 379, 458);
        chattingPanel.add(contentText);

        contentInputText = new JTextField();
        contentInputText.setBounds(20, 475, 289, 39);
        chattingPanel.add(contentInputText);
        contentInputText.setColumns(10);

        sendBtn = new JButton("전송");
        sendBtn.setBounds(318, 481, 81, 29);
        chattingPanel.add(sendBtn);
        chattingPanel.setVisible(false);
        /* 채팅 패널 끝 */
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getIpInputText() {
        return ipInputText;
    }

    public JTextField getPortInputText() {
        return portInputText;
    }

    public JTextField getNameInputText() {
        return nameInputText;
    }

    public JTextField getContentInputText() {
        return contentInputText;
    }

    public JPanel getChattingPanel() {
        return chattingPanel;
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }

    public JButton getSendBtn() {
        return sendBtn;
    }

    public JTextArea getContentText() {
        return contentText;
    }
}
