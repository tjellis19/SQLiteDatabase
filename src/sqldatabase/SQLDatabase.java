/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLDatabase;

import java.sql.*;
        
/**
 *
 * @author tme5209
 */
public class SQLDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // setting up database connection
//            Class.forName("sqlite-jdbc-3.27.2.1.jar");
            Connection dbConnection = DriverManager.getConnection("jdbc:sqlite:sample.sqlite3", "app", "app");
            // test database query
            Statement stmt = dbConnection.createStatement();
            String testQuery = "SELECT * FROM CUSTOMER";
            ResultSet results;
            
            results = stmt.executeQuery(testQuery);
            
            while (results.next()) {
                System.out.println("Result: " + results.getString("NAME"));
            }
            // clean up
            results.close();
            stmt.close();
            dbConnection.close();
        }
        catch (SQLException e) {
            System.out.println("Cannot connect to database.\n" 
                    + e.getMessage());
        } 
//        catch (ClassNotFoundException e) {
//            System.out.println("Cannot create an instance of the database driver.\n" 
//                    + e.getMessage());
//        }
        
    }
    
}
