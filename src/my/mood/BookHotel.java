package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {

    JLabel usernameL1, nameL1, phoneL1, emailL1, countryL1, costL1;
    JButton back, price, book;
    String username;
    Choice selectC, acC, foodC;
    JTextField personTF, dayTF;

    public BookHotel(String username){

        this.username = username;

        setLayout(null);
        setBounds( 150, 150, 1200, 600);
        getContentPane().setBackground(Color.orange);

        JLabel text = new JLabel("Book your Hotel here");
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

        selectC = new Choice();
        selectC.setBounds(250, 120, 200, 20);
        selectC.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(selectC);

        try {
            DBConnection c = new DBConnection();
            String query = " select * from hotel";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                selectC.add(rs.getString("hotelName"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        JLabel personL = new JLabel("No. of Persons :");
        personL.setBounds(80, 160, 150, 20);
        personL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(personL);

        personTF = new JTextField("1");
        personTF.setBounds(250, 160, 200, 20);
        personTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(personTF);

        JLabel dayL = new JLabel("No. of Days :");
        dayL.setBounds(80, 200, 150, 20);
        dayL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(dayL);

        dayTF = new JTextField("1");
        dayTF.setBounds(250, 200, 200, 20);
        dayTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(dayTF);

        JLabel acL = new JLabel("AC / Non-AC :");
        acL.setBounds(80, 240, 150, 20);
        acL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(acL);

        acC = new Choice();
        acC.setBounds(250, 240, 200, 20);
        acC.setFont(new Font("Raleway", Font.PLAIN, 16));
        acC.add("Ac");
        acC.add("Non-Ac");
        add(acC);

        JLabel foodL = new JLabel("Food Included :");
        foodL.setBounds(80, 280, 150, 20);
        foodL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(foodL);

        foodC = new Choice();
        foodC.setBounds(250, 280, 200, 20);
        foodC.setFont(new Font("Raleway", Font.PLAIN, 16));
        foodC.add("Yes");
        foodC.add("No");
        add(foodC);

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

        try {
            DBConnection DBc = new DBConnection();
            String query = "select * from Customer where username = '"+username+"'";
            ResultSet resultSet = DBc.s.executeQuery(query);

            while (resultSet.next()){
                usernameL1.setText(resultSet.getString("username"));
                nameL1.setText(resultSet.getString("name"));
                phoneL1.setText(resultSet.getString("phone"));
                emailL1.setText(resultSet.getString("email"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        JLabel costL = new JLabel("Total Cost :");
        costL.setBounds(80, 440, 150, 20);
        costL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(costL);

        costL1 = new JLabel();
        costL1.setBounds(250, 440, 200, 20);
        costL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(costL1);

        back = new JButton("BACK");
        back.setBounds(100, 500, 120, 25);
        back.setFont(new Font("Raleway", Font.BOLD, 18));
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        price = new JButton("Cost");
        price.setBounds(300, 500, 120, 25);
        price.setFont(new Font("Raleway", Font.BOLD, 18));
        price.setBackground(Color.gray);
        price.setForeground(Color.white);
        price.addActionListener(this);
        add(price);

        book = new JButton("BOOK");
        book.setBounds(950, 500, 120, 25);
        book.setFont(new Font("Raleway", Font.BOLD, 18));
        book.setBackground(Color.gray);
        book.setForeground(Color.white);
        book.addActionListener(this);
        add(book);

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

        String usernameS = usernameL1.getText();
        String hotelS = selectC.getSelectedItem();
        String personS = personTF.getText();
        String dayS = dayTF.getText();
        String acS = acC.getSelectedItem();
        String foodS = foodC.getSelectedItem();
        String nameS = nameL1.getText();
        String phoneS = phoneL1.getText();
        String emailS = emailL1.getText();

        if (ae.getSource() == back){
            setVisible(false);
        }
        else if (ae.getSource() == price){
            int cost = 0;

            try {
                DBConnection DBc = new DBConnection();
                String query = "select * from hotel where hotelName = '"+hotelS+"'";
                ResultSet rs = DBc.s.executeQuery(query);

                while (rs.next()){
                    cost = cost + Integer.parseInt(rs.getString("price"));
                    cost = cost * Integer.parseInt(personS);
                    cost = cost * Integer.parseInt(dayS);
                    if (acS == "Ac"){
                        cost = cost + Integer.parseInt(rs.getString("ac"));
                    }
                    if (foodS == "Yes"){
                        cost = cost + Integer.parseInt(rs.getString("food"));
                    }
                }

                costL1.setText("Rs. " + cost);

            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == book){
            String costS = costL1.getText();

            try {
                DBConnection DBc = new DBConnection();
                String query = "insert into HotelPackage values ('"+usernameS+"', '"+hotelS+"', '"+personS+"', '"+dayS+"', '"+acS+"', '"+foodS+"', '"+nameS+"', '"+phoneS+"', '"+emailS+"', '"+costS+"') ";
                DBc.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Hotel Booked successfully!");

                setVisible(false);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {

        new BookHotel("");
    }
}
