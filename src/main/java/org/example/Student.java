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
    @Setter private ArrayList<Course> registeredCourses; //use method to set

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
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);
        course.registerStudent(this);

        return true;
    }
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)){
            return false;
        }

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        return true;
    }
    public String toSimplifiedString(){
        return String.format("Student Id: %s\n" +
                "Student name: %s\n" +
                "Department name: %s\n", studentId, studentName, department.getDepartmentName());

    }
    public String toString() {
        String gender = this.gender.toString();
        return String.format("Student Id: %s, Student name: %s,Gender:  %s, Address:  %s," +
                " Department: %s, Registered courses: %s", studentId, studentName, gender, address, department, registeredCourses);
    }

    public enum Gender{
        MALE,FEMALE
    }
}
