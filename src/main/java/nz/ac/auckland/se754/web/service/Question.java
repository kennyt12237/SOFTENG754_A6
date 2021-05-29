package nz.ac.auckland.se754.web.service;

public class Question {

    private String question;
    private boolean isAnonymous;
    private boolean isFlagged;
    private boolean isUrgent;
    private boolean isAnswered;
    private int upvotes;

    public Question(String question) {
        this.question = question;
        this.isAnonymous = true;
        this.isFlagged = false;
        this.isUrgent = false;
        this.isAnswered = false;
        this.upvotes = 0;
    }

    public boolean questionIsAnonymous() {
        return isAnonymous;
    }

    public void setQuestionToAnonymous() {
        isAnonymous = true;
    }

    public void setFlagged() {
        isFlagged = true;
    }

    public boolean isQuestionFlagged() {
        return isFlagged;
    }

    public void markAnswered() {
        isAnswered = true;
    }

    public boolean isQuestionAnswered() {
        return isAnswered;
    }

    public void markAsUrgent() {
        isUrgent = true;
    }

    public boolean isQuestionUrgent() {
        return isUrgent;
    }

    public void upvoteQuestion() {
        upvotes++;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public String getQuestionWithUrgent() {
        String question = "";
        if (isUrgent) {
            question = question + "URGENT: ";
        }

        question = question + this.question;
        return question;
    }
}