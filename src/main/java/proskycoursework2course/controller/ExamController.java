package proskycoursework2course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proskycoursework2course.interfaces.ExaminerService;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/get/{amount}")
    public String getQuestions(@PathVariable("amount") int amount){
        return examinerService.getQuestions(amount).toString();
    }
}
