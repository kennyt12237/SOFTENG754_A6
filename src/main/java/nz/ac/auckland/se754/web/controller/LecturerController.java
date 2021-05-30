package nz.ac.auckland.se754.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.lang.StringBuilder;
import java.util.List;

import nz.ac.auckland.se754.web.service.Question;
import nz.ac.auckland.se754.web.service.QuestionStorage;

@Controller
@SessionAttributes("name")
public class LecturerController {

    Question studentQuestion = new Question("Can you explain interactivity?");
    QuestionStorage questionStorage = new QuestionStorage();

    @RequestMapping(path = "/receiveQuestion", method = RequestMethod.POST)
    public String lecturerReceiveQuestion(ModelMap model) {
        if (studentQuestion == null) {
            studentQuestion = new Question("Can you explain it again?");
        }
        model.put("questionReceivedText", "Anonymous question received!");
        return "lecturerScreen";
    }

    @RequestMapping(path = "/viewQuestion", method = RequestMethod.POST)
    public String lecturerViewQuestion(ModelMap model) {
        if (studentQuestion == null) {
            model.put("errorMessage", "No questions from students");
        } else {
            model.put("questionText", studentQuestion.getAnonymousQuestion());
        }
        return "lecturerScreen";
    }

    @RequestMapping(path = "/markQuestion", method = RequestMethod.POST)
    public String lecturerMarkQuestion(ModelMap model) {
        studentQuestion.markAnswered();
        model.put("questionText", studentQuestion.getAnonymousQuestion());
        model.put("markText", "Marked");
        return "lecturerScreen";
    }

    @RequestMapping(path = "/flagQuestion", method = RequestMethod.POST)
    public String lecturerFlagQuestion(ModelMap model) {
        studentQuestion.setFlagged();
        model.put("questionText", studentQuestion.getAnonymousQuestion());
        model.put("markText", "Flagged");
        return "lecturerScreen";
    }

    @RequestMapping(path = "/deleteQuestion", method = RequestMethod.POST)
    public String lecturerDeleteQuestion(ModelMap model) {
        studentQuestion = null;
        model.put("questionText", "");
        return "lecturerScreen";
    }

    @RequestMapping(path = "/storeQuestion", method = RequestMethod.POST)
    public String lecturerStoreQuestion(ModelMap model) {
        questionStorage.storeQuestion(studentQuestion);
        model.put("questionText", studentQuestion.getAnonymousQuestion());
        model.put("storedText", "Stored");
        return "lecturerScreen";
    }

    @RequestMapping(path = "/viewDatabase", method = RequestMethod.POST)
    public String lecturerViewsDatabase(ModelMap model) {
        List<Question> questions = questionStorage.getAllQuestions();

        StringBuilder stringBuilder = new StringBuilder();
        for (Question q : questions) {
            if (!stringBuilder.isEmpty()) {
                stringBuilder.append(",");
            }
            stringBuilder.append(q.getAnonymousQuestion());
        }

        String dbQuestionsStr = stringBuilder.toString();
        if (dbQuestionsStr.length() == 0) {
            dbQuestionsStr = "No Questions saved";
        }
        model.put("dbQuestionsText", dbQuestionsStr);
        return "lecturerScreen";
    }
}