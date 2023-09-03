package org.densoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("controllers")
public class ControllerTest {

    Person person = new Person("Dennis", "Githinji");

    @Test
    void testPerson() {
        Assertions.assertEquals("Dennis", person.getFirstName());
    }
}
