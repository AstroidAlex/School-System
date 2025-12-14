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
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()){
            return false;
        }
        for (char i : departmentName.toCharArray()) {
            if (!Character.isLetter(i) && !Character.isWhitespace(i)) {
                 return false;
             }
        }

        return true;
    }


}
