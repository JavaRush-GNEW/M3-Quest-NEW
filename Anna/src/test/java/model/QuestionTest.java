package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionTest {
    @Test
    void givenValidData_whenCreateQuestion_thenShouldHaveCorrectProperties() {
        // given
        ArrayList<String> answers = new ArrayList<>();
        answers.add("Option 1");
        answers.add("Option 2");
        answers.add("Option 3");

        // when
        Question question = Question.builder()
                .text("Test question?")
                .answers(answers)
                .correctAnswer(1)
                .build();

        // then
        assertEquals("Test question?", question.getText(), "The question text should match");
        assertEquals(3, question.getAnswers().size(), "The answer list should contain 3 options");
        assertEquals(1, question.getCorrectAnswer(), "The correct answer index should be 1");
    }

    @Test
    void givenQuestionWithThreeAnswers_whenGetCorrectAnswer_thenIndexShouldBeWithinBounds() {
        // given
        ArrayList<String> answers = new ArrayList<>(List.of("A", "B", "C"));

        // when
        Question question = Question.builder()
                .text("What is the correct answer?")
                .answers(answers)
                .correctAnswer(2)
                .build();

        // then
        assertTrue(question.getCorrectAnswer() >= 0 && question.getCorrectAnswer() < question.getAnswers().size(),
                "The correct answer index should be within the bounds of the answer list");
    }
}