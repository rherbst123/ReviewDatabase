/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package roosevelt.herbst.homework3yaya.review.reviewstuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Random;

/**
 * Renamed PopulateDBFixedBetter (MySQLTest) to PopulateDB
 * @author mruth
 */
public class PopulateDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            Connection conn = DriverManager.getConnection (
            "jdbc:mysql://localhost:3306/herbst",
            "user", "user");
            
            
            
    
     
           
            
            
            
            String[] fnames = {"Carter","Riley","Austin","Bryan",
            "Jacob","Jake","John","Nick","Jasmine","Zach"};
            
            String[] lnames = {"Shimp","Herbst","Zepeda","Tamayo",
            "Rawle","Gartung","Harker","Frieders","Dwyer","Herbst"};
            
            
        
            String[] titles = {"Django Unchained","Wolf of wall street","No country for old men","Interstellar",
            "Fantastic Mr.Fox","Die Hard","Harry Potter","Star Wars","Stalker","Breaking Bad"};
        
            String[] reviewBody = {"Abomination","Shit","Less Shit","Bad","Mid","not bad","alright","good","great","amazing"};
            
        
            
            Random random = new Random();
            
            int count = 5000;
            
            
            while (count > 0) {
                //need 7 digit number for reviewID
                int rid = random.nextInt(8999999) + 1000000;
                double stars = (double)random.nextInt(5);
                if (random.nextBoolean()) {
                    stars = stars + .5;
                }
                
               
                String name = lnames[random.nextInt(lnames.length)] + ", ";
                name = name + fnames[random.nextInt(fnames.length)];
                
                String title = titles[random.nextInt(titles.length)] + " ";
                
                
             
                //I just wanted the stars to match bodies :)
                int index = (int)(stars*2);
                String body = reviewBody[index];
                
             
                
                String sql = "INSERT INTO REVIEW VALUES ('";
                sql = sql + rid + "',";
                sql = sql + "'" + title + "',";
                sql = sql + "'" + body + "',";
                sql = sql + "'" + name + "',";
                sql = sql + stars + ")";
                System.out.println(sql);  
                
                try {
                    conn.createStatement().execute(sql);
                    count--;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
                
                
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
