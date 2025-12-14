import org.example.Address;
import org.example.Department;
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
}