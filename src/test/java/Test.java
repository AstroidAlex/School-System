import org.example.Address;
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
    @DisplayName("isPostalCodeValid() h1l1n1 -> true")
    void s() {
        String postalCode = "h1l1n1";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }
}