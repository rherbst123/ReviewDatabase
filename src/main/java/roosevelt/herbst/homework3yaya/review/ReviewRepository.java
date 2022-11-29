/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roosevelt.herbst.homework3yaya.review;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mruth
 */
public interface ReviewRepository extends CrudRepository<Review, String> {
    
    List<Review> findByReviewer(String reviewer);
    List<Review> findByStarsBetween(double low, double high);
    List<Review> findByTitleContainsOrBodyContains(String contains, String alsocontains);
}
