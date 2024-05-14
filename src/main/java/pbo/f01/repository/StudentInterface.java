package pbo.f01.repository;

import javax.persistence.EntityManager;

public interface StudentInterface {
    static void add(String _id, String _name, String _entranceYear, String _gender, EntityManager _entityManager) {}
}
