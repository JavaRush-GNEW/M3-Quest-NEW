package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Question {

    private String name;
    private Scene nextScene;

    public Question(String name) {
        this.name = name;
    }
}
