package pbo.f01.model;

import javax.persistence.*;
import java.util.Set;

/**
 * @author 12S22002 - Jeremy Nainggolan
 * @author 12S22049 - Agnes Harefa
 */

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column (name = "id", nullable = false, length = 255)
    private String id;
    @Column (name = "name", nullable = false, length = 255)
    private String name;
    @Column (name = "studentYear", nullable = false, length = 255)
    private String year;
    @Column (name = "gender", nullable = false, length = 255)
    private String gender;

    @OneToOne(mappedBy = "students", cascade = CascadeType.ALL)
    private Set<Dorm> dorms;

    public Student() {
        // default constructor
    }

    public Student(String id, String name, String year, String gender) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Dorm> getDorms() {
        return dorms;
    }

    public void setDorms(Set<Dorm> dorms) {
        this.dorms = dorms;
    }

    @Override
    public String toString() {
        return getId() + "|" + getName() + "|" + getYear() + "|" + getGender();
    }

}
