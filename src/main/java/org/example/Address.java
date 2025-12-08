package org.example;

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public enum Province{
        QC,ON,NS,NB,AB,BC,MB,NL,PE
    }
}
