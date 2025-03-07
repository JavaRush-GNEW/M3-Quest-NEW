package service;

import lombok.Data;
import model.Question;
import model.Scene;
import repository.QuizRepository;

import java.util.List;

@Data
public class QuizService {

    private Scene currentScene;
    private List<Scene> scenes;
    private QuizRepository quizRepository = QuizRepository.getInstance();;


    public QuizService() {
        currentScene = quizRepository.getScene1();
    }

    public Scene makeStep(int answer){
        List<Question> questions = currentScene.getQuestions();
        Question question = questions.get(answer);
        currentScene = question.getNextScene();
        return currentScene;
    }

}
