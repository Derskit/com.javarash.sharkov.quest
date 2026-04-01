package model;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SceneTest {

    @Test
    void testSetAndGetId() {
        Scene scene = new Scene();
        scene.setId(1);

        assertEquals(1, scene.getId());
    }

    @Test
    void testSetAndGetQuestion() {
        Scene scene = new Scene();
        scene.setQuestion("Test question");

        assertEquals("Test question", scene.getQuestion());
    }

    @Test
    void testSetAndGetSteps() {
        Scene scene = new Scene();

        Step step = new Step();
        step.setId(2);
        step.setText("Go");

        scene.setSteps(List.of(step));

        assertNotNull(scene.getSteps());
        assertEquals(1, scene.getSteps().size());
        assertEquals("Go", scene.getSteps().get(0).getText());
    }
}