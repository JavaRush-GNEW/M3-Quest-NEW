package repository;

import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QuestionRepositoryTest {
    private QuestionRepository questionRepository;

    @BeforeEach
    void setUp() {
        questionRepository = QuestionRepository.getInstance();
    }

    @Test
    void givenQuestionRepository_whenGetQuestions_thenShouldReturnNonEmptyList() {
        // given (QuestionRepository is initialized)

        // when
        ArrayList<Question> questions = questionRepository.getQuestions();

        // then
        assertNotNull(questions, "The question list should not be null");
        assertFalse(questions.isEmpty(), "The question list should not be empty");
    }

    @Test
    void givenQuestionRepository_whenGetQuestions_thenShouldReturnListOfFiveQuestions() {
        // given (QuestionRepository is initialized)

        // when
        ArrayList<Question> questions = questionRepository.getQuestions();

        // then
        assertEquals(5, questions.size(), "Expected 5 questions in the list");
    }

    @Test
    void givenQuestionRepository_whenGetFirstQuestion_thenShouldHaveValidTextAndAnswers() {
        // given (QuestionRepository is initialized)

        // when
        Question question = questionRepository.getQuestions().get(0);

        // then
        assertNotNull(question.getText(), "The question text should not be null");
        assertFalse(question.getAnswers().isEmpty(), "The answer list should not be empty");
        assertTrue(question.getCorrectAnswer() >= 0 && question.getCorrectAnswer() < question.getAnswers().size(),
                "The correct answer index should be within the answer list range");
    }
}