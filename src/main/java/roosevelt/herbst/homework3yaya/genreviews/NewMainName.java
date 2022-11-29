/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package roosevelt.herbst.homework3yaya.genreviews;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author riley
 */
public class NewMainName {

  
      public static void main(String[] args) throws SQLException {
       Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/herbst",
            "user", "user");
        
        //sql string
        String sql = "SELECT * FROM REVIEW ORDER BY TITLE";
        //get rs
        ResultSet rs = conn.createStatement().executeQuery(sql);
        //get to the first row
        while (rs.next()) {
            //create table row
            System.out.println("<tr>");
            //create a td for each element
            System.out.println("<td>" + rs.getString("reviewid") + "</td>");
            System.out.println("<td>" + rs.getString("title") + "</td>");
            System.out.println("<td>" + rs.getString("body") + "</td>");
            System.out.println("<td>" + rs.getString("reviewer") + "</td>");
            System.out.println("<td>" + rs.getDouble("stars") + "</td>");
            
            //close table row
            System.out.println("</tr>");
            
                
        }
        
            
    
    }
    }
    

