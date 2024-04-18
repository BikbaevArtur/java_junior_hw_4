package ru.bikbaev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.bikbaev.model.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
Убедитесь, что каждая операция выполняется в отдельной транзакции.
 */

public class Main {
    public static void main(String[] args) throws SQLException {

        //dropTable();


        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        try (Session session = sessionFactory.getCurrentSession()) {

            Course course = new Course("Робототехника", "5 занятий");
            session.beginTransaction();


            session.save(course);
            System.out.println("object save database");

            Course course1 = session.get(Course.class, 1);
            System.out.println("Object read database");
            System.out.println(course1);

            course1.setDuration("10 занятий");
            session.update(course1);
            System.out.println("Object update");


            session.delete(course1);
            System.out.println("Object delete");


            session.getTransaction().commit();


        }
    }

    public static void dropTable() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SchoolDB", "root", "root");
        PreparedStatement preparedStatement = connection.prepareStatement("DROP TABLE Course");
        preparedStatement.execute();
        connection.close();
    }


}