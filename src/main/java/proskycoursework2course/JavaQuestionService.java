package proskycoursework2course;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
@Service
public class JavaQuestionService implements QuestionService{


    public JavaQuestionService(Set<Question> questions) {

        this.questions = questions;
    }

   private Set<Question> questions = new HashSet<>(Set.of(
            new Question("вопрос 1", "ответ 1"),
            new Question("вопрос 2", "ответ 2"),
            new Question("вопрос 3", "ответ 3"),
            new Question("вопрос 4", "ответ 4")
   ));
    @Override
    public Question add(String question, String answer) {
        var newQuestion = new Question(question, answer);
        questions.add(newQuestion);

        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);

        return question;
    }

    @Override
    public Question remove(Question question) {
        validateCollectionIsNotNull();
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        validateCollectionIsNotNull();

        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        validateCollectionIsNotNull();
        int size = questions.size();
        int item = new Random().nextInt(size);
        int i = 0;
        Question rez = null;
        for (Question element : questions) {
            if (i == item) {
                rez = element;
            }
            i++;
        }
        return rez;
    }

    private void validateCollectionIsNotNull() {
        if (questions.isEmpty()) {
            throw new NullCollectionException();
        }
    }
}
