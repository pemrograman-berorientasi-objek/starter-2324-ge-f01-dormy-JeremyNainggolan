package pbo.f01.model;

import javax.persistence.*;
import java.util.Set;

/**
 * @author 12S22002 - Jeremy Nainggolan
 * @author 12S22049 - Agnes Harefa
 */

@Entity
@Table(name = "dorm")
public class Dorm {
    @Id
    @Column(name = "name", length = 255)
    private String name;
    @Column(name = "capacity", nullable = false, length = 255)
    private int capacity;
    @Column(name = "gender", nullable = false, length = 255)
    private String gender;
    @Column(name = "totalStudent", length = 255)
    private int totalStudent = 0;

    @OneToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
    private Set<Student> students;

    public Dorm() {
        // default constructor
    }

    public Dorm(String _name, int _capacity, String _gender) {
        this.name = _name;
        this.capacity = _capacity;
        this.gender = _gender;
    }

    public int getTotalStudent() {
        return this.totalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public Set<Student> getStudents() {
        return students;
    }
    
    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return name + "|" + capacity + "|" + gender + "|" + totalStudent;
    }

}
