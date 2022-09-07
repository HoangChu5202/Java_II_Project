package java1refresher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void getFirstName() {
        assertEquals(Person.DEFAULT_FIRST_NAME, person.getFirstName());
    }

    @Test
    void setFirstName() {

    }

    @Test
    void getLastName() {
        assertEquals(Person.DEFAULT_LAST_NAME, person.getLastName());
    }

    @Test
    void setLastName() {
    }

    @Test
    void getHeightInInches() {
        assertEquals(Person.DEFAULT_HEIGHT, person.getHeightInInches());
    }

    @Test
    void setHeightInInches() {
    }

    @Test
    void getWeightInPounds() {
        assertEquals(Person.DEFAULT_WEIGHT, person.getWeightInPounds());
    }

    @Test
    void setWeightInPounds() {
    }

    @Test
    void getDateOfBirth() {
        assertEquals(Person.DEFAULT_DOB, person.getDateOfBirth());
    }

    @Test
    void setDateOfBirth() {

    }

    @Test
    void testToString() {
        assertEquals(String.format("Person{firstName='%s', lastName='%s'}", Person.DEFAULT_FIRST_NAME, Person.DEFAULT_LAST_NAME),
                person.toString());
    }
}