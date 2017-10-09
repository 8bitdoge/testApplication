package com.dudin.service;

import com.dudin.model.Answer;
import com.dudin.model.Question;
import com.dudin.model.TestEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestEngine {

    public void runTest(TestEntity testEntity) {

        System.out.println("Answer the following questions:");
        System.out.println(testEntity.getTestName());
        for (Question question : testEntity.getQuestionsList()) {
            Map<String, Answer> stringAnswerMap = new HashMap<>();
            System.out.println(question);
            System.out.println("Answer variants:");
            int i = 0;
            for (Answer answer : question.getAnswerList()) {
                System.out.println(++i + ") " + answer);
                stringAnswerMap.putIfAbsent(i + "", answer);
            }
            this.checkInputAndWriteToConsole(question, true, stringAnswerMap);
        }
    }

    private void checkInputAndWriteToConsole(Question question, boolean writeInstruction, Map<String, Answer> strAnswerMap) {

        Scanner scanner = new Scanner(System.in);

        if (writeInstruction) {
            System.out.println("type number of your answer");
        }
        String userTyped = scanner.nextLine();
        if (userTyped.equals("")) {
            System.out.println("incorrect input");
            this.checkInputAndWriteToConsole(question, false, strAnswerMap);
        } else if (!(strAnswerMap.keySet().contains(userTyped))) {
            System.out.println("incorrect input");
            this.checkInputAndWriteToConsole(question, false, strAnswerMap);
        } else if (strAnswerMap.get(userTyped).equals(question.getCorrectAnswer())) {
            System.out.println("correct");
        } else {
            System.out.println("wrong");
        }
    }
}