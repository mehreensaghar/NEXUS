package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Bills extends JFrame implements ActionListener {
    String pin;
    JButton home,done,exit,cancel;
    JTextField amounttf,totf;
    JComboBox option;
    int balance = 0;
    Bills(String pin){
        this.pin=pin;
//header
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/pruple.jpeg"));
        Image i2=i1.getImage().getScaledInstance(400,100, getIconImage().SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,400,50);
        add(image);
        JLabel header=new JLabel("Bill Payment");
        header.setForeground(Color.white);
        header.setFont(new Font("Graphik",Font.PLAIN,16));
        header.setBounds(10,0,400,50);
        image.add(header);//we are using image obj so that text is added on the image not the frame

        //purpose of payment
        JLabel pop=new JLabel("Add Bills:");
        pop.setFont(new Font("Raleway",Font.BOLD,15));
        pop.setBounds(20,70,350,20);
        pop.setForeground(new Color(255, 165, 0));
        add(pop);
        String category[]={"Utility","Mobile Top ups","Mobile Bundels","Internet Payments","Government","Others"};
        option=new JComboBox(category);
        option.setBounds(20,100,350,50);
        option.setBackground(Color.white);
        option.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.white));
        add(option);

        //from acc
        JLabel from=new JLabel("From Account");
        from.setForeground(new Color(255, 165, 0));
        from.setFont(new Font("Graphik",Font.PLAIN,15));
        from.setBounds(20,170,400,30);
        add(from);
        //ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/grey.jpeg"));
        //Image i22=i11.getImage().getScaledInstance(400,100, getIconImage().SCALE_DEFAULT);
        //ImageIcon i33=new ImageIcon(i22);
        //JLabel image1=new JLabel(i33);
        //image1.setBounds(20,210,350,50);
        //add(image1);





        //enter amount
        JLabel amount=new JLabel("Amount:");
        amount.setFont(new Font("Raleway",Font.BOLD,15));
        amount.setBounds(20,320,100,20);
        amount.setForeground(Color.white);
        add(amount);

        amounttf=new JTextField();
        amounttf.setBounds(20,340,350,30);
        amounttf.setForeground(Color.white);
        amounttf.setBackground(Color.BLACK);
        amounttf.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.WHITE));
        add(amounttf);


        JLabel constraint=new JLabel("Enter an amount between Rs.1 and Rs.1,000,000");
        constraint.setFont(new Font("Raleway",Font.BOLD,12));
        constraint.setBounds(20,375,350,20);
        constraint.setForeground(new Color(255, 165, 0));
        add(constraint);





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


        JLabel info=new JLabel("  ");
        info.setForeground(new Color(255, 165, 0));
        info.setFont(new Font("Sans",Font.PLAIN,16));
        info.setBorder(BorderFactory.createMatteBorder(2,2,0,2,Color.lightGray));
        info.setBackground(Color.white);
        info.setBounds(20,210,350,30);
        add(info);
        JLabel info1=new JLabel("  ");
        info1.setForeground(new Color(255, 165, 0));
        info1.setFont(new Font("Sans",Font.PLAIN,13));
        info1.setBorder(BorderFactory.createMatteBorder(0,2,2,2,Color.lightGray));
        info1.setBackground(Color.white);
        info1.setBounds(20,240,350,30);
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
        JLabel info2=new JLabel("Available balance Rs. "+balance);
        info2.setForeground(Color.lightGray);
        info2.setFont(new Font("Sans",Font.PLAIN,15));
        info2.setBounds(20,268,200,50);
        add(info2);


















        //framework
        setLayout(null);
        setSize(400,700);//size of the frame
        setLocation(900,150);//by default frame is on top left corner so we set loc to center
        setUndecorated(true);
        getContentPane().setBackground(Color.black);
        setVisible(true);//to see the frame




    }
    public static void main(String[]args){
        new Bills("");

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
            String type=(String)option.getSelectedItem();
            String amount=amounttf.getText();
            try{
                if(option.getSelectedItem()==null){
                    JOptionPane.showMessageDialog(null,"Choose the type of bill");
                    new Bills(pin).setVisible(true);
                }
                if(amount.equals("")){
                    JOptionPane.showMessageDialog(null,"Amount is required");
                    new Bills(pin).setVisible(true);
                } else if(Integer.parseInt(amount)>balance) {
                    JOptionPane.showMessageDialog(null,"Low balance");
                    new Bills(pin).setVisible(true);

                } else if(Integer.parseInt(amount)>1000000 ||Integer.parseInt(amount)<1) {
                    JOptionPane.showMessageDialog(null,"Enter a amount between the given range");
                    new Bills(pin).setVisible(true);

                }
                else{
                    conn c=new conn();
                    Date date=new Date();
                    //inset query stores data in database

                    try {
                        String query = "insert into Transact values('" + pin + "','" + date + "','withdraw','" + amount + "')";
                        c.s.executeUpdate(query);

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (HeadlessException e) {
                        throw new RuntimeException(e);
                    }


                    setVisible(false);
                    new OTP(pin).setVisible(true);



                }

            }catch (Exception e){
                System.out.println(e);
            }
            try{
                conn c=new conn();
                String query="insert into Bills values('"+pin+"','"+type+"','"+amount+"')";
                c.s.executeUpdate(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            setVisible(false);

        } else if (ae.getSource()==cancel) {
            new Mainpage(pin).setVisible(true);
        }
    }
}



