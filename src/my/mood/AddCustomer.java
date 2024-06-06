package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener{

    JButton add, cancel;
    String username;
    JLabel usernameL1, nameL1;
    JComboBox idCB;
    JTextField idNumTF, phoneTF,
            emailTF, countryTF, addressTF;
    JRadioButton maleRB, femaleRB;

    public AddCustomer(String username){

        this.username = username;

        setSize(1200, 600);
        setLocation(150, 150);
        getContentPane().setBackground(Color.orange);
        setLayout(null);

        JLabel text = new JLabel("Add your Details here!");
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
        usernameL1.setBorder(new LineBorder(Color.black));
        usernameL1.setBackground(Color.white);
        add(usernameL1);

        JLabel idL = new JLabel("Id :");
        idL.setBounds(100, 100, 150, 20);
        idL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(idL);

        String [] arr = {"Passport Id", "Aadhaar Id", "Pan Number", "Voter Id", "Driving id"};
        idCB = new JComboBox(arr);
        idCB.setBackground(Color.white);
        idCB.setBounds(280, 100, 250, 20);
        idCB.setFont(new Font("Raleway", Font.PLAIN, 14));
        idCB.setBorder(new LineBorder(Color.black));
        add(idCB);

        JLabel idNumL = new JLabel("Id Number :");
        idNumL.setBounds(100, 150, 150, 20);
        idNumL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(idNumL);

        idNumTF = new JTextField();
        idNumTF.setBounds(280, 150, 250, 20);
        idNumTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        idNumTF.setBorder(new LineBorder(Color.black));
        add(idNumTF);

        JLabel nameL = new JLabel("Name :");
        nameL.setBounds(100, 200, 150, 20);
        nameL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(nameL);

        nameL1 = new JLabel();
        nameL1.setBounds(280, 200, 250, 20);
        nameL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        nameL1.setBorder(new LineBorder(Color.black));
        nameL1.setBackground(Color.white);
        add(nameL1);

        JLabel phoneL = new JLabel("Phone Number :");
        phoneL.setBounds(100, 250, 150, 20);
        phoneL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(phoneL);

        phoneTF = new JTextField();
        phoneTF.setBounds(280, 250, 250, 20);
        phoneTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        phoneTF.setBorder(new LineBorder(Color.black));
        add(phoneTF);

        JLabel emailL = new JLabel("Email Id :");
        emailL.setBounds(100, 300, 150, 20);
        emailL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(emailL);

        emailTF = new JTextField();
        emailTF.setBounds(280, 300, 250, 20);
        emailTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        emailTF.setBorder(new LineBorder(Color.black));
        add(emailTF);

        JLabel countryL = new JLabel("Country :");
        countryL.setBounds(100, 350, 150, 20);
        countryL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(countryL);

        countryTF = new JTextField();
        countryTF.setBounds(280, 350, 250, 20);
        countryTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        countryTF.setBorder(new LineBorder(Color.black));
        add(countryTF);

        JLabel genderL = new JLabel("Gender :");
        genderL.setBounds(100, 400, 150, 20);
        genderL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(genderL);

        maleRB = new JRadioButton("Male");
        maleRB.setBounds(300, 400, 120, 20);
        maleRB.setFont(new Font("Raleway", Font.PLAIN, 16));
        maleRB.setBackground(Color.orange);
        add(maleRB);

        femaleRB = new JRadioButton("Female");
        femaleRB.setBounds(430, 400, 120, 20);
        femaleRB.setFont(new Font("Raleway", Font.PLAIN, 16));
        femaleRB.setBackground(Color.orange);
        add(femaleRB);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRB);
        genderGroup.add(femaleRB);

        JLabel addressL = new JLabel("Address :");
        addressL.setBounds(100, 450, 150, 20);
        addressL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(addressL);

        addressTF = new JTextField();
        addressTF.setBounds(280, 450, 250, 20);
        addressTF.setFont(new Font("Raleway", Font.PLAIN, 16));
        addressTF.setBorder(new LineBorder(Color.black));
        add(addressTF);

        cancel = new JButton("CANCEL");
        cancel.setBounds(280, 500, 100, 25);
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBackground(Color.gray);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        add = new JButton("ADD");
        add.setBounds(430, 500, 100, 25);
        add.setFont(new Font("Raleway", Font.BOLD, 16));
        add.setBackground(Color.gray);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addData-removebg-preview.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(600, 50, 600, 500);
        add(image);

        try{
            DBConnection DBc = new DBConnection();
            String query = "select * from signup where username = '"+username+"'";
            ResultSet rs = DBc.s.executeQuery(query);

            while(rs.next()){
                usernameL1.setText(rs.getString("username"));
                nameL1.setText(rs.getString("name"));
            }
        }
        catch(SQLException e){
            System.out.print(e);
        }

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae){

        String usernameS = usernameL1.getText();
        String idS = (String) idCB.getSelectedItem();
        String idNumS = idNumTF.getText();
        String nameS = nameL1.getText();
        String phoneS = phoneTF.getText();
        String emailS = emailTF.getText();
        String countryS = countryTF.getText();
        String genderS = null;
        if(maleRB.isSelected()){
            genderS = "Male";
        }
        else if(femaleRB.isSelected()){
            genderS = "Female";
        }
        String addressS = addressTF.getText();

        if(ae.getSource() == add){
            try{
                if(usernameS.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill the username field!");
                }
                else if(idNumS.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill the Id number field!");
                }
                else if(nameS.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill the name field!");
                }
                else if(phoneS.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill the phone number field!");
                }
                else if(emailS.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill the email address field!");
                }
                else if(countryS.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill the country field!");
                }
                else if(genderS == null){
                    JOptionPane.showMessageDialog(null, "Please fill the gender field!");
                }
                else if(addressS.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill the address field!");
                }
                else{
                    DBConnection DBc = new DBConnection();
                    String query = "insert into Customer values('"+usernameS+"', '"+idS+"', '"+idNumS+"', '"+nameS+"', '"+phoneS+"', '"+emailS+"', '"+countryS+"', '"+genderS+"', '"+addressS+"')";
                    DBc.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Details added successfully!");

                    setVisible(false);
                }
            }
            catch(HeadlessException | SQLException e){
                System.out.print(e);
            }
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String [] args){

        new AddCustomer("").setVisible(true);

    }
}
