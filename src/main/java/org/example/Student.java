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
    private ArrayList<Course> registeredCourses; //use method to set

    private static int nextId;

    public enum Gender{
        MALE,FEMALE
    }
}
