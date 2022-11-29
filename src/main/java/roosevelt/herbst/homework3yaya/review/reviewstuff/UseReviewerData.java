/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package roosevelt.herbst.homework3yaya.review.reviewstuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mruth
 */
public class UseReviewerData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
            Connection conn = DriverManager.getConnection (
            "jdbc:mysql://localhost:3306/herbst",
            "user", "user");
            
            
            String sql = "SELECT COUNT(*) FROM REVIEW WHERE REVIEWID = 7777777";
            
            ResultSet rs = conn.createStatement().executeQuery(sql);
            rs.next();
            int num = rs.getInt(1);
            if (num > 0) {
                System.out.println("Review ID 7777777 was found");
            } else {
                System.out.println("Review ID 7777777 was NOT found");
            }
            System.out.println("");
            //part II
            
            
            //I commented it out bc mine returned 3000+ rows...
            sql = "SELECT REVIEWID, TITLE, REVIEWER FROM REVIEW WHERE STARS < 3";
            //execute query
            rs = conn.createStatement().executeQuery(sql);
            
            boolean first = true;
            //loop through rs
            while (rs.next()) {
                //get the fields and print
                String rid = rs.getString("REVIEWID");
                String title = rs.getString("TITLE");
                String reviewer = rs.getString("REVIEWER");
                if (!first) {
                    System.out.println("---------------------------------------");
                } else {
                    first = false;
                }
                System.out.println("ID: " + rid);
                System.out.println("Title:" + title);
                System.out.println("Reviewer: " + reviewer);
                
            }
            
            //Part III"4
            String mytitle = "Fantastic Mr. Fox"; 
            //since I am updating the stars, going to 
            //also update the body (not necessary)
            String mybody = "amazing";
            
            sql = "UPDATE REVIEW SET STARS = 5, BODY='" + mybody + "' ";
            sql = sql + "WHERE TITLE='" + mytitle + "'";
            
            //it'll produce the same number everytime!
            num = conn.createStatement().executeUpdate(sql);
            System.out.println("We changed the reviews for " + num + " " + mytitle);
            System.out.println("");
            //PArt III.5
            //only works once :)
            sql = "DELETE FROM REVIEW WHERE REVIEWID < 5000000";
            //it'll produce the same number everytime!
            num = conn.createStatement().executeUpdate(sql);
            System.out.println("We deleted " + num + " reviews");
            System.out.println("");
            //Part III.6
            sql = "SELECT COUNT(*) FROM REVIEW";
            
            rs = conn.createStatement().executeQuery(sql);
            rs.next();
            num = rs.getInt(1);
            System.out.println("There are " + num + " reviews still in db");
            System.out.println("");
            
            
            
    }
    
}
