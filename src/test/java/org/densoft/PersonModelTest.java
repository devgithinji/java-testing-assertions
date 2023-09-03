package org.densoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("controllers")
class PersonModelTest implements Model {

    Person person = new Person("Dennis", "Githinji");

    @Test
    void testPerson() {
        Assertions.assertEquals("Dennis", person.getFirstName());
    }
}
