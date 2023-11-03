package com.company.labTasks;

import com.company.Connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;

public class AddingPublisher
{

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
        String publishers =  "DrugEpt" ;
        // reset the auto increment
        String updatePublishersTable = "INSERT INTO Publishers (publisherName)" + "VALUES ('" + publishers + "')";
        try {
            stmt.executeUpdate(updatePublishersTable);
        } catch (SQLException e) {
            System.out.println("Problem of adding");
            throw new RuntimeException(e);
        }
    }
}

