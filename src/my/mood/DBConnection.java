package my.mood;

import java.sql.*;

public class DBConnection {

    Connection c;
    Statement s;

    public DBConnection(){

        try{
            c = DriverManager.getConnection("jdbc:mysql:///travel_tourismmanagementsystem", "root", "Shrunal#2383");
            s = c.createStatement();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
}
