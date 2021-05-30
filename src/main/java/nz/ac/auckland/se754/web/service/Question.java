package nz.ac.auckland.se754.web.service;

public class Question {

    private String question;
    private boolean isUrgent;
    private int upvotes;

    public Question(String question) {
        this.question = question;
        this.isUrgent = false;
        this.upvotes = 0;
    }

    public void markAsUrgent() {
        isUrgent = true;
    }

    public void upvoteQuestion() {
        upvotes++;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public String getQuestionWithUrgent() {
        String question = "Anonymous: ";
        question = question + this.question;

        if (isUrgent) {
            question = question + " URGENT!!!";
        }
        return question;
    }

    public String getAnonymousQuestion() {
        return "Anonymous: " + this.question;
    }
}