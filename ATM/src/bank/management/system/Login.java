package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{

    //we are declaring buttons outside constructor so that we can use them in actionperform function
    JButton login,signup,changepass;
    JTextField card;
    JPasswordField textpin;
    JRadioButton remember;
    Login(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));// class image icon classloader has static method which check an address for ta image
        Image i2=i1.getImage().getScaledInstance(500,900,Image.SCALE_DEFAULT);//IMAGE CLASS To scale the image according to frame
        //we cannot use jlabel on image so we have to change image to imageicon
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        //now to set imageicon on the corner
      image.setBounds(0,0,400,700);
       setLayout(null);//jframe have default layout for labels so when we use a custom layout we have to null the orignal layout
       add(image);//adds object passed on the frame(picture)

        //fingerprinnt

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/fingerprint.jpg"));// class image icon classloader has static method which check an address for ta image
        Image i22=i11.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);//IMAGE CLASS To scale the image according to frame
        //we cannot use jlabel on image so we have to change image to imageicon
        ImageIcon i33=new ImageIcon(i22);
        JLabel label1 =new JLabel(i33);
        //now to set imageicon on the corner
        label1.setBounds(160,510,80,80);
        setLayout(null);//jframe have default layout for labels so when we use a custom layout we have to null the orignal layout
        image.add(label1);//adds object passed on the frame(picture)
// fingerprint
        JLabel f=new JLabel("Login with TouchID");
        f.setFont(new Font("sans-serif",Font.BOLD,15));
        f.setBounds(130,600,200,40);
        f.setForeground(new Color(102, 66, 0));
        image.add(f);
        //WELCOME
        JLabel text=new JLabel("NEXUS");
        text.setFont(new Font("Graphik",Font.BOLD,50));
        text.setBounds(120,150,200,40);
        text.setForeground(new Color(70, 29, 99));
        image.add(text);

        //cardno
        JLabel C=new JLabel("Username");
        C.setFont(new Font("Raleway",Font.BOLD,15));
        C.setBounds(30,230,100,20);
        C.setForeground(Color.black);
        image.add(C);

        card=new JTextField();
        card.setBounds(20,260,350,40);
        card.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(70, 29, 99)));
        card.setForeground(new Color(16, 8, 0));
        image.add(card);
        //pin
        JLabel pin=new JLabel("Password");
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        pin.setBounds(30,325,100,20);
        pin.setForeground(Color.black);
        image.add(pin);

        textpin =new JPasswordField();
        textpin.setBounds(20,350,350,40);
        textpin.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(70, 29, 99)));
        textpin.setForeground(new Color(16, 8, 0));
        image.add(textpin);
        changepass=new JButton("Change password");
        changepass.setBounds(200,395,150,30);
        changepass.setForeground(new Color(255, 165, 0));
        changepass.setBorder(BorderFactory.createBevelBorder(2,Color.cyan,Color.black));
        changepass.setFont(new Font("Raleway",Font.BOLD,15));
        changepass.addActionListener(this);
        image.add(changepass);

        //BUTTONS
        //remember
        remember=new JRadioButton("Remember Username");
        remember.setFont(new Font("Raleway",Font.BOLD,15));
        remember.setBounds(20,305,200,15);
        remember.setForeground(new Color(255, 165, 0));
        image.add(remember);
        //login
        login =new JButton("Login");
        login.setBounds(25,440,160,40);

        login.setBorder(BorderFactory.createLineBorder(Color.black));
        login.setBackground(new Color(189, 168, 168));
        login.addActionListener(this);
        image.add(login);
        //signup
        signup =new JButton("Sign Up");
        signup.setBounds(210,440,160,40);
        signup.setBackground(new Color(189, 168, 168));
        signup.setBorder(BorderFactory.createLineBorder(Color.black));
        signup.addActionListener(this);
        image.add(signup);




       //framework
        setSize(400,700);//size of the frame
        setLocation(900,150);//by default frame is on top left corner so we set loc to center
        setLayout(null);
        setUndecorated(true);
        setVisible(true);//to see the frame




    }
    //if we are implementing a interface we need to override the abstract methods(actionlistener interface)
    public void actionPerformed(ActionEvent ae){
        String pin = null;
        //getsource tells where the action is being performed so use obj of actionevent class to locate
      if(ae.getSource()==login){
            conn c=new conn();
            String cardno=card.getText();
           pin =textpin.getText();
            //select `* query will check or compare data from the database
            String query="select * from Login1 where cardnumber ='"+cardno+"' and pinnumber = '"+pin+"' ";
            try{
                ResultSet r=c.s.executeQuery(query);//type of data returned by database is resultset;
                if(r.next()){
                    //r.next will check if data exist
                    setVisible(false);
                    new Mainpage(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect card number or pin");
                }

            }catch(Exception e){
                System.out.println(e);
            }


        }
        else if ((ae.getSource()==signup)) {
            setVisible(false);
            new Signup1().setVisible(true);

        }
      else if ((ae.getSource()==changepass)) {
          setVisible(false);
          new changepassword(pin).setVisible(true);

      }


    }
    public static void main(String[]args){
       new Login();
    }
}
