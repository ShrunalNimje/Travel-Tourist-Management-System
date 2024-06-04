package my.mood;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

    Thread thread;
    String username;
    JProgressBar loading;

    public Loading(String username){

        this.username = username;

        setSize(1200, 600);
        setLocation(150, 150);
        getContentPane().setBackground(Color.gray);
        setLayout(null);

        JLabel text = new JLabel("WELCOME TO TRAVEL AROUND THE WORLD");
        text.setBounds(350,100, 600, 30);
        text.setFont(new Font("Arial", Font.BOLD, 24));
        add(text);

        loading = new JProgressBar();
        loading.setBounds(200, 150, 800, 30);
        loading.setStringPainted(true);
        add(loading);

        JLabel text2 = new JLabel("Please wait while loading . . . ");
        text2.setBounds(500,200, 200, 30);
        text2.setFont(new Font("Arial", Font.PLAIN, 16));
        add(text2);

        JLabel text3 = new JLabel("Welcome " + username + " !");
        text3.setBounds(500,250, 500, 30);
        text3.setFont(new Font("Arial", Font.PLAIN, 20));
        add(text3);

        thread = new Thread(this);
        thread.start();


        setVisible(true);

    }

    @Override
    public void run(){
        try{
            for(int i = 1; i <= 101; i++){
                int a = loading.getMaximum();
                int b = loading.getValue();
                if(b < a){
                    loading.setValue(loading.getValue() + 1);
                    Thread.sleep(100);
                }
                else{
                    setVisible(false);
                    new Dashboard();

                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String [] args){

        new Loading("");

    }
}
