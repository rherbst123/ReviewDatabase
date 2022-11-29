/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roosevelt.herbst.homework3yaya.review;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Note table name = class so nothing to do here...
 * @author mruth
 */
@Entity
public class Review implements Serializable{
    /*
    String sql = "CREATE TABLE REVIEW (";
            sql = sql + " REVIEWID VARCHAR(10) PRIMARY KEY,";
            sql = sql + " TITLE VARCHAR(20),";
            sql = sql + " BODY VARCHAR(20),";
            sql = sql + " REVIEWER VARCHAR(20),";
            sql = sql + " STARS DOUBLE)";
    */
    @Id
    @Positive
    @Size(min = 5, max = 5)
    @NotBlank(message = "You need an Id to be identified!")
    private String reviewid;
    @Size(min = 30, max = 50)
    @NotBlank(message = "You need a review!")
    private String body;
    @Size(min = 30, max = 50)
    @NotBlank(message = "Somebody has to review it!")
    private String reviewer;
    @Min(0)
    @Max(5)
    @Digits(integer= 1, fraction = 2)
    private double stars;

    @Override
    public String toString() {
        return "Review{" + "reviewid=" + reviewid + ", title=" + title + ", body=" + body + ", reviewer=" + reviewer + ", stars=" + stars + '}';
    }
    private String title;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.reviewid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Review other = (Review) obj;
        return Objects.equals(this.reviewid, other.reviewid);
    }

    public String getReviewid() {
        return reviewid;
    }

    public void setReviewid(String reviewid) {
        this.reviewid = reviewid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }
    
}
