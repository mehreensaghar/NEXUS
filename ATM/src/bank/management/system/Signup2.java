package bank.management.system;
        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;




public class Signup2 extends JFrame implements ActionListener {
 String formno,name,fname;
    JTextField pantf,occupationtf;
    JRadioButton yes,no,yes1,no1;
    JComboBox reldd,catdd,edudd,incomedd;

    Signup2(String formno,String name,String fname ){
        this.formno= formno;
        this.name=name;
        this.fname=fname;
        setLayout(null);

        JLabel personeldetails=new JLabel("Page 2: Additional Details");
        personeldetails.setBounds(275,60,400,30);
        personeldetails.setFont(new Font("Raleway",Font.BOLD,20));
        personeldetails.setForeground(Color.WHITE);
        add(personeldetails);

        JLabel religion=new JLabel("Religion:");
        religion.setBounds(100,150,400,30);
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setForeground(Color.WHITE);
        add(religion);
        //Jcombo is used to make dropdowns list
        String valreligion[]={"Muslim","Christian","Hindu","Sikh","Other"};
        reldd=new JComboBox(valreligion);
        reldd.setBounds(300,150,400,30);
        add(reldd);


        JLabel category=new JLabel("Category:");
        category.setBounds(100,200,400,30);
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setForeground(Color.WHITE);
        add(category);
        String valcategory[]={"General","OBC","SC","ST","Other"};
        catdd=new JComboBox(valcategory);
        catdd.setBounds(300,200,400,30);
        add(catdd);

        JLabel income=new JLabel("Income:");
        income.setBounds(100,250,400,30);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setForeground(Color.WHITE);
        add(income);
        String valincome[]={"<1,50,000","<2,50,000","<3,,50,000","<5,00,000","Other"};
        incomedd=new JComboBox(valincome);
        incomedd.setBounds(300,250,400,30);
        add(incomedd);


        JLabel edu=new JLabel("Educational");
        edu.setBounds(100,290,400,20);
        edu.setFont(new Font("Raleway",Font.BOLD,18));
        edu.setForeground(Color.WHITE);
        add(edu);
        JLabel qual=new JLabel("qualification:");
        qual.setBounds(100,310,400,20);
        qual.setFont(new Font("Raleway",Font.BOLD,18));
        qual.setForeground(Color. WHITE);
        add(qual);
        String valedu[]={"Pre-Graduate","","Post-Graduate","MS","Other"};
        edudd=new JComboBox(valedu);
        edudd.setBounds(300,300,400,30);
        add(edudd);


        JLabel occupation=new JLabel("Occupation:");
        occupation.setBounds(100,350,400,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setForeground(Color.WHITE);
        add(occupation);
        occupationtf=new JTextField();
        occupationtf.setBounds(300,350,400,30);
        occupationtf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(occupationtf);

        JLabel pan=new JLabel("PAN Number:");
        pan.setBounds(100,400,400,30);
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setForeground(Color.WHITE);
        add(pan);
        pantf=new JTextField();
        pantf.setBounds(300,400,400,30);
        pantf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pantf);


        JLabel seniorcitizen=new JLabel("Senior Citizen:");
        seniorcitizen.setBounds(100,450,400,30);
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorcitizen.setForeground(Color.WHITE);
        add(seniorcitizen);
        yes=new JRadioButton("Yes");
        yes.setBounds(300,450,200,30);
       yes.setForeground(Color.WHITE);
        add(yes);
        no=new JRadioButton("No");
        no.setBounds(500,450,200,30);
        no.setForeground(Color.WHITE);
        add(no);
        ButtonGroup senior=new ButtonGroup();
        senior.add(yes);
        senior.add(no);


        JLabel EA=new JLabel("Existing account:");
        EA.setBounds(100,500,400,30);
        EA.setFont(new Font("Raleway",Font.BOLD,20));
        EA.setForeground(Color.white);
        add(EA);
        yes1=new JRadioButton("Yes");
        yes1.setBounds(300,500,200,30);
        yes1.setForeground(Color.WHITE);
        add(yes1);
        no1=new JRadioButton("No");
        no1.setBounds(500,500,200,30);
        no1.setForeground(Color.WHITE);
        add(no1);
        ButtonGroup acc=new ButtonGroup();
        acc.add(yes1);
        acc.add(no1);

        JButton next=new JButton("Next");
        next.setForeground(Color.white);
        next.setBorder(BorderFactory.createLineBorder(Color.white));
        next.setFont(new Font("san sarif",Font.ITALIC,15));
        next.setBounds(600,660,100,30);
        next.addActionListener(this);
        add(next);

        setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");
        setSize(850,800);
        setLocation(200,10);
        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);








    }
    public void actionPerformed(ActionEvent ae) {
        //we need value to enter the database so when action is performed we assigned user entered values in var to later store in db
        String religion=(String) reldd.getSelectedItem();
        String category=(String) catdd.getSelectedItem();
        String income=(String) incomedd.getSelectedItem();
        String education=(String) edudd.getSelectedItem();
        String occupation=occupationtf.getText();
        String pan=pantf.getText();
        String senior=null;
        if(yes.isSelected()){
            senior="Yes";
        } else if (no.isSelected()) {
            senior="No";
        }
        String EA=null;
        if(yes1.isSelected()){
            senior="Yes";
        } else if (no1.isSelected()) {
            senior="No";
        }

        try{
            conn c=new conn();
            String query="insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+senior+"','"+EA+"')";
            c.s.executeUpdate(query);

          setVisible(false);
          new Signup3(formno,name,fname).setVisible(true);




        }catch(Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[]args){
        new Signup2(" ","","");

    }
}

