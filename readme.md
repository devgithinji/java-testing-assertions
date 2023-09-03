[![CircleCI](https://dl.circleci.com/status-badge/img/gh/devgithinji/java-testing-assertions/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/devgithinji/java-testing-assertions/tree/master)

# Java Testing Assertions

This README provides an overview of common ways to make assertions in Java testing using various testing frameworks and libraries. Making assertions is a crucial aspect of writing effective unit tests to verify the correctness of your code.

## Assertions

You can make assertions in Java testing using various testing frameworks and libraries. Here are some common ways:

- **JUnit Assertions**:

  - JUnit is a widely used testing framework in Java, and it provides a set of built-in assertion methods. You can use them as follows:
    ```java
    import static org.junit.Assert.*;

    @Test
    public void testExample() {
        int expected = 5;
        int actual = someFunction();
        assertEquals(expected, actual);
    }
    ```
- **TestNG Assertions**:

  - TestNG is another popular testing framework that provides its own set of assertion methods:
    ```java
    import org.testng.Assert;

    @Test
    public void testExample() {
        int expected = 5;
        int actual = someFunction();
        Assert.assertEquals(expected, actual);
    }
    ```
- **AssertJ Assertions**:

  - AssertJ is a third-party library that offers a fluent and expressive API for making assertions:
    ```java
    import static org.assertj.core.api.Assertions.*;

    @Test
    public void testExample() {
        int expected = 5;
        int actual = someFunction();
        assertThat(actual).isEqualTo(expected);
    }
    ```
- **Hamcrest Matchers**:

  - Hamcrest is another third-party library that allows you to create custom matchers for expressive and readable assertions:
    ```java
    import static org.hamcrest.Matchers.*;
    import static org.hamcrest.MatcherAssert.assertThat;

    @Test
    public void testExample() {
        int expected = 5;
        int actual = someFunction();
        assertThat(actual, is(equalTo(expected)));
    }
    ```
- **Custom Assertions**:

  - You can create your custom assertion methods or matchers to suit your specific testing needs:
    ```java
    public void assertCustomCondition(Object value) {
        // Implement your custom assertion logic
        if (!customCondition(value)) {
            throw new AssertionError("Custom assertion failed");
        }
    }

    @Test
    public void testExample() {
        Object data = getData();
        assertCustomCondition(data);
    }

    ```

Choose the assertion method that best fits your testing needs and makes your test cases clear and understandable.
