package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;



public class Signup1 extends JFrame implements ActionListener {
    long random;
    JTextField nametf,fnametf,emailtf,adtf,statetf,pintf,citytf;
    JButton next;
    JRadioButton male,female,married,single,divorced;
    JDateChooser dateChooser;
    Signup1(){
        setLayout(null);
        //making sign up frame

        //LABELS
        //we want random number form application form number so we use random and print it as label
        Random ran=new Random();
        random =Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel formno=new JLabel("APPLICATION FORM NO."+random);
        formno.setBounds(180,20,600,40);
        formno.setFont(new Font("Raleway",Font.BOLD,32));
        formno.setForeground(Color.white);
        add(formno);

        JLabel personeldetails=new JLabel("Page 1: Personal Details");
        personeldetails.setBounds(275,60,400,30);
        personeldetails.setFont(new Font("Raleway",Font.BOLD,20));
        personeldetails.setForeground(Color.white);
        add(personeldetails);

        JLabel name=new JLabel("Name:");
        name.setBounds(100,150,400,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setForeground(Color.white);
        add(name);
        nametf=new JTextField();
        nametf.setBounds(300,150,400,30);
        nametf.setBorder(BorderFactory.createLineBorder(Color.white));
        add(nametf);

        JLabel fname=new JLabel("Father's name:");
        fname.setBounds(100,190,400,30);
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setForeground(Color.white);
        add(fname);
        fnametf=new JTextField();
        fnametf.setBounds(300,190,400,30);
        fnametf.setBorder(BorderFactory.createLineBorder(Color.white));
        add(fnametf);

        JLabel dob=new JLabel("Date of birth:");
        dob.setBounds(100,230,400,30);
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setForeground(Color.white);
        add(dob);
        //we use calendar class
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,230,200,30);
        dateChooser.setBorder(BorderFactory.createLineBorder(Color.white));
        dateChooser.setForeground(Color.DARK_GRAY);
        add(dateChooser);

        JLabel gender=new JLabel("Gender:");
        gender.setBounds(100,270,400,30);
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setForeground(Color.white);
        add(gender);
        male=new JRadioButton("Male");
        male.setBounds(300,270,200,30);
        male.setForeground(Color.white);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(500,270,200,30);
        female.setForeground(Color.white);
        add(female);

        //we use this class so that both buttons cannot be selected at th e same time
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);





        JLabel email=new JLabel("Email address:");
        email.setBounds(100,310,400,30);
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setForeground(Color.white);
        add(email);
        emailtf=new JTextField();
        emailtf.setBounds(300,310,400,30);
        emailtf.setBorder(BorderFactory.createLineBorder(Color.white));
        add(emailtf);

        JLabel marital=new JLabel("Marital status:");
        marital.setBounds(100,350,400,30);
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setForeground(Color.white);
        add(marital);
        married=new JRadioButton("Married");
        married.setBounds(300,350,100,30);
        married.setForeground(Color.white);
        add(married);
        single=new JRadioButton("Single");
        single.setBounds(400,350,100,30);
        single.setForeground(Color.white);
        add(single);
        divorced=new JRadioButton("Divorced");
        divorced.setBounds(500,350,100,30);
        divorced.setForeground(Color.white);
        add(divorced);
        //we use this class so that both buttons cannot be selected at th e same time
        ButtonGroup statusgroup=new ButtonGroup();
        statusgroup.add(married);
        statusgroup.add(single);
        statusgroup.add(divorced);

        JLabel address=new JLabel("Address:");
        address.setBounds(100,390,400,30);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setForeground(Color.white);
        add(address);
        adtf=new JTextField();
        adtf.setBounds(300,390,400,30);
        adtf.setBorder(BorderFactory.createLineBorder(Color.white));
        add(adtf);

        JLabel city=new JLabel("City:");
        city.setBounds(100,430,400,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setForeground(Color.white);
        add(city);
        citytf=new JTextField();
        citytf.setBounds(300,430,400,30);
        citytf.setBorder(BorderFactory.createLineBorder(Color.white));
        add(citytf);

        JLabel state=new JLabel("State:");
        state.setBounds(100,470,400,30);
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setForeground(Color.white);
        add(state);
        statetf=new JTextField();
        statetf.setBounds(300,470,400,30);
        statetf.setBorder(BorderFactory.createLineBorder(Color.white));
        add(statetf);

        JLabel pincode=new JLabel("Pin code:");
        pincode.setBounds(100,510,400,30);
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setForeground(Color.white);
        add(pincode);
        pintf=new JTextField();
        pintf.setBounds(300,510,400,30);
        pintf.setBorder(BorderFactory.createLineBorder(Color.white));
        add(pintf);

        next=new JButton("Next");
        next.setForeground(Color.white);
        next.setBorder(BorderFactory.createLineBorder(Color.white));
        next.setFont(new Font("san sarif",Font.ITALIC,15));
        next.setBounds(600,660,100,30);
        next.addActionListener(this);
        add(next);

        setTitle("SIGN UP");
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.darkGray);








    }
    public void actionPerformed(ActionEvent ae){
        //we need value to enter the database so when action is performed we assigned user entered values in var to later store in db
        String formno=" "+random;
        String Name=nametf.getText();
        String fname=fnametf.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String email= emailtf.getText();
        String city=citytf.getText();
        String address=adtf.getText();
        String state=statetf.getText();
        String pin=pintf.getText();
        String gender=null;
        if (male.isSelected()){
            gender="Male";
        } else if (female.isSelected()) {
            gender="Female";

        }
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        } else if (single.isSelected()) {
            marital="Single";

        }else if(divorced.isSelected()){
            marital="Divorced";
        }

        try{
            if(Name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }else{
                conn c=new conn();
                //inset query stores data in database
                String query="insert into signup1 values('"+formno+"','"+Name+"','"+fname+"','"+dob+"','"+email+"','"+city+"','"+address+"','"+state+"','"+pin+"','"+gender+"','"+marital+"')";
                c.s.executeUpdate(query);

                //After data of user stores in db now i want to move to next page so
                //creating an object of signup2 class
                setVisible(false);
                new Signup2(formno,Name,fname).setVisible(true);



            }

        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[]args){
        new Signup1();

    }
}