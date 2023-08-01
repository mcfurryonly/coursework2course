package proskycoursework2course.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import proskycoursework2course.Question;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExaminerServiceImplTest {


     ExaminerServiceImpl examinerService;
    @Mock
     JavaQuestionService jcs;


    @BeforeEach
    void setUp() {
        jcs = new JavaQuestionService();
        examinerService = new ExaminerServiceImpl(jcs);

    }

    @Test
    void getQuestions() {
        List<String> expectedQuestionList = examinerService.getQuestions(0);

        for (int i = 0; i < expectedQuestionList.size(); i++) {
            for (Question element : jcs.getAll()) {
                if (expectedQuestionList.get(i).equals(element.getQuestion())) {
                    String expectedQuestion = element.getQuestion();
                    String actualQuestion = expectedQuestionList.get(i);
                    assertEquals(expectedQuestion, actualQuestion);
                }
            }
        }
        Set<String> expectedQuestionSet = new HashSet<>(expectedQuestionList);
        assertEquals(expectedQuestionList.size(), expectedQuestionSet.size());
    }
}