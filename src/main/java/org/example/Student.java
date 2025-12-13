package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
public class Student {
    private String studentId;
    @Setter private String studentName;
    @Setter private Gender gender;
    @Setter private Address address;
    @Setter private Department department;
    private ArrayList<Course> registeredCourses; //use method to set

    private static int nextId = 0;

    public Student(String studentName, Gender gender, Address address,
                   Department department, ArrayList<Course> registeredCourses) {
        this.studentId = String.format("S%05d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    public boolean registerCourse(Course course){
        return false;
    }
    public boolean dropCourse(Course course) {
        return false;
    }
    public String toSimplifiedString(){
        return null;
    }
    public String toString() {
        return null;
    }

    public enum Gender{
        MALE,FEMALE
    }
}
