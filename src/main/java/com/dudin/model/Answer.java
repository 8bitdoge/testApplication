package com.dudin.model;

import java.util.Objects;

public class Answer extends BaseEntity {
    private String answer;
    private int question_id;
    private int answerID;
    private boolean correctAnswer;

    public Answer(int id, String answer, int question_id, int answerID, boolean correctAnswer) {
        super(id);
        this.answer = answer;
        this.question_id = question_id;
        this.answerID = answerID;
        this.correctAnswer = correctAnswer;
    }


    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public Answer(int id, String answer, int question_id, boolean correctAnswer) {
        super(id);
        this.answer = answer;
        this.question_id = question_id;
        this.correctAnswer = correctAnswer;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public Answer(int id, String answer, int question_id) {
        super(id);
        this.answer = answer;
        this.question_id = question_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public Answer(int id) {
        super(id);
    }

    public Answer(int id, String answer) {
        super(id);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Answer answer1 = (Answer) o;
        return Objects.equals(answer, answer1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer);
    }

    @Override
    public String toString() {
        return answer;
    }

    public boolean isCorrect(boolean correctAnswer) {
        return correctAnswer;
    }
}
