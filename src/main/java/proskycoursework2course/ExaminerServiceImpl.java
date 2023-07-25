package proskycoursework2course;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    private List<String> questionsList = new ArrayList<>();
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public List<String> getQuestions(int amount) {

        validateQuantityQuestions(amount);
        int originalQuestionsCounter = 0;
        while (originalQuestionsCounter <= amount) {
            String question = questionService.getRandomQuestion().getQuestion();
            if (isQuestionUnique(question)) {
                questionsList.add(questionService.getRandomQuestion().getQuestion());
                originalQuestionsCounter++;
            }
        }
        return questionsList;
    }

    private boolean isQuestionUnique(String question) {
        for (String element : questionsList) {
            if (question.equals(element)) {
                return false;
            }
        }
        return true;
    }


    private void validateQuantityQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new AmountOutOfCollectionBoundException();
        }
    }
}
