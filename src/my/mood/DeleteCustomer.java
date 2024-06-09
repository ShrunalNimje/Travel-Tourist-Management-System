package my.mood;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteCustomer extends JFrame implements ActionListener{

    JButton back, delete;
    String username;
    JLabel usernameL1, idL1,
            idNumL1, nameL1,
            phoneL1, emailL1,
            countryL1, genderL1, addressL1;

    public DeleteCustomer(String username){

        this.username = username;

        setSize(1200, 600);
        setLocation(150, 150);
        getContentPane().setBackground(Color.orange);
        setLayout(null);

        JLabel text = new JLabel("Delete your Account here!");
        text.setBounds(150, 10, 500, 25);
        text.setFont(new Font("Arial", Font.BOLD, 24));
        text.setForeground(Color.gray);
        add(text);

        JLabel usernameL = new JLabel("Username :");
        usernameL.setBounds(100, 50, 150, 20);
        usernameL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(usernameL);

        usernameL1 = new JLabel();
        usernameL1.setBounds(280, 50, 250, 20);
        usernameL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        usernameL1.setBackground(Color.white);
        add(usernameL1);

        JLabel idL = new JLabel("Id :");
        idL.setBounds(100, 100, 150, 20);
        idL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(idL);

        idL1 = new JLabel();
        idL1.setBounds(280, 100, 250, 20);
        idL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        idL1.setBackground(Color.white);
        add(idL1);

        JLabel idNumL = new JLabel("Id Number :");
        idNumL.setBounds(100, 150, 150, 20);
        idNumL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(idNumL);

        idNumL1 = new JLabel();
        idNumL1.setBounds(280, 150, 250, 20);
        idNumL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(idNumL1);

        JLabel nameL = new JLabel("Name :");
        nameL.setBounds(100, 200, 150, 20);
        nameL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(nameL);

        nameL1 = new JLabel();
        nameL1.setBounds(280, 200, 250, 20);
        nameL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        nameL1.setBackground(Color.white);
        add(nameL1);

        JLabel phoneL = new JLabel("Phone Number :");
        phoneL.setBounds(100, 250, 150, 20);
        phoneL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(phoneL);

        phoneL1 = new JLabel();
        phoneL1.setBounds(280, 250, 250, 20);
        phoneL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(phoneL1);

        JLabel emailL = new JLabel("Email Id :");
        emailL.setBounds(100, 300, 150, 20);
        emailL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(emailL);

        emailL1 = new JLabel();
        emailL1.setBounds(280, 300, 250, 20);
        emailL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(emailL1);

        JLabel countryL = new JLabel("Country :");
        countryL.setBounds(100, 350, 150, 20);
        countryL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(countryL);

        countryL1 = new JLabel();
        countryL1.setBounds(280, 350, 250, 20);
        countryL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(countryL1);

        JLabel genderL = new JLabel("Gender :");
        genderL.setBounds(100, 400, 150, 20);
        genderL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(genderL);

        genderL1 = new JLabel();
        genderL1.setBounds(280, 400, 250, 20);
        genderL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        genderL1.setBackground(Color.white);
        add(genderL1);

        JLabel addressL = new JLabel("Address :");
        addressL.setBounds(100, 450, 150, 20);
        addressL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(addressL);

        addressL1 = new JLabel();
        addressL1.setBounds(280, 450, 250, 20);
        addressL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(addressL1);

        delete = new JButton("DELETE ACCOUNT");
        delete.setBounds(430, 500, 150, 25);
        delete.setFont(new Font("Raleway", Font.BOLD, 16));
        delete.setBackground(Color.gray);
        delete.setForeground(Color.white);
        delete.setBorder(new LineBorder(Color.black));
        delete.addActionListener(this);
        add(delete);

        back = new JButton("BACK");
        back.setBounds(230, 500, 100, 25);
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.setBorder(new LineBorder(Color.black));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/deleteAccount-removebg-preview.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(600, 0, 600, 500);
        add(image);

        try{
            DBConnection DBc = new DBConnection();
            String query = "select * from Customer where username = '"+username+"'";
            ResultSet rs = DBc.s.executeQuery(query);

            while(rs.next()){
                usernameL1.setText(rs.getString("username"));
                idL1.setText(rs.getString("id"));
                idNumL1.setText(rs.getString("id_number"));
                nameL1.setText(rs.getString("name"));
                phoneL1.setText(rs.getString("phone"));
                emailL1.setText(rs.getString("email"));
                countryL1.setText(rs.getString("country"));
                genderL1.setText(rs.getString("gender"));
                addressL1.setText(rs.getString("address"));
            }
        }
        catch(SQLException e){
            System.out.print(e);
        }

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
        }
        else if (ae.getSource() == delete){
            try {
                DBConnection DBc = new DBConnection();
                String query = "delete from signup where username = '"+username+"'";
                String query1 = "delete from Customer where username = '"+username+"'";
                String query2 = "delete from Package where username = '"+username+"'";
                // String query3 = "delete from Hotel where username = '"+username+"'";

                DBc.s.executeUpdate(query);
                DBc.s.executeUpdate(query1);
                DBc.s.executeUpdate(query2);
                // DBc.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Account deleted successfully!");

                new Login().setVisible(true);

            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String [] args){

        new DeleteCustomer("").setVisible(true);

    }
}
