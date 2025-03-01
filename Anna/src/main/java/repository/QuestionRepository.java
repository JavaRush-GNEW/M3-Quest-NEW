package repository;

import model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {
    private static QuestionRepository INSTANCE;
    private ArrayList<Question> questions;

    private QuestionRepository() {
        questions = new ArrayList<>();

        questions.add(Question.builder()
                .text("Грім роздирає небо, і ти стоїш перед Зевсом. Він каже: “Смертний, щоб отримати силу блискавки, ти маєш знати, що найважливіше для правителя. Що ти обереш?”")
                .answers(new ArrayList<>(List.of("Справедливість", "Сила", "Хитрість", "Помста")))
                .correctAnswer(0)
                .build());

        questions.add(Question.builder()
                .text("Хвилі розступаються, і перед тобою постає Посейдон. “Лише той, хто розуміє природу океану, може керувати його силою. Що є головною сутністю моря?”")
                .answers(new ArrayList<>(List.of("Гнів", "Спокій", "Непередбачуваність", "Глибина")))
                .correctAnswer(2)
                .build());

        questions.add(Question.builder()
                .text("Афіна спостерігає за тобою пильним поглядом. “Перемогу здобувають не лише мечем, а й розумом. Що важливіше у битві?”")
                .answers(new ArrayList<>(List.of("Сміливість", "Стратегія", "Швидкість", "Честь")))
                .correctAnswer(1)
                .build());

        questions.add(Question.builder()
                .text("Ти спускаєшся в Підземний світ, і перед тобою Аїд. “Смертний, чи ти розумієш істину життя? Що найбільше лякає людей?”")
                .answers(new ArrayList<>(List.of("Біль", "Забуття", "Темрява", "Самотність")))
                .correctAnswer(1)
                .build());

        questions.add(Question.builder()
                .text("Арес грізно дивиться на тебе. “Лише найсильніший воїн заслуговує силу богів! Що є справжньою сутністю війни?”")
                .answers(new ArrayList<>(List.of("Руйнування", "Слава", "Виживання", "Влада")))
                .correctAnswer(2)
                .build());
    }

    public static QuestionRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuestionRepository();
        }
        return INSTANCE;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
