package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String location;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "school_id")
    private Map<String,Student> students;

    public School(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addStudent(Student s) {
        if (students == null)
            students = new HashMap<>();
        students.put(s.getStudentId(),s);
    }

    @Override
    public String toString() {
        return "School\n" +
                "\tname='" + name + '\'' +
                "\n\tlocation='" + location + '\'' +
                "\n\tstudents=\n\t\t" + students;
    }

    public void removeStudent(Student s) {
        students.remove(s.getStudentId());
    }
}
