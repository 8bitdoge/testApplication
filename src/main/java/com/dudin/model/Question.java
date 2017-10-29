package com.dudin.model;

import java.util.List;

public class Question extends BaseEntity {

    private int questionID;
    private List<Answer> answerList;
    private int testID;
    private String question;

    public Question(int id, int questionID, List<Answer> answerList, int testID, String question) {
        super(id);
        this.questionID = questionID;
        this.answerList = answerList;
        this.testID = testID;
        this.question = question;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }


    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public Question(int id, String question, int testID) {
        super(id);
        this.question = question;
        this.testID = testID;
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

    public Question(int id, String question, List<Answer> answerList, int test_id) {
        super(id);
        this.question = question;
        this.answerList = answerList;
        this.testID = test_id;
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




    @Override
    public String toString() {
        return question;
    }
}
