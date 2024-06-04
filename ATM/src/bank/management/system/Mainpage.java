package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mainpage extends JFrame implements ActionListener {
    String pin;
    JButton sendmoney,bills,ATM,settings,Feedback,exit;
    Mainpage(String pin){
        this.pin=pin;
//header
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/pruple.jpeg"));
        Image i2=i1.getImage().getScaledInstance(400,100, getIconImage().SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,400,50);
        add(image);
        JLabel header=new JLabel("NEXUS BANK");
        header.setForeground(Color.white);
        header.setFont(new Font("Graphik",Font.PLAIN,16));
        header.setBounds(10,0,400,50);
        image.add(header);//we are using image obj so that text is added on the image not the frame

        //account info
        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/grey.jpeg"));
        Image i22=i11.getImage().getScaledInstance(300,300, getIconImage().SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel image1=new JLabel(i33);
        image1.setBounds(50,60,300,150);
        add(image1);


        //buttons
        //sendmoney
        ImageIcon i111=new ImageIcon(ClassLoader.getSystemResource("icons/money.png"));
        Image i222=i111.getImage().getScaledInstance(90,90, getIconImage().SCALE_DEFAULT);
        ImageIcon i333=new ImageIcon(i222);
        JLabel image2=new JLabel(i333);
        image2.setBounds(50,250,90,90);
        add(image2);

        sendmoney=new JButton("Send Money");
        sendmoney.setForeground(Color.WHITE);
        sendmoney.setBorder(BorderFactory.createBevelBorder(2,Color.cyan,Color.black));
        sendmoney.setBounds(30,350,100,30);
        sendmoney.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
        sendmoney.addActionListener(this);
        add(sendmoney);

        //bills
        ImageIcon i1111=new ImageIcon(ClassLoader.getSystemResource("icons/bills.png"));
        Image i2222=i1111.getImage().getScaledInstance(90,90, getIconImage().SCALE_DEFAULT);
        ImageIcon i3333=new ImageIcon(i2222);
        JLabel image3=new JLabel(i3333);
        image3.setBounds(250,250,90,90);
        add(image3);
        bills=new JButton("Bill & Top up");
        bills.setBounds(250,350,100,30);
        bills.setForeground(Color.WHITE);
        bills.setBorder(BorderFactory.createBevelBorder(2,Color.cyan,Color.black));
        bills.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
        bills.addActionListener(this);
        add(bills);

        //ATM
        ImageIcon i11111=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i22222=i11111.getImage().getScaledInstance(90,90, getIconImage().SCALE_DEFAULT);
        ImageIcon i33333=new ImageIcon(i22222);
        JLabel image4=new JLabel(i33333);
        image4.setBounds(50,400,90,90);
        add(image4);
        ATM=new JButton("Transactions");
        ATM.setBounds(50,500,100,30);
        ATM.setForeground(Color.WHITE);
        ATM.setBorder(BorderFactory.createBevelBorder(2,Color.cyan,Color.black));
        ATM.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
        ATM.addActionListener(this);
        add(ATM);

        //settings
        ImageIcon i1111111=new ImageIcon(ClassLoader.getSystemResource("icons/setting.png"));
        Image i22222222=i1111111.getImage().getScaledInstance(90,90, getIconImage().SCALE_DEFAULT);
        ImageIcon i33333333=new ImageIcon(i22222222);
        JLabel image7=new JLabel(i33333333);
        image7.setBounds(250,400,90,90);
        add(image7);
        settings=new JButton("Settings");
        settings.setBounds(250,500,100,30);
        settings.setForeground(Color.WHITE);
        settings.setBorder(BorderFactory.createBevelBorder(2,Color.cyan,Color.black));
        settings.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
        settings.addActionListener(this);
        add(settings);

        //FEEDBACK
        ImageIcon i111111=new ImageIcon(ClassLoader.getSystemResource("icons/review.png"));
        Image i222222=i111111.getImage().getScaledInstance(130,90, getIconImage().SCALE_DEFAULT);
        ImageIcon i333333=new ImageIcon(i222222);
        JLabel image5=new JLabel(i333333);
        image5.setBounds(130,540,130,90);
        add(image5);
        Feedback=new JButton("Feedback");
        Feedback.setBounds(150,630,100,30);
        Feedback.setForeground(Color.WHITE);
        Feedback.setBorder(BorderFactory.createBevelBorder(2,Color.cyan,Color.black));
        Feedback.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
        Feedback.addActionListener(this);
        add(Feedback);

        //exit
        ImageIcon i111111111=new ImageIcon(ClassLoader.getSystemResource("icons/logout.png"));
        Image i2222222=i111111111.getImage().getScaledInstance(40,40, getIconImage().SCALE_DEFAULT);
        ImageIcon i333333333=new ImageIcon(i2222222);
        JLabel image6=new JLabel(i333333333);
        image6.setBounds(350,6,40,40);
        image.add(image6);
        exit=new JButton();
        exit.setBounds(350,10,40,40);
        exit.setForeground(Color.WHITE);
        exit.setBorder(BorderFactory.createBevelBorder(2,Color.cyan,Color.black));
        exit.addActionListener(this);
        image.add(exit);

        //DISPLAYING INFO
        JLabel info=new JLabel();
        info.setForeground(Color.BLACK);
        info.setFont(new Font("Sans",Font.BOLD,29));
        info.setBounds(30,40,300,60);
        image1.add(info);
        JLabel info1=new JLabel();
        info1.setForeground(Color.black);
        info1.setFont(new Font("Sans",Font.PLAIN,15));
        info1.setBounds(20,90,400,70);
        image1.add(info1);



        conn c=new conn();

        try {
            ResultSet r = c.s.executeQuery("select * from Login1 where pinnumber='" + pin + "'");
            while(r.next()){
                info.setText(info.getText() +"<html>"+r.getString("Yname")+"  "+r.getString("fathers_name")+"<br><br><html>");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            ResultSet r1 = c.s.executeQuery("select * from signup3 where pinnumber='" + pin + "'");
            while(r1.next()){
                info1.setText(info1.getText() +"<html>"+r1.getString("accounttype")+"-"+r1.getString("cardnumber")+"<br><br><html>");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        int bal = 0;
        try {
            ResultSet r2 = c.s.executeQuery("select * from Transact where pin='" + pin + "'");
            while(r2.next()){
                if (r2.getString("type").equals("deposit")) {
                    bal += Integer.parseInt(r2.getString("amount"));
                } else {
                    bal -= Integer.parseInt(r2.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        JLabel info2=new JLabel("Rs. "+bal);
        info2.setForeground(new Color(70, 29, 99));
        info2.setFont(new Font("Sans",Font.PLAIN,20));
        info2.setBounds(110,60,200,50);
        image1.add(info2);







        //framework
        setLayout(null);
        setSize(400,700);//size of the frame
        setLocation(900,150);//by default frame is on top left corner so we set loc to center
        setUndecorated(true);
        getContentPane().setBackground(Color.black);
        setVisible(true);//to see the frame




    }
    public static void main(String[]args){
        new Mainpage("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit){

            JOptionPane.showMessageDialog(null,"LOG OUT");
            System.exit(0);
        } else if (ae.getSource()==sendmoney) {
            setVisible(false);
            new SendMoney(pin).setVisible(true);


        }else if (ae.getSource()==bills){
            setVisible(false);
          new Bills(pin).setVisible(true);

        }else if (ae.getSource()==ATM){
            setVisible(false);
           new Transactions(pin).setVisible(true);

        }else if (ae.getSource()==Feedback){
            setVisible(false);
            new Feedback(pin).setVisible(true);

        }else if (ae.getSource()==settings) {
            setVisible(false);
            new Settings(pin).setVisible(true);
        }
    }
}

