package pbo.f01.repository;

import javax.persistence.EntityManager;

public interface DormInterface {
    static void add(String _name, int _capacity, String _gender, EntityManager _entityManager) {}
    static void assign(String _studentId, String _dormName, EntityManager _entityManager) {}
    static void display(EntityManager _entityManager) {}
}
