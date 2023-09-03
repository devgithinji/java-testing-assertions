package org.densoft;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedDemoTest {
    @DisplayName("value source test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"spring", "framework", "guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }
}
