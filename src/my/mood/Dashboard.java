package my.mood;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.IOException;

public class Dashboard extends JFrame implements ActionListener{

    JButton addPersonalDetails, updatePersonalDetails,
            viewDeleteDetails, deleteAccount,
            viewPackage, bookPackage,
            viewBookPackage, viewHotel,
            bookHotel, viewBookHotel,
            destination, payment,
            calculator, notepad,
            about, logOut;
    String username;

    public Dashboard(String username){

        this.username = username;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 1550, 50);
        p1.setBackground(Color.gray);
        p1.setLayout(null);
        p1.setBorder(new LineBorder(Color.white));
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(10, 0, 50, 50);
        p1.add(image);

        JLabel text = new JLabel("Dashboard");
        text.setBounds(80, 15, 120, 20);
        text.setFont(new Font("Raleway", Font.PLAIN, 24));
        text.setForeground(Color.BLACK);
        p1.add(text);

        logOut = new JButton("LOG OUT");
        logOut.setFont(new Font("Raleway", Font.BOLD, 18));
        logOut.setBounds(1350, 10, 120, 30);
        logOut.setForeground(Color.black);
        logOut.setBackground(Color.gray);
        logOut.setBorder(new LineBorder(Color.black));
        logOut.addActionListener(this);
        p1.add(logOut);

        JPanel p2 = new JPanel();
        p2.setBounds(0, 50, 220, 1000);
        p2.setBackground(Color.gray);
        p2.setLayout(null);
        p2.setBorder(new LineBorder(Color.white));
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setFont(new Font("Raleway", Font.PLAIN, 18));
        addPersonalDetails.setBounds(0, 0, 220, 50);
        addPersonalDetails.setForeground(Color.black);
        addPersonalDetails.setBackground(Color.gray);
        addPersonalDetails.setBorder(new LineBorder(Color.white));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Details");
        updatePersonalDetails.setFont(new Font("Raleway", Font.PLAIN, 18));
        updatePersonalDetails.setBounds(0, 50, 220, 50);
        updatePersonalDetails.setForeground(Color.black);
        updatePersonalDetails.setBackground(Color.gray);
        updatePersonalDetails.setBorder(new LineBorder(Color.white));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewDeleteDetails = new JButton("View / Delete Details");
        viewDeleteDetails.setFont(new Font("Raleway", Font.PLAIN, 18));
        viewDeleteDetails.setBounds(0, 100, 220, 50);
        viewDeleteDetails.setForeground(Color.black);
        viewDeleteDetails.setBackground(Color.gray);
        viewDeleteDetails.setBorder(new LineBorder(Color.white));
        viewDeleteDetails.addActionListener(this);
        p2.add(viewDeleteDetails);

        deleteAccount = new JButton("Delete Account");
        deleteAccount.setFont(new Font("Raleway", Font.PLAIN, 18));
        deleteAccount.setBounds(0, 150, 220, 50);
        deleteAccount.setForeground(Color.black);
        deleteAccount.setBackground(Color.gray);
        deleteAccount.setBorder(new LineBorder(Color.white));
        deleteAccount.addActionListener(this);
        p2.add(deleteAccount);

        viewPackage = new JButton("Show packages");
        viewPackage.setFont(new Font("Raleway", Font.PLAIN, 18));
        viewPackage.setBounds(0, 200, 220, 50);
        viewPackage.setForeground(Color.black);
        viewPackage.setBackground(Color.gray);
        viewPackage.setBorder(new LineBorder(Color.white));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        bookPackage = new JButton("Book package");
        bookPackage.setFont(new Font("Raleway", Font.PLAIN, 18));
        bookPackage.setBounds(0, 250, 220, 50);
        bookPackage.setForeground(Color.black);
        bookPackage.setBackground(Color.gray);
        bookPackage.setBorder(new LineBorder(Color.white));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewBookPackage = new JButton("View / Delete package");
        viewBookPackage.setFont(new Font("Raleway", Font.PLAIN, 18));
        viewBookPackage.setBounds(0, 300, 220, 50);
        viewBookPackage.setForeground(Color.black);
        viewBookPackage.setBackground(Color.gray);
        viewBookPackage.setBorder(new LineBorder(Color.white));
        viewBookPackage.addActionListener(this);
        p2.add(viewBookPackage);

        viewHotel = new JButton("Show hotels");
        viewHotel.setFont(new Font("Raleway", Font.PLAIN, 18));
        viewHotel.setBounds(0, 350, 220, 50);
        viewHotel.setForeground(Color.black);
        viewHotel.setBackground(Color.gray);
        viewHotel.setBorder(new LineBorder(Color.white));
        viewHotel.addActionListener(this);
        p2.add(viewHotel);

