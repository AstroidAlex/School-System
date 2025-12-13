package org.example;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;

    private static int nextId = 0;

    public Course(String courseName, double credits, Department department,
                  ArrayList<Assignment> assignments, ArrayList<Student> registeredStudents) {
        this.courseId = String.format("C-%s-%d", department.getDepartmentId(), nextId++); //confirm using string is ok
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = assignments;
        this.registeredStudents = registeredStudents;
    }

    public boolean isAssignmentWeightValid(){
        int total = 0;

        return total % 100 == 0;
    }
    public boolean registerStudent(Student student){
        this.registeredStudents.add(student);

        return true;
    }
    public int[] calcStudentsAverage() {
       int[] result = new int[1]; //temporary
        return result;
    }
    public boolean addAssignment(String assignmentName, double weight, int maxScore){
        this.assignments.add(new Assignment(assignmentName, weight, maxScore));
    }
}
