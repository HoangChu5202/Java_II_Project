package java1refresher;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private int heightInInches;
    private double weightInPounds;
    private LocalDateTime dateOfBirth;

    public static final String DEFAULT_FIRST_NAME = "John";
    public static final String DEFAULT_LAST_NAME = "Doe";
    public static final int DEFAULT_HEIGHT = 0;
    public static final double DEFAULT_WEIGHT = 0;
    public static final LocalDateTime DEFAULT_DOB = LocalDateTime.now();
    public static final LocalDateTime MIDNIGHT_TONIGHT = LocalDateTime.of(
            LocalDate.now(ZoneId.of("America/Chicago")), LocalTime.MIDNIGHT).plusDays(1);

    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME);
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        heightInInches = DEFAULT_HEIGHT;
        weightInPounds = DEFAULT_WEIGHT;
        dateOfBirth = DEFAULT_DOB;
    }

    public Person(String firstName, String lastName, int heightInInches, double weightInPounds, LocalDateTime dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Numbers are not allowed");
        } else if (firstName.equals("")) {
            throw new IllegalArgumentException("First Name is required");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        int result = this.lastName.compareTo(o.lastName);
        if (result == 0) {
            result = this.firstName.compareTo(o.firstName);
        }
        return result;
    }
}
