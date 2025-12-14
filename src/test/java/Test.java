import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;


public class Test {
    @org.junit.jupiter.api.Test
    @DisplayName("isPostalCodeValid() H1L1N1 -> true")
    void isPostalCodeValid1() {
        String postalCode = "H1L1N1";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("isPostalCodeValid() 111111 -> false")
    void isPostalCodeValid2() {
        String postalCode = "111111";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("isPostalCodeValid() empty -> false")
    void isPostalCodeValid3() {
        String postalCode = "";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("isPostalCodeValid() h1l1n1 -> true")
    void isPostalCodeValid4() {
        String postalCode = "h1l1n1";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("isPostalCodeValid() null -> false")
    void isPostalCodeValid5() {
        String postalCode = null;
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("isDepartmentNameValid() DDD -> true")
    void isDepartmentNameValid1() {
        String departmentName = "DDD";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(departmentName);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("isDepartmentNameValid() 1234 -> False")
    void isDepartmentNameValid2() {
        String departmentName = "1234";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("isDepartmentNameValid() null -> false")
    void isDepartmentNameValid3() {
        String departmentName = null;
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("isDepartmentNameValid() empty-> false")
    void isDepartmentNameValid4() {
        String departmentName = "";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("registerCourse() student(already in)-> false")
    void registerCourse1() {
        Student student = new Student("Katy", Student.Gender.FEMALE, new Address(12, "Main",
                "Laval", Address.Province.QC, "H1L1n1"), new Department("Math"));
        Course course = new Course("Prog 1", 3.5, new Department("Math"));
        boolean expected = false;
        student.registerCourse(course);
        boolean actual = student.registerCourse(course);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("registerCourse() student(normal)-> true")
    void registerCourse2() {
        Student student = new Student("Katy", Student.Gender.FEMALE, new Address(12, "Main",
                "Laval", Address.Province.QC, "H1L1n1"), new Department("Math"));
        Course course = new Course("Prog 1", 3.5, new Department("Math"));
        boolean expected = true;
        boolean actual = student.registerCourse(course);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("registerCourse() student(nulls)-> true")
    void registerCourse3() {
        Student student = new Student(null, Student.Gender.FEMALE, new Address(12, null,
                "Laval", Address.Province.QC, null), new Department(null));
        Course course = new Course(null, 3.5, new Department(null));
        boolean expected = true;
        boolean actual = student.registerCourse(course);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("registerCourse() student(empties)-> true")
    void registerCourse4() {
        Student student = new Student("", Student.Gender.FEMALE, new Address(12, "",
                "", Address.Province.QC, ""), new Department(""));
        Course course = new Course("", 3.5, new Department(""));
        boolean expected = true;
        boolean actual = student.registerCourse(course);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("dropCourse() student(already out)-> false")
    void dropCourse1() {
        Student student = new Student("Katy", Student.Gender.FEMALE, new Address(12, "Main",
                "Laval", Address.Province.QC, "H1L1n1"), new Department("Math"));
        Course course = new Course("Prog 1", 3.5, new Department("Math"));
        boolean expected = false;
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("dropCourse() student(normal)-> true")
    void dropCourse2() {
        Student student = new Student("Katy", Student.Gender.FEMALE, new Address(12, "Main",
                "Laval", Address.Province.QC, "H1L1n1"), new Department("Math"));
        Course course = new Course("Prog 1", 3.5, new Department("Math"));
        boolean expected = true;
        student.registerCourse(course);
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("dropCourse() student(nulls)-> true")
    void dropCourse3() {
        Student student = new Student(null, Student.Gender.FEMALE, new Address(12, null,
                "Laval", Address.Province.QC, null), new Department(null));
        Course course = new Course(null, 3.5, new Department(null));
        boolean expected = true;
        student.registerCourse(course);
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("dropCourse() student(empties)-> true")
    void dropCourse4() {
        Student student = new Student("", Student.Gender.FEMALE, new Address(12, "",
                "", Address.Province.QC, ""), new Department(""));
        Course course = new Course("", 3.5, new Department(""));
        boolean expected = true;
        student.registerCourse(course);
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("isAssignmentWeightValid() assignment(none)-> false")
    void isAssignmentWeightValid1() {
        Course course = new Course("", 3.5, new Department(""));
        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("isAssignmentWeightValid() assignment(100)-> true")
    void isAssignmentWeightValid2() {
       Course course = new Course("", 3.5, new Department(""));
        Assignment assignment = new Assignment(null, 100);
        course.addAssignment(assignment.getAssignmentName(), assignment.getWeight(), 100);
        boolean expected = true;
        boolean actual = course.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("isAssignmentWeightValid() assignment(10)-> false")
    void isAssignmentWeightValid3() {
        Course course = new Course("", 3.5, new Department(""));
        Assignment assignment = new Assignment(null, 10);
        course.addAssignment(assignment.getAssignmentName(), assignment.getWeight(), 100);
        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("isAssignmentWeightValid() assignment(101)-> false")
    void isAssignmentWeightValid4() {
        Course course = new Course("", 3.5, new Department(""));
        Assignment assignment = new Assignment(null, 101);
        course.addAssignment(assignment.getAssignmentName(), assignment.getWeight(), 100);
        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("registerStudent() student(already assigned)-> false")
    void registerStudent1() {
        Student student = new Student("", Student.Gender.FEMALE, new Address(12, "",
                "", Address.Province.QC, ""), new Department(""));
        Course course = new Course("", 3.5, new Department(""));
        Assignment assignment = new Assignment(null, 100);
        course.addAssignment(assignment.getAssignmentName(), assignment.getWeight(), 100);
        course.registerStudent(student);
        boolean expected = false;
        boolean actual = course.registerStudent(student);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("registerStudent() student(null)-> true")
    void registerStudent2() {
        Student student = new Student(null, Student.Gender.FEMALE, new Address(12, "",
                "", Address.Province.QC, null), new Department(null));
        Course course = new Course(null, 3.5, new Department(null));
        Assignment assignment = new Assignment(null, 100);
        course.addAssignment(assignment.getAssignmentName(), assignment.getWeight(), 100);
        boolean expected = true;
        boolean actual = course.registerStudent(student);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("registerStudent() student(Invalid weight)-> true")
    void registerStudent3() {
        Student student = new Student("", Student.Gender.FEMALE, new Address(12, "",
                "", Address.Province.QC, ""), new Department(""));
        Course course = new Course("", 3.5, new Department(""));
        Assignment assignment = new Assignment(null, 101);
        course.addAssignment(assignment.getAssignmentName(), assignment.getWeight(), 10);
        boolean expected = true;
        boolean actual = course.registerStudent(student);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("registerStudent() student(normal)-> true")
    void registerStudent4() {
        Student student = new Student("", Student.Gender.FEMALE, new Address(12, "",
                "", Address.Province.QC, ""), new Department(""));
        Course course = new Course("", 3.5, new Department(""));
        Assignment assignment = new Assignment(null, 100);
        course.addAssignment(assignment.getAssignmentName(), assignment.getWeight(), 100);
        boolean expected = true;
        boolean actual = course.registerStudent(student);
        Assertions.assertEquals(expected, actual);
    }
}