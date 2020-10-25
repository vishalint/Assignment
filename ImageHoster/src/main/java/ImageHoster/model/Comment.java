package ImageHoster.model;

import javax.persistence.*;

//import java.time.LocalDate;
import java.util.Date;


@Entity
//@Table annotation provides more options to customize the mapping.
//Here the name of the table to be created in the database is explicitly mentioned as 'comments'. Hence the table named 'comments' will be created in the database with all the columns mapped to all the attributes in 'comments' class
@Table(name = "comments")
public class Comment {

    // @Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column annotation specifies that the attribute will be mapped to the column
    // in the database.
   
    @Column(name = "id")
    private Integer id;

   
    // this is a comment text
    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(name = "createdDate")
    private Date createdDate;

    // The 'comments' table is mapped to 'users' table with Many:One mapping
    // FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    // Below annotation indicates that the name of the column in 'comments' table
    // referring the primary key in 'users' table will be 'user_id'
    @JoinColumn(name = "user_id")
    private User user;

  
    // Since the mapping is Many to Many, a new table will be generated containing
    // the two columns both referencing to the primary key of both the tables
    // ('images', 'comments')
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
