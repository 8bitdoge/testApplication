package com.dudin.model;

import java.util.List;

public class Question extends BaseEntity {
    private String question;
    private List<Answer> answerList;
    private Answer correctAnswer;

    public Question(int id) {
        super(id);
    }

    public Question(int id, String question) {
        super(id);
        this.question = question;
    }

    public Question(int id, String question, List<Answer> answerList) {
        super(id);
        this.question = question;
        this.answerList = answerList;
    }

    public Question(int id, String question, List<Answer> answerList, Answer correctAnswer) {
        super(id);
        this.question = question;
        this.answerList = answerList;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return question;
    }
}
