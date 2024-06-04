package my.mood;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton signup, login, password;
    JTextField usernameTF;
    JPasswordField passwordPF;

    public Login(){

        setLayout(null);
        setBounds(150,150,1200,600);

        JPanel one = new JPanel();
        one.setBounds(0,0,650, 600);
        one.setLayout(null);
        add(one);

        JPanel two = new JPanel();
        two.setBounds(650,30,550, 550);
        two.setBackground(Color.gray);
        two.setLayout(null);
        add(two);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(60, 60, 400, 400);
        two.add(image);

        JLabel text = new JLabel("TRAVEL AROUND THE WORLD");
        text.setFont(new Font("Arial", Font.BOLD, 24));
        text.setBounds(150, 60, 400, 25);
        one.add(text);

        JLabel usernameL = new JLabel("Username ");
        usernameL.setFont(new Font("Raleway", Font.BOLD, 16));
        usernameL.setBounds(170, 120, 100, 25);
        one.add(usernameL);

        usernameTF = new JTextField();
        usernameTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        usernameTF.setBounds(170, 160, 300, 25);
        usernameTF.setBorder(new LineBorder(Color.gray));
        one.add(usernameTF);

        JLabel passwordL = new JLabel("Password ");
        passwordL.setFont(new Font("Raleway", Font.BOLD, 16));
        passwordL.setBounds(170, 200, 100, 25);
        one.add(passwordL);

        passwordPF = new JPasswordField();
        passwordPF.setFont(new Font("Raleway", Font.PLAIN, 16));
        passwordPF.setBounds(170, 240, 300, 25);
        passwordPF.setBorder(new LineBorder(Color.gray));
        one.add(passwordPF);

        signup = new JButton("SIGN UP");
        signup.setBackground(Color.white);
        signup.setForeground(Color.black);
        signup.setFont(new Font("Raleway", Font.BOLD, 18));
        signup.setBounds(170, 310, 120, 30);
        signup.setBorder(new LineBorder(Color.gray));
        signup.addActionListener(this);
        one.add(signup);

        login = new JButton("LOGIN");
        login.setBackground(Color.gray);
        login.setForeground(Color.black);
        login.setFont(new Font("Raleway", Font.BOLD, 18));
        login.setBounds(350, 310, 120, 30);
        login.setBorder(new LineBorder(Color.gray));
        login.addActionListener(this);
        one.add(login);

        password = new JButton("FORGOT PASSWORD ?");
        password.setBackground(Color.white);
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Raleway", Font.BOLD, 14));
        password.setBounds(220, 370, 200, 30);
        password.setBorder(new LineBorder(Color.gray));
        password.addActionListener(this);
        one.add(password);


        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae){

        String usernameS = usernameTF.getText();
        String passwordS = passwordPF.getText();

        if(ae.getSource() == signup){
            setVisible(false);
            new Signup().setVisible(true);
        }
        else if(ae.getSource() == login){
            if(usernameS.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a username");
            }
            else if(passwordS.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a password");
            }
            else{
                try{
                    DBConnection DBc = new DBConnection();
                    String query = "select * from signup where username = '"+usernameS+"' and password = '"+passwordS+"'";
                    ResultSet rs = DBc.s.executeQuery(query);

                    if(rs.next()){
                        setVisible(false);
                        new Loading(usernameS).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect username or password");
                    }
                }
                catch(HeadlessException | SQLException e){
                    System.out.print(e);
                }
            }
        }
        if(ae.getSource() == password){
            setVisible(false);
            new ForgetPassword().setVisible(true);
        }

    }
    public static void main(String [] args){

        new Login();

    }
}
