package com.company.labTasks;
import com.company.Connection.JDBC;
import java.sql.*;
import java.util.*;


public class Query2
{
    public static void main(String[] args)  {
        Statement stmt = null;
        Scanner scanner =new Scanner(System.in);
        try{
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String query2Author = "SELECT * FROM titles where titles.publisherID=";
            System.out.println("Enter id of publisher to see its titles:");
            query2Author+= scanner.next();
            ResultSet rs1 = stmt.executeQuery(query2Author);
            while (rs1.next()) {
                int isbn = rs1.getInt("isbn");
                String title = rs1.getString("titile");
                int editionNumber = rs1.getInt("editionNumber");
                String year = rs1.getString("year");
                int publisherID = rs1.getInt("publisherID");
                float price=rs1.getFloat("price");
                System.out.println(isbn +"\t" + title+"\t" + editionNumber+"\t" + year+"\t" + publisherID+"\t" + price);
            }
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}



