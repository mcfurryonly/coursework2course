package proskycoursework2course.service;

import org.springframework.stereotype.Service;
import proskycoursework2course.exceptions.AmountOutOfCollectionBoundException;
import proskycoursework2course.interfaces.QuestionService;
import proskycoursework2course.interfaces.ExaminerService;

import java.util.ArrayList;
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
        questionsList.clear();
        validateQuantityQuestions(amount);
        int originalQuestionsCounter = 1;
        while (originalQuestionsCounter <= amount) {
            String question = questionService.getRandomQuestion().getQuestion();
            if (questionService.equals(question)) {
                questionsList.add(questionService.getRandomQuestion().getQuestion());
                originalQuestionsCounter++;
            }
        }
        return questionsList;
    }

    private boolean isQuestionUnique(String question) {
        for (String element : questionsList) {
            if (element.equals(question)) {
                return false;
            }
        }
        return true;
    }


    private void validateQuantityQuestions(int amount) {
        if (amount < questionService.getAll().size() || amount > 0) {
            throw new AmountOutOfCollectionBoundException();
        }
    }
}
