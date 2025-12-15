package org.example;

import lombok.*;

@ToString
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Address {
    @Setter private int streetNo;
    @Setter private String street;
    @Setter private String city;
    @Setter private Province province;
    private String postalCode;

    public void setPostalCode(String postalCode) {
        this.postalCode = isPostalCodeValid(postalCode) ? postalCode.toUpperCase() : null;
    }

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        this.streetNo = streetNo;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = isPostalCodeValid(postalCode) ? postalCode.toUpperCase() : null;
    }

    /**
     * Checks if the inputted postalCode is a valid one
     * @param postalCode is the postal code as a String with no spaces
     * @return if the postal code is a proper one or not
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }
        int tempIdxTracker = 0;
        for (char i : postalCode.toCharArray()){
            if (!Character.isLetter(i) && tempIdxTracker % 2 == 0){
                return false;
            }
            if (!Character.isDigit(i) && tempIdxTracker % 2 == 1) {
                return false;
            }
            tempIdxTracker++;
        }

        return true;
    }

    public enum Province{
        QC,ON,NS,NB,AB,BC,MB,NL,PE
    }
}