package org.densoft;

import org.junit.jupiter.api.*;

@Tag("controllers")
class PersonModelTest implements Model {

    Person person = new Person("Dennis", "Githinji");

    @Test
    void testPerson() {
        Assertions.assertEquals("Dennis", person.getFirstName());
    }

    @RepeatedTest(value = 10, name ="{displayName} : {currentRepetition} of {totalRepetitions}" )
    @DisplayName("My repeated test")
    void repeatedTest(RepetitionInfo repeatedTest, TestInfo testInfo) {
        System.out.println(repeatedTest);
        System.out.println(testInfo);
        System.out.println("repeated test");
    }
}
