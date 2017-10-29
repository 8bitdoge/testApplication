package com.dudin.service;

import com.dudin.model.Answer;
import com.dudin.model.Question;
import com.dudin.model.TestEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestEngine {

    private int count;
    private float sumOfQuestions;

    public void runTest(TestEntity testEntity) {

        System.out.println("Answer the following questions:");
        System.out.println(testEntity.getTestName());
        sumOfQuestions = testEntity.getQuestionsList().size();
        for (Question question : testEntity.getQuestionsList()) {
            Map<String, Answer> stringAnswerMap = new HashMap<>();
            System.out.println(question);
            System.out.println("Answer variants:");
            int i = 0;
            for (Answer answer : question.getAnswerList()) {
                if (answer.getQuestion_id() == question.getId()) {
                    System.out.println(++i + ") " + answer);
                    stringAnswerMap.putIfAbsent(i + "", answer);
                }
            }

            this.checkInputAndWriteToConsole(question, true, stringAnswerMap);
        }
        System.out.println("number of right answers is " + count);
        System.out.println("It is " + String.format("%.0f%%", count / sumOfQuestions * 100) + " of test");
    }

    private void checkInputAndWriteToConsole(Question question, boolean writeInstruction, Map<String, Answer> strAnswerMap) {
        Scanner scanner = new Scanner(System.in);

        if (writeInstruction) {
            System.out.println("type number of your answer");
        }
        String userTyped = scanner.nextLine();

        if (userTyped.equals("")) {
            System.out.println("incorrect input, try again");
            this.checkInputAndWriteToConsole(question, false, strAnswerMap);
        } else if (!(strAnswerMap.keySet().contains(userTyped))) {
            System.out.println("incorrect input, try again");
            this.checkInputAndWriteToConsole(question, false, strAnswerMap);
        } else for (int i = 0; i < question.getAnswerList().size(); i++) {
            if (strAnswerMap.get(userTyped).equals(question.getAnswerList().get(i))) {
                if (question.getAnswerList().get(i).isCorrect(question.getAnswerList().get(i).getCorrectAnswer())) {
                    System.out.println("correct");
                    count++;
                } else {
                    System.out.println("wrong");
                }
            }
        }
    }
}