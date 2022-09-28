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
        // Good test
        person.setFirstName("Marvin");
        assertEquals("Marvin", person.getFirstName());

        // Bad test
        Exception e = assertThrows(IllegalArgumentException.class, () -> person.setFirstName("1"));
        assertEquals("Numbers are not allowed", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> person.setFirstName(""));
    }

    @Test
    void getLastName() {
        assertEquals(Person.DEFAULT_LAST_NAME, person.getLastName());
    }

    @Test
    void setLastName() {
        // Good test
        person.setLastName("Chu");
        assertEquals("Chu", person.getLastName());

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

//    @Test
//    void compareTo() {
//        Person person2 = new Person("Amy", "Hauschildt");
//        Person person3 = new Person("Marc", "Hauschildt");
//        Person person4 = new Person("Jane", "Doe");
//        assertTrue(person.compareTo(person2) < 0); // Doe to Hauschildt
//        assertTrue(person.compareTo(person2) < 0); // Doe to Hauschildt
//        assertTrue(person.compareTo(person2) < 0); // Doe to Hauschildt
//        assertTrue(person.compareTo(person2) < 0); // Doe to Hauschildt
//        assertTrue(person.compareTo(person2) < 0); // Doe to Hauschildt
//    }
}