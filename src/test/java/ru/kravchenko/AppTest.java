package ru.kravchenko;

import org.junit.Test;

import java.util.UUID;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        for (int i = 0; i < 100; i++) {
            System.out.println(UUID.randomUUID());
        }
    }

}
