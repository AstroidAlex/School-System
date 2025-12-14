package org.example;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@EqualsAndHashCode
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
    public void calcAssignmentAvg() {
        if (scores == null || scores.isEmpty()){
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
        //avg remains unused due to constraints imposed by instructions
    }
    private int result; //used to show an example of how to use maxscore in course.addAssignment
    public void generateRandomScore() {
        Random random = new Random();
        int score = random.nextInt(0, 10);
        this.result = switch (score) {
            case 0 -> random.nextInt(0, 60);
            case 1,2 -> random.nextInt(60,70);
            case 3,4 -> random.nextInt(70,80);
            case 5,6,7,8 -> random.nextInt(80,90);
            case 9,10 -> random.nextInt(90,100);
            default -> 0;
        };
    }
}
