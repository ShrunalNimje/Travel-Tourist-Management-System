package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPayment extends JFrame implements ActionListener {

    String username;
    JButton back, pay;

    public MyPayment(String username){

        this.username = username;

        setBounds(150, 150, 1200, 600);
        setLayout(null);

        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);

        try {
            editorPane.setPage("https://paytm.com/paytmwallet");
        }
        catch (Exception e){
            editorPane.setContentType("text/html");
            editorPane.setText("<html>Could not load, Error - 404</html>");
        }

        // Create a JScrollPane and add the JEditorPane to it
        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setBounds(0, 0, 1180, 500);
        add(scrollPane);

        back = new JButton("Back");
        back.setBounds(900, 520, 120, 30);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        pay = new JButton("Pay");
        pay.setBounds(1050, 520, 120, 30);
        pay.setFont(new Font("Arial", Font.BOLD, 18));
        pay.setBackground(Color.gray);
        pay.setForeground(Color.white);
        pay.addActionListener(this);
        add(pay);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
        }
        else if (ae.getSource() == pay){
            JOptionPane.showMessageDialog(null, "It's not real \njust a demo to show");

            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new MyPayment("");
    }
}
