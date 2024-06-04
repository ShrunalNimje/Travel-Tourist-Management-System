package my.mood;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{

    JButton back, fetch, check;
    JTextField nameTF, usernameTF, passwordTF, answerTF, questionTF;

    public ForgetPassword(){

        setLayout(null);
        setBounds(150,150,1200,600);

        JPanel one = new JPanel();
        one.setBounds(0, 30, 550, 600);
        one.setLayout(null);
        one.setBackground(Color.yellow);
        add(one);

        JPanel two = new JPanel();
        two.setBounds(550, 0, 650, 600);
        two.setLayout(null);
        add(two);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/lock11.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(80, 70, 400, 400);
        one.add(image);


        JLabel text = new JLabel("TROUBLE IN PASSWORD . . . ");
        text.setFont(new Font("Raleway", Font.BOLD, 24));
        text.setBounds(150, 50, 400, 25);
        two.add(text);

        JLabel usernameL = new JLabel("Username :");
        usernameL.setFont(new Font("Raleway", Font.BOLD, 16));
        usernameL.setBounds(50, 130, 150, 25);
        two.add(usernameL);

        usernameTF = new JTextField();
        usernameTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        usernameTF.setBounds(220, 130, 200, 25);
        usernameTF.setBorder(new LineBorder(Color.yellow));
        two.add(usernameTF);

        fetch = new JButton("FETCH");
        fetch.setBackground(Color.white);
        fetch.setForeground(Color.black);
        fetch.setFont(new Font("Raleway", Font.BOLD, 18));
        fetch.setBounds(450, 130, 120, 25);
        fetch.setBorder(new LineBorder(Color.yellow));
        fetch.addActionListener(this);
        two.add(fetch);

        JLabel nameL = new JLabel("Name :");
        nameL.setFont(new Font("Raleway", Font.BOLD, 16));
        nameL.setBounds(50, 180, 150, 25);
        two.add(nameL);

        nameTF = new JTextField();
        nameTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        nameTF.setBounds(220, 180, 200, 25);
        nameTF.setBorder(new LineBorder(Color.yellow));
        two.add(nameTF);

        JLabel questionL = new JLabel("Security Question :");
        questionL.setFont(new Font("Raleway", Font.BOLD, 16));
        questionL.setBounds(50, 230, 150, 25);
        two.add(questionL);

        questionTF = new JTextField();
        questionTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        questionTF.setBounds(220, 230, 200, 25);
        questionTF.setBorder(new LineBorder(Color.yellow));
        two.add(questionTF);

        JLabel answerL = new JLabel("Answer :");
        answerL.setFont(new Font("Raleway", Font.BOLD, 16));
        answerL.setBounds(50, 280, 150, 25);
        two.add(answerL);

        answerTF = new JTextField();
        answerTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        answerTF.setBounds(220, 280, 200, 25);
        answerTF.setBorder(new LineBorder(Color.yellow));
        two.add(answerTF);

        check = new JButton("CHECK");
        check.setBackground(Color.white);
        check.setForeground(Color.black);
        check.setFont(new Font("Raleway", Font.BOLD, 18));
        check.setBounds(450, 280, 120, 25);
        check.setBorder(new LineBorder(Color.yellow));
        check.addActionListener(this);
        two.add(check);

        JLabel passwordL = new JLabel("Password :");
        passwordL.setFont(new Font("Raleway", Font.BOLD, 16));
        passwordL.setBounds(50, 330, 150, 25);
        two.add(passwordL);

        passwordTF = new JTextField();
        passwordTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        passwordTF.setBounds(220, 330, 200, 25);
        passwordTF.setBorder(new LineBorder(Color.yellow));
        two.add(passwordTF);


        back = new JButton("BACK");
        back.setBackground(Color.yellow);
        back.setForeground(Color.black);
        back.setFont(new Font("Raleway", Font.BOLD, 18));
        back.setBounds(450, 330, 120, 25);
        back.setBorder(new LineBorder(Color.yellow));
        back.addActionListener(this);
        two.add(back);


        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){

        String nameS = nameTF.getText();
        String usernameS = usernameTF.getText();
        String passwordS = passwordTF.getText();
        String answerS = answerTF.getText();
        String questionS = questionTF.getText();

        if(ae.getSource() == fetch){
            if(usernameS.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your username");
            }
            else{
                try{
                    DBConnection DBc = new DBConnection();
                    String query1 = "select * from signup where username = '"+usernameS+"'";
                    ResultSet rs = DBc.s.executeQuery(query1);
                    if(rs.next()){
                        nameTF.setText(rs.getString("name"));
                        questionTF.setText(rs.getString("question"));
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect username!");
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == check){
            if(usernameS.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your username");
            }
            else if(answerS.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your answer");
            }
            else{
                try{
                    DBConnection DBc = new DBConnection();
                    String query1 = "select * from signup where answer = '"+answerS+"' and username = '"+usernameS+"'";
                    ResultSet rs = DBc.s.executeQuery(query1);
                    if(rs.next()){
                        passwordTF.setText(rs.getString("password"));

                        JOptionPane.showMessageDialog(null, "Please note down your password");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect answer!");
                    }

                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String [] args){

        new ForgetPassword();

    }
}
