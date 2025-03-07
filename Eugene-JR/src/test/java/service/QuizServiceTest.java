package service;

import model.Question;
import model.Scene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.QuizRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class QuizServiceTest {

    private QuizService quizService;
    private QuizRepository quizRepository;

    @BeforeEach
    void setUp() {
        quizRepository = QuizRepository.getInstance();
        quizService = new QuizService();
    }

    @Test
    void testInitialSceneIsCorrect() {
        assertEquals(quizRepository.getScene1(), quizService.getCurrentScene(), "Initial scene should be Start");
    }

    @Test
    void testSceneTransition() {
        Scene initialScene = quizService.getCurrentScene();
        Scene expectedScene = initialScene.getQuestions().get(0).getNextScene();

        Scene newScene = quizService.makeStep(0);

        assertEquals(expectedScene, newScene, "After choosing the first option, the scene should change correctly");
    }

    @Test
    void testInvalidStepThrowsException() {
        Scene initialScene = quizService.getCurrentScene();
        int invalidIndex = initialScene.getQuestions().size();

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> quizService.makeStep(invalidIndex));

        assertTrue(exception.getMessage().contains("Index"), "Exception should be thrown for an invalid choice");
    }

    @Test
    void testFinalSceneDetection() {
        // Перехід до фінальної сцени (наприклад, через кілька кроків)
        Scene finalScene = new Scene("Перемога").setFinal();
        Scene testScene = new Scene("Test");
        testScene.setQuestions(Arrays.asList(new Question("Go to final", finalScene)));

        quizService.setCurrentScene(testScene);

        Scene newScene = quizService.makeStep(0);

        assertTrue(newScene.isFinal(), "Final scene should be detected properly");
        assertEquals(finalScene, newScene, "Final scene should be reached correctly");
    }


}