package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewBookHotel extends JFrame implements ActionListener {

    JLabel usernameL1, nameL1, phoneL1, emailL1, costL1, selectL1, acL1, foodL1, personL1, dayL1;
    JButton back, cancel ;
    String username;

    public ViewBookHotel(String username){

        this.username = username;

        setLayout(null);
        setBounds( 150, 150, 1200, 600);
        getContentPane().setBackground(Color.orange);

        JLabel text = new JLabel("View or Delete Booked Hotel here");
        text.setBounds(150, 20, 400, 30);
        text.setFont(new Font("Arial", Font.BOLD, 24));
        text.setForeground(Color.gray);
        add(text);

        JLabel usernameL = new JLabel("Username :");
        usernameL.setBounds(80, 80, 150, 20);
        usernameL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(usernameL);

        usernameL1 = new JLabel();
        usernameL1.setBounds(250, 80, 200, 20);
        usernameL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(usernameL1);

        JLabel selectL = new JLabel("Select Hotel :");
        selectL.setBounds(80, 120, 150, 20);
        selectL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(selectL);

        selectL1 = new JLabel();
        selectL1.setBounds(250, 120, 200, 20);
        selectL1.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(selectL1);

        JLabel personL = new JLabel("No. of Persons :");
        personL.setBounds(80, 160, 150, 20);
        personL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(personL);

        personL1 = new JLabel();
        personL1.setBounds(250, 160, 200, 20);
        personL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(personL1);

        JLabel dayL = new JLabel("No. of Days :");
        dayL.setBounds(80, 200, 150, 20);
        dayL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(dayL);

        dayL1 = new JLabel();
        dayL1.setBounds(250, 200, 200, 20);
        dayL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(dayL1);

        JLabel acL = new JLabel("AC / Non-AC :");
        acL.setBounds(80, 240, 150, 20);
        acL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(acL);

        acL1 = new JLabel();
        acL1.setBounds(250, 240, 200, 20);
        acL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(acL1);

        JLabel foodL = new JLabel("Food Included :");
        foodL.setBounds(80, 280, 150, 20);
        foodL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(foodL);

        foodL1 = new JLabel();
        foodL1.setBounds(250, 280, 200, 20);
        foodL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(foodL1);

        JLabel nameL = new JLabel("Name :");
        nameL.setBounds(80, 320, 150, 20);
        nameL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(nameL);

        nameL1 = new JLabel();
        nameL1.setBounds(250, 320, 200, 20);
        nameL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(nameL1);

        JLabel phoneL = new JLabel("Phone Number :");
        phoneL.setBounds(80, 360, 150, 20);
        phoneL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(phoneL);

        phoneL1 = new JLabel();
        phoneL1.setBounds(250, 360, 200, 20);
        phoneL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(phoneL1);

        JLabel emailL = new JLabel("Email id :");
        emailL.setBounds(80, 400, 150, 20);
        emailL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(emailL);

        emailL1 = new JLabel();
        emailL1.setBounds(250, 400, 200, 20);
        emailL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(emailL1);

        JLabel costL = new JLabel("Total Cost :");
        costL.setBounds(80, 440, 150, 20);
        costL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(costL);

        costL1 = new JLabel();
        costL1.setBounds(250, 440, 200, 20);
        costL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(costL1);

        try {
            DBConnection DBc = new DBConnection();
            String query = "select * from HotelPackage where username = '"+username+"'";
            ResultSet resultSet = DBc.s.executeQuery(query);

            while (resultSet.next()){
                usernameL1.setText(resultSet.getString("username"));
                nameL1.setText(resultSet.getString("name"));
                phoneL1.setText(resultSet.getString("phone"));
                emailL1.setText(resultSet.getString("email"));
                selectL1.setText(resultSet.getString("hotelName"));
                personL1.setText(resultSet.getString("no_of_persons"));
                dayL1.setText(resultSet.getString("no_of_days"));
                acL1.setText(resultSet.getString("ac"));
                foodL1.setText(resultSet.getString("food"));
                costL1.setText(resultSet.getString("cost"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        back = new JButton("BACK");
        back.setBounds(200, 500, 120, 25);
        back.setFont(new Font("Raleway", Font.BOLD, 18));
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        cancel = new JButton("Cancel Hotel");
        cancel.setBounds(400, 500, 150, 25);
        cancel.setFont(new Font("Raleway", Font.BOLD, 18));
        cancel.setBackground(Color.gray);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookHotel-removebg-preview.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(600, 50, 500, 400);
        add(image);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == back){
            setVisible(false);
        }
        else if (ae.getSource() == cancel){

            try {
                DBConnection DBc = new DBConnection();
                String query = "delete from HotelPackage where username = '"+username+"'";
                DBc.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Your Hotel cancel successfully!");

                setVisible(false);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {

        new ViewBookHotel("");
    }
}
