package org.densoft;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedDemoTest {

    @ParameterizedTest
    @ValueSource(strings = {"spring", "framework", "guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }
}
