package repository;

import lombok.Data;
import model.Question;
import model.Scene;

import java.util.Arrays;

@Data
public class QuizRepository {
    private static QuizRepository INSTANCE;

    // Локації квесту
    private Scene scene1 = new Scene("Біля входу до маєтку");
    private Scene scene2 = new Scene("Велика зала");
    private Scene scene3 = new Scene("Стара бібліотека");
    private Scene scene4 = new Scene("Темний підвал");
    private Scene scene5 = new Scene("Залізні сходи");
    private Scene scene6 = new Scene("Музична кімната");
    private Scene scene7 = new Scene("Секретний прохід");
    private Scene scene8 = new Scene("Горище");
    private Scene scene9 = new Scene("Старий сад");
    private Scene scene10 = new Scene("Покинута каплиця");

    // Фінальні сцени
    private Scene sceneEnd1 = new Scene("Перемога! Ви розкрили таємницю маєтку Лисенка і знайшли скарб.").setFinal();
    private Scene sceneEnd2 = new Scene("Поразка... Ви зачепили старий механізм, і стеля обвалилася.").setFinal();
    private Scene sceneEnd3 = new Scene("Нейтральна кінцівка. Ви залишилися в маєтку, зачаровані його музикою.").setFinal();

    private QuizRepository() {
        scene1.setQuestions(
                Arrays.asList(
                        new Question("Зайти в маєток", scene2),
                        new Question("Обійти будівлю навколо", scene9)
                )
        );

        scene2.setQuestions(
                Arrays.asList(
                        new Question("Піти до бібліотеки", scene3),
                        new Question("Спуститися в підвал", scene4),
                        new Question("Дослідити сходи нагору", scene5)
                )
        );

        scene3.setQuestions(
                Arrays.asList(
                        new Question("Відкрити стару книгу", scene7),
                        new Question("Оглянути нотні записи", scene6)
                )
        );

        scene4.setQuestions(
                Arrays.asList(
                        new Question("Шукати вихід", sceneEnd2), // Поразка
                        new Question("Піднятися назад", scene2)
                )
        );

        scene5.setQuestions(
                Arrays.asList(
                        new Question("Продовжити підніматися нагору", scene8),
                        new Question("Спуститися назад у залу", scene2)
                )
        );

        scene6.setQuestions(
                Arrays.asList(
                        new Question("Грати на піаніно", sceneEnd3), // Нейтральний фінал
                        new Question("Шукати прихований механізм", scene7)
                )
        );

        scene7.setQuestions(
                Arrays.asList(
                        new Question("Відкрити потайний хід", scene10),
                        new Question("Повернутися в бібліотеку", scene3)
                )
        );

        scene8.setQuestions(
                Arrays.asList(
                        new Question("Відчинити стару скриню", sceneEnd1), // Перемога
                        new Question("Спуститися вниз", scene5)
                )
        );

        scene9.setQuestions(
                Arrays.asList(
                        new Question("Дослідити старий фонтан", sceneEnd3), // Нейтральний фінал
                        new Question("Повернутися до входу в маєток", scene1)
                )
        );

        scene10.setQuestions(
                Arrays.asList(
                        new Question("Оглянути вівтар", sceneEnd1), // Перемога
                        new Question("Залишити каплицю і повернутися", scene7)
                )
        );
    }

    public static QuizRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuizRepository();
        }
        return INSTANCE;
    }
}
