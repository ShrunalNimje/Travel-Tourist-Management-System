package my.mood;

import javax.swing.*;
import java.awt.*;

public class ViewHotels extends JFrame implements Runnable{

    Thread thread;
    JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10/*, j11, j12, j13, j14, j15*/;
    JLabel [] j = {j1, j2, j3, j4, j5, j6, j7, j8, j9, j10/*, j11, j12, j13, j14, j15*/};
    JLabel label;
    String username;

    public ViewHotels(String username){

        this.username = username;

        setSize(1200, 600);
        setLocation(150, 150);

        label = new JLabel();
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBounds(20, 500, 500, 30);
        label.setForeground(Color.white);
        add(label);

        ImageIcon a1 = null, a2 = null, a3 = null, a4 = null, a5 = null,
                a6 = null, a7 = null, a8 = null, a9 = null, a10 = null/*,
                a11 = null, a12 = null, a13 = null, a14 = null, a15 = null*/;
        ImageIcon  [] a = {a1, a2, a3, a4, a5, a6, a7, a8, a9, a10/*, a11, a12, a13, a14, a15*/};

        Image b1 = null, b2 = null, b3 = null, b4 = null, b5 = null,
                b6 = null, b7 = null, b8 = null, b9 = null, b10 = null/*,
                b11 = null, b12 = null, b13 = null, b14 = null, b15 = null*/;
        Image [] b = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10/*, b11, b12, b13, b14, b15*/};

        ImageIcon c1 = null, c2 = null, c3 = null, c4 = null, c5 = null,
                c6 = null, c7 = null, c8 = null, c9 = null, c10 = null/*,
                c11 = null, c12 = null, c13 = null, c14 = null, c15 = null*/;
        ImageIcon  [] c = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10/* , c11, c12, c13, c14, c15*/};

        for (int i = 0; i < 10; i++){
            a[i] = new ImageIcon(ClassLoader.getSystemResource("icons/hotel" + (i+1) + ".jpg"));
            b[i] = a[i].getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
            c[i] = new ImageIcon(b[i]);

            j[i] = new JLabel(c[i]);
            j[i].setBounds(0, 0, 1200, 600);
            add(j[i]);

        }

        thread = new Thread(this);
        thread.start();

        setVisible(true);

    }

    public void run(){
        try{
            String  [] text = {"JW Marriott Hotel", "Mandarin Oriental Hotel", "Four Seasons Hotel", "Radisson Hotel", "Classio Hotel", "The Bay Club Hotel", "Breeze Blows Hotel", "Quick Stop Hotel", "Happy Mornings Motel", "Moss View Hotel"};

            for (int i = 0; i < 10; i++){
                j[i].setVisible(true);
                label.setText(text[i]);
                Thread.sleep(2000);
                j[i].setVisible(false);
            }

            setVisible(false);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        new ViewHotels("");

    }
}
