package pbo.f01.controller;

import javax.persistence.EntityManager;

import pbo.f01.model.Input;
import pbo.f01.repository.DormRepository;
import pbo.f01.repository.StudentRepository;

/**
 * @author 12S22002 - Jeremy Nainggolan
 * @author 12S22049 - Agnes Harefa
 */

public class Dormy {

    public void run(EntityManager _entityManager) {
        boolean isRunning = true;
        cleanDB(_entityManager);

        while (isRunning) {
            String input = Input.input();
            String[] inputArray = input.split("#");
            String command = inputArray[0];

            switch (command) {
                case "---":
                    isRunning = false;
                    break;
                case "student-add":
                    StudentRepository.add(inputArray[1], inputArray[2], inputArray[3], inputArray[4], _entityManager);
                    break;
                case "dorm-add":
                    DormRepository.add(inputArray[1], Integer.parseInt(inputArray[2]), inputArray[3], _entityManager);
                    break;
                case "assign":
                    DormRepository.assign(inputArray[1], inputArray[2], _entityManager);
                    break;
                case "display-all":
                    DormRepository.display(_entityManager);
                    break;
            }
        }
        _entityManager.close();
    }

    protected void cleanDB(EntityManager _entityManager) {
        String[] jpqa = {"DELETE FROM Dorm d", "DELETE FROM Student s"};

        for (String query : jpqa) {
            System.out.println(query);
            _entityManager.getTransaction().begin();
            _entityManager.createQuery(query).executeUpdate();
            _entityManager.flush();
            _entityManager.getTransaction().commit();
        }
    }
}
