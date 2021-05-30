package nz.ac.auckland.se754.web.service;

import java.util.ArrayList;
import java.util.List;

public class QuestionStorage {

    private List<Question> questions;

    public QuestionStorage() {
        questions = new ArrayList<Question>();
    }

    public void storeQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getAllQuestions() {
        return questions;
    }
}