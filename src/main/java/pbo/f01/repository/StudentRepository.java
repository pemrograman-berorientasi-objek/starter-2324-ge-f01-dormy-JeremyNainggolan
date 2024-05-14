package pbo.f01.repository;

import javax.persistence.EntityManager;
import pbo.f01.model.Student;

/**
 * @author 12S22002 - Jeremy Nainggolan
 * @author 12S22049 - Agnes Harefa
 */

public class StudentRepository implements StudentInterface {

    public static void add(String _id, String _name, String _entranceYear, String _gender, EntityManager _entityManager) {
        Student checkStudent = _entityManager.find(Student.class, _id);

        if (checkStudent == null) {
            Student student = new Student(_id, _name, _entranceYear, _gender);
            _entityManager.getTransaction().begin();
            _entityManager.persist(student);
            _entityManager.flush();
            _entityManager.getTransaction().commit();
        }
    }
}
