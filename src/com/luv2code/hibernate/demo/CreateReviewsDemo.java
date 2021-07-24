package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;

public class CreateReviewsDemo {
    public static void main(String[] args) throws ParseException {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            int id = 10;
            Course tempCourse=session.get(Course.class,id);
            Review review = new Review("Wonderful");
            Review  review1 = new Review("Amazing");
          tempCourse.addReview(review);
          tempCourse.addReview(review1);
         session.save(review);
         session.save(review1);

            session.getTransaction().commit();

        }finally {
            session.close();
        }
    }
}
