/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package roosevelt.herbst.homework3yaya.review.reviewstuff;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * I actually just renamed SetupDB (MySQLTest) to InitDB
 * 
 * and changed the table/column names...
 * @author mruth
 */
public class InitDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Connection conn = DriverManager.getConnection (
            "jdbc:mysql://localhost:3306/herbst",
            "user", "user");
            
            //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
            System.out.println("If Table Exists... drop it like it's hot");
            try {
                
                String sql = "DROP TABLE REVIEW";
            
                conn.createStatement().execute(sql);
            
                System.out.println("Table Dropped!");
            } catch (Exception e) {
                System.out.println("Table Didn't Exist");
            }
            
            
           
            
            
            String sql = "CREATE TABLE REVIEW (";
            sql = sql + " REVIEWID VARCHAR(10) PRIMARY KEY,";
            sql = sql + " TITLE VARCHAR(200),";
            sql = sql + " BODY VARCHAR(200),";
            sql = sql + " REVIEWER VARCHAR(200),";
            sql = sql + " STARS DOUBLE)";
            
            
            
            conn.createStatement().execute(sql);
            System.out.println("Table REVIEW created!");
            System.out.println("DB Complete!");
            conn.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
