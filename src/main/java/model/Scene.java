package model;
import java.util.List;

public class Scene {
    private int id;
    private String question;
    private List<Step> steps;

    public int getId() { return id; }

    public String getQuestion() { return question; }

    public List<Step> getSteps() { return steps; }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
