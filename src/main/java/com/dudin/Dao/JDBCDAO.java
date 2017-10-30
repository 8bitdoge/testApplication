package com.dudin.Dao;

import com.dudin.model.Answer;
import com.dudin.model.Question;
import com.dudin.model.TestEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDAO {

    private static final String DB_URL = "jdbc:mysql://localhost/testapplication";

    private static final String USER = "root";
    private static final String PASS = "!@#$%^";

    public TestEntity getTestEntity(String testID) {

        List<Answer> answerList = new ArrayList<>();
        List<Question> questionsList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        TestEntity testEntity = null;
        try {

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

            String sqlTest = "SELECT * FROM test AS t WHERE t.test_id = " + testID;
            String sqlQuestion = "SELECT * FROM question AS q WHERE q.test_id=" + testID;
            String sqlAnswer = "SELECT * FROM answer AS a WHERE a.question_id IN (";

            ResultSet resultSetTest = statement.executeQuery(sqlTest);
            ResultSet resultSetQuestion = statement.executeQuery(sqlQuestion);

            while (resultSetTest.next()) {
                int test_id = resultSetTest.getInt("test_id");
                String testName = resultSetTest.getString("test_name");
                testEntity = new TestEntity(test_id, testName);
            }

            while (resultSetQuestion.next()) {
                int question_id = resultSetQuestion.getInt("question_id");
                String question = resultSetQuestion.getString("question");
                int test_id_fromQuestion = resultSetQuestion.getInt("test_id");
                Question tmpQuestion = new Question(question_id, question, test_id_fromQuestion);
                questionsList.add(tmpQuestion);
            }

            for (int i = 0; i < questionsList.size(); i++) {
                if (i < questionsList.size() - 1) {
                    sqlAnswer += questionsList.get(i).getId() + ", ";
                } else {
                    sqlAnswer += questionsList.get(i).getId() + ")";
                }
            }

            ResultSet resultSetAnswer = statement.executeQuery(sqlAnswer);

            while (resultSetAnswer.next()) {
                int option_id = resultSetAnswer.getInt("option_id");
                String option = resultSetAnswer.getString("option");
                int question_id = resultSetAnswer.getInt("question_id");
                int correctAnswer = resultSetAnswer.getInt("correct_answer");
                boolean correct = false;
                if (correctAnswer == 1) {
                    correct = true;
                }
                Answer answer = new Answer(option_id, option, question_id, correct);
                answerList.add(answer);
            }

            for (Answer answer : answerList) {
                for (Question question : questionsList) {
                    if (answer.getId() == question.getId())
                        question.setAnswerList(answerList);
                }
            }
//            questionsList
            testEntity.setQuestionsList(questionsList);


        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return testEntity;
    }
}
