package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class OTP extends JFrame implements ActionListener {
    String pin;
    JButton done,cancel;
    JRadioButton p,p1;
    JTextField tf;
    OTP (String pin){
        this.pin=pin;
//header
        setLayout(null);

        JLabel to1=new JLabel("                         VERIFICATION");
        to1.setForeground(new Color(70, 29, 99));
        to1.setFont(new Font("Graphik",Font.PLAIN,14));
        to1.setBounds(0,10,300,15);
        add(to1);


        JLabel to=new JLabel("Enter 4-digit OTP send to");
        to.setForeground(Color.white);
        to.setFont(new Font("Graphik",Font.PLAIN,15));
        to.setBounds(25,100,280,30);
        add(to);

        JLabel to2=new JLabel("gmail account *******@gmail.com");
        to2.setForeground(Color.white);
        to2.setFont(new Font("Graphik",Font.PLAIN,15));
        to2.setBounds(25,120,280,30);
        add(to2);

        tf=new JTextField();
        tf.setBounds(10,170,280,30);
        tf.setForeground(Color.black);
        tf.setBackground(Color.lightGray);
        add(tf);

        //home
        cancel=new JButton("Cancel");
        cancel.setBounds(0,268,150,30);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("san sarif",Font.ITALIC,12));
        cancel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        cancel.addActionListener(this);
        add(cancel);
        //done
        done=new JButton("Done");
        done.setForeground(new Color(255, 165, 0));
        done.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0)));
        done.setFont(new Font("san sarif",Font.ITALIC,12));
        done.setBounds(150,268,150,30);
        done.addActionListener(this);
        add(done);










        //framework
        setLayout(null);
        setSize(300,300);//size of the frame
        setLocation(950,300);//by default frame is on top left corner so we set loc to center
        setUndecorated(true);
        getContentPane().setBackground(Color.black);
        setVisible(true);//to see the frame




    }
    public static void main(String[]args){
        new OTP("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String v=tf.getText();


        if (ae.getSource()==done) {
            if(v.length()<0||v.length()>4){
                JOptionPane.showMessageDialog(null,"Incorrect OTP,Try again");
                new OTP(pin).setVisible(true);
            }
            else {

                JOptionPane.showMessageDialog(null, "Transaction successful");
                setVisible(false);
                new Mainpage(pin).setVisible(true);
            }


        }else if (ae.getSource()==cancel) {
            setVisible(false);
            new Mainpage(pin).setVisible(true);


        }
    }
}





