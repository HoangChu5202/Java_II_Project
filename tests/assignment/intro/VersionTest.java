package assignment.intro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class VersionTest {
    @Test
    public void introAssignmentGoodChecks() {
        assertEquals("0.0.1", new Version().toString());
        assertEquals("1.2.3", new Version("1.2.3").toString());
        assertEquals("1.2.3", new Version("1.2.3.4").toString());
        assertEquals("1.2.3", new Version("1.2.3.d").toString());
        assertEquals("1.0.0", new Version("1").toString());
        assertEquals("1.1.0", new Version("1.1").toString());
        assertEquals("1.2.3", new Version(1, 2, 3).toString());
        assertEquals("0.0.1", new Version("").toString());
        assertEquals("12.50.23", new Version(12, 50, 23).toString());
    }

    @Test
    public void introAssignmentBadChecks() {
        assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                new Version("a.b.c");
            }
        });

        assertThrows(IllegalArgumentException.class, () -> new Version("a.0.0"));
        assertThrows(IllegalArgumentException.class, () -> new Version("0.a.0"));
        assertThrows(IllegalArgumentException.class, () -> new Version("0.0.a"));
        assertThrows(IllegalArgumentException.class, () -> new Version(-1, -2, -5));
    }

    @Test
    void roundOffError() {
//        assertEquals(2.11, 1.1 + 1.01); this test will fail because of round off error
//        you should do this:
        assertEquals(2.11, 1.1 + 1.01, 0.001);


    }
}