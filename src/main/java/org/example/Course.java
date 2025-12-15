package org.example;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private static int nextId = 0;

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    /**
     * Makes sure all assignments in the ArrayList assignments have a combined weight that is equal to 100
     * @return if the sum of the weights of each assignment result in 100
     */
    public boolean isAssignmentWeightValid(){
        double total = 0;
        for(Assignment assignment : assignments){;
            total += assignment.getWeight();
        }
        return total == 100;
    }

    /**
     * confirms that a student can be registered as well as registers them to the course
     * @param student
     * @return
     */
    public boolean registerStudent(Student student){
        if (registeredStudents.contains(student)){
            return false;
        }
        this.registeredStudents.add(student);
        student.registerCourse(this);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        return true;
    }

    /**
     * takes the registerStudents size, makes an array of such length, then calculates the final scores based on the
     * weight of each assignment
     * @return the rounded to an int final score of all assignments combined then divided by the quantity.
     */
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

    /**
     * Takes Information of an assignment then adds it to the course accordingly
     * @param assignmentName is the name of the assignment
     * @param weight is the weight of the assingment (for the final score)
     * @param maxScore is unused but could be used if unit testing didn't require a consistent output
     *                 (usage commented out)
     * @return If adding the assignment worked or not
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore){

        Assignment assignment = new Assignment(assignmentName, weight);
        assignments.add(assignment);
        /* commented due to the randomness causing occasional errors
        if (assignment.getResult() > maxScore) {  //added next to method to show an example of how it would work
            return false;
        }
        */


        return true;
    }

    /**
     * takes the quanity of assignments and runs the generateRandomScore() method as well as the calcAssignmentAvg()
     */
    public void generateScores(){
            for (Assignment assignment : assignments){
                assignment.generateRandomScore();

                assignment.calcAssignmentAvg();
            }
    }

    /**
     * Displays the scores, students, course, department and assignments in an easy to read format
     */
    public void displayScores(){
        System.out.printf("Course: %s(%s)\n", courseName, courseId);
        int count = 0; //used for moving the first assignment more to the right
        for (Assignment assignment : assignments) {
            if (count == 0) {
                System.out.printf("%30s",assignment.getAssignmentName());
                count++;
            } else {
                System.out.printf("%15s",assignment.getAssignmentName());
            }
        }
        System.out.printf("%25s", "Final Score\n");

        int[] finalScores = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++){
            Student student = registeredStudents.get(i);
            System.out.printf("%15s", student.getStudentName());

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                System.out.printf("%15s", score);
            }
            System.out.printf("%24d\n", finalScores[i]);
        }
        System.out.printf("%15s", "Average");
        for (Assignment assignment : assignments) {
            System.out.printf("%15.0f", assignment.getAverage());
        }
    }

    /**
     * is a way to read the string that simple to read
     * @return the string formated with simple information.
     */
    public String toSimplifiedString() {
        return String.format("\nCourse id: %s, Course name: %s, Credits: %f, Department name: %s",
                courseId, courseName, credits, department.getDepartmentName());
    }
    public String toSting() {
        for (Student student : registeredStudents) {
            return String.format("\nCourse id: %s, Course name: %s, Credits: %f, Department name: %s, " +
                            "Assignments: %s, Registered students: %s, %s, %s -%b", courseId, courseName, credits,
                    department.getDepartmentName(), assignments.toString(), student.getStudentId(), student.getStudentName(),
                    department.getDepartmentName(), isAssignmentWeightValid());
        }
        return "";
    }
}