package com.company.labTasks;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateNameAuthor {
    public static void main(String[] argv) {
        updateTables();
    }
    public static void updateTables(){
        try{
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();
            updateAuthorTable(stmt);
        }catch(SQLException e)
        {
            System.out.println("Connection Failde!");
            e.printStackTrace();
            return;
        }
        JDBC.close();
    }
    private static void updateAuthorTable(Statement stmt) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter author id to change his first name:");
        int id = scanner.nextInt();
        System.out.println("Enter first name:");
        String name = scanner.next();
        try {
            String updatePublishersTable = "UPDATE authors SET firstName = '"+name+"' WHERE authorID = '"+id+"'";
            stmt.executeUpdate(updatePublishersTable);
        } catch (SQLException e) {
            System.out.println("Problem of adding");
            throw new RuntimeException(e);
        }
    }
}
