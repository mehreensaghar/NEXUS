package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Signup3 extends JFrame implements ActionListener {
    JRadioButton sa,ca,fda;
    JCheckBox atm,ib,mb,ealerts,chequebook,estatement;
    JButton submit,cancel;
    String formno,name,fname;

    Signup3(String formno,String name,String fname){
        this.formno=formno;
        this.name=name;
        this.fname=fname;
        setLayout(null);


        JLabel title=new JLabel("Page 3: Account Details");
        title.setBounds(275,60,400,30);
        title.setFont(new Font("Raleway",Font.BOLD,20));
        title.setForeground(Color.white);
        add(title);

        JLabel accounttype=new JLabel("Account Type");
        accounttype.setBounds(100,150,200,30);
        accounttype.setFont(new Font("Raleway",Font.PLAIN,24));
        accounttype.setForeground(Color.white);
        add(accounttype);
        sa=new JRadioButton("Saving account");
        sa.setBounds(100,190,200,30);
        sa.setForeground(Color.WHITE);
        add(sa);
        ca=new JRadioButton("Current account");
        ca.setBounds(300,190,200,30);
        ca.setForeground(Color.WHITE);
        add(ca);
        fda=new JRadioButton("Fixed deposit account");
        fda.setBounds(500,190,200,30);
        fda.setForeground(Color.WHITE);
        add(fda);
        ButtonGroup account =new ButtonGroup();
        account.add(sa);
        account.add(ca);
        account.add(fda);

        JLabel cardno=new JLabel("Card Number");
        cardno.setBounds(100,300,400,30);
        cardno.setFont(new Font("Raleway",Font.PLAIN,24));
        cardno.setForeground(Color.white);
        add(cardno);
        JLabel c=new JLabel("Your 16 Digit Card Number");
        c.setBounds(100,332,400,15);
        c.setFont(new Font("Raleway",Font.PLAIN,9));
        c.setForeground(Color.white);
        add(c);
        JLabel no=new JLabel("xxxx-xxxx-xxxx-4355");
        no.setBounds(300,300,400,30);
        no.setFont(new Font("Raleway",Font.PLAIN,20));
        no.setForeground(Color.orange);
        add(no);

        JLabel pin=new JLabel("Pin");
        pin.setBounds(100,350,400,30);
        pin.setFont(new Font("Raleway",Font.PLAIN,24));
        pin.setForeground(Color.white);
        add(pin);
        JLabel p=new JLabel("Your 4 Digit PIN");
        p.setBounds(100,382,400,15);
        p.setFont(new Font("Raleway",Font.PLAIN,9));
        p.setForeground(Color.white);
        add(p);
        JLabel pinno=new JLabel("xxxx");
        pinno.setBounds(300,350,400,30);
        pinno.setFont(new Font("Raleway",Font.PLAIN,20));
        pinno.setForeground(Color.orange);
        add(pinno);

        JLabel service=new JLabel("Services required");
        service.setBounds(100,450,400,30);
        service.setFont(new Font("Raleway",Font.PLAIN,24));
        service.setForeground(Color.white);
        add(service);
        atm =new JCheckBox("ATM card");
        atm.setBounds(100,500,200,30);
        atm.setFont(new Font("Raleway",Font.PLAIN,17));
        atm.setForeground(Color.white);
        add(atm);
        ib =new JCheckBox("Internet Banking");
        ib.setBounds(300,500,200,30);
        ib.setFont(new Font("Raleway",Font.PLAIN,17));
        ib.setForeground(Color.white);
        add(ib);
        mb =new JCheckBox("Mobile Banking");
        mb.setBounds(100,550,200,30);
        mb.setFont(new Font("Raleway",Font.PLAIN,17));
        mb.setForeground(Color.white);
        add(mb);
        ealerts =new JCheckBox("Email Alerts");
        ealerts.setBounds(300,550,200,30);
        ealerts.setFont(new Font("Raleway",Font.PLAIN,17));
        ealerts.setForeground(Color.white);
        add(ealerts);
        chequebook =new JCheckBox("Cheque Book");
        chequebook.setBounds(100,600,200,30);
        chequebook.setFont(new Font("Raleway",Font.PLAIN,17));
        chequebook.setForeground(Color.white);
        add(chequebook);
        estatement =new JCheckBox("E-statement");
        estatement.setBounds(300,600,200,30);
        estatement.setFont(new Font("Raleway",Font.PLAIN,17));
        estatement.setForeground(Color.white);
        add(estatement);
        ButtonGroup ser=new ButtonGroup();
        ser.add(atm);
        ser.add(ib);
        ser.add(mb);
        ser.add(ealerts);
        ser.add(estatement);
        ser.add(chequebook);



        submit=new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBorder(BorderFactory.createLineBorder(Color.white));
        submit.setFont(new Font("san sarif",Font.ITALIC,15));
        submit.setBounds(700,700,100,30);
        submit.addActionListener(this);
        add(submit);
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBorder(BorderFactory.createLineBorder(Color.white));
        cancel.setFont(new Font("san sarif",Font.ITALIC,15));
        cancel.setBounds(550,700,100,30);
        cancel.addActionListener(this);
        add(cancel);









        setSize(850,800);
        setLocation(200,10);
        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);



    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==submit){
            String accounttype=null;
            if(sa.isSelected()){
                accounttype="Saving account";
            }else if(ca.isSelected()){
                accounttype="Current account";
            } else if (fda.isSelected()) {
                accounttype="Fixed bank.management.system.Deposit account";
            }
            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextLong()% 90000000L)+4203164500000000L);//we want a 16 digit number but a bank has fixed num at start so we add those manually
            String pinnumber=""+Math.abs((random.nextLong() % 9000L)+1000L);

            String service=null;
            if(atm.isSelected()){
                service="ATM card";
            }else if(ib.isSelected()){
                service="Internet banking";
            } else if (mb.isSelected()) {
                service="Mobile banking";
            } else if (ealerts.isSelected()) {
                service="Email alerts";
            }else if(chequebook.isSelected()){
                service="cheque book";
            }else if(estatement.isSelected()){
                service="E-statement";
            }

            try{
                conn c=new conn();
                String query="insert into signup3 values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+service+"')";
                String query2="insert into Login1 values('"+formno+"','"+cardnumber+"','"+pinnumber+"','"+name+"','"+fname+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Card number: "+cardnumber+"\npin: "+pinnumber);

                //open deposit bec we cannot open a account with 0 money
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }

    }
    public static void main(String[]args){
        new Signup3("","","");

    }


}
