package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener {

    String username;
    JButton back, pay;

    public Payment(String username){

        this.username = username;

        setBounds(150, 150, 1200, 600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/payment.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 600);
        add(image);

        back = new JButton("Back");
        back.setBounds(900, 500, 120, 30);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);

        pay = new JButton("Pay");
        pay.setBounds(1050, 500, 120, 30);
        pay.setFont(new Font("Arial", Font.BOLD, 18));
        pay.setBackground(Color.gray);
        pay.setForeground(Color.white);
        pay.addActionListener(this);
        image.add(pay);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
        }
        else if (ae.getSource() == pay){
            new MyPayment(username).setVisible(true);
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new Payment("");

    }
}
