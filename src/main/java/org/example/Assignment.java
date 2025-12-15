package org.example;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@EqualsAndHashCode
@Setter //used for testing the calcStudentsAvg
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 0;
    private double average; //added for calcAssignmentAvg()

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("%d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    /**
     * Despite the method being void, it updates the this.average to work with the displayScore() in Course
     */
    public void calcAssignmentAvg() {
        if (scores == null || scores.isEmpty()){
            this.average = 0;
            return;
        }
        int total = 0; //initalize total
        int count = 0; //initialize quantity for denominator in avg

        for (Integer score : scores){
            if (score != null) {
                total += score;
                count++;
            }
        }

        this.average = (count == 0) ? 0 : (double) total / count;
    }

    private int result; //used to show an example of how to use maxScore in course.addAssignment

    /**
     * it does not directly return any value that is used however, this.result is used to show a potential usage
     * in the course.addAssignment(), to give a usage to maxScore.
     */
    public void generateRandomScore() {
        Random random = new Random();
        for (int i = 0; i < scores.size(); i++){
            int range = random.nextInt(11);
            switch (range) {
                case 0 -> this.result = random.nextInt(0, 60);
                case 1,2 -> this.result = random.nextInt(60,70);
                case 3,4 -> this.result = random.nextInt(70,80);
                case 5,6,7,8 -> this.result = random.nextInt(80,90);
                case 9,10 -> this.result = random.nextInt(90,100);
                default -> this.result = 0;
            };

            scores.set(i, result);
        }

    }
}
