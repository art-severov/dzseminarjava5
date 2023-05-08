package dzseminar5;

import java.time.Period;

public class zadacha1_1 {
    public static void main(String[] args) {
        zadacha1 phones = new zadacha1();
        phones.add("Petrov", 13246);
        phones.add("Korovev", 79851468);
        phones.add("Petrov", 454123);
        phones.add("Kukushkin", 4188845);
        System.out.println(phones.print());
        System.out.println(phones.getNumber("Petrov"));
        System.out.println(phones.getByNumber(79851468));
    }
}