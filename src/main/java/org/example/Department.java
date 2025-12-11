package org.example;

import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class Department {
    private String departmentId;
    private String departmentName;

    private static int nextId = 0;

    public void setDepartmentName(String departmentName) {
        this.departmentName = isDepartmentNameValid(departmentName) ? departmentName : null;
    }

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D%2d", nextId++);
            this.departmentName = departmentName;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    public static boolean isDepartmentNameValid(String departmentName) {
        for (char i : departmentName.toCharArray()) {
            if (!Character.isLetter(i) && !Character.isWhitespace(i)) {
                 return false;
             }
        }

        return true;
    }


}
