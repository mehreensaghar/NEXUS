package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Settings extends JFrame implements ActionListener {
    String pin;
    JButton done,cancel,home,exit,chgpass,logout,fingerprint;
    JRadioButton en,dis;
    ButtonGroup f;
    Settings(String pin){
        this.pin=pin;
//header
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/pruple.jpeg"));
        Image i2=i1.getImage().getScaledInstance(400,100, getIconImage().SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,400,50);
        add(image);
        JLabel header=new JLabel("Settings");
        header.setForeground(Color.white);
        header.setFont(new Font("Graphik",Font.PLAIN,16));
        header.setBounds(10,0,400,50);
        image.add(header);//we are using image obj so that text is added on the image not the frame




        //buttons

        //exit
        ImageIcon i111111111=new ImageIcon(ClassLoader.getSystemResource("icons/logout.png"));
        Image i2222222=i111111111.getImage().getScaledInstance(33,33, getIconImage().SCALE_DEFAULT);
        ImageIcon i333333333=new ImageIcon(i2222222);
        JLabel image6=new JLabel(i333333333);
        image6.setBounds(350,10,33,33);
        image.add(image6);
        exit=new JButton();
        exit.setBounds(350,10,40,40);
        exit.setForeground(Color.WHITE);
        exit.setBorder(BorderFactory.createBevelBorder(2,Color.cyan,Color.black));
        exit.addActionListener(this);
        image.add(exit);
        //home
        ImageIcon i1111111111=new ImageIcon(ClassLoader.getSystemResource("icons/home.png"));
        Image i222222222=i1111111111.getImage().getScaledInstance(40,40, getIconImage().SCALE_DEFAULT);
        ImageIcon i3333333333=new ImageIcon(i222222222);
        JLabel image8=new JLabel(i3333333333);
        image8.setBounds(300,6,40,40);
        image.add(image8);
        home=new JButton();
        home.setBounds(300,10,40,40);
        home.setForeground(Color.WHITE);
        home.setBorder(BorderFactory.createBevelBorder(2,Color.cyan,Color.black));
        home.addActionListener(this);
        image.add(home);

        //next
        cancel=new JButton("Back");
        cancel.setForeground(Color.white);
        cancel.setBorder(BorderFactory.createLineBorder(Color.white));
        cancel.setFont(new Font("san sarif",Font.ITALIC,15));
        cancel.setBounds(0,650,400,50);
        cancel.addActionListener(this);
        add(cancel);

        //MAIN BUTTON
        //change pass
        chgpass=new JButton("Change Password");
        chgpass.setForeground(new Color(255, 165, 0));
        chgpass.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0)));
        chgpass.setFont(new Font("san sarif",Font.ITALIC,15));
        chgpass.setBounds(20,80,350,50);
        chgpass.addActionListener(this);
        add(chgpass);
        //fingerprint
        fingerprint=new JButton("Fingerprint Login");
        fingerprint.setForeground(new Color(255, 165, 0));
        fingerprint.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0)));
        fingerprint.setFont(new Font("san sarif",Font.ITALIC,15));
        fingerprint.setBounds(20,150,350,50);
        fingerprint.addActionListener(this);
        add(fingerprint);
        en=new JRadioButton("enable");
        en.setForeground(new Color(255, 165, 0));
        en.setBounds(280,154,80,20);
        en.addActionListener(this);
        add(en);
        dis=new JRadioButton("disable");
        dis.setBounds(280,172,80,20);
        dis.setForeground(new Color(255, 165, 0));
        dis.addActionListener(this);
        add(dis);
        f=new ButtonGroup();
        f.add(en);
        f.add(dis);



        logout=new JButton("Sign out");
        logout.setForeground(new Color(255, 165, 0));
        logout.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0)));
        logout.setFont(new Font("san sarif",Font.ITALIC,15));
        logout.setBounds(20,220,350,50);
        logout.addActionListener(this);
        add(logout);








        //framework
        setLayout(null);
        setSize(400,700);//size of the frame
        setLocation(900,150);//by default frame is on top left corner so we set loc to center
        setUndecorated(true);
        getContentPane().setBackground(Color.black);
        setVisible(true);//to see the frame




    }
    public static void main(String[]args){
        new Settings("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==en){
            JOptionPane.showMessageDialog(null,"Fingerprint Login enabled");

        }
        if(ae.getSource()==dis){
            JOptionPane.showMessageDialog(null,"Fingerprint Login disabled");
        }
        if(ae.getSource()==exit){
            JOptionPane.showMessageDialog(null,"LOG OUT");
            System.exit(0);
        } else if (ae.getSource()==cancel) {
            setVisible(false);
             new Mainpage(pin).setVisible(true);


        }else if (ae.getSource()==done){
            setVisible(false);
             new Mainpage(pin).setVisible(true);


        }else if (ae.getSource()==home){
            setVisible(false);
            new Mainpage(pin).setVisible(true);

        }else if (ae.getSource()==exit) {
            setVisible(false);

        } else if (ae.getSource()==chgpass) {
            setVisible(false);
            new changepassword(pin).setVisible(true);

        }else if (ae.getSource()==logout){
            JOptionPane.showMessageDialog(null,"Signing out");
            setVisible(false);

        }
    }
}




