package nz.ac.auckland.se754.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import nz.ac.auckland.se754.web.service.Question;

@Controller
@SessionAttributes("name")
public class QuestionController {

    Question studentQuestion;

    @PostMapping(path = "/lectureQuestion")
    public String studentAskQuestion(ModelMap model, @RequestParam(required = false) String question, @RequestParam(required = false) Boolean urgent) {

        System.out.println(question == null);
        boolean isQuestion = (question == null || question.indexOf('?') < 0) ? false : true;
        boolean markedUrgent = urgent == null ? false : urgent;
        if (!isQuestion) {
            model.put("errorMessage", "Not a question!");
            return "lecture";
        }

        studentQuestion = new Question(question);
        if (markedUrgent) {
            studentQuestion.markAsUrgent();
        }

        model.put("questionText", studentQuestion.getQuestionWithUrgent());
        model.put("upvote", studentQuestion.getUpvotes());
        return "lecture";
    }

    @RequestMapping(path = "/lectureUpvoteQuestion", method = RequestMethod.POST)
    public String studentUpvoteQuestion(ModelMap model) {
        studentQuestion.upvoteQuestion();
        model.put("questionText", studentQuestion.getQuestionWithUrgent());
        model.put("upvote", studentQuestion.getUpvotes());
        return "lecture";
    }
}