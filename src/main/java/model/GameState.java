package model;

public class GameState {
    private String username;
    private int currentScene;
    private int steps;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getCurrentScene() { return currentScene; }
    public void setCurrentScene(int currentScene) { this.currentScene = currentScene; }

    public int getSteps() { return steps; }
    public void setSteps(int steps) { this.steps = steps; }
}
