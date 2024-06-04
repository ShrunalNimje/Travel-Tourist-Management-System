package my.mood;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{

    Thread thread;

    public Splash(){

        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Splash1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        add(image);

        thread = new Thread(this);
        thread.start();

        setVisible(true);

    }

    @Override
    public void run(){

        try{
            Thread.sleep(8000);
            setVisible(false);
            new Login().setVisible(true);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }

    public static void main(String [] args){

        Splash splash = new Splash();

        for(int i = 1; i <= 150; i++){
            splash.setSize(i *8 , i * 4);
            splash.setLocation(i, i);
        }
    }
}
