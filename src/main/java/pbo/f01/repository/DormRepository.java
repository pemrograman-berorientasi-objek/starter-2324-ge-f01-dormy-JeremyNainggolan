package pbo.f01.repository;

import javax.persistence.EntityManager;
import java.util.*;
import pbo.f01.model.*;

/**
 * @author 12S22002 - Jeremy Nainggolan
 * @author 12S22049 - Agnes Harefa
 */

public class DormRepository {

    static int count = 0;

    public static void add(String _name, int _capacity, String _gender, EntityManager _entityManager) {
        Dorm dorm = new Dorm(_name, _capacity, _gender);

        _entityManager.getTransaction().begin();
        _entityManager.persist(dorm);
        _entityManager.flush();
        _entityManager.getTransaction().commit();
    }

    public static void assign(String _studentId, String _dormName, EntityManager _entityManager) {
        Student student = _entityManager.find(Student.class, _studentId);
        Dorm dorm = _entityManager.find(Dorm.class, _dormName);

        if (dorm.getCapacity() >= dorm.getTotalStudent()) {
            dorm.setTotalStudent(count++);
            if (student != null && dorm != null) {
                _entityManager.getTransaction().begin();
                student.getDorms().add(dorm);
                dorm.getStudents().add(student);
    
                _entityManager.merge(student);
                _entityManager.merge(dorm);
                _entityManager.flush();
                _entityManager.getTransaction().commit();
            }
        }
    }

    public static void display(EntityManager _entityManager) {
        String jpqa = "SELECT d FROM Dorm d ORDER BY d.name";
        List<Dorm> dorms = _entityManager.createQuery(jpqa, Dorm.class).getResultList();
        for (Dorm dorm : dorms) {
            System.out.println(dorm);
            Set<Student> students = new TreeSet<Student>(Comparator.comparing(Student::getId));
            students.addAll(dorm.getStudents());
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
