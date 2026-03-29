package model;
import java.util.List;

public class Scene {
    private int id;
    private String question;
    private List<Step> steps;

    public int getId() { return id; }

    public String getQuestion() { return question; }

    public List<Step> getSteps() { return steps; }
}
