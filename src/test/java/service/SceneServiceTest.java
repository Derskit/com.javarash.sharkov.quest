package service;
import model.Scene;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SceneServiceTest {

    @Test
    void testGetSceneNotNull() {
        Scene scene = SceneService.getScene(1);
        assertNotNull(scene, "Scene should not be null");
    }

    @Test
    void testSceneHasCorrectId() {
        Scene scene = SceneService.getScene(1);
        assertEquals(1, scene.getId());
    }

    @Test
    void testSceneHasQuestion() {
        Scene scene = SceneService.getScene(1);
        assertNotNull(scene.getQuestion());
        assertFalse(scene.getQuestion().isEmpty());
    }

    @Test
    void testSceneHasSteps() {
        Scene scene = SceneService.getScene(1);
        assertNotNull(scene.getSteps());
        assertFalse(scene.getSteps().isEmpty());
    }

    @Test
    void testInvalidSceneReturnsNull() {
        Scene scene = SceneService.getScene(999);
        assertNull(scene);
    }
}