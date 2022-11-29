/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roosevelt.herbst.homework3yaya.review;

import java.sql.SQLException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mruth
 */
@RestController
public class ReviewController {
    
    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
    
    @Autowired
    ReviewRepository reviewService;
    
    //PI.1
    @GetMapping("/reviews")
    public ResponseEntity<Iterable<Review>> getAllReviews() throws SQLException {
        //get them from the repository
        Iterable<Review> reviews = reviewService.findAll();
        //return them
        return new ResponseEntity(reviews, HttpStatus.OK);
      
    }
    //PI.2
    @GetMapping("/reviews/{rid}")
    public ResponseEntity<Review> getReviewByReviewID(@PathVariable("rid") String rid) throws SQLException {
        //try to get the student
        Optional<Review> option = reviewService.findById(rid);
        
        //now the check
        if (option.isPresent()) {
             return new ResponseEntity(option.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
      
    }
    
    //PI.3
    @GetMapping("/reviews/byreviewer/{reviewer}")
    public ResponseEntity<Review> getReviewByReviewer(@PathVariable("reviewer") String reviewer) throws SQLException {
        //get them from the repository
        Iterable<Review> reviews = reviewService.findByReviewer(reviewer);
        //return them
        return new ResponseEntity(reviews, HttpStatus.OK);
      
    }
    
    //PI.4
    //note I put them before and after bystarsbtwn...  
    @GetMapping("/reviews/{low}/bystarsbtwn/{high}")
    public ResponseEntity<Review> getReviewByStarsRatingBetween(@PathVariable("low") double low,@PathVariable("high") double high) throws SQLException {
        //get them from the repository
        Iterable<Review> reviews = reviewService.findByStarsBetween(low, high);
        //return them
        return new ResponseEntity(reviews, HttpStatus.OK);
      
    }
    
    //PI.5
    @GetMapping("/reviews/searchfor/{search}")
    public ResponseEntity<Review> getReviewsContaining(@PathVariable("search") String contains) throws SQLException {
        //get them from the repository
        Iterable<Review> reviews = reviewService.findByTitleContainsOrBodyContains(contains, contains);
        //return them
        return new ResponseEntity(reviews, HttpStatus.OK);
      
    }
    
    
    @PostMapping(value = "/reviews", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Review> insertStudent(@RequestBody final Review review) {
        if (reviewService.existsById(review.getReviewid())) {
            //already there
            return new ResponseEntity(review,HttpStatus.FOUND);
        } else {
            //add it
            reviewService.save(review);
            return new ResponseEntity(review,HttpStatus.OK);
        }
        
    }
    
    @PutMapping(value = "/reviews", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Review> updateStudent(@RequestBody final Review review) throws SQLException {
        logger.info(review + "");
        //does it exist?
        if (reviewService.existsById(review.getReviewid())) {
            //update
            reviewService.save(review);
            //already there
            return new ResponseEntity(review,HttpStatus.OK);
        } else {
            //add it
            
            return new ResponseEntity(review,HttpStatus.NOT_FOUND);
        }
        
    }
    
    
    @DeleteMapping("/reviews/{rid}")
    public ResponseEntity<String> deleteStudent(@PathVariable("rid") String rid) throws SQLException {
        
        if (reviewService.existsById(rid)) {
            //delete it!
            reviewService.deleteById(rid);
            //return result
            return new ResponseEntity(rid, HttpStatus.OK);
        } else {
            //not there
            return new ResponseEntity(rid, HttpStatus.NOT_FOUND);
        }
        
        
    }
    
    
    
}
