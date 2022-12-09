package final_exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;
    @BeforeEach
    void setUp() {
        student = new Student();
    }

    @Test
    void getStudentID() {
        assertEquals("k0000000", student.getStudentID());
    }

    @Test
    void setStudentID() {
        // Good data
        student.setStudentID("k0000001");
        assertEquals("k0000001", student.getStudentID());

        //Bad data
        assertThrows(IllegalArgumentException.class, () -> student.setStudentID(""));
        assertThrows(IllegalArgumentException.class, () -> student.setStudentID("k0000"));
        assertThrows(IllegalArgumentException.class, () -> student.setStudentID("h0000000"));
    }

    @Test
    void getGpa() {
        assertEquals(0, student.getGpa());
    }

    @Test
    void setGpa() {
        // Good data
        student.setGpa(1.5);
        assertEquals(1.5, student.getGpa());

        // Bad data
        assertThrows(IllegalArgumentException.class, () -> student.setGpa(-1));
        assertThrows(IllegalArgumentException.class, () -> student.setGpa(10));
    }

    @Test
    void compareTo() {
        Student student1 = new Student("k0000001", 2.5);
        Student student2 = new Student("k0000002", 3.0);

        assertTrue(student1.compareTo(student2) > 0); // Student 1 will be after student 2 when sort
    }

    @Test
    void testToString() {
        assertEquals("StudentID = k0000000, GPA = 0.0", student.toString());
    }
}