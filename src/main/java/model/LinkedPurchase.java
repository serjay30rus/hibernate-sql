package model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "LinkedPurchaseList")
@Data
public class LinkedPurchase implements Serializable {

    @Id
    @Column(name = "student_id")
    private int studentId;

    @Id
    @Column(name = "course_id")
    private int courseId;

    public LinkedPurchase() {};

    public LinkedPurchase(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}
