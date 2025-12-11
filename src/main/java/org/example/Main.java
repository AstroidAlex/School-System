package org.example;


public class Main {
    public static void main(String[] args) {
        Address address1 = new Address(124, "Main", "Montreal", Address.Province.QC, "h1L8F1");
        Department dep1 = new Department("Science");

        System.out.println(dep1.getDepartmentId());
        System.out.println(address1.getPostalCode());
    }
}