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
                   Department department) {
        this.studentId = String.format("S%05d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * checks if the course is already assigned, and if not, adds the course to the registeredCourses as well as
     * registers the student to the course
     * @param course is the course in which the student will be assigned and will be assigned to registeredCourses
     * @return if the course
     */
    public boolean registerCourse(Course course){
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);
        course.registerStudent(this);
        ArrayList<Assignment> assignments = course.getAssignments();

        return true;
    }

    /**
     * Removes a student from a course and checks for errors
     * @param course is the course that the student is removed from
     * @return
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)){
            return false;
        }
        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        return true;
    }

    /**
     * Takes studentId, studentName and departmentName into a single string
     * @return the elements above into a single string using string.format()
     */
    public String toSimplifiedString(){
        return String.format("\nStudent Id: %s, Student name: %s, Department name: %s\n",
                studentId, studentName, department.getDepartmentName());
    }

    /**
     * Takes studentId, studentName, gender, address, department and registeredCourses into a single string
     * @return the elements above into a single string using string.format()
     */
    public String toString() {
        String gender = this.gender.toString();
        return String.format("\nStudent Id: %s, Student name: %s,Gender:  %s, Address:  %s," +
                " Department: %s, Registered courses: %s", studentId, studentName, gender, address.toString(),
                department.toString(), registeredCourses);
    }

    public enum Gender{
        MALE,FEMALE
    }
}