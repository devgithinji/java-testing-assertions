package org.densoft;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@Tag("controller")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface Controller {

    @BeforeAll
    default void beforeAll() {
        System.out.println("lets do something here");
    }

}
