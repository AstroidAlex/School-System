package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class Address {
    @Setter private int streetNo;
    @Setter private String street;
    @Setter private String city;
    @Setter private Province province;
    private String postalCode;

    public void setPostalCode(String postalCode) { //required to check if is a valid postal code or not
        this.postalCode = isPostalCodeValid(postalCode) ? postalCode : null;
    }


    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        this.streetNo = streetNo;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = isPostalCodeValid(postalCode) ? postalCode : null;
    }

    private static boolean isPostalCodeValid(String postalCode) {
        if (postalCode.length() != 6) {
            return false;
        }
        char firstChar = postalCode.charAt(0);
        char secondChar = postalCode.charAt(1);
        char thirdChar = postalCode.charAt(2);
        char fourthChar = postalCode.charAt(3);
        char fifthChar = postalCode.charAt(4);
        char lastChar = postalCode.charAt(5);

        if (!Character.isLetter(firstChar) || !Character.isLetter(thirdChar) || !Character.isLetter(fifthChar)) {
            return false; //if any aren't a letter, it will return false
        }
        if (!Character.isDigit(secondChar) || !Character.isDigit(fourthChar) || !Character.isDigit(lastChar)) {
            return false; //if any aren't a number, it will return false
        }

        return true;
    }

    public enum Province{
        QC,ON,NS,NB,AB,BC,MB,NL,PE
    }
}
