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

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%d", department.getDepartmentId(), nextId++); //confirm using string is ok
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    public boolean isAssignmentWeightValid(){
        double total = 0;
        for(Assignment assignment : assignments){;
            total += assignment.getWeight();
        }
        return total == 100;
    }
    public boolean registerStudent(Student student){
        if (registeredStudents.contains(student)){
            return false;
        }
        this.registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        return true;
    }
    public int[] calcStudentsAverage() {
        int studentCount = registeredStudents.size();
        int[] finalScores = new int[studentCount];
        for (int i = 0; i < studentCount; i++){
            double total = 0;
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i); //Integer instead of int to avoid issues with null
                if (score != null) {
                    total += score * (assignment.getWeight() / 100.0);
                }
            }
            finalScores[i] = (int)Math.round(total);
        }

        return finalScores;
    }
    public boolean addAssignment(String assignmentName, double weight, int maxScore){
        Assignment assignment = new Assignment(assignmentName, weight);

        assignments.add(assignment);
        for (int i = 0; i < registeredStudents.size(); i++){
            assignment.getScores().add(null);
        }
        return true;
    }
}
