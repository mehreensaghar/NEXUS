package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    String pin;
    JButton a1, a2, a3, a4, a5, a6, back;

    Fastcash(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 970, getIconImage().SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 970);
        add(image);

        JLabel text = new JLabel("Please select your Withdrawal amount");
        text.setBounds(200, 330, 700, 40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);//we are using image obj so that text is added on the image not the frame

        //button

        a1 = new JButton("1000");
        a1.setBounds(160, 445, 150, 35);
        a1.addActionListener(this);
        image.add(a1);
        a2 = new JButton(" 2000");
        a2.setBounds(355, 445, 150, 35);
        a2.addActionListener(this);
        image.add(a2);
        a3 = new JButton("5000");
        a3.setBounds(160, 485, 150, 35);
        a3.addActionListener(this);
        image.add(a3);
        a4 = new JButton("10000");
        a4.setBounds(355, 485, 150, 35);
        a4.addActionListener(this);
        image.add(a4);
        a5 = new JButton("15000");
        a5.setBounds(160, 525, 150, 35);
        a5.addActionListener(this);
        image.add(a5);
        a6 = new JButton("20000");
        a6.setBounds(355, 525, 150, 35);
        a6.addActionListener(this);
        image.add(a6);
        back = new JButton("Back");
        back.setBounds(355, 565, 150, 34);
        back.addActionListener(this);
        image.add(back);


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText();
            conn c = new conn();

            try {
                //this working is to check if user has sufficient balance
                ResultSet r = c.s.executeQuery("select * from Transact where pin = '"+pin+"'");
                int balance = 0;
                while (r.next()) {
                    if (r.getString("type").equals("deposit")) {
                        balance += Integer.parseInt(r.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(r.getString("amount"));
                    }
                }
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "You don't have sufficient balance ");
                    return;
                }else {
                    Date date = new Date();
                    String query = "insert into Transact values('" + pin + "','" + date + "','withdraw','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Amount withdrawn successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }


    }
    public static void main(String[] args) {
        new Fastcash("");

    }
}


