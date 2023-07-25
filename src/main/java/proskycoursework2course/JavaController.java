package proskycoursework2course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/java")

public class JavaController {

   private QuestionService service;

    public JavaController(QuestionService service) {

        this.service = service;
    }

    @GetMapping("/")

    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        service.add(question, answer);

        return new Question(question, answer);
    }

    @GetMapping("/")
    public String getQuestions() {
        return service.getAll().toString();


    }

    @GetMapping("/")
    public Question removeQuestion(@RequestParam("question") String question,@RequestParam("answer") String answer) {
        var obj = new Question(question, answer);
        service.remove(obj);
        return obj;
    }
}
