package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class SendMoney2 extends JFrame implements ActionListener {
    String pin,amount;
    JButton home,done,cancel,exit;
    JTextField amounttf,totf;
    JComboBox option;


    SendMoney2(String pin,String amount){
        this.pin=pin;
        this.amount=amount;
//header
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/pruple.jpeg"));
        Image i2=i1.getImage().getScaledInstance(400,100, getIconImage().SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,400,50);
        add(image);
        JLabel header=new JLabel("Send Money");
        header.setForeground(Color.white);
        header.setFont(new Font("Graphik",Font.PLAIN,16));
        header.setBounds(10,0,400,50);
        image.add(header);//we are using image obj so that text is added on the image not the frame

        //from acc
        JLabel from=new JLabel("From ");
        from.setForeground(new Color(255, 165, 0));
        from.setFont(new Font("Graphik",Font.PLAIN,15));
        from.setBounds(20,60,400,30);
        add(from);

        JLabel info=new JLabel("   ");
        info.setForeground(new Color(255, 165, 0));
        info.setFont(new Font("Sans",Font.PLAIN,16));
        info.setBorder(BorderFactory.createMatteBorder(2,2,0,2,Color.lightGray));
        info.setBackground(Color.white);
        info.setBounds(20,100,350,25);
        add(info);
        JLabel info1=new JLabel("   ");
        info1.setForeground(new Color(255, 165, 0));
        info1.setFont(new Font("Sans",Font.PLAIN,14));
        info1.setBorder(BorderFactory.createMatteBorder(0,2,2,2,Color.lightGray));
        info1.setBackground(Color.white);
        info1.setBounds(20,125,350,25);
        add(info1);
        conn c=new conn();

        try {
            ResultSet r = c.s.executeQuery("select * from Login1 where pinnumber='" + pin + "'");
            while(r.next()){
                info.setText(info.getText() +r.getString("Yname")+"  "+r.getString("fathers_name"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            ResultSet r1 = c.s.executeQuery("select * from signup3 where pinnumber='" + pin + "'");
            while(r1.next()){
                info1.setText(info1.getText() +r1.getString("accounttype")+"-"+r1.getString("cardnumber"));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        int balance = 0;
        try {
            ResultSet r5 = c.s.executeQuery("select * from Transact where pin='" + pin + "'");
            while(r5.next()){
                if (r5.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(r5.getString("amount"));
                } else {
                    balance -= Integer.parseInt(r5.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }







        //to acc
        JLabel to=new JLabel("To");
        to.setForeground(new Color(255, 165, 0));
        to.setFont(new Font("Graphik",Font.PLAIN,15));
        to.setBounds(20,155,400,30);
        add(to);
        JLabel to2=new JLabel("  To:");
        to2.setForeground(Color.white);
        to2.setFont(new Font("Graphik",Font.PLAIN,13));
        to2.setBorder(BorderFactory.createMatteBorder(2,2,0,2,Color.WHITE));
        to2.setBounds(20,185,350,30);
        add(to2);
        JLabel to22=new JLabel("  ");
        to22.setForeground(Color.white);
        to22.setFont(new Font("Graphik",Font.PLAIN,13));
        to22.setBounds(220,186,150,30);
        add(to22);
String acc = null;
        try {
            ResultSet r6 = c.s.executeQuery("select * from SendMoney where pin='" + pin + "'");
            while(r6.next()){
                acc=r6.getString("toacc");
            }
            to22.setText(to22.getText() +acc);
            

        }catch (Exception e){
            System.out.println(e);
        }


        // amount
        JLabel amount1=new JLabel("  Amount:");
        amount1.setFont(new Font("Raleway",Font.PLAIN,13));
        amount1.setBounds(20,215,350,30);
        amount1.setBorder(BorderFactory.createMatteBorder(2,2,0,2,Color.WHITE));
        amount1.setForeground(Color.white);
        add(amount1);
        JLabel amount2=new JLabel("  ");
        amount2.setFont(new Font("Raleway",Font.PLAIN,13));
        amount2.setBounds(320,215,50,30);
        amount2.setForeground(Color.white);
        add(amount2);
        String a=null;
        try {
            ResultSet r7 = c.s.executeQuery("select * from SendMoney where pin='" + pin + "'");
            while(r7.next()){
                a=r7.getString("amount");
            }
            amount2.setText(amount2.getText() +a);

        }catch (Exception e){
            System.out.println(e);
        }

        // bank
        JLabel b =new JLabel("  Bank charges:                                                     Rs.0");
        b.setFont(new Font("Raleway",Font.PLAIN,13));
        b.setBounds(20,245,350,30);
        b.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE));
        b.setForeground(Color.white);
        add(b);







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
        //done
        done=new JButton("Pay Now");
        done.setForeground(new Color(255, 165, 0));
        done.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0)));
        done.setFont(new Font("san sarif",Font.ITALIC,15));
        done.setBounds(200,650,200,50);
        done.addActionListener(this);
        add(done);
        //next
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBorder(BorderFactory.createLineBorder(Color.white));
        cancel.setFont(new Font("san sarif",Font.ITALIC,15));
        cancel.setBounds(0,650,200,50);
        cancel.addActionListener(this);
        add(cancel);

        //DISPLAYING INFO





        //framework
        setLayout(null);
        setSize(400,700);//size of the frame
        setLocation(900,150);//by default frame is on top left corner so we set loc to center
        setUndecorated(true);
        getContentPane().setBackground(Color.black);
        setVisible(true);//to see the frame




    }
    public static void main(String[]args){
        new SendMoney2("","");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit){
            JOptionPane.showMessageDialog(null,"LOG OUT");
            System.exit(0);

        }else if (ae.getSource()==home){
            setVisible(false);
            new Mainpage(pin).setVisible(true);

        }else if (ae.getSource()==done) {
            try {
                Date date=new Date();
                conn c = new conn();
                String query = "insert into Transact values('"+pin+"','"+date+"','withdraw','"+amount+"')";
                c.s.executeUpdate(query);

                new OTP(pin).setVisible(true);



            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource()==cancel) {
            new SendMoney(pin).setVisible(true);
        }
    }
}




