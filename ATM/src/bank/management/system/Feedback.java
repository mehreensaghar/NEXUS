package bank.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class Feedback extends JFrame implements ActionListener {
    String pin;
    JButton[] stars;
    JButton[] stars1;
    JButton sendmoney, bills, ATM, home, done, cancel, exit;
    ImageIcon i33, i333;
    JTextField fb;
    int rating = 0;

    Feedback(String pin) {
        this.pin = pin;
//header
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pruple.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(400, 100, getIconImage().SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 400, 50);
        add(image);
        JLabel header = new JLabel("Feedback");
        header.setForeground(Color.white);
        header.setFont(new Font("Graphik", Font.PLAIN, 16));
        header.setBounds(10, 0, 400, 50);
        image.add(header);//we are using image obj so that text is added on the image not the frame


        //Main

        JLabel prompt = new JLabel("How would you rate your experience");
        prompt.setForeground(Color.white);
        prompt.setFont(new Font("Graphik", Font.PLAIN, 17));
        prompt.setBounds(40, 40, 300, 100);
        add(prompt);

        // Star Rating
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/star_empty.png"));
        Image i22 = i11.getImage().getScaledInstance(70, 70, getIconImage().SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icons/star_filled.png"));
        Image i222 = i111.getImage().getScaledInstance(70, 70, getIconImage().SCALE_DEFAULT);
        ImageIcon i333 = new ImageIcon(i222);


        stars = new JButton[5];
        for (int i = 0; i < 5; i++) {
            stars[i] = new JButton(i33);
            stars[i].setBounds(20 + i * 70, 130, 70, 70);
            stars[i].setOpaque(false);
            stars[i].setContentAreaFilled(false);
            stars[i].setBorderPainted(false);
            stars[i].addActionListener(this);
            add(stars[i]);
        }


        fb = new JTextField();
        fb.setBounds(20, 235, 350, 200);
        fb.setForeground(Color.black);
        fb.setBackground(Color.lightGray);
        fb.getCursor();
        add(fb);

        JLabel prompt1 = new JLabel("We always like to grow!");
        prompt1.setForeground(new Color(255, 165, 0));
        prompt1.setFont(new Font("Sans", Font.PLAIN, 17));
        prompt1.setBounds(90, 430, 300, 50);
        add(prompt1);


        //buttons

        //exit
        ImageIcon i111111111 = new ImageIcon(ClassLoader.getSystemResource("icons/logout.png"));
        Image i2222222 = i111111111.getImage().getScaledInstance(33, 33, getIconImage().SCALE_DEFAULT);
        ImageIcon i333333333 = new ImageIcon(i2222222);
        JLabel image6 = new JLabel(i333333333);
        image6.setBounds(350, 10, 33, 33);
        image.add(image6);
        exit = new JButton();
        exit.setBounds(350, 10, 40, 40);
        exit.setForeground(Color.WHITE);
        exit.setBorder(BorderFactory.createBevelBorder(2, Color.cyan, Color.black));
        exit.addActionListener(this);
        image.add(exit);
        //home
        ImageIcon i1111111111 = new ImageIcon(ClassLoader.getSystemResource("icons/home.png"));
        Image i222222222 = i1111111111.getImage().getScaledInstance(40, 40, getIconImage().SCALE_DEFAULT);
        ImageIcon i3333333333 = new ImageIcon(i222222222);
        JLabel image8 = new JLabel(i3333333333);
        image8.setBounds(300, 6, 40, 40);
        image.add(image8);
        home = new JButton();
        home.setBounds(300, 10, 40, 40);
        home.setForeground(Color.WHITE);
        home.setBorder(BorderFactory.createBevelBorder(2, Color.cyan, Color.black));
        home.addActionListener(this);
        image.add(home);
        //done
        done = new JButton("Submit");
        done.setForeground(new Color(255, 165, 0));
        done.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0)));
        done.setFont(new Font("san sarif", Font.ITALIC, 15));
        done.setBounds(200, 650, 200, 50);
        done.addActionListener(this);
        add(done);
        //next
        cancel = new JButton("Back");
        cancel.setForeground(Color.white);
        cancel.setBorder(BorderFactory.createLineBorder(Color.white));
        cancel.setFont(new Font("san sarif", Font.ITALIC, 15));
        cancel.setBounds(0, 650, 200, 50);
        cancel.addActionListener(this);
        add(cancel);


        //framework
        setLayout(null);
        setSize(400, 700);//size of the frame
        setLocation(900, 150);//by default frame is on top left corner so we set loc to center
        setUndecorated(true);
        getContentPane().setBackground(Color.black);
        setVisible(true);//to see the frame


    }

    public static void main(String[] args) {
        new Feedback("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String fbt = fb.getText();


        for (int i = 0; i < 5; i++) {
            if (ae.getSource() == stars[i]) {
                rating = i + 1;
                for (int j = 0; j <= i; j++) {
                    stars[j].setIcon(i333);
                }
                for (int j = i + 1; j < 5; j++) {
                    stars[j].setIcon(i33);
                }
            }
        }

        if (ae.getSource() == exit) {
            JOptionPane.showMessageDialog(null, "LOG OUT");
            System.exit(0);


        } else if (ae.getSource() == done) {
            try {

                if (fbt.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter a feedback");
                    new Feedback(pin).setVisible(true);

                }
                if (fbt.length() > 120) {
                    JOptionPane.showMessageDialog(null, "Word limit exceeded");
                    new Feedback(pin).setVisible(true);
                } else {
                    conn c = new conn();
                    String query = "insert into feedback values('" + pin + "','" + rating + "','" + fbt + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Thankyou for the feedback!!");
                    setVisible(false);
                    new Mainpage(pin).setVisible(true);

                }


            } catch (Exception e) {
                System.out.println(e);
            }


        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Mainpage(pin).setVisible(true);

        } else if (ae.getSource() == home) {
            setVisible(false);
            new Mainpage(pin).setVisible(true);
        }
    }
}

