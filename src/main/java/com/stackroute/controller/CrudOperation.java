package com.stackroute.controller;
import org.springframework.stereotype.Component;
import java.sql.*;

@Component
public class CrudOperation {
private Connection con;

    public void displayData() {
        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1","uday","uday123");
            //create statement object
            System.out.println("got connected");

            Statement stmt=con.createStatement();


            //execute query
            ResultSet rs=stmt.executeQuery("select * from customers");
            //process result
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2));

        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void displayCustomrerByName(String name) {

        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1","uday","uday123");
            //create statement object
            System.out.println("got connected");

            PreparedStatement stmt=con.prepareStatement("Select * from customers where id=? and name = ?");
            stmt.setInt(1,3);
            stmt.setString(2,name);
            ResultSet rs = stmt.executeQuery();
            //execute query
          //  ResultSet rs=stmt.executeQuery("select * from customers");
            //process result
            while(rs.next())
                System.out.println("ID "+rs.getInt(1)+"  "+rs.getString(2));
            con.close();
        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void insertCustomer(String username, String password) {

        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db11 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db11","uday","uday123");
            //create statement object
            System.out.println("got connected");

            PreparedStatement stmt=con.prepareStatement("insert into customers (username,password) values (?,?)");
            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.executeUpdate();
            //execute query
            //  ResultSet rs=stmt.executeQuery("select * from customers");
            //process result
//            while(rs.next())
//                System.out.println("ID "+rs.getInt(1)+"  "+rs.getString(2));
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                con.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
     }
 }
