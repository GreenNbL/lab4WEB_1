package com.company.Query;
import  com.company.Connection.JDBC;
import com.company.labTasks.Author;

import java.sql.*;
import java.util.*;


public class Query3
{
    public static void main(String[] args)  {
        Statement stmt = null;
        ArrayList<Author> authors= new ArrayList<Author>();
        Author author= null;
        try{

            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String query3Author = "SELECT * FROM authors";
            System.out.println("Show all authors");
            ResultSet rs1 = stmt.executeQuery(query3Author);
            while (rs1.next()) {
                author=new Author();
                author.setId( rs1.getInt("authorID"));
                author.setFirstName( rs1.getString("firstName"));
                author.setSecondName(rs1.getString("lastName"));
                authors.add(author);
            }
            Collections.sort(authors,new Comparator<Author>() {
                public int compare(Author author1, Author author2) {
                    return author1.getFirstName().compareTo(author2.getFirstName());
                }
            });
            for(Author a: authors)
            {
                System.out.println(a.toString());
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



