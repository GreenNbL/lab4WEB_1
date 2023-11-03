package com.company.labTasks;

import com.company.Connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddingISBN {
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
        int isbn72 = n.nextInt();
        System.out.println("Enter authors first name");
        String fname72 = n.next();
        System.out.println("Enter authors last name");
        String lname72 = n.next();
        String updatePublishersTable="INSERT INTO authorisbn (authorID, isbn)" +
                "VALUES (" +
                "(SELECT authorID FROM authors WHERE firstName = '" + fname72 + "' AND lastName = '" + lname72 + "')" +
                ", '" + isbn72 + "')";
        try {
            stmt.executeUpdate(updatePublishersTable);
        } catch (SQLException e) {
            System.out.println("Problem of adding");
            throw new RuntimeException(e);
        }
    }
}
