package org.example;


public class Main {
    public static void main(String[] args) {
        Address address1 = new Address(124, "Main", "Montreal", Address.Province.QC, "h1L8F1");
        Department dep1 = new Department("Science");
        Course c = new Course("Programming 1", 3, dep1);
        c.addAssignment("MidTerm", 30, 100);
        c.addAssignment("Finals", 70, 100);
        Student s1 = new Student("Charles", Student.Gender.MALE, address1, dep1);
        Student s2 = new Student("Mark", Student.Gender.MALE, address1, dep1);
        s1.registerCourse(c);
        s2.registerCourse(c);

        c.displayScores();
    }
}