package org.densoft;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest implements Controller {

    private final Person person = new Person("Dennis", "Githinji");
    private final Calculator calculator = new Calculator();

    @Test
    void standardAssertions() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(4, calculator.multiply(2, 2), "optional failure message");
        assertTrue('a' < 'b', "message");
        assertThat(4).isEqualTo(calculator.multiply(2, 2));
    }

    @Test
    void groupedAssertions() {
        //in grouped assertions all assertions are excepted and all failures are reported together
        assertAll("person", () -> assertEquals("Dennis", person.getFirstName()),
                () -> assertEquals("Githinji", person.getLastName()));
    }

    @Test
    void dependentAssertions() {
        //within  a code block, if an assertion fails the subsequent code in the ame block will be skipped
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);

                    // Executed only if the previous assertion is valid.
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("D")),
                            () -> assertTrue(firstName.endsWith("s"))
                    );
                },
                () -> {
                    // Grouped assertion, so processed independently
                    // of results of first name assertions.
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    // Executed only if the previous assertion is valid.
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("G")),
                            () -> assertTrue(lastName.endsWith("i"))
                    );
                }
        );
    }

    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
        });
    }


    @Test
    void timeoutNotExceededWithResult() {
        // The following assertion succeeds, and returns the supplied object.
        String actualResult = assertTimeout(ofMinutes(2), () -> {
            return "a result";
        });
        assertEquals("a result", actualResult);
        assertThat(person.getFirstName(), is("Dennis"));
    }

    @Test
    void timeoutNotExceededWithMethod() {
        // The following assertion invokes a method reference and returns an object.
        String actualGreeting = assertTimeout(ofMinutes(2), MainControllerTest::greeting);
        assertEquals("Hello, World!", actualGreeting);
    }

    @Disabled("just disabled")
    @Test
    void timeoutExceeded() {
        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100);
        });
    }

    @Disabled("test disabled")
    @Test
    void timeoutExceededWithPreemptiveTermination() {
        //here the test fails after the waiting time expires it does not wait for the method to finish execution
        // The following assertion fails with an error message similar to:
        // execution timed out after 10 ms
        assertTimeoutPreemptively(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            new CountDownLatch(1).await();
        });
    }

    @Test
    void testAssumptionTrue() {
        Assumptions.assumeTrue("Dennis".equalsIgnoreCase(System.getenv("USER")));
    }

    private static String greeting() {
        return "Hello, World!";
    }
}