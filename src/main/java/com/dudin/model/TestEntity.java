package com.dudin.model;

import java.util.List;

public class TestEntity extends BaseEntity {
    private String testName;
    private List<Question> questions;

    public TestEntity(int id) {
        super(id);
    }

    public TestEntity(int id, String testName) {
        super(id);
        this.testName = testName;
    }

    public TestEntity(int id, String testName, List<Question> questions) {
        super(id);
        this.testName = testName;
        this.questions = questions;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public List<Question> getQuestionsList() {
        return questions;
    }

    public void setQuestionsList(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
