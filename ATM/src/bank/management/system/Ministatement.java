package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ministatement extends JFrame {
    String pin;
    Ministatement(String pin){
        this.pin=pin;
        setLayout(null);
        setTitle("STATEMENT");
        JLabel text=new JLabel("BANK");
        text.setBounds(220,30,200,50);
        text.setForeground(Color.black);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        add(text);
        JLabel statement=new JLabel();
        statement.setBounds(20,100,400,300);
        statement.setForeground(Color.black);
        statement.setFont(new Font("Raleway",Font.BOLD,12));
        add(statement);


        conn c=new conn();

        try {
            ResultSet r = c.s.executeQuery("select * from Transact where pin='" + pin + "'");
            while(r.next()){
                statement.setText(statement.getText() +"<html>"+"Date:"+r.getString("date")+"  "+r.getString("type")+"  "+"Amount: "+r.getString("amount")+"<br><br><html>");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        int bal = 0;
        try {
            ResultSet r = c.s.executeQuery("select * from Transact where pin='" + pin + "'");
            while(r.next()){
                if (r.getString("type").equals("deposit")) {
                    bal += Integer.parseInt(r.getString("amount"));
                } else {
                    bal -= Integer.parseInt(r.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        JLabel balance=new JLabel("Your remaining balance is:"+bal);
        balance.setBounds(200,500,600,40);
        balance.setForeground(Color.blue);
        balance.setFont(new Font("Raleway",Font.BOLD,16));
        add(balance);






        setSize(500,600);
        setLocation(300,0);
        setVisible(true);


    }
    public static void main(String[] args) {
        new Ministatement("");

    }

}
