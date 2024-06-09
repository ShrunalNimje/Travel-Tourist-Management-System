package my.mood;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ViewPackage extends JFrame implements ActionListener {

    String username;

    public ViewPackage(String username){

        this.username = username;

        setSize(1200, 600);
        setLocation(150, 150);

        JTabbedPane tab = new JTabbedPane();

        String [] package1 = {"KERALA PACKAGE", "INCLUDES", "Pick & Drop from Airport/Railway Station", "2N in Munnar", "1N in Thekkady", "1N in Houseboat", "1N in Kochi", "Breakfast & Dinner", "Sightseeing & All Transportation", "EXCLUDES", "Lunch", "Air/Train Ticket", "Any Ride", "Any Personal Expenses", "viewPackage-removebg-preview.png", "Package Cost", "5 Couples : 14500/- per Person", "3 Couples : 16000/- per Person", "2 Couples : 18500/- per Person", "1 Couples : 21000/- per Person"};
        String [] package2 = {"HIMACHAL PACKAGE", "INCLUDES", "6 days travel", "Daily Breakfast & Dinner", "Sightseeing by AC Car", "Pick up / Drop : DELHI", "2 Nigths in Shimla", "3 Nights in Manali", "1 Nights in Dharamshala", "EXCLUDES", "Train / Air / Bus Tickets", "Any Personal Expences", "Any Ride", "", "viewPackage1-removebg-preview.png", "Package Cost", "5 Couples : 16000/- per Person", "3 Couples : 19500/- per Person", "2 Couples : 22500/- per Person", "1 Couples : 25000/- per Person"};
        String [] package3 = {"GOA PACKAGE", "INCLUDES", "4 days stay in Hotel / Resort", "Pick up & Drop", "3 Night & 4 Day Accomodation", "Daily Breakfast & Dinner", "1 Day Sight seen", "Complementary usage of Swimming pool", "All Tours & Transfer on Sic basis", "EXCLUDES", "Train / Air / Bus Tickets", "Any Personal Expences", "AirFare", "Extra GST", "viewPackage2-removebg-preview.png","Package Cost", "3 Couples : 22800/- per Person", "2 Couples : 24000/- per Person", "1 Couples : 28000/- per Person", ""};

        JPanel p1 = createPackage(package1);
        JPanel p2 = createPackage(package2);
        JPanel p3 = createPackage(package3);

        tab.addTab("Package 1", null, p1);
        tab.addTab("Package 2", null, p2);
        tab.addTab("Package 3", null, p3);

        add(tab);

        setVisible(true);

    }

    public JPanel createPackage(String [] arr){

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.CYAN);

        JLabel text = new JLabel(arr[0]);
        text.setBounds(200, 20, 300, 25);
        text.setFont(new Font("Arial", Font.BOLD, 24));
        text.setForeground(Color.red);
        p1.add(text);

        JLabel text1 = new JLabel(arr[1]);
        text1.setBounds(150, 60, 150, 25);
        text1.setFont(new Font("Arial", Font.BOLD, 20));
        text1.setForeground(Color.MAGENTA);
        p1.add(text1);

        JLabel include = new JLabel(arr[2]);
        include.setBounds(100, 100, 500, 20);
        include.setFont(new Font("Arial", Font.PLAIN, 16));
        include.setForeground(Color.DARK_GRAY);
        p1.add(include);

        JLabel include1 = new JLabel(arr[3]);
        include1.setBounds(100, 130, 500, 20);
        include1.setFont(new Font("Arial", Font.PLAIN, 16));
        include1.setForeground(Color.DARK_GRAY);
        p1.add(include1);

        JLabel include2 = new JLabel(arr[4]);
        include2.setBounds(100, 160, 500, 20);
        include2.setFont(new Font("Arial", Font.PLAIN, 16));
        include2.setForeground(Color.DARK_GRAY);
        p1.add(include2);

        JLabel include3 = new JLabel(arr[5]);
        include3.setBounds(100, 190, 500, 20);
        include3.setFont(new Font("Arial", Font.PLAIN, 16));
        include3.setForeground(Color.DARK_GRAY);
        p1.add(include3);

        JLabel include4 = new JLabel(arr[6]);
        include4.setBounds(100, 220, 500, 20);
        include4.setFont(new Font("Arial", Font.PLAIN, 16));
        include4.setForeground(Color.DARK_GRAY);
        p1.add(include4);

        JLabel include5 = new JLabel(arr[7]);
        include5.setBounds(100, 250, 500, 20);
        include5.setFont(new Font("Arial", Font.PLAIN, 16));
        include5.setForeground(Color.DARK_GRAY);
        p1.add(include5);

        JLabel include6 = new JLabel(arr[8]);
        include6.setBounds(100, 280, 500, 20);
        include6.setFont(new Font("Arial", Font.PLAIN, 16));
        include6.setForeground(Color.DARK_GRAY);
        p1.add(include6);

        JLabel exclude = new JLabel(arr[9]);
        exclude.setBounds(150, 320, 500, 25);
        exclude.setFont(new Font("Arial", Font.BOLD, 20));
        exclude.setForeground(Color.magenta);
        p1.add(exclude);

        JLabel exclude1 = new JLabel(arr[10]);
        exclude1.setBounds(100, 360, 500, 20);
        exclude1.setFont(new Font("Arial", Font.PLAIN, 16));
        exclude1.setForeground(Color.DARK_GRAY);
        p1.add(exclude1);

        JLabel exclude2 = new JLabel(arr[11]);
        exclude2.setBounds(100, 390, 500, 20);
        exclude2.setFont(new Font("Arial", Font.PLAIN, 16));
        exclude2.setForeground(Color.DARK_GRAY);
        p1.add(exclude2);

        JLabel exclude3 = new JLabel(arr[12]);
        exclude3.setBounds(100, 420, 500, 20);
        exclude3.setFont(new Font("Arial", Font.PLAIN, 16));
        exclude3.setForeground(Color.DARK_GRAY);
        p1.add(exclude3);

        JLabel exclude4 = new JLabel(arr[13]);
        exclude4.setBounds(100, 450, 500, 20);
        exclude4.setFont(new Font("Arial", Font.PLAIN, 16));
        exclude4.setForeground(Color.DARK_GRAY);
        p1.add(exclude4);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + arr[14]));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(650, 50, 400, 300);
        p1.add(image);

        JLabel cost = new JLabel(arr[15]);
        cost.setBounds(750, 380, 300, 25);
        cost.setFont(new Font("Arial", Font.BOLD, 20));
        cost.setForeground(Color.magenta);
        p1.add(cost);

        JLabel price1 = new JLabel(arr[16]);
        price1.setBounds(700, 420, 300, 20);
        price1.setFont(new Font("Arial", Font.PLAIN, 16));
        price1.setForeground(Color.DARK_GRAY);
        p1.add(price1);

        JLabel price2 = new JLabel(arr[17]);
        price2.setBounds(700, 450, 300, 20);
        price2.setFont(new Font("Arial", Font.PLAIN, 16));
        price2.setForeground(Color.DARK_GRAY);
        p1.add(price2);

        JLabel price3 = new JLabel(arr[18]);
        price3.setBounds(700, 480, 300, 20);
        price3.setFont(new Font("Arial", Font.PLAIN, 16));
        price3.setForeground(Color.DARK_GRAY);
        p1.add(price3);

        JLabel price4 = new JLabel(arr[19]);
        price4.setBounds(700, 510, 300, 20);
        price4.setFont(new Font("Arial", Font.PLAIN, 16));
        price4.setForeground(Color.DARK_GRAY);
        p1.add(price4);

        JButton book = new JButton("Book Now");
        book.setBounds(1000, 480, 150, 30);
        book.setFont(new Font("Arial", Font.BOLD, 20));
        book.setForeground(Color.red);
        book.setBackground(Color.cyan);
        book.setBorder(new LineBorder(Color.red));
        book.addActionListener(this);
        p1.add(book);

        return p1;
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new BookPackage(username).setVisible(true);
    }
    public static void main(String [] args){

        new ViewPackage("");

    }
}

