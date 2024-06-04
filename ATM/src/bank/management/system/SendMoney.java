package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SendMoney extends JFrame implements ActionListener {
        String pin;
        JButton sendmoney,bills,ATM,home,next,exit;
        JTextField amounttf,totf;
        JComboBox option;
    int balance = 0;
        SendMoney(String pin){
            this.pin=pin;
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
            JLabel from=new JLabel("From Account");
            from.setForeground(new Color(255, 165, 0));
            from.setFont(new Font("Graphik",Font.PLAIN,15));
            from.setBounds(20,60,400,30);
            add(from);








            //to acc
            JLabel to=new JLabel("To Account");
            to.setForeground(new Color(255, 165, 0));
            to.setFont(new Font("Graphik",Font.PLAIN,15));
            to.setBounds(20,145,400,30);
            add(to);
            //to text
            totf=new JTextField();
            totf.setBounds(20,175,352,58);
            totf.setForeground(Color.black);
            totf.setBackground(Color.lightGray);
            add(totf);


            //enter amount
            JLabel amount=new JLabel("Amount:");
            amount.setFont(new Font("Raleway",Font.BOLD,15));
            amount.setBounds(20,280,100,20);
            amount.setForeground(Color.white);
            add(amount);

            amounttf=new JTextField();
            amounttf.setBounds(20,300,350,30);
            amounttf.setForeground(Color.white);
            amounttf.setBackground(Color.BLACK);
            amounttf.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.WHITE));
            add(amounttf);


            JLabel constraint=new JLabel("Enter an amount between Rs.1 and Rs.1,000,000");
            constraint.setFont(new Font("Raleway",Font.BOLD,12));
            constraint.setBounds(20,335,350,20);
            constraint.setForeground(new Color(255, 165, 0));
            add(constraint);


            //purpose of payment
            JLabel pop=new JLabel("Purpose of payment");
            pop.setFont(new Font("Raleway",Font.BOLD,15));
            pop.setBounds(20,360,350,20);
            pop.setForeground(new Color(255, 165, 0));
            add(pop);
            String category[]={"Others","Donations/Charity","Education payment","investment","Loan","Medical"};
            option=new JComboBox(category);
            option.setBounds(20,390,350,40);
            option.setBackground(Color.white);
            option.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.white));
            add(option);


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
            next=new JButton("Next");
            next.setForeground(new Color(255, 165, 0));
            next.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0)));
            next.setFont(new Font("san sarif",Font.ITALIC,15));
            next.setBounds(0,650,400,50);
            next.addActionListener(this);
            add(next);

            //DISPLAYING INFO


            JLabel info=new JLabel("   ");
            info.setForeground(new Color(255, 165, 0));
            info.setFont(new Font("Sans",Font.PLAIN,16));
            info.setBorder(BorderFactory.createMatteBorder(2,2,0,2,Color.lightGray));
            info.setBackground(Color.white);
            info.setBounds(20,90,350,25);
            add(info);
            JLabel info1=new JLabel("   ");
            info1.setForeground(new Color(255, 165, 0));
            info1.setFont(new Font("Sans",Font.PLAIN,14));
            info1.setBorder(BorderFactory.createMatteBorder(0,2,2,2,Color.lightGray));
            info1.setBackground(Color.white);
            info1.setBounds(20,115,350,25);
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
            info2.setBounds(20,230,200,50);
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
            new SendMoney("");

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==exit){
                JOptionPane.showMessageDialog(null,"LOG OUT");
                System.exit(0);

            }else if (ae.getSource()==home){
                setVisible(false);
                new Mainpage(pin).setVisible(true);

            }else if (ae.getSource()==next) {
                String toacc=totf.getText();
                String amount=amounttf.getText();
                String purpose=(String)option.getSelectedItem();
                try{
                    if(toacc.equals("")){
                        JOptionPane.showMessageDialog(null,"To account is required");
                        new SendMoney(pin).setVisible(true);
                    }
                    if(amount.equals("")){
                        JOptionPane.showMessageDialog(null,"Amount is required");
                        new SendMoney(pin).setVisible(true);
                    } else if(Integer.parseInt(amount)>balance) {
                        JOptionPane.showMessageDialog(null,"Low balance");
                        new SendMoney(pin).setVisible(true);

                    } else if(Integer.parseInt(amount)>1000000 ||Integer.parseInt(amount)<1) {
                        JOptionPane.showMessageDialog(null,"Enter a amount between the given range");
                        new SendMoney(pin).setVisible(true);

                    }
                    else{
                        conn c=new conn();
                        //inset query stores data in database
                        String query="insert into sendmoney values('"+pin+"','"+toacc+"','"+amount+"','"+purpose+"')";
                        c.s.executeUpdate(query);


                        setVisible(false);
                        new SendMoney2(pin,amount).setVisible(true);



                    }

                }catch (Exception e){
                    System.out.println(e);
                }
                setVisible(false);

            }
        }
    }



