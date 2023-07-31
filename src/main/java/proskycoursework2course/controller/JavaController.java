package proskycoursework2course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import proskycoursework2course.Question;
import proskycoursework2course.interfaces.QuestionService;

@RestController
@RequestMapping("/exam/java")

public class JavaController {

   private QuestionService service;

    public JavaController(QuestionService service) {

        this.service = service;
    }

    @GetMapping("/add")

    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        service.add(question, answer);

        return new Question(question, answer);
    }

    @GetMapping("/get")
    public String getQuestions() {
        return service.getAll().toString();


    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,@RequestParam("answer") String answer) {
        var obj = new Question(question, answer);
        service.remove(obj);
        return obj;
    }
}
