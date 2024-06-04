package bank.management.system;
//jdbc(java database connection)
//register the driver
//create connection
//create statement
//execute query
//close connection
import java.sql.*;


public class conn {
    //creating connection using conection class
    Connection c;
    Statement s;


    public conn(){
        try{

            c=DriverManager.getConnection("jdbc:mysql:///ATMSYSTEM","root","kimnamjoon");
            s=c.createStatement();


        }catch(Exception e){
            System.out.println(e);
        }

    }

}
