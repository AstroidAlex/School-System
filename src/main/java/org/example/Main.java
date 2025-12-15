package org.example;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address(124, "Main", "Montreal", Address.Province.QC, "h1L8F1");
        Department dep1 = new Department("Science");
        Course c = new Course("Programming 1", 3, dep1);
        c.addAssignment("MidTerm", 30, 100);
        c.addAssignment("MidTerm", 70, 100);
        Student s1 = new Student("Charles", Student.Gender.MALE, address1, dep1);
        Student s2 = new Student("Mark", Student.Gender.MALE, address1, dep1);
        s1.registerCourse(c);
        s2.registerCourse(c);
        c.generateScores();



        c.displayScores();

        //System.out.println("\n\n\n");


        /*
        Address address1 = new Address(124, "Main", "Montreal", Address.Province.QC, "h1L8F1");
        Department dep1 = new Department("Science");
        Student s1 = new Student("Charles", Student.Gender.MALE, address1, dep1);
        Course c = new Course("Programming 1", 3, dep1);
        Assignment a1 = new Assignment("Finals", 100, 100);
        c.addAssignment(a1.getAssignmentName(), a1.getWeight(), 100);
        s1.registerCourse(c);
        System.out.println(Arrays.toString(c.calcStudentsAverage()));


         */

    }
}