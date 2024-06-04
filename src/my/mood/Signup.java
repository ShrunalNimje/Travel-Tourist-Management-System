package my.mood;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{

    JButton next, back;
    JTextField nameTF, usernameTF, passwordTF, answerTF;
    JComboBox questionCB;

    public Signup(){
        setLayout(null);
        setBounds(150,150,1200,600);

        JPanel one = new JPanel();
        one.setBounds(0, 30, 550, 600);
        one.setBackground(Color.CYAN);
        one.setLayout(null);
        add(one);

        JPanel two = new JPanel();
        two.setBounds(550, 50, 650, 600);
        two.setLayout(null);
        add(two);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(80, 70, 400, 400);
        one.add(image);


        JLabel text = new JLabel("CREATE YOUR ACCOUNT HERE!");
        text.setFont(new Font("Raleway", Font.BOLD, 24));
        text.setBounds(100, 50, 400, 25);
        two.add(text);

        JLabel nameL = new JLabel("Name :");
        nameL.setFont(new Font("Raleway", Font.BOLD, 16));
        nameL.setBounds(50, 130, 150, 25);
        two.add(nameL);

        nameTF = new JTextField();
        nameTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        nameTF.setBounds(220, 130, 300, 25);
        nameTF.setBorder(new LineBorder(Color.CYAN));
        two.add(nameTF);

        JLabel usernameL = new JLabel("Username :");
        usernameL.setFont(new Font("Raleway", Font.BOLD, 16));
        usernameL.setBounds(50, 180, 150, 25);
        two.add(usernameL);

        usernameTF = new JTextField();
        usernameTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        usernameTF.setBounds(220, 180, 300, 25);
        usernameTF.setBorder(new LineBorder(Color.CYAN));
        two.add(usernameTF);

        JLabel passwordL = new JLabel("Password :");
        passwordL.setFont(new Font("Raleway", Font.BOLD, 16));
        passwordL.setBounds(50, 230, 150, 25);
        two.add(passwordL);

        passwordTF = new JTextField();
        passwordTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        passwordTF.setBounds(220, 230, 300, 25);
        passwordTF.setBorder(new LineBorder(Color.CYAN));
        two.add(passwordTF);

        JLabel questionL = new JLabel("Security question :");
        questionL.setFont(new Font("Raleway", Font.BOLD, 16));
        questionL.setBounds(50, 280, 150, 25);
        two.add(questionL);

        String [] arr = {"Favourite game ?", "Your mother name ?", "Favourite player ?", "Your nickname ?"};
        questionCB = new JComboBox(arr);
        questionCB.setFont(new Font("Raleway", Font.PLAIN, 16));
        questionCB.setBounds(220, 280, 300, 25);
        questionCB.setBorder(new LineBorder(Color.cyan));
        two.add(questionCB);

        JLabel answerL = new JLabel("Answer :");
        answerL.setFont(new Font("Raleway", Font.BOLD, 16));
        answerL.setBounds(50, 330, 150, 25);
        two.add(answerL);

        answerTF = new JTextField();
        answerTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        answerTF.setBounds(220, 330, 300, 25);
        answerTF.setBorder(new LineBorder(Color.CYAN));
        two.add(answerTF);

        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFont(new Font("Raleway", Font.BOLD, 18));
        back.setBounds(220, 380, 120, 30);
        back.setBorder(new LineBorder(Color.cyan));
        back.addActionListener(this);
        two.add(back);

        next = new JButton("NEXT");
        next.setBackground(Color.cyan);
        next.setForeground(Color.black);
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.setBounds(400, 380, 120, 30);
        next.setBorder(new LineBorder(Color.cyan));
        next.addActionListener(this);
        two.add(next);


        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){

        String nameS = nameTF.getText();
        String usernameS = usernameTF.getText();
        String passwordS = passwordTF.getText();
        String answerS = answerTF.getText();
        String questionS = (String) questionCB.getSelectedItem();

        if(ae.getSource() == back){
            setVisible(false);
            new Login().setVisible(true);
        }
        else if(ae.getSource() == next){
            if(nameS.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a name");
            }
            else if(usernameS.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a username");
            }
            else if(passwordS.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a password");
            }
            else if(answerS.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a valid answer");
            }
            else{
                try{
                    DBConnection DBc = new DBConnection();
                    String query = "insert into signup values('"+nameS+"', '"+usernameS+"', '"+passwordS+"', '"+questionS+"', '"+answerS+"')";
                    DBc.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Account created successfully");

                    setVisible(false);
                    new Login().setVisible(true);

                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    public static void main(String [] args){

        new Signup();

    }
}
