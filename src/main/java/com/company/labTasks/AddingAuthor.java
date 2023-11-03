package com.company.labTasks;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddingAuthor {
    public static void main(String[] argv) {
        updateTables();
    }
    public static void updateTables(){
        try{
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();
            updatePublishersTable(stmt);
        }catch(SQLException e)
        {
            System.out.println("Connection Failde!");
            e.printStackTrace();
            return;
        }
        JDBC.close();
    }
    private static void updatePublishersTable(Statement stmt) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter first name:");
        String firstName = scanner.next();
        System.out.println("Enter second ame:");
        String secondName = scanner.next();
        int amount=1;
        try {
        String query2Author = "SELECT * FROM authors";
        ResultSet rs1 = stmt.executeQuery(query2Author);
        while (rs1.next()) {
            amount+=1;
        }
            String updatePublishersTable = "INSERT INTO authors (authorID, firstName,lastName)" + "VALUES (" + amount + ", '"
                    + firstName  + "','"+secondName+"')";
            stmt.executeUpdate(updatePublishersTable);
        } catch (SQLException e) {
            System.out.println("Problem of adding");
            throw new RuntimeException(e);
        }
    }
}

