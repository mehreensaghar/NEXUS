package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    String pin;
    JButton deposit,withdraw,fastcash,ministatement,balanceinquiry,exit;
    Transactions(String pin){
        this.pin=pin;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,970, getIconImage().SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,970);
        add(image);

        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(220,330,700,40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);//we are using image obj so that text is added on the image not the frame

        //button

        deposit=new JButton("Deposit");
        deposit.setBounds(160,445,150,35);
        deposit.addActionListener(this);
        image.add(deposit);
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,445,150,35);
        withdraw.addActionListener(this);
        image.add(withdraw);
        fastcash=new JButton("Fast cash");
        fastcash.setBounds(160,485,150,35);
        fastcash.addActionListener(this);
        image.add(fastcash);
        ministatement=new JButton("Statement");
        ministatement.setBounds(355,485,150,35);
        ministatement.addActionListener(this);
        image.add(ministatement);
        balanceinquiry=new JButton("Balance Inquiry");
        balanceinquiry.setBounds(160,525,150,35);
        balanceinquiry.addActionListener(this);
        image.add(balanceinquiry);
        exit=new JButton("Exit");
        exit.setBounds(355,525,150,35);
        exit.addActionListener(this);
        image.add(exit);




        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }
    public static void main(String[]args){
        new Transactions("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit){
            setVisible(false);
            new Mainpage(pin).setVisible(true);
        } else if (ae.getSource()==deposit) {
           setVisible(false);
           new Deposit(pin).setVisible(true);


        }else if (ae.getSource()==withdraw){
            setVisible(false);
            new Withdraw(pin).setVisible(true);

        }else if (ae.getSource()==fastcash){
            setVisible(false);
            new Fastcash(pin).setVisible(true);

        }else if (ae.getSource()==ministatement){
            setVisible(false);
            new Ministatement(pin).setVisible(true);

        }else if (ae.getSource()==balanceinquiry){
            setVisible(false);
            new Balanceinquiry(pin).setVisible(true);

        }

    }
}
