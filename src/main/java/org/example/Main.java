package org.example;


public class Main {
    public static void main(String[] args) {
        Address address1 = new Address(124, "Main", "Montreal", Address.Province.QC, "h1L8F1");
        Department dep1 = new Department("Science");
        Course c = new Course("Prog 1", 3, dep1);
        c.addAssignment("MidTerm", 30, 100);
        c.addAssignment("Finals", 70, 100);
        Student s = new Student("Charles", Student.Gender.MALE, address1, dep1);
        s.registerCourse(c);

        System.out.println(Util.toTitleCase("hi i    am bob"));
        System.out.println(dep1.getDepartmentId());
        System.out.println(address1.getPostalCode());
        System.out.println(c.getRegisteredStudents().size());
    }
}