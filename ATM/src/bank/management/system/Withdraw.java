package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JTextField amounttf;
    String pin;
    JButton withdraw,back;
    Withdraw(String pin) {
        this.pin=pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 970, getIconImage().SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 970);
        add(image);

        JLabel amount =new JLabel("Enter the amount you want to withdraw");
        amount.setBounds(185,330,600,40);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(amount);

        amounttf=new JTextField();
        amounttf.setBounds(185,370,305,30);
        amounttf.setForeground(Color.BLACK);
        amounttf.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(amounttf);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,485,150,35);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back=new JButton("Back");
        back.setBounds(355,525,150,35);
        back.addActionListener(this);
        image.add(back);




        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }






    public static void main(String[]args){
        new Deposit("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);

        } else if (ae.getSource() == withdraw) {
            String amount =""+ amounttf.getText();
            Date date=new Date();

            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter a amount");
            }else {
                try {
                    conn c = new conn();
                    String query = "insert into Transact values('"+pin+"','"+date+"','withdraw','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Amount withdrawn successfully");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);


                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
    }
}
