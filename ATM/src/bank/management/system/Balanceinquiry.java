package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balanceinquiry extends JFrame implements ActionListener {
    String pin;
    JButton back;
    Balanceinquiry(String pin) {
        this.pin=pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 970, getIconImage().SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 970);
        add(image);

        conn c=new conn();
        int balance = 0;
        try {
            ResultSet r = c.s.executeQuery("select * from Transact where pin='" + pin + "'");
            while(r.next()){
                if (r.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(r.getString("amount"));
                } else {
                    balance -= Integer.parseInt(r.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text=new JLabel("Your current balance is: "+balance);
        text.setBounds(220,330,700,40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        back=new JButton("Back");
        back.setBounds(355,525,150,35);
        back.addActionListener(this);
        image.add(back);




        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);




    }

    public static void main(String[] args) {
        new Balanceinquiry("");



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
}
