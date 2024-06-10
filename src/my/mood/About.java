package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    String username;
    JButton exit;

    public About(String username){

        this.username = username;

        setBounds(150, 150, 1200, 600);
        setLayout(null);

        JLabel text = new JLabel("ABOUT");
        text.setBounds(530, 20, 120, 30);
        text.setForeground(Color.red);
        text.setFont(new Font("Arial", Font.BOLD, 24));
        add(text);

        String about = "Welcome to TravelSphere, the premier solution for managing your travel and tourism needs with ease and efficiency.\n" +
                "\n" +
                "Our platform is designed to streamline the complexities of travel planning, booking, and management. Whether you're a travel agency, a tour operator, or a traveler looking for seamless arrangements, TravelSphere is your go-to tool for creating exceptional travel experiences.\n" +
                "\nOur Mission\n" +
                "\n" +
                "At TravelSphere, our mission is to simplify travel management by providing an all-in-one platform that caters to the diverse needs of the travel and tourism industry. We aim to enhance the travel experience through innovative solutions that make planning, booking, and managing travel easier than ever.\n" +
                "\nKey Features\n" +
                "\n" +
                "    Comprehensive Booking System: Seamlessly book flights, hotels, tours, and more from a single platform.\n" +
                "    User-Friendly Interface: Intuitive design that makes navigating and managing travel details effortless.\n" +
                "    Real-Time Updates: Stay informed with real-time updates on bookings, itineraries, and travel alerts.\n" +
                "    Secure Payment Options: Multiple payment methods with robust security to ensure a safe transaction experience.\n" +
                "    Customer Support: Dedicated support to assist you every step of the way.\n" +
                "\n" +
                "Why Choose Us?\n" +
                "\n" +
                "    Efficiency: Streamline your travel planning with an integrated system that saves you time and hassle.\n" +
                "    Customization: Tailor your travel experiences with personalized options and flexible itineraries.\n" +
                "    Innovation: Leverage cutting-edge technology for a seamless and modern travel management experience.\n" +
                "    Trust: Rely on a secure and reliable platform trusted by travel professionals and travelers alike.\n" +
                "\n" +
                "Thank you for choosing TravelSphere. We are committed to making your travel management effortless and enjoyable. Embark on your journey with us and explore the world with confidence.";

        TextArea textArea = new TextArea(about,100, 100, Scrollbar.VERTICAL);
        textArea.setEditable(false);
        textArea.setBounds(50, 80, 1100, 400);
        textArea.setFont(new Font("Raleway", Font.BOLD, 16));
        // textArea.setBackground(Color.gray);
        add(textArea);

        exit = new JButton("Exit");
        exit.setBounds(1000, 500, 120, 30);
        exit.setFont(new Font("Arial", Font.BOLD, 18));
        exit.setBackground(Color.gray);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args) {

        new About("");

    }
}
