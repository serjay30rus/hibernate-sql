package model;

import lombok.Data;
import model.Course;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
@Data
public class Subscription implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Student student;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @Override
    public String toString() {
        return "Subscription{" +
                "studentId=" + student.getId() +
                ", courseId=" + course.getId() +
                ", subscriptionDate=" + subscriptionDate +
                '}';
    }
}
