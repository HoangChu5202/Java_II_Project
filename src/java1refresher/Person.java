package java1refresher;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class Person { //implements Comparable<Person>{
    private int id;
    private String firstName;
    private String lastName;
    private int heightInInches;
    private double weightInPounds;
    private LocalDateTime dateOfBirth;

    public static final int DEFAULT_ID = 0;
    public static final String DEFAULT_FIRST_NAME = "John";
    public static final String DEFAULT_LAST_NAME = "Doe";
    public static final int DEFAULT_HEIGHT = 0;
    public static final double DEFAULT_WEIGHT = 0;
    public static final LocalDateTime DEFAULT_DOB = LocalDateTime.now();
    public static final LocalDateTime MIDNIGHT_TONIGHT = LocalDateTime.of(
            LocalDate.now(ZoneId.of("America/Chicago")), LocalTime.MIDNIGHT).plusDays(1);
    public static final String FIRST_NAME_NO_NUMBER_ERR = "First name cannot contain numbers";
    public static final String FIRST_NAME_EMPTY_ERR = "First name is required.";

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

    public Person(int id, String firstName, String lastName, int heightInInches, double weightInPounds, LocalDateTime dateOfBirth) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setHeightInInches(heightInInches);
        setWeightInPounds(weightInPounds);
        setDateOfBirth(dateOfBirth);
    }

    public Person(String firstName) {
        this.firstName = firstName;
        this.lastName = DEFAULT_LAST_NAME;
        heightInInches = DEFAULT_HEIGHT;
        weightInPounds = DEFAULT_WEIGHT;
        dateOfBirth = DEFAULT_DOB;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0) {
            throw new IllegalArgumentException("id must be 0 or higher");
        }
        this.id = id;
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
        if (lastName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Numbers are not allowed");
        } else if (lastName.equals("")) {
            throw new IllegalArgumentException("Last Name is required");
        }
        this.lastName = lastName;
    }

    public void setFirstNameAndLastName(String name) {
        String[] names = name.split(" ");
        if (names.length > 1) {
            lastName = names[names.length - 1].strip();
            String personFirstName = "";
            for (int i = 0; i < names.length - 1; i++) {
                personFirstName += names[i] + " ";
            }
            firstName = personFirstName.strip();
        } else {
            firstName = name;
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        if(heightInInches < 0 || heightInInches > 100) {
            throw new IllegalArgumentException("Height must be between 0 and 100");
        }
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        if(weightInPounds < 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        this.weightInPounds = weightInPounds;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        if(dateOfBirth.isAfter(MIDNIGHT_TONIGHT)) {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        }
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

//    @Override
//    public int compareTo(Person o) {
//        int result = this.lastName.compareTo(o.lastName);
//        if (result == 0) {
//            result = this.firstName.compareTo(o.firstName);
//        }
//        return result;
//    }
}
