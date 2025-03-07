package model;

import lombok.*;

import java.util.List;
@Data
public class Scene {

    private String name;
    private List<Question> questions;
    private boolean isFinal = false;

    public Scene(String name) {
        this.name = name;
    }

    public Scene setFinal(){
        isFinal = true;
        return this;
    }

    @Override
    public String toString() {
        return "Question{text='" + name+" }";
    }
}
