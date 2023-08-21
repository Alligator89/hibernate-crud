package com.tms.repository;

import com.tms.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    public final SessionFactory sessionFactory;

    public StudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Student findById(int id) {
        Student student = null;
        Session session = sessionFactory.openSession();
        Query<Student> query = session.createQuery("FROM students s WHERE s.id=: studentsId", Student.class);
        query.setParameter("studentsId", id);
        List<Student> resultList = query.getResultList();
        session.close();

        if (resultList != null && !resultList.isEmpty()) {
            student = resultList.get(0);
        }
        return student;
    }

    public List<Student> findAll() {
        Session session = sessionFactory.openSession();
        Query<Student> query = session.createQuery("FROM students ", Student.class);
        List<Student> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    public void save(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
        System.out.println();
    }

    public void updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        Query<Student> query = session.createQuery("UPDATE students SET name=:name," +
                " surName=:surName, age=:age, group=:groupNumber, averageMark=:averageMark WHERE id=:id");
        query.setParameter("id", student.getId());
        query.setParameter("name", student.getName());
        query.setParameter("surName", student.getSurName());
        query.setParameter("age", student.getAge());
        query.setParameter("groupNumber", student.getGroup());
        query.setParameter("averageMark", student.getAverageMark());

        session.beginTransaction();
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Student student) {
        Session session = sessionFactory.openSession();
        Query<Student> query = session.createQuery("DELETE students WHERE id=:id");
        query.setParameter("id", student.getId());

        session.beginTransaction();
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}

