package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    String username;
    JLabel usernameL1, nameL1, phoneL1, countryL1, emailL1, costL1;
    JButton back, price, book;
    JComboBox selectCB;
    JTextField coupleTF;

    public BookPackage(String username){

        this.username = username;

        setLayout(null);
        setBounds( 150, 150, 1200, 600);
        getContentPane().setBackground(Color.orange);

        JLabel text = new JLabel("Book your Package here");
        text.setBounds(150, 20, 400, 30);
        text.setFont(new Font("Arial", Font.BOLD, 24));
        text.setForeground(Color.gray);
        add(text);

        JLabel usernameL = new JLabel("Username :");
        usernameL.setBounds(80, 100, 150, 20);
        usernameL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(usernameL);

        usernameL1 = new JLabel();
        usernameL1.setBounds(250, 100, 200, 20);
        usernameL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(usernameL1);

        JLabel selectL = new JLabel("Select Package :");
        selectL.setBounds(80, 140, 150, 20);
        selectL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(selectL);

        String [] arr = {"Kerala Package", "Himachal Package", "Goa Package"};
        selectCB = new JComboBox(arr);
        selectCB.setBounds(250, 140, 200, 20);
        selectCB.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(selectCB);

        JLabel coupleL = new JLabel("No. of Couples :");
        coupleL.setBounds(80, 180, 150, 20);
        coupleL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(coupleL);

        coupleTF = new JTextField("1");
        coupleTF.setBounds(250, 180, 200, 20);
        coupleTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(coupleTF);

        JLabel nameL = new JLabel("Name :");
        nameL.setBounds(80, 220, 150, 20);
        nameL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(nameL);

        nameL1 = new JLabel();
        nameL1.setBounds(250, 220, 200, 20);
        nameL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(nameL1);

        JLabel phoneL = new JLabel("Phone Number :");
        phoneL.setBounds(80, 260, 150, 20);
        phoneL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(phoneL);

        phoneL1 = new JLabel();
        phoneL1.setBounds(250, 260, 200, 20);
        phoneL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(phoneL1);

        JLabel emailL = new JLabel("Email id :");
        emailL.setBounds(80, 300, 150, 20);
        emailL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(emailL);

        emailL1 = new JLabel();
        emailL1.setBounds(250, 300, 200, 20);
        emailL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(emailL1);

        JLabel countryL = new JLabel("Country :");
        countryL.setBounds(80, 340, 150, 20);
        countryL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(countryL);

        countryL1 = new JLabel();
        countryL1.setBounds(250, 340, 200, 20);
        countryL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(countryL1);

        JLabel costL = new JLabel("Total Cost :");
        costL.setBounds(80, 380, 150, 20);
        costL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(costL);

        costL1 = new JLabel();
        costL1.setBounds(250, 380, 200, 20);
        costL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(costL1);

        back = new JButton("BACK");
        back.setBounds(100, 430, 120, 25);
        back.setFont(new Font("Raleway", Font.BOLD, 18));
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        price = new JButton("Cost");
        price.setBounds(300, 430, 120, 25);
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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookPackage-removebg-preview.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(650, 50, 500, 450);
        add(image);

        try {
            DBConnection DBc = new DBConnection();
            String query = "select * from Customer where username = '"+username+"'";

            ResultSet rs = DBc.s.executeQuery(query);
            while (rs.next()){
                usernameL1.setText(rs.getString("username"));
                nameL1.setText(rs.getString("name"));
                phoneL1.setText(rs.getString("phone"));
                emailL1.setText(rs.getString("email"));
                countryL1.setText(rs.getString("country"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        String usernameS = usernameL1.getText();
        String packageS = (String) selectCB.getSelectedItem();
        String coupleS = coupleTF.getText();
        String nameS = nameL1.getText();
        String phoneS = phoneL1.getText();
        String emailS = emailL1.getText();
        String countryS = countryL1.getText();
        String costS = costL1.getText();
        int cost = 0;

        if (ae.getSource() == back){
            setVisible(false);
        }
        else if (ae.getSource() == price){

            if (packageS.equals("Kerala Package")){
                cost = cost + 21000;
            }
            else if (packageS.equals("Himachal Package")){
                cost = cost + 25000;
            }
            else if (packageS.equals("Goa Package")){
                cost = cost + 28000;
            }

            cost = cost * Integer.parseInt(coupleS);
            costL1.setText("" + cost);

        }
        else if (ae.getSource() == book){
            try {
                DBConnection DBc = new DBConnection();
                String query = "insert into Package values ('"+usernameS+"', '"+packageS+"', '"+coupleS+"', '"+nameS+"', '"+phoneS+"', '"+emailS+"', '"+countryS+"', '"+costS+"')";
                DBc.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Package booked successfully!");
                setVisible(false);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {

        new BookPackage("");

    }
}