        bookHotel = new JButton(" Book hotel");
        bookHotel.setFont(new Font("Raleway", Font.PLAIN, 18));
        bookHotel.setBounds(0, 400, 220, 50);
        bookHotel.setForeground(Color.black);
        bookHotel.setBackground(Color.gray);
        bookHotel.setBorder(new LineBorder(Color.white));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        viewBookHotel = new JButton("View / Delete hotel");
        viewBookHotel.setFont(new Font("Raleway", Font.PLAIN, 18));
        viewBookHotel.setBounds(0, 450, 220, 50);
        viewBookHotel.setForeground(Color.black);
        viewBookHotel.setBackground(Color.gray);
        viewBookHotel.setBorder(new LineBorder(Color.white));
        viewBookHotel.addActionListener(this);
        p2.add(viewBookHotel);

        destination = new JButton("Destination");
        destination.setFont(new Font("Raleway", Font.PLAIN, 18));
        destination.setBounds(0, 500, 220, 50);
        destination.setForeground(Color.black);
        destination.setBackground(Color.gray);
        destination.setBorder(new LineBorder(Color.white));
        destination.addActionListener(this);
        p2.add(destination);

        payment = new JButton("Payment");
        payment.setFont(new Font("Raleway", Font.PLAIN, 18));
        payment.setBounds(0, 550, 220, 50);
        payment.setForeground(Color.black);
        payment.setBackground(Color.gray);
        payment.setBorder(new LineBorder(Color.white));
        payment.addActionListener(this);
        p2.add(payment);

        calculator = new JButton("Calculator");
        calculator.setFont(new Font("Raleway", Font.PLAIN, 18));
        calculator.setBounds(0, 600, 220, 50);
        calculator.setForeground(Color.black);
        calculator.setBackground(Color.gray);
        calculator.setBorder(new LineBorder(Color.white));
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setFont(new Font("Raleway", Font.PLAIN, 18));
        notepad.setBounds(0, 650, 220, 50);
        notepad.setForeground(Color.black);
        notepad.setBackground(Color.gray);
        notepad.setBorder(new LineBorder(Color.white));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setFont(new Font("Raleway", Font.PLAIN, 18));
        about.setBounds(0, 700, 220, 50);
        about.setForeground(Color.black);
        about.setBackground(Color.gray);
        about.setBorder(new LineBorder(Color.white));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.jpg"));
        Image i22 = i11.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);

        JLabel image1 = new JLabel(i33);
        image1.setBounds(0, 0, 1600, 800);
        add(image1);

        JLabel text1 = new JLabel("Welcome to TravelSphere");
        text1.setBounds(550, 80, 800, 50);
        text1.setFont(new Font("Raleway", Font.BOLD, 55));
        text1.setForeground(Color.ORANGE);
        image1.add(text1);

        setVisible (true);

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == logOut){

            JOptionPane.showMessageDialog(null, "Account logged out successfully!");

            setVisible(false);
            new Login().setVisible(true);
        }
        else if(ae.getSource() == addPersonalDetails){
            new AddCustomer(username).setVisible(true);
        }
        else if(ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username).setVisible(true);
        }
        else if(ae.getSource() == viewDeleteDetails){
            new ViewCustomer(username).setVisible(true);
        }
        else if(ae.getSource() == viewPackage){
            new ViewPackage(username).setVisible(true);
        }
        else if(ae.getSource() == bookPackage){
            new BookPackage(username).setVisible(true);
        }
        else if(ae.getSource() == viewBookPackage){
            new ViewBookedPackage(username).setVisible(true);
        }
        else if(ae.getSource() == viewHotel){
            new ViewHotels(username).setVisible(true);
        }
        else if(ae.getSource() == destination){
            new Destination(username).setVisible(true);
        }
        else if(ae.getSource() == deleteAccount){
            new DeleteCustomer(username).setVisible(true);
        }
        else if(ae.getSource() == bookHotel){
            new BookHotel(username).setVisible(true);
        }
        else if(ae.getSource() == viewBookHotel){
            new ViewBookHotel(username).setVisible(true);
        }
        else if(ae.getSource() == calculator){
            try {
                Runtime.getRuntime().exec("calc.exe");
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else if(ae.getSource() == notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == payment){
            new Payment(username).setVisible(true);
        }
        else if (ae.getSource() == about){
            new About(username).setVisible(true);
        }
    }

    public static void main(String [] args){

        new Dashboard("");

    }
}
