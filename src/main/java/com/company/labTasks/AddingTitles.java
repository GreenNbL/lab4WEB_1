package com.company.labTasks;

import com.company.Connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddingTitles {
    public static void main(String[] argv) {
        updateTables();
    }
    public static void updateTables(){
        try{
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();
            updateTitlesTable(stmt);
        }catch(SQLException e)
        {
            System.out.println("Connection Failde!");
            e.printStackTrace();
            return;
        }
        JDBC.close();
    }
    private static void updateTitlesTable(Statement stmt) {
        Scanner n = new Scanner(System.in);
        System.out.println("Enter isbn");
        int isbn7 = n.nextInt();
        System.out.println("Enter title");
        String title7 = n.next();
        System.out.println("Enter edition number");
        int en7 = n.nextInt();
        System.out.println("Enter year");
        int year7 = n.nextInt();
        System.out.println("Enter publisher name");
        String name7 = n.next();
        System.out.println("Enter price");
        float price7 = n.nextFloat();
        String updatePublishersTable="INSERT INTO Titles (isbn, title, editionNumber, year, publisherID, price)"
                + "VALUES ('" + isbn7 + "', '" + title7 + "', " + en7 + ",'" + year7 + "',"
                + "(SELECT publisherID FROM publishers WHERE publisherName = '" + name7 + "')"
                + "," + price7 + ");";
        try {
            stmt.executeUpdate(updatePublishersTable);
        } catch (SQLException e) {
            System.out.println("Problem of adding");
            throw new RuntimeException(e);
        }
    }
}
