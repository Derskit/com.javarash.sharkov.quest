package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StepTest {

    @Test
    void testSetAndGetId() {
        Step step = new Step();
        step.setId(10);

        assertEquals(10, step.getId());
    }

    @Test
    void testSetAndGetText() {
        Step step = new Step();
        step.setText("Run away");

        assertEquals("Run away", step.getText());
    }

    @Test
    void testDefaultValues() {
        Step step = new Step();

        assertEquals(0, step.getId());
        assertNull(step.getText());
    }
}