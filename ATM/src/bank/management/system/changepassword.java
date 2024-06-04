package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class changepassword extends JFrame implements ActionListener {
    String pin;
    JButton done,cancel,home,exit,chgpass,logout,fingerprint;
    JRadioButton p,p1;
    JTextField oldtf,newtf,new1tf;
    changepassword(String pin){
        this.pin=pin;
//header
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/pruple.jpeg"));
        Image i2=i1.getImage().getScaledInstance(400,100, getIconImage().SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,400,50);
        add(image);
        JLabel header=new JLabel("Change Password");
        header.setForeground(Color.white);
        header.setFont(new Font("Graphik",Font.PLAIN,16));
        header.setBounds(10,0,400,50);
        image.add(header);//we are using image obj so that text is added on the image not the frame

        //MAIN
         JLabel old =new JLabel("Old password");
        old.setForeground(new Color(255, 165, 0));
        old.setFont(new Font("Graphik",Font.PLAIN,15));
        old.setBounds(20,70,400,30);
        add(old);
        //to text
        oldtf=new JTextField();
        oldtf.setBounds(20,100,352,50);
        oldtf.setForeground(Color.black);
        oldtf.setBackground(Color.lightGray);
        add(oldtf);

        JLabel newp =new JLabel("New password");
        newp.setForeground(new Color(255, 165, 0));
        newp.setFont(new Font("Graphik",Font.PLAIN,15));
        newp.setBounds(20,170,400,30);
        add(newp);
        //to text
        newtf=new JTextField();
        newtf.setBounds(20,200,352,50);
        newtf.setForeground(Color.black);
        newtf.setBackground(Color.lightGray);
        add(newtf);

        JLabel newp1 =new JLabel("Re-enter new  password");
        newp1.setForeground(new Color(255, 165, 0));
        newp1.setFont(new Font("Graphik",Font.PLAIN,15));
        newp1.setBounds(20,270,400,30);
        add(newp1);
        //to text
        new1tf=new JTextField();
        new1tf.setBounds(20,300,352,50);
        new1tf.setForeground(Color.black);
        new1tf.setBackground(Color.lightGray);
        add(new1tf);
//Constraints
        JLabel constraint=new JLabel("Password must be numeric");
        constraint.setFont(new Font("Raleway",Font.BOLD,10));
        constraint.setBounds(20,355,350,10);
        constraint.setForeground(new Color(255, 165, 0));
        add(constraint);
        JLabel constraint1=new JLabel("Maximum password length should be 4 character");
        constraint1.setFont(new Font("Raleway",Font.BOLD,10));
        constraint1.setBounds(20,370,350,10);
        constraint1.setForeground(new Color(255, 165, 0));
        add(constraint1);







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
        done=new JButton("OK");
        done.setForeground(new Color(255, 165, 0));
        done.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0)));
        done.setFont(new Font("san sarif",Font.ITALIC,15));
        done.setBounds(0,650,400,50);
        done.addActionListener(this);
        add(done);










        //framework
        setLayout(null);
        setSize(400,700);//size of the frame
        setLocation(900,150);//by default frame is on top left corner so we set loc to center
        setUndecorated(true);
        getContentPane().setBackground(Color.black);
        setVisible(true);//to see the frame




    }
    public static void main(String[]args){
        new changepassword("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String oldpass=oldtf.getText();
        String newpass=newtf.getText();
        String newpass1=new1tf.getText();



        if(ae.getSource()==exit){

            System.exit(0);


        }else if (ae.getSource()==done){
            if(oldpass==""||newpass==""||newpass1==""){
                JOptionPane.showMessageDialog(null,"Enter values");
                new changepassword(pin).setVisible(true);

            }

            conn c=new conn();
            try {
                ResultSet r1 = c.s.executeQuery("select * from signup3 where pinnumber='" + pin + "'");
                while(r1.next()){
                    if (oldpass.equals(r1.getString("pinnumber"))){
                        if(newpass.equals(newpass1)){
                            if(newpass.length()>0&&newpass.length()<5) {
                                JOptionPane.showMessageDialog(null, "password updated");

                            }else {
                                JOptionPane.showMessageDialog(null,"Password length does not match requirement");
                                new changepassword(pin).setVisible(true);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"Password do not match");
                            new changepassword(pin).setVisible(true);
                        }

                    }else{
                        JOptionPane.showMessageDialog(null,"Incorrect Password");
                        new changepassword(pin).setVisible(true);
                    }



                }
            }catch (Exception e){
                System.out.println(e);
            }

            conn c1=new conn();

            try {
                String updateQuery = "UPDATE signup3 SET pinnumber = '" + newpass + "' WHERE pinnumber = '" + oldpass + "'";
                c1.s.executeUpdate(updateQuery);
            } catch (Exception e) {
                System.out.println("Error updating password: " + e.getMessage());
            }
            try {
                String updateQuery = "UPDATE Login1 SET pinnumber = '" + newpass + "' WHERE pinnumber = '" + oldpass + "'";
                c1.s.executeUpdate(updateQuery);
            } catch (Exception e) {
                System.out.println("Error updating password: " + e.getMessage());
            }
            try {
                String updateQuery = "UPDATE Transact SET pinnumber = '" + newpass + "' WHERE pinnumber = '" + oldpass + "'";
                c1.s.executeUpdate(updateQuery);
            } catch (Exception e) {
                System.out.println("Error updating password: " + e.getMessage());
            }
            try {
                String updateQuery = "UPDATE SendMoney SET pinnumber = '" + newpass + "' WHERE pinnumber = '" + oldpass + "'";
                c1.s.executeUpdate(updateQuery);
            } catch (Exception e) {
                System.out.println("Error updating password: " + e.getMessage());
            }
            try {
                String updateQuery = "UPDATE Bills SET pinnumber = '" + newpass + "' WHERE pinnumber = '" + oldpass + "'";
                c1.s.executeUpdate(updateQuery);
            } catch (Exception e) {
                System.out.println("Error updating password: " + e.getMessage());
            }
            try {
                String updateQuery = "UPDATE feedback SET pinnumber = '" + newpass + "' WHERE pinnumber = '" + oldpass + "'";
                c1.s.executeUpdate(updateQuery);
            } catch (Exception e) {
                System.out.println("Error updating password: " + e.getMessage());
            }

            setVisible(false);
            new Mainpage(pin).setVisible(true);


        }else if (ae.getSource()==home){
            setVisible(false);
            new Mainpage(pin).setVisible(true);

        }else if (ae.getSource()==exit) {
            setVisible(false);


        }
    }
}




